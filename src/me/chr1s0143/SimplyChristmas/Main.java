package me.chr1s0143.SimplyChristmas;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.concurrent.Executor;

import java.util.List;

/**
 * Created by chris on 04/11/2014.
 */
public class Main extends JavaPlugin{

    private static Main main;
    private static Present present;
    private static Announcement announcement;
    private static Teleportation teleportation;

    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        main = this;
        getCommand("ask").setExecutor(new Present());
        getCommand("simplyxmasb").setExecutor(new Announcement());
        getCommand("present").setExecutor(new Teleportation());
        getCommand("presenttp").setExecutor(new Teleportation());
        getCommand("presenttpt").setExecutor(new Teleportation());
        getCommand("simplyxmas").setExecutor(new HelpList());

        }
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("simplyxmasr")) {
                if (player.hasPermission("simplyxmas.reload")) {
                    reloadConfig();
                    player.sendMessage(ChatColor.DARK_GREEN + "Config File Has Been Reloaded!");
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