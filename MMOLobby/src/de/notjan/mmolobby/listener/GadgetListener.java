package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GadgetListener implements Listener {

    private HashMap<Player, EnderPearl> eps = new HashMap<>();
    public static List<Player> onEP = new ArrayList<>();

    @EventHandler
    public void onEP(PlayerInteractEvent e) {
        if(e.getItem() != null) {
            if (e.getItem().getType() == Material.ENDER_PEARL) {
                if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5EnderPerle §8|| §7Alle 5 Sekunden verfügbar")) {
                    if (e.getAction() == Action.RIGHT_CLICK_AIR) {
                        Player p = e.getPlayer();
                        e.setCancelled(true);

                        ItemStack wEnderPerle = new ItemStack(Material.FIREWORK_CHARGE);
                        ItemMeta wemeta = wEnderPerle.getItemMeta();
                        wemeta.setDisplayName("§7EnderPerle");
                        wEnderPerle.setItemMeta(wemeta);

                        p.getInventory().setItem(4, wEnderPerle);
                        p.updateInventory();

                        EnderPearl ep = p.launchProjectile(EnderPearl.class);
                        ep.setPassenger(p);
                        eps.put(p, ep);

                        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                            @Override
                            public void run() {
                                ItemStack EnderPerle = new ItemStack(Material.ENDER_PEARL);
                                ItemMeta emeta = EnderPerle.getItemMeta();
                                emeta.setDisplayName("§5EnderPerle §8|| §7Alle 5 Sekunden verfügbar");
                                EnderPerle.setItemMeta(emeta);

                                p.getInventory().setItem(4, EnderPerle);
                                p.updateInventory();
                            }
                        }, 20 * 5);


                    }
                }
            }
        }
    }

    @EventHandler
    public void onVehicleLeave(VehicleExitEvent e) {
        if(e.getExited() instanceof Player) {
            if(eps.containsKey(e.getExited())) {
                eps.get(e.getExited()).remove();
            }
        }
    }
}
