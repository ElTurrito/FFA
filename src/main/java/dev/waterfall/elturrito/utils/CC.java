package dev.waterfall.elturrito.utils;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

public class CC {

    public static String translate(String cc){
       return ChatColor.translateAlternateColorCodes('&', cc);
    }

    public static String console(String msg){
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(translate(msg));
        return msg;
    }
}
