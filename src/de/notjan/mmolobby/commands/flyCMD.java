package de.notjan.mmolobby.commands;

import de.notjan.mmolobby.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("lobby.fly")){
                if(args.length == 0){
                    if(Main.fly.contains(p.getPlayer())){
                        Main.fly.remove(p);
                        p.setAllowFlight(false);
                        p.sendMessage(Main.prefix + "§7Dein §aFlugmodus §7wurde §cdeaktiviert§7!");
                    } else {
                        Main.fly.add(p);
                        p.setAllowFlight(true);
                        p.sendMessage(Main.prefix + "§7Dein §aFlugmodus §7wurde §aaktiviert§7!");
                    }
                }
            }
        }
        return true;
    }
}
