package me.chr1s0143.SimplyChristmas;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by chris on 04/11/2014.
 */

    //By doing "/simplyxmasb" - the broadcast will show up.
public class Announcement implements CommandExecutor {
    private Main main = Main.getInstance();

        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (cmd.getName().equalsIgnoreCase("simplyxmasb")) {
                    if (player.hasPermission("simplyxmas.broadcast")) {
                        main.getServer().broadcastMessage(ChatColor.AQUA + "Merry Christmas from all the SimplyCrafted Staff! " + ChatColor.GOLD + "/Ask Santa " + ChatColor.AQUA + "to ask Santa Squish for a gift to open after the 24th December!");
                    }
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
                }
            }
            return true;
        }

    }