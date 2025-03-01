package me.brandonjja.manhunt.listeners.player;

import me.brandonjja.manhunt.ManHunt;
import me.brandonjja.manhunt.roles.PlayerMH;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PlayerMH mhPlayer = ManHunt.addPlayer(player);
        player.sendMessage(ChatColor.GREEN + "You are now a: " + ChatColor.AQUA + mhPlayer.getRole());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        ManHunt.removePlayer(event.getPlayer());
    }
}
