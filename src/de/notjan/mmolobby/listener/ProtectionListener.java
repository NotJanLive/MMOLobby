package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class ProtectionListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if(!Main.build.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if(!Main.build.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(!Main.build.contains(e.getWhoClicked())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        if(!Main.build.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if(!Main.build.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(e.getEntity().getType().equals(EntityType.PLAYER)) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onFood(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void onWeather(WeatherChangeEvent e) {
        e.setCancelled(true);
    }
}
