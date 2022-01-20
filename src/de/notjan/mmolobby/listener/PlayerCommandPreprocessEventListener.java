package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.inventories.JoinInv;
import de.notjan.mmolobby.main.Main;
import de.notjan.mmolobby.utils.ItemAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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
    public static List<Player> reload = new ArrayList<>();

    @EventHandler(priority = EventPriority.HIGH)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().equalsIgnoreCase("/plugins") || e.getMessage().equalsIgnoreCase("/pl")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("§7Dieser Server nutzt die öffentlichen Plugins §aLuckPerms§7 und §aViaVersion.");
        } else if (e.getMessage().toLowerCase().startsWith("/stop")) {
            if (e.getPlayer().hasPermission("lobby.stop")) {
                if (stop.contains(e.getPlayer())) {
                    stop.remove(e.getPlayer());
                    Bukkit.getServer().shutdown();
                } else {
                    e.setCancelled(true);
                    stop.add(e.getPlayer());
                    e.getPlayer().sendMessage("§c§lACHTUNG! §7Es ist nicht empfohlen den Server über §a/stop §7oder §a/reload §7zu stoppen! Gebe den Befehl in §a5 Sekunden §7noch einmal ein, um den Vorgang zu bestätigen.");
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                stop.remove(e.getPlayer());
                            }
                        }
                    }.runTaskLater(Main.getPlugin(), 100);
                }
            } else {
                e.getPlayer().sendMessage(Main.prefix + "§cDazu hast du keine Rechte!");
            }
        } else if (e.getMessage().toLowerCase().startsWith("/reload") || e.getMessage().toLowerCase().startsWith("/rl")) {
            if (e.getPlayer().hasPermission("lobby.stop")) {
                if (reload.contains(e.getPlayer())) {
                    reload.remove(e.getPlayer());
                    Bukkit.getServer().reload();
                } else {
                    e.setCancelled(true);
                    reload.add(e.getPlayer());
                    e.getPlayer().sendMessage("§c§lACHTUNG! §7Es ist nicht empfohlen den Server über §a/stop §7oder §a/reload §7zu stoppen! Gebe den Befehl in §a5 Sekunden §7noch einmal ein, um den Vorgang zu bestätigen.");
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                reload.remove(e.getPlayer());
                            }
                        }
                    }.runTaskLater(Main.getPlugin(), 100);
                }
            } else {
                e.getPlayer().sendMessage(Main.prefix + "§cDazu hast du keine Rechte!");
            }
        } else if (e.getMessage().toLowerCase().startsWith("/clear")) {
            e.setCancelled(true);
            e.getPlayer().getInventory().clear();
            e.getPlayer().getInventory().setItem(4, new ItemAPI(Material.COMPASS).setName("§a§lNavigator").build());
            e.getPlayer().getInventory().setItem(8, new ItemAPI(Material.LIME_DYE).setName("§c§lSpieler verstecken").build());
            e.getPlayer().sendMessage(Main.prefix + "§7Dir wurden alle Items §aerfolgreich §7gecleart!");

        } else if(e.getMessage().toLowerCase().startsWith("/help") || e.getMessage().toLowerCase().startsWith("/?") || e.getMessage().toLowerCase().startsWith("/bukkit") || e.getMessage().toLowerCase().startsWith("/version")){
            if(!(e.getPlayer().hasPermission("lobby.admin"))) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(Main.prefix + "§cComing soon!");
            }
        }
    }
}
