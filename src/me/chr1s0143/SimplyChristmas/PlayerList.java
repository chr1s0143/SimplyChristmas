package me.chr1s0143.SimplyChristmas;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by chris on 08/11/2014.
 */
public class PlayerList implements CommandExecutor {
    private Main main = Main.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("present")) {
                if (player.hasPermission("simplyxmas.list")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.YELLOW + "Present Commands:");
                        player.sendMessage(ChatColor.GOLD + "/present tpset (player name)");
                        player.sendMessage(ChatColor.GOLD + "/present done (player name)");
                        player.sendMessage(ChatColor.GOLD + "/present playerlist");
                    } else if (args[0].equalsIgnoreCase("playerlist")) {
                        player.sendMessage(ChatColor.YELLOW + "Players:");
                        player.sendMessage("" + main.getConfig().getStringList("Names"));
                    }
                    else { player.sendMessage(ChatColor.YELLOW + "Present Commands:");
                        player.sendMessage(ChatColor.GOLD + "/present tpset (player name)");
                        player.sendMessage(ChatColor.GOLD + "/present done (player name)");
                        player.sendMessage(ChatColor.GOLD + "/present playerlist"); }
                } else { player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!"); }
            }
        }
        return true;
    }
}