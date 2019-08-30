package fr.blacklistmc.blacklist.tabcompleter;

import fr.blacklistmc.blacklist.Blacklist;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class BlacklisTabCompleter implements TabCompleter {
    private Blacklist main;
    public BlacklisTabCompleter(Blacklist blacklist) {
        this.main = blacklist;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Arrays.asList(main.listArgs);
    }
}
