package me.chr1s0143.SimplyChristmas;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by chris on 10/11/2014.
 */
public class AutoAnnounce implements CommandExecutor {
    private Main main = Main.getInstance();
    private int ab;


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("simplyxmasb")) {
                if (player.hasPermission("simplyxmas.broadcast")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.AQUA + "Specify what action you would like to do");
                        player.sendMessage(ChatColor.YELLOW + " Broadcast Commands:");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasb start  " + ChatColor.GREEN + "-  Start the auto-broadcasting");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasb stop  " + ChatColor.GREEN + "-  Stop the auto-broadcasting");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasb broadcast  " + ChatColor.GREEN + "-  Manually broadcast the message");
                    }
                    else if (args[0].equalsIgnoreCase("broadcast")) {
                        main.getServer().broadcastMessage(ChatColor.AQUA + "Merry Christmas from all the SimplyCrafted Staff! "
                                + ChatColor.GOLD + "/Ask Santa " + ChatColor.AQUA + "to ask Santa Squish for a gift to open after the 24th December!");
                    } else if (args[0].equalsIgnoreCase("start")) {
                        player.sendMessage(ChatColor.GREEN + "SimplyChristmas AutoBroadcast Started!");
                        this.ab = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
                            public void run() {
                                main.getServer().broadcastMessage(ChatColor.AQUA + "Merry Christmas from all the SimplyCrafted Staff! "
                                        + ChatColor.GOLD + "/Ask Santa " + ChatColor.AQUA + "to ask Santa Squish for a gift to open after the 24th December!");
                            }
                        }, 400, 36000);
                    } else if (args[0].equalsIgnoreCase("stop")) {
                        player.sendMessage(ChatColor.GREEN + "SimplyChristmas AutoBroadcast Stopped!");
                        Bukkit.getScheduler().cancelTask(ab);
                    } else if (args.length == 1) {
                        player.sendMessage(ChatColor.GOLD + "" + args[0] + ChatColor.RED + " is not part of the command");
                        player.sendMessage(ChatColor.YELLOW + "Broadcast Commands:");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasb start  " + ChatColor.GREEN + "-  Start the auto-broadcasting");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasb stop  " + ChatColor.GREEN + "-  Stop the auto-broadcasting");
                        player.sendMessage(ChatColor.GOLD + "/simplyxmasb broadcast  " + ChatColor.GREEN + "-  Manually broadcast the message");
                    }
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
                }
            }
        }
        return true;
    }
}
