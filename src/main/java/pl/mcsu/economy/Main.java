package pl.mcsu.economy;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;
import pl.mcsu.economy.command.Balance;
import pl.mcsu.economy.command.Coins;
import pl.mcsu.economy.command.Set;
import pl.mcsu.economy.command.Transfer;
import pl.mcsu.economy.listener.*;
import pl.mcsu.economy.service.Assets;

import java.lang.reflect.Field;

public final class Main extends JavaPlugin {

    private static Main instance;

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }

    /*
    *
    *   Main class
    *
    * */

    public static Assets getApi() {
        return Assets.getInstance();
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
