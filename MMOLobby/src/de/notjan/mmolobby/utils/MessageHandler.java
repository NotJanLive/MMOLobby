package de.notjan.mmolobby.utils;

import org.bukkit.configuration.file.FileConfiguration;

public class MessageHandler {
	
	public static String rank1_tabprefix;
	
	public static String rank2_tabprefix;
	
	public static String rank3_tabprefix;
	
	public static String rank4_tabprefix;
	
	public static String rank5_tabprefix;
	
	public static String rank6_tabprefix;
	
	public static String rank7_tabprefix;
	
	public static String rank8_tabprefix;

	public static String rank9_tabprefix;
	
	public static String rank10_tabprefix;
	
	public static String rank11_tabprefix;
	
	public static String rank12_tabprefix;
	
	public static String clantagformat;
	
	public static String chatformat_inClan;
	public static String chatformat_noClan;
	
	public static void loadMessages() {
		FileConfiguration config = ConfigAPI.getConfigConfiguration();
		
		rank1_tabprefix = config.getString("Prefix.Rank1").replaceAll("&", "§");
		
		rank2_tabprefix = config.getString("Prefix.Rank2").replaceAll("&", "§");
		
		rank3_tabprefix = config.getString("Prefix.Rank3").replaceAll("&", "§");
		
		rank4_tabprefix = config.getString("Prefix.Rank4").replaceAll("&", "§");
		
		rank5_tabprefix = config.getString("Prefix.Rank5").replaceAll("&", "§");
		
		rank6_tabprefix = config.getString("Prefix.Rank6").replaceAll("&", "§");
		
		rank7_tabprefix = config.getString("Prefix.Rank7").replaceAll("&", "§");
		
		rank8_tabprefix = config.getString("Prefix.Rank8").replaceAll("&", "§");
		
		rank9_tabprefix = config.getString("Prefix.Rank9").replaceAll("&", "§");
		
		rank10_tabprefix = config.getString("Prefix.Rank10").replaceAll("&", "§");
		
		rank11_tabprefix = config.getString("Prefix.Rank11").replaceAll("&", "§");
		
		rank12_tabprefix = config.getString("Prefix.Rank12").replaceAll("&", "§");
		
		clantagformat = config.getString("Prefix.Clantagformat").replaceAll("&", "§");
		
		chatformat_inClan = config.getString("Chat.Format.InClan").replaceAll("&", "§");
		chatformat_noClan = config.getString("Chat.Format.NoClan").replaceAll("&", "§");
	}
}
