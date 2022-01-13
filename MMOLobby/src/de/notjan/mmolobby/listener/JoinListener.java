package de.notjan.mmolobby.listener;

import de.notjan.mmolobby.inventories.JoinInv;
import de.notjan.mmolobby.main.Main;
import de.notjan.mmolobby.utils.MessageHandler;
import de.notjan.mmolobby.utils.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class JoinListener implements Listener {

    public Team Rank1 = ScoreboardManager.getRank1();
    public Team Rank2 = ScoreboardManager.getRank2();
    public Team Rank3 = ScoreboardManager.getRank3();
    public Team Rank4 = ScoreboardManager.getRank4();
    public Team Rank5 = ScoreboardManager.getRank5();
    public Team Rank6 = ScoreboardManager.getRank6();
    public Team Rank7 = ScoreboardManager.getRank7();
    public Team Rank8 = ScoreboardManager.getRank8();
    public Team Rank9 = ScoreboardManager.getRank9();
    public Team Rank10 = ScoreboardManager.getRank10();
    public Team Rank11 = ScoreboardManager.getRank11();
    public Team Rank12 = ScoreboardManager.getRank12();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
       Location loc = new Location(Bukkit.getWorld("world"), 88.5, 23, -1.5, 141, 1);

       // new BukkitRunnable() {
           // @Override
           // public void run() {
             //   for(Player all : Bukkit.getOnlinePlayers()) {
             //       ScoreboardMethod.setScoreboard(all);
             //   }
         //   }
       // }.runTaskLater(Main.getPlugin(), 1);

        for(String playersHiding : InteractListener.hidedall) {
            Player playersinhide = Bukkit.getPlayer(playersHiding);
            if(playersinhide != null) {
                playersinhide.hidePlayer(e.getPlayer());
            } else
                InteractListener.hidedall.remove(playersHiding);
        }

        if(e.getPlayer().hasPermission("lobby.fly")) {
            Main.fly.add(e.getPlayer());
            e.getPlayer().sendMessage(Main.prefix + "§7Da du die Permission §alobby.fly §7besitzt, wurde dein §aFliegen §7automatisch §aaktiviert§7.");
            e.getPlayer().setAllowFlight(true);
        }

        Player p = e.getPlayer();
        if(Main.build.contains(p)) {
            Main.build.remove(p);
        }
        if(Main.fly.contains(p)) {
            Main.fly.remove(p);
        }

        String msg = "§8[§b+§8] §b%player%";
        msg = msg.replaceAll("&", "§");
        msg = msg.replace("%player%", p.getName());
        e.setJoinMessage(msg);

        p.setGameMode(GameMode.SURVIVAL);
        if(PlayerCommandPreprocessEventListener.stop.contains(e.getPlayer())) {
            PlayerCommandPreprocessEventListener.stop.remove(e.getPlayer());
        }
        p.getInventory().clear();
        p.teleport(loc);
        JoinInv.GetJoinItems(p);

    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Main.build.remove(e.getPlayer());
    }

    @EventHandler
    public void onJoin1(PlayerJoinEvent event) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj= scoreboard.getObjective("test");

        if (obj == null) {
            obj = scoreboard.registerNewObjective("test", "dummy");
        }

        Rank1 = scoreboard.registerNewTeam("a");
        Rank2 = scoreboard.registerNewTeam("b");
        Rank3 = scoreboard.registerNewTeam("c");
        Rank4 = scoreboard.registerNewTeam("d");
        Rank5 = scoreboard.registerNewTeam("e");
        Rank6 = scoreboard.registerNewTeam("f");
        Rank7 = scoreboard.registerNewTeam("g");
        Rank8 = scoreboard.registerNewTeam("h");
        Rank9 = scoreboard.registerNewTeam("i");
        Rank10 = scoreboard.registerNewTeam("j");
        Rank11 = scoreboard.registerNewTeam("k");
        Rank12 = scoreboard.registerNewTeam("l");

        Bukkit.getOnlinePlayers().forEach(players -> {
            if (players.hasPermission("clantags.rank1")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank1, "a", MessageHandler.rank1_tabprefix);

            } else if(players.hasPermission("clantags.rank2")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank2, "b", MessageHandler.rank2_tabprefix);

            } else if(players.hasPermission("clantags.rank3")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank3, "c", MessageHandler.rank3_tabprefix);

            } else if(players.hasPermission("clantags.rank4")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank4, "d", MessageHandler.rank4_tabprefix);

            } else if(players.hasPermission("clantags.rank5")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank5, "e", MessageHandler.rank5_tabprefix);

            } else if(players.hasPermission("clantags.rank6")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank2, "f", MessageHandler.rank6_tabprefix);

            } else if(players.hasPermission("clantags.rank7")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank7, "g", MessageHandler.rank7_tabprefix);

            } else if(players.hasPermission("clantags.rank8")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank8, "h", MessageHandler.rank8_tabprefix);

            } else if(players.hasPermission("clantags.rank9")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank9, "i", MessageHandler.rank9_tabprefix);

            } else if(players.hasPermission("clantags.rank10")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank10, "j", MessageHandler.rank10_tabprefix);

            } else if(players.hasPermission("clantags.rank11")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank11, "k", MessageHandler.rank11_tabprefix);

            } else if(players.hasPermission("clantags.rank12")) {
                ScoreboardManager.setTeam(players, scoreboard, Rank12, "l", MessageHandler.rank12_tabprefix);
            }
        });
    }
}
