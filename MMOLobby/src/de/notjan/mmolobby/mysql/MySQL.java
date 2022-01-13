package de.notjan.mmolobby.mysql;

import de.notjan.mmolobby.utils.ConfigAPI;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

	public static String username;
	public static String password;
	public static String database;
	public static String host;
	public static String port;
	public static Connection connection;

	public static void connect() {
		if (!isConnected()) {
			try {
				connection = DriverManager.getConnection(
						"jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", username, password);
				System.out.println("[MySQL] The MySQL connection for the plugin 'MMOLObby' has been activated!");
			} catch (SQLException exception) {
				exception.printStackTrace();
				System.out.println("[MySQL] An error occurred during the connection for the plugin 'MMOLobby'! Please check the MySQL-Data in the config.yml!");
			}
		}
	}

	public static void close() {
		if (isConnected()) {
			try {
				connection.close();
				System.out.println("[MySQL] The MySQL connection for the plugin 'MMOLobby' has been deactivated!");
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
	}

	public static boolean isConnected() {
		return connection != null;
	}

	public static void readMySQL() {
		FileConfiguration cfg = ConfigAPI.getConfigConfiguration();
		host = cfg.getString("MySQL.Host");
		port = cfg.getString("MySQL.Port");
		database = cfg.getString("MySQL.Database");
		username = cfg.getString("MySQL.Username");
		password = cfg.getString("MySQL.Password");
	}
}
