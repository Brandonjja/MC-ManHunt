package me.brandonjja.manhunt.commands.handler;

import me.brandonjja.manhunt.ManHunt;
import me.brandonjja.manhunt.commands.ManHuntCommand;
import me.brandonjja.manhunt.roles.PlayerMH;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class RoleCommand extends ManHuntCommand {

    @Override
    public boolean execute(Player player, String[] args) {
        PlayerMH mhPlayer = ManHunt.getPlayer(player);
        player.sendMessage(ChatColor.GREEN + "You are currently a(n): " + ChatColor.AQUA + mhPlayer.getRole());
        return true;
    }

}
