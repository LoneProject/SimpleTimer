package org.lone64.simpletimer.object;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.lone64.simpletimer.STimer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Config {

    private final File file;
    private final YamlConfiguration config;

    public Config(String path) {
        JavaPlugin plugin = STimer.getPlugin(STimer.class);
        this.file = new File(plugin.getDataFolder() + "/" + path);
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public void generate() {
        try {
            this.file.createNewFile();
            this.config.save(this.file);
        } catch (Exception var2) {
        }
    }

    public boolean directory() {
        return this.file.mkdir();
    }

    public boolean delete() {
        return this.file.delete();
    }

    private void save() {
        try {
            this.config.save(this.file);
        } catch (Exception var2) {}
    }

    public void setObject(String path, Object obj) {
        this.config.set(path, obj);
        this.save();
    }

    public Object getObject(String path) {
        return this.config.get(path);
    }

    public boolean getBoolean(String path) {
        return this.config.getBoolean(path);
    }

    public String getString(String path) {
        return this.config.getString(path);
    }

    public List<?> getList(String path) {
        return this.config.getList(path);
    }

    public List<String> getListString(String path) {
        return this.config.getStringList(path);
    }

    public ArrayList<String> getArrayList(String path) {
        return (ArrayList<String>) this.config.getStringList(path);
    }

    public Set<String> getSet(String path) {
        return this.config.getConfigurationSection(path).getKeys(false);
    }

    public int getInt(String path) {
        return this.config.getInt(path);
    }

    public long getLong(String path) {
        return this.config.getLong(path);
    }

    public boolean isContains(String path) {
        return this.config.contains(path);
    }

    public ItemStack getItemStack(String path) {
        return this.config.getItemStack(path);
    }

    public boolean isExists() {
        return this.file.exists();
    }

    public File[] getFiles() {
        return this.file.listFiles();
    }

    public void setReload() {
        try {
            this.config.load(this.file);
        } catch (InvalidConfigurationException | IOException var2) {}
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

}
