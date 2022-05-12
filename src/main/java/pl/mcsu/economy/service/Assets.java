package pl.mcsu.economy.service;

import org.bukkit.entity.Player;
import pl.mcsu.economy.controller.Organizer;
import pl.mcsu.economy.utility.Types;

public class Assets {

    private static Assets instance = new Assets();

    public Assets() {
        instance = this;
    }

    public static Assets getInstance() {
        return instance;
    }

    /*
    *
    *   Assets class
    *
    * */

    public static void add(Player player, Types.Asset asset, int amount) {
        switch (asset) {
            case COINS -> Organizer.getInstance().getUser(player.getUniqueId())
                    .setCoins(Organizer.getInstance().getUser(player.getUniqueId()).getCoins() + amount);
            case EMERALDS -> Organizer.getInstance().getUser(player.getUniqueId())
                    .setEmeralds(Organizer.getInstance().getUser(player.getUniqueId()).getEmeralds() + amount);
            case NETHERITE -> Organizer.getInstance().getUser(player.getUniqueId())
                    .setNetherite(Organizer.getInstance().getUser(player.getUniqueId()).getNetherite() + amount);
            case DIAMONDS -> Organizer.getInstance().getUser(player.getUniqueId())
                    .setDiamonds(Organizer.getInstance().getUser(player.getUniqueId()).getDiamonds() + amount);
        }
    }

    public void remove(Player player, Types.Asset asset, int amount) {
        switch (asset) {
            case COINS:
                if (amount > Organizer.getInstance().getUser(player.getUniqueId()).getCoins()) return;
                Organizer.getInstance().getUser(player.getUniqueId())
                    .setCoins(Organizer.getInstance().getUser(player.getUniqueId()).getCoins() - amount);
            case EMERALDS:
                if (amount > Organizer.getInstance().getUser(player.getUniqueId()).getEmeralds()) return;
                Organizer.getInstance().getUser(player.getUniqueId())
                        .setEmeralds(Organizer.getInstance().getUser(player.getUniqueId()).getEmeralds() - amount);
            case NETHERITE:
                if (amount > Organizer.getInstance().getUser(player.getUniqueId()).getNetherite()) return;
                Organizer.getInstance().getUser(player.getUniqueId())
                        .setNetherite(Organizer.getInstance().getUser(player.getUniqueId()).getNetherite() - amount);
            case DIAMONDS:
                if (amount > Organizer.getInstance().getUser(player.getUniqueId()).getDiamonds()) return;
                Organizer.getInstance().getUser(player.getUniqueId())
                        .setDiamonds(Organizer.getInstance().getUser(player.getUniqueId()).getDiamonds() - amount);
        }
    }

}
