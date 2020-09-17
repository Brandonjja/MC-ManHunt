package com.brandonjja.manhunt.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import com.brandonjja.manhunt.ManHunt;
import com.brandonjja.manhunt.listeners.player.PlayerConnectionListener;

public class ListenerManager {
	public static void registerListeners() {
		register(new PlayerConnectionListener());
	}
	
	private static void register(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, ManHunt.getPlugin());
	}
}
