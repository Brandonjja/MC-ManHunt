package com.brandonjja.manhunt.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

public class GiveCommandListener implements Listener {
	
	@EventHandler
	public void onGiveCompass(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().startsWith("/give ")) {
			String args[] = e.getMessage().split(" ");
			Player player = e.getPlayer();
			if (args.length == 3) {
				if (args[2].contains("compass")) {
					e.setCancelled(true);
					player.getInventory().addItem(new ItemStack(Material.COMPASS));
					player.sendMessage("Given [Compass] * 1 to " + player.getName());
				}
			} else if (args.length == 4) {
				if (args[2].contains("compass")) {
					int items;
					try {
						items = Integer.parseInt(args[3]);
					} catch (NumberFormatException ex) {
						return;
					}
					e.setCancelled(true);
					player.getInventory().addItem(new ItemStack(Material.COMPASS, items));
					player.sendMessage("Given [Compass] * " + items + " to " + player.getName());
				}
			}
		}
	}
}
