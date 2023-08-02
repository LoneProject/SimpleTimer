package org.lone64.simpletimer.runnable;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class RunnableManager {

    private final Map<UUID, PlayerRunnable> runnableMap = new HashMap<>();

    public void addNewRunnable(Player player, PlayerRunnable runnable) {
        this.runnableMap.put(player.getUniqueId(), runnable);
    }

    public void delRunnable(Player player) {
        this.runnableMap.remove(player.getUniqueId());
    }

    public PlayerRunnable getRunnable(Player player) {
        return this.runnableMap.get(player.getUniqueId());
    }

    public boolean isRunnable(Player player) {
        return this.runnableMap.get(player.getUniqueId()) != null;
    }

}
