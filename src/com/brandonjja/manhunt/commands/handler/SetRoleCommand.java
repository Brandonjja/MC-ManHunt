package com.brandonjja.manhunt.commands.handler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.brandonjja.manhunt.ManHunt;
import com.brandonjja.manhunt.commands.ManHuntCommand;
import com.brandonjja.manhunt.roles.PlayerMH;
import com.brandonjja.manhunt.roles.Role;

public class SetRoleCommand extends ManHuntCommand {

	@Override
	public boolean execute(Player player, String[] args) {
		if (args.length == 1) {
			PlayerMH mhPlayer = ManHunt.getPlayer(player);
			switch (args[0].toLowerCase()) {
			case "hunter":
				mhPlayer.setRole(Role.HUNTER);
				player.sendMessage(ChatColor.GREEN + "You are now a: " + ChatColor.AQUA + mhPlayer.getRole());
				break;
			case "runner":
				mhPlayer.setRole(Role.RUNNER);
				player.sendMessage(ChatColor.GREEN + "You are now a: " + ChatColor.AQUA + mhPlayer.getRole());
				break;
			case "assassin":
				mhPlayer.setRole(Role.ASSASSIN);
				player.sendMessage(ChatColor.GREEN + "You are now an: " + ChatColor.AQUA + mhPlayer.getRole());
				break;
			default:
				player.sendMessage(ChatColor.RED + "Valid Roles: Hunter, Runner, Assassin");
				break;
			}
			return true;
		}
		player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/setrole <roleName>");
		player.sendMessage(ChatColor.RED + "Valid Roles: Hunter, Runner, Assassin");
		return true;
	}
}
