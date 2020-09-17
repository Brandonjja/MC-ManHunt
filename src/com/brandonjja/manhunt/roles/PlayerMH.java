package com.brandonjja.manhunt.roles;

import org.bukkit.entity.Player;

public class PlayerMH {
	Player player;
	Role role;
	
	public PlayerMH(Player player, Role role) {
		this.player = player;
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
}
