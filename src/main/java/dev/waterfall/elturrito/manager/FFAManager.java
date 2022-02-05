package dev.waterfall.elturrito.manager;

import dev.waterfall.elturrito.FFA;
import dev.waterfall.elturrito.utils.CC;
import dev.waterfall.elturrito.utils.YamlDoc;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class FFAManager {

    public static ArrayList<Player> FFATOGGLEPLAYING = new ArrayList();

    public static void sendToArena(Player j, boolean message){
        YamlDoc c = FFA.getInstance().getConfigFile();

        double x = c.getDouble("CONFIG.ARENA-SPAWN.X");
        double y = c.getDouble("CONFIG.ARENA-SPAWN.Y");
        double z = c.getDouble("CONFIG.ARENA-SPAWN.Z");
        float yaw = Float.parseFloat(c.getString("CONFIG.ARENA-SPAWN.YAW"));
        float pitch = Float.parseFloat(c.getString("CONFIG.ARENA-SPAWN.PITCH"));
        World world = FFA.getInstance().getServer().getWorld(c.getString("CONFIG.ARENA-SPAWN.WORLD"));

        Location l = new Location(world, x, y, z, yaw, pitch);

        j.teleport(l);
        if(message){
            j.sendMessage(CC.translate("&aYou has been teleported to the arena"));
        }
    }

    public static void sendToSpawn(Player j, boolean message){
        YamlDoc c = FFA.getInstance().getConfigFile();

        double x = c.getDouble("CONFIG.WAIT-SPAWN.X");
        double y = c.getDouble("CONFIG.WAIT-SPAWN.Y");
        double z = c.getDouble("CONFIG.WAIT-SPAWN.Z");
        float yaw = Float.parseFloat(c.getString("CONFIG.WAIT-SPAWN.YAW"));
        float pitch = Float.parseFloat(c.getString("CONFIG.WAIT-SPAWN.PITCH"));
        World world = FFA.getInstance().getServer().getWorld(c.getString("CONFIG.WAIT-SPAWN.WORLD"));

        Location l = new Location(world, x, y, z, yaw, pitch);

        j.teleport(l);
        if(message){
            j.sendMessage(CC.translate("&aYou has been teleported to the arena"));
        }
    }

    public static void setFFAInventory(Player j){
        ItemStack he = new ItemStack(310, 1, (short)0);
        ItemStack ch = new ItemStack(311, 1, (short)0);
        ItemStack leg = new ItemStack(312, 1, (short)0);
        ItemStack bo = new ItemStack(313, 1, (short)0);
        ItemStack sword = new ItemStack(276, 1, (short)0);
        ItemStack enderpearl = new ItemStack(368, 16, (short)0);
        ItemStack steack = new ItemStack(364, 32, (short)0);
        PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 99999, 1);

        j.getInventory().setHelmet(he);
        j.getInventory().setChestplate(ch);
        j.getInventory().setLeggings(leg);
        j.getInventory().setBoots(bo);
        j.getInventory().setItem(0, sword);
        j.getInventory().setItem(1, enderpearl);
        j.getInventory().setItem(2, steack);

        j.addPotionEffect(speed);
        for (int i = 3; i < 34; i++) {
            ItemStack healthPotions = new ItemStack(373, 1, (short)16421);
            j.getInventory().setItem(i, healthPotions);
        }
    }

    public static void setDefaultInventory(Player j){
        j.getInventory().clear();
        j.getInventory().setArmorContents(null);
    }

    public static void joinFFAPlaying(Player j){
        j.getInventory().clear();
        j.getInventory().setArmorContents(null);

        sendToArena(j, true);
        setFFAInventory(j);
        FFATOGGLEPLAYING.add(j);
    }

    public static void leaveFFAPlaying(Player j){
        sendToSpawn(j, true);
        setDefaultInventory(j);

        FFATOGGLEPLAYING.remove(j);
    }
}
