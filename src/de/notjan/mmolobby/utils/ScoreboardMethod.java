package de.notjan.mmolobby.utils;

import de.notjan.mmolobby.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardMethod {

    private Main plugin;

    public ScoreboardMethod(Main plugin) {
        this.plugin = plugin;
    }

    public static void setScoreboard(Player p) {
        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = sb.registerNewObjective("111", "222");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§6§lMMOCRAFT.DE");

        obj.getScore("§4 ").setScore(12);
        obj.getScore("§fDein Rang§7:").setScore(11);
        if(p.hasPermission("clantags.rank1"))
            obj.getScore("§c§lADMIN").setScore(10);
        else if(p.hasPermission("clantags.rank2"))
            obj.getScore("§e§lLEITUNG").setScore(10);
        else
            obj.getScore("§7§lSPIELER").setScore(10);
        obj.getScore("§7 ").setScore(9);
        obj.getScore("§fOnline§7:").setScore(8);
        obj.getScore("§e" + Bukkit.getOnlinePlayers().size() + "§8/§a" + Bukkit.getMaxPlayers()).setScore(7);
        obj.getScore("§1 ").setScore(6);
        obj.getScore("§fCoins§7:").setScore(5);
        obj.getScore("§cComing soon!").setScore(4);
        obj.getScore("§f ").setScore(3);
        obj.getScore("§fDiscord§7:").setScore(2);
        obj.getScore("§9discord.mmocraft.de").setScore(1);
        obj.getScore("§8 ").setScore(0);

        p.setScoreboard(sb);
    }
}
