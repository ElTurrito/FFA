package dev.waterfall.elturrito.listeners;

import dev.waterfall.elturrito.manager.FFAManager;
import dev.waterfall.elturrito.utils.CC;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class FFAListener implements Listener {

    public FFAListener() {}

    @EventHandler
    public void playerDamage(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Player) {
            if (e.getEntity() instanceof Player) {

                Player damaged = (Player) e.getEntity();
                Player damager = (Player) e.getDamager();

                if(!FFAManager.FFATOGGLEPLAYING.contains(damaged)){
                    e.setCancelled(true);
                }else{
                    e.setCancelled(false);
                }

                if(!FFAManager.FFATOGGLEPLAYING.contains(damaged)){
                    e.setCancelled(true);
                }else{
                    e.setCancelled(false);
                }
            }
        }
    }

    @EventHandler
    public void damageFall(EntityDamageEvent e){
        DamageCause damageCause = e.getCause();

        if(damageCause.equals(DamageCause.FALL)){
            e.setCancelled(true);
        }

        if(damageCause.equals(DamageCause.DROWNING)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void leaveWhenFFAIsEnable(PlayerQuitEvent e){
        Player j = e.getPlayer();

        if(FFAManager.FFATOGGLEPLAYING.contains(j)){
            CC.console("The player " + j.getName() + " leave when the FFA is enabled, and she FFA MODE has toggle off.");
        }
    }

    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent e){
        Location loc = e.getEntity().getLocation();

        loc.getWorld().strikeLightning(loc);
        e.setDroppedExp(0);
        e.getDrops().clear();
        loc.getWorld().playEffect(loc, Effect.NOTE, 1.0F);

        ItemStack goldenApple = new ItemStack(322, 4, (short)0);
        loc.getWorld().dropItemNaturally(loc, goldenApple);
    }
}
