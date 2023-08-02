package org.lone64.simpletimer.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.lone64.simpletimer.util.Util;
import org.lone64.simpletimer.util.runnable.Runnable;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (Runnable.getManager().isRunnable(player)) Runnable.getManager().delRunnable(player);
        player.sendMessage(Util.getColor("&6&l타이머 > &f해당 서버는 &e[lone64]&f의 타이머 플러그인을 사용하고 있습니다!"));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (Runnable.getManager().isRunnable(player)) Runnable.getManager().delRunnable(player);
    }

}
