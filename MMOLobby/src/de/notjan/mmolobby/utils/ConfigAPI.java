package de.notjan.mmolobby.utils;

import de.notjan.mmolobby.main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigAPI {
	
	public static void setStandardConfig() {
		FileConfiguration cfg = getConfigConfiguration();

		cfg.options().copyDefaults(true);
		cfg.addDefault("MySQL.Host", "127.0.0.1");
		cfg.addDefault("MySQL.Port", "3306");
		cfg.addDefault("MySQL.Database", "localhost");
		cfg.addDefault("MySQL.Username", "root");
		cfg.addDefault("MySQL.Password", "password");
		cfg.addDefault("Prefix.Enabled", true);
		cfg.addDefault("Prefix.Rank1", "&4Owner &7| &4");
		cfg.addDefault("Prefix.Rank2", "&4Admin &7| &4");
		cfg.addDefault("Prefix.Rank3", "&bDev &7| &b");
		cfg.addDefault("Prefix.Rank4", "&cSrMod &7| &c");
		cfg.addDefault("Prefix.Rank5", "&eSrBuild &7| &e");
		cfg.addDefault("Prefix.Rank6", "&cMod &7| &c");
		cfg.addDefault("Prefix.Rank7", "&eBuild &7| &e");
		cfg.addDefault("Prefix.Rank8", "&5VIP &7| &5");
		cfg.addDefault("Prefix.Rank9", "&eElite &7| &3");
		cfg.addDefault("Prefix.Rank10", "&dSupreme &7| &d");
		cfg.addDefault("Prefix.Rank11", "&6Premium &7| &6");
		cfg.addDefault("Prefix.Rank12", "&aPlayer &7| &a");
		cfg.addDefault("Prefix.Clantagformat", " &7[&e%clantag%&7]");
		cfg.addDefault("Chat.Enabled", true);
		cfg.addDefault("Chat.Format.InClan", "&7[&e%clantag%&7] %prefix%%player% &8» &f%message%");
		cfg.addDefault("Chat.Format.NoClan", "%prefix%%player% &8» &f%message%");
		
		try {
			cfg.save(getConfig());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public static File getConfig() {
		return new File(Main.getPlugin().getDataFolder(), "config.yml");
	}

	public static FileConfiguration getConfigConfiguration() {
		return YamlConfiguration.loadConfiguration(getConfig());
	}
}
