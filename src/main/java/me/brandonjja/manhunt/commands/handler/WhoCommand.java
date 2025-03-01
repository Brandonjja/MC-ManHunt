package me.brandonjja.manhunt.commands.handler;

import me.brandonjja.manhunt.ManHunt;
import me.brandonjja.manhunt.commands.ManHuntCommand;
import me.brandonjja.manhunt.roles.PlayerMH;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class WhoCommand extends ManHuntCommand {

    @Override
    public boolean execute(Player player, String[] args) {
        PlayerMH mhPlayer;
        StringBuilder playerList = new StringBuilder(ChatColor.GOLD + "------ Players: ------\n");
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            mhPlayer = ManHunt.getPlayer(onlinePlayer);

            playerList.append(ChatColor.GREEN)
                    .append(onlinePlayer.getName())
                    .append(ChatColor.WHITE)
                    .append(" - ")
                    .append(ChatColor.AQUA)
                    .append(mhPlayer.getRole())
                    .append("\n");
        }

        playerList.append(ChatColor.GOLD).append("--------------------");
        player.sendMessage(playerList.toString());
        return true;
    }
}
