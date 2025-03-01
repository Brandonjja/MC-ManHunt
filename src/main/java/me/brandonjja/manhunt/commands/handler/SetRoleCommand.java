package me.brandonjja.manhunt.commands.handler;

import me.brandonjja.manhunt.ManHunt;
import me.brandonjja.manhunt.commands.ManHuntCommand;
import me.brandonjja.manhunt.roles.PlayerMH;
import me.brandonjja.manhunt.roles.Role;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SetRoleCommand extends ManHuntCommand {

    @Override
    public boolean execute(Player player, String[] args) {
        if (args.length == 1) {
            PlayerMH mhPlayer = ManHunt.getPlayer(player);
            try {
                Role role = Role.valueOf(args[0].toUpperCase());
                mhPlayer.setRole(role);
                player.sendMessage(ChatColor.GREEN + "You are now " + (role == Role.ASSASSIN ? "an" : "a") + ": " + ChatColor.AQUA + mhPlayer.getRole());
                return true;
            } catch (IllegalArgumentException ignored) {
            }
        }

        player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/setrole <roleName>");
        player.sendMessage(ChatColor.RED + "Valid Roles: Hunter, Runner, Assassin");
        return true;
    }
}
