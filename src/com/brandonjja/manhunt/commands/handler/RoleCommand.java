package com.brandonjja.manhunt.commands.handler;

import org.bukkit.entity.Player;

import com.brandonjja.manhunt.ManHunt;
import com.brandonjja.manhunt.commands.ManHuntCommand;
import com.brandonjja.manhunt.roles.PlayerMH;

import net.md_5.bungee.api.ChatColor;

public class RoleCommand extends ManHuntCommand {

	@Override
	public boolean execute(Player player, String[] args) {
		PlayerMH mhPlayer = ManHunt.getPlayer(player);
		player.sendMessage(ChatColor.GREEN + "You are currently a(n): " + ChatColor.AQUA + mhPlayer.getRole());
		return true;
	}
	
}
