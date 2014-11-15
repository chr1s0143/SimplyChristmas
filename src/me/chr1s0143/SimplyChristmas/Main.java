package me.chr1s0143.SimplyChristmas;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.io.*;
import java.util.concurrent.Executor;

import java.util.List;

/**
 * Created by chris on 04/11/2014.
 */
public class Main extends JavaPlugin {
    SettingsManager settings = SettingsManager.getInstance();


    public static Main main;
    private static Present present;
    private static Teleportation teleportation;
    private static PresentCommands presentCommands;
    private static HelpList helpList;
    private static AutoAnnounce autoannounce;
    public static Main instance;

    public void onEnable() {
        settings.setupAdventFile(this);
        settings.getAdventFile().options().copyDefaults(true);
        settings.saveDefaultAdventFile();
        settings.setupLocationFile(this);
        settings.getLocationsFile().options().copyDefaults(true);
        settings.saveDefaultLocationsFile();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        main = this;
        getCommand("ask").setExecutor(new Present());
        getCommand("simplyxmasb").setExecutor(new AutoAnnounce());
        getCommand("present").setExecutor(new PresentCommands());
        getCommand("presenttp").setExecutor(new Teleportation());
        getCommand("presenttpt").setExecutor(new Teleportation());
        getCommand("simplyxmas").setExecutor(new HelpList());
        getCommand("advent").setExecutor(new Advent());
        }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        File config = new File(getDataFolder() + File.separator + "config.yml");
        File advent = new File(getDataFolder() + File.separator + "advent.yml");
        File locations = new File(getDataFolder() + File.separator + "locations.yml");
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("simplyxmasr")) {
                if (player.hasPermission("simplyxmas.reload")) {
                    if (!config.exists()) {
                        getConfig().options().copyDefaults(true);
                        saveDefaultConfig();
                        player.sendMessage(ChatColor.RED + "config.yml file was not found! Generating a new config.yml file....");
                        {
                            reloadConfig();
                        }
                    } else {
                        reloadConfig();
                        player.sendMessage(ChatColor.DARK_GREEN + "Config File Has Been Reloaded!");
                    }
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
                }
            }
        }
        return true;
    }
    public static Main getInstance() {
        return main;
    }




}