package pl.mcsu.economy.repository;

import pl.mcsu.economy.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Container {

    private static Container instance = new Container();

    public Container() {
        instance = this;
    }

    public static Container getInstance() {
        return instance;
    }

    /*
    *
    *   Container class
    *
    * */

    private final Map<UUID, User> users = new HashMap<>();

    public Map<UUID, User> getUsers() {
        return users;
    }

}
