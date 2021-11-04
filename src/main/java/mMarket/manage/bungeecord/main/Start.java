package mMarket.manage.bungeecord.main;

import net.md_5.bungee.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Deobfuscated and created source code by FlatiCommunity (https://t.me/flaticommunity)
 * caesium XDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD
 */

public class Start extends Plugin {

    public static String PreloadMessage;
    public static String prefix = "§e§lmMarketManage§r ";
    public static String DisablePluginMSG;
    public static String StartPluginMSG;

    static {
        StartPluginMSG = prefix + "§aPlugin enabled successfully!";
        DisablePluginMSG = prefix + "§cPlugin disabled successfully!";
        PreloadMessage = prefix + "Pre-loading...";
        System.out.println(PreloadMessage);
    }

    public void onDisable() {
        System.out.println(Start.DisablePluginMSG);
    }

    public void onEnable() {
        System.out.println(prefix + ChatColor.AQUA + "Running on " + BungeeCord.getInstance().getVersion().trim());
        System.out.println(StartPluginMSG);
    }
}
