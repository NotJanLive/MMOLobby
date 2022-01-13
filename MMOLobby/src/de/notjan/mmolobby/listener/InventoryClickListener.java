package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.inventories.GadgetInv;
import de.notjan.mmolobby.inventories.LobbyInv;
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
        if (!(e.getClickedInventory().getTitle() == null)) {
            if (e.getClickedInventory().getTitle().equals("§a§lNavigation")) {
                if (e.getCurrentItem().getType() == Material.GOLDEN_APPLE) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§l1v1")) {
                        p.closeInventory();
                        p.sendMessage(Main.prefix + "§7Verbinde zu §a1v1§7...");
                        p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                        Bukkit.dispatchCommand(p, "s 1v1");
                    }
                } else if (e.getCurrentItem().getType() == Material.GRASS) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEarth")) {
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                        p.sendMessage(Main.prefix + "§7Verbinde zu §aEarth§7...");
                        Bukkit.dispatchCommand(p, "s Earth");
                    }
                } else if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSpawn")) {
                        p.closeInventory();
                        p.teleport(new Location(Bukkit.getWorld("world"), 88.5, 23, -1.5, 141, 1));
                        p.sendMessage(Main.prefix + "§7Du wurdest erfolgreich zum §aSpawn §7teleportiert!");
                        p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                    }
                } else if (e.getCurrentItem().getType() == Material.IRON_PICKAXE) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPrison")) {
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                        p.sendMessage(Main.prefix + "§7Verbinde zu §aPrison§7...");
                        Bukkit.dispatchCommand(p, "s Prison");

                    }
                } else if (e.getCurrentItem().getType() == Material.DIAMOND) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lEventserver")) {
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                        p.sendMessage(Main.prefix + "§7Verbinde zu §aEvent§7...");
                        Bukkit.dispatchCommand(p, "s Eventserver");
                    }
                } else if (e.getCurrentItem().getType() == Material.ENDER_PORTAL_FRAME) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9§lCrates")) {
                        p.closeInventory();
                        p.teleport(new Location(Bukkit.getWorld("world"), 96.5, 17, -29.5, 180, 0));
                        p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                        p.sendMessage(Main.prefix + "§7Du wurdest erfolgreich zu den §aCrates §7teleportiert!");
                    }
                }
                if (e.getClickedInventory().equals(GadgetInv.gadgetInv)) {
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
            if (e.getClickedInventory().equals(LobbyInv.lobbyInv)) {
                if (e.getCurrentItem().getType() == Material.GLOWSTONE_DUST) {
                    p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                    p.sendMessage(Main.prefix + "§7Verbinde zu §aLobby§7...");
                    Bukkit.dispatchCommand(p, "s Lobby");
                    p.closeInventory();
                }
                if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
                    p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                    p.sendMessage(Main.prefix + "§7Verbinde zu §aPremium-Lobby§7...");
                    Bukkit.dispatchCommand(p, "s 1v1");
                    p.closeInventory();
                }
            }
        }
    }
}