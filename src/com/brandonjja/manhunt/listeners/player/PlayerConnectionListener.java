package com.brandonjja.manhunt.listeners.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.brandonjja.manhunt.ManHunt;

public class PlayerConnectionListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		ManHunt.addPlayer(e.getPlayer());
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		ManHunt.removePlayer(e.getPlayer());
	}
}
