package fr.blacklistmc.blacklist.listener;

import fr.blacklistmc.blacklist.Blacklist;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;


public class BlacklistJoinListener implements Listener {
    private Blacklist main;

    public BlacklistJoinListener(Blacklist blacklist) {
        this.main = blacklist;
    }



    @EventHandler
    public void onPreJoin(AsyncPlayerPreLoginEvent event){
        String uuid = event.getUniqueId().toString();
        String player = event.getName();
        if (main.blackListPlayer.contains(uuid) || main.blackListPlayer.contains(player)){
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("blacklist.kickmessage")));
        }


    }

}
