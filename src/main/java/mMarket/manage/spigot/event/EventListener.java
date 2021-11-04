package mMarket.manage.spigot.event;

import java.util.*;
import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;
import mMarket.manage.spigot.main.*;
import org.bukkit.event.entity.EntityDamageEvent.*;

/**
 * Deobfuscated and created source code by FlatiCommunity (https://t.me/flaticommunity)
 * binscure MEGA OBFFFFF Xdddd
 */

public class EventListener implements Listener {

    public String category_player = "actions.player-events.";
    public String category_block = "actions.block-events.";
    public String category_chat = "actions.chat-events.";
    public Start plugin;
    public String category_damage = "actions.damage-events.";

    
    public EventListener(Start plugin) {
        this.plugin = plugin;
    }

    public void PickupItem(PlayerPickupItemEvent e) {
        Player player = e.getPlayer();
        if (plugin.getConfig().getInt(category_player + "pickup-item") == 1 && !player.hasPermission(plugin.getConfig().getString("permissions.pickup-item"))) {
            e.setCancelled(true);
            player.sendMessage(plugin.getConfig().getString("messages.pickup-item-deny").replace('&', '§'));
        }
    }

    public void DragonDamage(EntityDamageEvent e) {
        if (plugin.getConfig().getInt(category_damage + "dragon-damage-player") == 1 && e.getCause() == DamageCause.DRAGON_BREATH) {
            e.setCancelled(true);
        }

    }

    public void ChangeGamemode(PlayerGameModeChangeEvent e) {
        Player player = e.getPlayer();
        if (plugin.getConfig().getInt(category_player + "change-gamemode") == 1 && !player.hasPermission(plugin.getConfig().getString("permissions.change-gamemode"))) {
            e.setCancelled(true);
            player.sendMessage(plugin.getConfig().getString("messages.change-gamemode-deny").replace('&', '§'));
        }
    }

    public void FallDamage(EntityDamageEvent e) {
        if (plugin.getConfig().getInt(category_damage + "fall-damage") == 1 && e.getCause() == DamageCause.FALL) {
            e.setCancelled(true);
        }
    }

    public void DropItem(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        if(plugin.getConfig().getInt(category_player + "drop-item") == 1 && !player.hasPermission(plugin.getConfig().getString("permissions.drop-item"))) {
            e.setCancelled(true);
            player.sendMessage(plugin.getConfig().getString("messages.drop-item-deny").replace('&', '§'));
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void BlockContains(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        Player player = e.getPlayer();
        if (player.isOp()) {
            e.setCancelled(true);
        } else {
            String msg = plugin.getConfig().getString("messages.contains-chat-msg").replace('&', '§');
            for(String s : plugin.getConfig().getStringList("block-contains-chat")) {
                if (message.contains(s)) {
                    player.sendMessage(msg);
                    e.setCancelled(true);
                }
            }
        }

    }

    public void PickupItem(PlayerPickupArrowEvent e) {
        Player player = e.getPlayer();
        if (plugin.getConfig().getInt(category_player + "pickup-arrow") == 1 && !player.hasPermission(plugin.getConfig().getString("permissions.pickup-arrow"))) {
            e.setCancelled(true);
            player.sendMessage(plugin.getConfig().getString("messages.pickup-arrow-deny").replace('&', '§'));
        }

    }
    
    public void SwapHandDisable(PlayerSwapHandItemsEvent e) {
        Player player = e.getPlayer();
        if (plugin.getConfig().getInt(category_player + "swap-hand") == 1 && !player.hasPermission("permissions.swap-hand")) {
            e.setCancelled(true);
            player.sendMessage(plugin.getConfig().getString("messages.swap-hand-deny").replace('&', '§'));
        }

    }
    
    public void LeavesPatch(LeavesDecayEvent e) {
        if(plugin.getConfig().getInt(category_block + "leaves-patch") == 1) {
            e.setCancelled(true);
        }
    }
    
    public void AntiDrown(EntityDamageEvent e) {
        if (plugin.getConfig().getInt(category_damage + "anti-drowning") == 1 && e.getCause() == DamageCause.DROWNING) {
            e.setCancelled(true);
        }

    }
    
    public void BlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (plugin.getConfig().getInt(category_block + "block-break") == 1 && !player.hasPermission(plugin.getConfig().getString("permissions.block-break"))) {
            e.setCancelled(true);
            player.sendMessage(plugin.getConfig().getString("messages.block-break-deny").replace('&', '§'));
        }
    }
    
    public void WitherDamage(EntityDamageEvent e) {
        if (plugin.getConfig().getInt(category_damage + "wither-damage-player") == 1 && e.getCause() == DamageCause.WITHER) {
            e.setCancelled(true);
        }

    }
    
    public void LavaDamage(EntityDamageEvent e) {
        if (plugin.getConfig().getInt(category_damage + "fire-damage") == 1 && e.getCause() == DamageCause.FIRE) {
            e.setCancelled(true);
        }
    }
    
    public void JoinInfo(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (plugin.getConfig().getInt(category_chat + "join-info-msg") == 1) {
            player.sendMessage(plugin.getConfig().getString("messages.join-info").replace('&', '§'));
        }
    }
    
    public void BlockPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (plugin.getConfig().getInt(category_block + "block-place") == 1 && !player.hasPermission(plugin.getConfig().getString("permissions.block-place"))) {
            e.setCancelled(true);
            player.sendMessage(plugin.getConfig().getString("messages.block-place-deny").replace('&', '§'));
        }
    }
    
    public void VoidAntiDeath(EntityDamageEvent e) {
        if (plugin.getConfig().getInt(category_damage + "antideathvoid") == 1 && e.getCause() == DamageCause.VOID) {
            e.setCancelled(true);
        }
    }
    
    public void NoHunger(FoodLevelChangeEvent e) {
        if (plugin.getConfig().getInt(category_chat + "disable-join-msg") == 1) { // DISABLE JOIN MESSAGE IN FOOD LEVEL?????? https://i.imgur.com/UrQPDZt.png
            e.setFoodLevel(20);
        }
        e.setCancelled(true);
    }
    
    public void BlockBurn(BlockBurnEvent var1) {
        if (plugin.getConfig().getInt(category_block + "block-burn") == 1) {
            var1.setCancelled(true);
        }

    }
    
    public void HideQuit(PlayerQuitEvent e) {
        if(plugin.getConfig().getInt(category_chat + "disable-quit-msg") == 1) {
            e.setQuitMessage("");
        }
    }
    
    public void HideDeathMessage(PlayerDeathEvent e) {
        if (plugin.getConfig().getInt(category_chat + "disable-death-msg") == 1) {
            e.setDeathMessage(""); // null???
        }

    }
    
    public void Interact(PlayerInteractEvent e) {
        if (plugin.getConfig().getInt(category_player + "player-interact") == 1) {
            e.setCancelled(true);
        }

    }
    
    public void DisablePvP(EntityDamageByEntityEvent e) {
        if (plugin.getConfig().getInt(category_player + "disable-pvp") == 1) {
            e.setCancelled(true);
        }
    }
    
    public void BlockPhysics(BlockPhysicsEvent e) {
        if (plugin.getConfig().getInt(category_block + "block-physics") == 1) {
            e.setCancelled(true);
        }

    }
    
    public void FireDamage(EntityDamageEvent e) {
        if (plugin.getConfig().getInt(category_damage + "fire-damage-player") == 1 && e.getCause() == DamageCause.FIRE) {
            e.setCancelled(true);
        }

    }
    
    public void HideJoin(PlayerJoinEvent e) {
        if (plugin.getConfig().getInt(category_chat + "disable-join-msg") == 1) {
            e.setJoinMessage(""); // null????
        }

    }
    
    public void Godmode(EntityDamageEvent e) {
        if (plugin.getConfig().getInt(category_player + "godmode") == 1) {
            e.setCancelled(true);
        }

    }
    
    public void ArmorstandInteract(PlayerArmorStandManipulateEvent e) {
        if (plugin.getConfig().getInt(category_player + "armorstand-interact") == 1) {
            e.setCancelled(true);
        }

    }
    
    public void InteractPortal(PlayerPortalEvent e) {
        if (plugin.getConfig().getInt(category_player + "player-portal-event") == 1) {
            e.setCancelled(true);
        }

    }
}
