package de.notjan.mmolobby.inventories;

import de.notjan.mmolobby.utils.ItemAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class GadgetInv {

    public static Inventory gadgetInv = Bukkit.createInventory(null, 9, "§e§lGadgets");

    public static void gadgetBefüllen() {
        SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
        meta.setOwner("GommeHD");
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        meta.setDisplayName("§a§lKopf von GommeHD");
        skull.setItemMeta(meta);

        gadgetInv.setItem(0, skull);
        gadgetInv.setItem(8, new ItemAPI(Material.BARRIER).setName("§c§lAktuelles Gadget entfernen").build());
        gadgetInv.setItem(7, new ItemAPI(Material.ENDER_PEARL).setName("§5EnderPerle").build());
    }
}
