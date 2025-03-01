package me.brandonjja.manhunt.listeners.mobs;

import org.bukkit.Material;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class EndermanDeathListener implements Listener {

    // Increase the enderpearl drop rate to 50% to speed up the game
    @EventHandler
    public void onEndermanDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Enderman)) {
            return;
        }

        event.getDrops().removeIf(itemStack -> itemStack.getType() == Material.ENDER_PEARL);

        int chance = ThreadLocalRandom.current().nextInt(100);
        if (chance < 50) {
            event.getDrops().add(new ItemStack(Material.ENDER_PEARL));
        }
    }
}
