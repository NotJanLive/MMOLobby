package de.notjan.mmolobby.commands;

import de.notjan.mmolobby.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class vanishCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("lobby.vanish")) {
                if(args.length == 0) {
                    if(Main.vanish.contains(p)) {
                        Main.vanish.remove(p);
                        p.sendMessage(Main.prefix + "§7Der §aVanishmodus §7wurde für dich §cdeaktiviert§7.");
                        for(PotionEffect effect : p.getActivePotionEffects()) {
                            p.removePotionEffect(effect.getType());
                        }
                    } else {
                        Main.vanish.add(p);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 2));
                        p.sendMessage(Main.prefix + "§7Der §aVanishmodus §7wurde für dich §aaktiviert§7.");
                    }
                } else if(args.length == 1) {
                    Player t = Bukkit.getPlayer(args[0]);
                    if(t != null) {
                        if(Main.vanish.contains(t)) {
                            Main.vanish.remove(t);
                            for(PotionEffect effect : t.getActivePotionEffects()) {
                                t.removePotionEffect(effect.getType());
                            }
                            t.sendMessage(Main.prefix + "§7Der Spieler §a " + p.getName() + " §7hat dir den §aVanishmodus §cdeaktiviert§7.");
                            p.sendMessage(Main.prefix + "§7Du hast dem Spieler §a" + t.getName() + "§7den §aVanishmodus §cdeaktiviert§7.");
                        } else {
                            Main.vanish.add(t);
                            t.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 2));
                            t.sendMessage(Main.prefix + "§7Der Spieler §a " + p.getName() + " §7hat dir den §aVanishmodus aktiviert§7.");
                            p.sendMessage(Main.prefix + "§7Du hast dem Spieler §a" + t.getName() + "§7den §aVanishmodus aktiviert§7.");
                        }
                    } else
                        p.sendMessage(Main.notfound);
                } else
                    p.sendMessage(Main.prefix + "§7Benutze §8-> §a/vanish §8|| §a/vanish <Spieler>");
            } else
                p.sendMessage(Main.noperms);
        } else
            sender.sendMessage(Main.prefix + "§7Du musst ein Spieler sein.");


        return false;
    }
}
