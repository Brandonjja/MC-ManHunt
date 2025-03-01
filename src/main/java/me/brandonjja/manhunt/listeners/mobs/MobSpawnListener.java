package me.brandonjja.manhunt.listeners.mobs;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.concurrent.ThreadLocalRandom;

public class MobSpawnListener implements Listener {

    // Increase the spawn rate of endermen, based on the current spawn rate of zombies
    @EventHandler
    public void onZombieSpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Zombie)) {
            return;
        }

        // 5% chance of an extra enderman spawning every time a zombie spawns
        int chance = ThreadLocalRandom.current().nextInt(100);
        if (chance < 5) {
            entity.getWorld().spawnEntity(entity.getLocation(), EntityType.ENDERMAN);
        }
    }
}
