package me.chr1s0143.SimplyChristmas;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by chris on 10/11/2014.
 */
public class Advent implements CommandExecutor {
    private Main main = Main.getInstance();
    SettingsManager settings = SettingsManager.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("advent")) {
                if (player.hasPermission("simplyxmas.advent")) {
                    if (args.length == 0)
                        player.sendMessage(ChatColor.DARK_AQUA + "You need to mention which day to open. E.G: " + ChatColor.GOLD + "/advent day1");
                        //day1

                    else if (args[0].equalsIgnoreCase("day1")) {
                        if (player.hasPermission("simplyxmas.advent.day1")) {
                            if (settings.getAdventFile().getStringList("Day1").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 2");
                            } else {
                                    List<String> string = settings.getAdventFile().getStringList("Day1");
                                    string.add(player.getName());
                                    settings.getAdventFile().set("Day1", string);
                                    if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                        player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 1" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                    } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                        player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 1" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                    } else {
                                        player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 1" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                    }
                                    settings.saveAdventFile();
                                    player.giveExp(20);
                                    ItemStack diamonds = new ItemStack(Material.DIAMOND, 1);
                                    player.getInventory().addItem(diamonds);
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "The SimplyCrated Christmas Advent Calendar event has not started yet. Wait until the 1st, December to begin the event.");
                        }
                    }
                    //day2

                    else if (args[0].equalsIgnoreCase("day2")) {
                        if (player.hasPermission("simplyxmas.advent.day2")) {
                            if (settings.getAdventFile().getStringList("Day2").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 3");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day2");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day2", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 2" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 2" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 2" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamonds = new ItemStack(Material.EMERALD, 4);
                                player.getInventory().addItem(diamonds);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 2 yet. Wait until the 2nd, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day3")) {
                        if (player.hasPermission("simplyxmas.advent.day3")) {
                            if (settings.getAdventFile().getStringList("Day3").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 4");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day2");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day3", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 3" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 3" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 3" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack exp_bottle = new ItemStack(Material.EXP_BOTTLE, 16);
                                player.getInventory().addItem(exp_bottle);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 3 yet. Wait until the 3rd, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day4")) {
                        if (player.hasPermission("simplyxmas.advent.day4")) {
                            if (settings.getAdventFile().getStringList("Day4").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 5");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day4");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day4", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 4" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 4" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 4" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack jukebox = new ItemStack(Material.JUKEBOX, 1);
                                player.getInventory().addItem(jukebox);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 4 yet. Wait until the 4th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day5")) {
                        if (player.hasPermission("simplyxmas.advent.day5")) {
                            if (settings.getAdventFile().getStringList("Day5").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 6");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day5", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 5" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 5" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 5" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack emerald = new ItemStack(Material.EMERALD, 3);
                                player.getInventory().addItem(emerald);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 5 yet. Wait until the 5th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day6")) {
                        if (player.hasPermission("simplyxmas.advent.day6")) {
                            if (settings.getAdventFile().getStringList("Day6").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 7");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day6", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 6" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 6" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 6" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 3);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 6 yet. Wait until the 6th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day7")) {
                        if (player.hasPermission("simplyxmas.advent.day7")) {
                            if (settings.getAdventFile().getStringList("Day7").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 8");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day7", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 7" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 7" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 7" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack emerald = new ItemStack(Material.EMERALD, 3);
                                player.getInventory().addItem(emerald);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 7 yet. Wait until the 7th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day8")) {
                        if (player.hasPermission("simplyxmas.advent.day8")) {
                            if (settings.getAdventFile().getStringList("Day8").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 9");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day8", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 8" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 8" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 8" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack mob_spawner = new ItemStack(Material.MOB_SPAWNER, 1);
                                player.getInventory().addItem(mob_spawner);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 8 yet. Wait until the 8th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day9")) {
                        if (player.hasPermission("simplyxmas.advent.day9")) {
                            if (settings.getAdventFile().getStringList("Day9").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 10");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day9", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 9" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 9" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 9" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack emerald = new ItemStack(Material.EMERALD, 8);
                                player.getInventory().addItem(emerald);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 9 yet. Wait until the 9th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day10")) {
                        if (player.hasPermission("simplyxmas.advent.day10")) {
                            if (settings.getAdventFile().getStringList("Day10").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 11");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day10", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 10" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 10" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 10" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 10 yet. Wait until the 10th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day11")) {
                        if (player.hasPermission("simplyxmas.advent.day11")) {
                            if (settings.getAdventFile().getStringList("Day11").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 12");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day11", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 11" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 11" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 11" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 11 yet. Wait until the 11th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day12")) {
                        if (player.hasPermission("simplyxmas.advent.day12")) {
                            if (settings.getAdventFile().getStringList("Day12").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 13");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day12", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 12" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 12" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 12" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 12 yet. Wait until the 12th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day13")) {
                        if (player.hasPermission("simplyxmas.advent.day13")) {
                            if (settings.getAdventFile().getStringList("Day13").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 14");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day13", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 13" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 13" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 13" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 13 yet. Wait until the 13th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day14")) {
                        if (player.hasPermission("simplyxmas.advent.day14")) {
                            if (settings.getAdventFile().getStringList("Day14").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 15");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day14", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 14" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 14" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 14" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 14 yet. Wait until the 14th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day15")) {
                        if (player.hasPermission("simplyxmas.advent.day15")) {
                            if (settings.getAdventFile().getStringList("Day15").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 16");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day15", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 15" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 15" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 15" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 15 yet. Wait until the 15th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day16")) {
                        if (player.hasPermission("simplyxmas.advent.day16")) {
                            if (settings.getAdventFile().getStringList("Day16").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 17");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day16", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 16" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 16" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 16" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 16 yet. Wait until the 16th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day17")) {
                        if (player.hasPermission("simplyxmas.advent.day17")) {
                            if (settings.getAdventFile().getStringList("Day17").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 18");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day17", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 17" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 17" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 17" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 17 yet. Wait until the 17th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day18")) {
                        if (player.hasPermission("simplyxmas.advent.day18")) {
                            if (settings.getAdventFile().getStringList("Day18").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 19");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day18", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 18" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 18" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 18" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 18 yet. Wait until the 18th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day19")) {
                        if (player.hasPermission("simplyxmas.advent.day19")) {
                            if (settings.getAdventFile().getStringList("Day19").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 20");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day19", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 19" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 19" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 19" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 19 yet. Wait until the 19th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day20")) {
                        if (player.hasPermission("simplyxmas.advent.day20")) {
                            if (settings.getAdventFile().getStringList("Day20").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 21");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day20", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 20" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 20" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 20" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 20 yet. Wait until the 20th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day21")) {
                        if (player.hasPermission("simplyxmas.advent.day21")) {
                            if (settings.getAdventFile().getStringList("Day21").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 22");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day21", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 21" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 21" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 21" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 21 yet. Wait until the 21th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day22")) {
                        if (player.hasPermission("simplyxmas.advent.day22")) {
                            if (settings.getAdventFile().getStringList("Day22").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 23");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day22", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 22" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 22" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 22" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 22 yet. Wait until the 22th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day23")) {
                        if (player.hasPermission("simplyxmas.advent.day23")) {
                            if (settings.getAdventFile().getStringList("Day23").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 24");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day23", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 23" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 23" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 23" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 23 yet. Wait until the 23th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day24")) {
                        if (player.hasPermission("simplyxmas.advent.day24")) {
                            if (settings.getAdventFile().getStringList("Day24").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 25");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day24", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 24" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 24" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 24" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 24 yet. Wait until the 24th, December to open this day."); }
                    }
                    else if (args[0].equalsIgnoreCase("day25")) {
                        if (player.hasPermission("simplyxmas.advent.day25")) {
                            if (settings.getAdventFile().getStringList("Day25").contains(player.getName())) {
                                player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! Check back and see if you missed any days. Merry Christmas! :)");
                            } else {
                                List<String> string = settings.getAdventFile().getStringList("Day5");
                                string.add(player.getName());
                                settings.getAdventFile().set("Day25", string);
                                if (main.getConfig().getStringList("Names").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 25" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 25" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                                }
                                else {
                                    player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 25" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                                }
                                settings.saveAdventFile();
                                player.giveExp(20);
                                ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                                player.getInventory().addItem(diamond);
                            }
                        } else { player.sendMessage(ChatColor.RED + "You cannot open day 25 yet. Wait until the 25th, December to open this day."); }
                    }
                }
            }
        }
        return true;
    }
}