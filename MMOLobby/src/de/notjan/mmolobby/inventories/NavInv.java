package de.notjan.mmolobby.inventories;

import de.notjan.mmolobby.utils.ItemAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class NavInv {

    public static Inventory navInv = Bukkit.createInventory(null, 36, "§a§lNavigation");

    public static void NavInvBefüllen() {
        navInv.setItem(2, new ItemAPI(Material.GOLDEN_APPLE).setName("§e§lUHC").build());
        navInv.setItem(6, new ItemAPI(Material.GOLD_SWORD).setName("§c§l1v1").build());
        navInv.setItem(13, new ItemAPI(Material.MAGMA_CREAM).setName("§a§lSpawn").build());
        navInv.setItem(22, new ItemAPI(Material.SKULL_ITEM).setName("§a§lCommunity").build());
        navInv.setItem(29, new ItemAPI(Material.GRASS).setName("§b§lCityBuild").build());
        navInv.setItem(33, new ItemAPI(Material.STICK).setName("§6§lKnockIT").build());
    }
}
