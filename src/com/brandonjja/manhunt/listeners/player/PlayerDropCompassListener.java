package com.brandonjja.manhunt.listeners.player;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropCompassListener implements Listener {
	
	@EventHandler
	public void onDropCompass(PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getType() == Material.COMPASS) {
			e.setCancelled(true);
		}
	}
}
