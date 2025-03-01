package me.brandonjja.manhunt.listeners.player;

import me.brandonjja.manhunt.ManHunt;
import me.brandonjja.manhunt.roles.PlayerMH;
import me.brandonjja.manhunt.roles.Role;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        PlayerMH mhPlayer = ManHunt.getPlayer(player);
        if (mhPlayer.getRole() == Role.RUNNER) {
            return;
        }

        event.getDrops().removeIf(itemDrop -> itemDrop.getType() == Material.COMPASS);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        PlayerMH mhPlayer = ManHunt.getPlayer(player);
        if (mhPlayer.getRole() == Role.RUNNER) {
            return;
        }

        player.getInventory().addItem(new ItemStack(Material.COMPASS));
    }
}
