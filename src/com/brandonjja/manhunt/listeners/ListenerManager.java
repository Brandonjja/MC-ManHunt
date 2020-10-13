package com.brandonjja.manhunt.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import com.brandonjja.manhunt.ManHunt;
import com.brandonjja.manhunt.commands.handler.PauseCommand;
import com.brandonjja.manhunt.listeners.mobs.EndermanDeathListener;
import com.brandonjja.manhunt.listeners.mobs.MobSpawnListener;
import com.brandonjja.manhunt.listeners.player.PlayerConnectionListener;
import com.brandonjja.manhunt.listeners.player.PlayerDamageListener;
import com.brandonjja.manhunt.listeners.player.PlayerDeathListener;
import com.brandonjja.manhunt.listeners.player.PlayerDropCompassListener;

public class ListenerManager {
	public static void registerListeners() {
		register(new PlayerConnectionListener());
		register(new PlayerDamageListener());
		register(new PlayerDeathListener());
		register(new PlayerDropCompassListener());
		register(new CompassClickListener());
		register(new EndermanDeathListener());
		register(new MobSpawnListener());
		register(new GiveCommandListener());
		
		register(new PauseCommand());
	}
	
	private static void register(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, ManHunt.getPlugin());
	}
}
