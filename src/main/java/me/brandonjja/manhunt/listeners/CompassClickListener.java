package me.brandonjja.manhunt.listeners;

import me.brandonjja.manhunt.ManHunt;
import me.brandonjja.manhunt.roles.PlayerMH;
import me.brandonjja.manhunt.roles.Role;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class CompassClickListener implements Listener {

    @EventHandler
    public void onTrackPlayer(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getItemInHand().getType() != Material.COMPASS) {
            return;
        }

        Player target = getClosestPlayer(player);
        if (target != null) {
            Location targetLocation = target.getLocation();
            player.setCompassTarget(targetLocation);
            player.sendMessage(ChatColor.GREEN + "Currently Tracking: " + ChatColor.AQUA + target.getName());
            return;
        }

        player.sendMessage(ChatColor.RED + "No players found!");
    }

    private Player getClosestPlayer(Player tracker) {
        double minDistanceFound = Double.POSITIVE_INFINITY;
        Player target = null;
        Location trackerLocation = tracker.getLocation();

        for (Player potentialTargetPlayer : Bukkit.getOnlinePlayers()) {
            if (potentialTargetPlayer.equals(tracker)) {
                continue;
            }

            PlayerMH mhPlayer = ManHunt.getPlayer(potentialTargetPlayer);
            if (mhPlayer.getRole() != Role.RUNNER) {
                continue;
            }

            double distanceTo;
            try {
                distanceTo = trackerLocation.distanceSquared(potentialTargetPlayer.getLocation());
            } catch (IllegalArgumentException ex) {
                distanceTo = Double.POSITIVE_INFINITY;
            }

            if (distanceTo > minDistanceFound) {
                continue;
            }

            minDistanceFound = distanceTo;
            target = potentialTargetPlayer;
        }

        return (target == null || minDistanceFound == Double.POSITIVE_INFINITY) ? null : target;
    }
}
