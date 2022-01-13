package de.notjan.mmolobby.main;

import de.notjan.mmolobby.commands.buildCMD;
import de.notjan.mmolobby.commands.vanishCMD;
import de.notjan.mmolobby.listener.*;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.DataOutputStream;
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
        Bukkit.getPluginManager().registerEvents(new SneakListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProtectionListener(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new GadgetListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerCommandPreprocessEventListener(), this);
        Bukkit.getPluginManager().registerEvents(new CosmeticsListener(), this);
        //COMMANDS
        getCommand("build").setExecutor(new buildCMD());
        getCommand("vanish").setExecutor(new vanishCMD());
        getCommand("v").setExecutor(new vanishCMD());

        loadconfig();
    }


    private void loadconfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public static Main getPlugin() {
        return plugin;
    }
}
