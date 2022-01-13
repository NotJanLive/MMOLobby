package de.notjan.mmolobby.utils;

import de.notjan.mmolobby.mysql.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ClanManager {

	public static boolean isPlayerInClan(UUID uuid) {
		try {
			PreparedStatement preparedStatement = MySQL.connection
					.prepareStatement("SELECT UUID FROM Clans WHERE UUID = ?");
			preparedStatement.setString(1, uuid.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	public static String getClanTag(UUID uuid) {
		int clanID = getClanID(uuid).intValue();
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT ClanTag FROM Clans WHERE ClanID = ?");
			ps.setInt(1, clanID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("Clantag");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "null";
	}

	public static Integer getClanID(UUID uuid) {
		try {
			PreparedStatement preparedStatement = MySQL.connection
					.prepareStatement("SELECT ClanID FROM Clans WHERE UUID = ?");
			preparedStatement.setString(1, uuid.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return Integer.valueOf(resultSet.getInt("ClanID"));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return Integer.valueOf(-1);
	}

}
