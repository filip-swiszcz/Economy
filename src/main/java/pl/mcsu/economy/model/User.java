package pl.mcsu.economy.model;

import pl.mcsu.economy.utility.Types;

import java.util.UUID;

public class User {

    private final UUID uuid;
    private int coins;
    private int emeralds;
    private int netherite;
    private int diamonds;
    private Types.Select select;

    public User(UUID uuid) {
        this.uuid = uuid;
        this.coins = 0;
        this.emeralds = 0;
        this.netherite = 0;
        this.diamonds = 0;
        this.select = Types.Select.NEUTRAL;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getCoins() {
        return coins;
    }

    public int getEmeralds() {
        return emeralds;
    }

    public int getNetherite() {
        return netherite;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public Types.Select getSelect() {
        return select;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setEmeralds(int emeralds) {
        this.emeralds = emeralds;
    }

    public void setNetherite(int netherite) {
        this.netherite = netherite;
    }

    public void setDiamonds(int diamonds) {
        this.diamonds = diamonds;
    }

    public void setSelect(Types.Select select) {
        this.select = select;
    }

}
