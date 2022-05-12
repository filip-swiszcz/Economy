package pl.mcsu.economy.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import pl.mcsu.economy.Economy;

public class Settings {

    public final HikariDataSource hikariDataSource = new HikariDataSource(getHikariConfig());

    private HikariConfig getHikariConfig() {
        String name = Economy.getInstance().getConfig().getString("name");
        String user = Economy.getInstance().getConfig().getString("user");
        String password = Economy.getInstance().getConfig().getString("password");
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/" + name);
        hikariConfig.setUsername(user);
        hikariConfig.setPassword(password);
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("useServerPrepStmts", "true");
        return hikariConfig;
    }

}
