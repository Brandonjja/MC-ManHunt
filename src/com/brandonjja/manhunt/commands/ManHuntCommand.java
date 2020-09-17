package com.brandonjja.manhunt.commands;

import org.bukkit.entity.Player;

public abstract class ManHuntCommand {
	public abstract boolean execute(Player player, String args[]);
}
