package me.brandonjja.manhunt.commands;

import me.brandonjja.manhunt.commands.handler.PauseCommand;
import me.brandonjja.manhunt.commands.handler.RoleCommand;
import me.brandonjja.manhunt.commands.handler.SetRoleCommand;
import me.brandonjja.manhunt.commands.handler.WhoCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CommandManager implements CommandExecutor {

    private static final Map<String, ManHuntCommand> COMMANDS = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        return COMMANDS.get(commandLabel).execute((Player) sender, args);
    }

    public static void registerCommands() {
        if (!COMMANDS.isEmpty()) {
            return;
        }

        COMMANDS.put("setrole", new SetRoleCommand());
        COMMANDS.put("role", new RoleCommand());
        COMMANDS.put("who", new WhoCommand());
        COMMANDS.put("pause", new PauseCommand());
        COMMANDS.put("p", new PauseCommand());

        for (String cmdLabel : COMMANDS.keySet()) {
            register(cmdLabel, new CommandManager());
        }
    }

    private static void register(String cmdLabel, CommandExecutor command) {
        Bukkit.getPluginCommand(cmdLabel).setExecutor(command);
    }
}
