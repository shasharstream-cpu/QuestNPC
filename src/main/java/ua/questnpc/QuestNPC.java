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
    private static final LegacyComponentSerializer LEGACY = LegacyComponentSerializer.builder().character('&').hexColors().build();

    /** Кольоровий текст: &-коди, hex &#RRGGBB або MiniMessage (напр. <gradient:#ff0000:#0000ff>Ім'я</gradient>). */
    static Component colored(String s) {
        if (s != null && s.indexOf('<') >= 0 && s.indexOf('>') > s.indexOf('<') && s.indexOf('&') < 0) {
            return net.kyori.adventure.text.minimessage.MiniMessage.miniMessage().deserialize(s);
        }
        return LEGACY.deserialize(s == null ? "" : s);
    }
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
    private final Map<String, Line> lines = new LinkedHashMap<>();
    private final Map<UUID, java.util.Set<String>> linesDone = new HashMap<>();
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
        this.loadChatters();
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
        this.getServer().getScheduler().runTaskTimer((Plugin)this, this::tickChatters, 200L, 20L);
        this.getServer().getScheduler().runTaskTimer((Plugin)this, this::maintainPoses, 100L, 100L);
        this.getServer().getScheduler().runTaskTimer((Plugin)this, () -> {
            if (this.progressDirty) {
                this.saveProgress();
            }
        }, 100L, 100L);
    }

    public void onDisable() {
        for (org.bukkit.entity.TextDisplay nb : new ArrayList<>(this.npcBubbles.values())) {
            if (nb.isValid()) {
                nb.remove();
            }
        }
        for (Player pl : Bukkit.getOnlinePlayers()) {
            this.hideTracker(pl);
            this.removeMarkers(pl);
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
        return Dialog.create(factory -> ((DialogRegistryEntry.Builder)factory.empty()).base(DialogBase.builder((Component)QuestNPC.colored(title)).canCloseWithEscape(true).body(body).inputs(inputs).build()).type(type));
    }

    private DialogBody para(String legacy) {
        return DialogBody.plainMessage((Component)LEGACY.deserialize(legacy));
    }

    private DialogInput line(String key, String label, String initial, int maxLength) {
        return DialogInput.text((String)key, (Component)Component.text((String)label)).width(300).initial(initial == null ? "" : initial).maxLength(maxLength).build();
    }

    private DialogInput block(String key, String label, String initial, int maxLength) {
        return DialogInput.text((String)key, (Component)Component.text((String)label)).width(300).initial(initial == null ? "" : initial).maxLength(maxLength).multiline(TextDialogInput.MultilineOptions.create((Integer)null, (Integer)120)).build();
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
        if (!(entity instanceof org.bukkit.entity.LivingEntity)) {
            return null;
        }
        return (Integer)entity.getPersistentDataContainer().get(this.npcKey, PersistentDataType.INTEGER);
    }

    private void setup(Entity m, Npc n) {
        m.getPersistentDataContainer().set(this.npcKey, PersistentDataType.INTEGER, n.id);
        m.customName((Component)QuestNPC.colored(n.name));
        m.setCustomNameVisible(true);
        m.setInvulnerable(true);
        m.setSilent(true);
        m.setPersistent(true);
        if (m instanceof Mannequin mq) {
            mq.setDescription(null);
            mq.setImmovable(true);
            this.applyPose(mq, n);
        }
        if (m instanceof org.bukkit.entity.LivingEntity le) {
            le.setRemoveWhenFarAway(false);
            if (!(m instanceof Mannequin)) {
                le.setAI(false);
                le.setCollidable(false);
            }
        }
    }

    private Entity entityOf(Npc n) {
        if (n.entity == null || n.loc == null || n.loc.getWorld() == null) {
            return null;
        }
        n.loc.getWorld().getChunkAt(n.loc).load();
        return n.loc.getWorld().getEntity(n.entity);
    }

    private Npc createNpc(String name, String skin, Location loc, String mob) {
        Npc n = new Npc(this.nextId++);
        n.name = name;
        n.skin = skin;
        n.mobType = this.validMob(mob);
        n.loc = loc.clone();
        n.root.choices.add(new Choice("\u0425\u0442\u043e \u0442\u0438?", "", "", new Node("\u042f \u043d\u043e\u0432\u0438\u0439 NPC. \u041c\u0435\u043d\u0435 \u043c\u043e\u0436\u043d\u0430 \u043d\u0430\u043b\u0430\u0448\u0442\u0443\u0432\u0430\u0442\u0438 \u041c\u0456\u0437\u043a\u043e\u043f\u0440\u0430\u0432\u043e\u043c.", n.root, "\u0425\u0442\u043e \u0442\u0438?")));
        Entity m = this.spawnNpcEntity(n, loc);
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
            Entity m = this.entityOf(n);
            if (m instanceof Mannequin mm && resolved != null) {
                mm.setProfile(ResolvableProfile.resolvableProfile((PlayerProfile)resolved));
            }
        })).exceptionally(ex -> {
            this.getLogger().warning("\u041d\u0435 \u0432\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u0432\u0430\u043d\u0442\u0430\u0436\u0438\u0442\u0438 \u0441\u043a\u0456\u043d '" + n.skin + "': " + ex.getMessage());
            return null;
        });
    }

    private void removeNpc(Npc n) {
        Entity m = this.entityOf(n);
        this.dropSeat(n);
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
        String shown = this.nodeText(p, node);
        this.showBubble(p, n, shown);
        p.showDialog((DialogLike)this.dialog(n.name, List.of(DialogBody.plainMessage((Component)this.fmt(shown, p))), List.of(), (DialogType)type));
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
                String qid = a.substring(6).trim();
                Quest oq = this.quests.get(qid);
                if (oq != null && this.getConfig().getBoolean("offer.confirm", true) && this.canStart(p, oq)) {
                    this.openQuestOffer(p, n, oq, () -> this.openNode(p, n, c.next), () -> this.openNode(p, n, node));
                } else if (this.startQuest(p, qid)) {
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
                if (q != null && (st == null || "DONE".equals(st.status) && q.repeatable && this.cooldownLeft(q, st) == 0L) && this.blockReason(p, q) == null) {
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
            Npc n = this.createNpc(QuestNPC.clean((String)v.apply("name"), "NPC"), QuestNPC.clean((String)v.apply("skin"), ""), loc, QuestNPC.clean((String)v.apply("mob"), ""));
            p.sendMessage(this.text("&aNPC #" + n.id + " \u0441\u0442\u0432\u043e\u0440\u0435\u043d\u043e. \u041f\u041a\u041c \u043f\u043e \u043d\u044c\u043e\u043c\u0443 \u0437 \u041c\u0456\u0437\u043a\u043e\u043f\u0440\u0430\u0432\u043e\u043c - \u043d\u0430\u043b\u0430\u0448\u0442\u0443\u0432\u0430\u043d\u043d\u044f."));
        })), (ActionButton)this.btn("&c\u0421\u043a\u0430\u0441\u0443\u0432\u0430\u0442\u0438", null));
        p.showDialog((DialogLike)this.dialog("&5\u0421\u0442\u0432\u043e\u0440\u0435\u043d\u043d\u044f NPC", List.of(this.para("NPC \u0437'\u044f\u0432\u0438\u0442\u044c\u0441\u044f \u043d\u0430 \u0432\u0438\u0431\u0440\u0430\u043d\u043e\u043c\u0443 \u043c\u0456\u0441\u0446\u0456. \u0421\u043a\u0456\u043d \u0431\u0435\u0440\u0435\u0442\u044c\u0441\u044f \u0437\u0430 \u043d\u0456\u043a\u043e\u043c \u0433\u0440\u0430\u0432\u0446\u044f (\u043f\u043e\u0442\u0440\u0456\u0431\u0435\u043d \u043e\u043d\u043b\u0430\u0439\u043d-\u0440\u0435\u0436\u0438\u043c \u0441\u0435\u0440\u0432\u0435\u0440\u0430).")), List.of(this.line("name", "Ім'я NPC (&-кольори, &#RRGGBB або <gradient:#f00:#00f>...)", "\u041d\u043e\u0432\u0438\u0439 NPC", 150), this.line("skin", "\u0421\u043a\u0456\u043d: \u043d\u0456\u043a \u0433\u0440\u0430\u0432\u0446\u044f", p.getName(), 16), this.line("mob", "Вигляд: тип моба (порожньо = людина зі скіном; напр. VILLAGER, COW, ALLAY)", "", 30)), (DialogType)type));
    }

    private void openSettings(Player p, Npc n) {
        List<ActionButton> buttons = List.of(this.btn("\u0406\u043c'\u044f \u0442\u0430 \u0441\u043a\u0456\u043d", v -> this.sync(() -> this.openIdentity(p, n))), this.btn("\u0414\u0456\u0430\u043b\u043e\u0433", v -> this.sync(() -> this.openNodeEditor(p, n, n.root))), this.btn("\u0423\u0433\u043e\u0434\u0438 (\u0442\u043e\u0440\u0433\u0456\u0432\u043b\u044f): " + n.trades.size(), v -> this.sync(() -> this.openTradeEditor(p, n))), this.btn("\u041f\u0435\u0440\u0435\u043c\u0456\u0441\u0442\u0438\u0442\u0438 \u0434\u043e \u043c\u0435\u043d\u0435", v -> this.sync(() -> {
            Entity m = this.entityOf(n);
            if (m != null) {
                Location l = p.getLocation();
                if (m.getVehicle() != null) {
                    m.leaveVehicle();
                }
                this.dropSeat(n);
                m.teleport(l);
                n.loc = l.clone();
                this.save();
                p.sendMessage(this.text("&aNPC \u043f\u0435\u0440\u0435\u043c\u0456\u0449\u0435\u043d\u043e."));
            } else {
                p.sendMessage(this.text("&c\u0421\u0443\u0442\u043d\u0456\u0441\u0442\u044c NPC \u043d\u0435 \u0437\u043d\u0430\u0439\u0434\u0435\u043d\u043e (\u043c\u043e\u0436\u043b\u0438\u0432\u043e, \u0457\u0457 \u0432\u0431\u0438\u043b\u0438). \u0412\u0438\u0434\u0430\u043b\u0438 \u0439 \u0441\u0442\u0432\u043e\u0440\u0438 \u0437\u0430\u043d\u043e\u0432\u043e."));
            }
            this.openSettings(p, n);
        })), this.btn(n.mobType.isBlank() ? "Поза: " + QuestNPC.poseLabel(n.pose) : "&8Поза (лише для людей)", v -> this.sync(() -> {
            if (n.mobType.isBlank()) {
                n.pose = QuestNPC.nextPose(n.pose);
                this.applyPoseNow(n);
                this.save();
            } else {
                p.sendMessage(this.text("&cПоза доступна лише для NPC-людей (без типу моба)."));
            }
            this.openSettings(p, n);
        })), this.btn("Розмови NPC", v -> this.sync(() -> this.openChatterList(p))), this.btn("Меню вибору (GUI)", v -> this.sync(() -> this.openHubEditor(p, n))), this.btn("&6\u041a\u0432\u0435\u0441\u0442\u0438 (\u0440\u0435\u0434\u0430\u043a\u0442\u043e\u0440)", v -> this.sync(() -> this.openQuestList(p))), this.btn("&c\u0412\u0438\u0434\u0430\u043b\u0438\u0442\u0438 NPC", v -> this.sync(() -> this.openDelete(p, n))));
        p.showDialog((DialogLike)this.dialog("&5NPC #" + n.id + ": " + n.name, List.of(this.para("\u0429\u043e \u0437\u043c\u0456\u043d\u0438\u0442\u0438?")), List.of(), (DialogType)DialogType.multiAction(buttons, (ActionButton)this.btn("&7\u0417\u0430\u043a\u0440\u0438\u0442\u0438", null), (int)1)));
    }

    private void openIdentity(Player p, Npc n) {
        ConfirmationType type = DialogType.confirmation((ActionButton)this.btn("&a\u0417\u0431\u0435\u0440\u0435\u0433\u0442\u0438", v -> this.sync(() -> {
            n.name = QuestNPC.clean((String)v.apply("name"), n.name);
            String newSkin = QuestNPC.clean((String)v.apply("skin"), "");
            boolean skinChanged = !newSkin.equals(n.skin);
            n.skin = newSkin;
            String newMob = this.validMob(QuestNPC.clean((String)v.apply("mob"), ""));
            boolean mobChanged = !newMob.equals(n.mobType);
            n.mobType = newMob;
            if (mobChanged) {
                this.respawnNpc(n);
            }
            Entity m = this.entityOf(n);
            if (m != null) {
                m.customName((Component)QuestNPC.colored(n.name));
            }
            if (skinChanged) {
                this.applySkin(n);
            }
            this.save();
            p.sendMessage(this.text("&a\u0417\u0431\u0435\u0440\u0435\u0436\u0435\u043d\u043e."));
            this.openSettings(p, n);
        })), (ActionButton)this.btn("&7\u041d\u0430\u0437\u0430\u0434", v -> this.sync(() -> this.openSettings(p, n))));
        p.showDialog((DialogLike)this.dialog("&5\u0406\u043c'\u044f \u0442\u0430 \u0441\u043a\u0456\u043d", List.of(this.para("\u0421\u043a\u0456\u043d \u0431\u0435\u0440\u0435\u0442\u044c\u0441\u044f \u0437\u0430 \u043d\u0456\u043a\u043e\u043c \u0433\u0440\u0430\u0432\u0446\u044f (\u043f\u043e\u0442\u0440\u0456\u0431\u0435\u043d \u043e\u043d\u043b\u0430\u0439\u043d-\u0440\u0435\u0436\u0438\u043c \u0441\u0435\u0440\u0432\u0435\u0440\u0430).")), List.of(this.line("name", "Ім'я NPC (&-кольори, &#RRGGBB або <gradient:#f00:#00f>...)", n.name, 150), this.line("skin", "\u0421\u043a\u0456\u043d: \u043d\u0456\u043a \u0433\u0440\u0430\u0432\u0446\u044f", n.skin, 16), this.line("mob", "Вигляд: тип моба (порожньо = людина зі скіном; напр. VILLAGER, COW, ALLAY)", n.mobType, 30)), (DialogType)type));
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
        inputs.add(this.block("again", "Репліка NPC при повторній розмові (порожньо = завжди та сама)", node.again, 600));
        inputs.add(this.line("againcd", "Повторна репліка діє (напр. 10m, 1h, 1d; 0 = завжди після першого разу)", node.againCd > 0L ? node.againCd + "s" : "0", 12));
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
        node.again = QuestNPC.clean(v.apply("again"), "");
        node.againCd = QuestNPC.parseDuration(v.apply("againcd"));
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
        Merchant merchant = Bukkit.createMerchant((Component)QuestNPC.colored(n.name));
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
        if (this.limitReached(p) && (st == null || "DONE".equals(st.status))) {
            p.sendMessage(this.text("&cУ тебе забагато активних квестів (максимум " + this.getConfig().getInt("quest.max-active", 0) + "). Заверши або скасуй один з них."));
            return false;
        }
        String blockWhy = this.blockReason(p, q);
        if (blockWhy != null && (st == null || "DONE".equals(st.status))) {
            p.sendMessage(this.text("&cКвест закрито: &f" + blockWhy));
            return false;
        }
        if (!(st == null || "DONE".equals(st.status) && q.repeatable)) {
            p.sendMessage(this.text("DONE".equals(st.status) ? "&7\u0426\u0435\u0439 \u043a\u0432\u0435\u0441\u0442 \u0443\u0436\u0435 \u0432\u0438\u043a\u043e\u043d\u0430\u043d\u043e." : "&7\u0422\u0438 \u0432\u0436\u0435 \u0432\u0437\u044f\u0432 \u0446\u0435\u0439 \u043a\u0432\u0435\u0441\u0442."));
            return false;
        }
        this.progress.computeIfAbsent(p.getUniqueId(), k -> new LinkedHashMap()).put(qid, new QState());
        this.tracked.put(p.getUniqueId(), qid);
        this.progress.get(p.getUniqueId()).get(qid).startedAt = System.currentTimeMillis();
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
        if (st.stage < q.stages.size()) {
            this.sendStageChat(p, q, q.stages.get(st.stage));
        }
        ++st.stage;
        st.count = 0;
        if (st.stage >= q.stages.size()) {
            if (q.turnIn) {
                st.status = "READY";
                this.saveProgress();
                p.sendMessage(this.text("&a\u0423\u0441\u0456 \u0435\u0442\u0430\u043f\u0438 \u043a\u0432\u0435\u0441\u0442\u0443 \"" + q.name + "\" \u0432\u0438\u043a\u043e\u043d\u0430\u043d\u043e. \u041f\u043e\u0432\u0435\u0440\u043d\u0456\u0442\u044c\u0441\u044f \u0434\u043e NPC, \u0449\u043e\u0431 \u0437\u0434\u0430\u0442\u0438."));
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.6f, 1.4f);
                this.notifyTitle(p, "&6&lЕтапи виконано", "&fПовернись до NPC, щоб здати «" + q.name + "»");
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
        this.notifyTitle(p, "&a&lКвест виконано!", "&f" + q.name);
        this.getServer().getScheduler().runTask((Plugin) this, () -> this.checkLines(p));
        if (this.getConfig().getBoolean("notify.broadcast", false)) {
            Bukkit.broadcast(LEGACY.deserialize("&6" + p.getName() + " &7виконав квест: &f" + q.name));
        }
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
                boolean reached = sg.type.equals("reach") ? this.inZone(p, sg) : sg.type.equals("mob") && this.mobInZone(p, sg);
                if (!reached) continue;
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
        this.removeMarkers(e.getPlayer());
        this.bubbleNpc.remove(e.getPlayer().getUniqueId());
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
            y.set(b + "mob-type", n.mobType);
            y.set(b + "pose", n.pose);
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
                n.mobType = s.getString("mob-type", "");
                n.pose = s.getString("pose", "stand");
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
        o.addProperty("uid", node.uid);
        if (!node.again.isBlank()) {
            o.addProperty("again", node.again);
            o.addProperty("againCd", node.againCd);
        }
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
        if (o.has("uid")) {
            node.uid = o.get("uid").getAsString();
        } else {
            this.uidGenerated = true;
        }
        node.again = o.has("again") ? o.get("again").getAsString() : "";
        node.againCd = o.has("againCd") ? o.get("againCd").getAsLong() : 0L;
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
        this.lines.clear();
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
            for (String r : s.getStringList("requires")) {
                q.requires.add(r.toLowerCase(Locale.ROOT));
            }
            for (String r : s.getStringList("excludes")) {
                q.excludes.add(r.toLowerCase(Locale.ROOT));
            }
            q.minLevel = Math.max(0, s.getInt("min-level", 0));
            q.giver = s.getInt("giver", -1);
            q.dailyReset = Math.max(-1, QuestNPC.parseHhmm(s.getString("daily-reset", "")));
            q.timeLimit = Math.max(0L, s.getLong("time-limit", 0L));
            q.acceptReply = s.getString("accept-reply", "");
            q.declineReply = s.getString("decline-reply", "");
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
                sg.chat = QuestNPC.ms(m, "chat", "");
                sg.chatNpc = (int)QuestNPC.md(m, "chat-npc", -1.0);
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
                    case "mob": {
                        sg.world = QuestNPC.ms(m, "world", "world");
                        sg.x = QuestNPC.md(m, "x", 0.0);
                        sg.y = QuestNPC.md(m, "y", 64.0);
                        sg.z = QuestNPC.md(m, "z", 0.0);
                        sg.radius = QuestNPC.md(m, "radius", 5.0);
                        sg.height = QuestNPC.md(m, "height", -1.0);
                        sg.mobName = QuestNPC.ms(m, "mob-name", "");
                        String metype = QuestNPC.ms(m, "entity", "");
                        if (!metype.isEmpty()) {
                            try {
                                sg.entity = EntityType.valueOf(metype.toUpperCase(Locale.ROOT));
                            } catch (IllegalArgumentException ex3) {
                                this.getLogger().warning("Квест " + id + ", етап " + index + ": невідомий тип моба " + metype);
                            }
                        }
                        if (sg.mobName.isBlank()) {
                            this.getLogger().warning("Квест " + id + ", етап " + index + ": не вказано mob-name.");
                            valid = false;
                        }
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
        ConfigurationSection ls = y.getConfigurationSection("lines");
        if (ls != null) {
            for (String lid : ls.getKeys(false)) {
                ConfigurationSection lc = ls.getConfigurationSection(lid);
                if (lc == null) continue;
                Line ln = new Line();
                ln.id = lid.toLowerCase(Locale.ROOT);
                ln.name = lc.getString("name", ln.id);
                ln.description = lc.getString("description", "");
                for (String qid : lc.getStringList("quests")) {
                    String k = qid.toLowerCase(Locale.ROOT);
                    if (this.quests.containsKey(k)) {
                        ln.quests.add(k);
                    }
                }
                ln.xp = lc.getInt("rewards.xp", 0);
                ln.commands = new ArrayList<>(lc.getStringList("rewards.commands"));
                this.lines.put(ln.id, ln);
            }
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
        this.linesDone.clear();
        ConfigurationSection ld = y.getConfigurationSection("lines-done");
        if (ld != null) {
            for (String u : ld.getKeys(false)) {
                try {
                    this.linesDone.put(UUID.fromString(u), new java.util.HashSet<>(ld.getStringList(u)));
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
                    st.startedAt = qs.getLong("startedAt", 0L);
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
                y.set(b + "startedAt", (Object)qe.getValue().startedAt);
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
        for (Map.Entry<UUID, java.util.Set<String>> le : this.linesDone.entrySet()) {
            y.set("lines-done." + le.getKey(), new ArrayList<>(le.getValue()));
        }
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
                    s.sendMessage(Component.text(q.id).color(net.kyori.adventure.text.format.NamedTextColor.GRAY)
                        .clickEvent(net.kyori.adventure.text.event.ClickEvent.copyToClipboard(q.id))
                        .hoverEvent(net.kyori.adventure.text.event.HoverEvent.showText(Component.text("Натисни, щоб скопіювати id")))
                        .append(Component.text(" " + q.name + " (етапів: " + q.stages.size() + (q.turnIn ? ", зі здачею" : "") + ")", net.kyori.adventure.text.format.NamedTextColor.WHITE)));
                }
                break;
            }
            case "chatter": {
                if (!(s instanceof Player)) {
                    s.sendMessage("Тільки для гравців.");
                    return true;
                }
                this.openChatterList((Player) s);
                return true;
            }
            case "resetphrases": {
                Player rp = a.length > 1 ? Bukkit.getPlayerExact(a[1]) : (s instanceof Player rpp ? rpp : null);
                if (rp == null) {
                    s.sendMessage("Гравця не знайдено. Використання: /mizkoprav resetphrases [нік]");
                    return true;
                }
                this.choiceUses.remove(rp.getUniqueId());
                this.progressDirty = true;
                s.sendMessage(this.text("&aОдноразові фрази та повторні репліки скинуто для &f" + rp.getName()));
                return true;
            }
            case "markers": {
                if (!(s instanceof Player)) {
                    s.sendMessage("Тільки для гравців.");
                    return true;
                }
                Player dp = (Player) s;
                s.sendMessage(this.text("&7Знаки над NPC: markers.enabled = &f" + this.getConfig().getBoolean("markers.enabled", true)
                    + "&7, радіус &f" + this.getConfig().getDouble("markers.range", 32.0)));
                for (Npc dn : this.npcs.values()) {
                    List<String> ids = new ArrayList<>();
                    for (Quest dq : this.npcQuests(dp, dn)) {
                        QState dst = this.stateOf(dp, dq.id);
                        ids.add(dq.id + "(" + (dst == null ? (this.canStart(dp, dq) ? "новий" : "закритий") : dst.status) + ")");
                    }
                    s.sendMessage(this.text("&7NPC #" + dn.id + " &f" + dn.name + "&7: знак &f" + this.markerState(dp, dn)
                        + "&7 (0 немає, 1 !, 2 золоте ?, 3 сіре ?), квести: &f" + (ids.isEmpty() ? "немає" : String.join(", ", ids))));
                }
                return true;
            }
            case "version": {
                s.sendMessage("QuestNPC " + this.getPluginMeta().getVersion());
                return true;
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
                this.loadChatters();
                this.reseatAll();
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
        "# requires / excludes / min-level / giver та розділ lines - вимоги, видавець і лінійки квестів (редагуються в грі).",
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
            if (!q.requires.isEmpty()) {
                y.set(b + "requires", q.requires);
            }
            if (!q.excludes.isEmpty()) {
                y.set(b + "excludes", q.excludes);
            }
            if (q.minLevel > 0) {
                y.set(b + "min-level", q.minLevel);
            }
            if (q.giver >= 0) {
                y.set(b + "giver", q.giver);
            }
            if (q.dailyReset >= 0) {
                y.set(b + "daily-reset", QuestNPC.hhmm(q.dailyReset));
            }
            if (q.timeLimit > 0L) {
                y.set(b + "time-limit", q.timeLimit);
            }
            if (!q.acceptReply.isBlank()) {
                y.set(b + "accept-reply", q.acceptReply);
            }
            if (!q.declineReply.isBlank()) {
                y.set(b + "decline-reply", q.declineReply);
            }
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
                if (!sg.chat.isBlank()) {
                    m.put("chat", sg.chat);
                }
                if (sg.chatNpc >= 0) {
                    m.put("chat-npc", sg.chatNpc);
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
                    case "mob" -> {
                        m.put("world", sg.world);
                        m.put("x", sg.x);
                        m.put("y", sg.y);
                        m.put("z", sg.z);
                        m.put("radius", sg.radius);
                        if (sg.height >= 0.0) {
                            m.put("height", sg.height);
                        }
                        m.put("mob-name", sg.mobName);
                        if (sg.entity != null) {
                            m.put("entity", sg.entity.name());
                        }
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
        for (Line ln : this.lines.values()) {
            String lb = "lines." + ln.id + ".";
            y.set(lb + "name", ln.name);
            y.set(lb + "description", ln.description);
            y.set(lb + "quests", ln.quests);
            y.set(lb + "rewards.xp", ln.xp);
            y.set(lb + "rewards.commands", ln.commands);
        }
        try {
            java.nio.file.Path qp = this.questsFile.toPath();
            if (java.nio.file.Files.exists(qp)) {
                java.nio.file.Files.copy(qp, qp.resolveSibling("quests.yml.bak"), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            }
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
            case "deliver" -> "Віддати предмети (за назвою)";
            case "item" -> "Віддати предмет з лівої руки (точний)";
            case "mob" -> "Привести моба в зону";
            case "talk" -> "Поговорити з NPC";
            default -> type;
        };
    }

    private void openQuestList(Player p) {
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&a+ Новий квест", v -> this.sync(() -> this.openQuestNew(p))));
        buttons.add(this.btn("&bЛінійки квестів", v -> this.sync(() -> this.openLineAdmin(p))));
        buttons.add(this.btn("&7Скопіювати id квесту...", v -> this.sync(() -> this.openQuestIds(p, () -> this.openQuestList(p)))));
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
        int dr = QuestNPC.parseHhmm(v.apply("dailyreset"));
        if (dr == -2) {
            p.sendMessage(this.text("&cЧас має бути у форматі ГГ:ХХ, напр. 04:00 - залишено попереднє значення."));
        } else {
            q.dailyReset = dr;
            if (dr >= 0) {
                q.repeatable = true;
            }
        }
        q.timeLimit = QuestNPC.parseDuration(v.apply("timelimit"));
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
        inputs.add(this.line("dailyreset", "Щоденне оновлення о (ГГ:ХХ, напр. 04:00; порожньо = немає)", q.dailyReset >= 0 ? QuestNPC.hhmm(q.dailyReset) : "", 5));
        inputs.add(this.line("timelimit", "Ліміт часу на виконання (напр. 30m, 2h; 0 = без)", q.timeLimit > 0L ? q.timeLimit + "s" : "0", 12));
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
                p.sendMessage(this.text("&aПредмет додано в нагороду (зачарування й назва збережені): &f" + this.itemNameStr(held) + " x" + held.getAmount()));
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
        buttons.add(this.copyBtn("&7Скопіювати id: &f" + q.id, q.id));
        buttons.add(this.copyBtn("&7Скопіювати дію «взяти»: &fquest:" + q.id, "quest:" + q.id));
        buttons.add(this.copyBtn("&7Скопіювати дію «здати»: &fturnin:" + q.id, "turnin:" + q.id));
        buttons.add(this.btn("&bВимоги, видавець, відповіді NPC", v -> this.sync(() -> {
            this.applyQuestFields(p, q, v);
            this.saveQuests();
            this.openReqEditor(p, q);
        })));
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
        buttons.add(this.btn("&dДублювати квест", v -> this.sync(() -> {
            this.applyQuestFields(p, q, v);
            this.saveQuests();
            Quest dup = this.copyQuest(q);
            this.quests.put(dup.id, dup);
            this.saveQuests();
            p.sendMessage(this.text("&aСтворено копію: &f" + dup.id + " &7(видавця NPC в копії скинуто)"));
            this.openQuestEditor(p, dup);
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
                for (Line dl : this.lines.values()) {
                    dl.quests.remove(q.id);
                }
                for (Quest oq2 : this.quests.values()) {
                    oq2.requires.remove(q.id);
                    oq2.excludes.remove(q.id);
                }
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
        for (String t : new String[]{"reach", "mob", "kill", "deliver", "item", "talk"}) {
            buttons.add(this.btn("&a+ " + QuestNPC.stageLabel(t), v -> this.sync(() -> {
                Stage sg = new Stage();
                sg.type = t;
                sg.text = QuestNPC.stageLabel(t);
                if (t.equals("reach") || t.equals("mob")) {
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
                    if (sg.npc >= 0 && !this.npcs.containsKey(sg.npc)) {
                        p.sendMessage(this.text("&eУвага: NPC #" + sg.npc + " не існує."));
                    }
                }
                case "mob" -> {
                    String mworld = QuestNPC.clean(v.apply("world"), sg.world);
                    if (Bukkit.getWorld(mworld) == null) {
                        p.sendMessage(this.text("&cСвіт \"" + mworld + "\" не знайдено."));
                        return false;
                    }
                    double mx = Double.parseDouble(QuestNPC.clean(v.apply("x"), "0").replace(',', '.'));
                    double my = Double.parseDouble(QuestNPC.clean(v.apply("y"), "64").replace(',', '.'));
                    double mz = Double.parseDouble(QuestNPC.clean(v.apply("z"), "0").replace(',', '.'));
                    double mr = Math.max(1.0, Double.parseDouble(QuestNPC.clean(v.apply("radius"), "5").replace(',', '.')));
                    String mh = QuestNPC.clean(v.apply("height"), "");
                    String mname = QuestNPC.clean(v.apply("mobname"), "");
                    if (mname.isEmpty()) {
                        p.sendMessage(this.text("&cВкажи назву моба (як на бирці)."));
                        return false;
                    }
                    String met = QuestNPC.clean(v.apply("entity"), "");
                    EntityType mtype = met.isEmpty() ? null : EntityType.valueOf(met.toUpperCase(Locale.ROOT));
                    sg.world = mworld;
                    sg.x = mx;
                    sg.y = my;
                    sg.z = mz;
                    sg.radius = mr;
                    sg.height = mh.isEmpty() ? -1.0 : Math.max(0.0, Double.parseDouble(mh.replace(',', '.')));
                    sg.mobName = mname;
                    sg.entity = mtype;
                }
                case "item" -> {
                    sg.amount = Math.max(1, Integer.parseInt(QuestNPC.clean(v.apply("amount"), "1")));
                    sg.npc = Integer.parseInt(QuestNPC.clean(v.apply("npc"), "-1"));
                    if (sg.npc >= 0 && !this.npcs.containsKey(sg.npc)) {
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
            sg.chat = QuestNPC.clean(v.apply("chat"), "");
            sg.chatNpc = Integer.parseInt(QuestNPC.clean(v.apply("chatnpc"), "-1"));
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
                inputs.add(this.line("npc", "№ NPC, якому віддати (-1 = забрати з інвентаря автоматично)", String.valueOf(sg.npc), 5));
            }
            case "mob" -> {
                inputs.add(this.line("world", "Світ", sg.world, 40));
                inputs.add(this.line("x", "X (центр зони)", QuestNPC.num(sg.x), 12));
                inputs.add(this.line("y", "Y", QuestNPC.num(sg.y), 12));
                inputs.add(this.line("z", "Z", QuestNPC.num(sg.z), 12));
                inputs.add(this.line("radius", "Радіус зони", QuestNPC.num(sg.radius), 8));
                inputs.add(this.line("height", "Допуск по висоті (порожньо = як радіус)", sg.height < 0.0 ? "" : QuestNPC.num(sg.height), 8));
                inputs.add(this.line("mobname", "Назва моба на бирці (як на name tag, без кольорів)", sg.mobName, 60));
                inputs.add(this.line("entity", "Тип моба (необов'язково, напр. COW; порожньо = будь-який)", sg.entity == null ? "" : sg.entity.name(), 40));
            }
            case "item" -> {
                inputs.add(this.line("amount", "Кількість", String.valueOf(sg.amount), 5));
                inputs.add(this.line("npc", "№ NPC, якому віддати (-1 = забрати з інвентаря автоматично)", String.valueOf(sg.npc), 5));
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
        inputs.add(this.block("chat", "Повідомлення від NPC в чаті гравцю, коли етап виконано (порожньо = немає)", sg.chat, 300));
        inputs.add(this.line("chatnpc", "№ NPC-мовця для цього повідомлення (-1 = NPC етапу або видавець квесту)", String.valueOf(sg.chatNpc), 5));
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&aЗберегти", v -> this.sync(() -> {
            if (this.applyStage(p, sg, v)) {
                this.saveQuests();
                p.sendMessage(this.text("&aЕтап збережено."));
            }
            this.openStageEditor(p, q, idx);
        })));
        if (sg.type.equals("reach") || sg.type.equals("mob")) {
            buttons.add(this.btn("Взяти мою позицію", v -> this.sync(() -> {
                this.applyStage(p, sg, v);
                this.fillHere(sg, p);
                this.saveQuests();
                this.openStageEditor(p, q, idx);
            })));
        }
        if (sg.type.equals("deliver") || sg.type.equals("item") || sg.type.equals("talk")) {
            buttons.add(this.btn("&bОбрати найближчого NPC (до 15 блоків)", v -> this.sync(() -> {
                this.applyStage(p, sg, v);
                Npc best = null;
                double bd = 15.0;
                for (Npc n0 : this.npcs.values()) {
                    if (n0.loc.getWorld() != p.getWorld()) {
                        continue;
                    }
                    double d = n0.loc.distance(p.getLocation());
                    if (d < bd) {
                        bd = d;
                        best = n0;
                    }
                }
                if (best == null) {
                    p.sendMessage(this.text("&cПоруч (до 15 блоків) немає NPC. Підійди до NPC і натисни ще раз."));
                } else {
                    sg.npc = best.id;
                    p.sendMessage(this.text("&aОбрано NPC №" + best.id + ": &f" + best.name));
                }
                this.saveQuests();
                this.openStageEditor(p, q, idx);
            })));
        }
        if (sg.type.equals("deliver")) {
            buttons.add(this.btn("&dВзяти предмет з лівої руки (точний, з зачаруваннями)", v -> this.sync(() -> {
                this.applyStage(p, sg, v);
                ItemStack held = p.getInventory().getItemInOffHand();
                if (held.getType().isAir()) {
                    p.sendMessage(this.text("&cПоклади предмет у ліву руку (клавіша F міняє руки)."));
                } else {
                    sg.stack = this.encode(held.clone());
                    sg.amount = held.getAmount();
                    sg.material = held.getType();
                    sg.type = "item";
                    p.sendMessage(this.text("&aТепер NPC прийме саме цей предмет (з назвою й зачаруваннями): &f" + this.itemNameStr(held) + " x" + held.getAmount()));
                }
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
                    p.sendMessage(this.text("&aПредмет оновлено: &f" + this.itemNameStr(held) + " x" + held.getAmount()));
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
            List.of(this.para("Квест: " + q.name + " &8(QuestNPC " + this.getPluginMeta().getVersion() + ")")), inputs,
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
        Entity m = this.entityOf(n);
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
        this.bubbleNpc.put(id, n.id);
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
        for (Quest gq : this.quests.values()) {
            if (gq.giver == n.id) {
                ids.add(gq.id);
            }
        }
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
        if (st == null && this.blockReason(p, q) != null) {
            return "&8[Закрито] &7";
        }
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
        String lock = fresh ? this.blockReason(p, q) : null;
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
        Component rw = this.rewardsComponent(q);
        if (rw != null) {
            body.add(DialogBody.plainMessage(rw));
        }
        if (q.dailyReset >= 0) {
            body.add(DialogBody.plainMessage((Component) this.fmt("&7Оновлюється щодня о &f" + QuestNPC.hhmm(q.dailyReset), p)));
        }
        if (q.timeLimit > 0L) {
            body.add(DialogBody.plainMessage((Component) this.fmt("&cЛіміт часу: &f" + QuestNPC.fmtDuration(q.timeLimit), p)));
        }
        if (lock != null) {
            body.add(DialogBody.plainMessage((Component) this.fmt("&cКвест закрито: &f" + lock, p)));
        }
        List<ActionButton> buttons = new ArrayList<>();
        if (fresh) {
            if (lock == null) {
                buttons.add(this.btn("&aПрийняти квест", v -> this.sync(() -> {
                    if (this.startQuest(p, q.id) && !q.acceptReply.isBlank()) {
                        this.openReply(p, n, q.acceptReply);
                    } else {
                        this.openQuestDetail(p, n, q);
                    }
                })));
            }
        } else if ("READY".equals(st.status)) {
            buttons.add(this.btn("&6Здати квест", v -> this.sync(() -> {
                this.turnIn(p, q.id);
                this.openQuestDetail(p, n, q);
            })));
        }
        ActionButton back = this.btn(fresh && lock == null ? "&cВідхилити" : "&7Назад", v -> this.sync(() -> {
            if (fresh && lock == null && !q.declineReply.isBlank()) {
                this.openReply(p, n, q.declineReply);
            } else {
                this.openQuestMenu(p, n);
            }
        }));
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
        if (st == null || !"DONE".equals(st.status)) {
            return 0L;
        }
        long left = 0L;
        if (q.cooldown > 0L) {
            left = Math.max(0L, st.doneAt + q.cooldown * 1000L - System.currentTimeMillis());
        }
        if (q.dailyReset >= 0) {
            left = Math.max(left, this.dailyLeft(q, st));
        }
        return left;
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
            return this.itemNameStr(s0);
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
            this.autoCollect(p);
            this.checkTimeouts(p);
            this.updateTracker(p);
            this.updateMarkers(p);
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
        Component title = LEGACY.deserialize("&6&l" + q.name + " &8▸ ").append(this.describeC(p, q, st));
        if (q.timeLimit > 0L && "ACTIVE".equals(st.status) && st.startedAt > 0L) {
            long leftMs = Math.max(0L, st.startedAt + q.timeLimit * 1000L - System.currentTimeMillis());
            title = title.append(LEGACY.deserialize(" &c[" + QuestNPC.clock(leftMs / 1000L) + "]"));
        }
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
                body.add(DialogBody.plainMessage(LEGACY.deserialize((q == tq ? "&e★ " : "") + "&6&l" + q.name + desc + "\n").append(this.describeC(p, q, st))));
                if (q != tq) {
                    buttons.add(this.btn("&eВідстежувати: " + q.name, v -> this.sync(() -> {
                        this.tracked.put(id, q.id);
                        this.progressDirty = true;
                        this.updateTracker(p);
                        this.openJournal(p);
                    })));
                }
                if (this.getConfig().getBoolean("quest.allow-cancel", true)) {
                    buttons.add(this.btn("&cСкасувати: " + q.name, v -> this.sync(() -> this.openCancelConfirm(p, q))));
                }
            }
        }
        if (body.isEmpty()) {
            body.add(this.para("&7Активних квестів немає. Поговори з жителями, щоб отримати завдання."));
        }
        if (!this.lines.isEmpty()) {
            buttons.add(this.btn("&bЛінійки квестів", v -> this.sync(() -> this.openLines(p))));
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

    // ======================= v0.5.2: АВТОЗБІР ПРЕДМЕТІВ, ГАРНИЙ ОПИС ЕТАПУ =======================

    private Component npcSuffix(int id) {
        Npc n = this.npcs.get(id);
        return n == null ? Component.empty() : LEGACY.deserialize(" &8→ &7" + n.name);
    }

    /** Опис поточного етапу для панелі та журналу: з перекладеними назвами предметів і прогресом. */
    private Component describeC(Player p, Quest q, QState st) {
        if ("READY".equals(st.status)) {
            return LEGACY.deserialize("&aУсе виконано. Віддай квест NPC.");
        }
        if (st.stage >= q.stages.size()) {
            return Component.empty();
        }
        Stage sg = q.stages.get(st.stage);
        Component out = LEGACY.deserialize("&f" + sg.text);
        if (sg.type.equals("kill")) {
            return out.append(LEGACY.deserialize(" &7(" + st.count + "/" + sg.amount + ")"));
        }
        if (sg.type.equals("deliver") || sg.type.equals("item")) {
            Component name = Component.text("?");
            int have = 0;
            try {
                if (sg.type.equals("deliver") && sg.material != null) {
                    Material mat = sg.material;
                    name = Component.translatable(mat.translationKey());
                    have = this.countStack(p, it -> it.getType() == mat);
                } else if (sg.type.equals("item")) {
                    ItemStack tpl = this.stackOf(sg.stack);
                    ItemMeta im = tpl.getItemMeta();
                    name = im != null && im.hasDisplayName() ? im.displayName() : Component.translatable(tpl.getType().translationKey());
                    have = this.countStack(p, it -> it.isSimilar(tpl));
                }
            } catch (RuntimeException ex) {
                name = Component.text("?");
            }
            return out.append(LEGACY.deserialize(" &7(" + Math.min(have, sg.amount) + "/" + sg.amount + " "))
                .append(name.colorIfAbsent(net.kyori.adventure.text.format.NamedTextColor.GRAY))
                .append(LEGACY.deserialize("&7)"))
                .append(this.npcSuffix(sg.npc));
        }
        if (sg.type.equals("talk")) {
            return out.append(this.npcSuffix(sg.npc));
        }
        if (sg.type.equals("mob")) {
            String near = "";
            if (p.getWorld().getName().equals(sg.world)) {
                double dx = p.getLocation().getX() - sg.x;
                double dy = p.getLocation().getY() - sg.y;
                double dz = p.getLocation().getZ() - sg.z;
                near = " &8→ " + (int) Math.sqrt(dx * dx + dy * dy + dz * dz) + " м";
            }
            return out.append(LEGACY.deserialize(" &7(привести «" + sg.mobName + "»)" + near));
        }
        return LEGACY.deserialize(this.describe(p, q, st));
    }

    /** Етапи з предметами без NPC (№ NPC = -1): предмети автоматично забираються з інвентаря. */
    private void autoCollect(Player p) {
        Map<String, QState> m = this.progress.get(p.getUniqueId());
        if (m == null) {
            return;
        }
        for (Map.Entry<String, QState> en : new ArrayList<Map.Entry<String, QState>>(m.entrySet())) {
            QState st = en.getValue();
            Quest q = this.quests.get(en.getKey());
            if (q == null || !"ACTIVE".equals(st.status) || st.stage >= q.stages.size()) {
                continue;
            }
            Stage sg = q.stages.get(st.stage);
            if (sg.npc >= 0) {
                continue;
            }
            ItemStack take = null;
            String label = "";
            if (sg.type.equals("deliver") && sg.material != null) {
                if (p.getInventory().containsAtLeast(new ItemStack(sg.material), sg.amount)) {
                    take = new ItemStack(sg.material, sg.amount);
                    label = sg.material.name();
                }
            } else if (sg.type.equals("item")) {
                try {
                    ItemStack tpl = this.stackOf(sg.stack);
                    ItemStack one = tpl.clone();
                    one.setAmount(1);
                    if (p.getInventory().containsAtLeast(one, sg.amount)) {
                        take = tpl;
                        take.setAmount(sg.amount);
                        label = this.stackLabel(sg);
                    }
                } catch (RuntimeException ex) {
                    continue;
                }
            }
            if (take == null) {
                continue;
            }
            p.getInventory().removeItem(new ItemStack[]{take});
            p.sendMessage(this.text("&7З інвентаря забрано: &f" + sg.amount + " x " + label));
            this.advance(p, q, st);
            if (!sg.reply.isBlank()) {
                p.sendMessage(this.fmt(sg.reply, p));
            }
        }
    }

    // ======================= v0.5.3: ПРИЙНЯТИ/ВІДХИЛИТИ, СКАСУВАТИ, СПОВІЩЕННЯ =======================

    private boolean canStart(Player p, Quest q) {
        QState st = this.stateOf(p, q.id);
        return (st == null || "DONE".equals(st.status) && q.repeatable && this.cooldownLeft(q, st) == 0L) && this.blockReason(p, q) == null && !this.limitReached(p);
    }

    /** Вікно пропозиції квесту: опис, завдання, нагорода та кнопки «Прийняти» / «Відхилити». */
    private void openQuestOffer(Player p, Npc n, Quest q, Runnable onAccept, Runnable onDecline) {
        List<DialogBody> body = new ArrayList<>();
        if (!q.description.isBlank()) {
            body.add(DialogBody.plainMessage((Component) this.fmt(q.description, p)));
        }
        StringBuilder sb = new StringBuilder("&6Завдання:");
        for (int i = 0; i < q.stages.size(); i++) {
            sb.append("\n&7").append(i + 1).append(". &f").append(q.stages.get(i).text);
        }
        body.add(DialogBody.plainMessage((Component) this.fmt(sb.toString(), p)));
        Component rw = this.rewardsComponent(q);
        if (rw != null) {
            body.add(DialogBody.plainMessage(rw));
        }
        if (q.repeatable) {
            body.add(DialogBody.plainMessage((Component) this.fmt(q.cooldown > 0L
                ? "&7Повторюваний, кулдаун: &f" + QuestNPC.fmtDuration(q.cooldown) : "&7Повторюваний", p)));
        }
        if (q.dailyReset >= 0) {
            body.add(DialogBody.plainMessage((Component) this.fmt("&7Оновлюється щодня о &f" + QuestNPC.hhmm(q.dailyReset), p)));
        }
        if (q.timeLimit > 0L) {
            body.add(DialogBody.plainMessage((Component) this.fmt("&cЛіміт часу: &f" + QuestNPC.fmtDuration(q.timeLimit), p)));
        }
        ConfirmationType type = DialogType.confirmation(
            (ActionButton) this.btn("&aПрийняти", v -> this.sync(() -> {
                if (this.startQuest(p, q.id)) {
                    if (!q.acceptReply.isBlank()) {
                        this.openReply(p, n, q.acceptReply);
                    } else {
                        onAccept.run();
                    }
                } else {
                    onDecline.run();
                }
            })),
            (ActionButton) this.btn("&cВідхилити", v -> this.sync(() -> {
                p.sendMessage(this.text("&7Ти відмовився від квесту: &f" + q.name));
                if (!q.declineReply.isBlank()) {
                    this.openReply(p, n, q.declineReply);
                } else {
                    onDecline.run();
                }
            })));
        p.showDialog((DialogLike) this.dialog("&6" + q.name, body, List.of(), (DialogType) type));
    }

    private void openCancelConfirm(Player p, Quest q) {
        ConfirmationType type = DialogType.confirmation(
            (ActionButton) this.btn("&cТак, скасувати", v -> this.sync(() -> {
                Map<String, QState> m = this.progress.get(p.getUniqueId());
                if (m != null) {
                    m.remove(q.id);
                }
                this.saveProgress();
                this.updateTracker(p);
                p.sendMessage(this.text("&7Квест скасовано: &f" + q.name + "&7. Його можна взяти знову."));
                this.openJournal(p);
            })),
            (ActionButton) this.btn("&7Ні", v -> this.sync(() -> this.openJournal(p))));
        p.showDialog((DialogLike) this.dialog("&cСкасувати квест?",
            List.of(this.para("Прогрес квесту «" + q.name + "» буде втрачено. Предмети, які вже віддані NPC, не повертаються.")),
            List.of(), (DialogType) type));
    }

    private void notifyTitle(Player p, String main, String sub) {
        if (!this.getConfig().getBoolean("notify.title", true)) {
            return;
        }
        p.showTitle(net.kyori.adventure.title.Title.title(LEGACY.deserialize(main), LEGACY.deserialize(sub),
            net.kyori.adventure.title.Title.Times.times(java.time.Duration.ofMillis(300L), java.time.Duration.ofSeconds(3L), java.time.Duration.ofMillis(800L))));
    }

    // ======================= v0.6.0: ЛІНІЙКИ КВЕСТІВ, ВИМОГИ, ВИДАВЕЦЬ =======================

    /** Причина, чому квест зараз закритий для гравця; null = відкритий. */
    private String blockReason(Player p, Quest q) {
        if (q.minLevel > 0 && p.getLevel() < q.minLevel) {
            return "потрібен рівень " + q.minLevel;
        }
        for (String rid : q.requires) {
            QState st = this.stateOf(p, rid);
            if (st == null || !"DONE".equals(st.status)) {
                Quest r = this.quests.get(rid);
                return "спершу виконай: " + (r == null ? rid : r.name);
            }
        }
        for (String eid : q.excludes) {
            if (this.stateOf(p, eid) != null) {
                Quest e = this.quests.get(eid);
                return "несумісний з квестом: " + (e == null ? eid : e.name);
            }
        }
        return null;
    }

    private int lineDone(Player p, Line ln) {
        int n = 0;
        for (String qid : ln.quests) {
            QState st = this.stateOf(p, qid);
            if (st != null && "DONE".equals(st.status)) {
                n++;
            }
        }
        return n;
    }

    /** Нагорода за повне проходження лінійки (один раз на гравця). */
    private void checkLines(Player p) {
        for (Line ln : this.lines.values()) {
            if (ln.quests.isEmpty()) {
                continue;
            }
            java.util.Set<String> done = this.linesDone.computeIfAbsent(p.getUniqueId(), k -> new java.util.HashSet<>());
            if (done.contains(ln.id) || this.lineDone(p, ln) < ln.quests.size()) {
                continue;
            }
            done.add(ln.id);
            this.progressDirty = true;
            p.sendMessage(this.text("&b&lЛінійку квестів завершено: &f" + ln.name));
            this.notifyTitle(p, "&b&lЛінійку завершено!", "&f" + ln.name);
            if (ln.xp > 0) {
                p.giveExp(ln.xp);
            }
            for (String cmd : ln.commands) {
                Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(), cmd.replace("{player}", p.getName()));
            }
        }
    }

    // ---- для гравця ----

    private void openLines(Player p) {
        List<ActionButton> buttons = new ArrayList<>();
        for (Line ln : this.lines.values()) {
            buttons.add(this.btn(ln.name + " &7(" + this.lineDone(p, ln) + "/" + ln.quests.size() + ")",
                v -> this.sync(() -> this.openLineView(p, ln))));
        }
        if (buttons.isEmpty()) {
            this.openJournal(p);
            return;
        }
        p.showDialog((DialogLike) this.dialog("&bЛінійки квестів",
            List.of(this.para("Обери лінійку, щоб побачити її квести та прогрес.")), List.of(),
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openJournal(p))), (int) 1)));
    }

    private void openLineView(Player p, Line ln) {
        List<DialogBody> body = new ArrayList<>();
        if (!ln.description.isBlank()) {
            body.add(DialogBody.plainMessage((Component) this.fmt(ln.description, p)));
        }
        StringBuilder sb = new StringBuilder("&bКвести лінійки:");
        int i = 1;
        for (String qid : ln.quests) {
            Quest q = this.quests.get(qid);
            if (q == null) {
                continue;
            }
            QState st = this.stateOf(p, qid);
            String why = st == null ? this.blockReason(p, q) : null;
            String mark;
            if (st != null && "DONE".equals(st.status)) {
                mark = "&a✔ &7";
            } else if (st != null && "READY".equals(st.status)) {
                mark = "&6! &f";
            } else if (st != null) {
                mark = "&e▶ &f";
            } else {
                mark = why != null ? "&8✖ &8" : "&f○ &f";
            }
            sb.append("\n").append(mark).append(i++).append(". ").append(q.name);
            if (why != null) {
                sb.append(" &7(").append(why).append(")");
            }
        }
        body.add(DialogBody.plainMessage((Component) this.fmt(sb.toString(), p)));
        List<String> rewards = new ArrayList<>();
        if (ln.xp > 0) {
            rewards.add(ln.xp + " досвіду");
        }
        if (!ln.commands.isEmpty()) {
            rewards.add("особлива нагорода");
        }
        if (!rewards.isEmpty()) {
            body.add(DialogBody.plainMessage((Component) this.fmt("&6Нагорода за всю лінійку: &f" + String.join(", ", rewards), p)));
        }
        p.showDialog((DialogLike) this.dialog("&b" + ln.name, body, List.of(),
            (DialogType) DialogType.notice((ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openLines(p))))));
    }

    // ---- редактор вимог квесту ----

    private void applyReq(Player p, Quest q, Function<String, String> v) {
        List<String> req = new ArrayList<>();
        for (String raw : QuestNPC.lines(v.apply("requires"))) {
            String id = raw.toLowerCase(Locale.ROOT);
            if (id.equals(q.id) || !this.quests.containsKey(id)) {
                p.sendMessage(this.text("&cКвест пропущено у вимогах (немає такого id): &f" + raw));
                continue;
            }
            req.add(id);
        }
        q.requires = req;
        List<String> exc = new ArrayList<>();
        for (String raw : QuestNPC.lines(v.apply("excludes"))) {
            String id = raw.toLowerCase(Locale.ROOT);
            if (id.equals(q.id) || !this.quests.containsKey(id)) {
                p.sendMessage(this.text("&cКвест пропущено у несумісних (немає такого id): &f" + raw));
                continue;
            }
            exc.add(id);
        }
        q.excludes = exc;
        try {
            q.minLevel = Math.max(0, Integer.parseInt(QuestNPC.clean(v.apply("minlevel"), "0")));
        } catch (NumberFormatException ex) {
            p.sendMessage(this.text("&cРівень має бути цілим числом - залишено попереднє значення."));
        }
        q.acceptReply = QuestNPC.clean(v.apply("acceptreply"), "");
        q.declineReply = QuestNPC.clean(v.apply("declinereply"), "");
        try {
            q.giver = Integer.parseInt(QuestNPC.clean(v.apply("giver"), "-1"));
            if (q.giver >= 0 && !this.npcs.containsKey(q.giver)) {
                p.sendMessage(this.text("&eУвага: NPC #" + q.giver + " не існує."));
            }
        } catch (NumberFormatException ex) {
            p.sendMessage(this.text("&c№ NPC має бути цілим числом - залишено попереднє значення."));
        }
    }

    private void openReqEditor(Player p, Quest q) {
        List<DialogInput> inputs = new ArrayList<>();
        inputs.add(this.block("requires", "Вимоги: id квестів, які треба виконати раніше (кожен з нового рядка)", String.join("\n", q.requires), 400));
        inputs.add(this.block("excludes", "Несумісні: якщо гравець узяв один з цих квестів, цей закривається (id, з нового рядка)", String.join("\n", q.excludes), 400));
        inputs.add(this.line("minlevel", "Мінімальний рівень досвіду гравця (0 = без обмеження)", String.valueOf(q.minLevel), 4));
        inputs.add(this.line("giver", "№ NPC, який видає квест (-1 = лише через кнопку в діалозі)", String.valueOf(q.giver), 5));
        inputs.add(this.block("acceptreply", "Відповідь NPC, коли гравець приймає квест (порожньо = без відповіді)", q.acceptReply, 400));
        inputs.add(this.block("declinereply", "Відповідь NPC, коли гравець відхиляє квест (порожньо = без відповіді)", q.declineReply, 400));
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&7Скопіювати id квестів...", v -> this.sync(() -> {
            this.applyReq(p, q, v);
            this.saveQuests();
            this.openQuestIds(p, () -> this.openReqEditor(p, q));
        })));
        buttons.add(this.btn("&aЗберегти", v -> this.sync(() -> {
            this.applyReq(p, q, v);
            this.saveQuests();
            p.sendMessage(this.text("&aВимоги збережено."));
            this.openReqEditor(p, q);
        })));
        p.showDialog((DialogLike) this.dialog("&5Вимоги: " + q.name,
            List.of(this.para("Усі id квестів: " + String.join(", ", this.quests.keySet()))),
            inputs,
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openQuestEditor(p, q))), (int) 1)));
    }

    // ---- редактор лінійок ----

    private void openLineAdmin(Player p) {
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&a+ Нова лінійка", v -> this.sync(() -> this.openLineNew(p))));
        for (Line ln : this.lines.values()) {
            buttons.add(this.btn(ln.name + " &8(" + ln.quests.size() + " кв.)", v -> this.sync(() -> this.openLineEditor(p, ln))));
        }
        p.showDialog((DialogLike) this.dialog("&bЛінійки квестів",
            List.of(this.para("Лінійка - це група квестів з прогресом і нагородою за повне проходження.")), List.of(),
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openQuestList(p))), (int) 1)));
    }

    private void openLineNew(Player p) {
        ConfirmationType type = DialogType.confirmation(
            (ActionButton) this.btn("&aСтворити", v -> this.sync(() -> {
                String name = QuestNPC.clean(v.apply("linename"), "");
                if (name.isEmpty()) {
                    p.sendMessage(this.text("&cВведи назву лінійки."));
                    this.openLineNew(p);
                    return;
                }
                String base = QuestNPC.slug(name);
                String id = base;
                int i = 2;
                while (this.lines.containsKey(id)) {
                    id = base + "_" + i++;
                }
                Line ln = new Line();
                ln.id = id;
                ln.name = name;
                this.lines.put(id, ln);
                this.saveQuests();
                p.sendMessage(this.text("&aЛінійку створено. Додай у неї квести."));
                this.openLineEditor(p, ln);
            })),
            (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openLineAdmin(p))));
        p.showDialog((DialogLike) this.dialog("&bНова лінійка",
            List.of(this.para("Достатньо написати назву, id створиться автоматично.")),
            List.of(this.line("linename", "Назва лінійки", "", 60)),
            (DialogType) type));
    }

    private void applyLine(Player p, Line ln, Function<String, String> v) {
        ln.name = QuestNPC.clean(v.apply("linename"), ln.id);
        ln.description = QuestNPC.clean(v.apply("linedesc"), "");
        try {
            ln.xp = Math.max(0, Integer.parseInt(QuestNPC.clean(v.apply("linexp"), "0")));
        } catch (NumberFormatException ex) {
            p.sendMessage(this.text("&cДосвід має бути цілим числом - залишено попереднє значення."));
        }
        List<String> cmds = new ArrayList<>();
        for (String c : QuestNPC.lines(v.apply("linecmds"))) {
            cmds.add(c.startsWith("/") ? c.substring(1) : c);
        }
        ln.commands = cmds;
    }

    private void openLineEditor(Player p, Line ln) {
        List<DialogInput> inputs = new ArrayList<>();
        inputs.add(this.line("linename", "Назва лінійки", ln.name, 60));
        inputs.add(this.block("linedesc", "Опис лінійки", ln.description, 500));
        inputs.add(this.line("linexp", "Нагорода за всю лінійку: досвід", String.valueOf(ln.xp), 7));
        inputs.add(this.block("linecmds", "Нагорода за всю лінійку: команди від консолі ({player} = нік, по одній в рядок)", String.join("\n", ln.commands), 500));
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&aЗберегти", v -> this.sync(() -> {
            this.applyLine(p, ln, v);
            this.saveQuests();
            p.sendMessage(this.text("&aЛінійку збережено."));
            this.openLineEditor(p, ln);
        })));
        buttons.add(this.btn("Квести лінійки: " + ln.quests.size(), v -> this.sync(() -> {
            this.applyLine(p, ln, v);
            this.saveQuests();
            this.openLineQuests(p, ln);
        })));
        buttons.add(this.btn("&cВидалити лінійку", v -> this.sync(() -> {
            ConfirmationType type = DialogType.confirmation(
                (ActionButton) this.btn("&cТак, видалити", v2 -> this.sync(() -> {
                    this.lines.remove(ln.id);
                    this.saveQuests();
                    p.sendMessage(this.text("&aЛінійку видалено (квести лишились)."));
                    this.openLineAdmin(p);
                })),
                (ActionButton) this.btn("&7Ні", v2 -> this.sync(() -> this.openLineEditor(p, ln))));
            p.showDialog((DialogLike) this.dialog("&cВидалити лінійку?",
                List.of(this.para("Лінійка «" + ln.name + "» буде видалена. Самі квести не видаляються.")),
                List.of(), (DialogType) type));
        })));
        p.showDialog((DialogLike) this.dialog("&bЛінійка: " + ln.id, List.of(this.para("Порядок квестів у лінійці такий, в якому ти їх додаєш. Щоб змінити порядок, прибери й додай квест знову. Обмеження \"хто за ким\" задаються у вимогах самого квесту.")),
            inputs,
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openLineAdmin(p))), (int) 1)));
    }

    private void openLineQuests(Player p, Line ln) {
        List<ActionButton> buttons = new ArrayList<>();
        for (Quest q : this.quests.values()) {
            int pos = ln.quests.indexOf(q.id);
            buttons.add(this.btn((pos >= 0 ? "&a[" + (pos + 1) + "] " : "&7[ ] ") + "&f" + q.name, v -> this.sync(() -> {
                if (!ln.quests.remove(q.id)) {
                    ln.quests.add(q.id);
                }
                this.saveQuests();
                this.openLineQuests(p, ln);
            })));
        }
        if (buttons.isEmpty()) {
            p.sendMessage(this.text("&cСпершу створи квести."));
            this.openLineEditor(p, ln);
            return;
        }
        p.showDialog((DialogLike) this.dialog("&bКвести лінійки: " + ln.name,
            List.of(this.para("Натисни квест, щоб додати його в лінійку або прибрати. Цифра - номер у лінійці.")), List.of(),
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openLineEditor(p, ln))), (int) 1)));
    }

    // ======================= v0.6.1: ЗНАКИ НАД NPC, ЩОДЕННІ КВЕСТИ, ЛІМІТИ, ДУБЛЮВАННЯ =======================

    private final Map<UUID, Map<Integer, org.bukkit.entity.TextDisplay>> markers = new HashMap<>();
    private final Map<UUID, Integer> bubbleNpc = new HashMap<>();

    private java.time.ZoneId zone() {
        String z = this.getConfig().getString("daily.timezone", "");
        try {
            return z == null || z.isBlank() ? java.time.ZoneId.systemDefault() : java.time.ZoneId.of(z);
        } catch (java.time.DateTimeException ex) {
            return java.time.ZoneId.systemDefault();
        }
    }

    /** Скільки мс лишилось до найближчого щоденного оновлення після виконання квесту. */
    private long dailyLeft(Quest q, QState st) {
        java.time.ZoneId zone = this.zone();
        java.time.ZonedDateTime done = java.time.Instant.ofEpochMilli(st.doneAt).atZone(zone);
        java.time.ZonedDateTime next = done.toLocalDate().atTime(q.dailyReset / 60, q.dailyReset % 60).atZone(zone);
        if (!next.isAfter(done)) {
            next = next.plusDays(1L);
        }
        return Math.max(0L, next.toInstant().toEpochMilli() - System.currentTimeMillis());
    }

    private static String hhmm(int minutes) {
        return String.format(Locale.ROOT, "%02d:%02d", minutes / 60, minutes % 60);
    }

    /** ГГ:ХХ у хвилини від півночі; -1 = порожньо, -2 = неправильний формат. */
    private static int parseHhmm(String raw) {
        if (raw == null || raw.isBlank()) {
            return -1;
        }
        String[] part = raw.trim().replace('.', ':').split(":");
        try {
            int h = Integer.parseInt(part[0].trim());
            int m = part.length > 1 ? Integer.parseInt(part[1].trim()) : 0;
            if (h < 0 || h > 23 || m < 0 || m > 59) {
                return -2;
            }
            return h * 60 + m;
        } catch (NumberFormatException ex) {
            return -2;
        }
    }

    private static String clock(long s) {
        if (s >= 3600L) {
            return String.format(Locale.ROOT, "%d:%02d:%02d", s / 3600L, s % 3600L / 60L, s % 60L);
        }
        return String.format(Locale.ROOT, "%d:%02d", s / 60L, s % 60L);
    }

    private int activeCount(Player p) {
        Map<String, QState> m = this.progress.get(p.getUniqueId());
        int n = 0;
        if (m != null) {
            for (QState st : m.values()) {
                if ("ACTIVE".equals(st.status)) {
                    n++;
                }
            }
        }
        return n;
    }

    private boolean limitReached(Player p) {
        int max = this.getConfig().getInt("quest.max-active", 0);
        return max > 0 && this.activeCount(p) >= max;
    }

    /** Квести з ліміту часу: якщо час вийшов, квест провалено й скинуто. */
    private void checkTimeouts(Player p) {
        Map<String, QState> m = this.progress.get(p.getUniqueId());
        if (m == null) {
            return;
        }
        for (Map.Entry<String, QState> en : new ArrayList<Map.Entry<String, QState>>(m.entrySet())) {
            QState st = en.getValue();
            Quest q = this.quests.get(en.getKey());
            if (q == null || q.timeLimit <= 0L || !"ACTIVE".equals(st.status) || st.startedAt <= 0L) {
                continue;
            }
            if (System.currentTimeMillis() - st.startedAt < q.timeLimit * 1000L) {
                continue;
            }
            m.remove(q.id);
            this.progressDirty = true;
            p.sendMessage(this.text("&c&lЧас вийшов! &7Квест провалено: &f" + q.name + "&7. Його можна взяти знову."));
            this.notifyTitle(p, "&c&lКвест провалено", "&f" + q.name);
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 0.8f);
        }
    }

    private Quest copyQuest(Quest q) {
        String base = q.id + "_copy";
        String id = base;
        int i = 2;
        while (this.quests.containsKey(id)) {
            id = base + "_" + i++;
        }
        Quest c = new Quest();
        c.id = id;
        c.name = q.name + " (копія)";
        c.description = q.description;
        c.repeatable = q.repeatable;
        c.turnIn = q.turnIn;
        c.cooldown = q.cooldown;
        c.dailyReset = q.dailyReset;
        c.timeLimit = q.timeLimit;
        c.requires = new ArrayList<>(q.requires);
        c.excludes = new ArrayList<>(q.excludes);
        c.minLevel = q.minLevel;
        c.giver = -1;
        c.xp = q.xp;
        c.items = new ArrayList<>(q.items);
        c.stacks = new ArrayList<>(q.stacks);
        c.commands = new ArrayList<>(q.commands);
        c.acceptReply = q.acceptReply;
        c.declineReply = q.declineReply;
        for (Stage s0 : q.stages) {
            Stage s1 = new Stage();
            s1.type = s0.type;
            s1.text = s0.text;
            s1.world = s0.world;
            s1.x = s0.x;
            s1.y = s0.y;
            s1.z = s0.z;
            s1.radius = s0.radius;
            s1.height = s0.height;
            s1.entity = s0.entity;
            s1.amount = s0.amount;
            s1.material = s0.material;
            s1.npc = s0.npc;
            s1.stack = s0.stack;
            s1.reply = s0.reply;
            s1.replyFail = s0.replyFail;
            s1.mobName = s0.mobName;
            s1.chat = s0.chat;
            s1.chatNpc = s0.chatNpc;
            c.stages.add(s1);
        }
        return c;
    }

    // ---- знаки «!» і «?» над NPC (кожен гравець бачить свої) ----

    private void collectByPrefix(Node node, String prefix, java.util.Set<String> out) {
        for (Choice c : node.choices) {
            String a = c.action == null ? "" : c.action.trim().toLowerCase(Locale.ROOT);
            if (a.startsWith(prefix)) {
                out.add(a.substring(prefix.length()).trim());
            }
            if (c.next != null) {
                this.collectByPrefix(c.next, prefix, out);
            }
        }
    }

    /** 0 = немає знака, 1 = «!» (є новий квест), 2 = золоте «?» (є що здати), 3 = сіре «?» (квест веде до цього NPC). */
    private int markerState(Player p, Npc n) {
        Map<String, QState> m = this.progress.get(p.getUniqueId());
        List<Quest> listed = this.npcQuests(p, n);
        for (Quest q : listed) {
            QState st = m == null ? null : m.get(q.id);
            if (st != null && "READY".equals(st.status)) {
                return 2;
            }
        }
        java.util.Set<String> offer = new java.util.LinkedHashSet<>();
        this.collectByPrefix(n.root, "quest:", offer);
        for (Quest gq : this.quests.values()) {
            if (gq.giver == n.id) {
                offer.add(gq.id);
            }
        }
        for (String id : offer) {
            Quest q = this.quests.get(id);
            if (q != null && this.canStart(p, q)) {
                return 1;
            }
        }
        for (Quest q : listed) {
            QState st = m == null ? null : m.get(q.id);
            if (st != null && "ACTIVE".equals(st.status) && st.stage < q.stages.size() && q.stages.get(st.stage).npc == n.id) {
                return 3;
            }
        }
        return 0;
    }

    private void updateMarkers(Player p) {
        UUID id = p.getUniqueId();
        boolean on = this.getConfig().getBoolean("markers.enabled", true);
        double range = this.getConfig().getDouble("markers.range", 32.0);
        double offset = this.getConfig().getDouble("markers.height-offset", 0.9);
        Map<Integer, org.bukkit.entity.TextDisplay> mine = this.markers.computeIfAbsent(id, k -> new HashMap<>());
        java.util.Set<Integer> keep = new java.util.HashSet<>();
        if (on) {
            for (Npc n : this.npcs.values()) {
                if (n.loc == null || n.loc.getWorld() == null || n.entity == null || !n.loc.getWorld().equals(p.getWorld())) {
                    continue;
                }
                if (n.loc.distanceSquared(p.getLocation()) > range * range) {
                    continue;
                }
                if (!n.loc.getWorld().isChunkLoaded(n.loc.getBlockX() >> 4, n.loc.getBlockZ() >> 4)) {
                    continue;
                }
                int state = this.markerState(p, n);
                Integer bn = this.bubbleNpc.get(id);
                if (state == 0 || bn != null && bn == n.id && this.bubbles.containsKey(id)) {
                    continue;
                }
                Entity ent = n.loc.getWorld().getEntity(n.entity);
                if (ent == null) {
                    continue;
                }
                Location at = ent.getLocation().add(0.0, ent.getHeight() + offset, 0.0);
                final Component label = LEGACY.deserialize(state == 1 ? "&e&l!" : state == 2 ? "&6&l?" : "&7&l?");
                org.bukkit.entity.TextDisplay d = mine.get(n.id);
                if (d == null || !d.isValid()) {
                    d = ent.getWorld().spawn(at, org.bukkit.entity.TextDisplay.class, d0 -> {
                        d0.setPersistent(false);
                        d0.setVisibleByDefault(false);
                        d0.text(label);
                        d0.setBillboard(org.bukkit.entity.Display.Billboard.CENTER);
                        d0.setBackgroundColor(org.bukkit.Color.fromARGB(0, 0, 0, 0));
                        d0.setShadowed(true);
                        d0.setTransformation(new org.bukkit.util.Transformation(new org.joml.Vector3f(), new org.joml.AxisAngle4f(),
                            new org.joml.Vector3f(2.0f, 2.0f, 2.0f), new org.joml.AxisAngle4f()));
                    });
                    p.showEntity(this, d);
                    mine.put(n.id, d);
                } else {
                    d.text(label);
                    if (d.getLocation().distanceSquared(at) > 0.01) {
                        d.teleport(at);
                    }
                }
                keep.add(n.id);
            }
        }
        java.util.Iterator<Map.Entry<Integer, org.bukkit.entity.TextDisplay>> it = mine.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, org.bukkit.entity.TextDisplay> en = it.next();
            if (!keep.contains(en.getKey())) {
                if (en.getValue().isValid()) {
                    en.getValue().remove();
                }
                it.remove();
            }
        }
    }

    private void removeMarkers(Player p) {
        Map<Integer, org.bukkit.entity.TextDisplay> mine = this.markers.remove(p.getUniqueId());
        if (mine != null) {
            for (org.bukkit.entity.TextDisplay d : mine.values()) {
                if (d.isValid()) {
                    d.remove();
                }
            }
        }
    }

    /** Репліка NPC: перший раз основний текст, потім (або після кулдауну) повторна репліка. */
    private String nodeText(Player p, Node node) {
        if (node.again.isBlank()) {
            return node.text;
        }
        long now = System.currentTimeMillis();
        Map<String, Long> uses = this.choiceUses.computeIfAbsent(p.getUniqueId(), k -> new HashMap<>());
        String key = "n" + node.uid;
        Long last = uses.get(key);
        if (last != null && (node.againCd <= 0L || now - last < node.againCd * 1000L)) {
            return node.again;
        }
        uses.put(key, now);
        this.progressDirty = true;
        return node.text;
    }

    // ======================= v0.6.5: КОПІЮВАННЯ ID КВЕСТІВ =======================

    /** Кнопка, яка копіює текст у буфер обміну гравця. */
    private ActionButton copyBtn(String label, String value) {
        return ActionButton.create((Component) LEGACY.deserialize(label),
            (Component) LEGACY.deserialize("&7Натисни, щоб скопіювати: &f" + value), (int) 300,
            (DialogAction) DialogAction.staticAction(net.kyori.adventure.text.event.ClickEvent.copyToClipboard(value)));
    }

    /** Вікно, яке не закривається після натискання кнопки (щоб скопіювати кілька id підряд). */
    private Dialog dialogKeep(String title, List<DialogBody> body, List<DialogInput> inputs, DialogType type) {
        return Dialog.create(factory -> ((DialogRegistryEntry.Builder) factory.empty()).base(DialogBase.builder((Component) QuestNPC.colored(title)).canCloseWithEscape(true).afterAction(DialogBase.DialogAfterAction.NONE).body(body).inputs(inputs).build()).type(type));
    }

    /** Список усіх квестів: клік по рядку копіює id квесту. */
    private void openQuestIds(Player p, Runnable back) {
        List<ActionButton> buttons = new ArrayList<>();
        for (Quest q : this.quests.values()) {
            buttons.add(this.copyBtn("&f" + q.name + " &8(" + q.id + ")", q.id));
        }
        if (buttons.isEmpty()) {
            p.sendMessage(this.text("&cКвестів ще немає."));
            back.run();
            return;
        }
        p.showDialog((DialogLike) this.dialogKeep("&bСкопіювати id квесту",
            List.of(this.para("Натисни на квест, щоб скопіювати його id в буфер обміну. Потім встав його (Ctrl+V) у потрібне поле.")),
            List.of(),
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад", v -> this.sync(back)), (int) 1)));
    }

    // ======================= v0.7.0: ВИГЛЯД МОБА, ПОЗИ, ЕТАП «ПРИВЕСТИ МОБА», ПОВІДОМЛЕННЯ NPC =======================

    private Entity entityIfLoaded(Npc n) {
        if (n.entity == null || n.loc == null || n.loc.getWorld() == null) {
            return null;
        }
        if (!n.loc.getWorld().isChunkLoaded(n.loc.getBlockX() >> 4, n.loc.getBlockZ() >> 4)) {
            return null;
        }
        return n.loc.getWorld().getEntity(n.entity);
    }

    /** Повертає назву типу моба, якщо його можна використати як вигляд NPC, інакше порожній рядок. */
    private String validMob(String raw) {
        if (raw == null || raw.isBlank()) {
            return "";
        }
        try {
            EntityType t = EntityType.valueOf(raw.trim().toUpperCase(Locale.ROOT).replace(' ', '_'));
            if (!t.isAlive() || !t.isSpawnable() || t == EntityType.PLAYER || t == EntityType.WITHER
                || t == EntityType.ENDER_DRAGON || t.name().equals("MANNEQUIN")) {
                return "";
            }
            return t.name();
        } catch (IllegalArgumentException ex) {
            return "";
        }
    }

    private Entity spawnNpcEntity(Npc n, Location loc) {
        if (!n.mobType.isBlank()) {
            try {
                Entity e = loc.getWorld().spawnEntity(loc, EntityType.valueOf(n.mobType));
                this.setup(e, n);
                return e;
            } catch (IllegalArgumentException ex) {
                n.mobType = "";
            }
        }
        return loc.getWorld().spawn(loc, Mannequin.class, mq -> this.setup(mq, n));
    }

    private void respawnNpc(Npc n) {
        Entity old = this.entityOf(n);
        Location at = old != null ? old.getLocation() : n.loc;
        this.dropSeat(n);
        if (old != null) {
            old.remove();
        }
        Entity e = this.spawnNpcEntity(n, at);
        n.entity = e.getUniqueId();
        n.loc = at.clone();
        this.applySkin(n);
        this.save();
    }

    private void applyPose(Entity e, Npc n) {
        if (!(e instanceof Mannequin)) {
            return;
        }
        if (n.pose.equals("lie")) {
            e.setPose(org.bukkit.entity.Pose.SLEEPING, true);
        } else if (n.pose.equals("sneak")) {
            e.setPose(org.bukkit.entity.Pose.SNEAKING, true);
        } else {
            e.setPose(org.bukkit.entity.Pose.STANDING, false);
        }
    }

    private void dropSeat(Npc n) {
        if (n.seat == null) {
            return;
        }
        Entity st = n.loc != null && n.loc.getWorld() != null ? n.loc.getWorld().getEntity(n.seat) : null;
        if (st != null) {
            st.remove();
        }
        n.seat = null;
    }

    /** Раз на кілька секунд: тримає пози (лежить, присів) і саджає NPC, якщо обрано «сидить». */
    private void maintainPoses() {
        double off = this.getConfig().getDouble("pose.sit-offset", -0.5);
        for (Npc n : this.npcs.values()) {
            Entity e = this.entityIfLoaded(n);
            if (!(e instanceof Mannequin)) {
                continue;
            }
            if (n.pose.equals("lie")) {
                if (e.getPose() != org.bukkit.entity.Pose.SLEEPING) {
                    e.setPose(org.bukkit.entity.Pose.SLEEPING, true);
                }
            } else if (n.pose.equals("sneak")) {
                if (e.getPose() != org.bukkit.entity.Pose.SNEAKING) {
                    e.setPose(org.bukkit.entity.Pose.SNEAKING, true);
                }
            } else if (n.pose.equals("sit")) {
                if (!(e.getVehicle() instanceof org.bukkit.entity.ArmorStand)) {
                    this.dropSeat(n);
                    org.bukkit.entity.ArmorStand seat = (org.bukkit.entity.ArmorStand) e.getWorld().spawnEntity(e.getLocation().add(0.0, off, 0.0), EntityType.ARMOR_STAND);
                    seat.setInvisible(true);
                    seat.setMarker(true);
                    seat.setGravity(false);
                    seat.setSilent(true);
                    seat.setInvulnerable(true);
                    seat.setPersistent(false);
                    seat.addPassenger(e);
                    n.seat = seat.getUniqueId();
                }
            } else {
                if (e.getVehicle() instanceof org.bukkit.entity.ArmorStand) {
                    e.leaveVehicle();
                    this.dropSeat(n);
                }
                if (e.getPose() != org.bukkit.entity.Pose.STANDING) {
                    e.setPose(org.bukkit.entity.Pose.STANDING, false);
                }
            }
        }
    }

    private void reseatAll() {
        for (Npc n : this.npcs.values()) {
            Entity e = this.entityIfLoaded(n);
            if (e != null && e.getVehicle() instanceof org.bukkit.entity.ArmorStand) {
                e.leaveVehicle();
            }
            this.dropSeat(n);
        }
    }

    private static String poseLabel(String pose) {
        return switch (pose) {
            case "lie" -> "лежить";
            case "sit" -> "сидить";
            case "sneak" -> "присів";
            default -> "стоїть";
        };
    }

    private static String nextPose(String pose) {
        return switch (pose) {
            case "stand" -> "sit";
            case "sit" -> "lie";
            case "lie" -> "sneak";
            default -> "stand";
        };
    }

    private void applyPoseNow(Npc n) {
        Entity e = this.entityOf(n);
        if (e == null) {
            return;
        }
        if (e.getVehicle() instanceof org.bukkit.entity.ArmorStand && !n.pose.equals("sit")) {
            e.leaveVehicle();
            this.dropSeat(n);
        }
        this.applyPose(e, n);
        this.maintainPoses();
    }

    // ---- повідомлення від NPC в чаті гравцю при завершенні етапу ----

    private void sendStageChat(Player p, Quest q, Stage sg) {
        if (sg.chat == null || sg.chat.isBlank()) {
            return;
        }
        int id = sg.chatNpc >= 0 ? sg.chatNpc : (sg.npc >= 0 ? sg.npc : q.giver);
        Npc n = id >= 0 ? this.npcs.get(id) : null;
        Component who = n != null ? QuestNPC.colored(n.name) : LEGACY.deserialize("&6Квест");
        p.sendMessage(who.append(LEGACY.deserialize(" &8» &f")).append(this.fmt(sg.chat, p)));
    }

    // ---- етап «привести моба з певною биркою в зону» ----

    private boolean mobInZone(Player p, Stage sg) {
        World w = Bukkit.getWorld(sg.world);
        if (w == null || !p.getWorld().equals(w) || sg.mobName == null || sg.mobName.isBlank()) {
            return false;
        }
        Location c = new Location(w, sg.x, sg.y, sg.z);
        double near = sg.radius + 12.0;
        if (p.getLocation().distanceSquared(c) > near * near) {
            return false;
        }
        double vertical = sg.height >= 0.0 ? sg.height : sg.radius;
        for (Entity e : w.getNearbyEntities(c, sg.radius, vertical, sg.radius)) {
            if (!(e instanceof org.bukkit.entity.LivingEntity) || e instanceof Player || this.npcIdOf(e) != null) {
                continue;
            }
            if (sg.entity != null && e.getType() != sg.entity) {
                continue;
            }
            Component cn = e.customName();
            if (cn == null) {
                continue;
            }
            String plain = net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer.plainText().serialize(cn).trim();
            if (plain.equalsIgnoreCase(sg.mobName.trim())) {
                return true;
            }
        }
        return false;
    }

    // ---- назви предметів у нагородах (кастомна назва замість CUBLESTONE) ----

    private Component itemName(ItemStack it) {
        ItemMeta im = it.getItemMeta();
        if (im != null && im.hasDisplayName() && im.displayName() != null) {
            return im.displayName().decoration(net.kyori.adventure.text.format.TextDecoration.ITALIC, false);
        }
        return Component.translatable(it.getType().translationKey());
    }

    private String itemNameStr(ItemStack it) {
        ItemMeta im = it.getItemMeta();
        if (im != null && im.hasDisplayName() && im.displayName() != null) {
            return LEGACY.serialize(im.displayName());
        }
        String n = it.getType().name().toLowerCase(Locale.ROOT).replace('_', ' ');
        return n.substring(0, 1).toUpperCase(Locale.ROOT) + n.substring(1);
    }

    private Component rewardsComponent(Quest q) {
        List<Component> parts = new ArrayList<>();
        if (q.xp > 0) {
            parts.add(Component.text(q.xp + " досвіду"));
        }
        for (String it : q.items) {
            String[] sp = it.split(":");
            Material mat = Material.matchMaterial(sp[0].trim());
            if (mat != null) {
                parts.add(Component.text((sp.length > 1 ? sp[1].trim() : "1") + " x ").append(Component.translatable(mat.translationKey())));
            } else {
                parts.add(Component.text(it.replace(":", " x ")));
            }
        }
        for (String enc : q.stacks) {
            try {
                ItemStack st0 = this.decode(enc);
                parts.add(Component.text(st0.getAmount() + " x ").append(this.itemName(st0)));
            } catch (RuntimeException ex) {
                parts.add(Component.text("предмет"));
            }
        }
        if (parts.isEmpty()) {
            return null;
        }
        Component out = LEGACY.deserialize("&6Нагорода: &f");
        for (int i = 0; i < parts.size(); i++) {
            if (i > 0) {
                out = out.append(Component.text(", "));
            }
            out = out.append(parts.get(i).colorIfAbsent(net.kyori.adventure.text.format.NamedTextColor.WHITE));
        }
        return out;
    }

    // ======================= v0.7.0: РОЗМОВИ МІЖ NPC =======================

    static final class ChatLine {
        int npc;
        long delay = 4L;
        String text = "";

        ChatLine() {
        }
    }

    static final class Chatter {
        String id;
        String name;
        long interval = 2400L;
        double range = 24.0;
        boolean enabled = true;
        List<ChatLine> lines = new ArrayList<ChatLine>();
        long nextAt = 0L;
        boolean playing = false;

        Chatter() {
        }
    }

    private final Map<String, Chatter> chatters = new LinkedHashMap<>();
    private final Map<Integer, org.bukkit.entity.TextDisplay> npcBubbles = new HashMap<>();

    private File chatterFile() {
        return new File(this.getDataFolder(), "chatter.yml");
    }

    private void loadChatters() {
        this.chatters.clear();
        File f = this.chatterFile();
        if (!f.exists()) {
            return;
        }
        YamlConfiguration y = YamlConfiguration.loadConfiguration(f);
        ConfigurationSection sec = y.getConfigurationSection("conversations");
        if (sec == null) {
            return;
        }
        for (String id : sec.getKeys(false)) {
            ConfigurationSection s = sec.getConfigurationSection(id);
            if (s == null) {
                continue;
            }
            Chatter ch = new Chatter();
            ch.id = id.toLowerCase(Locale.ROOT);
            ch.name = s.getString("name", ch.id);
            ch.interval = Math.max(10L, s.getLong("interval", 2400L));
            ch.range = Math.max(4.0, s.getDouble("range", 24.0));
            ch.enabled = s.getBoolean("enabled", true);
            for (Map m : s.getMapList("lines")) {
                ChatLine l = new ChatLine();
                l.npc = (int) QuestNPC.md(m, "npc", -1.0);
                l.delay = Math.max(1L, (long) QuestNPC.md(m, "delay", 4.0));
                l.text = QuestNPC.ms(m, "text", "");
                if (!l.text.isBlank()) {
                    ch.lines.add(l);
                }
            }
            ch.nextAt = System.currentTimeMillis() + 60000L;
            this.chatters.put(ch.id, ch);
        }
        this.getLogger().info("Завантажено розмов NPC: " + this.chatters.size());
    }

    private void saveChatters() {
        YamlConfiguration y = new YamlConfiguration();
        for (Chatter ch : this.chatters.values()) {
            String b = "conversations." + ch.id + ".";
            y.set(b + "name", ch.name);
            y.set(b + "interval", ch.interval);
            y.set(b + "range", ch.range);
            y.set(b + "enabled", ch.enabled);
            List<Map<String, Object>> ls = new ArrayList<>();
            for (ChatLine l : ch.lines) {
                Map<String, Object> m = new LinkedHashMap<>();
                m.put("npc", l.npc);
                m.put("delay", l.delay);
                m.put("text", l.text);
                ls.add(m);
            }
            y.set(b + "lines", ls);
        }
        try {
            y.save(this.chatterFile());
        } catch (IOException ex) {
            this.getLogger().severe("Не вдалося зберегти chatter.yml: " + ex.getMessage());
        }
    }

    private List<Player> chatterAudience(Chatter ch) {
        List<Player> out = new ArrayList<>();
        for (Player pl : Bukkit.getOnlinePlayers()) {
            for (ChatLine l : ch.lines) {
                Npc n = this.npcs.get(l.npc);
                if (n == null || n.loc == null || n.loc.getWorld() == null || !n.loc.getWorld().equals(pl.getWorld())) {
                    continue;
                }
                if (n.loc.distanceSquared(pl.getLocation()) <= ch.range * ch.range) {
                    out.add(pl);
                    break;
                }
            }
        }
        return out;
    }

    private void tickChatters() {
        long now = System.currentTimeMillis();
        for (Chatter ch : this.chatters.values()) {
            if (!ch.enabled || ch.playing || ch.lines.size() < 2 || ch.nextAt > now) {
                continue;
            }
            if (!this.chatterAudience(ch).isEmpty()) {
                this.playChatter(ch);
            }
        }
    }

    /** Відтворює розмову: фрази йдуть по черзі, кожна з паузою після попередньої. */
    private void playChatter(Chatter ch) {
        ch.playing = true;
        long at = 0L;
        for (int i = 0; i < ch.lines.size(); i++) {
            ChatLine l = ch.lines.get(i);
            at += i == 0 ? 0L : Math.max(1L, l.delay) * 20L;
            final boolean last = i == ch.lines.size() - 1;
            Bukkit.getScheduler().runTaskLater((Plugin) this, () -> {
                this.npcSay(ch, l);
                if (last) {
                    ch.playing = false;
                    ch.nextAt = System.currentTimeMillis() + ch.interval * 1000L;
                }
            }, at);
        }
    }

    private void npcSay(Chatter ch, ChatLine l) {
        Npc n = this.npcs.get(l.npc);
        if (n == null) {
            return;
        }
        Entity e = this.entityIfLoaded(n);
        if (e == null) {
            return;
        }
        org.bukkit.entity.TextDisplay old = this.npcBubbles.remove(n.id);
        if (old != null && old.isValid()) {
            old.remove();
        }
        String t = l.text.replaceAll("\\s*\\R\\s*", " ").strip();
        int max = Math.max(20, this.getConfig().getInt("bubble.max-length", 140));
        if (t.length() > max) {
            t = t.substring(0, max).stripTrailing();
            if (t.endsWith("&")) {
                t = t.substring(0, t.length() - 1);
            }
            t = t + "…";
        }
        final String shown = t;
        Location at = e.getLocation().add(0.0, e.getHeight() + this.getConfig().getDouble("bubble.height-offset", 0.7), 0.0);
        org.bukkit.entity.TextDisplay d = e.getWorld().spawn(at, org.bukkit.entity.TextDisplay.class, d0 -> {
            d0.setPersistent(false);
            d0.text(LEGACY.deserialize(shown));
            d0.setBillboard(org.bukkit.entity.Display.Billboard.CENTER);
            d0.setAlignment(org.bukkit.entity.TextDisplay.TextAlignment.CENTER);
            d0.setLineWidth(180);
        });
        this.npcBubbles.put(n.id, d);
        long ticks = Math.max(60L, Math.min(300L, 40L + (long) shown.length() * 3L));
        Bukkit.getScheduler().runTaskLater((Plugin) this, () -> {
            if (this.npcBubbles.get(n.id) == d) {
                this.npcBubbles.remove(n.id);
            }
            if (d.isValid()) {
                d.remove();
            }
        }, ticks);
        if (this.getConfig().getBoolean("chatter.chat-messages", false)) {
            Component msg = QuestNPC.colored(n.name).append(LEGACY.deserialize(" &8» &f" + l.text));
            for (Player pl : this.chatterAudience(ch)) {
                pl.sendMessage(msg);
            }
        }
    }

    private String chatterLinesText(Chatter ch) {
        StringBuilder sb = new StringBuilder();
        for (ChatLine l : ch.lines) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(l.npc).append("|").append(l.delay).append("|").append(l.text);
        }
        return sb.toString();
    }

    private void applyChatter(Player p, Chatter ch, Function<String, String> v) {
        ch.name = QuestNPC.clean(v.apply("chname"), ch.id);
        long iv = QuestNPC.parseDuration(v.apply("chint"));
        if (iv > 0L) {
            ch.interval = Math.max(10L, iv);
        } else {
            p.sendMessage(this.text("&cІнтервал має бути часом, напр. 40m - залишено попереднє значення."));
        }
        try {
            ch.range = Math.max(4.0, Double.parseDouble(QuestNPC.clean(v.apply("chrange"), "24").replace(',', '.')));
        } catch (NumberFormatException ex) {
            p.sendMessage(this.text("&cРадіус має бути числом - залишено попереднє значення."));
        }
        List<ChatLine> out = new ArrayList<>();
        for (String raw : QuestNPC.lines(v.apply("chlines"))) {
            String[] part = raw.split("\\|", 3);
            try {
                ChatLine l = new ChatLine();
                l.npc = Integer.parseInt(part[0].trim());
                if (part.length == 3) {
                    l.delay = Math.max(1L, QuestNPC.parseDuration(part[1]));
                    l.text = part[2].trim();
                } else if (part.length == 2) {
                    l.text = part[1].trim();
                } else {
                    throw new NumberFormatException("format");
                }
                if (l.text.isBlank()) {
                    throw new NumberFormatException("empty");
                }
                if (!this.npcs.containsKey(l.npc)) {
                    p.sendMessage(this.text("&eУвага: NPC #" + l.npc + " не існує, фраза пропущена: &f" + raw));
                    continue;
                }
                out.add(l);
            } catch (NumberFormatException ex) {
                p.sendMessage(this.text("&cРядок пропущено (формат: №NPC|пауза|текст): &f" + raw));
            }
        }
        ch.lines = out;
    }

    private void openChatterList(Player p) {
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&a+ Нова розмова", v -> this.sync(() -> this.openChatterNew(p))));
        for (Chatter ch : this.chatters.values()) {
            buttons.add(this.btn((ch.enabled ? "&a" : "&7") + ch.name + " &8(" + ch.lines.size() + " фраз)", v -> this.sync(() -> this.openChatterEditor(p, ch))));
        }
        p.showDialog((DialogLike) this.dialog("&bРозмови NPC",
            List.of(this.para("Розмова - це черга фраз кількох NPC, що виглядає як переписка між ними. Запускається раз на інтервал, коли поруч є гравець.")),
            List.of(),
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Закрити", null), (int) 1)));
    }

    private void openChatterNew(Player p) {
        ConfirmationType type = DialogType.confirmation(
            (ActionButton) this.btn("&aСтворити", v -> this.sync(() -> {
                String name = QuestNPC.clean(v.apply("chname"), "");
                if (name.isEmpty()) {
                    p.sendMessage(this.text("&cВведи назву розмови."));
                    this.openChatterNew(p);
                    return;
                }
                String base = QuestNPC.slug(name);
                String id = base;
                int i = 2;
                while (this.chatters.containsKey(id)) {
                    id = base + "_" + i++;
                }
                Chatter ch = new Chatter();
                ch.id = id;
                ch.name = name;
                ch.nextAt = System.currentTimeMillis() + 60000L;
                this.chatters.put(id, ch);
                this.saveChatters();
                p.sendMessage(this.text("&aРозмову створено. Додай фрази."));
                this.openChatterEditor(p, ch);
            })),
            (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openChatterList(p))));
        p.showDialog((DialogLike) this.dialog("&bНова розмова",
            List.of(this.para("Достатньо назви. Фрази, інтервал і радіус налаштуєш далі.")),
            List.of(this.line("chname", "Назва розмови", "", 60)),
            (DialogType) type));
    }

    private void openChatterEditor(Player p, Chatter ch) {
        List<DialogInput> inputs = new ArrayList<>();
        inputs.add(this.line("chname", "Назва розмови", ch.name, 60));
        inputs.add(this.line("chint", "Як часто запускати (напр. 40m, 1h; рахується після кінця розмови)", ch.interval + "s", 12));
        inputs.add(this.line("chrange", "Радіус: розмова йде, коли гравець ближче цієї відстані до будь-кого з NPC (блоки)", String.valueOf(ch.range), 6));
        inputs.add(this.block("chlines", "Фрази, по одній в рядок: №NPC|пауза перед фразою (с)|текст", this.chatterLinesText(ch), 1500));
        List<ActionButton> buttons = new ArrayList<>();
        buttons.add(this.btn("&aЗберегти", v -> this.sync(() -> {
            this.applyChatter(p, ch, v);
            this.saveChatters();
            p.sendMessage(this.text("&aРозмову збережено."));
            this.openChatterEditor(p, ch);
        })));
        buttons.add(this.btn("Увімкнена: " + (ch.enabled ? "&aтак" : "&cні"), v -> this.sync(() -> {
            this.applyChatter(p, ch, v);
            ch.enabled = !ch.enabled;
            this.saveChatters();
            this.openChatterEditor(p, ch);
        })));
        buttons.add(this.btn("&dВідтворити зараз (тест)", v -> this.sync(() -> {
            this.applyChatter(p, ch, v);
            this.saveChatters();
            if (ch.lines.size() < 2) {
                p.sendMessage(this.text("&cДля розмови потрібно хоча б 2 фрази."));
            } else if (ch.playing) {
                p.sendMessage(this.text("&eРозмова вже йде."));
            } else {
                this.playChatter(ch);
                p.sendMessage(this.text("&aРозмову запущено. Підійди до NPC, щоб побачити фрази над їхніми головами."));
            }
            this.openChatterEditor(p, ch);
        })));
        buttons.add(this.btn("&cВидалити розмову", v -> this.sync(() -> {
            ConfirmationType type = DialogType.confirmation(
                (ActionButton) this.btn("&cТак, видалити", v2 -> this.sync(() -> {
                    this.chatters.remove(ch.id);
                    this.saveChatters();
                    p.sendMessage(this.text("&aРозмову видалено."));
                    this.openChatterList(p);
                })),
                (ActionButton) this.btn("&7Ні", v2 -> this.sync(() -> this.openChatterEditor(p, ch))));
            p.showDialog((DialogLike) this.dialog("&cВидалити розмову?",
                List.of(this.para("Розмова «" + ch.name + "» буде видалена.")), List.of(), (DialogType) type));
        })));
        p.showDialog((DialogLike) this.dialog("&bРозмова: " + ch.id,
            List.of(this.para("Приклад фраз:\n1|0|Чув, що в лісі знову бродять зомбі?\n2|4|Так, треба сказати Бородатому.\n1|5|Він усе одно не слухає...")),
            inputs,
            (DialogType) DialogType.multiAction(buttons, (ActionButton) this.btn("&7Назад", v -> this.sync(() -> this.openChatterList(p))), (int) 1)));
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
            return List.of("give", "list", "remove", "tp", "here", "quests", "editor", "version", "markers", "resetphrases", "chatter", "reload").stream().filter(x -> x.startsWith(a[0].toLowerCase())).toList();
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
        String mobType = "";
        String pose = "stand";
        java.util.UUID seat;
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
        String uid = UUID.randomUUID().toString().substring(0, 8);
        String again = "";
        long againCd = 0L;

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
        List<String> requires = new ArrayList<String>();
        List<String> excludes = new ArrayList<String>();
        int minLevel = 0;
        int giver = -1;
        int dailyReset = -1;
        long timeLimit = 0L;
        String acceptReply = "";
        String declineReply = "";
        final List<Stage> stages = new ArrayList<Stage>();
        int xp;
        List<String> items = new ArrayList<String>();
        List<String> stacks = new ArrayList<String>();
        List<String> commands = new ArrayList<String>();

        Quest() {
        }
    }

    static final class Line {
        String id;
        String name;
        String description = "";
        int xp;
        List<String> commands = new ArrayList<String>();
        List<String> quests = new ArrayList<String>();

        Line() {
        }
    }

    static final class QState {
        String status = "ACTIVE";
        int stage = 0;
        int count = 0;
        long doneAt = 0L;
        long startedAt = 0L;

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
        String mobName = "";
        String chat = "";
        int chatNpc = -1;

        Stage() {
        }
    }
}

