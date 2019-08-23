package com.apsidepoei.projetpoei.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DbOpenHelper {

  private Connection conn;

  /** Constructeur privé. */
  private DbOpenHelper() {
    GetDbConfig.getInstance().dbConfig();

    MysqlDataSource datasource = new MysqlDataSource();
    datasource.setUser(GetDbConfig.getInstance().getLogin());
    datasource.setPassword(GetDbConfig.getInstance().getPsw());
    datasource.setServerName(GetDbConfig.getInstance().getIp());
    datasource.setDatabaseName(GetDbConfig.getInstance().getDbname());

    try {
      datasource.setServerTimezone("UTC");
      conn = datasource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Instance unique non préinitialisée. */
  private static DbOpenHelper INSTANCE = null;

  /** Point d'accès pour l'instance unique du DBOpenHelper. */
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
   * the conn.
   */
  public Connection getConn() {
    return conn;
  }

}
