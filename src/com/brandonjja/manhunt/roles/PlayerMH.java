package com.brandonjja.manhunt.roles;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerMH {
	Player player;
	Role role;
	
	public PlayerMH(Player player, Role role) {
		this.player = player;
		this.setRole(role);
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
		if (role.equals(Role.RUNNER)) {
			removeCompass(player);
		} else {
			giveCompass(player);
		}
	}
	
	
	private void giveCompass(Player player) {
		if (!player.getInventory().contains(Material.COMPASS)) {
			player.getInventory().addItem(new ItemStack(Material.COMPASS));
		}
	}
	
	private void removeCompass(Player player) {
		player.getInventory().remove(Material.COMPASS);
	}
}
