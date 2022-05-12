package pl.mcsu.economy;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;
import pl.mcsu.economy.command.Balance;
import pl.mcsu.economy.command.Coins;
import pl.mcsu.economy.command.Set;
import pl.mcsu.economy.command.Transfer;
import pl.mcsu.economy.listener.*;
import pl.mcsu.economy.model.User;
import pl.mcsu.economy.repository.Container;
import pl.mcsu.economy.service.Assets;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.UUID;

public final class Economy extends JavaPlugin {

    private static Economy instance;

    public Economy() {
        instance = this;
    }

    public static Economy getInstance() {
        return instance;
    }

    /*
    *
    *   Economy class
    *
    * */

    public Map<UUID, User> userMap() {
        return Container.getInstance().getUsers();
    }

    @Override
    public void onEnable() {
        setCommands();
        setConfig();
        setListeners();
    }

    private void setCommands() {
        try {
            Field commandMapClass = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapClass.setAccessible(true);
            CommandMap commandMap = (CommandMap) commandMapClass.get(Bukkit.getServer());
            commandMap.register("economy", new Balance("bank"));
            commandMap.register("economy", new Coins("monety"));
            commandMap.register("economy", new Set("bankier"));
            commandMap.register("economy", new Transfer("przelew"));
            commandMapClass.setAccessible(false);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void setConfig() {
        saveDefaultConfig();
    }

    private void setListeners() {
        getServer().getPluginManager().registerEvents(new Click(), this);
        getServer().getPluginManager().registerEvents(new Close(), this);
        getServer().getPluginManager().registerEvents(new Drag(), this);
        getServer().getPluginManager().registerEvents(new Interact(), this);
        getServer().getPluginManager().registerEvents(new Join(), this);
        //getServer().getPluginManager().registerEvents(new Pre(), this);
        getServer().getPluginManager().registerEvents(new Quit(), this);
    }

}
