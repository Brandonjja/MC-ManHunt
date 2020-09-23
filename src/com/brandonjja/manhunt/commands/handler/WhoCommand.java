package com.brandonjja.manhunt.commands.handler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.brandonjja.manhunt.ManHunt;
import com.brandonjja.manhunt.commands.ManHuntCommand;
import com.brandonjja.manhunt.roles.PlayerMH;

public class WhoCommand extends ManHuntCommand {

	@Override
	public boolean execute(Player player, String[] args) {
		PlayerMH mhPlayer;
		String list = "";
		for (Player pl : Bukkit.getOnlinePlayers()) {
			mhPlayer = ManHunt.getPlayer(pl);
			list += pl.getName() + " - " + mhPlayer.getRole() + "\n";
		}
		
		player.sendMessage(list);
		
		return true;
	}
	
}
