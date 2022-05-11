package pl.mcsu.economy.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.mcsu.economy.controller.Organizer;
import pl.mcsu.economy.database.Queries;

public class Join implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void join(PlayerJoinEvent event) {
        if (!Queries.getInstance().hasAccount(event.getPlayer().getUniqueId()))
            Queries.getInstance().setAccount(event.getPlayer().getUniqueId(), event.getPlayer().getName(), false);
        int[] assets = Queries.getInstance().getAccount(event.getPlayer().getUniqueId());
        if (assets == null) return;
        Organizer.getInstance().getUser(event.getPlayer().getUniqueId()).setCoins(assets[0]);
        Organizer.getInstance().getUser(event.getPlayer().getUniqueId()).setEmeralds(assets[1]);
        Organizer.getInstance().getUser(event.getPlayer().getUniqueId()).setNetherite(assets[2]);
        Organizer.getInstance().getUser(event.getPlayer().getUniqueId()).setDiamonds(assets[3]);
    }

}
