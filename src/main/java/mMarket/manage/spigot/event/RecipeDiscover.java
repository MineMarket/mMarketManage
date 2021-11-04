package mMarket.manage.spigot.event;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
import mMarket.manage.spigot.main.*;

/**
 * Deobfuscated and created source code by FlatiCommunity (https://t.me/flaticommunity)
 * caesium XDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD
 */

public class RecipeDiscover implements Listener {

    public Start plugin;
    public String category_player = "actions.player-events.";

    public RecipeDiscover(Start plugin) {
        this.plugin = plugin;
    }

    public void DisableOpenRecipes(PlayerRecipeDiscoverEvent e) {
        if (plugin.getConfig().getInt(category_player + "recipes-discover") == 1) {
            e.setCancelled(true);
        }
    }

}
