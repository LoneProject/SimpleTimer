package org.lone64.simpletimer.listener;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.lone64.simpletimer.object.Config;
import org.lone64.simpletimer.runnable.PlayerRunnable;
import org.lone64.simpletimer.util.Util;
import org.lone64.simpletimer.util.runnable.Runnable;

public class BlockListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (new Config("config.yml").getBoolean("enabled") && player.getWorld().getName().equals(new Config("config.yml").getString("world"))) {
            Block block = player.getLocation().subtract(0, 1, 0).getBlock();
            if (block.getType().equals(Material.valueOf(new Config("config.yml").getString("start-block")))) {
                if (Runnable.getManager().isRunnable(player)) return;

                PlayerRunnable runnable = new PlayerRunnable(player);
                Runnable.getManager().addNewRunnable(player, runnable.start());
            } else if (block.getType().equals(Material.valueOf(new Config("config.yml").getString("stop-block")))) {
                if (!Runnable.getManager().isRunnable(player)) return;

                PlayerRunnable runnable = Runnable.getManager().getRunnable(player);
                Runnable.getManager().delRunnable(player);
                runnable.stop();
                Bukkit.broadcastMessage(Util.getColor("&6&l타이머 > &e" + player.getName() + "&e님&f의 기록은 &e[" + Util.calculateTime(runnable.getCount()) + "&e]&f입니다!"));
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                        new TextComponent(Util.getColor("&6&l타이머 > &7타이머가 종료되었습니다!")));
            }
        }
    }

}
