package pl.mcsu.economy.service;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.mcsu.economy.controller.Organizer;
import pl.mcsu.economy.utility.Types;

import java.util.HashMap;

public class Items {

    private static Items instance = new Items();

    public Items() {
        instance = this;
    }

    public static Items getInstance() {
        return instance;
    }

    /*
     *
     *   Items class
     *
     * */

    public void add(Player player, int amount) {
        switch (Organizer.getInstance().getUser(player.getUniqueId()).getSelect()) {
            case EMERALDS -> {
                if (Organizer.getInstance().getUser(player.getUniqueId()).getEmeralds() < amount) return;
                HashMap<Integer, ItemStack> items = player.getInventory().addItem(new ItemStack(Material.EMERALD, amount));
                if (!items.isEmpty()) return;
                Assets.getInstance().remove(player, Types.Asset.EMERALDS, amount);
            }
            case NETHERITE -> {
                if (Organizer.getInstance().getUser(player.getUniqueId()).getNetherite() < amount) return;
                HashMap<Integer, ItemStack> items = player.getInventory().addItem(new ItemStack(Material.NETHERITE_INGOT, amount));
                if (!items.isEmpty()) return;
                Assets.getInstance().remove(player, Types.Asset.NETHERITE, amount);
            }
            case DIAMONDS -> {
                if (Organizer.getInstance().getUser(player.getUniqueId()).getDiamonds() < amount) return;
                HashMap<Integer, ItemStack> items = player.getInventory().addItem(new ItemStack(Material.DIAMOND, amount));
                if (!items.isEmpty()) return;
                Assets.getInstance().remove(player, Types.Asset.DIAMONDS, amount);
            }
        }
    }

    public void remove(Player player, int amount) {
        switch (Organizer.getInstance().getUser(player.getUniqueId()).getSelect()) {
            case EMERALDS -> {
                if (!player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), amount)) return;
                HashMap<Integer, ItemStack> items = player.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, amount));
                if (!items.isEmpty()) return;
                Assets.getInstance().add(player, Types.Asset.EMERALDS, amount);
            }
            case NETHERITE -> {
                if (!player.getInventory().containsAtLeast(new ItemStack(Material.NETHERITE_INGOT), amount)) return;
                HashMap<Integer, ItemStack> items = player.getInventory().removeItemAnySlot(new ItemStack(Material.NETHERITE_INGOT, amount));
                if (!items.isEmpty()) return;
                Assets.getInstance().add(player, Types.Asset.NETHERITE, amount);
            }
            case DIAMONDS -> {
                if (!player.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), amount)) return;
                HashMap<Integer, ItemStack> items = player.getInventory().removeItemAnySlot(new ItemStack(Material.DIAMOND, amount));
                if (!items.isEmpty()) return;
                Assets.getInstance().add(player, Types.Asset.DIAMONDS, amount);
            }
        }
    }

}
