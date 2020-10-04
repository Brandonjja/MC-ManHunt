package com.brandonjja.manhunt.listeners.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.brandonjja.manhunt.ManHunt;
import com.brandonjja.manhunt.roles.PlayerMH;
import com.brandonjja.manhunt.roles.Role;

public class PlayerDamageListener implements Listener {

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			PlayerMH assassin = (PlayerMH) ManHunt.getPlayer((Player) e.getDamager());
			PlayerMH runner = (PlayerMH) ManHunt.getPlayer((Player) e.getEntity());

			if (assassin.getRole() == Role.ASSASSIN && runner.getRole() == Role.RUNNER) {
				ItemStack item = assassin.getPlayer().getItemInHand();
				short dur = item.getDurability();
				if (item.isSimilar(getItem(Material.WOOD_SWORD, dur))
						|| item.isSimilar(getItem(Material.STONE_SWORD, dur))
						|| item.isSimilar(getItem(Material.GOLD_SWORD, dur))
						|| item.isSimilar(getItem(Material.IRON_SWORD, dur))
						|| item.isSimilar(getItem(Material.DIAMOND_SWORD, dur))) {
					e.setDamage(100);
				}
			}
		}
	}
	
	private ItemStack getItem(Material m, short dur) {
		ItemStack item = new ItemStack(m);
		item.setDurability(dur);
		return item;
	}
}
