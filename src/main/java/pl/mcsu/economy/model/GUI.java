package pl.mcsu.economy.model;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.mcsu.economy.utility.Icons;

public class GUI {

    private final Component title;
    private final Inventory inventory;
    private final ItemStack[] icons;
    private final int[] slots;

    public GUI(Component title, ItemStack[] icons, int[] slots) {
        this.title = title;
        this.inventory = Bukkit.createInventory(null, InventoryType.CHEST, title);
        this.icons = icons;
        this.slots = slots;
    }

    public Component getTitle() {
        return title;
    }

    public Inventory getInventory() {
        for (int i = 0; i < 27; i++) inventory.setItem(i, Icons.background());
        for (int i = 0; i < icons.length; i++) inventory.setItem(slots[i], icons[i]);
        return inventory;
    }

    public ItemStack[] getIcons() {
        return icons;
    }

    public int[] getSlots() {
        return slots;
    }

}
