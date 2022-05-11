package pl.mcsu.economy.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.mcsu.economy.database.Queries;

public class Quit implements Listener {

    @EventHandler
    public void quit(PlayerQuitEvent event) {
        Queries.getInstance().setAccount(event.getPlayer().getUniqueId(), event.getPlayer().getName(), true);
    }

}
