package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.utils.ClanManager;
import de.notjan.mmolobby.utils.MessageHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        message = message.replaceAll("%", "%%");

        if(message.contains("&") && player.hasPermission("clantags.chat.colored")) {
            message = message.replaceAll("&", "§");


            if(ClanManager.isPlayerInClan(player.getUniqueId())) {
                event.setFormat(MessageHandler.chatformat_inClan.replaceAll("%clantag%", ClanManager.getClanTag(player.getUniqueId()))
                        .replaceAll("%prefix%", getRank(player)).replaceAll("%player%", player.getName())
                        .replaceAll("%message%", message));

            } else {
                event.setFormat(MessageHandler.chatformat_noClan.replaceAll("%prefix%", getRank(player)).replaceAll("%player%", player.getName())
                        .replaceAll("%message%", message));
            }
        }


        if(ClanManager.isPlayerInClan(player.getUniqueId())) {
            event.setFormat(MessageHandler.chatformat_inClan.replaceAll("%clantag%", ClanManager.getClanTag(player.getUniqueId()))
                    .replaceAll("%prefix%", getRank(player)).replaceAll("%player%", player.getName())
                    .replaceAll("%message%", message));

        } else {
            event.setFormat(MessageHandler.chatformat_noClan.replaceAll("%prefix%", getRank(player)).replaceAll("%player%", player.getName())
                    .replaceAll("%message%", message));
        }
    }

    public String getRank(Player player) {
        if (player.hasPermission("clantags.rank1")) {
            return MessageHandler.rank1_tabprefix;

        } else if (player.hasPermission("clantags.rank2")) {
            return MessageHandler.rank2_tabprefix;

        } else if (player.hasPermission("clantags.rank3")) {
            return MessageHandler.rank3_tabprefix;

        } else if (player.hasPermission("clantags.rank4")) {
            return MessageHandler.rank4_tabprefix;

        } else if (player.hasPermission("clantags.rank5")) {
            return MessageHandler.rank5_tabprefix;

        } else if (player.hasPermission("clantags.rank6")) {
            return MessageHandler.rank6_tabprefix;

        } else if (player.hasPermission("clantags.rank7")) {
            return MessageHandler.rank7_tabprefix;

        } else if (player.hasPermission("clantags.rank8")) {
            return MessageHandler.rank8_tabprefix;

        } else if (player.hasPermission("clantags.rank9")) {
            return MessageHandler.rank9_tabprefix;

        } else if (player.hasPermission("clantags.rank10")) {
            return MessageHandler.rank10_tabprefix;

        } else if (player.hasPermission("clantags.rank11")) {
            return MessageHandler.rank11_tabprefix;

        } else if (player.hasPermission("clantags.rank12")) {
            return MessageHandler.rank12_tabprefix;
        }

        return "§f";
    }
}

