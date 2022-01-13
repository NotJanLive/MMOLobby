package de.notjan.mmolobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardManager {

	private static Team rank1;
	private static Team rank2;
	private static Team rank3;
	private static Team rank4;
	private static Team rank5;
	private static Team rank6;
	private static Team rank7;
	private static Team rank8;
	private static Team rank9;
	private static Team rank10;
	private static Team rank11;
	private static Team rank12;
	private static Scoreboard scoreboard;

	public static Scoreboard getScoreboard() {
		return scoreboard;
	}

	public static Team getRank1() {
		return rank1;
	}

	public static Team getRank2() {
		return rank2;
	}

	public static Team getRank3() {
		return rank3;
	}

	public static Team getRank4() {
		return rank4;
	}

	public static Team getRank5() {
		return rank5;
	}

	public static Team getRank6() {
		return rank6;
	}

	public static Team getRank7() {
		return rank7;
	}

	public static Team getRank8() {
		return rank8;
	}

	public static Team getRank9() {
		return rank9;
	}

	public static Team getRank10() {
		return rank10;
	}

	public static Team getRank11() {
		return rank11;
	}

	public static Team getRank12() {
		return rank12;
	}

	@SuppressWarnings("deprecation")
	public static void setTeam(Player players, Scoreboard scoreboard, Team team, String teamname, String prefix) {
		team = scoreboard.getTeam(teamname);

		Objective obj = scoreboard.registerNewObjective("111", "222");

		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("§6§lMMOCRAFT.DE");

		obj.getScore("§4 ").setScore(12);
		obj.getScore("§fDein Rang§7:").setScore(11);
		if(players.hasPermission("clantags.rank1"))
			obj.getScore("§c§lADMIN").setScore(10);
		else if(players.hasPermission("clantags.rank2"))
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


		if (team == null) {
			team = scoreboard.registerNewTeam(teamname);
		}
		
		team.removeEntry(players.getName());
		team.setPrefix(prefix);
		
		if (ClanManager.isPlayerInClan(players.getUniqueId())) {
			String clanTag = ClanManager.getClanTag(players.getUniqueId());
			
			players.setPlayerListName(team.getPrefix() + players.getName() + MessageHandler.clantagformat.replaceAll("%clantag%", clanTag));
			team.addPlayer(players);
		} else {
			players.setPlayerListName(team.getPrefix() + players.getName());
			team.addPlayer(players);
		}
		
		players.setScoreboard(scoreboard);
	}

}
