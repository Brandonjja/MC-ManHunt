package com.brandonjja.manhunt;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ManHunt extends JavaPlugin {
	
	private static ManHunt plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
	}
	
	@Override
	public void onDisable() {
		plugin = null;
	}
	
	public static Plugin getPlugin() {
		return plugin;
	}
}
