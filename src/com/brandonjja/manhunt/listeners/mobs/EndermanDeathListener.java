package com.brandonjja.manhunt.listeners.mobs;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Enderman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EndermanDeathListener implements Listener {
	
	@EventHandler
	public void onEndermanDeath(EntityDeathEvent e) {
		if (e.getEntity() instanceof Enderman) {
			if (e.getDrops().contains(new ItemStack(Material.ENDER_PEARL))) {
				e.getDrops().clear();
			}
			
			Random rand = new Random();
			int num = rand.nextInt(10);
			if (num < 5) {
				e.getDrops().add(new ItemStack(Material.ENDER_PEARL));
			}
			
		}
	}
}
