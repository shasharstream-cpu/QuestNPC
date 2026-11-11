package ua.questnpc;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.papermc.paper.datacomponent.item.ResolvableProfile;
import io.papermc.paper.dialog.Dialog;
import io.papermc.paper.registry.data.dialog.ActionButton;
import io.papermc.paper.registry.data.dialog.DialogBase;
import io.papermc.paper.registry.data.dialog.action.DialogAction;
import io.papermc.paper.registry.data.dialog.body.DialogBody;
import io.papermc.paper.registry.data.dialog.input.DialogInput;
import io.papermc.paper.registry.data.dialog.input.TextDialogInput;
import io.papermc.paper.registry.data.dialog.type.DialogType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickCallback;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mannequin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * QuestNPC v0.3: NPC (Mannequin) зі скінами, діалоги-дерева з діями та умовами,
 * торгівля, багатоетапні квести та журнал.
 */
public final class QuestNPC extends JavaPlugin implements Listener, TabExecutor {

    private static final LegacyComponentSerializer LEGACY = LegacyComponentSerializer.legacyAmpersand();
    private static final ClickCallback.Options CLICK_OPTS =
            ClickCallback.Options.builder().uses(1).lifetime(Duration.ofMinutes(30)).build();

    /** Варіантів відповіді в одному вузлі діалогу. */
    private static final int MAX_CHOICES = 5;
    /** Угод в одного NPC (по 3 слоти на угоду в скрині 54). */
    private static final int MAX_TRADES = 18;

    // ================================================================== model

    /** Вузол діалогу: репліка NPC і варіанти відповіді. */
    static final class Node {
        String text;
        final List<Choice> choices = new ArrayList<>();
        final Node parent;
        String fromLabel;

        Node(String text, Node parent, String fromLabel) {
            this.text = text;
            this.parent = parent;
            this.fromLabel = fromLabel;
        }
    }

    /** Кнопка діалогу: текст, дія (trade/close/quest:id/turnin:id), умова показу та наступний вузол. */
    static final class Choice {
        String label;
        String action;
        String cond;
        final Node next;

        Choice(String label, String action, String cond, Node next) {
            this.label = label;
            this.action = action;
            this.cond = cond;
            this.next = next;
        }
    }

    static final class Trade {
        final ItemStack price1;
        final ItemStack price2; // може бути null
        final ItemStack result;

        Trade(ItemStack price1, ItemStack price2, ItemStack result) {
            this.price1 = price1;
            this.price2 = price2;
            this.result = result;
        }
    }

    static final class Npc {
        final int id;
        String name = "NPC";
        String skin = "";
        Node root = new Node("Привіт, {player}!", null, "");
        final List<Trade> trades = new ArrayList<>();
        Location loc;
        UUID entity;

        Npc(int id) {
            this.id = id;
        }
    }

    /** Етап квесту. type: reach | kill | deliver | talk. */
    static final class Stage {
        String type;
        String text = "";
        String world = "";
        double x, y, z;
        double radius = 5;
        double height = -1;
        EntityType entity;
        int amount = 1;
        Material material;
        int npc = -1;
    }

    static final class Quest {
        String id;
        String name;
        String description = "";
        boolean repeatable;
        boolean turnIn;
        final List<Stage> stages = new ArrayList<>();
        int xp;
        List<String> items = new ArrayList<>();
        List<String> commands = new ArrayList<>();
    }

    /** Прогрес гравця в квесті. status: ACTIVE | READY | DONE. */
    static final class QState {
        String status = "ACTIVE";
        int stage = 0;
        int count = 0;
    }

    /** Власник вікна-скрині, де адмін розкладає угоди. */
    static final class TradeEditor implements InventoryHolder {
        final Npc npc;
        Inventory inv;

        TradeEditor(Npc npc) {
            this.npc = npc;
        }

        @Override
        public Inventory getInventory() {
            return inv;
        }
    }

    // ================================================================== state

    private NamespacedKey wandKey;
    private NamespacedKey npcKey;
    private File dataFile;
    private File progressFile;
    private File questsFile;

    private final Map<Integer, Npc> npcs = new LinkedHashMap<>();
    private int nextId = 1;
    private final Map<UUID, Long> lastUse = new HashMap<>();

    private final Map<String, Quest> quests = new LinkedHashMap<>();
    private final Map<UUID, Map<String, QState>> progress = new HashMap<>();
    private boolean progressDirty = false;

    // ================================================================== lifecycle

    @Override
    public void onEnable() {
        wandKey = new NamespacedKey(this, "wand");
        npcKey = new NamespacedKey(this, "npc_id");
        getDataFolder().mkdirs();
        dataFile = new File(getDataFolder(), "npcs.yml");
        progressFile = new File(getDataFolder(), "progress.yml");
        questsFile = new File(getDataFolder(), "quests.yml");
        if (!questsFile.exists()) saveResource("quests.yml", false);

        load();
        loadQuests();
        loadProgress();
        getServer().getPluginManager().registerEvents(this, this);

        PluginCommand cmd = getCommand("mizkoprav");
        if (cmd != null) {
            cmd.setExecutor(this);
            cmd.setTabCompleter(this);
        }
        PluginCommand qcmd = getCommand("quests");
        if (qcmd != null) qcmd.setExecutor(this);

        // перевірка зон для етапів "дійти до місця" раз на секунду
        getServer().getScheduler().runTaskTimer(this, this::checkReach, 40L, 20L);
        // лічильники вбивств зберігаємо пачкою
        getServer().getScheduler().runTaskTimer(this, () -> {
            if (progressDirty) saveProgress();
        }, 100L, 100L);
    }

    @Override
    public void onDisable() {
        save();
        saveProgress();
    }

    // ================================================================== helpers

    private Component text(String legacy) {
        return LEGACY.deserialize(legacy).decoration(TextDecoration.ITALIC, false);
    }

    private Component fmt(String raw, Player p) {
        return LEGACY.deserialize(raw.replace("{player}", p.getName()));
    }

    private static String clean(String s, String fallback) {
        if (s == null || s.isBlank()) return fallback;
        return s.trim();
    }

    private void sync(Runnable r) {
        if (Bukkit.isPrimaryThread()) r.run();
        else Bukkit.getScheduler().runTask(this, r);
    }

    private ActionButton btn(String label, Consumer<Function<String, String>> cb) {
        DialogAction action = cb == null
                ? null
                : DialogAction.customClick((view, audience) -> cb.accept(view::getText), CLICK_OPTS);
        return ActionButton.create(LEGACY.deserialize(label), null, 200, action);
    }

    private Dialog dialog(String title, List<DialogBody> body, List<DialogInput> inputs, DialogType type) {
        return Dialog.create(factory -> factory.empty()
                .base(DialogBase.builder(LEGACY.deserialize(title))
                        .canCloseWithEscape(true)
                        .body(body)
                        .inputs(inputs)
                        .build())
                .type(type));
    }

    private DialogBody para(String legacy) {
        return DialogBody.plainMessage(LEGACY.deserialize(legacy));
    }

    private DialogInput line(String key, String label, String initial, int maxLength) {
        return DialogInput.text(key, Component.text(label))
                .width(300)
                .initial(initial == null ? "" : initial)
                .maxLength(maxLength)
                .build();
    }

    private DialogInput block(String key, String label, String initial, int maxLength) {
        return DialogInput.text(key, Component.text(label))
                .width(300)
                .initial(initial == null ? "" : initial)
                .maxLength(maxLength)
                .multiline(TextDialogInput.MultilineOptions.create(6, 90))
                .build();
    }

    // ================================================================== wand

    private ItemStack createWand() {
        ItemStack item = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(text("&dМізкоправ"));
        meta.lore(List.of(
                text("&7ПКМ по блоку - створити NPC."),
                text("&7ПКМ по NPC - налаштувати.")));
        meta.getPersistentDataContainer().set(wandKey, PersistentDataType.BYTE, (byte) 1);
        item.setItemMeta(meta);
        return item;
    }

    private boolean isWand(ItemStack item) {
        return item != null && item.hasItemMeta()
                && item.getItemMeta().getPersistentDataContainer().has(wandKey, PersistentDataType.BYTE);
    }

    @EventHandler
    public void onUseWand(PlayerInteractEvent e) {
        if (e.getHand() != EquipmentSlot.HAND || !isWand(e.getItem())) return;
        Action a = e.getAction();
        if (a != Action.RIGHT_CLICK_BLOCK && a != Action.RIGHT_CLICK_AIR) return;

        e.setCancelled(true);
        Player p = e.getPlayer();
        if (!p.hasPermission("questnpc.admin")) {
            p.sendMessage(text("&cНемає прав."));
            return;
        }
        if (a == Action.RIGHT_CLICK_AIR) {
            p.sendMessage(text("&7ПКМ по блоку - створити NPC, ПКМ по NPC - налаштувати."));
            return;
        }
        Block clicked = e.getClickedBlock();
        if (clicked == null) return;

        Location loc = clicked.getRelative(e.getBlockFace()).getLocation().add(0.5, 0, 0.5);
        loc.setYaw(p.getLocation().getYaw() + 180f);
        loc.setPitch(0f);
        if (tooFast(p)) return;
        openCreate(p, loc);
    }

    // ================================================================== NPC entity

    private Integer npcIdOf(Entity entity) {
        if (!(entity instanceof Mannequin)) return null;
        return entity.getPersistentDataContainer().get(npcKey, PersistentDataType.INTEGER);
    }

    private void setup(Mannequin m, Npc n) {
        m.getPersistentDataContainer().set(npcKey, PersistentDataType.INTEGER, n.id);
        m.customName(LEGACY.deserialize(n.name));
        m.setCustomNameVisible(true);
        m.setDescription(null);
        m.setImmovable(true);
        m.setInvulnerable(true);
        m.setSilent(true);
        m.setPersistent(true);
        m.setRemoveWhenFarAway(false);
    }

    private Mannequin entityOf(Npc n) {
        if (n.entity == null || n.loc == null || n.loc.getWorld() == null) return null;
        n.loc.getWorld().getChunkAt(n.loc).load();
        Entity e = n.loc.getWorld().getEntity(n.entity);
        return e instanceof Mannequin m ? m : null;
    }

    private Npc createNpc(String name, String skin, Location loc) {
        Npc n = new Npc(nextId++);
        n.name = name;
        n.skin = skin;
        n.loc = loc.clone();
        n.root.choices.add(new Choice("Хто ти?", "", "",
                new Node("Я новий NPC. Мене можна налаштувати Мізкоправом.", n.root, "Хто ти?")));

        Mannequin m = loc.getWorld().spawn(loc, Mannequin.class, mq -> setup(mq, n));
        n.entity = m.getUniqueId();
        npcs.put(n.id, n);
        save();
        applySkin(n);
        return n;
    }

    private void applySkin(Npc n) {
        if (n.skin == null || n.skin.isBlank()) return;
        PlayerProfile profile = Bukkit.createProfile(n.skin);
        profile.update().thenAccept(resolved -> sync(() -> {
            Mannequin m = entityOf(n);
            if (m != null && resolved != null) m.setProfile(ResolvableProfile.resolvableProfile(resolved));
        })).exceptionally(ex -> {
            getLogger().warning("Не вдалось завантажити скін '" + n.skin + "': " + ex.getMessage());
            return null;
        });
    }

    private void removeNpc(Npc n) {
        Mannequin m = entityOf(n);
        if (m != null) m.remove();
        npcs.remove(n.id);
        save();
    }

    // ================================================================== talking

    private boolean tooFast(Player p) {
        long now = System.currentTimeMillis();
        Long last = lastUse.get(p.getUniqueId());
        if (last != null && now - last < 300) return true;
        lastUse.put(p.getUniqueId(), now);
        return false;
    }

    @EventHandler
    public void onInteractNpc(PlayerInteractEntityEvent e) {
        Integer id = npcIdOf(e.getRightClicked());
        if (id == null) return;
        e.setCancelled(true);
        if (e.getHand() != EquipmentSlot.HAND) return;

        Npc n = npcs.get(id);
        Player p = e.getPlayer();
        if (n == null || tooFast(p)) return;

        if (isWand(p.getInventory().getItemInMainHand())) {
            if (p.hasPermission("questnpc.admin")) openSettings(p, n);
        } else {
            questsOnTalk(p, n.id); // етапи "поговорити" та "принести"
            openNode(p, n, n.root);
        }
    }

    private void openNode(Player p, Npc n, Node node) {
        List<ActionButton> buttons = new ArrayList<>();
        for (Choice c : node.choices) {
            if (!condOk(p, c.cond)) continue;
            buttons.add(btn("&f" + c.label, v -> sync(() -> runChoice(p, n, node, c))));
        }
        if (node.parent != null) {
            Node parent = node.parent;
            buttons.add(btn("&e< Назад", v -> sync(() -> openNode(p, n, parent))));
        }
        DialogType type = buttons.isEmpty()
                ? DialogType.notice(btn("&7Закрити", null))
                : DialogType.multiAction(buttons, btn("&7Закрити", null), 1);

        p.showDialog(dialog(n.name, List.of(DialogBody.plainMessage(fmt(node.text, p))), List.of(), type));
    }

    /** Виконує дію кнопки. Порожня дія просто веде до наступної репліки. */
    private void runChoice(Player p, Npc n, Node node, Choice c) {
        String a = c.action == null ? "" : c.action.trim().toLowerCase(Locale.ROOT);
        if (a.isEmpty()) {
            openNode(p, n, c.next);
        } else if (a.equals("close")) {
            // вікно просто закривається
        } else if (a.equals("trade")) {
            openTrade(p, n);
        } else if (a.startsWith("quest:")) {
            if (startQuest(p, a.substring(6).trim())) openNode(p, n, c.next);
            else openNode(p, n, node);
        } else if (a.startsWith("turnin:")) {
            if (turnIn(p, a.substring(7).trim())) openNode(p, n, c.next);
            else openNode(p, n, node);
        } else {
            openNode(p, n, c.next);
        }
    }

    /** Умови (через кому): new:id, active:id, ready:id, done:id; "!" перед умовою означає "навпаки". */
    private boolean condOk(Player p, String cond) {
        if (cond == null || cond.isBlank()) return true;
        for (String part : cond.split(",")) {
            String t = part.trim().toLowerCase(Locale.ROOT);
            if (t.isEmpty()) continue;
            boolean negate = t.startsWith("!");
            if (negate) t = t.substring(1);
            int i = t.indexOf(':');
            if (i < 0) continue;
            boolean ok = questMatches(p, t.substring(0, i).trim(), t.substring(i + 1).trim());
            if (ok == negate) return false;
        }
        return true;
    }

    private boolean questMatches(Player p, String kind, String qid) {
        Quest q = quests.get(qid);
        QState st = stateOf(p, qid);
        return switch (kind) {
            case "new" -> q != null && (st == null || ("DONE".equals(st.status) && q.repeatable));
            case "active" -> st != null && "ACTIVE".equals(st.status);
            case "ready" -> st != null && "READY".equals(st.status);
            case "done" -> st != null && "DONE".equals(st.status);
            default -> false;
        };
    }

    // ================================================================== editing (Мізкоправ)

    private void openCreate(Player p, Location loc) {
        DialogType type = DialogType.confirmation(
                btn("&aСтворити", v -> sync(() -> {
                    Npc n = createNpc(clean(v.apply("name"), "NPC"), clean(v.apply("skin"), ""), loc);
                    p.sendMessage(text("&aNPC #" + n.id + " створено. ПКМ по ньому з Мізкоправом - налаштування."));
                })),
                btn("&cСкасувати", null));

        p.showDialog(dialog("&5Створення NPC",
                List.of(para("NPC з'явиться на вибраному місці. Скін береться за ніком гравця (потрібен онлайн-режим сервера).")),
                List.of(line("name", "Ім'я NPC (можна з &-кольорами)", "Новий NPC", 32),
                        line("skin", "Скін: нік гравця", p.getName(), 16)),
                type));
    }

    private void openSettings(Player p, Npc n) {
        List<ActionButton> buttons = List.of(
                btn("Ім'я та скін", v -> sync(() -> openIdentity(p, n))),
                btn("Діалог", v -> sync(() -> openNodeEditor(p, n, n.root))),
                btn("Угоди (торгівля): " + n.trades.size(), v -> sync(() -> openTradeEditor(p, n))),
                btn("Перемістити до мене", v -> sync(() -> {
                    Mannequin m = entityOf(n);
                    if (m != null) {
                        Location l = p.getLocation();
                        m.teleport(l);
                        n.loc = l.clone();
                        save();
                        p.sendMessage(text("&aNPC переміщено."));
                    } else {
                        p.sendMessage(text("&cСутність NPC не знайдено (можливо, її вбили). Видали й створи заново."));
                    }
                    openSettings(p, n);
                })),
                btn("&cВидалити NPC", v -> sync(() -> openDelete(p, n))));

        p.showDialog(dialog("&5NPC #" + n.id + ": " + n.name,
                List.of(para("Що змінити?")), List.of(),
                DialogType.multiAction(buttons, btn("&7Закрити", null), 1)));
    }

    private void openIdentity(Player p, Npc n) {
        DialogType type = DialogType.confirmation(
                btn("&aЗберегти", v -> sync(() -> {
                    n.name = clean(v.apply("name"), n.name);
                    String newSkin = clean(v.apply("skin"), "");
                    boolean skinChanged = !newSkin.equals(n.skin);
                    n.skin = newSkin;
                    Mannequin m = entityOf(n);
                    if (m != null) m.customName(LEGACY.deserialize(n.name));
                    if (skinChanged) applySkin(n);
                    save();
                    p.sendMessage(text("&aЗбережено."));
                    openSettings(p, n);
                })),
                btn("&7Назад", v -> sync(() -> openSettings(p, n))));

        p.showDialog(dialog("&5Ім'я та скін",
                List.of(para("Скін береться за ніком гравця (потрібен онлайн-режим сервера).")),
                List.of(line("name", "Ім'я NPC", n.name, 32),
                        line("skin", "Скін: нік гравця", n.skin, 16)),
                type));
    }

    /** Шлях від кореня до вузла, наприклад "Привітання > Хто ти? > Розкажи більше". */
    private String path(Node node) {
        List<String> parts = new ArrayList<>();
        for (Node x = node; x != null; x = x.parent) {
            parts.add(x.parent == null ? "Привітання" : x.fromLabel);
        }
        Collections.reverse(parts);
        return String.join(" > ", parts);
    }

    /** Редактор одного вузла діалогу: репліка, кнопки, їхні дії та умови, вхід у гілки. */
    private void openNodeEditor(Player p, Npc n, Node node) {
        List<Choice> old = new ArrayList<>(node.choices);

        List<DialogInput> inputs = new ArrayList<>();
        inputs.add(block("text", node.parent == null ? "Привітання (перша репліка NPC)" : "Що каже NPC",
                node.text, 1000));
        for (int i = 0; i < MAX_CHOICES; i++) {
            Choice c = i < old.size() ? old.get(i) : null;
            inputs.add(line("label" + i, "Варіант " + (i + 1) + ": текст кнопки (порожньо = нема)",
                    c == null ? "" : c.label, 40));
            inputs.add(line("act" + i, "   дія: trade / close / quest:id / turnin:id",
                    c == null ? "" : c.action, 60));
            inputs.add(line("cond" + i, "   умова: new:id, active:id, ready:id, done:id (!=навпаки)",
                    c == null ? "" : c.cond, 80));
        }

        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(btn("&aЗберегти", v -> sync(() -> {
            applyNode(node, old, v);
            save();
            p.sendMessage(text("&aЗбережено."));
            openNodeEditor(p, n, node);
        })));
        for (Choice c : old) {
            buttons.add(btn("Гілка: " + c.label, v -> sync(() -> {
                applyNode(node, old, v);
                save();
                if (node.choices.contains(c)) openNodeEditor(p, n, c.next);
                else openNodeEditor(p, n, node);
            })));
        }
        ActionButton back = btn("&7Назад (без збереження)", v -> sync(() -> {
            if (node.parent == null) openSettings(p, n);
            else openNodeEditor(p, n, node.parent);
        }));

        p.showDialog(dialog("&5Діалог: " + path(node),
                List.of(para("Порожній текст кнопки прибирає варіант разом з усією його гілкою. "
                        + "Кнопка \"Гілка\" відкриває те, що NPC скаже далі.\n"
                        + "Дія: trade = торгівля, close = закрити, quest:id = взяти квест, turnin:id = здати квест "
                        + "(після квесту показується відповідь гілки). Умова: кілька через кому, "
                        + "кнопка видима лише коли всі виконані.\n"
                        + "Кольори: &a, &c, &l. {player} = ім'я гравця.")),
                inputs, DialogType.multiAction(buttons, back, 1)));
    }

    private void applyNode(Node node, List<Choice> old, Function<String, String> v) {
        node.text = clean(v.apply("text"), "...");
        List<Choice> result = new ArrayList<>();
        for (int i = 0; i < MAX_CHOICES; i++) {
            String label = clean(v.apply("label" + i), "");
            if (label.isEmpty()) continue;
            String act = clean(v.apply("act" + i), "");
            String cond = clean(v.apply("cond" + i), "");
            Choice c = i < old.size() ? old.get(i) : new Choice(label, act, cond, new Node("...", node, label));
            c.label = label;
            c.action = act;
            c.cond = cond;
            c.next.fromLabel = label;
            result.add(c);
        }
        node.choices.clear();
        node.choices.addAll(result);
    }

    private void openDelete(Player p, Npc n) {
        DialogType type = DialogType.confirmation(
                btn("&cТак, видалити", v -> sync(() -> {
                    removeNpc(n);
                    p.sendMessage(text("&aNPC видалено."));
                })),
                btn("&7Ні", v -> sync(() -> openSettings(p, n))));
        p.showDialog(dialog("&cВидалити NPC?", List.of(para("NPC #" + n.id + " \"" + n.name + "\" буде видалено.")),
                List.of(), type));
    }

    // ================================================================== trading

    private void openTradeEditor(Player p, Npc n) {
        TradeEditor holder = new TradeEditor(n);
        Inventory inv = Bukkit.createInventory(holder, 54, text("&5Угоди NPC #" + n.id));
        holder.inv = inv;
        for (int t = 0; t < n.trades.size() && t < MAX_TRADES; t++) {
            Trade tr = n.trades.get(t);
            inv.setItem(t * 3, tr.price1.clone());
            if (tr.price2 != null) inv.setItem(t * 3 + 1, tr.price2.clone());
            inv.setItem(t * 3 + 2, tr.result.clone());
        }
        p.openInventory(inv);
        p.sendMessage(text("&7Кожні 3 слоти поспіль це одна угода: &fціна&7, &fдруга ціна (необов'язково)&7, &fтовар&7. "
                + "До 18 угод. Закрий вікно, щоб зберегти."));
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (!(e.getInventory().getHolder() instanceof TradeEditor te)) return;
        Inventory inv = e.getInventory();
        te.npc.trades.clear();
        for (int t = 0; t < MAX_TRADES; t++) {
            ItemStack p1 = inv.getItem(t * 3);
            ItemStack p2 = inv.getItem(t * 3 + 1);
            ItemStack r = inv.getItem(t * 3 + 2);
            if (p1 == null && p2 != null) {
                p1 = p2;
                p2 = null;
            }
            if (p1 == null || r == null) continue;
            te.npc.trades.add(new Trade(p1.clone(), p2 == null ? null : p2.clone(), r.clone()));
        }
        save();
        if (e.getPlayer() instanceof Player pl) {
            pl.sendMessage(text("&aУгод збережено: " + te.npc.trades.size()));
        }
    }

    private void openTrade(Player p, Npc n) {
        if (n.trades.isEmpty()) {
            p.sendMessage(text("&7Тут поки нічого немає на продаж."));
            return;
        }
        Merchant merchant = Bukkit.createMerchant(LEGACY.deserialize(n.name));
        List<MerchantRecipe> recipes = new ArrayList<>();
        for (Trade t : n.trades) {
            MerchantRecipe r = new MerchantRecipe(t.result.clone(), 0, 1_000_000, false);
            r.addIngredient(t.price1.clone());
            if (t.price2 != null) r.addIngredient(t.price2.clone());
            r.setIgnoreDiscounts(true);
            recipes.add(r);
        }
        merchant.setRecipes(recipes);
        p.openMerchant(merchant, true);
    }

    // ================================================================== quests: progress

    private QState stateOf(Player p, String qid) {
        Map<String, QState> m = progress.get(p.getUniqueId());
        return m == null ? null : m.get(qid);
    }

    private boolean startQuest(Player p, String qid) {
        Quest q = quests.get(qid);
        if (q == null) {
            p.sendMessage(text("&cКвест \"" + qid + "\" не знайдено (перевір quests.yml)."));
            return false;
        }
        QState st = stateOf(p, qid);
        if (st != null && !("DONE".equals(st.status) && q.repeatable)) {
            p.sendMessage(text("DONE".equals(st.status) ? "&7Цей квест уже виконано." : "&7Ти вже взяв цей квест."));
            return false;
        }
        progress.computeIfAbsent(p.getUniqueId(), k -> new LinkedHashMap<>()).put(qid, new QState());
        saveProgress();
        p.sendMessage(text("&6Квест взято: &f" + q.name));
        if (!q.stages.isEmpty()) p.sendMessage(text("&6Етап 1: &f" + q.stages.get(0).text));
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.6f, 1.2f);
        return true;
    }

    private boolean turnIn(Player p, String qid) {
        Quest q = quests.get(qid);
        QState st = stateOf(p, qid);
        if (q == null || st == null || !"READY".equals(st.status)) {
            p.sendMessage(text("&7Квест ще не виконано."));
            return false;
        }
        complete(p, q, st);
        return true;
    }

    private void advance(Player p, Quest q, QState st) {
        st.stage++;
        st.count = 0;
        if (st.stage >= q.stages.size()) {
            if (q.turnIn) {
                st.status = "READY";
                saveProgress();
                p.sendMessage(text("&aУсі етапи квесту \"" + q.name + "\" виконано. Поверніться до NPC, щоб здати."));
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.6f, 1.4f);
            } else {
                complete(p, q, st);
            }
        } else {
            saveProgress();
            p.sendMessage(text("&6Етап " + (st.stage + 1) + ": &f" + q.stages.get(st.stage).text));
            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.8f, 1f);
        }
    }

    private void complete(Player p, Quest q, QState st) {
        st.status = "DONE";
        saveProgress();
        p.sendMessage(text("&a&lКвест виконано: &f" + q.name));
        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1f, 1f);
        if (q.xp > 0) p.giveExp(q.xp);
        for (String entry : q.items) {
            String[] parts = entry.split(":");
            Material m = Material.matchMaterial(parts[0].trim());
            if (m == null) continue;
            int amount = 1;
            if (parts.length > 1) {
                try {
                    amount = Math.max(1, Integer.parseInt(parts[1].trim()));
                } catch (NumberFormatException ignored) {
                }
            }
            p.getInventory().addItem(new ItemStack(m, amount))
                    .values().forEach(rest -> p.getWorld().dropItemNaturally(p.getLocation(), rest));
        }
        for (String cmd : q.commands) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("{player}", p.getName()));
        }
    }

    /** Етапи "поговорити" та "принести": зараховуються, коли гравець заговорив із потрібним NPC. */
    private void questsOnTalk(Player p, int npcId) {
        Map<String, QState> m = progress.get(p.getUniqueId());
        if (m == null) return;
        for (Map.Entry<String, QState> en : new ArrayList<>(m.entrySet())) {
            QState st = en.getValue();
            Quest q = quests.get(en.getKey());
            if (q == null || !"ACTIVE".equals(st.status) || st.stage >= q.stages.size()) continue;
            Stage sg = q.stages.get(st.stage);
            if (sg.npc != npcId) continue;

            if (sg.type.equals("talk")) {
                advance(p, q, st);
            } else if (sg.type.equals("deliver")) {
                ItemStack need = new ItemStack(sg.material, sg.amount);
                if (p.getInventory().containsAtLeast(new ItemStack(sg.material), sg.amount)) {
                    p.getInventory().removeItem(need);
                    p.sendMessage(text("&7Ти віддав: &f" + sg.amount + " x " + sg.material.name()));
                    advance(p, q, st);
                } else {
                    p.sendMessage(text("&eПотрібно принести: &f" + sg.amount + " x " + sg.material.name()));
                }
            }
        }
    }

    @EventHandler
    public void onKill(EntityDeathEvent e) {
        Player p = e.getEntity().getKiller();
        if (p == null) return;
        Map<String, QState> m = progress.get(p.getUniqueId());
        if (m == null) return;
        for (Map.Entry<String, QState> en : new ArrayList<>(m.entrySet())) {
            QState st = en.getValue();
            Quest q = quests.get(en.getKey());
            if (q == null || !"ACTIVE".equals(st.status) || st.stage >= q.stages.size()) continue;
            Stage sg = q.stages.get(st.stage);
            if (!sg.type.equals("kill") || sg.entity != e.getEntityType()) continue;

            st.count++;
            if (st.count >= sg.amount) {
                advance(p, q, st);
            } else {
                progressDirty = true;
                p.sendActionBar(text("&6" + q.name + ": &f" + st.count + "/" + sg.amount));
            }
        }
    }

    /** Раз на секунду: чи зайшов хтось у зону активного етапу "дійти". */
    private void checkReach() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            Map<String, QState> m = progress.get(p.getUniqueId());
            if (m == null) continue;
            for (Map.Entry<String, QState> en : new ArrayList<>(m.entrySet())) {
                QState st = en.getValue();
                Quest q = quests.get(en.getKey());
                if (q == null || !"ACTIVE".equals(st.status) || st.stage >= q.stages.size()) continue;
                Stage sg = q.stages.get(st.stage);
                if (sg.type.equals("reach") && inZone(p, sg)) advance(p, q, st);
            }
        }
    }

    private boolean inZone(Player p, Stage sg) {
        World w = Bukkit.getWorld(sg.world);
        if (w == null || !p.getWorld().equals(w)) return false;
        Location l = p.getLocation();
        double dx = l.getX() - sg.x;
        double dz = l.getZ() - sg.z;
        if (dx * dx + dz * dz > sg.radius * sg.radius) return false;
        return sg.height < 0 || Math.abs(l.getY() - sg.y) <= sg.height;
    }

    // ================================================================== journal

    private String compass(double dx, double dz) {
        double ang = Math.toDegrees(Math.atan2(dx, -dz)); // 0 = північ, 90 = схід
        if (ang < 0) ang += 360;
        String[] names = {"північ", "північний схід", "схід", "південний схід",
                "південь", "південний захід", "захід", "північний захід"};
        return names[(int) Math.round(ang / 45.0) % 8];
    }

    private String describe(Player p, Quest q, QState st) {
        if ("READY".equals(st.status)) return "&aУсе виконано. Здай квест NPC.";
        if (st.stage >= q.stages.size()) return "";
        Stage sg = q.stages.get(st.stage);
        String base = "&f" + sg.text;
        switch (sg.type) {
            case "kill":
                return base + " &7(" + st.count + "/" + sg.amount + ")";
            case "deliver":
                return base + " &7(" + sg.amount + " x " + sg.material.name() + ", NPC #" + sg.npc + ")";
            case "talk":
                return base + " &7(NPC #" + sg.npc + ")";
            case "reach": {
                World w = Bukkit.getWorld(sg.world);
                if (w == null || !p.getWorld().equals(w)) return base + " &7(в іншому світі: " + sg.world + ")";
                double dx = sg.x - p.getLocation().getX();
                double dz = sg.z - p.getLocation().getZ();
                long dist = Math.round(Math.sqrt(dx * dx + dz * dz));
                return base + " &7(" + dist + " м на " + compass(dx, dz) + ")";
            }
            default:
                return base;
        }
    }

    private void openJournal(Player p) {
        List<DialogBody> body = new ArrayList<>();
        Map<String, QState> m = progress.get(p.getUniqueId());
        if (m != null) {
            for (Map.Entry<String, QState> en : m.entrySet()) {
                QState st = en.getValue();
                Quest q = quests.get(en.getKey());
                if (q == null || "DONE".equals(st.status)) continue;
                String desc = q.description.isBlank() ? "" : "\n&7" + q.description;
                body.add(para("&6&l" + q.name + desc + "\n" + describe(p, q, st)));
            }
        }
        if (body.isEmpty()) body.add(para("&7Активних квестів немає. Поговори з жителями."));
        p.showDialog(dialog("&6Журнал квестів", body, List.of(), DialogType.notice(btn("&7Закрити", null))));
    }

    // ================================================================== protection

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (npcIdOf(e.getEntity()) != null) e.setCancelled(true);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        lastUse.remove(e.getPlayer().getUniqueId());
    }

    // ================================================================== storage: NPCs

    private String encode(ItemStack item) {
        return Base64.getEncoder().encodeToString(item.serializeAsBytes());
    }

    private ItemStack decode(String s) {
        return ItemStack.deserializeBytes(Base64.getDecoder().decode(s));
    }

    private void save() {
        YamlConfiguration y = new YamlConfiguration();
        y.set("next-id", nextId);
        for (Npc n : npcs.values()) {
            String b = "npcs." + n.id + ".";
            y.set(b + "name", n.name);
            y.set(b + "skin", n.skin);
            y.set(b + "world", n.loc.getWorld().getName());
            y.set(b + "x", n.loc.getX());
            y.set(b + "y", n.loc.getY());
            y.set(b + "z", n.loc.getZ());
            y.set(b + "yaw", (double) n.loc.getYaw());
            y.set(b + "entity", n.entity == null ? null : n.entity.toString());
            y.set(b + "tree", nodeToJson(n.root).toString());
            List<Map<String, String>> list = new ArrayList<>();
            for (Trade t : n.trades) {
                Map<String, String> m = new LinkedHashMap<>();
                m.put("p1", encode(t.price1));
                if (t.price2 != null) m.put("p2", encode(t.price2));
                m.put("r", encode(t.result));
                list.add(m);
            }
            y.set(b + "trades", list);
        }
        try {
            y.save(dataFile);
        } catch (IOException ex) {
            getLogger().severe("Не вдалось зберегти npcs.yml: " + ex.getMessage());
        }
    }

    private void load() {
        npcs.clear();
        if (!dataFile.exists()) return;
        YamlConfiguration y = YamlConfiguration.loadConfiguration(dataFile);
        nextId = y.getInt("next-id", 1);
        ConfigurationSection sec = y.getConfigurationSection("npcs");
        if (sec == null) return;
        for (String key : sec.getKeys(false)) {
            ConfigurationSection s = sec.getConfigurationSection(key);
            if (s == null) continue;
            World w = Bukkit.getWorld(s.getString("world", ""));
            if (w == null) continue;
            try {
                Npc n = new Npc(Integer.parseInt(key));
                n.name = s.getString("name", "NPC");
                n.skin = s.getString("skin", "");
                n.loc = new Location(w, s.getDouble("x"), s.getDouble("y"), s.getDouble("z"),
                        (float) s.getDouble("yaw"), 0f);
                String ent = s.getString("entity");
                n.entity = ent == null ? null : UUID.fromString(ent);
                loadTree(s, n);
                for (Map<?, ?> m : s.getMapList("trades")) {
                    Object p1 = m.get("p1");
                    Object p2 = m.get("p2");
                    Object r = m.get("r");
                    if (p1 == null || r == null) continue;
                    try {
                        n.trades.add(new Trade(decode(p1.toString()),
                                p2 == null ? null : decode(p2.toString()), decode(r.toString())));
                    } catch (RuntimeException ex) {
                        getLogger().warning("Не вдалось прочитати угоду NPC " + key);
                    }
                }
                npcs.put(n.id, n);
                nextId = Math.max(nextId, n.id + 1);
            } catch (IllegalArgumentException ex) {
                getLogger().warning("Пропускаю пошкоджений запис NPC " + key);
            }
        }
    }

    private JsonObject nodeToJson(Node node) {
        JsonObject o = new JsonObject();
        o.addProperty("text", node.text);
        JsonArray arr = new JsonArray();
        for (Choice c : node.choices) {
            JsonObject co = new JsonObject();
            co.addProperty("label", c.label);
            co.addProperty("action", c.action == null ? "" : c.action);
            co.addProperty("cond", c.cond == null ? "" : c.cond);
            co.add("node", nodeToJson(c.next));
            arr.add(co);
        }
        o.add("choices", arr);
        return o;
    }

    private Node nodeFromJson(JsonObject o, Node parent, String fromLabel, int depth) {
        Node node = new Node(o.has("text") ? o.get("text").getAsString() : "...", parent, fromLabel);
        if (o.has("choices") && depth < 30) {
            for (JsonElement e : o.getAsJsonArray("choices")) {
                JsonObject co = e.getAsJsonObject();
                String label = co.get("label").getAsString();
                String action = co.has("action") ? co.get("action").getAsString() : "";
                String cond = co.has("cond") ? co.get("cond").getAsString() : "";
                node.choices.add(new Choice(label, action, cond,
                        nodeFromJson(co.getAsJsonObject("node"), node, label, depth + 1)));
            }
        }
        return node;
    }

    /** Читає дерево діалогу. Підтримує і старий формат 0.1.0 (привітання + варіанти з відповідями). */
    private void loadTree(ConfigurationSection s, Npc n) {
        String tree = s.getString("tree");
        if (tree != null) {
            try {
                n.root = nodeFromJson(JsonParser.parseString(tree).getAsJsonObject(), null, "", 0);
            } catch (RuntimeException ex) {
                getLogger().warning("Пошкоджений діалог NPC " + n.id + ", скинуто до типового.");
            }
            return;
        }
        n.root = new Node(s.getString("greeting", "..."), null, "");
        for (Map<?, ?> m : s.getMapList("options")) {
            Object label = m.get("label");
            Object reply = m.get("reply");
            if (label == null || label.toString().isBlank()) continue;
            String l = label.toString();
            n.root.choices.add(new Choice(l, "", "",
                    new Node(reply == null ? "..." : reply.toString(), n.root, l)));
        }
    }

    // ================================================================== storage: quests

    private static String ms(Map<?, ?> m, String k, String d) {
        Object o = m.get(k);
        return o == null ? d : o.toString();
    }

    private static double md(Map<?, ?> m, String k, double d) {
        Object o = m.get(k);
        if (o instanceof Number num) return num.doubleValue();
        if (o != null) {
            try {
                return Double.parseDouble(o.toString());
            } catch (NumberFormatException ignored) {
            }
        }
        return d;
    }

    private void loadQuests() {
        quests.clear();
        if (!questsFile.exists()) return;
        YamlConfiguration y = YamlConfiguration.loadConfiguration(questsFile);
        ConfigurationSection sec = y.getConfigurationSection("quests");
        if (sec == null) return;

        for (String rawId : sec.getKeys(false)) {
            String id = rawId.toLowerCase(Locale.ROOT);
            ConfigurationSection s = sec.getConfigurationSection(rawId);
            if (s == null) continue;
            if (!id.matches("[a-z0-9_\\-]+")) {
                getLogger().warning("Квест \"" + rawId + "\": id має складатись з a-z, 0-9, _ та -. Пропущено.");
                continue;
            }
            Quest q = new Quest();
            q.id = id;
            q.name = s.getString("name", id);
            q.description = s.getString("description", "");
            q.repeatable = s.getBoolean("repeatable", false);
            q.turnIn = s.getBoolean("turn-in", false);
            q.xp = s.getInt("rewards.xp", 0);
            q.items = s.getStringList("rewards.items");
            q.commands = s.getStringList("rewards.commands");

            boolean valid = true;
            int index = 0;
            for (Map<?, ?> m : s.getMapList("stages")) {
                index++;
                Stage sg = new Stage();
                sg.type = ms(m, "type", "").toLowerCase(Locale.ROOT);
                sg.text = ms(m, "text", "");
                switch (sg.type) {
                    case "reach" -> {
                        sg.world = ms(m, "world", "world");
                        sg.x = md(m, "x", 0);
                        sg.y = md(m, "y", 64);
                        sg.z = md(m, "z", 0);
                        sg.radius = md(m, "radius", 5);
                        sg.height = md(m, "height", -1);
                    }
                    case "kill" -> {
                        try {
                            sg.entity = EntityType.valueOf(ms(m, "entity", "").toUpperCase(Locale.ROOT));
                        } catch (IllegalArgumentException ex) {
                            getLogger().warning("Квест " + id + ", етап " + index + ": невідомий entity.");
                            valid = false;
                        }
                        sg.amount = (int) md(m, "amount", 1);
                    }
                    case "deliver" -> {
                        sg.material = Material.matchMaterial(ms(m, "material", ""));
                        if (sg.material == null) {
                            getLogger().warning("Квест " + id + ", етап " + index + ": невідомий material.");
                            valid = false;
                        }
                        sg.amount = (int) md(m, "amount", 1);
                        sg.npc = (int) md(m, "npc", -1);
                    }
                    case "talk" -> sg.npc = (int) md(m, "npc", -1);
                    default -> {
                        getLogger().warning("Квест " + id + ", етап " + index + ": невідомий type \"" + sg.type + "\".");
                        valid = false;
                    }
                }
                q.stages.add(sg);
            }
            if (!valid || q.stages.isEmpty()) {
                getLogger().warning("Квест " + id + " пропущено через помилки в етапах.");
                continue;
            }
            quests.put(id, q);
        }
        getLogger().info("Завантажено квестів: " + quests.size());
    }

    private void loadProgress() {
        progress.clear();
        if (!progressFile.exists()) return;
        YamlConfiguration y = YamlConfiguration.loadConfiguration(progressFile);
        ConfigurationSection players = y.getConfigurationSection("players");
        if (players == null) return;
        for (String uuidStr : players.getKeys(false)) {
            ConfigurationSection ps = players.getConfigurationSection(uuidStr);
            if (ps == null) continue;
            try {
                UUID uuid = UUID.fromString(uuidStr);
                Map<String, QState> map = new LinkedHashMap<>();
                for (String qid : ps.getKeys(false)) {
                    ConfigurationSection qs = ps.getConfigurationSection(qid);
                    if (qs == null) continue;
                    QState st = new QState();
                    st.status = qs.getString("status", "ACTIVE");
                    st.stage = qs.getInt("stage", 0);
                    st.count = qs.getInt("count", 0);
                    map.put(qid, st);
                }
                progress.put(uuid, map);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private void saveProgress() {
        progressDirty = false;
        YamlConfiguration y = new YamlConfiguration();
        for (Map.Entry<UUID, Map<String, QState>> pe : progress.entrySet()) {
            for (Map.Entry<String, QState> qe : pe.getValue().entrySet()) {
                String b = "players." + pe.getKey() + "." + qe.getKey() + ".";
                y.set(b + "status", qe.getValue().status);
                y.set(b + "stage", qe.getValue().stage);
                y.set(b + "count", qe.getValue().count);
            }
        }
        try {
            y.save(progressFile);
        } catch (IOException ex) {
            getLogger().severe("Не вдалось зберегти progress.yml: " + ex.getMessage());
        }
    }

    // ================================================================== commands

    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] a) {
        if (command.getName().equalsIgnoreCase("quests")) {
            if (s instanceof Player p) openJournal(p);
            else s.sendMessage("Тільки для гравців.");
            return true;
        }

        if (!s.hasPermission("questnpc.admin")) {
            s.sendMessage("§cНемає прав.");
            return true;
        }
        String sub = a.length == 0 ? "give" : a[0].toLowerCase();
        switch (sub) {
            case "give" -> {
                Player target = a.length > 1 ? Bukkit.getPlayerExact(a[1]) : (s instanceof Player pl ? pl : null);
                if (target == null) {
                    s.sendMessage("§cГравця не знайдено.");
                    return true;
                }
                target.getInventory().addItem(createWand())
                        .values().forEach(rest -> target.getWorld().dropItemNaturally(target.getLocation(), rest));
                s.sendMessage("§aМізкоправ видано гравцю " + target.getName() + ".");
            }
            case "list" -> {
                s.sendMessage("§aNPC: §f" + npcs.size());
                for (Npc n : npcs.values()) {
                    s.sendMessage("§7#" + n.id + " §f" + n.name + " §8(" + n.loc.getWorld().getName() + " "
                            + n.loc.getBlockX() + " " + n.loc.getBlockY() + " " + n.loc.getBlockZ() + ")");
                }
            }
            case "remove" -> {
                Npc n = byArg(a);
                if (n == null) {
                    s.sendMessage("§cВкажи номер NPC з /mizkoprav list.");
                    return true;
                }
                removeNpc(n);
                s.sendMessage("§aNPC #" + n.id + " видалено.");
            }
            case "tp" -> {
                Npc n = byArg(a);
                if (n == null || !(s instanceof Player p)) {
                    s.sendMessage("§cВкажи номер NPC з /mizkoprav list (команда для гравців).");
                    return true;
                }
                p.teleportAsync(n.loc);
            }
            case "here" -> {
                if (!(s instanceof Player p)) {
                    s.sendMessage("Тільки для гравців.");
                    return true;
                }
                Location l = p.getLocation();
                s.sendMessage("§aТвоя позиція для quests.yml:");
                s.sendMessage("§fworld: " + l.getWorld().getName());
                s.sendMessage("§fx: " + l.getBlockX() + "  y: " + l.getBlockY() + "  z: " + l.getBlockZ());
            }
            case "quests" -> {
                s.sendMessage("§aКвестів: §f" + quests.size());
                for (Quest q : quests.values()) {
                    s.sendMessage("§7" + q.id + " §f" + q.name + " §8(етапів: " + q.stages.size()
                            + (q.turnIn ? ", зі здачею" : "") + ")");
                }
            }
            case "reload" -> {
                loadQuests();
                s.sendMessage("§aquests.yml перезавантажено. Квестів: " + quests.size());
            }
            default -> s.sendMessage("§e/mizkoprav [give|list|remove <№>|tp <№>|here|quests|reload]");
        }
        return true;
    }

    private Npc byArg(String[] a) {
        if (a.length < 2) return null;
        try {
            return npcs.get(Integer.parseInt(a[1]));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender s, Command command, String alias, String[] a) {
        if (!command.getName().equalsIgnoreCase("mizkoprav")) return List.of();
        if (a.length == 1) {
            return List.of("give", "list", "remove", "tp", "here", "quests", "reload").stream()
                    .filter(x -> x.startsWith(a[0].toLowerCase())).toList();
        }
        if (a.length == 2 && (a[0].equalsIgnoreCase("remove") || a[0].equalsIgnoreCase("tp"))) {
            return npcs.keySet().stream().map(String::valueOf).filter(x -> x.startsWith(a[1])).toList();
        }
        return List.of();
    }
}
