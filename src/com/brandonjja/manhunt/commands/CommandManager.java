package com.brandonjja.manhunt.commands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.brandonjja.manhunt.commands.handler.PauseCommand;
import com.brandonjja.manhunt.commands.handler.RoleCommand;
import com.brandonjja.manhunt.commands.handler.SetRoleCommand;
import com.brandonjja.manhunt.commands.handler.WhoCommand;

public class CommandManager implements CommandExecutor {
	
	private static Map<String, ManHuntCommand> commandList = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		return commandList.get(commandLabel).execute((Player) sender, args);
	}
	
	public static void registerCommands() {
		commandList.put("setrole", new SetRoleCommand());
		commandList.put("role", new RoleCommand());
		commandList.put("who", new WhoCommand());
		commandList.put("pause", new PauseCommand());
		commandList.put("p", new PauseCommand());
		
		for (String cmdLabel : commandList.keySet()) {
			register(cmdLabel, new CommandManager());
		}
	}
	
	private static void register(String cmdLabel, CommandExecutor command) {
		Bukkit.getPluginCommand(cmdLabel).setExecutor(command);
	}
}
