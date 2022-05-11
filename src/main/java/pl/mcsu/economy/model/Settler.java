package pl.mcsu.economy.model;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

public class Settler {

    private final Location location;
    private final Component name;
    private final Villager.Profession profession;
    private final Villager.Type type;

    public Settler(Component name, Location location, Villager.Profession profession, Villager.Type type) {
        this.location = location;
        this.name = name;
        this.profession = profession;
        this.type = type;
    }

    public Component getName() {
        return name;
    }

    public Villager.Profession getProfession() {
        return profession;
    }

    public Villager.Type getType() {
        return type;
    }

    public void spawn() {
        Villager villager = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        villager.customName(name);
        villager.setProfession(profession);
        villager.setVillagerType(type);
        villager.setInvulnerable(true);
        villager.setAI(false);
        villager.setCollidable(false);
        villager.setGravity(false);
        villager.setCustomNameVisible(true);
        villager.setSilent(true);
    }

}
