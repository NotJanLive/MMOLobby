package de.notjan.mmolobby.inventories;

import de.notjan.mmolobby.utils.ItemAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class LobbyInv {

    public static Inventory lobbyInv = Bukkit.createInventory(null, 9, "§e§lLobby");

    public static void fillLobbyInv() {
        lobbyInv.setItem(2, new ItemAPI(Material.GLOWSTONE_DUST).setName("§eLobby 1").build());
        lobbyInv.setItem(7, new ItemAPI(Material.GOLD_INGOT).setName("§ePremium Lobby").build());
    }
}

