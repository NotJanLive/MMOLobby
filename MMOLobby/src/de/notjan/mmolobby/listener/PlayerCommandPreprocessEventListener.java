package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.main.Main;
import de.notjan.mmolobby.utils.ScoreboardMethod;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class PlayerCommandPreprocessEventListener implements Listener {
    public static List<Player> stop = new ArrayList<>();

    @EventHandler(priority = EventPriority.HIGH)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent e){
        if(e.getMessage().equalsIgnoreCase("/plugins") || e.getMessage().equalsIgnoreCase("/pl")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("§7Dieser Server nutzt die öffentlichen Plugins §aLuckPerms§7 und §aViaVersion.");
        } else if(e.getMessage().toLowerCase().startsWith("/stop")){
            if(stop.contains(e.getPlayer())){
                stop.remove(e.getPlayer());
                Bukkit.getServer().shutdown();
            }else {
                e.setCancelled(true);
                stop.add(e.getPlayer());
                e.getPlayer().sendMessage("§c§lACHTUNG! §7Es ist nicht empfohlen den Server über §a/stop §7oder §a/reload §7zu stoppen! Gebe den Befehl in §a5 Sekunden §7noch einmal ein, um den Vorgang zu bestätigen.");
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        for(Player all : Bukkit.getOnlinePlayers()) {
                            stop.remove(e.getPlayer());
                        }
                    }
                }.runTaskLater(Main.getPlugin(), 100);
            }
        }
    }
}
