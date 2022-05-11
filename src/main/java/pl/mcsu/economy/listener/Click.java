package pl.mcsu.economy.listener;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import pl.mcsu.economy.controller.Organizer;
import pl.mcsu.economy.model.GUI;
import pl.mcsu.economy.service.Items;
import pl.mcsu.economy.utility.Icons;
import pl.mcsu.economy.utility.Types;

import java.util.Objects;

public class Click implements Listener {

    @EventHandler
    public void click(InventoryClickEvent event) {
        Component bank = Component.text()
                .append(Component.text("Bank"))
                .build();
        Component choose = Component.text()
                .append(Component.text("Wybierz"))
                .build();
        Component deposit = Component.text()
                .append(Component.text("Wpłać"))
                .build();
        Component withdraw = Component.text()
                .append(Component.text("Wypłać"))
                .build();
        if (event.getClickedInventory() == null) return;
        if (event.getView().title().equals(bank)
                || event.getView().title().equals(choose)
                || event.getView().title().equals(deposit)
                || event.getView().title().equals(withdraw)) event.setCancelled(true);
        if (Objects.requireNonNull(event.getCurrentItem()).displayName().equals(Icons.background().displayName())) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().title().equals(bank)) {
            if (Objects.equals(Objects.requireNonNull(event.getCurrentItem()).getItemMeta().displayName(),
                    Icons.coins(0).getItemMeta().displayName())) return;
            if (Objects.equals(Objects.requireNonNull(event.getCurrentItem()).getItemMeta().displayName(),
                    Icons.emeralds(0).getItemMeta().displayName()))
                Organizer.getInstance().getUser(player.getUniqueId()).setSelect(Types.Select.EMERALDS);
            if (Objects.equals(Objects.requireNonNull(event.getCurrentItem()).getItemMeta().displayName(),
                    Icons.netherite(0).getItemMeta().displayName()))
                Organizer.getInstance().getUser(player.getUniqueId()).setSelect(Types.Select.NETHERITE);
            if (Objects.equals(Objects.requireNonNull(event.getCurrentItem()).getItemMeta().displayName(),
                    Icons.diamonds(0).getItemMeta().displayName()))
                Organizer.getInstance().getUser(player.getUniqueId()).setSelect(Types.Select.DIAMONDS);
            ItemStack[] icons = new ItemStack[2];
            icons[0] = Icons.deposit();
            icons[1] = Icons.withdraw();
            int[] slots = new int[2];
            slots[0] = 12;
            slots[1] = 14;
            GUI gui = new GUI(choose, icons, slots);
            player.openInventory(gui.getInventory());
            return;
        }
        if (event.getView().title().equals(choose)) {
            if (event.getCurrentItem().displayName().equals(Icons.deposit().displayName())) {
                ItemStack[] icons = new ItemStack[4];
                icons[0] = Icons.number(1);
                icons[1] = Icons.number(16);
                icons[2] = Icons.number(32);
                icons[3] = Icons.number(64);
                int[] slots = new int[4];
                slots[0] = 10;
                slots[1] = 12;
                slots[2] = 14;
                slots[3] = 16;
                GUI gui = new GUI(deposit, icons, slots);
                player.openInventory(gui.getInventory());
                return;
            }
            if (event.getCurrentItem().displayName().equals(Icons.withdraw().displayName())) {
                ItemStack[] icons = new ItemStack[4];
                icons[0] = Icons.number(1);
                icons[1] = Icons.number(16);
                icons[2] = Icons.number(32);
                icons[3] = Icons.number(64);
                int[] slots = new int[4];
                slots[0] = 10;
                slots[1] = 12;
                slots[2] = 14;
                slots[3] = 16;
                GUI gui = new GUI(withdraw, icons, slots);
                player.openInventory(gui.getInventory());
                return;
            }
            return;
        }
        if (event.getView().title().equals(deposit)) {
            if (Objects.equals(event.getCurrentItem().getItemMeta().displayName(),
                    Icons.number(1).getItemMeta().displayName())) {
                Items.getInstance().remove(player, 1);
                return;
            }
            if (Objects.equals(Objects.requireNonNull(event.getCurrentItem()).getItemMeta().displayName(),
                    Icons.number(16).getItemMeta().displayName())) {
                Items.getInstance().remove(player, 16);
                return;
            }
            if (event.getCurrentItem().displayName().contains(Icons.number(32).displayName())) {
                Items.getInstance().remove(player, 32);
                return;
            }
            if (event.getCurrentItem().displayName().contains(Icons.number(64).displayName())) {
                Items.getInstance().remove(player, 64);
                return;
            }
        }
        if (event.getView().title().equals(withdraw)) {
            if (Objects.equals(event.getCurrentItem().getItemMeta().displayName(),
                    Icons.number(1).getItemMeta().displayName())) {
                Items.getInstance().add(player, 1);
                return;
            }
            if (Objects.equals(event.getCurrentItem().getItemMeta().displayName(),
                    Icons.number(16).getItemMeta().displayName())) {
                Items.getInstance().add(player, 16);
                return;
            }
            if (Objects.equals(event.getCurrentItem().getItemMeta().displayName(),
                    Icons.number(32).getItemMeta().displayName())) {
                Items.getInstance().add(player, 32);
                return;
            }
            if (Objects.equals(event.getCurrentItem().getItemMeta().displayName(),
                    Icons.number(64).getItemMeta().displayName())) {
                Items.getInstance().add(player, 64);
            }
        }
    }

}
