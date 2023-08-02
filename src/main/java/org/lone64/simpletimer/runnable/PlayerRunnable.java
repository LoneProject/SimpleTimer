package org.lone64.simpletimer.runnable;

import lombok.Getter;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.lone64.simpletimer.STimer;
import org.lone64.simpletimer.util.Util;

@Getter
public class PlayerRunnable extends BukkitRunnable {

    private final Player player;
    private int count;

    public PlayerRunnable(Player player) {
        this.player = player;
        this.count = 0;
    }

    public PlayerRunnable start() {
        this.runTaskTimer(STimer.get(), 0, 20L);
        return this;
    }

    public void stop() {
        this.cancel();
    }

    @Override
    public void run() {
        this.count++;
        this.player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                new TextComponent(Util.getColor("&6&l타이머 > &f" + Util.calculateTime(this.count))));
    }

}
