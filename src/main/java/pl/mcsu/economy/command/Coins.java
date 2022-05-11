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

import java.util.Locale;

public class Coins extends Command {

    public Coins(@NotNull String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (!player.hasPermission("economy.coins")) {
            Component error = Component.text()
                    .append(Component.text("Nie posiadasz wymaganych uprawnień!", Colors.RED))
                    .build();
            player.sendActionBar(error);
            return false;
        }
        if (args.length != 3) {
            Component error = Component.text()
                    .append(Component.text("Spróbuj /monety [gracz] [dodaj/usun] [kwota]", Colors.RED))
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
        switch (args[1].toLowerCase(Locale.ROOT)) {
            case "dodaj":
                if (!StringUtils.isNumeric(args[2])) {
                    Component error = Component.text()
                            .append(Component.text("Kwota jest niepoprawna!", Colors.RED))
                            .build();
                    player.sendActionBar(error);
                    return false;
                }
                int amount = Integer.parseInt(args[2]);
                Assets.getInstance().add(target, Types.Asset.COINS, amount);
                Component send = Component.text()
                        .append(Component.text("Wysłano monety!", Colors.GREEN))
                        .build();
                player.sendActionBar(send);
                Component receive = Component.text()
                        .append(Component.text("Otrzymano monety!", Colors.GREEN))
                        .build();
                target.sendActionBar(receive);
                return true;
            case "usun":
                if (!StringUtils.isNumeric(args[2])) {
                    Component error = Component.text()
                            .append(Component.text("Kwota jest niepoprawna!", Colors.RED))
                            .build();
                    player.sendActionBar(error);
                    return false;
                }
                amount = Integer.parseInt(args[2]);
                if (amount > Organizer.getInstance().getUser(target.getUniqueId()).getCoins()) {
                    Component error = Component.text()
                            .append(Component.text("Gracz nie posiada takiej ilości monet!", Colors.RED))
                            .build();
                    player.sendActionBar(error);
                    return false;
                }
                Assets.getInstance().remove(target, Types.Asset.COINS, amount);
                Component take = Component.text()
                        .append(Component.text("Odebrano monety!", Colors.GREEN))
                        .build();
                player.sendActionBar(take);
                Component lose = Component.text()
                        .append(Component.text("Stracono monety!", Colors.GREEN))
                        .build();
                target.sendActionBar(lose);
                return true;
        }
        return true;
    }

}
