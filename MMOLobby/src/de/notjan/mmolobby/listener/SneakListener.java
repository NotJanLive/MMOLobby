package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.inventories.JoinInv;
import de.notjan.mmolobby.main.Main;
import de.notjan.mmolobby.utils.ItemAPI;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SneakListener implements Listener {

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        if(!GadgetListener.onEP.contains(e.getPlayer())) {
            if (!Main.build.contains(e.getPlayer())) {
                if (e.getPlayer().isSneaking()) {
                    e.getPlayer().getInventory().clear();
                    JoinInv.GetJoinItems(e.getPlayer());
                } else {
                    e.getPlayer().getInventory().clear();
                    e.getPlayer().getInventory().setItem(4, new ItemAPI(Material.FEATHER).setName("§a§lFlugfeder").build());
                }
            }
        } else {
            if(!Main.build.contains(e.getPlayer())) {
                if(e.getPlayer().isSneaking()) {
                    e.getPlayer().getInventory().clear();
                    JoinInv.GetJoinItems(e.getPlayer());
                    ItemStack EnderPerle = new ItemStack(Material.ENDER_PEARL);
                    ItemMeta emeta = EnderPerle.getItemMeta();
                    emeta.setDisplayName("§5EnderPerle §8|| §7Alle 5 Sekunden verfügbar");
                    EnderPerle.setItemMeta(emeta);

                    e.getPlayer().getInventory().setItem(4, EnderPerle);
                } else {
                    e.getPlayer().getInventory().clear();
                    e.getPlayer().getInventory().setItem(4, new ItemAPI(Material.FEATHER).setName("§a§lFlugfeder").build());
                }
            }
        }
    }
}
