package com.brandonjja.manhunt.listeners.player;

import java.util.Iterator;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import com.brandonjja.manhunt.ManHunt;
import com.brandonjja.manhunt.roles.PlayerMH;
import com.brandonjja.manhunt.roles.Role;

public class PlayerDeathListener implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player player = e.getEntity();
		PlayerMH mhPlayer = ManHunt.getPlayer(player);
		
		if (mhPlayer.getRole() == Role.RUNNER) {
			return;
		}
		
		Iterator<ItemStack> it = e.getDrops().iterator();
		
		while (it.hasNext()) {
			ItemStack stack = it.next();
			if (stack.getType() == Material.COMPASS) {
				e.getDrops().remove(stack);
				break;
			}
		}
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		Player player = e.getPlayer();
		PlayerMH mhPlayer = ManHunt.getPlayer(player);
		
		if (mhPlayer.getRole() != Role.RUNNER) {
			player.getInventory().addItem(new ItemStack(Material.COMPASS));
		}
	}
}
