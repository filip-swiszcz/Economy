package pl.mcsu.economy.utility;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Icons {

    public static ItemStack background() {
        ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Component name = Component.text()
                .append(Component.text("MCSU.PL", Colors.LIGHT_YELLOW))
                .decoration(TextDecoration.ITALIC, false)
                .decoration(TextDecoration.BOLD, true)
                .build();
        itemMeta.displayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack coins(int amount) {
        ItemStack itemStack = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Component name = Component.text()
                .append(Component.text("Monety", Colors.YELLOW))
                .decoration(TextDecoration.ITALIC, false)
                .build();
        Component number = Component.text()
                .append(Component.text("x", Colors.LIGHT_YELLOW))
                .decoration(TextDecoration.ITALIC, false)
                .append(Component.text(String.valueOf(amount), Colors.LIGHT_GRAY))
                .decoration(TextDecoration.ITALIC, false)
                .build();
        List<Component> lore = List.of(number);
        itemMeta.displayName(name);
        itemMeta.lore(lore);
        itemMeta.addEnchant(Enchantment.LUCK, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack emeralds(int amount) {
        ItemStack itemStack = new ItemStack(Material.EMERALD);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Component name = Component.text()
                .append(Component.text("Emeraldy", Colors.YELLOW))
                .decoration(TextDecoration.ITALIC, false)
                .build();
        Component number = Component.text()
                .append(Component.text("x", Colors.LIGHT_YELLOW))
                .decoration(TextDecoration.ITALIC, false)
                .append(Component.text(String.valueOf(amount), Colors.LIGHT_GRAY))
                .decoration(TextDecoration.ITALIC, false)
                .build();
        List<Component> lore = List.of(number);
        itemMeta.displayName(name);
        itemMeta.lore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack netherite(int amount) {
        ItemStack itemStack = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Component name = Component.text()
                .append(Component.text("Netheryt", Colors.YELLOW))
                .decoration(TextDecoration.ITALIC, false)
                .build();
        Component number = Component.text()
                .append(Component.text("x", Colors.LIGHT_YELLOW))
                .decoration(TextDecoration.ITALIC, false)
                .append(Component.text(String.valueOf(amount), Colors.LIGHT_GRAY))
                .decoration(TextDecoration.ITALIC, false)
                .build();
        List<Component> lore = List.of(number);
        itemMeta.displayName(name);
        itemMeta.lore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack diamonds(int amount) {
        ItemStack itemStack = new ItemStack(Material.DIAMOND);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Component name = Component.text()
                .append(Component.text("Diamenty", Colors.YELLOW))
                .decoration(TextDecoration.ITALIC, false)
                .build();
        Component number = Component.text()
                .append(Component.text("x", Colors.LIGHT_YELLOW))
                .decoration(TextDecoration.ITALIC, false)
                .append(Component.text(String.valueOf(amount), Colors.LIGHT_GRAY))
                .decoration(TextDecoration.ITALIC, false)
                .build();
        List<Component> lore = List.of(number);
        itemMeta.displayName(name);
        itemMeta.lore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack deposit() {
        ItemStack itemStack = new ItemStack(Material.LIME_CONCRETE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Component name = Component.text()
                .append(Component.text("Wpłać"))
                .decoration(TextDecoration.ITALIC, false)
                .build();
        itemMeta.displayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack withdraw() {
        ItemStack itemStack = new ItemStack(Material.RED_CONCRETE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Component name = Component.text()
                .append(Component.text("Wypłać"))
                .decoration(TextDecoration.ITALIC, false)
                .build();
        itemMeta.displayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack number(int amount) {
        ItemStack itemStack = new ItemStack(Material.PAPER, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Component name = Component.text()
                .append(Component.text(String.valueOf(amount)))
                .decoration(TextDecoration.ITALIC, false)
                .build();
        itemMeta.displayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
