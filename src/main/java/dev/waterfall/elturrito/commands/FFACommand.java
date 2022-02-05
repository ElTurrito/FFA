package dev.waterfall.elturrito.commands;

import dev.waterfall.elturrito.FFA;
import dev.waterfall.elturrito.manager.FFAManager;
import dev.waterfall.elturrito.utils.CC;
import dev.waterfall.elturrito.utils.YamlDoc;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FFACommand implements CommandExecutor {

    public FFACommand(FFA ffa){}


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }

        Player j = (Player)sender;
        if(args.length == 0){
            this.sendUsage(j);
        }

        if(args.length == 1){
            if(args[0].equalsIgnoreCase("join")){
               FFAManager.joinFFAPlaying(j);
               j.sendMessage(CC.translate("&aSucessfully given't the FFA kit."));
            }else if(args[0].equalsIgnoreCase("leave")){
                FFAManager.leaveFFAPlaying(j);
                j.sendMessage(CC.translate("&cYou leaven't the FFA game"));
            }else if(args[0].equalsIgnoreCase("setspawn")){
                YamlDoc c = FFA.getInstance().getConfigFile();

                double x = j.getLocation().getX();
                double y = j.getLocation().getY();
                double z = j.getLocation().getZ();
                float yaw = j.getLocation().getYaw();
                float pitch = j.getLocation().getPitch();
                String world = j.getWorld().getName();

               c.set("CONFIG.WAIT-SPAWN.X", x);
               c.set("CONFIG.WAIT-SPAWN.Y", y);
               c.set("CONFIG.WAIT-SPAWN.Z", z);
               c.set("CONFIG.WAIT-SPAWN.YAW", yaw);
               c.set("CONFIG.WAIT-SPAWN.PITCH", pitch);
               c.set("CONFIG.WAIT-SPAWN.WORLD", world);

               c.save();
               j.sendMessage(CC.translate("&aCorreclty set the currently wait spawn."));
            }else if(args[0].equalsIgnoreCase("setffaspawn")){
                YamlDoc c = FFA.getInstance().getConfigFile();

                double x = j.getLocation().getX();
                double y = j.getLocation().getY();
                double z = j.getLocation().getZ();
                float yaw = j.getLocation().getYaw();
                float pitch = j.getLocation().getPitch();
                String world = j.getWorld().getName();

                c.set("CONFIG.ARENA-SPAWN.X", x);
                c.set("CONFIG.ARENA-SPAWN.Y", y);
                c.set("CONFIG.ARENA-SPAWN.Z", z);
                c.set("CONFIG.ARENA-SPAWN.YAW", yaw);
                c.set("CONFIG.ARENA-SPAWN.PITCH", pitch);
                c.set("CONFIG.ARENA-SPAWN.WORLD", world);

                c.save();
                j.sendMessage(CC.translate("&aCorrectly set the ffa spawn."));
            }
        }
        return true;
    }

    private void sendUsage(Player j){
        j.sendMessage(CC.translate("&f&m----------------------"));
        j.sendMessage(CC.translate("&cCorrect usages"));
        j.sendMessage("");
        j.sendMessage(CC.translate("&c/ffa join"));
        j.sendMessage(CC.translate("&c/ffa leave"));
        j.sendMessage("");
        j.sendMessage(CC.translate("&f&m----------------------"));
        if(j.isOp()){
            j.sendMessage("");
            j.sendMessage(CC.translate("&f&m----------------------"));
            j.sendMessage(CC.translate("&cAdmin usages"));
            j.sendMessage("");
            j.sendMessage(CC.translate("&c/ffa setspawn"));
            j.sendMessage(CC.translate("&c/ffa setffaspawn"));
            j.sendMessage("");
            j.sendMessage(CC.translate("&f&m----------------------"));
        }
    }
}
