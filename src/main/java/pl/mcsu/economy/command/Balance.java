package pl.mcsu.economy.command;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import pl.mcsu.economy.controller.Organizer;
import pl.mcsu.economy.model.GUI;
import pl.mcsu.economy.utility.Colors;
import pl.mcsu.economy.utility.Icons;

public class Balance extends Command {

    public Balance(@NotNull String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (!player.hasPermission("economy.balance")) {
            Component error = Component.text()
                    .append(Component.text("Nie posiadasz wymaganych uprawnień!", Colors.RED))
                    .build();
            player.sendActionBar(error);
            return false;
        }
        if (args.length > 1) {
            Component error = Component.text()
                    .append(Component.text("Spróbuj /bank [gracz]", Colors.RED))
                    .build();
            player.sendActionBar(error);
            return false;
        }
        switch (args.length) {
            case 0:
                Component title = Component.text()
                        .append(Component.text("Bank"))
                        .build();
                ItemStack[] icons = new ItemStack[4];
                icons[0] = Icons.coins(Organizer.getInstance().getUser(player.getUniqueId()).getCoins());
                icons[1] = Icons.emeralds(Organizer.getInstance().getUser(player.getUniqueId()).getEmeralds());
                icons[2]= Icons.netherite(Organizer.getInstance().getUser(player.getUniqueId()).getNetherite());
                icons[3] = Icons.diamonds(Organizer.getInstance().getUser(player.getUniqueId()).getDiamonds());
                int[] slots = new int[4];
                slots[0] = 10;
                slots[1] = 12;
                slots[2] = 14;
                slots[3] = 16;
                GUI gui = new GUI(title, icons, slots);
                player.openInventory(gui.getInventory());
                return true;
            case 1:
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    Component error = Component.text()
                            .append(Component.text("Gracz jest niedostępny!", Colors.RED))
                            .build();
                    player.sendActionBar(error);
                    return false;
                }
                title = Component.text()
                        .append(Component.text("Bank"))
                        .build();
                icons = new ItemStack[4];
                icons[0] = Icons.coins(Organizer.getInstance().getUser(target.getUniqueId()).getCoins());
                icons[1] = Icons.emeralds(Organizer.getInstance().getUser(target.getUniqueId()).getEmeralds());
                icons[2]= Icons.netherite(Organizer.getInstance().getUser(target.getUniqueId()).getNetherite());
                icons[3] = Icons.diamonds(Organizer.getInstance().getUser(target.getUniqueId()).getDiamonds());
                slots = new int[4];
                slots[0] = 10;
                slots[1] = 12;
                slots[2] = 14;
                slots[3] = 16;
                gui = new GUI(title, icons, slots);
                player.openInventory(gui.getInventory());
                return true;
        }
        return true;
    }

}
