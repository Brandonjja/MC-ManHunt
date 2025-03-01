package me.brandonjja.manhunt.listeners.player;

import me.brandonjja.manhunt.ManHunt;
import me.brandonjja.manhunt.roles.PlayerMH;
import me.brandonjja.manhunt.roles.Role;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDamageListener implements Listener {

    @EventHandler
    public void onPlayerDamagePlayer(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        if (!(damager instanceof Player)) {
            return;
        }

        Entity victim = event.getEntity();
        if (!(victim instanceof Player)) {
            return;
        }

        PlayerMH assassin = ManHunt.getPlayer((Player) damager);
        if (assassin.getRole() != Role.ASSASSIN) {
            return;
        }

        PlayerMH runner = ManHunt.getPlayer((Player) victim);
        if (runner.getRole() != Role.RUNNER) {
            return;
        }

        ItemStack itemInHand = ((Player) damager).getItemInHand();
        if (!itemInHand.getType().name().endsWith("_SWORD")) {
            return;
        }

        event.setDamage(100);
    }
}
