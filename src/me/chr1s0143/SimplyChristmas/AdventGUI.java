package me.chr1s0143.SimplyChristmas;

//EACH ITEMSTACK WILL BE IN 3's
//9 SLOTS 1 TO 8 SLOTS WILL BE WOOL
// LAST SLOT (DAY 25) Diamond Block
//Inventories In Inventories.



import net.minecraft.server.v1_7_R4.MaterialDecoration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/** event.getPlayer().getInventory().addItem(new CleanItem(Material.BOW)
 .withName("Bow of Power")
 * Created by chris on 24/11/2014.
 */
public class AdventGUI implements CommandExecutor, Listener{

    public static IconMenu menu = new IconMenu(ChatColor.DARK_AQUA + "Advent Calendar", 27, new IconMenu.OptionClickEventHandler() {
        @Override
        public void onOptionClick(IconMenu.OptionClickEvent event) {
            SettingsManager settings = SettingsManager.getInstance();
            Main main = Main.getInstance();
            IconMenu im = IconMenu.getInstance();
            Player player = event.getPlayer();
            String name = event.getName().toLowerCase();
            if (name.equals("day 1")) {
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
                        ItemStack diamonds = new ItemStack(Material.DIAMOND, 7);
                        player.getInventory().addItem(diamonds);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "The SimplyCrated Christmas Advent Calendar event has not started yet. Wait until the 1st, December to begin the event.");
                }
            } else if (name.equals("day 2")) {
                if (player.hasPermission("simplyxmas.advent.day2")) {
                    if (settings.getAdventFile().getStringList("Day2").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 3");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day2");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day2", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 2" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 2" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 2" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack diamond_pickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                        ItemMeta diamond_pickaxe_meta = diamond_pickaxe.getItemMeta();
                        ArrayList<String> dp = new ArrayList<String>();
                        diamond_pickaxe_meta.setDisplayName(ChatColor.GREEN + "The Christmas Pickaxe!" + ChatColor.GOLD + " - " + ChatColor.DARK_AQUA + "2014");
                        dp.add(ChatColor.GREEN + " What happened to the man ");
                        dp.add(ChatColor.GREEN + " who stole an Advent Calendar? ");
                        dp.add(ChatColor.DARK_AQUA + " He got 25 Days! HAHA!! ");
                        diamond_pickaxe_meta.setLore(dp);
                        diamond_pickaxe.setItemMeta(diamond_pickaxe_meta);
                        player.getInventory().addItem(diamond_pickaxe);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 2 yet. Wait until the 2nd, December to open this day.");
                }
            } else if (name.equals("day 3")) {
                if (player.hasPermission("simplyxmas.advent.day3")) {
                    if (settings.getAdventFile().getStringList("Day3").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 4");
                        return;
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day3");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day3", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 3" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 3" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 3" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack exp_bottle = new ItemStack(Material.EXP_BOTTLE, 16);
                        player.getInventory().addItem(exp_bottle);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 3 yet. Wait until the 3rd, December to open this day.");
                }
            } else if (name.equals("day 4")) {
                if (player.hasPermission("simplyxmas.advent.day4")) {
                    if (settings.getAdventFile().getStringList("Day4").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 5");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day4");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day4", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 4" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 4" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 4" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack jukebox = new ItemStack(Material.JUKEBOX, 1);
                        ItemMeta jukebox_meta = jukebox.getItemMeta();
                        ArrayList<String> dp = new ArrayList<String>();
                        jukebox_meta.setDisplayName(ChatColor.GREEN + "The Boom Box" + ChatColor.GOLD + " - " + ChatColor.DARK_AQUA + "2014");
                        jukebox.setItemMeta(jukebox_meta);
                        player.getInventory().addItem(jukebox);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 4 yet. Wait until the 4th, December to open this day.");
                }
            } else if (name.equals("day 5")) {
                if (player.hasPermission("simplyxmas.advent.day5")) {
                    if (settings.getAdventFile().getStringList("Day5").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 6");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day5");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day5", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 5" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 5" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 5" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack emerald = new ItemStack(Material.EMERALD, 3);
                        player.getInventory().addItem(emerald);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 5 yet. Wait until the 5th, December to open this day.");
                }
            } else if (name.equals("day 6")) {
                if (player.hasPermission("simplyxmas.advent.day6")) {
                    if (settings.getAdventFile().getStringList("Day6").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 7");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day6");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day6", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 6" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 6" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 6" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack diamond = new ItemStack(Material.DIAMOND, 3);
                        player.getInventory().addItem(diamond);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 6 yet. Wait until the 6th, December to open this day.");
                }
            } else if (name.equals("day 7")) {
                if (player.hasPermission("simplyxmas.advent.day7")) {
                    if (settings.getAdventFile().getStringList("Day7").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 8");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day7");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day7", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 7" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 7" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 7" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack emerald = new ItemStack(Material.EMERALD, 3);
                        player.getInventory().addItem(emerald);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 7 yet. Wait until the 7th, December to open this day.");
                }
            } else if (name.equals("day 8")) {
                if (player.hasPermission("simplyxmas.advent.day8")) {
                    if (settings.getAdventFile().getStringList("Day8").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 9");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day8");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day8", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 8" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 8" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 8" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack exp_bottle = new ItemStack(Material.EXP_BOTTLE, 64);
                        player.getInventory().addItem(exp_bottle);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 8 yet. Wait until the 8th, December to open this day.");
                }
            } else if (name.equals("day 9")) {
                if (player.hasPermission("simplyxmas.advent.day9")) {
                    if (settings.getAdventFile().getStringList("Day9").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 10");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day9");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day9", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 9" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 9" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 9" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack emerald = new ItemStack(Material.EMERALD, 8);
                        player.getInventory().addItem(emerald);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 9 yet. Wait until the 9th, December to open this day.");
                }
            } else if (name.equals("day 10")) {
                if (player.hasPermission("simplyxmas.advent.day10")) {
                    if (settings.getAdventFile().getStringList("Day10").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 11");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day10");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day10", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 10" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 10" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 10" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack diamond = new ItemStack(Material.DIAMOND, 5);
                        player.getInventory().addItem(diamond);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 10 yet. Wait until the 10th, December to open this day.");
                }
            } else if (name.equals("day 11")) {
                if (player.hasPermission("simplyxmas.advent.day11")) {
                    if (settings.getAdventFile().getStringList("Day11").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 12");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day11");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day11", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 11" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 11" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 11" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack emerald = new ItemStack(Material.EMERALD, 5);
                        player.getInventory().addItem(emerald);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 11 yet. Wait until the 11th, December to open this day.");
                }
            } else if (name.equals("day 12")) {
                if (player.hasPermission("simplyxmas.advent.day12")) {
                    if (settings.getAdventFile().getStringList("Day12").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 13");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day12");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day12", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 12" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 12" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 12" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack exp_bottle = new ItemStack(Material.EXP_BOTTLE, 18);
                        player.getInventory().addItem(exp_bottle);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 12 yet. Wait until the 12th, December to open this day.");
                }
            } else if (name.equals("day 13")) {
                if (player.hasPermission("simplyxmas.advent.day13")) {
                    if (settings.getAdventFile().getStringList("Day13").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 14");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day13");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day13", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 13" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 13" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 13" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack gold_sword = new ItemStack(Material.GOLD_SWORD, 1);
                        player.getInventory().addItem(gold_sword);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 13 yet. Wait until the 13th, December to open this day.");
                }
            } else if (name.equals("day 14")) {
                if (player.hasPermission("simplyxmas.advent.day14")) {
                    if (settings.getAdventFile().getStringList("Day14").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 15");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day14");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day14", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 14" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 14" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 14" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack diamond = new ItemStack(Material.DIAMOND, 3);
                        player.getInventory().addItem(diamond);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 14 yet. Wait until the 14th, December to open this day.");
                }
            } else if (name.equals("day 15")) {
                if (player.hasPermission("simplyxmas.advent.day15")) {
                    if (settings.getAdventFile().getStringList("Day15").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 16");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day15");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day15", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 15" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 15" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 15" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack emerald = new ItemStack(Material.EMERALD, 3);
                        player.getInventory().addItem(emerald);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 15 yet. Wait until the 15th, December to open this day.");
                }
            } else if (name.equals("day 16")) {
                if (player.hasPermission("simplyxmas.advent.day16")) {
                    if (settings.getAdventFile().getStringList("Day16").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 17");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day16");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day16", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 16" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 16" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 16" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack exp_bottle = new ItemStack(Material.EXP_BOTTLE, 32);
                        player.getInventory().addItem(exp_bottle);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 16 yet. Wait until the 16th, December to open this day.");
                }
            } else if (name.equals("day 17")) {
                if (player.hasPermission("simplyxmas.advent.day17")) {
                    if (settings.getAdventFile().getStringList("Day17").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 18");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day17");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day17", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 17" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 17" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 17" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack gold_nugget = new ItemStack(Material.GOLD_NUGGET, 64);
                        player.getInventory().addItem(gold_nugget);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 17 yet. Wait until the 17th, December to open this day.");
                }
            } else if (name.equals("day 18")) {
                if (player.hasPermission("simplyxmas.advent.day18")) {
                    if (settings.getAdventFile().getStringList("Day18").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 19");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day18");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day18", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 18" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 18" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 18" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack emerald_block = new ItemStack(Material.EMERALD_BLOCK, 1);
                        player.getInventory().addItem(emerald_block);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 18 yet. Wait until the 18th, December to open this day.");
                }
            } else if (name.equals("day 19")) {
                if (player.hasPermission("simplyxmas.advent.day19")) {
                    if (settings.getAdventFile().getStringList("Day19").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 20");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day19");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day19", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 19" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 19" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 19" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack diamond = new ItemStack(Material.DIAMOND, 3);
                        player.getInventory().addItem(diamond);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 19 yet. Wait until the 19th, December to open this day.");
                }
            } else if (name.equals("day 20")) {
                if (player.hasPermission("simplyxmas.advent.day20")) {
                    if (settings.getAdventFile().getStringList("Day20").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 21");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day20");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day20", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 20" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 20" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 20" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack exp_bottle = new ItemStack(Material.EXP_BOTTLE, 32);
                        player.getInventory().addItem(exp_bottle);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 20 yet. Wait until the 20th, December to open this day.");
                }
            } else if (name.equals("day 21")) {
                if (player.hasPermission("simplyxmas.advent.day21")) {
                    if (settings.getAdventFile().getStringList("Day21").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 22");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day21");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day21", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 21" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 21" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 21" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack diamond = new ItemStack(Material.DIAMOND, 7);
                        player.getInventory().addItem(diamond);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 21 yet. Wait until the 21th, December to open this day.");
                }
            } else if (name.equals("day 22")) {
                if (player.hasPermission("simplyxmas.advent.day22")) {
                    if (settings.getAdventFile().getStringList("Day22").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 23");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day22");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day22", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 22" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift." + ChatColor.DARK_GREEN + " Wish chr1s0143 a happy b-day! :D");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 22" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift." + ChatColor.DARK_GREEN + " Wish chr1s0143 a happy b-day! :D");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 22" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa" + ChatColor.DARK_GREEN + " Wish chr1s0143 a happy b-day! :D");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack gold_nugget = new ItemStack(Material.GOLD_NUGGET, 64);
                        player.getInventory().addItem(gold_nugget);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 22 yet. Wait until the 22th, December to open this day.");
                }
            } else if (name.equals("day 23")) {
                if (player.hasPermission("simplyxmas.advent.day23")) {
                    if (settings.getAdventFile().getStringList("Day23").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 24");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day23");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day23", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 23" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 23" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 23" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack diamond = new ItemStack(Material.DIAMOND, 2);
                        player.getInventory().addItem(diamond);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 23 yet. Wait until the 23th, December to open this day.");
                }
            } else if (name.equals("day 24")) {
                if (player.hasPermission("simplyxmas.advent.day24")) {
                    if (settings.getAdventFile().getStringList("Day24").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! You need to wait until tomorrow to open " + ChatColor.GOLD + "Day 25");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day24");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day24", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 24" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 24" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 24" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack diamond_block = new ItemStack(Material.DIAMOND_BLOCK, 1);
                        player.getInventory().addItem(diamond_block);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 24 yet. Wait until the 24th, December to open this day.");
                }
            } else if (name.equals("day 25")) {
                if (player.hasPermission("simplyxmas.advent.day25")) {
                    if (settings.getAdventFile().getStringList("Day25").contains(player.getName())) {
                        player.sendMessage(ChatColor.DARK_AQUA + "You have already claimed today's advent! Check back and see if you missed any days. Merry Christmas! :)");
                    } else {
                        List<String> string = settings.getAdventFile().getStringList("Day25");
                        string.add(player.getName());
                        settings.getAdventFile().set("Day25", string);
                        if (main.getConfig().getStringList("Names").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 25" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else if (main.getConfig().getStringList("Done").contains(player.getName())) {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 25" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift.");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "You have opened " + ChatColor.GOLD + "day 25" + ChatColor.AQUA + " of the 25 day advent calendar! Enjoy your gift. You haven't asked santa for a gift yet, do so now by doing " + ChatColor.GOLD + "/ask santa");
                        }
                        settings.saveAdventFile();
                        player.giveExp(20);
                        ItemStack nether_star = new ItemStack(Material.NETHER_STAR, 1);
                        ItemMeta nether_star_meta = nether_star.getItemMeta();
                        ArrayList<String> ns = new ArrayList<String>();
                        nether_star_meta.setDisplayName(ChatColor.GREEN + "SimplyCrafted Christmas" + ChatColor.GOLD + " - " + ChatColor.DARK_AQUA + "2014");
                        ns.add(ChatColor.GREEN + "SimplyCrafted staff wishes you a very Happy Christmas!");
                        nether_star_meta.setLore(ns);
                        nether_star.setItemMeta(nether_star_meta);
                        player.getInventory().addItem(nether_star);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot open day 25 yet. Wait until the 25th, December to open this day.");
                }
            }
        }
    }, Main.getInstance());

    public static void open(Player player){
        adventDayMenu();
        menu.open(player);
    }
    public static void adventDayMenu(){
        menu.setOption(0, new ItemStack(Material.CHEST), "Day 1", "Open Day 1 of the 25 Day Advent!");
        menu.setOption(1, new ItemStack(Material.CHEST), "Day 2", "Open Day 2 of the 25 Day Advent!");
        menu.setOption(2, new ItemStack(Material.CHEST), "Day 3", "Open Day 3 of the 25 Day Advent!");
        menu.setOption(3, new ItemStack(Material.CHEST), "Day 4", "Open Day 4 of the 25 Day Advent!");
        menu.setOption(4, new ItemStack(Material.CHEST), "Day 5", "Open Day 5 of the 25 Day Advent!");
        menu.setOption(5, new ItemStack(Material.CHEST), "Day 6", "Open Day 6 of the 25 Day Advent!");
        menu.setOption(6, new ItemStack(Material.CHEST), "Day 7", "Open Day 7 of the 25 Day Advent!");
        menu.setOption(7, new ItemStack(Material.CHEST), "Day 8", "Open Day 8 of the 25 Day Advent!");
        menu.setOption(8, new ItemStack(Material.CHEST), "Day 9", "Open Day 9 of the 25 Day Advent!");
        menu.setOption(9, new ItemStack(Material.CHEST), "Day 10", "Open Day 10 of the 25 Day Advent!");
        menu.setOption(10, new ItemStack(Material.CHEST), "Day 11", "Open Day 11 of the 25 Day Advent!");
        menu.setOption(11, new ItemStack(Material.CHEST), "Day 12", "Open Day 12 of the 25 Day Advent!");
        menu.setOption(12, new ItemStack(Material.CHEST), "Day 13", "Open Day 13 of the 25 Day Advent!");
        menu.setOption(13, new ItemStack(Material.CHEST), "Day 14", "Open Day 14 of the 25 Day Advent!");
        menu.setOption(14, new ItemStack(Material.CHEST), "Day 15", "Open Day 15 of the 25 Day Advent!");
        menu.setOption(15, new ItemStack(Material.CHEST), "Day 16", "Open Day 16 of the 25 Day Advent!");
        menu.setOption(16, new ItemStack(Material.CHEST), "Day 17", "Open Day 17 of the 25 Day Advent!");
        menu.setOption(17, new ItemStack(Material.CHEST), "Day 18", "Open Day 18 of the 25 Day Advent!");
        menu.setOption(19, new ItemStack(Material.CHEST), "Day 19", "Open Day 19 of the 25 Day Advent!");
        menu.setOption(20, new ItemStack(Material.CHEST), "Day 20", "Open Day 20 of the 25 Day Advent!");
        menu.setOption(21, new ItemStack(Material.CHEST), "Day 21", "Open Day 21 of the 25 Day Advent!");
        menu.setOption(22, new ItemStack(Material.CHEST), "Day 22", "Open Day 22 of the 25 Day Advent!");
        menu.setOption(23, new ItemStack(Material.CHEST), "Day 23", "Open Day 23 of the 25 Day Advent!");
        menu.setOption(24, new ItemStack(Material.CHEST), "Day 24", "Open Day 24 of the 25 Day Advent!");
        menu.setOption(25, new ItemStack(Material.CHEST), "Day 25", "Open Day 25 of the 25 Day Advent!");
    }
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("calendar")) {
                if (player.hasPermission("simplyxmas.advent.calendar")) {
                    adventDayMenu();
                    menu.open(player);
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to open the advent calendar!");
                }
            }
        }
        return true;
    }
}