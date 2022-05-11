package pl.mcsu.economy.listener;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import pl.mcsu.economy.controller.Organizer;
import pl.mcsu.economy.model.GUI;
import pl.mcsu.economy.utility.Icons;

import java.util.Objects;

public class Interact implements Listener {

    @EventHandler
    public void interact(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Villager villager)) return;
        Component name = Component.text()
                .append(Component.text("Bankier"))
                .build();
        if (!Objects.equals(villager.customName(), name)) return;
        event.setCancelled(true);
        Component title = Component.text()
                .append(Component.text("Bank"))
                .build();
        ItemStack[] icons = new ItemStack[4];
        icons[0] = Icons.coins(Organizer.getInstance().getUser(event.getPlayer().getUniqueId()).getCoins());
        icons[1] = Icons.emeralds(Organizer.getInstance().getUser(event.getPlayer().getUniqueId()).getEmeralds());
        icons[2]= Icons.netherite(Organizer.getInstance().getUser(event.getPlayer().getUniqueId()).getNetherite());
        icons[3] = Icons.diamonds(Organizer.getInstance().getUser(event.getPlayer().getUniqueId()).getDiamonds());
        int[] slots = new int[4];
        slots[0] = 10;
        slots[1] = 12;
        slots[2] = 14;
        slots[3] = 16;
        GUI gui = new GUI(title, icons, slots);
        event.getPlayer().openInventory(gui.getInventory());
    }

}
