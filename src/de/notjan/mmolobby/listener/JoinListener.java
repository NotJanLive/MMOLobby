package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.inventories.JoinInv;
import de.notjan.mmolobby.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
       Location loc = new Location(Bukkit.getWorld("world"), 0.5, 37, 0.5, 180, 0);

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

        String msg = "§8[§b+§8] §b%player%";
        msg = msg.replaceAll("&", "§");
        msg = msg.replace("%player%", p.getName());
        e.setJoinMessage(msg);

        p.setGameMode(GameMode.SURVIVAL);
        if(PlayerCommandPreprocessEventListener.stop.contains(e.getPlayer())) {
            PlayerCommandPreprocessEventListener.stop.remove(e.getPlayer());
        }
        if(PlayerCommandPreprocessEventListener.reload.contains((e.getPlayer()))) {
            PlayerCommandPreprocessEventListener.reload.remove(e.getPlayer());
        }
        p.getInventory().clear();
        p.teleport(loc);
        JoinInv.GetJoinItems(p);

    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Main.build.remove(e.getPlayer());
    }
}
