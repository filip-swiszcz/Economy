package pl.mcsu.economy.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import pl.mcsu.economy.controller.Organizer;

public class Pre implements Listener {

    @EventHandler
    public void pre(AsyncPlayerPreLoginEvent event) {
        if (!Organizer.getInstance().hasUser(event.getUniqueId())) Organizer.getInstance().setUser(event.getUniqueId());
    }

}
