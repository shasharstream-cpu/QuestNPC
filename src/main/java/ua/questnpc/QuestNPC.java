/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.destroystokyo.paper.profile.PlayerProfile
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  io.papermc.paper.datacomponent.item.ResolvableProfile
 *  io.papermc.paper.dialog.Dialog
 *  io.papermc.paper.dialog.DialogResponseView
 *  io.papermc.paper.registry.data.dialog.ActionButton
 *  io.papermc.paper.registry.data.dialog.DialogBase
 *  io.papermc.paper.registry.data.dialog.DialogRegistryEntry$Builder
 *  io.papermc.paper.registry.data.dialog.action.DialogAction
 *  io.papermc.paper.registry.data.dialog.action.DialogAction$CustomClickAction
 *  io.papermc.paper.registry.data.dialog.body.DialogBody
 *  io.papermc.paper.registry.data.dialog.input.DialogInput
 *  io.papermc.paper.registry.data.dialog.input.TextDialogInput$MultilineOptions
 *  io.papermc.paper.registry.data.dialog.type.ConfirmationType
 *  io.papermc.paper.registry.data.dialog.type.DialogType
 *  io.papermc.paper.registry.data.dialog.type.NoticeType
 *  net.kyori.adventure.dialog.DialogLike
 *  net.kyori.adventure.text.Component
 *  net.kyori.adventure.text.event.ClickCallback$Options
 *  net.kyori.adventure.text.format.TextDecoration
 *  net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.NamespacedKey
 *  org.bukkit.Sound
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.command.PluginCommand
 *  org.bukkit.command.TabCompleter
 *  org.bukkit.command.TabExecutor
 *  org.bukkit.configuration.ConfigurationSection
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.HumanEntity
 *  org.bukkit.entity.Mannequin
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.Action
 *  org.bukkit.event.entity.EntityDamageEvent
 *  org.bukkit.event.entity.EntityDeathEvent
 *  org.bukkit.event.inventory.InventoryCloseEvent
 *  org.bukkit.event.player.PlayerInteractEntityEvent
 *  org.bukkit.event.player.PlayerInteractEvent
 *  org.bukkit.event.player.PlayerQuitEvent
 *  org.bukkit.inventory.EquipmentSlot
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.InventoryHolder
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.Merchant
 *  org.bukkit.inventory.MerchantRecipe
 *  org.bukkit.inventory.meta.ItemMeta
 *  org.bukkit.persistence.PersistentDataType
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.java.JavaPlugin
 */
package ua.questnpc;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.papermc.paper.datacomponent.item.ResolvableProfile;
import io.papermc.paper.dialog.Dialog;
import io.papermc.paper.dialog.DialogResponseView;
import io.papermc.paper.registry.data.dialog.ActionButton;
import io.papermc.paper.registry.data.dialog.DialogBase;
import io.papermc.paper.registry.data.dialog.DialogRegistryEntry;
import io.papermc.paper.registry.data.dialog.action.DialogAction;
import io.papermc.paper.registry.data.dialog.body.DialogBody;
import io.papermc.paper.registry.data.dialog.input.DialogInput;
import io.papermc.paper.registry.data.dialog.input.TextDialogInput;
import io.papermc.paper.registry.data.dialog.type.ConfirmationType;
import io.papermc.paper.registry.data.dialog.type.DialogType;
import io.papermc.paper.registry.data.dialog.type.NoticeType;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import net.kyori.adventure.dialog.DialogLike;
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
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuestNPC
extends JavaPlugin
implements Listener,
TabExecutor {
    private static final LegacyComponentSerializer LEGACY = LegacyComponentSerializer.legacyAmpersand();
    private static final ClickCallback.Options CLICK_OPTS = (ClickCallback.Options)ClickCallback.Options.builder().uses(1).lifetime((TemporalAmount)Duration.ofMinutes(30L)).build();
    private static final int MAX_CHOICES = 5;
    private static final int MAX_TRADES = 18;
    private NamespacedKey wandKey;
    private NamespacedKey npcKey;
    private File dataFile;
    private File progressFile;
    private File questsFile;
    private final Map<Integer, Npc> npcs = new LinkedHashMap<Integer, Npc>();
    private int nextId = 1;
    private final Map<UUID, Long> lastUse = new HashMap<UUID, Long>();
    private final Map<String, Quest> quests = new LinkedHashMap<String, Quest>();
    private final Map<UUID, Map<String, QState>> progress = new HashMap<UUID, Map<String, QState>>();
    private boolean progressDirty = false;
    private boolean uidGenerated = false;
    private final Map<UUID, Map<String, Long>> choiceUses = new HashMap<>();
    private final Map<UUID, String> tracked = new HashMap<>();
    private final java.util.Set<UUID> hudOff = new java.util.HashSet<>();
    private final Map<UUID, net.kyori.adventure.bossbar.BossBar> bars = new HashMap<>();
    private final Map<String, ItemStack> stackCache = new HashMap<>();

    public void onEnable() {
        PluginCommand qcmd;
        this.wandKey = new NamespacedKey((Plugin)this, "wand");
        this.npcKey = new NamespacedKey((Plugin)this, "npc_id");
        this.getDataFolder().mkdirs();
        this.saveDefaultConfig();
        this.dataFile = new File(this.getDataFolder(), "npcs.yml");
        this.progressFile = new File(this.getDataFolder(), "progress.yml");
        this.questsFile = new File(this.getDataFolder(), "quests.yml");
        if (!this.questsFile.exists()) {
            this.saveResource("quests.yml", false);
        }
        this.load();
        if (this.uidGenerated) {
            this.save();
        }
        this.loadQuests();
        this.loadProgress();
        this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
        PluginCommand cmd = this.getCommand("mizkoprav");
        if (cmd != null) {
            cmd.setExecutor((CommandExecutor)this);
            cmd.setTabCompleter((TabCompleter)this);
        }
        if ((qcmd = this.getCommand("quests")) != null) {
            qcmd.setExecutor((CommandExecutor)this);
        }
        this.getServer().getScheduler().runTaskTimer((Plugin)this, this::checkReach, 40L, 20L);
        this.getServer().getScheduler().runTaskTimer((Plugin)this, this::updateTrackers, 40L, 20L);
        this.getServer().getScheduler().runTaskTimer((Plugin)this, () -> {
            if (this.progressDirty) {
                this.saveProgress();
            }
        }, 100L, 100L);
    }

    public void onDisable() {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            this.hideTracker(pl);
        }
        for (UUID id : new ArrayList<>(this.bubbles.keySet())) {
            this.removeBubble(id);
        }
        this.save();
        this.saveProgress();
    }

    private Component text(String legacy) {
        return LEGACY.deserialize(legacy).decoration(TextDecoration.ITALIC, false);
    }

    private Component fmt(String raw, Player p) {
        return LEGACY.deserialize(this.papi(p, raw.replace("{player}", p.getName())));
    }

    private static String clean(String s, String fallback) {
        if (s == null || s.isBlank()) {
            return fallback;
        }
        return s.trim();
    }

    private void sync(Runnable r) {
        if (Bukkit.isPrimaryThread()) {
            r.run();
        } else {
            Bukkit.getScheduler().runTask((Plugin)this, r);
        }
    }

    private ActionButton btn(String label, Consumer<Function<String, String>> cb) {
        DialogAction.CustomClickAction action = cb == null ? null : DialogAction.customClick((view, audience) -> cb.accept(arg_0 -> ((DialogResponseView)view).getText(arg_0)), (ClickCallback.Options)CLICK_OPTS);
        return ActionButton.create((Component)LEGACY.deserialize(label), null, (int)200, (DialogAction)action);
    }

    private Dialog dialog(String title, List<DialogBody> body, List<DialogInput> inputs, DialogType type) {
        return Dialog.create(factory -> ((DialogRegistryEntry.Builder)factory.empty()).base(DialogBase.builder((Component)LEGACY.deserialize(title)).canCloseWithEscape(true).body(body).inputs(inputs).build()).type(type));
    }

    private DialogBody para(String legacy) {
        return DialogBody.plainMessage((Component)LEGACY.deserialize(legacy));
    }

    private DialogInput line(String key, String label, String initial, int maxLength) {
        return DialogInput.text((String)key, (Component)Component.text((String)label)).width(300).initial(initial == null ? "" : initial).maxLength(maxLength).build();
    }

    private DialogInput block(String key, String label, String initial, int maxLength) {
        return DialogInput.text((String)key, (Component)Component.text((String)label)).width(300).initial(initial == null ? "" : initial).maxLength(maxLength).multiline(TextDialogInput.MultilineOptions.create((Integer)6, (Integer)90)).build();
    }

    private ItemStack createWand() {
        ItemStack item = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(this.text("&d\u041c\u0456\u0437\u043a\u043e\u043f\u0440\u0430\u0432"));
        meta.lore(List.of(this.text("&7\u041f\u041a\u041c \u043f\u043e \u0431\u043b\u043e\u043a\u0443 - \u0441\u0442\u0432\u043e\u0440\u0438\u0442\u0438 NPC."), this.text("&7\u041f\u041a\u041c \u043f\u043e NPC - \u043d\u0430\u043b\u0430\u0448\u0442\u0443\u0432\u0430\u0442\u0438.")));
        meta.getPersistentDataContainer().set(this.wandKey, PersistentDataType.BYTE, (byte)1);
        item.setItemMeta(meta);
        return item;
    }

    private boolean isWand(ItemStack item) {
        return item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(this.wandKey, PersistentDataType.BYTE);
    }

    @EventHandler
    public void onUseWand(PlayerInteractEvent e) {
        if (e.getHand() != EquipmentSlot.HAND || !this.isWand(e.getItem())) {
            return;
        }
        Action a = e.getAction();
        if (a != Action.RIGHT_CLICK_BLOCK && a != Action.RIGHT_CLICK_AIR) {
            return;
        }
        e.setCancelled(true);
        Player p = e.getPlayer();
        if (!p.hasPermission("questnpc.admin")) {
            p.sendMessage(this.text("&c\u041d\u0435\u043c\u0430\u0454 \u043f\u0440\u0430\u0432."));
            return;
        }
        if (a == Action.RIGHT_CLICK_AIR) {
            if (p.isSneaking()) {
                this.openQuestList(p);
                return;
            }
            p.sendMessage(this.text("&7\u041f\u041a\u041c \u043f\u043e \u0431\u043b\u043e\u043a\u0443 - \u0441\u0442\u0432\u043e\u0440\u0438\u0442\u0438 NPC, \u041f\u041a\u041c \u043f\u043e NPC - \u043d\u0430\u043b\u0430\u0448\u0442\u0443\u0432\u0430\u0442\u0438."));
            return;
        }
        Block clicked = e.getClickedBlock();
        if (clicked == null) {
            return;
        }
        Location loc = clicked.getRelative(e.getBlockFace()).getLocation().add(0.5, 0.0, 0.5);
        loc.setYaw(p.getLocation().getYaw() + 180.0f);
        loc.setPitch(0.0f);
        if (this.tooFast(p)) {
            return;
        }
        this.openCreate(p, loc);
    }

    private Integer npcIdOf(Entity entity) {
        if (!(entity instanceof Mannequin)) {
            return null;
        }
        return (Integer)entity.getPersistentDataContainer().get(this.npcKey, PersistentDataType.INTEGER);
    }

    private void setup(Mannequin m, Npc n) {
        m.getPersistentDataContainer().set(this.npcKey, PersistentDataType.INTEGER, n.id);
        m.customName((Component)LEGACY.deserialize(n.name));
        m.setCustomNameVisible(true);
        m.setDescription(null);
        m.setImmovable(true);
        m.setInvulnerable(true);
        m.setSilent(true);
        m.setPersistent(true);
        m.setRemoveWhenFarAway(false);
    }

    private Mannequin entityOf(Npc n) {
        Mannequin m;
        if (n.entity == null || n.loc == null || n.loc.getWorld() == null) {
            return null;
        }
        n.loc.getWorld().getChunkAt(n.loc).load();
        Entity e = n.loc.getWorld().getEntity(n.entity);
        return e instanceof Mannequin ? (m = (Mannequin)e) : null;
    }

    private Npc createNpc(String name, String skin, Location loc) {
        Npc n = new Npc(this.nextId++);
        n.name = name;
        n.skin = skin;
        n.loc = loc.clone();
        n.root.choices.add(new Choice("\u0425\u0442\u043e \u0442\u0438?", "", "", new Node("\u042f \u043d\u043e\u0432\u0438\u0439 NPC. \u041c\u0435\u043d\u0435 \u043c\u043e\u0436\u043d\u0430 \u043d\u0430\u043b\u0430\u0448\u0442\u0443\u0432\u0430\u0442\u0438 \u041c\u0456\u0437\u043a\u043e\u043f\u0440\u0430\u0432\u043e\u043c.", n.root, "\u0425\u0442\u043e \u0442\u0438?")));
        Mannequin m = (Mannequin)loc.getWorld().spawn(loc, Mannequin.class, mq -> this.setup((Mannequin)mq, n));
        n.entity = m.getUniqueId();
        this.npcs.put(n.id, n);
        this.save();
        this.applySkin(n);
        return n;
    }

    private void applySkin(Npc n) {
        if (n.skin == null || n.skin.isBlank()) {
            return;
        }
        PlayerProfile profile = Bukkit.createProfile((String)n.skin);
        profile.update().thenAccept(resolved -> this.sync(() -> {
            Mannequin m = this.entityOf(n);
            if (m != null && resolved != null) {
                m.setProfile(ResolvableProfile.resolvableProfile((PlayerProfile)resolved));
            }
        })).exceptionally(ex -> {
            this.getLogger().warning("\u041d\u0435 \u0432\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u0432\u0430\u043d\u0442\u0430\u0436\u0438\u0442\u0438 \u0441\u043a\u0456\u043d '" + n.skin + "': " + ex.getMessage());
            return null;
        });
    }

    private void removeNpc(Npc n) {
        Mannequin m = this.entityOf(n);
        if (m != null) {
            m.remove();
        }
        this.npcs.remove(n.id);
        this.save();
    }

    private boolean tooFast(Player p) {
        long now = System.currentTimeMillis();
        Long last = this.lastUse.get(p.getUniqueId());
        if (last != null && now - last < 300L) {
            return true;
        }
        this.lastUse.put(p.getUniqueId(), now);
        return false;
    }

    @EventHandler
    public void onInteractNpc(PlayerInteractEntityEvent e) {
        Integer id = this.npcIdOf(e.getRightClicked());
        if (id == null) {
            return;
        }
        e.setCancelled(true);
        if (e.getHand() != EquipmentSlot.HAND) {
            return;
        }
        Npc n = this.npcs.get(id);
        Player p = e.getPlayer();
        if (n == null || this.tooFast(p)) {
            return;
        }
        if (this.isWand(p.getInventory().getItemInMainHand())) {
            if (p.hasPermission("questnpc.admin")) {
                this.openSettings(p, n);
            }
        } else {
            String reply = this.questsOnTalk(p, n.id);
            if (reply != null) {
                this.openReply(p, n, reply);
            } else if (this.useHub(p, n)) {
                this.openHub(p, n);
            } else {
                this.openNode(p, n, n.root);
            }
        }
    }

    private void openNode(Player p, Npc n, Node node) {
        ArrayList<ActionButton> buttons = new ArrayList<ActionButton>();
        for (Choice c : node.choices) {
            if (!this.condOk(p, c.cond) || !this.choiceAvailable(p, c)) continue;
            buttons.add(this.btn("&f" + c.label, v -> this.sync(() -> this.runChoice(p, n, node, c))));
        }
        if (node.parent != null) {
            Node parent = node.parent;
            buttons.add(this.btn("&e< \u041d\u0430\u0437\u0430\u0434", v -> this.sync(() -> this.openNode(p, n, parent))));
        } else if (this.useHub(p, n)) {
            buttons.add(this.btn("&e< Меню", v -> this.sync(() -> this.openHub(p, n))));
        }
        DialogType type = buttons.isEmpty() ? DialogType.notice((ActionButton)this.btn("&7\u0417\u0430\u043a\u0440\u0438\u0442\u0438", null)) : DialogType.multiAction(buttons, (ActionButton)this.btn("&7\u0417\u0430\u043a\u0440\u0438\u0442\u0438", null), (int)1);
        this.showBubble(p, n, node.text);
        p.showDialog((DialogLike)this.dialog(n.name, List.of(DialogBody.plainMessage((Component)this.fmt(node.text, p))), List.of(), (DialogType)type));
    }

    private void runChoice(Player p, Npc n, Node node, Choice c) {
        this.markChoiceUsed(p, c);
        String a;
        String string = a = c.action == null ? "" : c.action.trim().toLowerCase(Locale.ROOT);
        if (a.isEmpty()) {
            this.openNode(p, n, c.next);
        } else if (!a.equals("close")) {
            if (a.equals("trade")) {
                this.openTrade(p, n);
            } else if (a.startsWith("quest:")) {
                if (this.startQuest(p, a.substring(6).trim())) {
                    this.openNode(p, n, c.next);
                } else {
                    this.openNode(p, n, node);
                }
            } else if (a.startsWith("turnin:")) {
                if (this.turnIn(p, a.substring(7).trim())) {
                    this.openNode(p, n, c.next);
                } else {
                    this.openNode(p, n, node);
                }
            } else {
                this.openNode(p, n, c.next);
            }
        }
    }

    private boolean condOk(Player p, String cond) {
        if (cond == null || cond.isBlank()) {
            return true;
        }
        for (String part : cond.split(",")) {
            boolean ok;
            int i;
            String t = part.trim().toLowerCase(Locale.ROOT);
            if (t.isEmpty()) continue;
            if (t.equals("once") || t.startsWith("cd:")) continue;
            boolean negate = t.startsWith("!");
            if (negate) {
                t = t.substring(1);
            }
            if ((i = t.indexOf(58)) < 0 || (ok = this.questMatches(p, t.substring(0, i).trim(), t.substring(i + 1).trim())) != negate) continue;
            return false;
        }
        return true;
    }

    private boolean questMatches(Player p, String kind, String qid) {
        Quest q = this.quests.get(qid);
        QState st = this.stateOf(p, qid);
        return switch (kind) {
            case "new" -> {
                if (q != null && (st == null || "DONE".equals(st.status) && q.repeatable && this.cooldownLeft(q, st) == 0L)) {
                    yield true;
                }
                yield false;
            }
            case "active" -> {
                if (st != null && "ACTIVE".equals(st.status)) {
                    yield true;
                }
                yield false;
            }
            case "ready" -> {
                if (st != null && "READY".equals(st.status)) {
                    yield true;
                }
                yield false;
            }
            case "done" -> {
                if (st != null && "DONE".equals(st.status)) {
                    yield true;
                }
                yield false;
            }
            default -> false;
        };
    }

    private void openCreate(Player p, Location loc) {
        ConfirmationType type = DialogType.confirmation((ActionButton)this.btn("&a\u0421\u0442\u0432\u043e\u0440\u0438\u0442\u0438", v -> this.sync(() -> {
            Npc n = this.createNpc(QuestNPC.clean((String)v.apply("name"), "NPC"), QuestNPC.clean((String)v.apply("skin"), ""), loc);
            p.sendMessage(this.text("&aNPC #" + n.id + " \u0441\u0442\u0432\u043e\u0440\u0435\u043d\u043e. \u041f\u041a\u041c \u043f\u043e \u043d\u044c\u043e\u043c\u0443 \u0437 \u041c\u0456\u0437\u043a\u043e\u043f\u0440\u0430\u0432\u043e\u043c - \u043d\u0430\u043b\u0430\u0448\u0442\u0443\u0432\u0430\u043d\u043d\u044f."));
        })), (ActionButton)this.btn("&c\u0421\u043a\u0430\u0441\u0443\u0432\u0430\u0442\u0438", null));
        p.showDialog((DialogLike)this.dialog("&5\u0421\u0442\u0432\u043e\u0440\u0435\u043d\u043d\u044f NPC", List.of(this.para("NPC \u0437'\u044f\u0432\u0438\u0442\u044c\u0441\u044f \u043d\u0430 \u0432\u0438\u0431\u0440\u0430\u043d\u043e\u043c\u0443 \u043c\u0456\u0441\u0446\u0456. \u0421\u043a\u0456\u043d \u0431\u0435\u0440\u0435\u0442\u044c\u0441\u044f \u0437\u0430 \u043d\u0456\u043a\u043e\u043c \u0433\u0440\u0430\u0432\u0446\u044f (\u043f\u043e\u0442\u0440\u0456\u0431\u0435\u043d \u043e\u043d\u043b\u0430\u0439\u043d-\u0440\u0435\u0436\u0438\u043c \u0441\u0435\u0440\u0432\u0435\u0440\u0430).")), List.of(this.line("name", "\u0406\u043c'\u044f NPC (\u043c\u043e\u0436\u043d\u0430 \u0437 &-\u043a\u043e\u043b\u044c\u043e\u0440\u0430\u043c\u0438)", "\u041d\u043e\u0432\u0438\u0439 NPC", 32), this.line("skin", "\u0421\u043a\u0456\u043d: \u043d\u0456\u043a \u0433\u0440\u0430\u0432\u0446\u044f", p.getName(), 16)), (DialogType)type));
    }

    private void openSettings(Player p, Npc n) {
        List<ActionButton> buttons = List.of(this.btn("\u0406\u043c'\u044f \u0442\u0430 \u0441\u043a\u0456\u043d", v -> this.sync(() -> this.openIdentity(p, n))), this.btn("\u0414\u0456\u0430\u043b\u043e\u0433", v -> this.sync(() -> this.openNodeEditor(p, n, n.root))), this.btn("\u0423\u0433\u043e\u0434\u0438 (\u0442\u043e\u0440\u0433\u0456\u0432\u043b\u044f): " + n.trades.size(), v -> this.sync(() -> this.openTradeEditor(p, n))), this.btn("\u041f\u0435\u0440\u0435\u043c\u0456\u0441\u0442\u0438\u0442\u0438 \u0434\u043e \u043c\u0435\u043d\u0435", v -> this.sync(() -> {
            Mannequin m = this.entityOf(n);
            if (m != null) {
                Location l = p.getLocation();
                m.teleport(l);
                n.loc = l.clone();
                this.save();
                p.sendMessage(this.text("&aNPC \u043f\u0435\u0440\u0435\u043c\u0456\u0449\u0435\u043d\u043e."));
            } else {
                p.sendMessage(this.text("&c\u0421\u0443\u0442\u043d\u0456\u0441\u0442\u044c NPC \u043d\u0435 \u0437\u043d\u0430\u0439\u0434\u0435\u043d\u043e (\u043c\u043e\u0436\u043b\u0438\u0432\u043e, \u0457\u0457 \u0432\u0431\u0438\u043b\u0438). \u0412\u0438\u0434\u0430\u043b\u0438 \u0439 \u0441\u0442\u0432\u043e\u0440\u0438 \u0437\u0430\u043d\u043e\u0432\u043e."));
            }
            this.openSettings(p, n);
        })), this.btn("Меню вибору (GUI)", v -> this.sync(() -> this.openHubEditor(p, n))), this.btn("&6\u041a\u0432\u0435\u0441\u0442\u0438 (\u0440\u0435\u0434\u0430\u043a\u0442\u043e\u0440)", v -> this.sync(() -> this.openQuestList(p))), this.btn("&c\u0412\u0438\u0434\u0430\u043b\u0438\u0442\u0438 NPC", v -> this.sync(() -> this.openDelete(p, n))));
        p.showDialog((DialogLike)this.dialog("&5NPC #" + n.id + ": " + n.name, List.of(this.para("\u0429\u043e \u0437\u043c\u0456\u043d\u0438\u0442\u0438?")), List.of(), (DialogType)DialogType.multiAction(buttons, (ActionButton)this.btn("&7\u0417\u0430\u043a\u0440\u0438\u0442\u0438", null), (int)1)));
    }

    private void openIdentity(Player p, Npc n) {
        ConfirmationType type = DialogType.confirmation((ActionButton)this.btn("&a\u0417\u0431\u0435\u0440\u0435\u0433\u0442\u0438", v -> this.sync(() -> {
            n.name = QuestNPC.clean((String)v.apply("name"), n.name);
            String newSkin = QuestNPC.clean((String)v.apply("skin"), "");
            boolean skinChanged = !newSkin.equals(n.skin);
            n.skin = newSkin;
            Mannequin m = this.entityOf(n);
            if (m != null) {
                m.customName((Component)LEGACY.deserialize(n.name));
            }
            if (skinChanged) {
                this.applySkin(n);
            }
            this.save();
            p.sendMessage(this.text("&a\u0417\u0431\u0435\u0440\u0435\u0436\u0435\u043d\u043e."));
            this.openSettings(p, n);
        })), (ActionButton)this.btn("&7\u041d\u0430\u0437\u0430\u0434", v -> this.sync(() -> this.openSettings(p, n))));
        p.showDialog((DialogLike)this.dialog("&5\u0406\u043c'\u044f \u0442\u0430 \u0441\u043a\u0456\u043d", List.of(this.para("\u0421\u043a\u0456\u043d \u0431\u0435\u0440\u0435\u0442\u044c\u0441\u044f \u0437\u0430 \u043d\u0456\u043a\u043e\u043c \u0433\u0440\u0430\u0432\u0446\u044f (\u043f\u043e\u0442\u0440\u0456\u0431\u0435\u043d \u043e\u043d\u043b\u0430\u0439\u043d-\u0440\u0435\u0436\u0438\u043c \u0441\u0435\u0440\u0432\u0435\u0440\u0430).")), List.of(this.line("name", "\u0406\u043c'\u044f NPC", n.name, 32), this.line("skin", "\u0421\u043a\u0456\u043d: \u043d\u0456\u043a \u0433\u0440\u0430\u0432\u0446\u044f", n.skin, 16)), (DialogType)type));
    }

    private String path(Node node) {
        ArrayList<String> parts = new ArrayList<String>();
        Node x = node;
        while (x != null) {
            parts.add(x.parent == null ? "\u041f\u0440\u0438\u0432\u0456\u0442\u0430\u043d\u043d\u044f" : x.fromLabel);
            x = x.parent;
        }
        Collections.reverse(parts);
        return String.join((CharSequence)" > ", parts);
    }

    private void openNodeEditor(Player p, Npc n, Node node) {
        ArrayList<Choice> old = new ArrayList<Choice>(node.choices);
        ArrayList<DialogInput> inputs = new ArrayList<DialogInput>();
        inputs.add(this.block("text", node.parent == null ? "\u041f\u0440\u0438\u0432\u0456\u0442\u0430\u043d\u043d\u044f (\u043f\u0435\u0440\u0448\u0430 \u0440\u0435\u043f\u043b\u0456\u043a\u0430 NPC)" : "\u0429\u043e \u043a\u0430\u0436\u0435 NPC", node.text, 1000));
        for (int i = 0; i < 5; ++i) {
            Choice c = i < old.size() ? (Choice)old.get(i) : null;
            inputs.add(this.line("label" + i, "\u0412\u0430\u0440\u0456\u0430\u043d\u0442 " + (i + 1) + ": \u0442\u0435\u043a\u0441\u0442 \u043a\u043d\u043e\u043f\u043a\u0438 (\u043f\u043e\u0440\u043e\u0436\u043d\u044c\u043e = \u043d\u0435\u043c\u0430)", c == null ? "" : c.label, 40));
            inputs.add(this.line("act" + i, "   \u0434\u0456\u044f: trade / close / quest:id / turnin:id", c == null ? "" : c.action, 60));
            inputs.add(this.line("cond" + i, "   \u0443\u043c\u043e\u0432\u0430: new:id, active:id, ready:id, done:id (!=навпаки), once = одноразова, cd:10m = кулдаун", c == null ? "" : c.cond, 80));
        }
        ArrayList<ActionButton> buttons = new ArrayList<ActionButton>();
        buttons.add(this.btn("&a\u0417\u0431\u0435\u0440\u0435\u0433\u0442\u0438", v -> this.sync(() -> {
            this.applyNode(node, (List<Choice>)old, (Function<String, String>)v);
            this.save();
            p.sendMessage(this.text("&a\u0417\u0431\u0435\u0440\u0435\u0436\u0435\u043d\u043e."));
            this.openNodeEditor(p, n, node);
        })));
        for (Choice c : old) {
            buttons.add(this.btn("\u0413\u0456\u043b\u043a\u0430: " + c.label, v -> this.sync(() -> {
                this.applyNode(node, (List<Choice>)old, (Function<String, String>)v);
                this.save();
                if (node.choices.contains(c)) {
                    this.openNodeEditor(p, n, c.next);
                } else {
                    this.openNodeEditor(p, n, node);
                }
            })));
        }
        ActionButton back = this.btn("&7\u041d\u0430\u0437\u0430\u0434 (\u0431\u0435\u0437 \u0437\u0431\u0435\u0440\u0435\u0436\u0435\u043d\u043d\u044f)", v -> this.sync(() -> {
            if (node.parent == null) {
                this.openSettings(p, n);
            } else {
                this.openNodeEditor(p, n, node.parent);
            }
        }));
        p.showDialog((DialogLike)this.dialog("&5\u0414\u0456\u0430\u043b\u043e\u0433: " + this.path(node), List.of(this.para("\u041f\u043e\u0440\u043e\u0436\u043d\u0456\u0439 \u0442\u0435\u043a\u0441\u0442 \u043a\u043d\u043e\u043f\u043a\u0438 \u043f\u0440\u0438\u0431\u0438\u0440\u0430\u0454 \u0432\u0430\u0440\u0456\u0430\u043d\u0442 \u0440\u0430\u0437\u043e\u043c \u0437 \u0443\u0441\u0456\u0454\u044e \u0439\u043e\u0433\u043e \u0433\u0456\u043b\u043a\u043e\u044e. \u041a\u043d\u043e\u043f\u043a\u0430 \"\u0413\u0456\u043b\u043a\u0430\" \u0432\u0456\u0434\u043a\u0440\u0438\u0432\u0430\u0454 \u0442\u0435, \u0449\u043e NPC \u0441\u043a\u0430\u0436\u0435 \u0434\u0430\u043b\u0456.\n\u0414\u0456\u044f: trade = \u0442\u043e\u0440\u0433\u0456\u0432\u043b\u044f, close = \u0437\u0430\u043a\u0440\u0438\u0442\u0438, quest:id = \u0432\u0437\u044f\u0442\u0438 \u043a\u0432\u0435\u0441\u0442, turnin:id = \u0437\u0434\u0430\u0442\u0438 \u043a\u0432\u0435\u0441\u0442 (\u043f\u0456\u0441\u043b\u044f \u043a\u0432\u0435\u0441\u0442\u0443 \u043f\u043e\u043a\u0430\u0437\u0443\u0454\u0442\u044c\u0441\u044f \u0432\u0456\u0434\u043f\u043e\u0432\u0456\u0434\u044c \u0433\u0456\u043b\u043a\u0438). \u0423\u043c\u043e\u0432\u0430: \u043a\u0456\u043b\u044c\u043a\u0430 \u0447\u0435\u0440\u0435\u0437 \u043a\u043e\u043c\u0443, \u043a\u043d\u043e\u043f\u043a\u0430 \u0432\u0438\u0434\u0438\u043c\u0430 \u043b\u0438\u0448\u0435 \u043a\u043e\u043b\u0438 \u0432\u0441\u0456 \u0432\u0438\u043a\u043e\u043d\u0430\u043d\u0456.\n\u041a\u043e\u043b\u044c\u043e\u0440\u0438: &a, &c, &l. {player} = \u0456\u043c'\u044f \u0433\u0440\u0430\u0432\u0446\u044f.")), inputs, (DialogType)DialogType.multiAction(buttons, (ActionButton)back, (int)1)));
    }

    private void applyNode(Node node, List<Choice> old, Function<String, String> v) {
        node.text = QuestNPC.clean(v.apply("text"), "...");
        ArrayList<Choice> result = new ArrayList<Choice>();
        for (int i = 0; i < 5; ++i) {
            String label = QuestNPC.clean(v.apply("label" + i), "");
            if (label.isEmpty()) continue;
            String act = QuestNPC.clean(v.apply("act" + i), "");
            String cond = QuestNPC.clean(v.apply("cond" + i), "");
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
        ConfirmationType type = DialogType.confirmation((ActionButton)this.btn("&c\u0422\u0430\u043a, \u0432\u0438\u0434\u0430\u043b\u0438\u0442\u0438", v -> this.sync(() -> {
            this.removeNpc(n);
            p.sendMessage(this.text("&aNPC \u0432\u0438\u0434\u0430\u043b\u0435\u043d\u043e."));
        })), (ActionButton)this.btn("&7\u041d\u0456", v -> this.sync(() -> this.openSettings(p, n))));
        p.showDialog((DialogLike)this.dialog("&c\u0412\u0438\u0434\u0430\u043b\u0438\u0442\u0438 NPC?", List.of(this.para("NPC #" + n.id + " \"" + n.name + "\" \u0431\u0443\u0434\u0435 \u0432\u0438\u0434\u0430\u043b\u0435\u043d\u043e.")), List.of(), (DialogType)type));
    }

    private void openTradeEditor(Player p, Npc n) {
        Inventory inv;
        TradeEditor holder = new TradeEditor(n);
        holder.inv = inv = Bukkit.createInventory((InventoryHolder)holder, (int)54, (Component)this.text("&5\u0423\u0433\u043e\u0434\u0438 NPC #" + n.id));
        for (int t = 0; t < n.trades.size() && t < 18; ++t) {
            Trade tr = n.trades.get(t);
            inv.setItem(t * 3, tr.price1.clone());
            if (tr.price2 != null) {
                inv.setItem(t * 3 + 1, tr.price2.clone());
            }
            inv.setItem(t * 3 + 2, tr.result.clone());
        }
        p.openInventory(inv);
        p.sendMessage(this.text("&7\u041a\u043e\u0436\u043d\u0456 3 \u0441\u043b\u043e\u0442\u0438 \u043f\u043e\u0441\u043f\u0456\u043b\u044c \u0446\u0435 \u043e\u0434\u043d\u0430 \u0443\u0433\u043e\u0434\u0430: &f\u0446\u0456\u043d\u0430&7, &f\u0434\u0440\u0443\u0433\u0430 \u0446\u0456\u043d\u0430 (\u043d\u0435\u043e\u0431\u043e\u0432'\u044f\u0437\u043a\u043e\u0432\u043e)&7, &f\u0442\u043e\u0432\u0430\u0440&7. \u0414\u043e 18 \u0443\u0433\u043e\u0434. \u0417\u0430\u043a\u0440\u0438\u0439 \u0432\u0456\u043a\u043d\u043e, \u0449\u043e\u0431 \u0437\u0431\u0435\u0440\u0435\u0433\u0442\u0438."));
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        InventoryHolder inventoryHolder = e.getInventory().getHolder();
        if (!(inventoryHolder instanceof TradeEditor)) {
            return;
        }
        TradeEditor te = (TradeEditor)inventoryHolder;
        Inventory inv = e.getInventory();
        te.npc.trades.clear();
        for (int t = 0; t < 18; ++t) {
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
        this.save();
        HumanEntity humanEntity = e.getPlayer();
        if (humanEntity instanceof Player) {
            Player pl = (Player)humanEntity;
            pl.sendMessage(this.text("&a\u0423\u0433\u043e\u0434 \u0437\u0431\u0435\u0440\u0435\u0436\u0435\u043d\u043e: " + te.npc.trades.size()));
        }
    }

    private void openTrade(Player p, Npc n) {
        if (n.trades.isEmpty()) {
            p.sendMessage(this.text("&7\u0422\u0443\u0442 \u043f\u043e\u043a\u0438 \u043d\u0456\u0447\u043e\u0433\u043e \u043d\u0435\u043c\u0430\u0454 \u043d\u0430 \u043f\u0440\u043e\u0434\u0430\u0436."));
            return;
        }
        Merchant merchant = Bukkit.createMerchant((Component)LEGACY.deserialize(n.name));
        ArrayList<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>();
        for (Trade t : n.trades) {
            MerchantRecipe r = new MerchantRecipe(t.result.clone(), 0, 1000000, false);
            r.addIngredient(t.price1.clone());
            if (t.price2 != null) {
                r.addIngredient(t.price2.clone());
            }
            r.setIgnoreDiscounts(true);
            recipes.add(r);
        }
        merchant.setRecipes(recipes);
        p.openMerchant(merchant, true);
    }

    private QState stateOf(Player p, String qid) {
        Map<String, QState> m = this.progress.get(p.getUniqueId());
        return m == null ? null : m.get(qid);
    }

    private boolean startQuest(Player p, String qid) {
        Quest q = this.quests.get(qid);
        if (q == null) {
            p.sendMessage(this.text("&c\u041a\u0432\u0435\u0441\u0442 \"" + qid + "\" \u043d\u0435 \u0437\u043d\u0430\u0439\u0434\u0435\u043d\u043e (\u043f\u0435\u0440\u0435\u0432\u0456\u0440 quests.yml)."));
            return false;
        }
        QState st = this.stateOf(p, qid);
        if (st != null && "DONE".equals(st.status) && q.repeatable && this.cooldownLeft(q, st) > 0L) {
            p.sendMessage(this.text("&eЦей квест можна взяти знову через &f" + QuestNPC.fmtDuration(this.cooldownLeft(q, st) / 1000L + 1L)));
            return false;
        }
        if (!(st == null || "DONE".equals(st.status) && q.repeatable)) {
            p.sendMessage(this.text("DONE".equals(st.status) ? "&7\u0426\u0435\u0439 \u043a\u0432\u0435\u0441\u0442 \u0443\u0436\u0435 \u0432\u0438\u043a\u043e\u043d\u0430\u043d\u043e." : "&7\u0422\u0438 \u0432\u0436\u0435 \u0432\u0437\u044f\u0432 \u0446\u0435\u0439 \u043a\u0432\u0435\u0441\u0442."));
            return false;
        }
        this.progress.computeIfAbsent(p.getUniqueId(), k -> new LinkedHashMap()).put(qid, new QState());
        this.tracked.put(p.getUniqueId(), qid);
        this.saveProgress();
        p.sendMessage(this.text("&6\u041a\u0432\u0435\u0441\u0442 \u0432\u0437\u044f\u0442\u043e: &f" + q.name));
        if (!q.stages.isEmpty()) {
            p.sendMessage(this.text("&6\u0415\u0442\u0430\u043f 1: &f" + q.stages.get((int)0).text));
        }
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.6f, 1.2f);
        return true;
    }

    private boolean turnIn(Player p, String qid) {
        Quest q = this.quests.get(qid);
        QState st = this.stateOf(p, qid);
        if (q == null || st == null || !"READY".equals(st.status)) {
            p.sendMessage(this.text("&7\u041a\u0432\u0435\u0441\u0442 \u0449\u0435 \u043d\u0435 \u0432\u0438\u043a\u043e\u043d\u0430\u043d\u043e."));
            return false;
        }
        this.complete(p, q, st);
        return true;
    }

    private void advance(Player p, Quest q, QState st) {
        ++st.stage;
        st.count = 0;
        if (st.stage >= q.stages.size()) {
            if (q.turnIn) {
                st.status = "READY";
                this.saveProgress();
                p.sendMessage(this.text("&a\u0423\u0441\u0456 \u0435\u0442\u0430\u043f\u0438 \u043a\u0432\u0435\u0441\u0442\u0443 \"" + q.name + "\" \u0432\u0438\u043a\u043e\u043d\u0430\u043d\u043e. \u041f\u043e\u0432\u0435\u0440\u043d\u0456\u0442\u044c\u0441\u044f \u0434\u043e NPC, \u0449\u043e\u0431 \u0437\u0434\u0430\u0442\u0438."));
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.6f, 1.4f);
            } else {
                this.complete(p, q, st);
            }
        } else {
            this.saveProgress();
            p.sendMessage(this.text("&6\u0415\u0442\u0430\u043f " + (st.stage + 1) + ": &f" + q.stages.get((int)st.stage).text));
            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.8f, 1.0f);
        }
    }

    private void complete(Player p, Quest q, QState st) {
        st.status = "DONE";
        st.doneAt = System.currentTimeMillis();
        this.saveProgress();
        p.sendMessage(this.text("&a&l\u041a\u0432\u0435\u0441\u0442 \u0432\u0438\u043a\u043e\u043d\u0430\u043d\u043e: &f" + q.name));
        p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0f, 1.0f);
        if (q.xp > 0) {
            p.giveExp(q.xp);
        }
        for (String entry : q.items) {
            String[] parts = entry.split(":");
            Material m = Material.matchMaterial((String)parts[0].trim());
            if (m == null) continue;
            int amount = 1;
            if (parts.length > 1) {
                try {
                    amount = Math.max(1, Integer.parseInt(parts[1].trim()));
                }
                catch (NumberFormatException numberFormatException) {
                    // empty catch block
                }
            }
            p.getInventory().addItem(new ItemStack[]{new ItemStack(m, amount)}).values().forEach(rest -> p.getWorld().dropItemNaturally(p.getLocation(), rest));
        }
        for (String enc : q.stacks) {
            try {
                ItemStack reward = this.decode(enc);
                p.getInventory().addItem(new ItemStack[]{reward}).values().forEach(rest -> p.getWorld().dropItemNaturally(p.getLocation(), rest));
            } catch (RuntimeException ex) {
                this.getLogger().warning("Не вдалося видати предмет-нагороду квесту " + q.id + ": " + ex.getMessage());
            }
        }
        for (String cmd : q.commands) {
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)cmd.replace("{player}", p.getName()));
        }
    }

    /** Повертає текст відповіді NPC, якщо етап, що щойно виконався (або не виконався), її має. */
    private String questsOnTalk(Player p, int npcId) {
        Map<String, QState> m = this.progress.get(p.getUniqueId());
        if (m == null) {
            return null;
        }
        String reply = null;
        for (Map.Entry<String, QState> en : new ArrayList<Map.Entry<String, QState>>(m.entrySet())) {
            QState st = en.getValue();
            Quest q = this.quests.get(en.getKey());
            if (q == null || !"ACTIVE".equals(st.status) || st.stage >= q.stages.size()) {
                continue;
            }
            Stage sg = q.stages.get(st.stage);
            if (sg.npc != npcId) {
                continue;
            }
            if (sg.type.equals("talk")) {
                this.advance(p, q, st);
                if (reply == null && !sg.reply.isBlank()) {
                    reply = sg.reply;
                }
                continue;
            }
            if (sg.type.equals("deliver") && sg.material != null) {
                ItemStack need = new ItemStack(sg.material, sg.amount);
                if (p.getInventory().containsAtLeast(new ItemStack(sg.material), sg.amount)) {
                    p.getInventory().removeItem(new ItemStack[]{need});
                    p.sendMessage(this.text("&7Ти віддав: &f" + sg.amount + " x " + sg.material.name()));
                    this.advance(p, q, st);
                    if (reply == null && !sg.reply.isBlank()) {
                        reply = sg.reply;
                    }
                } else if (!sg.replyFail.isBlank()) {
                    if (reply == null) {
                        reply = sg.replyFail;
                    }
                } else {
                    p.sendMessage(this.text("&eПотрібно принести: &f" + sg.amount + " x " + sg.material.name()));
                }
                continue;
            }
            if (sg.type.equals("item")) {
                ItemStack need;
                try {
                    need = this.stackOf(sg.stack);
                } catch (RuntimeException ex) {
                    continue;
                }
                ItemStack one = need.clone();
                one.setAmount(1);
                if (p.getInventory().containsAtLeast(one, sg.amount)) {
                    ItemStack take = need.clone();
                    take.setAmount(sg.amount);
                    p.getInventory().removeItem(new ItemStack[]{take});
                    p.sendMessage(this.text("&7Ти віддав: &f" + sg.amount + " x " + this.stackLabel(sg)));
                    this.advance(p, q, st);
                    if (reply == null && !sg.reply.isBlank()) {
                        reply = sg.reply;
                    }
                } else if (!sg.replyFail.isBlank()) {
                    if (reply == null) {
                        reply = sg.replyFail;
                    }
                } else {
                    p.sendMessage(this.text("&eПотрібно принести: &f" + sg.amount + " x " + this.stackLabel(sg)));
                }
            }
        }
        return reply;
    }

    @EventHandler
    public void onKill(EntityDeathEvent e) {
        Player p = e.getEntity().getKiller();
        if (p == null) {
            return;
        }
        Map<String, QState> m = this.progress.get(p.getUniqueId());
        if (m == null) {
            return;
        }
        for (Map.Entry<String, QState> en : new ArrayList<Map.Entry<String, QState>>(m.entrySet())) {
            QState st = en.getValue();
            Quest q = this.quests.get(en.getKey());
            if (q == null || !"ACTIVE".equals(st.status) || st.stage >= q.stages.size()) continue;
            Stage sg = q.stages.get(st.stage);
            if (!sg.type.equals("kill") || sg.entity != e.getEntityType()) continue;
            ++st.count;
            if (st.count >= sg.amount) {
                this.advance(p, q, st);
                continue;
            }
            this.progressDirty = true;
            p.sendActionBar(this.text("&6" + q.name + ": &f" + st.count + "/" + sg.amount));
        }
    }

    private void checkReach() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            Map<String, QState> m = this.progress.get(p.getUniqueId());
            if (m == null) continue;
            for (Map.Entry<String, QState> en : new ArrayList<Map.Entry<String, QState>>(m.entrySet())) {
                QState st = en.getValue();
                Quest q = this.quests.get(en.getKey());
                if (q == null || !"ACTIVE".equals(st.status) || st.stage >= q.stages.size()) continue;
                Stage sg = q.stages.get(st.stage);
                if (!sg.type.equals("reach") || !this.inZone(p, sg)) continue;
                this.advance(p, q, st);
            }
        }
    }

    private boolean inZone(Player p, Stage sg) {
        double dz;
        World w = Bukkit.getWorld((String)sg.world);
        if (w == null || !p.getWorld().equals((Object)w)) {
            return false;
        }
        Location l = p.getLocation();
        double dx = l.getX() - sg.x;
        if (dx * dx + (dz = l.getZ() - sg.z) * dz > sg.radius * sg.radius) {
            return false;
        }
        return sg.height < 0.0 || Math.abs(l.getY() - sg.y) <= sg.height;
    }

    private String compass(double dx, double dz) {
        double ang = Math.toDegrees(Math.atan2(dx, -dz));
        if (ang < 0.0) {
            ang += 360.0;
        }
        String[] names = new String[]{"\u043f\u0456\u0432\u043d\u0456\u0447", "\u043f\u0456\u0432\u043d\u0456\u0447\u043d\u0438\u0439 \u0441\u0445\u0456\u0434", "\u0441\u0445\u0456\u0434", "\u043f\u0456\u0432\u0434\u0435\u043d\u043d\u0438\u0439 \u0441\u0445\u0456\u0434", "\u043f\u0456\u0432\u0434\u0435\u043d\u044c", "\u043f\u0456\u0432\u0434\u0435\u043d\u043d\u0438\u0439 \u0437\u0430\u0445\u0456\u0434", "\u0437\u0430\u0445\u0456\u0434", "\u043f\u0456\u0432\u043d\u0456\u0447\u043d\u0438\u0439 \u0437\u0430\u0445\u0456\u0434"};
        return names[(int)Math.round(ang / 45.0) % 8];
    }

    private String describe(Player p, Quest q, QState st) {
        if ("READY".equals(st.status)) {
            return "&a\u0423\u0441\u0435 \u0432\u0438\u043a\u043e\u043d\u0430\u043d\u043e. \u0417\u0434\u0430\u0439 \u043a\u0432\u0435\u0441\u0442 NPC.";
        }
        if (st.stage >= q.stages.size()) {
            return "";
        }
        Stage sg = q.stages.get(st.stage);
        String base = "&f" + sg.text;
        switch (sg.type) {
            case "kill": {
                return base + " &7(" + st.count + "/" + sg.amount + ")";
            }
            case "deliver": {
                return base + " &7(" + sg.amount + " x " + sg.material.name() + ", NPC #" + sg.npc + ")";
            }
            case "item": {
                return base + " &7(" + sg.amount + " x " + this.stackLabel(sg) + ", NPC #" + sg.npc + ")";
            }
            case "talk": {
                return base + " &7(NPC #" + sg.npc + ")";
            }
            case "reach": {
                World w = Bukkit.getWorld((String)sg.world);
                if (w == null || !p.getWorld().equals((Object)w)) {
                    return base + " &7(\u0432 \u0456\u043d\u0448\u043e\u043c\u0443 \u0441\u0432\u0456\u0442\u0456: " + sg.world + ")";
                }
                double dx = sg.x - p.getLocation().getX();
                double dz = sg.z - p.getLocation().getZ();
                long dist = Math.round(Math.sqrt(dx * dx + dz * dz));
                return base + " &7(" + dist + " \u043c \u043d\u0430 " + this.compass(dx, dz) + ")";
            }
        }
        return base;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (this.npcIdOf(e.getEntity()) != null) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        this.lastUse.remove(e.getPlayer().getUniqueId());
        this.removeBubble(e.getPlayer().getUniqueId());
        this.hideTracker(e.getPlayer());
    }

    private String encode(ItemStack item) {
        return Base64.getEncoder().encodeToString(item.serializeAsBytes());
    }

    private ItemStack decode(String s) {
        return ItemStack.deserializeBytes((byte[])Base64.getDecoder().decode(s));
    }

    private void save() {
        YamlConfiguration y = new YamlConfiguration();
        y.set("next-id", (Object)this.nextId);
        for (Npc n : this.npcs.values()) {
            String b = "npcs." + n.id + ".";
            y.set(b + "name", (Object)n.name);
            y.set(b + "skin", (Object)n.skin);
            y.set(b + "world", (Object)n.loc.getWorld().getName());
            y.set(b + "x", (Object)n.loc.getX());
            y.set(b + "y", (Object)n.loc.getY());
            y.set(b + "z", (Object)n.loc.getZ());
            y.set(b + "yaw", (Object)n.loc.getYaw());
            y.set(b + "entity", n.entity == null ? null : n.entity.toString());
            y.set(b + "hub.text", n.hubText);
            y.set(b + "hub.trade", n.tradeLabel);
            y.set(b + "hub.dialog", n.dialogLabel);
            y.set(b + "hub.quest", n.questLabel);
            y.set(b + "hub.mode", n.menuMode);
            y.set(b + "tree", (Object)this.nodeToJson(n.root).toString());
            ArrayList list = new ArrayList();
            for (Trade t : n.trades) {
                LinkedHashMap<String, String> m = new LinkedHashMap<String, String>();
                m.put("p1", this.encode(t.price1));
                if (t.price2 != null) {
                    m.put("p2", this.encode(t.price2));
                }
                m.put("r", this.encode(t.result));
                list.add(m);
            }
            y.set(b + "trades", list);
        }
        try {
            y.save(this.dataFile);
        }
        catch (IOException ex) {
            this.getLogger().severe("\u041d\u0435 \u0432\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0431\u0435\u0440\u0435\u0433\u0442\u0438 npcs.yml: " + ex.getMessage());
        }
    }

    private void load() {
        this.npcs.clear();
        if (!this.dataFile.exists()) {
            return;
        }
        YamlConfiguration y = YamlConfiguration.loadConfiguration((File)this.dataFile);
        this.nextId = y.getInt("next-id", 1);
        ConfigurationSection sec = y.getConfigurationSection("npcs");
        if (sec == null) {
            return;
        }
        for (String key : sec.getKeys(false)) {
            World w;
            ConfigurationSection s = sec.getConfigurationSection(key);
            if (s == null || (w = Bukkit.getWorld((String)s.getString("world", ""))) == null) continue;
            try {
                Npc n = new Npc(Integer.parseInt(key));
                n.name = s.getString("name", "NPC");
                n.skin = s.getString("skin", "");
                n.loc = new Location(w, s.getDouble("x"), s.getDouble("y"), s.getDouble("z"), (float)s.getDouble("yaw"), 0.0f);
                String ent = s.getString("entity");
                n.entity = ent == null ? null : UUID.fromString(ent);
                n.hubText = s.getString("hub.text", "");
                n.tradeLabel = s.getString("hub.trade", "");
                n.dialogLabel = s.getString("hub.dialog", "");
                n.questLabel = s.getString("hub.quest", "");
                n.menuMode = Math.max(0, Math.min(2, s.getInt("hub.mode", 0)));
                this.loadTree(s, n);
                for (Map m : s.getMapList("trades")) {
                    Object p1 = m.get("p1");
                    Object p2 = m.get("p2");
                    Object r = m.get("r");
                    if (p1 == null || r == null) continue;
                    try {
                        n.trades.add(new Trade(this.decode(p1.toString()), p2 == null ? null : this.decode(p2.toString()), this.decode(r.toString())));
                    }
                    catch (RuntimeException ex) {
                        this.getLogger().warning("\u041d\u0435 \u0432\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0442\u0438 \u0443\u0433\u043e\u0434\u0443 NPC " + key);
                    }
                }
                this.npcs.put(n.id, n);
                this.nextId = Math.max(this.nextId, n.id + 1);
            }
            catch (IllegalArgumentException ex) {
                this.getLogger().warning("\u041f\u0440\u043e\u043f\u0443\u0441\u043a\u0430\u044e \u043f\u043e\u0448\u043a\u043e\u0434\u0436\u0435\u043d\u0438\u0439 \u0437\u0430\u043f\u0438\u0441 NPC " + key);
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
            co.addProperty("uid", c.uid);
            co.add("node", (JsonElement)this.nodeToJson(c.next));
            arr.add((JsonElement)co);
        }
        o.add("choices", (JsonElement)arr);
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
                Choice ch = new Choice(label, action, cond, this.nodeFromJson(co.getAsJsonObject("node"), node, label, depth + 1));
                if (co.has("uid")) {
                    ch.uid = co.get("uid").getAsString();
                } else {
                    this.uidGenerated = true;
                }
                node.choices.add(ch);
            }
        }
        return node;
    }

    private void loadTree(ConfigurationSection s, Npc n) {
        String tree = s.getString("tree");
        if (tree != null) {
            try {
                n.root = this.nodeFromJson(JsonParser.parseString((String)tree).getAsJsonObject(), null, "", 0);
            }
            catch (RuntimeException ex) {
                this.getLogger().warning("\u041f\u043e\u0448\u043a\u043e\u0434\u0436\u0435\u043d\u0438\u0439 \u0434\u0456\u0430\u043b\u043e\u0433 NPC " + n.id + ", \u0441\u043a\u0438\u043d\u0443\u0442\u043e \u0434\u043e \u0442\u0438\u043f\u043e\u0432\u043e\u0433\u043e.");
            }
            return;
        }
        n.root = new Node(s.getString("greeting", "..."), null, "");
        for (Map m : s.getMapList("options")) {
            Object label = m.get("label");
            Object reply = m.get("reply");
            if (label == null || label.toString().isBlank()) continue;
            String l = label.toString();
            n.root.choices.add(new Choice(l, "", "", new Node(reply == null ? "..." : reply.toString(), n.root, l)));
        }
    }

    private static String ms(Map<?, ?> m, String k, String d) {
        Object o = m.get(k);
        return o == null ? d : o.toString();
    }

    private static double md(Map<?, ?> m, String k, double d) {
        Object o = m.get(k);
        if (o instanceof Number) {
            Number num = (Number)o;
            return num.doubleValue();
        }
        if (o != null) {
            try {
                return Double.parseDouble(o.toString());
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        return d;
    }

    private void loadQuests() {
        this.quests.clear();
        if (!this.questsFile.exists()) {
            return;
        }
        YamlConfiguration y = YamlConfiguration.loadConfiguration((File)this.questsFile);
        ConfigurationSection sec = y.getConfigurationSection("quests");
        if (sec == null) {
            return;
        }
        for (String rawId : sec.getKeys(false)) {
            String id = rawId.toLowerCase(Locale.ROOT);
            ConfigurationSection s = sec.getConfigurationSection(rawId);
            if (s == null) continue;
            if (!id.matches("[a-z0-9_\\-]+")) {
                this.getLogger().warning("\u041a\u0432\u0435\u0441\u0442 \"" + rawId + "\": id \u043c\u0430\u0454 \u0441\u043a\u043b\u0430\u0434\u0430\u0442\u0438\u0441\u044c \u0437 a-z, 0-9, _ \u0442\u0430 -. \u041f\u0440\u043e\u043f\u0443\u0449\u0435\u043d\u043e.");
                continue;
            }
            Quest q = new Quest();
            q.id = id;
            q.name = s.getString("name", id);
            q.description = s.getString("description", "");
            q.repeatable = s.getBoolean("repeatable", false);
            q.turnIn = s.getBoolean("turn-in", false);
            q.cooldown = Math.max(0L, s.getLong("cooldown", 0L));
            q.xp = s.getInt("rewards.xp", 0);
            q.items = s.getStringList("rewards.items");
            q.stacks = new ArrayList<>(s.getStringList("rewards.stacks"));
            q.commands = s.getStringList("rewards.commands");
            boolean valid = true;
            int index = 0;
            for (Map m : s.getMapList("stages")) {
                ++index;
                Stage sg = new Stage();
                sg.type = QuestNPC.ms(m, "type", "").toLowerCase(Locale.ROOT);
                sg.text = QuestNPC.ms(m, "text", "");
                sg.reply = QuestNPC.ms(m, "reply", "");
                sg.replyFail = QuestNPC.ms(m, "reply-fail", "");
                switch (sg.type) {
                    case "reach": {
                        sg.world = QuestNPC.ms(m, "world", "world");
                        sg.x = QuestNPC.md(m, "x", 0.0);
                        sg.y = QuestNPC.md(m, "y", 64.0);
                        sg.z = QuestNPC.md(m, "z", 0.0);
                        sg.radius = QuestNPC.md(m, "radius", 5.0);
                        sg.height = QuestNPC.md(m, "height", -1.0);
                        break;
                    }
                    case "kill": {
                        try {
                            sg.entity = EntityType.valueOf((String)QuestNPC.ms(m, "entity", "").toUpperCase(Locale.ROOT));
                        }
                        catch (IllegalArgumentException ex) {
                            this.getLogger().warning("\u041a\u0432\u0435\u0441\u0442 " + id + ", \u0435\u0442\u0430\u043f " + index + ": \u043d\u0435\u0432\u0456\u0434\u043e\u043c\u0438\u0439 entity.");
                            valid = false;
                        }
                        sg.amount = (int)QuestNPC.md(m, "amount", 1.0);
                        break;
                    }
                    case "deliver": {
                        sg.material = Material.matchMaterial((String)QuestNPC.ms(m, "material", ""));
                        if (sg.material == null) {
                            this.getLogger().warning("\u041a\u0432\u0435\u0441\u0442 " + id + ", \u0435\u0442\u0430\u043f " + index + ": \u043d\u0435\u0432\u0456\u0434\u043e\u043c\u0438\u0439 material.");
                            valid = false;
                        }
                        sg.amount = (int)QuestNPC.md(m, "amount", 1.0);
                        sg.npc = (int)QuestNPC.md(m, "npc", -1.0);
                        break;
                    }
                    case "item": {
                        sg.stack = QuestNPC.ms(m, "stack", "");
                        sg.amount = (int)QuestNPC.md(m, "amount", 1.0);
                        sg.npc = (int)QuestNPC.md(m, "npc", -1.0);
                        try {
                            this.decode(sg.stack);
                        } catch (RuntimeException ex2) {
                            this.getLogger().warning("Квест " + id + ", етап " + index + ": пошкоджений предмет (stack).");
                            valid = false;
                        }
                        break;
                    }
                    case "talk": {
                        sg.npc = (int)QuestNPC.md(m, "npc", -1.0);
                        break;
                    }
                    default: {
                        this.getLogger().warning("\u041a\u0432\u0435\u0441\u0442 " + id + ", \u0435\u0442\u0430\u043f " + index + ": \u043d\u0435\u0432\u0456\u0434\u043e\u043c\u0438\u0439 type \"" + sg.type + "\".");
                        valid = false;
                    }
                }
                q.stages.add(sg);
            }
            if (!valid || q.stages.isEmpty()) {
                this.getLogger().warning("\u041a\u0432\u0435\u0441\u0442 " + id + " \u043f\u0440\u043e\u043f\u0443\u0449\u0435\u043d\u043e \u0447\u0435\u0440\u0435\u0437 \u043f\u043e\u043c\u0438\u043b\u043a\u0438 \u0432 \u0435\u0442\u0430\u043f\u0430\u0445.");
                continue;
            }
            this.quests.put(id, q);
        }
        this.getLogger().info("\u0417\u0430\u0432\u0430\u043d\u0442\u0430\u0436\u0435\u043d\u043e \u043a\u0432\u0435\u0441\u0442\u0456\u0432: " + this.quests.size());
    }

    private void loadProgress() {
        this.progress.clear();
        if (!this.progressFile.exists()) {
            return;
        }
        YamlConfiguration y = YamlConfiguration.loadConfiguration((File)this.progressFile);
        this.choiceUses.clear();
        this.tracked.clear();
        this.hudOff.clear();
        ConfigurationSection us = y.getConfigurationSection("uses");
        if (us != null) {
            for (String u : us.getKeys(false)) {
                try {
                    ConfigurationSection uc = us.getConfigurationSection(u);
                    if (uc == null) continue;
                    Map<String, Long> mm = new HashMap<>();
                    for (String k : uc.getKeys(false)) {
                        mm.put(k, uc.getLong(k));
                    }
                    this.choiceUses.put(UUID.fromString(u), mm);
                } catch (IllegalArgumentException ignored) { }
            }
        }
        ConfigurationSection ts = y.getConfigurationSection("tracked");
        if (ts != null) {
            for (String u : ts.getKeys(false)) {
                try {
                    this.tracked.put(UUID.fromString(u), ts.getString(u, ""));
                } catch (IllegalArgumentException ignored) { }
            }
        }
        for (String u : y.getStringList("hud-off")) {
            try {
                this.hudOff.add(UUID.fromString(u));
            } catch (IllegalArgumentException ignored) { }
        }
        ConfigurationSection players = y.getConfigurationSection("players");
        if (players == null) {
            return;
        }
        for (String uuidStr : players.getKeys(false)) {
            ConfigurationSection ps = players.getConfigurationSection(uuidStr);
            if (ps == null) continue;
            try {
                UUID uuid = UUID.fromString(uuidStr);
                LinkedHashMap<String, QState> map = new LinkedHashMap<String, QState>();
                for (String qid : ps.getKeys(false)) {
                    ConfigurationSection qs = ps.getConfigurationSection(qid);
                    if (qs == null) continue;
                    QState st = new QState();
                    st.status = qs.getString("status", "ACTIVE");
                    st.stage = qs.getInt("stage", 0);
                    st.count = qs.getInt("count", 0);
                    st.doneAt = qs.getLong("doneAt", 0L);
                    map.put(qid, st);
                }
                this.progress.put(uuid, map);
            }
            catch (IllegalArgumentException illegalArgumentException) {}
        }
    }

    private void saveProgress() {
        this.progressDirty = false;
        YamlConfiguration y = new YamlConfiguration();
        for (Map.Entry<UUID, Map<String, QState>> pe : this.progress.entrySet()) {
            for (Map.Entry<String, QState> qe : pe.getValue().entrySet()) {
                String b = "players." + String.valueOf(pe.getKey()) + "." + qe.getKey() + ".";
                y.set(b + "status", (Object)qe.getValue().status);
                y.set(b + "stage", (Object)qe.getValue().stage);
                y.set(b + "count", (Object)qe.getValue().count);
                y.set(b + "doneAt", (Object)qe.getValue().doneAt);
            }
        }
        for (Map.Entry<UUID, Map<String, Long>> ue : this.choiceUses.entrySet()) {
            for (Map.Entry<String, Long> use : ue.getValue().entrySet()) {
                y.set("uses." + ue.getKey() + "." + use.getKey(), use.getValue());
            }
        }
        for (Map.Entry<UUID, String> te : this.tracked.entrySet()) {
            y.set("tracked." + te.getKey(), te.getValue());
        }
        y.set("hud-off", this.hudOff.stream().map(UUID::toString).toList());
        try {
            y.save(this.progressFile);
        }
        catch (IOException ex) {
            this.getLogger().severe("\u041d\u0435 \u0432\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0431\u0435\u0440\u0435\u0433\u0442\u0438 progress.yml: " + ex.getMessage());
        }
    }

    public boolean onCommand(CommandSender s, Command command, String label, String[] a) {
        String sub;
        if (command.getName().equalsIgnoreCase("quests")) {
            if (s instanceof Player) {
                Player p = (Player)s;
                this.openJournal(p);
            } else {
                s.sendMessage("\u0422\u0456\u043b\u044c\u043a\u0438 \u0434\u043b\u044f \u0433\u0440\u0430\u0432\u0446\u0456\u0432.");
            }
            return true;
        }
        if (!s.hasPermission("questnpc.admin")) {
            s.sendMessage("\u00a7c\u041d\u0435\u043c\u0430\u0454 \u043f\u0440\u0430\u0432.");
            return true;
        }
        switch (sub = a.length == 0 ? "give" : a[0].toLowerCase()) {
            case "give": {
                final Player target = a.length > 1 ? Bukkit.getPlayerExact(a[1]) : (s instanceof Player pl ? pl : null);
                if (target == null) {
                    s.sendMessage("\u00a7c\u0413\u0440\u0430\u0432\u0446\u044f \u043d\u0435 \u0437\u043d\u0430\u0439\u0434\u0435\u043d\u043e.");
                    return true;
                }
                target.getInventory().addItem(new ItemStack[]{this.createWand()}).values().forEach(rest -> target.getWorld().dropItemNaturally(target.getLocation(), rest));
                s.sendMessage("\u00a7a\u041c\u0456\u0437\u043a\u043e\u043f\u0440\u0430\u0432 \u0432\u0438\u0434\u0430\u043d\u043e \u0433\u0440\u0430\u0432\u0446\u044e " + target.getName() + ".");
                break;
            }
            case "list": {
                s.sendMessage("\u00a7aNPC: \u00a7f" + this.npcs.size());
                for (Npc n : this.npcs.values()) {
                    s.sendMessage("\u00a77#" + n.id + " \u00a7f" + n.name + " \u00a78(" + n.loc.getWorld().getName() + " " + n.loc.getBlockX() + " " + n.loc.getBlockY() + " " + n.loc.getBlockZ() + ")");
                }
                break;
            }
            case "remove": {
                Npc n = this.byArg(a);
                if (n == null) {
                    s.sendMessage("\u00a7c\u0412\u043a\u0430\u0436\u0438 \u043d\u043e\u043c\u0435\u0440 NPC \u0437 /mizkoprav list.");
                    return true;
                }
                this.removeNpc(n);
                s.sendMessage("\u00a7aNPC #" + n.id + " \u0432\u0438\u0434\u0430\u043b\u0435\u043d\u043e.");
                break;
            }
            case "tp": {
                Npc n = this.byArg(a);
                if (n == null || !(s instanceof Player)) {
                    s.sendMessage("\u00a7c\u0412\u043a\u0430\u0436\u0438 \u043d\u043e\u043c\u0435\u0440 NPC \u0437 /mizkoprav list (\u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u0434\u043b\u044f \u0433\u0440\u0430\u0432\u0446\u0456\u0432).");
                    return true;
                }
                Player p = (Player)s;
                p.teleportAsync(n.loc);
                break;
            }
            case "here": {
                if (!(s instanceof Player)) {
                    s.sendMessage("\u0422\u0456\u043b\u044c\u043a\u0438 \u0434\u043b\u044f \u0433\u0440\u0430\u0432\u0446\u0456\u0432.");
                    return true;
                }
                Player p = (Player)s;
                Location l = p.getLocation();
                s.sendMessage("\u00a7a\u0422\u0432\u043e\u044f \u043f\u043e\u0437\u0438\u0446\u0456\u044f \u0434\u043b\u044f quests.yml:");
                s.sendMessage("\u00a7fworld: " + l.getWorld().getName());
                s.sendMessage("\u00a7fx: " + l.getBlockX() + "  y: " + l.getBlockY() + "  z: " + l.getBlockZ());
                break;
            }
            case "quests": {
                s.sendMessage("\u00a7a\u041a\u0432\u0435\u0441\u0442\u0456\u0432: \u00a7f" + this.quests.size());
                for (Quest q : this.quests.values()) {
                    s.sendMessage("\u00a77" + q.id + " \u00a7f" + q.name + " \u00a78(\u0435\u0442\u0430\u043f\u0456\u0432: " + q.stages.size() + (q.turnIn ? ", \u0437\u0456 \u0437\u0434\u0430\u0447\u0435\u044e" : "") + ")");
                }
                break;
            }
            case "editor", "quest": {
                if (!(s instanceof Player)) {
                    s.sendMessage("Тільки для гравців.");
                    return true;
                }
                this.openQuestList((Player)s);
                break;
            }
            case "reload": {
                this.reloadConfig();
                this.loadQuests();
                s.sendMessage("\u00a7aquests.yml \u043f\u0435\u0440\u0435\u0437\u0430\u0432\u0430\u043d\u0442\u0430\u0436\u0435\u043d\u043e. \u041a\u0432\u0435\u0441\u0442\u0456\u0432: " + this.quests.size());
                break;
            }
            default: {
                s.sendMessage("\u00a7e/mizkoprav [give|list|remove <\u2116>|tp <\u2116>|here|quests|editor|reload]");
            }
        }
        return true;
    }

    // ======================= РЕДАКТОР КВЕСТІВ У ГРІ =======================

    private static final String QUESTS_HEADER = String.join("\n",
        "# Квести QuestNPC. Файл можна редагувати в грі: /mizkoprav editor",
        "# (при збереженні з гри коментарі в цьому файлі перезаписуються).",
        "#",
        "# Типи етапів: reach (дійти до зони), kill (вбити істот),",
        "#              deliver (принести предмети NPC), talk (поговорити з NPC).",
        "# turn-in: true - після останнього етапу квест чекає здачі (дія turnin:<id>).",
        "# У діалозі NPC: дія quest:<id> (взяти), turnin:<id> (здати).",
        "# Умови кнопок: new:<id>, active:<id>, ready:<id>, done:<id>; перед умовою можна ставити !",
        "", "");

    private void saveQuests() {
        YamlConfiguration y = new YamlConfiguration();
        for (Quest q : this.quests.values()) {
            String b = "quests." + q.id + ".";
            y.set(b + "name", q.name);
            y.set(b + "description", q.description);
            y.set(b + "repeatable", q.repeatable);
            y.set(b + "turn-in", q.turnIn);
            y.set(b + "cooldown", q.cooldown);
            List<Map<String, Object>> st = new ArrayList<>();
            for (Stage sg : q.stages) {
                Map<String, Object> m = new LinkedHashMap<>();
                m.put("type", sg.type);
                m.put("text", sg.text);
                if (!sg.reply.isBlank()) {
                    m.put("reply", sg.reply);
                }
                if (!sg.replyFail.isBlank()) {
                    m.put("reply-fail", sg.replyFail);
                }
                switch (sg.type) {
                    case "reach" -> {
                        m.put("world", sg.world);
                        m.put("x", sg.x);
                        m.put("y", sg.y);
                        m.put("z", sg.z);
                        m.put("radius", sg.radius);
                        if (sg.height >= 0.0) {
                            m.put("height", sg.height);
                        }
                    }
                    case "kill" -> {
                        m.put("entity", sg.entity == null ? "ZOMBIE" : sg.entity.name());
                        m.put("amount", sg.amount);
                    }
                    case "deliver" -> {
                        m.put("material", sg.material == null ? "STONE" : sg.material.name());
                        m.put("amount", sg.amount);
                        m.put("npc", sg.npc);
                    }
                    case "item" -> {
                        m.put("stack", sg.stack);
                        m.put("amount", sg.amount);
                        m.put("npc", sg.npc);
                    }
                    case "talk" -> m.put("npc", sg.npc);
                    default -> { }
                }
                st.add(m);
            }
            y.set(b + "stages", st);
            y.set(b + "rewards.xp", q.xp);
            y.set(b + "rewards.items", q.items);
            y.set(b + "rewards.stacks", q.stacks);
            y.set(b + "rewards.commands", q.commands);
        }
        try {
            java.nio.file.Files.writeString(this.questsFile.toPath(), QUESTS_HEADER + y.saveToString(),
                java.nio.charset.StandardCharsets.UTF_8);
        } catch (IOException ex) {
            this.getLogger().severe("Не вдалося зберегти quests.yml: " + ex.getMessage());
        }
    }

    private static String num(double d) {
        return d == Math.rint(d) ? String.valueOf((long) d) : String.format(Locale.ROOT, "%.1f", d);
    }

    private static List<String> lines(String raw) {
        List<String> out = new ArrayList<>();
        if (raw == null) {
            return out;
        }
        for (String s : raw.split("\\R")) {
            if (!s.isBlank()) {
                out.add(s.trim());
            }
        }
        return out;
    }

    private static String stageLabel(String type) {
        return switch (type) {
            case "reach" -> "Дійти до зони";
            case "kill" -> "Вбити";
            case "deliver" -> "Принести предмети";
            case "item" -> "Принести предмет з лівої руки";
            case "talk" -> "Поговорити з NPC";
            default -> type;
        };
    }

    private void openQuestList(Player p) {
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&a+ Новий квест", v -> this.sync(() -> this.openQuestNew(p))));
        for (Quest q : this.quests.values()) {
            buttons.add(this.btn(q.name + " &8(" + q.id + ")", v -> this.sync(() -> this.openQuestEditor(p, q))));
        }
        p.showDialog((DialogLike) this.dialog("&5Квести",
            List.of(this.para("Квестів: " + this.quests.size() + ". Обери квест, щоб змінити, або створи новий.")),
            List.of(),
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Закрити", null), (int) 1)));
    }

    /** Перетворює текст (у т.ч. українською) на id квесту: малі латинські літери, цифри, _ і -. */
    private static String slug(String in) {
        StringBuilder sb = new StringBuilder();
        for (char ch : in.toLowerCase(Locale.ROOT).toCharArray()) {
            String r = switch (ch) {
                case 'а' -> "a"; case 'б' -> "b"; case 'в' -> "v"; case 'г' -> "h"; case 'ґ' -> "g";
                case 'д' -> "d"; case 'е' -> "e"; case 'є' -> "ye"; case 'ж' -> "zh"; case 'з' -> "z";
                case 'и' -> "y"; case 'і' -> "i"; case 'ї' -> "yi"; case 'й' -> "y"; case 'к' -> "k";
                case 'л' -> "l"; case 'м' -> "m"; case 'н' -> "n"; case 'о' -> "o"; case 'п' -> "p";
                case 'р' -> "r"; case 'с' -> "s"; case 'т' -> "t"; case 'у' -> "u"; case 'ф' -> "f";
                case 'х' -> "kh"; case 'ц' -> "ts"; case 'ч' -> "ch"; case 'ш' -> "sh"; case 'щ' -> "shch";
                case 'ю' -> "yu"; case 'я' -> "ya"; case 'ы' -> "y"; case 'э' -> "e"; case 'ё' -> "yo";
                case 'ь', 'ъ', '\'', '’', 'ʼ' -> "";
                default -> (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == '-' ? String.valueOf(ch) : "_";
            };
            sb.append(r);
        }
        String s = sb.toString().replaceAll("_+", "_").replaceAll("^[_\\-]+|[_\\-]+$", "");
        if (s.length() > 32) {
            s = s.substring(0, 32).replaceAll("[_\\-]+$", "");
        }
        return s.isEmpty() ? "quest" : s;
    }

    private void openQuestNew(Player p) {
        this.openQuestNew(p, "", "");
    }

    private void openQuestNew(Player p, String keepId, String keepName) {
        ConfirmationType type = DialogType.confirmation(
            (ActionButton) this.btn("&aСтворити", v -> this.sync(() -> {
                String rawId = QuestNPC.clean(v.apply("questid"), "");
                String name = QuestNPC.clean(v.apply("questname"), "");
                try {
                    if (rawId.isEmpty() && name.isEmpty()) {
                        p.sendMessage(this.text("&cВведи назву квесту (id можна залишити порожнім)."));
                        this.openQuestNew(p, rawId, name);
                        return;
                    }
                    String base = QuestNPC.slug(rawId.isEmpty() ? name : rawId);
                    String id = base;
                    if (rawId.isEmpty()) {
                        int i = 2;
                        while (this.quests.containsKey(id)) {
                            id = base + "_" + i++;
                        }
                    } else if (this.quests.containsKey(id)) {
                        p.sendMessage(this.text("&cКвест з id &f" + id + "&c уже є. Обери інший id."));
                        this.openQuestNew(p, rawId, name);
                        return;
                    }
                    Quest q = new Quest();
                    q.id = id;
                    q.name = name.isEmpty() ? id : name;
                    Stage sg = new Stage();
                    sg.type = "reach";
                    sg.text = "Дійди до зони";
                    this.fillHere(sg, p);
                    q.stages.add(sg);
                    this.quests.put(id, q);
                    this.saveQuests();
                    p.sendMessage(this.text("&aКвест створено. id: &f" + id + "&a. Додай етапи й нагороди."));
                    this.openQuestEditor(p, q);
                } catch (RuntimeException ex) {
                    this.getLogger().log(java.util.logging.Level.SEVERE, "Не вдалося створити квест", ex);
                    p.sendMessage(this.text("&cПомилка створення квесту: &f" + ex));
                }
            })),
            (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openQuestList(p))));
        p.showDialog((DialogLike) this.dialog("&5Новий квест",
            List.of(this.para("Достатньо написати назву. Порожнє id створиться з назви автоматично (українські літери перетворюються на латинські). Квест одразу отримає один етап «дійти до зони» у твоїй позиції - зміниш його далі.")),
            List.of(this.line("questname", "Назва квесту", keepName, 60),
                    this.line("questid", "id (необов'язково; a-z, 0-9, _ , -)", keepId, 32)),
            (DialogType) type));
    }

    private void applyQuestFields(Player p, Quest q, Function<String, String> v) {
        q.name = QuestNPC.clean(v.apply("name"), q.id);
        q.description = QuestNPC.clean(v.apply("description"), "");
        try {
            q.xp = Math.max(0, Integer.parseInt(QuestNPC.clean(v.apply("xp"), "0")));
        } catch (NumberFormatException ex) {
            p.sendMessage(this.text("&cДосвід має бути цілим числом - залишено попереднє значення."));
        }
        q.cooldown = QuestNPC.parseDuration(v.apply("cooldown"));
        List<String> items = new ArrayList<>();
        for (String entry : QuestNPC.lines(v.apply("items"))) {
            if (Material.matchMaterial(entry.split(":")[0].trim()) == null) {
                this.suggestItems(p, entry.split(":")[0]);
                continue;
            }
            items.add(entry);
        }
        q.items = items;
        List<String> cmds = new ArrayList<>();
        for (String c : QuestNPC.lines(v.apply("commands"))) {
            cmds.add(c.startsWith("/") ? c.substring(1) : c);
        }
        q.commands = cmds;
    }

    private void openQuestEditor(Player p, Quest q) {
        List<DialogInput> inputs = new ArrayList<>();
        inputs.add(this.line("name", "Назва квесту", q.name, 60));
        inputs.add(this.block("description", "Опис", q.description, 500));
        inputs.add(this.line("xp", "Нагорода: досвід", String.valueOf(q.xp), 7));
        inputs.add(this.line("cooldown", "Кулдаун повтору (напр. 30m, 12h, 1d; 0 = без; працює для повторюваних)", q.cooldown > 0L ? q.cooldown + "s" : "0", 12));
        inputs.add(this.block("items", "Нагорода: предмети (МАТЕРІАЛ:кількість, кожен з нового рядка)",
            String.join("\n", q.items), 500));
        inputs.add(this.block("commands", "Нагорода: команди від консолі ({player} = нік, по одній в рядок)",
            String.join("\n", q.commands), 500));
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&aЗберегти", v -> this.sync(() -> {
            this.applyQuestFields(p, q, v);
            this.saveQuests();
            p.sendMessage(this.text("&aКвест збережено."));
            this.openQuestEditor(p, q);
        })));
        buttons.add(this.btn("Етапи: " + q.stages.size(), v -> this.sync(() -> {
            this.applyQuestFields(p, q, v);
            this.saveQuests();
            this.openStages(p, q);
        })));
        buttons.add(this.btn("&dНагорода: предмет з лівої руки (+) &7[" + q.stacks.size() + "]", v -> this.sync(() -> {
            this.applyQuestFields(p, q, v);
            ItemStack held = p.getInventory().getItemInOffHand();
            if (held.getType().isAir()) {
                p.sendMessage(this.text("&cПоклади в ліву руку (клавіша F міняє руки) предмет, який хочеш додати в нагороду."));
            } else {
                q.stacks.add(this.encode(held.clone()));
                p.sendMessage(this.text("&aПредмет додано в нагороду (зачарування й назва збережені): &f" + held.getType().name() + " x" + held.getAmount()));
            }
            this.saveQuests();
            this.openQuestEditor(p, q);
        })));
        if (!q.stacks.isEmpty()) {
            buttons.add(this.btn("&cОчистити предмети з лівої руки", v -> this.sync(() -> {
                this.applyQuestFields(p, q, v);
                q.stacks.clear();
                this.saveQuests();
                this.openQuestEditor(p, q);
            })));
        }
        buttons.add(this.btn("Повторюваний: " + (q.repeatable ? "&aтак" : "&cні"), v -> this.sync(() -> {
            this.applyQuestFields(p, q, v);
            q.repeatable = !q.repeatable;
            this.saveQuests();
            this.openQuestEditor(p, q);
        })));
        buttons.add(this.btn("Здача NPC: " + (q.turnIn ? "&aтак" : "&cні (нагорода одразу)"), v -> this.sync(() -> {
            this.applyQuestFields(p, q, v);
            q.turnIn = !q.turnIn;
            this.saveQuests();
            this.openQuestEditor(p, q);
        })));
        buttons.add(this.btn("&cВидалити квест", v -> this.sync(() -> this.openQuestDelete(p, q))));
        p.showDialog((DialogLike) this.dialog("&5Квест: " + q.id,
            List.of(this.para("У діалозі NPC: дія &equest:" + q.id + "&r - взяти, &eturnin:" + q.id + "&r - здати.")),
            inputs,
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openQuestList(p))), (int) 1)));
    }

    private void openQuestDelete(Player p, Quest q) {
        ConfirmationType type = DialogType.confirmation(
            (ActionButton) this.btn("&cТак, видалити", v -> this.sync(() -> {
                this.quests.remove(q.id);
                this.saveQuests();
                p.sendMessage(this.text("&aКвест видалено."));
                this.openQuestList(p);
            })),
            (ActionButton) this.btn("&7Ні", v -> this.sync(() -> this.openQuestEditor(p, q))));
        p.showDialog((DialogLike) this.dialog("&cВидалити квест?",
            List.of(this.para("Квест «" + q.name + "» (" + q.id + ") буде видалено. Кнопки NPC з цим id перестануть працювати.")),
            List.of(), (DialogType) type));
    }

    private void openStages(Player p, Quest q) {
        List<ActionButton> buttons = new ArrayList<>();
        for (int i = 0; i < q.stages.size(); i++) {
            final int idx = i;
            Stage sg = q.stages.get(i);
            buttons.add(this.btn((i + 1) + ". " + QuestNPC.stageLabel(sg.type) + ": &7" + sg.text,
                v -> this.sync(() -> this.openStageEditor(p, q, idx))));
        }
        for (String t : new String[]{"reach", "kill", "deliver", "item", "talk"}) {
            buttons.add(this.btn("&a+ " + QuestNPC.stageLabel(t), v -> this.sync(() -> {
                Stage sg = new Stage();
                sg.type = t;
                sg.text = QuestNPC.stageLabel(t);
                if (t.equals("reach")) {
                    this.fillHere(sg, p);
                } else if (t.equals("kill")) {
                    sg.entity = EntityType.ZOMBIE;
                } else if (t.equals("deliver")) {
                    sg.material = Material.STONE;
                } else if (t.equals("item")) {
                    ItemStack held = p.getInventory().getItemInOffHand();
                    if (held.getType().isAir()) {
                        p.sendMessage(this.text("&cПоклади в ліву руку (клавіша F міняє руки) предмет, який треба принести NPC, і натисни ще раз."));
                        this.openStages(p, q);
                        return;
                    }
                    sg.stack = this.encode(held.clone());
                    sg.amount = held.getAmount();
                    sg.material = held.getType();
                }
                q.stages.add(sg);
                this.saveQuests();
                this.openStageEditor(p, q, q.stages.size() - 1);
            })));
        }
        p.showDialog((DialogLike) this.dialog("&5Етапи: " + q.name,
            List.of(this.para("Етапи проходяться по черзі. Зміна порядку чи видалення етапу зсуває прогрес гравців, які вже проходять цей квест.")),
            List.of(),
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openQuestEditor(p, q))), (int) 1)));
    }

    private void fillHere(Stage sg, Player p) {
        Location l = p.getLocation();
        sg.world = l.getWorld().getName();
        sg.x = l.getBlockX();
        sg.y = l.getBlockY();
        sg.z = l.getBlockZ();
    }

    private boolean applyStage(Player p, Stage sg, Function<String, String> v) {
        try {
            String text = QuestNPC.clean(v.apply("text"), QuestNPC.stageLabel(sg.type));
            switch (sg.type) {
                case "reach" -> {
                    String world = QuestNPC.clean(v.apply("world"), sg.world);
                    if (Bukkit.getWorld(world) == null) {
                        p.sendMessage(this.text("&cСвіт \"" + world + "\" не знайдено."));
                        return false;
                    }
                    double x = Double.parseDouble(QuestNPC.clean(v.apply("x"), "0").replace(',', '.'));
                    double y = Double.parseDouble(QuestNPC.clean(v.apply("y"), "64").replace(',', '.'));
                    double z = Double.parseDouble(QuestNPC.clean(v.apply("z"), "0").replace(',', '.'));
                    double radius = Math.max(1.0, Double.parseDouble(QuestNPC.clean(v.apply("radius"), "5").replace(',', '.')));
                    String hs = QuestNPC.clean(v.apply("height"), "");
                    sg.world = world;
                    sg.x = x;
                    sg.y = y;
                    sg.z = z;
                    sg.radius = radius;
                    sg.height = hs.isEmpty() ? -1.0 : Math.max(0.0, Double.parseDouble(hs.replace(',', '.')));
                }
                case "kill" -> {
                    EntityType et = EntityType.valueOf(QuestNPC.clean(v.apply("entity"), "ZOMBIE").toUpperCase(Locale.ROOT));
                    sg.entity = et;
                    sg.amount = Math.max(1, Integer.parseInt(QuestNPC.clean(v.apply("amount"), "1")));
                }
                case "deliver" -> {
                    Material m = Material.matchMaterial(QuestNPC.clean(v.apply("material"), ""));
                    if (m == null) {
                        this.suggestItems(p, QuestNPC.clean(v.apply("material"), ""));
                        return false;
                    }
                    sg.material = m;
                    sg.amount = Math.max(1, Integer.parseInt(QuestNPC.clean(v.apply("amount"), "1")));
                    sg.npc = Integer.parseInt(QuestNPC.clean(v.apply("npc"), "-1"));
                    if (!this.npcs.containsKey(sg.npc)) {
                        p.sendMessage(this.text("&eУвага: NPC #" + sg.npc + " не існує."));
                    }
                }
                case "item" -> {
                    sg.amount = Math.max(1, Integer.parseInt(QuestNPC.clean(v.apply("amount"), "1")));
                    sg.npc = Integer.parseInt(QuestNPC.clean(v.apply("npc"), "-1"));
                    if (!this.npcs.containsKey(sg.npc)) {
                        p.sendMessage(this.text("&eУвага: NPC #" + sg.npc + " не існує."));
                    }
                }
                case "talk" -> {
                    sg.npc = Integer.parseInt(QuestNPC.clean(v.apply("npc"), "-1"));
                    if (!this.npcs.containsKey(sg.npc)) {
                        p.sendMessage(this.text("&eУвага: NPC #" + sg.npc + " не існує."));
                    }
                }
                default -> { }
            }
            if (sg.type.equals("deliver") || sg.type.equals("item") || sg.type.equals("talk")) {
                sg.reply = QuestNPC.clean(v.apply("reply"), "");
                sg.replyFail = QuestNPC.clean(v.apply("replyfail"), "");
            }
            sg.text = text;
            return true;
        } catch (IllegalArgumentException ex) {
            p.sendMessage(this.text("&cНевірне значення (число або назва істоти) - зміни не збережено."));
            return false;
        }
    }

    private void openStageEditor(Player p, Quest q, int idx) {
        Stage sg = q.stages.get(idx);
        List<DialogInput> inputs = new ArrayList<>();
        inputs.add(this.line("text", "Текст етапу (що бачить гравець)", sg.text, 80));
        switch (sg.type) {
            case "reach" -> {
                inputs.add(this.line("world", "Світ", sg.world, 40));
                inputs.add(this.line("x", "X", QuestNPC.num(sg.x), 12));
                inputs.add(this.line("y", "Y", QuestNPC.num(sg.y), 12));
                inputs.add(this.line("z", "Z", QuestNPC.num(sg.z), 12));
                inputs.add(this.line("radius", "Радіус (по горизонталі)", QuestNPC.num(sg.radius), 8));
                inputs.add(this.line("height", "Допуск по висоті (порожньо = без обмеження)",
                    sg.height < 0.0 ? "" : QuestNPC.num(sg.height), 8));
            }
            case "kill" -> {
                inputs.add(this.line("entity", "Істота (EntityType, напр. ZOMBIE)", sg.entity == null ? "ZOMBIE" : sg.entity.name(), 40));
                inputs.add(this.line("amount", "Кількість", String.valueOf(sg.amount), 5));
            }
            case "deliver" -> {
                inputs.add(this.line("material", "Предмет (напр. DIAMOND)", sg.material == null ? "" : sg.material.name(), 40));
                inputs.add(this.line("amount", "Кількість", String.valueOf(sg.amount), 5));
                inputs.add(this.line("npc", "№ NPC, якому віддати", String.valueOf(sg.npc), 5));
            }
            case "item" -> {
                inputs.add(this.line("amount", "Кількість", String.valueOf(sg.amount), 5));
                inputs.add(this.line("npc", "№ NPC, якому віддати", String.valueOf(sg.npc), 5));
            }
            case "talk" -> inputs.add(this.line("npc", "№ NPC, з яким поговорити", String.valueOf(sg.npc), 5));
            default -> { }
        }
        if (sg.type.equals("deliver") || sg.type.equals("item") || sg.type.equals("talk")) {
            inputs.add(this.block("reply", "Відповідь NPC після виконання (порожньо = звичайне меню)", sg.reply, 300));
            if (!sg.type.equals("talk")) {
                inputs.add(this.block("replyfail", "Відповідь NPC, якщо предмета немає (порожньо = лише повідомлення в чаті)", sg.replyFail, 300));
            }
        }
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&aЗберегти", v -> this.sync(() -> {
            if (this.applyStage(p, sg, v)) {
                this.saveQuests();
                p.sendMessage(this.text("&aЕтап збережено."));
            }
            this.openStageEditor(p, q, idx);
        })));
        if (sg.type.equals("reach")) {
            buttons.add(this.btn("Взяти мою позицію", v -> this.sync(() -> {
                this.applyStage(p, sg, v);
                this.fillHere(sg, p);
                this.saveQuests();
                this.openStageEditor(p, q, idx);
            })));
        }
        if (sg.type.equals("item")) {
            buttons.add(this.btn("&dЗамінити предмет на той, що в лівій руці", v -> this.sync(() -> {
                this.applyStage(p, sg, v);
                ItemStack held = p.getInventory().getItemInOffHand();
                if (held.getType().isAir()) {
                    p.sendMessage(this.text("&cПоклади предмет у ліву руку (клавіша F міняє руки)."));
                } else {
                    sg.stack = this.encode(held.clone());
                    sg.amount = held.getAmount();
                    sg.material = held.getType();
                    p.sendMessage(this.text("&aПредмет оновлено: &f" + held.getType().name() + " x" + held.getAmount()));
                }
                this.saveQuests();
                this.openStageEditor(p, q, idx);
            })));
        }
        if (idx > 0) {
            buttons.add(this.btn("Підняти вгору", v -> this.sync(() -> {
                this.applyStage(p, sg, v);
                java.util.Collections.swap(q.stages, idx, idx - 1);
                this.saveQuests();
                this.openStageEditor(p, q, idx - 1);
            })));
        }
        if (idx < q.stages.size() - 1) {
            buttons.add(this.btn("Опустити вниз", v -> this.sync(() -> {
                this.applyStage(p, sg, v);
                java.util.Collections.swap(q.stages, idx, idx + 1);
                this.saveQuests();
                this.openStageEditor(p, q, idx + 1);
            })));
        }
        buttons.add(this.btn("&cВидалити етап", v -> this.sync(() -> {
            if (q.stages.size() <= 1) {
                p.sendMessage(this.text("&cУ квесті має лишитися хоча б один етап."));
                this.openStageEditor(p, q, idx);
                return;
            }
            q.stages.remove(idx);
            this.saveQuests();
            this.openStages(p, q);
        })));
        p.showDialog((DialogLike) this.dialog("&5Етап " + (idx + 1) + ": " + QuestNPC.stageLabel(sg.type),
            List.of(this.para("Квест: " + q.name)), inputs,
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад (без збереження)", v -> this.sync(() -> this.openStages(p, q))), (int) 1)));
    }

    // ======================= ПЛЕЙСХОЛДЕРИ І БУЛЬБАШКА НАД NPC =======================

    private java.lang.reflect.Method papiMethod;
    private boolean papiChecked;
    private final Map<UUID, org.bukkit.entity.TextDisplay> bubbles = new HashMap<>();

    /** Підставляє плейсхолдери PlaceholderAPI (а через нього й CMI), якщо плагін встановлено. */
    private String papi(Player p, String raw) {
        if (raw == null || raw.indexOf('%') < 0 || !this.getConfig().getBoolean("placeholders", true)) {
            return raw;
        }
        if (!this.papiChecked) {
            this.papiChecked = true;
            if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                try {
                    this.papiMethod = Class.forName("me.clip.placeholderapi.PlaceholderAPI")
                        .getMethod("setPlaceholders", org.bukkit.OfflinePlayer.class, String.class);
                    this.getLogger().info("PlaceholderAPI знайдено - плейсхолдери в діалогах увімкнено.");
                } catch (ReflectiveOperationException ex) {
                    this.getLogger().warning("Не вдалося підключити PlaceholderAPI: " + ex.getMessage());
                }
            }
        }
        if (this.papiMethod == null) {
            return raw;
        }
        try {
            Object r = this.papiMethod.invoke(null, p, raw);
            return r instanceof String s ? s : raw;
        } catch (ReflectiveOperationException | RuntimeException ex) {
            return raw;
        }
    }

    private void removeBubble(UUID id) {
        org.bukkit.entity.TextDisplay old = this.bubbles.remove(id);
        if (old != null && old.isValid()) {
            old.remove();
        }
    }

    /** Показує репліку NPC над його головою - лише тому гравцю, який з ним говорить. */
    private void showBubble(Player p, Npc n, String raw) {
        UUID id = p.getUniqueId();
        this.removeBubble(id);
        if (!this.getConfig().getBoolean("bubble.enabled", true)) {
            return;
        }
        Mannequin m = this.entityOf(n);
        if (m == null) {
            return;
        }
        String t = this.papi(p, raw.replace("{player}", p.getName())).replaceAll("\\s*\\R\\s*", " ").strip();
        int max = Math.max(20, this.getConfig().getInt("bubble.max-length", 140));
        if (t.length() > max) {
            t = t.substring(0, max).stripTrailing();
            if (t.endsWith("&")) {
                t = t.substring(0, t.length() - 1);
            }
            t = t + "…";
        }
        if (t.isBlank()) {
            return;
        }
        final String shown = t;
        double offset = this.getConfig().getDouble("bubble.height-offset", 0.7);
        Location loc = m.getLocation().add(0.0, m.getHeight() + offset, 0.0);
        org.bukkit.entity.TextDisplay d = m.getWorld().spawn(loc, org.bukkit.entity.TextDisplay.class, d0 -> {
            d0.setPersistent(false);
            d0.setVisibleByDefault(false);
            d0.text(LEGACY.deserialize(shown));
            d0.setBillboard(org.bukkit.entity.Display.Billboard.CENTER);
            d0.setAlignment(org.bukkit.entity.TextDisplay.TextAlignment.CENTER);
            d0.setLineWidth(180);
        });
        p.showEntity(this, d);
        this.bubbles.put(id, d);
        long ticks = Math.max(60L, Math.min(300L, 40L + (long) shown.length() * 3L));
        Bukkit.getScheduler().runTaskLater(this, () -> {
            if (this.bubbles.get(id) == d) {
                this.removeBubble(id);
            } else if (d.isValid()) {
                d.remove();
            }
        }, ticks);
    }

    // ======================= МЕНЮ ВИБОРУ ДІЇ З NPC =======================

    private void collectQuestIds(Node node, java.util.Set<String> out) {
        for (Choice c : node.choices) {
            String a = c.action == null ? "" : c.action.trim().toLowerCase(Locale.ROOT);
            if (a.startsWith("quest:")) {
                out.add(a.substring(6).trim());
            } else if (a.startsWith("turnin:")) {
                out.add(a.substring(7).trim());
            }
            if (c.next != null) {
                this.collectQuestIds(c.next, out);
            }
        }
    }

    /** Квести цього NPC: ті, що він видає або приймає в діалозі, і ті, що гравець зараз виконує з ним. */
    private List<Quest> npcQuests(Player p, Npc n) {
        java.util.Set<String> ids = new java.util.LinkedHashSet<>();
        this.collectQuestIds(n.root, ids);
        Map<String, QState> m = this.progress.get(p.getUniqueId());
        if (m != null) {
            for (Map.Entry<String, QState> en : m.entrySet()) {
                Quest q = this.quests.get(en.getKey());
                QState st = en.getValue();
                if (q == null || !"ACTIVE".equals(st.status) || st.stage >= q.stages.size()) {
                    continue;
                }
                if (q.stages.get(st.stage).npc == n.id) {
                    ids.add(q.id);
                }
            }
        }
        List<Quest> out = new ArrayList<>();
        for (String id : ids) {
            Quest q = this.quests.get(id);
            if (q != null) {
                out.add(q);
            }
        }
        return out;
    }

    private String questTag(Player p, Quest q) {
        QState st = this.stateOf(p, q.id);
        if (st == null) {
            return "&a[Новий] &f";
        }
        return switch (st.status) {
            case "READY" -> "&6[Здати] &f";
            case "DONE" -> q.repeatable ? (this.cooldownLeft(q, st) > 0L ? "&7[Кулдаун " + QuestNPC.fmtDuration(this.cooldownLeft(q, st) / 1000L + 1L) + "] &7" : "&a[Знову] &f") : "&7[Виконано] &7";
            default -> "&e[У процесі] &f";
        };
    }

    private boolean hubUseful(Player p, Npc n) {
        return !n.trades.isEmpty() || !this.npcQuests(p, n).isEmpty();
    }

    private void openHub(Player p, Npc n) {
        List<ActionButton> buttons = new ArrayList<>();
        if (!n.trades.isEmpty()) {
            buttons.add(this.btn(n.tradeLabel.isBlank() ? "&aТоргівля" : n.tradeLabel, v -> this.sync(() -> this.openTrade(p, n))));
        }
        buttons.add(this.btn(n.dialogLabel.isBlank() ? "&bДіалог" : n.dialogLabel, v -> this.sync(() -> this.openNode(p, n, n.root))));
        int qn = this.npcQuests(p, n).size();
        if (qn > 0) {
            buttons.add(this.btn((n.questLabel.isBlank() ? "&6Квест" : n.questLabel) + (qn > 1 ? " &7(" + qn + ")" : ""), v -> this.sync(() -> this.openQuestMenu(p, n))));
        }
        p.showDialog((DialogLike) this.dialog(n.name,
            List.of(DialogBody.plainMessage((Component) this.fmt(n.hubText.isBlank() ? "Чим займемось, {player}?" : n.hubText, p))),
            List.of(),
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Закрити", null), (int) 1)));
    }

    private void openQuestMenu(Player p, Npc n) {
        List<ActionButton> buttons = new ArrayList<>();
        for (Quest q : this.npcQuests(p, n)) {
            buttons.add(this.btn(this.questTag(p, q) + q.name, v -> this.sync(() -> this.openQuestDetail(p, n, q))));
        }
        if (buttons.isEmpty()) {
            this.openHub(p, n);
            return;
        }
        p.showDialog((DialogLike) this.dialog(n.name + " &8- &6Квести",
            List.of(this.para("Обери квест, щоб побачити подробиці.")),
            List.of(),
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openHub(p, n))), (int) 1)));
    }

    private void openQuestDetail(Player p, Npc n, Quest q) {
        QState st = this.stateOf(p, q.id);
        boolean fresh = st == null || "DONE".equals(st.status) && q.repeatable && this.cooldownLeft(q, st) == 0L;
        List<DialogBody> body = new ArrayList<>();
        if (!q.description.isBlank()) {
            body.add(DialogBody.plainMessage((Component) this.fmt(q.description, p)));
        }
        StringBuilder sb = new StringBuilder("&6Етапи:");
        for (int i = 0; i < q.stages.size(); i++) {
            Stage sg = q.stages.get(i);
            boolean allDone = st != null && ("READY".equals(st.status) || "DONE".equals(st.status) && !q.repeatable);
            boolean done = allDone || st != null && !fresh && i < st.stage;
            boolean current = !allDone && !fresh && st != null && i == st.stage;
            sb.append("\n").append(done ? "&a✔ &7" : current ? "&e▶ &f" : "&8○ &7").append(sg.text);
            if (current && sg.type.equals("kill")) {
                sb.append(" &8(").append(st.count).append("/").append(sg.amount).append(")");
            }
        }
        body.add(DialogBody.plainMessage((Component) this.fmt(sb.toString(), p)));
        if (q.repeatable && q.cooldown > 0L) {
            long left = this.cooldownLeft(q, st);
            body.add(DialogBody.plainMessage((Component) this.fmt(left > 0L
                ? "&eМожна взяти знову через: &f" + QuestNPC.fmtDuration(left / 1000L + 1L)
                : "&7Повторюваний, кулдаун: &f" + QuestNPC.fmtDuration(q.cooldown), p)));
        }
        List<String> rewards = new ArrayList<>();
        if (q.xp > 0) {
            rewards.add(q.xp + " досвіду");
        }
        for (String it : q.items) {
            rewards.add(it.replace(":", " x"));
        }
        for (String enc : q.stacks) {
            try {
                ItemStack st0 = this.decode(enc);
                rewards.add(st0.getAmount() + " x " + st0.getType().name() + (st0.hasItemMeta() ? " (особливий)" : ""));
            } catch (RuntimeException ex) {
                rewards.add("предмет (помилка читання)");
            }
        }
        if (!rewards.isEmpty()) {
            body.add(DialogBody.plainMessage((Component) this.fmt("&6Нагорода: &f" + String.join(", ", rewards), p)));
        }
        List<ActionButton> buttons = new ArrayList<>();
        if (fresh) {
            buttons.add(this.btn("&aВзяти квест", v -> this.sync(() -> {
                this.startQuest(p, q.id);
                this.openQuestDetail(p, n, q);
            })));
        } else if ("READY".equals(st.status)) {
            buttons.add(this.btn("&6Здати квест", v -> this.sync(() -> {
                this.turnIn(p, q.id);
                this.openQuestDetail(p, n, q);
            })));
        }
        ActionButton back = this.btn("&7Назад", v -> this.sync(() -> this.openQuestMenu(p, n)));
        DialogType type = buttons.isEmpty()
            ? DialogType.notice(back)
            : DialogType.multiAction(buttons, back, (int) 1);
        p.showDialog((DialogLike) this.dialog("&6" + q.name, body, List.of(), type));
    }

    // ======================= РЕДАКТОР МЕНЮ ВИБОРУ (GUI) =======================

    private boolean useHub(Player p, Npc n) {
        if (n.menuMode == 2) {
            return false;
        }
        if (n.menuMode == 1) {
            return true;
        }
        return this.getConfig().getBoolean("menu.enabled", true) && this.hubUseful(p, n);
    }

    private void applyHub(Npc n, Function<String, String> v) {
        n.hubText = QuestNPC.clean(v.apply("hubtext"), "");
        n.tradeLabel = QuestNPC.clean(v.apply("tlabel"), "");
        n.dialogLabel = QuestNPC.clean(v.apply("dlabel"), "");
        n.questLabel = QuestNPC.clean(v.apply("qlabel"), "");
    }

    private void openHubEditor(Player p, Npc n) {
        List<DialogInput> inputs = new ArrayList<>();
        inputs.add(this.block("hubtext", "Привітання в меню ({player}, плейсхолдери; порожньо = стандартне)", n.hubText, 200));
        inputs.add(this.line("tlabel", "Кнопка торгівлі (порожньо = «Торгівля»)", n.tradeLabel, 40));
        inputs.add(this.line("dlabel", "Кнопка діалогу (порожньо = «Діалог»)", n.dialogLabel, 40));
        inputs.add(this.line("qlabel", "Кнопка квестів (порожньо = «Квест»)", n.questLabel, 40));
        String mode = switch (n.menuMode) {
            case 1 -> "&aзавжди показувати";
            case 2 -> "&cвимкнене (одразу діалог)";
            default -> "&eавто (за config.yml)";
        };
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&aЗберегти", v -> this.sync(() -> {
            this.applyHub(n, v);
            this.save();
            p.sendMessage(this.text("&aМеню збережено."));
            this.openHubEditor(p, n);
        })));
        buttons.add(this.btn("Переглянути меню", v -> this.sync(() -> {
            this.applyHub(n, v);
            this.save();
            this.openHub(p, n);
        })));
        buttons.add(this.btn("Показ меню: " + mode, v -> this.sync(() -> {
            this.applyHub(n, v);
            n.menuMode = (n.menuMode + 1) % 3;
            this.save();
            this.openHubEditor(p, n);
        })));
        buttons.add(this.btn("&cСкинути до стандартних", v -> this.sync(() -> {
            n.hubText = "";
            n.tradeLabel = "";
            n.dialogLabel = "";
            n.questLabel = "";
            n.menuMode = 0;
            this.save();
            p.sendMessage(this.text("&aМеню скинуто."));
            this.openHubEditor(p, n);
        })));
        p.showDialog((DialogLike) this.dialog("&5Меню вибору: " + n.name,
            List.of(this.para("Це меню бачить гравець при кліку по NPC: торгівля / діалог / квест. Кнопки «Торгівля» і «Квест» з'являються лише коли в NPC є угоди чи квести.")),
            inputs,
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openSettings(p, n))), (int) 1)));
    }

    // ======================= КУЛДАУНИ, ОДНОРАЗОВІ ФРАЗИ, ПРЕДМЕТ З РУКИ =======================

    private static final java.util.regex.Pattern DUR = java.util.regex.Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)\\s*([a-zа-яіїєґ]*)$");

    /** Розбирає час: 90, 30s, 15m, 2h, 1d, а також 30хв, 2год, 1дн. Повертає секунди. */
    private static long parseDuration(String raw) {
        if (raw == null) {
            return 0L;
        }
        java.util.regex.Matcher m = DUR.matcher(raw.trim().toLowerCase(Locale.ROOT).replace(',', '.'));
        if (!m.matches()) {
            return 0L;
        }
        double v = Double.parseDouble(m.group(1));
        String u = m.group(2);
        long mult = 1L;
        if (u.startsWith("m") || u.startsWith("х")) {
            mult = 60L;
        } else if (u.startsWith("h") || u.startsWith("г")) {
            mult = 3600L;
        } else if (u.startsWith("d") || u.startsWith("д")) {
            mult = 86400L;
        }
        return Math.max(0L, Math.round(v * (double) mult));
    }

    private static String fmtDuration(long sec) {
        if (sec <= 0L) {
            return "0 с";
        }
        long d = sec / 86400L;
        long h = sec % 86400L / 3600L;
        long m = sec % 3600L / 60L;
        long s = sec % 60L;
        StringBuilder sb = new StringBuilder();
        if (d > 0L) {
            sb.append(d).append(" д ");
        }
        if (h > 0L) {
            sb.append(h).append(" год ");
        }
        if (m > 0L && d == 0L) {
            sb.append(m).append(" хв ");
        }
        if (s > 0L && d == 0L && h == 0L) {
            sb.append(s).append(" с");
        }
        return sb.toString().trim();
    }

    private long cooldownLeft(Quest q, QState st) {
        if (st == null || !"DONE".equals(st.status) || q.cooldown <= 0L) {
            return 0L;
        }
        return Math.max(0L, st.doneAt + q.cooldown * 1000L - System.currentTimeMillis());
    }

    /** Чи доступна кнопка діалогу з урахуванням токенів once і cd:<час> в полі умови. */
    private boolean choiceAvailable(Player p, Choice c) {
        if (c.cond == null || c.cond.isBlank()) {
            return true;
        }
        Map<String, Long> uses = this.choiceUses.get(p.getUniqueId());
        Long last = uses == null ? null : uses.get(c.uid);
        if (last == null) {
            return true;
        }
        for (String part : c.cond.split(",")) {
            String t = part.trim().toLowerCase(Locale.ROOT);
            if (t.equals("once")) {
                return false;
            }
            if (t.startsWith("cd:")) {
                long cd = QuestNPC.parseDuration(t.substring(3));
                if (cd > 0L && System.currentTimeMillis() - last < cd * 1000L) {
                    return false;
                }
            }
        }
        return true;
    }

    private void markChoiceUsed(Player p, Choice c) {
        if (c.cond == null) {
            return;
        }
        String low = c.cond.toLowerCase(Locale.ROOT);
        if (!low.contains("once") && !low.contains("cd:")) {
            return;
        }
        this.choiceUses.computeIfAbsent(p.getUniqueId(), k -> new HashMap<>()).put(c.uid, System.currentTimeMillis());
        this.progressDirty = true;
    }

    /** Підказує назви предметів, що містять введений текст (пошук). */
    private void suggestItems(Player p, String query) {
        String q = query == null ? "" : query.trim().toUpperCase(Locale.ROOT).replace(' ', '_').replace("MINECRAFT:", "");
        List<String> hits = new ArrayList<>();
        if (!q.isEmpty()) {
            for (Material m : Material.values()) {
                if (!m.isLegacy() && m.isItem() && m.name().contains(q)) {
                    hits.add(m.name());
                    if (hits.size() >= 8) {
                        break;
                    }
                }
            }
        }
        p.sendMessage(this.text(hits.isEmpty()
            ? "&cПредмет не знайдено: &f" + query + "&c. Спробуй англійську назву, напр. diamond_sword."
            : "&cТочної назви немає. Можливо, ти мав на увазі: &f" + String.join(", ", hits)));
    }

    private ItemStack stackOf(String enc) {
        ItemStack s0 = this.stackCache.get(enc);
        if (s0 == null) {
            s0 = this.decode(enc);
            this.stackCache.put(enc, s0);
        }
        return s0.clone();
    }

    private String stackLabel(Stage sg) {
        try {
            ItemStack s0 = this.stackOf(sg.stack);
            return s0.getType().name() + (s0.hasItemMeta() ? "*" : "");
        } catch (RuntimeException ex) {
            return "?";
        }
    }

    /** Відповідь NPC окремим вікном (після виконання етапу з полем «відповідь»). */
    private void openReply(Player p, Npc n, String text) {
        this.showBubble(p, n, text);
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&aДалі", v -> this.sync(() -> {
            if (this.useHub(p, n)) {
                this.openHub(p, n);
            } else {
                this.openNode(p, n, n.root);
            }
        })));
        p.showDialog((DialogLike) this.dialog(n.name,
            List.of(DialogBody.plainMessage((Component) this.fmt(text, p))), List.of(),
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Закрити", null), (int) 1)));
    }

    // ======================= ПАНЕЛЬ ПРОГРЕСУ КВЕСТІВ (BOSSBAR) =======================

    private Quest trackedQuest(Player p) {
        UUID id = p.getUniqueId();
        Map<String, QState> m = this.progress.get(id);
        if (m == null) {
            return null;
        }
        String tid = this.tracked.get(id);
        if (tid != null) {
            QState st = m.get(tid);
            Quest q = this.quests.get(tid);
            if (q != null && st != null && !"DONE".equals(st.status)) {
                return q;
            }
        }
        for (Map.Entry<String, QState> en : m.entrySet()) {
            Quest q = this.quests.get(en.getKey());
            if (q != null && !"DONE".equals(en.getValue().status)) {
                return q;
            }
        }
        return null;
    }

    private int countStack(Player p, java.util.function.Predicate<ItemStack> match) {
        int total = 0;
        for (ItemStack it : p.getInventory().getContents()) {
            if (it != null && !it.getType().isAir() && match.test(it)) {
                total += it.getAmount();
            }
        }
        return total;
    }

    private float questFraction(Player p, Quest q, QState st) {
        if ("READY".equals(st.status)) {
            return 1.0f;
        }
        int total = Math.max(1, q.stages.size());
        double part = 0.0;
        if (st.stage < q.stages.size()) {
            Stage sg = q.stages.get(st.stage);
            int need = Math.max(1, sg.amount);
            if (sg.type.equals("kill")) {
                part = Math.min(1.0, st.count / (double) need);
            } else if (sg.type.equals("deliver") && sg.material != null) {
                Material mat = sg.material;
                part = Math.min(1.0, this.countStack(p, it -> it.getType() == mat) / (double) need);
            } else if (sg.type.equals("item")) {
                try {
                    ItemStack tpl = this.stackOf(sg.stack);
                    part = Math.min(1.0, this.countStack(p, it -> it.isSimilar(tpl)) / (double) need);
                } catch (RuntimeException ex) {
                    part = 0.0;
                }
            }
        }
        return (float) Math.max(0.0, Math.min(1.0, ((double) st.stage + part) / (double) total));
    }

    private void updateTrackers() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            this.updateTracker(p);
        }
    }

    private void updateTracker(Player p) {
        UUID id = p.getUniqueId();
        boolean enabled = this.getConfig().getBoolean("tracker.enabled", true) && !this.hudOff.contains(id);
        Quest q = enabled ? this.trackedQuest(p) : null;
        net.kyori.adventure.bossbar.BossBar bar = this.bars.get(id);
        if (q == null) {
            if (bar != null) {
                p.hideBossBar(bar);
                this.bars.remove(id);
            }
            return;
        }
        QState st = this.progress.get(id).get(q.id);
        Component title = LEGACY.deserialize("&6" + q.name + " &8» " + this.describe(p, q, st));
        float prog = this.questFraction(p, q, st);
        net.kyori.adventure.bossbar.BossBar.Color color = "READY".equals(st.status)
            ? net.kyori.adventure.bossbar.BossBar.Color.GREEN : net.kyori.adventure.bossbar.BossBar.Color.YELLOW;
        if (bar == null) {
            bar = net.kyori.adventure.bossbar.BossBar.bossBar(title, prog, color, net.kyori.adventure.bossbar.BossBar.Overlay.PROGRESS);
            this.bars.put(id, bar);
            p.showBossBar(bar);
        } else {
            bar.name(title);
            bar.progress(prog);
            bar.color(color);
        }
    }

    private void hideTracker(Player p) {
        net.kyori.adventure.bossbar.BossBar bar = this.bars.remove(p.getUniqueId());
        if (bar != null) {
            p.hideBossBar(bar);
        }
    }

    private void openJournal(Player p) {
        List<DialogBody> body = new ArrayList<>();
        List<ActionButton> buttons = new ArrayList<>();
        UUID id = p.getUniqueId();
        Map<String, QState> m = this.progress.get(id);
        Quest tq = this.trackedQuest(p);
        if (m != null) {
            for (Map.Entry<String, QState> en : m.entrySet()) {
                QState st = en.getValue();
                Quest q = this.quests.get(en.getKey());
                if (q == null || "DONE".equals(st.status)) {
                    continue;
                }
                String desc = q.description.isBlank() ? "" : "\n&7" + q.description;
                body.add(this.para((q == tq ? "&e★ " : "") + "&6&l" + q.name + desc + "\n" + this.describe(p, q, st)));
                if (q != tq) {
                    buttons.add(this.btn("&eВідстежувати: " + q.name, v -> this.sync(() -> {
                        this.tracked.put(id, q.id);
                        this.progressDirty = true;
                        this.updateTracker(p);
                        this.openJournal(p);
                    })));
                }
            }
        }
        if (body.isEmpty()) {
            body.add(this.para("&7Активних квестів немає. Поговори з жителями, щоб отримати завдання."));
        }
        buttons.add(this.btn("Панель квестів зверху: " + (this.hudOff.contains(id) ? "&cвимкнена" : "&aувімкнена"), v -> this.sync(() -> {
            if (!this.hudOff.remove(id)) {
                this.hudOff.add(id);
            }
            this.progressDirty = true;
            this.updateTracker(p);
            this.openJournal(p);
        })));
        p.showDialog((DialogLike) this.dialog("&6Журнал квестів", body, List.of(),
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Закрити", null), (int) 1)));
    }

    private Npc byArg(String[] a) {
        if (a.length < 2) {
            return null;
        }
        try {
            return this.npcs.get(Integer.parseInt(a[1]));
        }
        catch (NumberFormatException ex) {
            return null;
        }
    }

    public List<String> onTabComplete(CommandSender s, Command command, String alias, String[] a) {
        if (!command.getName().equalsIgnoreCase("mizkoprav")) {
            return List.of();
        }
        if (a.length == 1) {
            return List.of("give", "list", "remove", "tp", "here", "quests", "editor", "reload").stream().filter(x -> x.startsWith(a[0].toLowerCase())).toList();
        }
        if (a.length == 2 && (a[0].equalsIgnoreCase("remove") || a[0].equalsIgnoreCase("tp"))) {
            return this.npcs.keySet().stream().map(String::valueOf).filter(x -> x.startsWith(a[1])).toList();
        }
        return List.of();
    }

    static final class Npc {
        final int id;
        String name = "NPC";
        String skin = "";
        String hubText = "";
        String tradeLabel = "";
        String dialogLabel = "";
        String questLabel = "";
        int menuMode = 0;
        Node root = new Node("\u041f\u0440\u0438\u0432\u0456\u0442, {player}!", null, "");
        final List<Trade> trades = new ArrayList<Trade>();
        Location loc;
        UUID entity;

        Npc(int id) {
            this.id = id;
        }
    }

    static final class Node {
        String text;
        final List<Choice> choices = new ArrayList<Choice>();
        final Node parent;
        String fromLabel;

        Node(String text, Node parent, String fromLabel) {
            this.text = text;
            this.parent = parent;
            this.fromLabel = fromLabel;
        }
    }

    static final class Choice {
        String label;
        String action;
        String cond;
        String uid = UUID.randomUUID().toString().substring(0, 8);
        final Node next;

        Choice(String label, String action, String cond, Node next) {
            this.label = label;
            this.action = action;
            this.cond = cond;
            this.next = next;
        }
    }

    static final class Quest {
        String id;
        String name;
        String description = "";
        boolean repeatable;
        boolean turnIn;
        long cooldown = 0L;
        final List<Stage> stages = new ArrayList<Stage>();
        int xp;
        List<String> items = new ArrayList<String>();
        List<String> stacks = new ArrayList<String>();
        List<String> commands = new ArrayList<String>();

        Quest() {
        }
    }

    static final class QState {
        String status = "ACTIVE";
        int stage = 0;
        int count = 0;
        long doneAt = 0L;

        QState() {
        }
    }

    static final class TradeEditor
    implements InventoryHolder {
        final Npc npc;
        Inventory inv;

        TradeEditor(Npc npc) {
            this.npc = npc;
        }

        public Inventory getInventory() {
            return this.inv;
        }
    }

    static final class Trade {
        final ItemStack price1;
        final ItemStack price2;
        final ItemStack result;

        Trade(ItemStack price1, ItemStack price2, ItemStack result) {
            this.price1 = price1;
            this.price2 = price2;
            this.result = result;
        }
    }

    static final class Stage {
        String type;
        String text = "";
        String world = "";
        double x;
        double y;
        double z;
        double radius = 5.0;
        double height = -1.0;
        EntityType entity;
        int amount = 1;
        Material material;
        int npc = -1;
        String stack = "";
        String reply = "";
        String replyFail = "";

        Stage() {
        }
    }
}

