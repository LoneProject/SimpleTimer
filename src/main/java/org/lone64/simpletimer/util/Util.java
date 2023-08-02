package org.lone64.simpletimer.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Util {

    public static String getColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String getNumberFormat(int num) {
        DecimalFormat df = new DecimalFormat("#,##0");
        return df.format(num);
    }

    public static String getDoubleFormat(int num) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(num);
    }

    public static String getGenerateString(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            if (i % 4 == 0 && i > 0) {
                result.append("-");
            } else if (i % 2 == 0) {
                int index = random.nextInt(alphabet.length());
                char randomChar = alphabet.charAt(index);
                result.append(randomChar);
            } else {
                int index = random.nextInt(numbers.length());
                char randomNum = numbers.charAt(index);
                result.append(randomNum);
            }
        }

        return result.toString();
    }

    public static String getName(UUID uuid) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
        return player.getName();
    }

    public static String calculateTime(long seconds) {
        int day = (int) TimeUnit.SECONDS.toDays(seconds);
        long hours = TimeUnit.SECONDS.toHours(seconds) - (day * 24L);
        long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds) * 60);
        long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) * 60);

        if (hours > 0 && day == 0)
            return hours + "시 " + minute + "분 " + second + "초";
        if (hours >= 0 && day > 0)
            return day + "일 " + hours + "시 " + minute + "분 " + second + "초";

        return minute + "분 " + second + "초";
    }

    public static ItemStack getUsed(ItemStack is, int amount) {
        if (is.getAmount() == 1) {
            return null;
        } else {
            is.setAmount(is.getAmount() - amount);
            return is;
        }
    }

    public static ItemStack getItem(ItemStack is, int amount) {
        if (is.getAmount() == 1) {
            return null;
        } else {
            is.setAmount(amount);
            return is;
        }
    }

}
