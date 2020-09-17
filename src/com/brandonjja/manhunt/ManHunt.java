package com.brandonjja.manhunt;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.brandonjja.manhunt.commands.CommandManager;
import com.brandonjja.manhunt.listeners.ListenerManager;
import com.brandonjja.manhunt.roles.PlayerMH;
import com.brandonjja.manhunt.roles.Role;

public class ManHunt extends JavaPlugin {
	
	private static ManHunt plugin;
	private static Map<String, PlayerMH> players;
	
	@Override
	public void onEnable() {
		plugin = this;
		players = new HashMap<>();
		
		CommandManager.registerCommands();
		ListenerManager.registerListeners();
		
		for (Player pl : Bukkit.getOnlinePlayers()) {
			PlayerMH mhPlayer = new PlayerMH(pl, Role.HUNTER);
			players.put(pl.getName(), mhPlayer);
		}
		
	}
	
	@Override
	public void onDisable() {
		plugin = null;
		
		players.clear();
		players = null;
	}
	
	public static Plugin getPlugin() {
		return plugin;
	}
	
	public static void addPlayer(Player player) {
		players.put(player.getName(), new PlayerMH(player, Role.HUNTER));
	}
	
	public static void removePlayer(Player player) {
		if (players.keySet().contains(player.getName())) {
			players.remove(player.getName());
		}
	}
	
	public static PlayerMH getPlayer(Player player) {
		if (players.keySet().contains(player.getName())) {
			return players.get(player.getName());
		}
		return null;
	}
}
