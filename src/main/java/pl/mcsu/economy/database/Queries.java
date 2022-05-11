package pl.mcsu.economy.database;

import pl.mcsu.economy.controller.Organizer;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.UUID;

public class Queries extends Links {

    private static Queries instance = new Queries();

    public Queries() {
        instance = this;
    }

    public static Queries getInstance() {
        return instance;
    }

    /*
    *
    *   Queries class
    *
    * */

    public int[] getAccount(UUID uuid) {
        String sql = "select coins, emeralds, netherite, diamonds from assets where uuid=?";
        Object[] objects = new Object[1];
        objects[0] = uuid.toString();
        int [] assets = new int[4];
        try {
            CachedRowSet cachedRowSet = select(sql, objects);
            while (cachedRowSet.next()) {
                assets[0] = cachedRowSet.getInt(1);
                assets[1] = cachedRowSet.getInt(2);
                assets[2] = cachedRowSet.getInt(3);
                assets[3] = cachedRowSet.getInt(4);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return assets;
    }

    public boolean hasAccount(UUID uuid) {
        String sql = "select id from assets where uuid=?";
        Object[] objects = new Object[1];
        objects[0] = uuid.toString();
        try {
            CachedRowSet cachedRowSet = select(sql, objects);
            if (cachedRowSet.first()) return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    public void setAccount(UUID uuid, String name, boolean update) {
        if (update) {
            String sql = "update assets set coins=?, emeralds=?, netherite=?, diamonds=? where uuid=?";
            Object[] objects = new Object[5];
            objects[0] = Organizer.getInstance().getUser(uuid).getCoins();
            objects[1] = Organizer.getInstance().getUser(uuid).getEmeralds();
            objects[2] = Organizer.getInstance().getUser(uuid).getNetherite();
            objects[3] = Organizer.getInstance().getUser(uuid).getDiamonds();
            objects[4] = uuid.toString();
            try {
                execute(sql, objects);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            return;
        }
        String sql = "insert into assets(uuid, name, coins, emeralds, netherite, diamonds) values (?, ?, ?, ?, ?, ?)";
        Object[] objects = new Object[6];
        objects[0] = uuid.toString();
        objects[1] = name;
        objects[2] = 0;
        objects[3] = 0;
        objects[4] = 0;
        objects[5] = 0;
        try {
            execute(sql, objects);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}
