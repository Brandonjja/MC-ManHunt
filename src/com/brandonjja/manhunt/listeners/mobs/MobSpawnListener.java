package com.brandonjja.manhunt.listeners.mobs;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MobSpawnListener implements Listener {
	
	@EventHandler
	public void onMobSpawn(EntitySpawnEvent e) {
		if (e.getEntity() instanceof Zombie) {
			Random rand = new Random();
			int num = rand.nextInt(100);
			if (num < 5) {
				e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ENDERMAN);
			}
		}
	}
}
