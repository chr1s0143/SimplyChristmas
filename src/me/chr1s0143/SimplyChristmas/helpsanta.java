package me.chr1s0143.SimplyChristmas;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by chris on 28/11/2014.
 */
public class helpsanta implements CommandExecutor {

    private Main main = Main.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("helpsanta")) {
                if (player.hasPermission("simplyxmas.helpsanta")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.YELLOW + "Santa needs you to help him find his lost presents.");
                        player.sendMessage(ChatColor.YELLOW + "Pesky evil elves have taken presents out of Santa's sleigh");
                        player.sendMessage(ChatColor.YELLOW + "which they have hidden all around Christmas Island.");
                        player.sendMessage(ChatColor.YELLOW + "Stand near or on the presents you find and do:");
                        player.sendMessage(ChatColor.GOLD + "/found " + ChatColor.YELLOW + "to safely return that present to Santa");
                        player.sendMessage(ChatColor.YELLOW + "Once you have found all of the presents, santa will reward you for the help");
                    }
                } else { player.sendMessage(ChatColor.RED + "You do not have permission to use this command!"); }
            }
        }
        return true;
    }
}