package me.chr1s0143.SimplyChristmas;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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


public class PlayersDone implements CommandExecutor {
    private Main main = Main.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("present")) {
                if (player.hasPermission("simplyxmas.done")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.YELLOW + "Present Commands:");
                        player.sendMessage(ChatColor.GOLD + "/present tpset (player name)");
                        player.sendMessage(ChatColor.GOLD + "/present done (player name)");
                        player.sendMessage(ChatColor.GOLD + "/present playerlist");
                    } else if (args[0].equalsIgnoreCase("done")) {
                        if (args.length == 2) {
                            if (main.getConfig().getStringList("Done").contains(args[1])) {
                                player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.RED + " is already on the done list.");
                            } else if (main.getConfig().getStringList("Names").contains(args[1])) {
                                List<String> string = main.getConfig().getStringList("Done");
                                string.add(args[1]);
                                main.getConfig().set("Done", string);
                                player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.GREEN + " has been added to the done list.");
                                main.saveConfig();
                            }
                            if (main.getConfig().getStringList("Done").contains(args[1])) {
                                List<String> string = main.getConfig().getStringList("Names");
                                string.remove(args[1]);
                                main.getConfig().set("Names", string);
                                main.saveConfig();
                            } else {
                                player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.RED + " has not asked for a gift. Check to make sure you spelt the name correctly.");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Try doing " + ChatColor.GOLD + "/present done (player name)");
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
                }
                if (player.hasPermission("simplyxmas.tpset")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.YELLOW + "Present Commands:");
                        player.sendMessage(ChatColor.GOLD + "/present tpset (player name)");
                        player.sendMessage(ChatColor.GOLD + "/present done (player name)");
                        player.sendMessage(ChatColor.GOLD + "/present playerlist");
                    } else if (args[0].equalsIgnoreCase("tpset")) {
                        if (args.length == 2) {
                            if (main.getConfig().getStringList("Names").contains(args[1])) {
                                if (main.getConfig().contains(args[1])) {
                                    player.sendMessage(ChatColor.RED + " " + args[1] + " has already had a tp location set");
                                } else {
                                    List<String> string = main.getConfig().getStringList("Locations");
                                    main.getConfig().set(args[1] + ".x", player.getLocation().getBlockX());
                                    main.getConfig().set(args[1] + ".y", player.getLocation().getBlockY());
                                    main.getConfig().set(args[1] + ".z", player.getLocation().getBlockZ());
                                    main.getConfig().set("Locations", string);
                                    player.sendMessage(ChatColor.GOLD + " " + args[1] + "'s " + ChatColor.GREEN + "location set. Be sure to do " + ChatColor.GOLD + "/present done " + "" + args[1]);
                                    main.saveConfig();
                                }
                            } else {
                                player.sendMessage(ChatColor.GOLD + "" + args[1] + ChatColor.RED + " has not asked for a gift, therefore they cannot have a location set.");
                            }
                        } else
                            player.sendMessage(ChatColor.RED + "Try doing " + ChatColor.GOLD + "/present tpset (player name)");
                    }
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
                }
            }
        }
        return true;
    }
}
