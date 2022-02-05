package dev.waterfall.elturrito.commands;

import dev.waterfall.elturrito.FFA;
import dev.waterfall.elturrito.manager.FFAManager;
import dev.waterfall.elturrito.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    public SpawnCommand(FFA ffa){}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            CC.console("&cOnly player can execute commands");
            return true;
        }
        Player j = (Player)sender;

        if(args.length == 0){
            FFAManager.sendToSpawn(j, true);
            return true;
        }
        return true;
    }
}
