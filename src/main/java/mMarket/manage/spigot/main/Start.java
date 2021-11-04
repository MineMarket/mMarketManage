package mMarket.manage.spigot.main;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;
import mMarket.manage.spigot.event.*;
import mMarket.manage.spigot.commands.*;

/**
 * Deobfuscated and created source code by FlatiCommunity (https://t.me/flaticommunity)
 * caesium XDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD
 */

public class Start extends JavaPlugin {

    private static String LoadCommands;
    private static String ServerVersion;
    private static String DisablePluginMSG;
    private static String StartPluginMSG;
    private static String PreloadMessage;
    private static String LoadEvents;
    private static String LoadCFG;
    private static String CheckCFG;
    private static String prefix = "§e§lmMarketManage§r ";
    private static String PreloadNotice;

    public void onEnable() {
        LoadPlugin();
        System.out.println(StartPluginMSG);
    }

    private void RegisterCommands() {
        System.out.println(LoadCommands);
        getCommand(getConfig().getString("commands.reload-command")).setExecutor(new ReloadCommand(this));
    }

    private void LoadPlugin() {
        System.out.println(ServerVersion + Bukkit.getVersion().trim());
        RegisterConfig();
        RegisterEvents();
        RegisterCommands();
    }

    public void onDisable() {
        System.out.println(DisablePluginMSG);
    }

    public void ReloadPlugin() {
        reloadConfig();
        System.out.println(CheckCFG);
        HandlerList.unregisterAll(new EventListener(this)); // ой облизали видимо за такое им)))
        HandlerList.unregisterAll(new RecipeDiscover(this));
        RegisterEvents();
    }

    private void RegisterConfig() {
        System.out.println(LoadCFG);
        this.saveDefaultConfig();
    }

    private void RegisterEvents() {
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
        PreloadNotice = prefix + "NOTICE: §cThis is needed to load libraries";
        ServerVersion = prefix + "Running on ";
        CheckCFG = prefix + "Checking for changes in the config...";
        System.out.println(PreloadMessage);
        System.out.println(PreloadNotice);
    }

}
