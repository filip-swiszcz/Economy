package pl.mcsu.economy.command;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.jetbrains.annotations.NotNull;
import pl.mcsu.economy.model.Settler;
import pl.mcsu.economy.utility.Colors;

public class Set extends Command {

    public Set(@NotNull String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (!player.hasPermission("economy.set")) {
            Component error = Component.text()
                    .append(Component.text("Nie posiadasz wymaganych uprawnień!", Colors.RED))
                    .build();
            player.sendActionBar(error);
            return false;
        }
        if (args.length > 0) {
            Component error = Component.text()
                    .append(Component.text("Spróbuj /bankier", Colors.RED))
                    .build();
            player.sendActionBar(error);
            return false;
        }
        Component name = Component.text()
                .append(Component.text("Bankier"))
                .build();
        Settler settler = new Settler(name, player.getLocation(), Villager.Profession.CARTOGRAPHER, Villager.Type.SAVANNA);
        settler.spawn();
        Component success = Component.text()
                .append(Component.text("Wezwano bankiera!", Colors.GREEN))
                .build();
        player.sendActionBar(success);
        return true;
    }

}
