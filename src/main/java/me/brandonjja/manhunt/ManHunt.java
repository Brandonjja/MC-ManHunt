package me.brandonjja.manhunt;

import me.brandonjja.manhunt.commands.CommandManager;
import me.brandonjja.manhunt.listeners.ListenerManager;
import me.brandonjja.manhunt.roles.PlayerMH;
import me.brandonjja.manhunt.roles.Role;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ManHunt extends JavaPlugin {

    private static final Map<UUID, PlayerMH> PLAYERS = new HashMap<>();

    private static ManHunt plugin;

    public static Plugin getPlugin() {
        return plugin;
    }

    public static PlayerMH addPlayer(Player player) {
        PlayerMH mhPlayer = PlayerMH.create(player, Role.HUNTER);
        PLAYERS.putIfAbsent(player.getUniqueId(), mhPlayer);
        return mhPlayer;
    }

    public static void removePlayer(Player player) {
        PLAYERS.remove(player.getUniqueId());
    }

    public static PlayerMH getPlayer(Player player) {
        return PLAYERS.get(player.getUniqueId());
    }

    @Override
    public void onEnable() {
        plugin = this;
        PLAYERS.clear();

        CommandManager.registerCommands();
        ListenerManager.registerListeners();

        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerMH mhPlayer = PlayerMH.create(player, Role.HUNTER);
            PLAYERS.put(player.getUniqueId(), mhPlayer);
        }
    }

    @Override
    public void onDisable() {
        plugin = null;
        PLAYERS.clear();
    }
}
