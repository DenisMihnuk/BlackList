package fr.blacklistmc.blacklist.commands;

import fr.blacklistmc.blacklist.Blacklist;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;


public class BlacklistCommand implements CommandExecutor {
    private Blacklist main;

    public BlacklistCommand(Blacklist blacklist) {
        this.main = blacklist;

    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.DARK_RED + "Usage: /blacklist <" + Arrays.toString(main.listArgs) + ">");

        } else {
            if (args[0].equalsIgnoreCase("enable")) {
                if (main.getConfig().getBoolean("blacklist.enable", true)) {
                    sender.sendMessage(ChatColor.RED + "Blacklist Off");
                    main.getConfig().set("blacklist.enable", false);
                    main.saveConfig();
                    main.unLoadList();
                } else {
                    main.getConfig().set("blacklist.enable", true);
                    sender.sendMessage(ChatColor.GREEN + "Blacklist On");
                    main.saveConfig();
                    main.loadListe();
                }

                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage(ChatColor.AQUA + "La BlackList a bien été reload");
                main.saveConfig();
                if (main.getConfig().getBoolean("blacklist.enable", true)) {
                    main.loadListe();
                } else {
                    main.unLoadList();
                }
                return true;

            }
        }
            return false;
        }

    }

