package me.brandonjja.manhunt.roles;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class PlayerMH {

    private final UUID uuid;

    private Role role;

    public static PlayerMH create(Player player, Role role) {
        PlayerMH mhPlayer = new PlayerMH(player);
        mhPlayer.setRole(role);
        return mhPlayer;
    }

    private PlayerMH(Player player) {
        this.uuid = player.getUniqueId();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) {
            return;
        }

        if (role.equals(Role.RUNNER)) {
            removeCompass(player);
        } else {
            giveCompass(player);
        }
    }

    private void giveCompass(Player player) {
        if (!player.getInventory().contains(Material.COMPASS)) {
            player.getInventory().addItem(new ItemStack(Material.COMPASS));
        }
    }

    private void removeCompass(Player player) {
        player.getInventory().remove(Material.COMPASS);
    }
}
