package me.chr1s0143.SimplyChristmas;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by chris on 05/11/2014.
 */

//Once the players present has been added, a staff member will do /simplyxmas done (playername)
//this will then have the player placed in the done section of the config file. They must not be able to do /ask santa again. (Checks 'Players' list and "Done" list before adding them)
// if they are either on the 'Players' list or 'Done' list they will be sent a message.
// "" 'Players' = HO HO HO! You have already been added to my list %Player% "" (in the 'Present' class)
// "" 'Done'' = HO HO HO! I have already added your gift to my Sleigh %Player%. ""


public class PresentCommands implements CommandExecutor {
    private Main main = Main.getInstance();
    SettingsManager settings = SettingsManager.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("present")) {
                if (player.hasPermission("simplyxmas.present")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.YELLOW + "Present Commands:");
                        player.sendMessage(ChatColor.GOLD + "/present tpset (player name)");
                        player.sendMessage(ChatColor.GOLD + "/present tpremove (player name)");
                        player.sendMessage(ChatColor.GOLD + "/present done (player name)");
                        player.sendMessage(ChatColor.GOLD + "/present playerlist");
                    } else if (args[0].equalsIgnoreCase("done")) {
                        if (args.length == 2) {
                            if (main.getConfig().getStringList("Done").contains(args[1])) {
                                player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.RED + " is already on the done list.");
                            } else if (main.getConfig().getStringList("Names").contains(args[1])) {
                                if (settings.getLocationsFile().getStringList("Names").contains(args[1])) {
                                    List<String> string = main.getConfig().getStringList("Done");
                                    string.add(args[1]);
                                    main.getConfig().set("Done", string);
                                    player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.GREEN + " has been added to the done list.");
                                    main.saveConfig();
                                } else {
                                    player.sendMessage(ChatColor.RED + "You forgot to set a TP location for " + ChatColor.GOLD + "" + args[1] + ChatColor.RED + ". Do " + ChatColor.GOLD + "/present tpset " + args[1]);
                                }
                                if (main.getConfig().getStringList("Done").contains(args[1])) {
                                    List<String> string = main.getConfig().getStringList("Names");
                                    string.remove(args[1]);
                                    main.getConfig().set("Names", string);
                                    main.saveConfig();
                                }
                            } else {
                                player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.RED + " has not asked for a gift. Check to make sure you spelt the name correctly.");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Try doing " + ChatColor.GOLD + "/present done (player name)");
                        }
                    } else if (args[0].equalsIgnoreCase("tpset")) {
                        if (args.length == 2) {
                            if (main.getConfig().getStringList("Names").contains(args[1])) {
                                if (settings.getLocationsFile().getStringList("Names").contains(args[1])) {
                                    player.sendMessage(ChatColor.RED + " " + args[1] + " has already had a tp location set");
                                } else {
                                    List<String> string = settings.getLocationsFile().getStringList("Names");
                                    string.add(args[1]);
                                    settings.getLocationsFile().set("Names", string);
                                    settings.getLocationsFile().getStringList("Locations");
                                    settings.getLocationsFile().set(args[1] + ".x", player.getLocation().getX());
                                    settings.getLocationsFile().set(args[1] + ".y", player.getLocation().getY());
                                    settings.getLocationsFile().set(args[1] + ".z", player.getLocation().getZ());
                                    settings.getLocationsFile().set(args[1] + ".yaw", player.getLocation().getYaw());
                                    settings.getLocationsFile().set(args[1] + ".pitch", player.getLocation().getPitch());
                                    player.sendMessage(ChatColor.GOLD + " " + args[1] + "'s " + ChatColor.GREEN + "location set. Be sure to do " + ChatColor.GOLD + "/present done " + "" + args[1]);
                                    settings.saveLocationsFile();
                                }
                            } else if (main.getConfig().getStringList("Done").contains(args[1])) {
                                player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.RED + " is on the done list. They should have a location set already." + ChatColor.GOLD + " /presenttpt " + "" + args[1] + ChatColor.RED + " to teleport to " + "" + args[1] + "'s present.");
                            } else {
                                player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.RED + " has not asked for a gift, therefore they cannot have a location set.");
                            }
                        } else
                            player.sendMessage(ChatColor.RED + "Try doing " + ChatColor.GOLD + "/present tpset (player name)");
                    } else if (args[0].equalsIgnoreCase("tpremove")) {
                        if (args.length == 2) {
                                if (settings.getLocationsFile().getStringList("Names").contains(args[1])) {
                                    List<String> LocNamesString = settings.getLocationsFile().getStringList("Names");
                                    LocNamesString.remove(args[1]);
                                    settings.getLocationsFile().set("Names", LocNamesString);
                                    player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.GREEN + "'s present TP location has been removed!");
                                    settings.saveLocationsFile();
                                    if (main.getConfig().getStringList("Done").contains(args[1])) {
                                        List<String> doneString = main.getConfig().getStringList("Done");
                                        doneString.remove(args[1]);
                                        main.getConfig().set("Done", doneString);
                                        List<String> namesString = main.getConfig().getStringList("Names");
                                        namesString.add(args[1]);
                                        main.getConfig().set("Names", namesString);
                                        main.saveConfig();
                                        player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.GREEN + " has also been removed from the done list!");
                                    }
                                } else {
                                    player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.RED + " has not had a present TP location set.");
                                }
                            } else { player.sendMessage(ChatColor.RED + "Try doing " + ChatColor.GOLD + "/present tpremove (player name)"); }
                        }
                    else if (args[0].equalsIgnoreCase("playerlist")) {
                            player.sendMessage(ChatColor.YELLOW + "Players:");
                            player.sendMessage("" + main.getConfig().getStringList("Names"));
                        } else if (args[0].equalsIgnoreCase("donelist")) {
                            player.sendMessage(ChatColor.YELLOW + "Players Done:");
                            player.sendMessage("" + main.getConfig().getStringList("Done"));
                        }
                    } else {
                        player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
                    }
                }
            }
        return true;
        }
    }