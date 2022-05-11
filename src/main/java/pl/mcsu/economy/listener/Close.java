package pl.mcsu.economy.listener;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import pl.mcsu.economy.controller.Organizer;
import pl.mcsu.economy.utility.Types;

public class Close implements Listener {

    @EventHandler
    public void close(InventoryCloseEvent event) {
        Component bank = Component.text()
                .append(Component.text("Bank"))
                .build();
        Component choose = Component.text()
                .append(Component.text("Wybierz"))
                .build();
        Component deposit = Component.text()
                .append(Component.text("Wpłać"))
                .build();
        Component withdraw = Component.text()
                .append(Component.text("Wypłać"))
                .build();
        if (!event.getView().title().equals(bank)
                || !event.getView().title().equals(choose)
                || !event.getView().title().equals(deposit)) return;

        // DEBUG
        System.out.println("USED EVENT #1");

        if (event.getReason().equals(InventoryCloseEvent.Reason.OPEN_NEW)) return;

        // DEBUG
        System.out.println("USED EVENT #2");

        Organizer.getInstance().getUser(event.getPlayer().getUniqueId()).setSelect(Types.Select.NEUTRAL);
    }

}
