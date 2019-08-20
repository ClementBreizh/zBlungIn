package com.apsidepoei.projetpoei.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DbOpenHelper {

    private Connection conn;

    /** Constructeur privé */
    private DbOpenHelper() {
        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setUser("vianney");
        datasource.setPassword("root");
        datasource.setServerName("127.0.0.1");
        datasource.setDatabaseName("zblungin");

        try {
            datasource.setServerTimezone("UTC");
            conn = datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Instance unique non préinitialisée */
    private static DbOpenHelper INSTANCE = null;

    /** Point d'accès pour l'instance unique du DBOpenHelper */
    public static DbOpenHelper getInstance() {
        if (INSTANCE == null) {
            synchronized (DbOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DbOpenHelper();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

}
