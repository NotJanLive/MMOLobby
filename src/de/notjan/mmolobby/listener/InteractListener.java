package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.inventories.LobbyInv;
import de.notjan.mmolobby.inventories.NavInv;
import de.notjan.mmolobby.main.Main;
import de.notjan.mmolobby.utils.ItemAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class InteractListener implements Listener {

    public static List<String> hidedall = new ArrayList<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getItem() != null) {
            if(!(Main.build.contains(e.getPlayer()))) {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (e.getHand() != EquipmentSlot.HAND) return;
                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lNavigator")) {
                        NavInv.NavInvBefüllen();
                        p.openInventory(NavInv.navInv);
                        p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
                    } else if (e.getItem().getType() == Material.LIME_DYE) {
                        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lSpieler verstecken")) {
                            hidedall.add(p.getName());
                            p.getInventory().setItem(8, new ItemAPI(Material.GRAY_DYE).setName("§a§lSpieler anzeigen").build());
                            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 5));
                            p.sendMessage(Main.prefix + "§7Dir werden nun keine Spieler mehr §cangezeigt§7.");
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 1);
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                p.hidePlayer(all);
                            }
                        }
                    }
                    if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                        if (e.getItem().getType() == Material.GRAY_DYE) {
                            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSpieler anzeigen")) {
                                hidedall.remove(p.getName());
                                p.getInventory().setItem(8, new ItemAPI(Material.LIME_DYE).setName("§c§lSpieler verstecken").build());
                                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 5));
                                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 1);
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    p.showPlayer(all);
                                }
                                p.sendMessage(Main.prefix + "§7Dir werden nun alle Spieler wieder §aangezeigt§7.");
                            }
                        } else if (e.getItem().getType() == Material.GLOWSTONE_DUST) {
                            if (e.getItem().getItemMeta().getDisplayName().equals("§e§lLobby")) {
                                LobbyInv.fillLobbyInv();
                                p.openInventory(LobbyInv.lobbyInv);
                                p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
                            }
                        }
                    }
                }
            }
        }
    }
}
