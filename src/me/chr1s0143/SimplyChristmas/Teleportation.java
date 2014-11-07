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

    //Staff will do "/simplyxmas tpset (player name)" to set a tp point to the %players% present.
    //The players name and the co-ords will be added to the 'Presents' menu in the config
    //Players will have the 'simplyxmas.tp' permission on the 25th December [Manually] (Console Time)
    //Players will then have access to the "/presenttp" command to go to their present. (May use signs instead of commands)


public class Teleportation implements CommandExecutor {
    private Main main = Main.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("present")) {
                if (player.hasPermission("simplyxmas.tpset")) {
                    if (args.length == 0)
                        player.sendMessage(ChatColor.RED + "Try doing " + ChatColor.GOLD + "/present tpset (playername)");
                    else if (args[0].equalsIgnoreCase("tpset")) {
                        if (args.length == 2) {
                            if (main.getConfig().getStringList("Locations").contains(args[1])) {
                                player.sendMessage(ChatColor.RED + " " + args[1] + " has already had a tp location set");
                            } else {
                                List<String> string = main.getConfig().getStringList("Locations");
                                main.getConfig().set(args[1] + ".x", player.getLocation().getBlockX());
                                main.getConfig().set(args[1] + ".y", player.getLocation().getBlockY());
                                main.getConfig().set(args[1] + ".z", player.getLocation().getBlockZ());
                                main.getConfig().set("Locations", string);
                                player.sendMessage(ChatColor.GOLD + " " + args[1] + "'s " + ChatColor.GREEN + "location set");
                                main.saveConfig();
                            }
                        }
                        else player.sendMessage(ChatColor.RED + "Try doing " + ChatColor.GOLD + "/present tpset (playername)");
                    }
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
                }
                return true;
                //need to add the check name in config
            } else if (cmd.getName().equalsIgnoreCase("presenttp")) {
                if (player.hasPermission("simplyxmas.tp")) {
                    int x = main.getConfig().getInt(player.getName() + ".x"),
                            y = main.getConfig().getInt(player.getName() + ".y"),
                            z = main.getConfig().getInt(player.getName() + ".z");
                    player.teleport(new Location(player.getWorld(), x, y, z));
                } else
                    player.sendMessage(ChatColor.AQUA + "Santa " + ChatColor.RED + "hasn't given you permission to go to your present yet! Wait until the " + ChatColor.GOLD + "25th, December");
            }

        }
        return true;
    }
}
