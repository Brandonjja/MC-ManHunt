package me.brandonjja.manhunt.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

public class GiveCommandListener implements Listener {

    @EventHandler
    public void onGiveCompass(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage();
        if (!command.startsWith("/give ")) {
            return;
        }

        String[] args = command.split(" ");
        if (args.length < 3 || !args[2].contains("compass")) {
            return;
        }

        Player player = event.getPlayer();
        if (args.length == 3) {
            event.setCancelled(true);
            player.getInventory().addItem(new ItemStack(Material.COMPASS));
            player.sendMessage("Given [Compass] * 1 to " + player.getName());

        } else if (args.length == 4) {
            int amountToGive;
            try {
                amountToGive = Integer.parseInt(args[3]);
            } catch (NumberFormatException ex) {
                return;
            }

            event.setCancelled(true);
            player.getInventory().addItem(new ItemStack(Material.COMPASS, amountToGive));
            player.sendMessage("Given [Compass] * " + amountToGive + " to " + player.getName());
        }
    }
}
