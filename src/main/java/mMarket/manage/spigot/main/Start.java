package mMarket.manage.spigot.main;

import org.bukkit.*;
import org.bukkit.plugin.java.*;
import mMarket.manage.spigot.event.*;
import mMarket.manage.spigot.commands.*;

/**
 * Deobfuscated and created source code by FlatiCommunity (https://t.me/flaticommunity)
 * binscure MEGA OBFFFFF Xdddd
 */

public class Start extends JavaPlugin {

    public static String LoadEvents;
    public static String ServerVersion;
    public static String LoadCFG;
    public static String PreloadMessage;
    public static String prefix = "§e§lmMarketManage§r ";
    public static String StartPluginMSG;
    public static String LoadCommands;
    public static String DisablePluginMSG;

    public void RegisterCommands() {
        System.out.println(LoadCommands);
        getCommand(getConfig().getString("commands.reload-command")).setExecutor(new ReloadCommand(this));
    }

    public void RegisterEvents() {
        System.out.println(LoadEvents);
        Bukkit.getPluginManager().registerEvents(new EventListener(this), this);
        Bukkit.getPluginManager().registerEvents(new RecipeDiscover(this), this);
    }

    static {
        StartPluginMSG = prefix + "§aPlugin enabled successfully!";
        DisablePluginMSG = prefix + "§cPlugin disabled successfully!";
        LoadCFG = prefix + "Loading the configuration...";
        LoadEvents = prefix + "Loading events...";
        LoadCommands = prefix + "Loading commands...";
        PreloadMessage = prefix + "Pre-loading...";
        ServerVersion = prefix + "Running on ";
        System.out.println(PreloadMessage);
    }

    public void onDisable() {
        System.out.println(DisablePluginMSG);
    }

    public void RegisterConfig() {
        System.out.println(LoadCFG);
        saveDefaultConfig();
    }

    public void onEnable() {
        LoadPlugin();
        System.out.println(StartPluginMSG);
    }

    public void LoadPlugin() {
        System.out.println(ServerVersion + Bukkit.getVersion().trim());
        RegisterConfig();
        RegisterEvents();
        RegisterCommands();
    }
}
