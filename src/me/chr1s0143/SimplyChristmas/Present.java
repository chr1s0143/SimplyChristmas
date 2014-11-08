package me.chr1s0143.SimplyChristmas;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;

import java.util.List;

/**
 * Created by chris on 04/11/2014.
 */

//ask santa will add them to the list (santa's list)
    //if they are already on the list it will tell them: "HO HO HO! You have already been added to my list %player%" -DONE
    //if they type "/ask" without the 'santa' argument after it will say "Don't forget to mention santa in that command! He will only answer to /ask santa" -DONE
    //any other argument (e.g /ask bob) it will "%arg% isn't here right now, although santa is! /ask santa" - DONE

//add to all classes
public class Present implements CommandExecutor {
    private Main main = Main.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("ask")) {
                if (player.hasPermission("simplyxmas.ask")) {
                    if (args.length == 0)
                        player.sendMessage(ChatColor.AQUA + "Don't forget to mention santa in that command! He will only answer to" + ChatColor.GOLD + " /ask santa");
                    else if (args[0].equalsIgnoreCase("santa")) {
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.DARK_AQUA + "HO HO HO! You have already been added to my list " + ChatColor.GOLD + " " + player.getName() + ChatColor.DARK_AQUA + ". I will add it to my sleigh very soon."); }
                        else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.DARK_AQUA + "HO HO HO! I have already added your gift to my sleigh! You can open it after the " + ChatColor.GOLD + "24th, December");
                        } else {
                            List<String> string = main.getConfig().getStringList("Names");
                            string.add(player.getName());
                            main.getConfig().set("Names", string);
                            player.sendMessage(ChatColor.DARK_AQUA + "HO HO HO! Merry Christmas " + ChatColor.GOLD + " " + player.getName() + ChatColor.DARK_AQUA + "! You have been added to my list to receive a gift which you can open from Christmas day, onwards!");
                            main.saveConfig();
                            Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "[G] " + ChatColor.WHITE + "[" + ChatColor.GREEN + "Christmas" + ChatColor.WHITE + "] " + ChatColor.DARK_AQUA + "Santa Squish" + ChatColor.DARK_GREEN + ": HO HO HO! " + ChatColor.GOLD + "" + player.getName() + ChatColor.DARK_GREEN + " has just asked me for a gift! If you would like a gift too, just ask me." + ChatColor.GOLD + " /ask santa");
                        }
                    }
                    else if (args.length == 1) {
                        player.sendMessage(ChatColor.GOLD + "" + args[0] + ChatColor.AQUA + " isn't here right now, although Santa Squish is! " + ChatColor.GOLD + "/ask santa");
                    }
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
                }

            } else
                player.sendMessage(ChatColor.RED + "You have not been good this year so Santa will not give you a present! If you think this is an error, contact a member of staff.");
        }
        return true;
    }

}