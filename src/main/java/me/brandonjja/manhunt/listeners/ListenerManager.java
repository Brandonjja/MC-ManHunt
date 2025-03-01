package me.brandonjja.manhunt.listeners;

import me.brandonjja.manhunt.ManHunt;
import me.brandonjja.manhunt.commands.handler.PauseCommand;
import me.brandonjja.manhunt.listeners.mobs.EndermanDeathListener;
import me.brandonjja.manhunt.listeners.mobs.MobSpawnListener;
import me.brandonjja.manhunt.listeners.player.PlayerConnectionListener;
import me.brandonjja.manhunt.listeners.player.PlayerDamageListener;
import me.brandonjja.manhunt.listeners.player.PlayerDeathListener;
import me.brandonjja.manhunt.listeners.player.PlayerDropCompassListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class ListenerManager {

    private static boolean alreadyRegistered = false;

    public static void registerListeners() {
        if (alreadyRegistered) {
            return;
        }

        register(new PlayerConnectionListener());
        register(new PlayerDamageListener());
        register(new PlayerDeathListener());
        register(new PlayerDropCompassListener());
        register(new CompassClickListener());
        register(new EndermanDeathListener());
        register(new MobSpawnListener());
        register(new GiveCommandListener());

        register(new PauseCommand());

        alreadyRegistered = true;
    }

    private static void register(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, ManHunt.getPlugin());
    }
}
