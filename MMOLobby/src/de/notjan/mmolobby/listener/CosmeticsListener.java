package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.inventories.GadgetInv;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CosmeticsListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
            Player p = e.getPlayer();
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (e.getItem().getType() == Material.CHEST) {
                if (p.hasPermission("lobby.gadgets")) {
                        p.sendMessage("test");
                        if (e.getPlayer().hasPermission("lobby.gadgets")) {
                            GadgetInv.gadgetBefüllen();
                            p.openInventory(GadgetInv.gadgetInv);
                            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1, 1);
                        }
                    }   else {
                    p.sendMessage("§cDieses Feature ist aktuell nicht verfügbar!");
                    e.setCancelled(true);
                    }
                }
            }
    }
}
