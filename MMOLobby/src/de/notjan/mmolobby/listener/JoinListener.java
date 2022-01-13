package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.inventories.JoinInv;
import de.notjan.mmolobby.main.Main;
import de.notjan.mmolobby.utils.ScoreboardMethod;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    ScoreboardMethod.setScoreboard(all);
                }
            }
        }.runTaskLater(Main.getPlugin(), 1);

        for(String playersHiding : InteractListener.hidedall) {
            Player playersinhide = Bukkit.getPlayer(playersHiding);
            if(playersinhide != null) {
                playersinhide.hidePlayer(e.getPlayer());
            } else
                InteractListener.hidedall.remove(playersHiding);
        }

        if(e.getPlayer().hasPermission("lobby.fly")) {
            Main.fly.add(e.getPlayer());
            e.getPlayer().sendMessage(Main.prefix + "§7Da du die Permission §alobby.fly §7besitzt, wurde dein §aFliegen §7automatisch §aaktiviert§7.");
            e.getPlayer().setAllowFlight(true);
        }

        Player p = e.getPlayer();
        if(Main.build.contains(p)) {
            Main.build.remove(p);
        }
        if(Main.fly.contains(p)) {
            Main.fly.remove(p);
        }

        String msg = Main.getPlugin().getConfig().getString("Lobby.JoinMessage");
        msg = msg.replaceAll("&", "§");
        msg = msg.replace("%player%", p.getName());
        e.setJoinMessage(msg);

        p.setGameMode(GameMode.SURVIVAL);
        if(PlayerCommandPreprocessEventListener.stop.contains(e.getPlayer())) {
            PlayerCommandPreprocessEventListener.stop.remove(e.getPlayer());
        }
        JoinInv.GetJoinItems(p);

    }
}
