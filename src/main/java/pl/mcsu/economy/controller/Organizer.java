package pl.mcsu.economy.controller;

import pl.mcsu.economy.repository.Container;
import pl.mcsu.economy.model.User;

import java.util.UUID;

public class Organizer {

    private static Organizer instance = new Organizer();

    public Organizer() {
        instance = this;
    }

    public static Organizer getInstance() {
        return instance;
    }

    /*
    *
    *   Organizer class
    *
    * */

    public User getUser(UUID uuid) {
        return Container.getInstance().getUsers().get(uuid);
    }

    public boolean hasUser(UUID uuid) {
        return Container.getInstance().getUsers().containsKey(uuid);
    }

    public void setUser(UUID uuid) {
        User user = new User(uuid);
        Container.getInstance().getUsers().put(uuid, user);
    }

}
