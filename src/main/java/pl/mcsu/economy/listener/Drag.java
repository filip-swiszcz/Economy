package pl.mcsu.economy.listener;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

public class Drag implements Listener {

    @EventHandler
    public void drag(InventoryDragEvent event) {
        Component title = Component.text()
                .append(Component.text("Bank"))
                .build();
        Component choose = Component.text()
                .append(Component.text("Wybierz"))
                .build();
        if (event.getView().title().equals(title)) event.setCancelled(true);
        if (event.getView().title().equals(choose)) event.setCancelled(true);
    }

}
