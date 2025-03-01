package me.brandonjja.manhunt.commands.handler;

import me.brandonjja.manhunt.commands.ManHuntCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PauseCommand extends ManHuntCommand implements Listener {

    private static boolean currentlyFrozen = false;

    @Override
    public boolean execute(Player player, String[] args) {
        String alertMessage = ChatColor.BLUE + "The game has been " + (currentlyFrozen ? ChatColor.GREEN : ChatColor.RED) + ChatColor.BOLD + (currentlyFrozen ? "unpaused" : "paused") + ChatColor.BLUE + " by " + player.getName() + ", so you are now " + ChatColor.AQUA + ChatColor.BOLD + (currentlyFrozen ? "unfrozen" : "frozen!");
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.sendMessage(alertMessage);

            for (Entity nearbyEntity : onlinePlayer.getNearbyEntities(40, 40, 40)) {
                if (!(nearbyEntity instanceof LivingEntity)) {
                    continue;
                }

                LivingEntity livingEntity = (LivingEntity) nearbyEntity;
                if (nearbyEntity instanceof Player) {
                    continue;
                }

                if (currentlyFrozen) {
                    if (livingEntity.hasPotionEffect(PotionEffectType.SLOW)) {
                        livingEntity.removePotionEffect(PotionEffectType.SLOW);
                    }
                } else {
                    livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10_000, 20));
                }
            }
        }

        toggleGameRule(player);

        currentlyFrozen = !currentlyFrozen;
        return true;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (currentlyFrozen) {
            event.getPlayer().teleport(event.getFrom());
        }
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (currentlyFrozen && event.getEntity() instanceof Player) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onHungerChange(FoodLevelChangeEvent event) {
        if (currentlyFrozen) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event) {
        if (currentlyFrozen) {
            event.setCancelled(true);
        }
    }

    private void toggleGameRule(Player player) {
        if (currentlyFrozen) {
            player.getWorld().setGameRuleValue("doDaylightCycle", "true");
        } else {
            player.getWorld().setGameRuleValue("doDaylightCycle", "false");
        }
    }
}
