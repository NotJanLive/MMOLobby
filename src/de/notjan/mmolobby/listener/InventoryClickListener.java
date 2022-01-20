package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.main.Main;
import de.notjan.mmolobby.utils.ItemAPI;

import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        FileConfiguration cfg = Main.getPlugin().getConfig();
        Player p = (Player) e.getWhoClicked();
        if (!(e.getView().getTitle() == null)) {
            if (e.getView().getTitle() .equals("§a§lNavigation")) {
                if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lSkywars")) {
                        p.closeInventory();
                        p.sendMessage(Main.prefix + "§7Teleportiere zu §aSkywars§7...");
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1, 1);
                        p.teleport(new Location(p.getWorld(), -23.5, 29, -92.5, 145, 0));
                    }
                } else if (e.getCurrentItem().getType() == Material.GRASS) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEarth")) {
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1, 1);
                        p.sendMessage(Main.prefix + "§cDieser Modus ist aktuell nicht verfügbar!");
                    }
                } else if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSpawn")) {
                        p.closeInventory();
                        p.teleport(new Location(Bukkit.getWorld("world"), 0.5, 37, 0.5, -180, 0));
                        p.sendMessage(Main.prefix + "§7Du wurdest erfolgreich zum §aSpawn §7teleportiert!");
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1, 1);
                    }
                } else if (e.getCurrentItem().getType() == Material.IRON_PICKAXE) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPrison")) {
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1, 1);
                        p.sendMessage(Main.prefix + "§cDieser Modus ist aktuell nicht verfügbar!");

                    }
                } else if (e.getCurrentItem().getType() == Material.DIAMOND) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lEventserver")) {
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1, 1);
                        p.sendMessage(Main.prefix + "§cDieser Modus ist aktuell nicht verfügbar!");
                    }
                } else if (e.getCurrentItem().getType() == Material.END_PORTAL_FRAME) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9§lCrates")) {
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1, 1);
                        p.sendMessage(Main.prefix + "§cDiese Funktion ist erst zu einem späterem Zeitpunkt verfügbar!");
                    }
                }
            }
        }
    }
}