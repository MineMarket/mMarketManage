package mMarket.manage.spigot.commands;

import org.bukkit.command.*;
import mMarket.manage.spigot.main.*;

/**
 * Deobfuscated and created source code by FlatiCommunity (https://t.me/flaticommunity)
 * binscure MEGA OBFFFFF Xdddd
 */

public class ReloadCommand implements CommandExecutor {

    public Start plugin;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission(plugin.getConfig().getString("permissions.cmd-reload"))) {
            sender.sendMessage(plugin.getConfig().getString("messages.no-permission").replace('&', '§'));
        } else {
            plugin.getPluginLoader().disablePlugin(plugin);
            plugin.getPluginLoader().enablePlugin(plugin);
            sender.sendMessage(plugin.getConfig().getString("messages.plugin-reloaded").replace('&', '§'));
        }

        return false;
    }

    public ReloadCommand(Start plugin) {
        this.plugin = plugin;
    }
}
