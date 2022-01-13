package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
      //  new BukkitRunnable() {
         //   @Override
          //  public void run() {
           //     for(Player all : Bukkit.getOnlinePlayers()) {
             //       ScoreboardMethod.setScoreboard(all);
             //   }
           // }
       // }.runTaskLater(Main.getPlugin(), 1);

        if(InteractListener.hidedall.contains(e.getPlayer().getName())) {
            InteractListener.hidedall.remove(e.getPlayer().getName());
        }

        if(Main.vanish.contains(e.getPlayer())) {
            if(!e.getPlayer().hasPermission("lobby.vanish.on")) {
                Main.vanish.remove(e.getPlayer());
                for(PotionEffect effect : e.getPlayer().getActivePotionEffects()) {
                    e.getPlayer().removePotionEffect(effect.getType());
                }
            }

        }

        Player p = e.getPlayer();
        String msg = "§8[§c-§8] §c%player%";
        msg = msg.replaceAll("&", "§");
        msg = msg.replace("%player%", p.getName());
        e.setQuitMessage(msg);
    }
}
