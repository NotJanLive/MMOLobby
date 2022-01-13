package de.notjan.mmolobby.main;

import de.notjan.mmolobby.commands.buildCMD;
import de.notjan.mmolobby.commands.vanishCMD;
import de.notjan.mmolobby.listener.*;
import de.notjan.mmolobby.utils.ConfigAPI;
import de.notjan.mmolobby.utils.MessageHandler;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import de.notjan.mmolobby.mysql.MySQL;

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
        ConfigAPI.setStandardConfig();

        MessageHandler.loadMessages();

        if(ConfigAPI.getConfigConfiguration().getBoolean("Prefix.Enabled")) {
            Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        }

        if(ConfigAPI.getConfigConfiguration().getBoolean("Chat.Enabled")) {
            Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        }

        MySQL.readMySQL();
        MySQL.connect();
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

    }
    @Override
    public void onDisable() {
        MySQL.close();
        plugin = null;
    }

    public static Main getPlugin() {
        return plugin;
    }

    public void bungeeCommand(Player p, String sn) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream d = new DataOutputStream(b);

        try {
            d.writeUTF("Connect");
            d.writeUTF(sn);
            b.close();
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().severe(ChatColor.RED + "Fehler beim Verbiden zum Server: " + sn);
        }
        p.sendPluginMessage(this, "BungeeCord", b.toByteArray());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String sn, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Nur Spieler können diesen Befehl ausführen!");
            return true;
        }

        Player p = (Player) sender;

        if (sn.equalsIgnoreCase("spawn")) {
            bungeeCommand(p, "Lobby");
        }
        if (sn.equalsIgnoreCase("s")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Bitte bestimme einen Server!");
                return true;
            }
            if (args[0].equalsIgnoreCase("premiumlobby"))
                bungeeCommand(p, "PremiumLobby");
            if (args[0].equalsIgnoreCase("lobby"))
                bungeeCommand(p, "Lobby");
            if(args[0].equalsIgnoreCase( "1v1"))
                bungeeCommand(p, "1v1");
            if(args[0].equalsIgnoreCase("prison"))
                bungeeCommand(p, "Prsion");
            if(args[0].equalsIgnoreCase("earth")){
                bungeeCommand(p, "Earth");
            if(args[0].equalsIgnoreCase("eventserver"))
                bungeeCommand(p, "Eventserver");
            }
        }
        return true;
    }
}