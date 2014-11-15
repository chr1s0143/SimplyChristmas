package me.chr1s0143.SimplyChristmas;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by chris on 04/11/2014.
 */

    //Staff will do "/simplyxmas tpset (player name)" to set a tp point to the %players% present. -DONE
    //The players name and the co-ords will be added to the 'Presents' menu in the config -DONE
    //Players will have the 'simplyxmas.tp' permission on the 25th December [Manually] (Console Time) - CHECK
    //Players will then have access to the "/presenttp" command to go to their present.


public class Teleportation implements CommandExecutor {
    private Main main = Main.getInstance();
    SettingsManager settings = SettingsManager.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
             if (cmd.getName().equalsIgnoreCase("presenttp")) {
                if (player.hasPermission("simplyxmas.tp")) {
                    if (settings.getLocationsFile().getStringList("Names").contains(player.getName())) {
                    int x = settings.getLocationsFile().getInt(player.getName() + ".x"),
                            y = settings.getLocationsFile().getInt(player.getName() + ".y"),
                            z = settings.getLocationsFile().getInt(player.getName() + ".z");
                    player.teleport(new Location(player.getWorld(), x, y, z));
                    player.sendMessage(ChatColor.GREEN + "Teleporting to your present");
                    } else { player.sendMessage(ChatColor.RED + "Could not locate your present. Did you " + ChatColor.GOLD + "/ask santa" + ChatColor.RED + "?");
                        player.sendMessage(ChatColor.RED + "If you think this is an error, contact a member of staff");
                    }
                } else
                    player.sendMessage(ChatColor.AQUA + "Santa " + ChatColor.RED + "hasn't given you permission to go to your present yet! Wait until the " + ChatColor.GOLD + "25th, December");
            }
            else if (cmd.getName().equalsIgnoreCase("presenttpt")) {
                if (player.hasPermission("simplyxmas.tpt")) {
                    if (args.length == 0)
                        player.sendMessage(ChatColor.RED + "Try doing " + ChatColor.GOLD + "/presenttpt (player name)");
                    else if (args.length == 1) {
                        if (settings.getLocationsFile().getStringList("Names").contains(args[0])) {
                            int     x = settings.getLocationsFile().getInt(args[0] + ".x"),
                                    y = settings.getLocationsFile().getInt(args[0] + ".y"),
                                    z = settings.getLocationsFile().getInt(args[0] + ".z");
                            player.teleport(new Location(player.getWorld(), x, y, z));
                            player.sendMessage(ChatColor.GREEN + "Teleporting to " + ChatColor.GOLD + "" + args[0] + "'s " + ChatColor.GREEN + "present ");
                        } else { player.sendMessage(ChatColor.GOLD + "" + args[0] + ChatColor.RED + " does not have a present location set!" ); }
                    }
                } else { player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!"); }
            }
        }
        return true;
    }
}
