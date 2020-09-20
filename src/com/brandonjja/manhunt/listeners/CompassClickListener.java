package com.brandonjja.manhunt.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.brandonjja.manhunt.ManHunt;
import com.brandonjja.manhunt.roles.PlayerMH;
import com.brandonjja.manhunt.roles.Role;

public class CompassClickListener implements Listener {
	
	private Player track(Player p) {
		double dis = Double.POSITIVE_INFINITY;
		Player target = null;
		
		for (Player pl : Bukkit.getOnlinePlayers()) {
			PlayerMH mhPlayer = ManHunt.getPlayer(pl);
			if (pl.equals(p) || mhPlayer.getRole() != Role.RUNNER) {
				continue;
			}
			double distanceTo = p.getLocation().distance(pl.getLocation());
			if (distanceTo > dis) {
				continue;
			}
			dis = distanceTo;
			target = pl;
		}
		if (target == null) {
			return null;
		} else {
			return target;
		}
	}

	@EventHandler
	public void onTrack(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if (player.getItemInHand().getType() == Material.COMPASS) {
			Player target = track(player);
			if (target != null) {
				Location loc = target.getLocation();
				player.setCompassTarget(loc);
				player.sendMessage(ChatColor.GREEN + "Currently Tracking: " + ChatColor.AQUA + target.getName());
			} else {
				Location loc = new Location(player.getWorld(), 0, 0, 0);
				player.setCompassTarget(loc);
				player.sendMessage(ChatColor.RED + "No players found!");
			}
		}
	}
}
