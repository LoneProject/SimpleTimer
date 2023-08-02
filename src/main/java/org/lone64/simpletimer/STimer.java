package org.lone64.simpletimer;

import org.bukkit.plugin.java.JavaPlugin;
import org.lone64.simpletimer.listener.BlockListener;
import org.lone64.simpletimer.listener.PlayerListener;
import org.lone64.simpletimer.object.Config;
import org.lone64.simpletimer.runnable.RunnableManager;

public final class STimer extends JavaPlugin {

    private static STimer instance;

    private static RunnableManager manager;

    @Override
    public void onEnable() {
        instance = this;
        manager = new RunnableManager();

        // CONFIGS
        if (!new Config("config.yml").isExists())
            this.saveResource("config.yml", false);

        // LISTENERS
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public static STimer get() {
        return instance;
    }

    public static RunnableManager getManager() {
        return manager;
    }

}
