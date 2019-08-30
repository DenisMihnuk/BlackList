package fr.blacklistmc.blacklist;

import fr.blacklistmc.blacklist.commands.BlacklistCommand;
import fr.blacklistmc.blacklist.listener.BlacklistJoinListener;
import fr.blacklistmc.blacklist.tabcompleter.BlacklisTabCompleter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public final class Blacklist extends JavaPlugin {
    public ArrayList<String> blackListPlayer = new ArrayList<>();
    public final  String[] listArgs = {"enable", "reload"};

    @Override
    public void onEnable() {
        saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();
        getCommand("blacklist").setExecutor(new BlacklistCommand(this));
        getCommand("blacklist").setTabCompleter(new BlacklisTabCompleter(this));
        pm.registerEvents(new BlacklistJoinListener(this), this);
        if (getConfig().getBoolean("blacklist.enable", true)){
            loadListe();

        }else {
            unLoadList();
        }

    }

    @Override
    public void onDisable() {

    }
    public void loadListe(){
        String[] uuidList = getConfig().getStringList("blacklist.UUID").toArray(new String[0]);
        String[] playerNameList = getConfig().getStringList("blacklist.playername").toArray(new String[0]);
        blackListPlayer.addAll(Arrays.asList(uuidList));
        blackListPlayer.addAll(Arrays.asList(playerNameList));

    }
     public void unLoadList(){
        blackListPlayer.clear();
     }
}
