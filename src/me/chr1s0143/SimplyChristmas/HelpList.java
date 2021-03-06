package me.chr1s0143.SimplyChristmas;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

/**
 * Created by chris on 07/11/2014.
 */
public class HelpList implements CommandExecutor {
    private Main main = Main.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("simplyxmas")) {
                if (player.isOp()) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.RED + "Not enough arguments. Try " + ChatColor.GOLD + "/simplyxmas help");
                    } else if (args[0].equalsIgnoreCase("help")) {
                        player.sendMessage(ChatColor.YELLOW + "OP Commands:");
                        player.sendMessage(ChatColor.GOLD + "/ask santa " + ChatColor.GREEN + " -  Ask santa for a gift");
                        player.sendMessage(ChatColor.GOLD + "/presenttp " + ChatColor.GREEN + " -  Teleport to your present " + ChatColor.RED + "(Available on the 25th, December)");
                        player.sendMessage(ChatColor.GOLD + "/calendar " + ChatColor.GREEN + " -  View the advent calendar");
                        player.sendMessage(ChatColor.GOLD + "/advent (day) " + ChatColor.GREEN + " -  Claim your daily advent. e.g of this command - /advent day4 " + ChatColor.RED + "(Available from the 1st, December - 25th, December)");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmas help " + ChatColor.GREEN + " -  view your available commands");
                        player.sendMessage(ChatColor.GOLD + "/present tpset (player name) " + ChatColor.GREEN + " -  Set a teleport location for the player to their present");
                        player.sendMessage(ChatColor.GOLD + "/present done (player name) " + ChatColor.GREEN + " -  add the player to the done list. Make sure their tp location has been set first");
                        player.sendMessage(ChatColor.GOLD + "/presenttpt " + ChatColor.GREEN + " -  Teleport to a players present");
                        player.sendMessage(ChatColor.GOLD + "/present playerlist " + ChatColor.GREEN + " -  Display the list of players who asked for a present");
                        player.sendMessage(ChatColor.GOLD + "/present donelist " + ChatColor.GREEN + " -  Display the list of players who are on the done list");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasb start " + ChatColor.GREEN + " -  Start the auto-broadcasting");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasb stop " + ChatColor.GREEN + " -  Stop the auto-broadcasting");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasb broadcast " + ChatColor.GREEN + " -  Manually broadcast the message");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasr (yml names)" + ChatColor.GREEN + " -  Reload the config file " + ChatColor.RED + "(TO UPDATE THE CONFIG ONLY!)");
                        player.sendMessage(ChatColor.YELLOW + "Available YML Files:");
                        player.sendMessage(ChatColor.WHITE + "Config");
                        player.sendMessage(ChatColor.WHITE + "Advent");
                        player.sendMessage(ChatColor.WHITE + "Locations");
                    }
                }
                 else if (player.hasPermission("simplyxmas.help.staff")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.RED + "Not enough arguments. Try " + ChatColor.GOLD + "/simplyxmas help");
                    } else if (args[0].equalsIgnoreCase("help")) {
                        player.sendMessage(ChatColor.YELLOW + "Staff Commands:");
                        player.sendMessage(ChatColor.GOLD + "/ask santa " + ChatColor.GREEN + " -  Ask santa for a gift");
                        player.sendMessage(ChatColor.GOLD + "/presenttp " + ChatColor.GREEN + " -  Teleport to your present " + ChatColor.RED + "(Available on the 25th, December)");
                        player.sendMessage(ChatColor.GOLD + "/calendar " + ChatColor.GREEN + " -  View the advent calendar");
                        player.sendMessage(ChatColor.GOLD + "/advent (day) " + ChatColor.GREEN + " -  Claim your daily advent. e.g of this command - /advent day4 " + ChatColor.RED + "(Available from the 1st, December - 25th, December)");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmas help " + ChatColor.GREEN + " -  view your available commands");
                        player.sendMessage(ChatColor.GOLD + "/present tpset (player name) " + ChatColor.GREEN + " -  Set a teleport location for the player to their present");
                        player.sendMessage(ChatColor.GOLD + "/present done (player name) " + ChatColor.GREEN + " -  add the player to the done list. Make sure their tp location has been set first");
                        player.sendMessage(ChatColor.GOLD + "/presenttpt " + ChatColor.GREEN + " -  Teleport to a players present");
                        player.sendMessage(ChatColor.GOLD + "/present playerlist " + ChatColor.GREEN + " -  Display the list of players who asked for a present");
                        player.sendMessage(ChatColor.GOLD + "/present donelist " + ChatColor.GREEN + " -  Display the list of players who are on the done list");

                    }
                }
                else if (player.hasPermission("simplyxmas.help.player")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.RED + "Not enough arguments. Try " + ChatColor.GOLD + "/simplyxmas help");
                    } else if (args[0].equalsIgnoreCase("help")) {
                        player.sendMessage(ChatColor.YELLOW + "Player Commands:");
                        player.sendMessage(ChatColor.GOLD + "/ask santa " + ChatColor.GREEN + " -  Ask santa for a gift");
                        player.sendMessage(ChatColor.GOLD + "/presenttp " + ChatColor.GREEN + " -  Teleport to your present " + ChatColor.RED + "(Available on the 25th, December)");
                        player.sendMessage(ChatColor.GOLD + "/calendar " + ChatColor.GREEN + " -  View the advent calendar");
                        player.sendMessage(ChatColor.GOLD + "/advent (day) " + ChatColor.GREEN + " -  Claim your daily advent. e.g of this command - /advent day4 " + ChatColor.RED + "(Available from the 1st, December - 25th, December)");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmas help " + ChatColor.GREEN + " -  view your available commands");
                    }
                } else { player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!"); }
            }
        }
        return true;
    }
}