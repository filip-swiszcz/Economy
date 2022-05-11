package pl.mcsu.economy.command;

import net.kyori.adventure.text.Component;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.mcsu.economy.controller.Organizer;
import pl.mcsu.economy.service.Assets;
import pl.mcsu.economy.utility.Colors;
import pl.mcsu.economy.utility.Types;

public class Transfer extends Command {

    public Transfer(@NotNull String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length != 2) {
            Component error = Component.text()
                    .append(Component.text("Spróbuj /przelew [gracz] [kwota]", Colors.RED))
                    .build();
            player.sendActionBar(error);
            return false;
        }
        if (args[0].equalsIgnoreCase(player.getName())) {
            Component error = Component.text()
                    .append(Component.text("Nie możesz zrobić przelewu sobie!", Colors.RED))
                    .build();
            player.sendActionBar(error);
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            Component error = Component.text()
                    .append(Component.text("Gracz jest niedostępny!", Colors.RED))
                    .build();
            player.sendActionBar(error);
            return false;
        }
        if (!StringUtils.isNumeric(args[1])) {
            Component error = Component.text()
                    .append(Component.text("Kwota jest niepoprawna!", Colors.RED))
                    .build();
            player.sendActionBar(error);
            return false;
        }
        int amount = Integer.parseInt(args[1]);
        if (amount > Organizer.getInstance().getUser(player.getUniqueId()).getCoins()) {
            Component error = Component.text()
                    .append(Component.text("Nie posiadasz takiej ilości monet!", Colors.RED))
                    .build();
            player.sendActionBar(error);
            return false;
        }
        Assets.getInstance().remove(player, Types.Asset.COINS, amount);
        Component send = Component.text()
                .append(Component.text("Wysłano przelew!", Colors.GREEN))
                .build();
        player.sendActionBar(send);
        Assets.getInstance().add(target, Types.Asset.COINS, amount);
        Component receive = Component.text()
                .append(Component.text("Otrzymano przelew!", Colors.GREEN))
                .build();
        target.sendActionBar(receive);
        return true;
    }

}
