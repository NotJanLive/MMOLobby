package de.notjan.mmolobby.inventories;

import de.notjan.mmolobby.utils.ItemAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SkullMeta;

public class JoinInv {

    public static void GetJoinItems(Player p) {
        p.getInventory().setItem(4, new ItemAPI(Material.COMPASS).setName("§a§lNavigator").build());
        p.getInventory().setItem(8, new ItemAPI(Material.LIME_DYE).setName("§c§lSpieler verstecken").build());
    }
}
