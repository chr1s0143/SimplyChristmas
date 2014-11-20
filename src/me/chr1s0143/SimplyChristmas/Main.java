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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.Executor;

import java.util.List;

/**
 * Created by chris on 04/11/2014.
 */
public class Main extends JavaPlugin {
    SettingsManager settings = SettingsManager.getInstance();
    int AP;


    public static Main main;
    private static Present present;
    private static Teleportation teleportation;
    private static PresentCommands presentCommands;
    private static HelpList helpList;
    private static AutoAnnounce autoannounce;
    public static Main instance;

    public void onEnable() {
        main = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getCommand("ask").setExecutor(new Present());
        getCommand("simplyxmasb").setExecutor(new AutoAnnounce());
        getCommand("present").setExecutor(new PresentCommands());
        getCommand("presenttp").setExecutor(new Teleportation());
        getCommand("presenttpt").setExecutor(new Teleportation());
        getCommand("simplyxmas").setExecutor(new HelpList());
        getCommand("advent").setExecutor(new Advent());

        //AutoPerm System
        this.AP = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                String timeStamp = new SimpleDateFormat("MMddyyyy HHmmss").format(Calendar.getInstance().getTime());
                if ((timeStamp.equalsIgnoreCase("12012014 120000"))) {
                    System.out.print("Advent Day 1 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] " 
                                    + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 1 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day1");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day1");
                } else if ((timeStamp.equalsIgnoreCase("12022014 120000"))) {
                    System.out.print("Advent Day 2 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 2 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day2");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day2");
                } else if ((timeStamp.equalsIgnoreCase("12032014 120000"))) {
                    System.out.print("Advent Day 3 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 3 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day3");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day3");
                } else if ((timeStamp.equalsIgnoreCase("12042014 120000"))) {
                    System.out.print("Advent Day 4 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 4 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day4");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day4");
                } else if ((timeStamp.equalsIgnoreCase("12052014 120000"))) {
                    System.out.print("Advent Day 5 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 5 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day5");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day5");
                } else if ((timeStamp.equalsIgnoreCase("12062014 120000"))) {
                    System.out.print("Advent Day 6 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 6 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day6");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day6");
                } else if ((timeStamp.equalsIgnoreCase("12072014 120000"))) {
                    System.out.print("Advent Day 7 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 7 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day7");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day7");
                } else if ((timeStamp.equalsIgnoreCase("12082014 120000"))) {
                    System.out.print("Advent Day 8 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 8 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day8");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day8");
                } else if ((timeStamp.equalsIgnoreCase("12092014 120000"))) {
                    System.out.print("Advent Day 9 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 9 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day9");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day9");
                } else if ((timeStamp.equalsIgnoreCase("12102014 120000"))) {
                    System.out.print("Advent Day 10 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 10 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day10");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day10");
                } else if ((timeStamp.equalsIgnoreCase("12112014 120000"))) {
                    System.out.print("Advent Day 11 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 11 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day11");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day11");
                } else if ((timeStamp.equalsIgnoreCase("12122014 120000"))) {
                    System.out.print("Advent Day 12 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 12 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day12");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day12");
                } else if ((timeStamp.equalsIgnoreCase("12132014 120000"))) {
                    System.out.print("Advent Day 13 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 13 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day13");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day13");
                } else if ((timeStamp.equalsIgnoreCase("12142014 120000"))) {
                    System.out.print("Advent Day 14 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 14 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day14");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day14");
                } else if ((timeStamp.equalsIgnoreCase("12152014 120000"))) {
                    System.out.print("Advent Day 15 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 15 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day15");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day15");
                } else if ((timeStamp.equalsIgnoreCase("12162014 120000"))) {
                    System.out.print("Advent Day 16 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 16 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day16");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day16");
                } else if ((timeStamp.equalsIgnoreCase("12172014 120000"))) {
                    System.out.print("Advent Day 17 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 17 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day17");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day17");
                } else if ((timeStamp.equalsIgnoreCase("12182014 120000"))) {
                    System.out.print("Advent Day 18 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 18 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day18");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day18");
                } else if ((timeStamp.equalsIgnoreCase("12192014 120000"))) {
                    System.out.print("Advent Day 19 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 19 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day19");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day19");
                } else if ((timeStamp.equalsIgnoreCase("12202014 120000"))) {
                    System.out.print("Advent Day 20 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 20 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day20");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day20");
                } else if ((timeStamp.equalsIgnoreCase("12212014 120000"))) {
                    System.out.print("Advent Day 21 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 21 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day21");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day21");
                } else if ((timeStamp.equalsIgnoreCase("12222014 120000"))) {
                    System.out.print("Advent Day 22 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 22 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day22");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day22");
                } else if ((timeStamp.equalsIgnoreCase("12232014 120000"))) {
                    System.out.print("Advent Day 23 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 23 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day23");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day23");
                } else if ((timeStamp.equalsIgnoreCase("12242014 120000"))) {
                    System.out.print("Advent Day 24 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 24 of the SimplyAdvent Calendar is now available to open! " + ChatColor.GOLD + "/advent day24");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day24");
                } else if ((timeStamp.equalsIgnoreCase("12252014 120000"))) {
                    System.out.print("Advent Day 25 Unlocked!");
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] "
                            + ChatColor.DARK_AQUA + "Advent" + ChatColor.DARK_GREEN + ": Day 25 of the SimplyAdvent Calendar is now available to open! I hope you all have a great Christams! - From all the SimplyCrafted Staff"
                            + ChatColor.GOLD + "/advent day25" + ChatColor.GREEN + " You can now TP to your present if you asked for one before the 22nd, December! " + ChatColor.GOLD + "/presenttp");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.advent.day25");
                    getServer().dispatchCommand(getServer().getConsoleSender(), "pex group Player add simplyxmas.tp");
                }
            }
        }, 0L, 20L);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        File config = new File(getDataFolder() + File.separator + "config.yml");
        File advent = new File(getDataFolder() + File.separator + "advent.yml");
        File locations = new File(getDataFolder() + File.separator + "locations.yml");
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("simplyxmasr")) {
                if (player.hasPermission("simplyxmas.reload")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.AQUA + "Specify what action you would like to do");
                        player.sendMessage(ChatColor.YELLOW + " Reload Commands:");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasr config  " + ChatColor.GREEN + "-  Reload the config.yml file");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasr locations  " + ChatColor.GREEN + "-  Reload the locations.yml file");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasr advent  " + ChatColor.GREEN + "-  Reload the advent.yml file");
                    }
                        else if (args[0].equalsIgnoreCase("config")) {
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
                        } else if (args[0].equalsIgnoreCase("locations")) {
                            if (!locations.exists()) {
                                try {
                                    locations.createNewFile();
                                    player.sendMessage(ChatColor.RED + "locations.yml file was not found! Generating a new locations.yml file....");
                                } catch (IOException e) {
                                    Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create locations.yml!");
                                }
                            } else {
                                settings.reloadLocationsFile();
                                player.sendMessage(ChatColor.DARK_GREEN + "Locations File Has Been Reloaded!");
                            }
                        } else if (args[0].equalsIgnoreCase("advent")) {
                            if (!advent.exists()) {
                                try {
                                    advent.createNewFile();
                                    player.sendMessage(ChatColor.RED + "advent.yml file was not found! Generating a new advent.yml file....");
                                } catch (IOException e) {
                                    Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create advent.yml!");
                                }
                            } else {
                                settings.reloadAdventFile();
                                player.sendMessage(ChatColor.DARK_GREEN + "Advent File Has Been Reloaded!");
                            }
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