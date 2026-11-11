package ua.questnpc;

import com.destroystokyo.paper.profile.PlayerProfile;
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
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mannequin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * QuestNPC v0.1: NPC (сутність Mannequin) зі скіном, діалогами у нативних вікнах гри
 * і налаштуванням у грі через предмет "Мізкоправ".
 */
public final class QuestNPC extends JavaPlugin implements Listener, TabExecutor {

    private static final LegacyComponentSerializer LEGACY = LegacyComponentSerializer.legacyAmpersand();
    private static final ClickCallback.Options CLICK_OPTS =
            ClickCallback.Options.builder().uses(1).lifetime(Duration.ofMinutes(30)).build();

    /** Скільки варіантів відповіді можна налаштувати в одного NPC. */
    private static final int MAX_OPTIONS = 4;

    static final class Option {
        String label;
        String reply;

        Option(String label, String reply) {
            this.label = label;
            this.reply = reply;
        }
    }

    static final class Npc {
        final int id;
        String name = "NPC";
        String skin = "";
        String greeting = "Привіт, {player}!";
        final List<Option> options = new ArrayList<>();
        Location loc;
        UUID entity;

        Npc(int id) {
            this.id = id;
        }
    }

    private NamespacedKey wandKey;
    private NamespacedKey npcKey;
    private File dataFile;

    private final Map<Integer, Npc> npcs = new LinkedHashMap<>();
    private int nextId = 1;
    private final Map<UUID, Long> lastUse = new HashMap<>();

    // ================================================================== lifecycle

    @Override
    public void onEnable() {
        wandKey = new NamespacedKey(this, "wand");
        npcKey = new NamespacedKey(this, "npc_id");
        dataFile = new File(getDataFolder(), "npcs.yml");
        getDataFolder().mkdirs();

        load();
        getServer().getPluginManager().registerEvents(this, this);

        PluginCommand cmd = getCommand("mizkoprav");
        if (cmd != null) {
            cmd.setExecutor(this);
            cmd.setTabCompleter(this);
        }
    }

    @Override
    public void onDisable() {
        save();
    }

    // ================================================================== helpers

    private Component text(String legacy) {
        return LEGACY.deserialize(legacy).decoration(TextDecoration.ITALIC, false);
    }

    /** Текст із кольорами (&), {player} замінюється на ім'я гравця. */
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

    /** Кнопка діалогу. cb == null - кнопка просто закриває вікно. */
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

        e.setCancelled(true); // не відкривати редактор книги
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
        loc.setYaw(p.getLocation().getYaw() + 180f); // дивитись на гравця
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
        n.options.add(new Option("Хто ти?", "Я новий NPC. Мене можна налаштувати Мізкоправом."));

        Mannequin m = loc.getWorld().spawn(loc, Mannequin.class, mq -> setup(mq, n));
        n.entity = m.getUniqueId();
        npcs.put(n.id, n);
        save();
        applySkin(n);
        return n;
    }

    /** Завантажує скін за ніком (потрібен онлайн-режим) і ставить його на NPC. */
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
            openTalk(p, n);
        }
    }

    private void openTalk(Player p, Npc n) {
        List<ActionButton> buttons = new ArrayList<>();
        for (Option o : n.options) {
            if (o.label == null || o.label.isBlank()) continue;
            buttons.add(btn("&f" + o.label, v -> sync(() -> openReply(p, n, o))));
        }
        DialogType type = buttons.isEmpty()
                ? DialogType.notice(btn("&7Закрити", null))
                : DialogType.multiAction(buttons, btn("&7Закрити", null), 1);

        p.showDialog(dialog(n.name, List.of(DialogBody.plainMessage(fmt(n.greeting, p))), List.of(), type));
    }

    private void openReply(Player p, Npc n, Option o) {
        String reply = (o.reply == null || o.reply.isBlank()) ? "..." : o.reply;
        DialogType type = DialogType.multiAction(
                List.of(btn("&e< Назад", v -> sync(() -> openTalk(p, n)))),
                btn("&7Закрити", null), 1);
        p.showDialog(dialog(n.name, List.of(DialogBody.plainMessage(fmt(reply, p))), List.of(), type));
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
                btn("Діалог", v -> sync(() -> openDialogueEditor(p, n))),
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

    private void openDialogueEditor(Player p, Npc n) {
        List<DialogInput> inputs = new ArrayList<>();
        inputs.add(block("greeting", "Привітання (перша репліка NPC)", n.greeting, 1000));
        for (int i = 0; i < MAX_OPTIONS; i++) {
            Option o = i < n.options.size() ? n.options.get(i) : new Option("", "");
            inputs.add(line("label" + i, "Варіант " + (i + 1) + ": текст кнопки (порожньо = нема)", o.label, 40));
            inputs.add(block("reply" + i, "Варіант " + (i + 1) + ": відповідь NPC", o.reply, 1000));
        }

        DialogType type = DialogType.confirmation(
                btn("&aЗберегти", v -> sync(() -> {
                    n.greeting = clean(v.apply("greeting"), "...");
                    n.options.clear();
                    for (int i = 0; i < MAX_OPTIONS; i++) {
                        String label = clean(v.apply("label" + i), "");
                        if (label.isEmpty()) continue;
                        n.options.add(new Option(label, clean(v.apply("reply" + i), "")));
                    }
                    save();
                    p.sendMessage(text("&aДіалог збережено. Клікни по NPC без Мізкоправа, щоб перевірити."));
                    openSettings(p, n);
                })),
                btn("&7Назад", v -> sync(() -> openSettings(p, n))));

        p.showDialog(dialog("&5Діалог: " + n.name,
                List.of(para("Кольори: &a, &c, &l тощо. {player} = ім'я гравця. Порожній текст кнопки прибирає варіант.")),
                inputs, type));
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

    // ================================================================== protection

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (npcIdOf(e.getEntity()) != null) e.setCancelled(true);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        lastUse.remove(e.getPlayer().getUniqueId());
    }

    // ================================================================== storage

    private void save() {
        YamlConfiguration y = new YamlConfiguration();
        y.set("next-id", nextId);
        for (Npc n : npcs.values()) {
            String b = "npcs." + n.id + ".";
            y.set(b + "name", n.name);
            y.set(b + "skin", n.skin);
            y.set(b + "greeting", n.greeting);
            y.set(b + "world", n.loc.getWorld().getName());
            y.set(b + "x", n.loc.getX());
            y.set(b + "y", n.loc.getY());
            y.set(b + "z", n.loc.getZ());
            y.set(b + "yaw", (double) n.loc.getYaw());
            y.set(b + "entity", n.entity == null ? null : n.entity.toString());
            List<Map<String, String>> opts = new ArrayList<>();
            for (Option o : n.options) {
                Map<String, String> m = new LinkedHashMap<>();
                m.put("label", o.label);
                m.put("reply", o.reply);
                opts.add(m);
            }
            y.set(b + "options", opts);
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
                n.greeting = s.getString("greeting", "...");
                n.loc = new Location(w, s.getDouble("x"), s.getDouble("y"), s.getDouble("z"),
                        (float) s.getDouble("yaw"), 0f);
                String ent = s.getString("entity");
                n.entity = ent == null ? null : UUID.fromString(ent);
                for (Map<?, ?> m : s.getMapList("options")) {
                    Object label = m.get("label");
                    Object reply = m.get("reply");
                    n.options.add(new Option(label == null ? "" : label.toString(), reply == null ? "" : reply.toString()));
                }
                npcs.put(n.id, n);
                nextId = Math.max(nextId, n.id + 1);
            } catch (IllegalArgumentException ex) {
                getLogger().warning("Пропускаю пошкоджений запис NPC " + key);
            }
        }
    }

    // ================================================================== commands

    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] a) {
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
            default -> s.sendMessage("§e/mizkoprav [give|list|remove <№>|tp <№>]");
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
        if (a.length == 1) {
            return List.of("give", "list", "remove", "tp").stream()
                    .filter(x -> x.startsWith(a[0].toLowerCase())).toList();
        }
        if (a.length == 2 && (a[0].equalsIgnoreCase("remove") || a[0].equalsIgnoreCase("tp"))) {
            return npcs.keySet().stream().map(String::valueOf).filter(x -> x.startsWith(a[1])).toList();
        }
        return List.of();
    }
}
