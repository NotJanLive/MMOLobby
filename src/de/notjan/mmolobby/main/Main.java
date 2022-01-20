package de.notjan.mmolobby.main;

import de.notjan.mmolobby.commands.buildCMD;
import de.notjan.mmolobby.commands.flyCMD;
import de.notjan.mmolobby.commands.vanishCMD;
import de.notjan.mmolobby.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    public static Main plugin;
    public static List<Player> build = new ArrayList<>();
    public static List<Player> fly = new ArrayList<>();
    public static List<Player> vanish = new ArrayList<>();
    public static String prefix = "§8➤ §b§lLobby §8➥ ";
    public static String noperms = prefix + "§cDazu hast du keine Rechte.";
    public static String notfound = prefix + "§cDieser Spieler wurde nicht gefunden.";

    @Override
    public void onEnable() {
        plugin = this;

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getConsoleSender().sendMessage(prefix + "§7Das Lobbyplugin wurde erfolgreich gestartet");

        //LISTENER
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProtectionListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerCommandPreprocessEventListener(), this);
        //COMMANDS
        getCommand("build").setExecutor(new buildCMD());
        getCommand("b").setExecutor(new buildCMD());
        getCommand("vanish").setExecutor(new vanishCMD());
        getCommand("v").setExecutor(new vanishCMD());
        getCommand("f").setExecutor(new flyCMD());
        getCommand("fly").setExecutor(new flyCMD());

    }
    public static Main getPlugin() {
        return plugin;
    }

}