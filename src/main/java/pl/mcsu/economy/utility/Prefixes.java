package pl.mcsu.economy.utility;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;

public class Prefixes {

    public static Component server = Component.text()
            .append(Component.text("MCSU.PL", Colors.LIGHT_YELLOW)
                    .decoration(TextDecoration.ITALIC, false))
            .build();
    public static Component success = Component.text()
            .append(Component.text("MCSU.PL » ", Colors.GREEN))
            .build();
    public static Component error = Component.text()
            .append(Component.text("MCSU.PL » ", Colors.RED))
            .build();

}
