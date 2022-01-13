package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.inventories.GadgetInv;
import de.notjan.mmolobby.inventories.NavInv;
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
        if (e.getClickedInventory().equals(NavInv.navInv)) {
            if (e.getCurrentItem().getType() == Material.GOLDEN_APPLE) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lUHC")) {
                    World world = Bukkit.getWorld(cfg.getString("Location.uhc.world"));
                    double x = cfg.getDouble("Location.uhc.x");
                    double y = cfg.getDouble("Location.uhc.y");
                    double z = cfg.getDouble("Location.uhc.z");
                    float yaw = (float) cfg.getDouble("Location.uhc.yaw");
                    float pitch = (float) cfg.getDouble("Location.uhc.pitch");

                    Location loc = new Location(world, x, y, z, yaw, pitch);
                    p.closeInventory();
                    p.teleport(loc);
                    p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                    p.sendMessage(Main.prefix + "§7Du wurdest zu §e§lUHC §r§7teleportiert.");
                }
            } else if (e.getCurrentItem().getType() == Material.GOLD_SWORD) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§l1v1")) {
                    World world = Bukkit.getWorld(cfg.getString("Location.1v1.world"));
                    double x = cfg.getDouble("Location.1v1.x");
                    double y = cfg.getDouble("Location.1v1.y");
                    double z = cfg.getDouble("Location.1v1.z");
                    float yaw = (float) cfg.getDouble("Location.1v1.yaw");
                    float pitch = (float) cfg.getDouble("Location.1v1.pitch");

                    Location loc = new Location(world, x, y, z, yaw, pitch);
                    p.closeInventory();
                    p.teleport(loc);
                    p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                    p.sendMessage(Main.prefix + "§7Du wurdest zu §c§l1v1 §r§7teleportiert.");
                }
            } else if (e.getCurrentItem().getType() == Material.MAGMA_CREAM) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSpawn")) {
                    World world = Bukkit.getWorld(cfg.getString("Location.spawn.world"));
                    double x = cfg.getDouble("Location.spawn.x");
                    double y = cfg.getDouble("Location.spawn.y");
                    double z = cfg.getDouble("Location.spawn.z");
                    float yaw = (float) cfg.getDouble("Location.spawn.yaw");
                    float pitch = (float) cfg.getDouble("Location.spawn.pitch");

                    Location loc = new Location(world, x, y, z, yaw, pitch);
                    p.closeInventory();
                    p.teleport(loc);
                    p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                    p.sendMessage(Main.prefix + "§7Du wurdest zum §a§lSpawn §r§7teleportiert.");
                }
            } else if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lCommunity")) {
                    World world = Bukkit.getWorld(cfg.getString("Location.commu.world"));
                    double x = cfg.getDouble("Location.commu.x");
                    double y = cfg.getDouble("Location.commu.y");
                    double z = cfg.getDouble("Location.commu.z");
                    float yaw = (float) cfg.getDouble("Location.commu.yaw");
                    float pitch = (float) cfg.getDouble("Location.commu.pitch");

                    Location loc = new Location(world, x, y, z, yaw, pitch);
                    p.closeInventory();
                    p.teleport(loc);
                    p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                    p.sendMessage(Main.prefix + "§7Du wurdest zu §a§lCommunity §r§7teleportiert.");
                }
            } else if (e.getCurrentItem().getType() == Material.GRASS) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lCityBuild")) {
                    World world = Bukkit.getWorld(cfg.getString("Location.cb.world"));
                    double x = cfg.getDouble("Location.cb.x");
                    double y = cfg.getDouble("Location.cb.y");
                    double z = cfg.getDouble("Location.cb.z");
                    float yaw = (float) cfg.getDouble("Location.cb.yaw");
                    float pitch = (float) cfg.getDouble("Location.cb.pitch");

                    Location loc = new Location(world, x, y, z, yaw, pitch);
                    p.closeInventory();
                    p.teleport(loc);
                    p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                    p.sendMessage(Main.prefix + "§7Du wurdest zu §b§lCityBuild §r§7teleportiert.");
                }
            } else if (e.getCurrentItem().getType() == Material.STICK) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lKnockIT")) {
                    World world = Bukkit.getWorld(cfg.getString("Location.knock.world"));
                    double x = cfg.getDouble("Location.knock.x");
                    double y = cfg.getDouble("Location.knock.y");
                    double z = cfg.getDouble("Location.knock.z");
                    float yaw = (float) cfg.getDouble("Location.knock.yaw");
                    float pitch = (float) cfg.getDouble("Location.knock.pitch");

                    Location loc = new Location(world, x, y, z, yaw, pitch);
                    p.closeInventory();
                    p.teleport(loc);
                    p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                    p.sendMessage(Main.prefix + "§7Du wurdest zu §6§lKnockIT §r§7teleportiert.");
                }
            }
        } else if (e.getClickedInventory().equals(GadgetInv.gadgetInv)) {
            if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lKopf von GommeHD")) {
                    SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
                    meta.setOwner("GommeHD");
                    ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
                    meta.setDisplayName("§a§lKopf von GommeHD");
                    skull.setItemMeta(meta);

                    p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                    p.getInventory().setHelmet(skull);
                    p.closeInventory();
                    p.sendMessage(Main.prefix + "§7Du hast nun den Kopf von GommeHD auf.");
                }
            } else if (e.getCurrentItem().getType() == Material.BARRIER) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lAktuelles Gadget entfernen")) {
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1, 1);
                    p.sendMessage(Main.prefix + "§7Du hast das aktuelle Gadget entfernt");
                    p.getInventory().setHelmet(null);
                    p.getInventory().setItem(4, new ItemAPI(Material.BARRIER).setName("§c§lKein Gadget ausgewählt").build());
                    GadgetListener.onEP.remove(p);
                }
            } else if (e.getCurrentItem().getType() == Material.ENDER_PEARL) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5EnderPerle")) {
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1, 1);
                    p.getInventory().setItem(4, new ItemAPI(Material.ENDER_PEARL).setName("§5EnderPerle §8|| §7Alle 5 Sekunden verfügbar").build());
                    GadgetListener.onEP.add(p);
                }
            }
        }
    }
}