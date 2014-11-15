package me.chr1s0143.SimplyChristmas;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by chris on 13/11/2014.
 */
public class SettingsManager {

    private SettingsManager() { }

    static SettingsManager instance = new SettingsManager();

    public static SettingsManager getInstance() {
        return instance;
    }

    Plugin plugin;

    FileConfiguration locations;
    File lfile;

    FileConfiguration advent;
    File afile;

    public void setupAdventFile(Plugin plugin) {

        afile = new File(plugin.getDataFolder(), "advent.yml");

        if (!afile.exists()) {
            try {
                afile.createNewFile();
            }
            catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create advent.yml!");
            }
        }

        advent = YamlConfiguration.loadConfiguration(afile);
    }

    public FileConfiguration getAdventFile() {
        return advent;
    }

    public void saveDefaultAdventFile() {
        if (advent == null) {
            afile = new File(plugin.getDataFolder(), "advent.yml");
        }
        if (!afile.exists()) {
            plugin.saveResource("advent.yml", false);
        }
    }

    public void saveAdventFile() {
        try {
            advent.save(afile);
        }
        catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save advent.yml!");
        }
    }

    public void reloadAdventFile() {
        advent = YamlConfiguration.loadConfiguration(afile);
    }

    //LOCATIONS FILE

    public void setupLocationFile(Plugin plugin) {

        lfile = new File(plugin.getDataFolder(), "locations.yml");

        if (!lfile.exists()) {
            try {
                lfile.createNewFile();
            }
            catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create locations.yml!");
            }
        }

        locations = YamlConfiguration.loadConfiguration(lfile);
    }

    public FileConfiguration getLocationsFile() {
        return locations;
    }

    public void saveDefaultLocationsFile() {
        if (locations == null) {
            lfile = new File(plugin.getDataFolder(), "locations.yml");
        }
        if (!lfile.exists()) {
            plugin.saveResource("locations.yml", false);
        }
    }

    public void saveLocationsFile() {
        try {
            locations.save(lfile);
        }
        catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save locations.yml!");
        }
    }

    public void reloadLocationsFile() {
        locations = YamlConfiguration.loadConfiguration(lfile);
    }

}
