package de.notjan.mmolobby.inventories;

import de.notjan.mmolobby.utils.ItemAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class NavInv {

    public static Inventory navInv = Bukkit.createInventory(null, 36, "§a§lNavigation");

    public static void NavInvBefüllen() {
        navInv.setItem(4, new ItemAPI(Material.GOLDEN_APPLE).setName("§e§l1v1").build());
        navInv.setItem(11, new ItemAPI(Material.GRASS).setName("§b§lEarth").build());
        navInv.setItem(22, new ItemAPI(Material.NETHER_STAR).setName("§a§lSpawn").build());
        navInv.setItem(15, new ItemAPI(Material.IRON_PICKAXE).setName("§c§lPrison").build());
        navInv.setItem(29, new ItemAPI(Material.ENDER_PORTAL_FRAME).setName("§9§lCrates").build());
        navInv.setItem(33, new ItemAPI(Material.DIAMOND).setName("§6§lEventserver").build());
    }
}
