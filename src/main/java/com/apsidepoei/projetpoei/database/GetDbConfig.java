package com.apsidepoei.projetpoei.database;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetDbConfig {

  private String ip;
  private String login;
  private String dbname;
  private String psw;

  /**
   * Constructeur privé.
   */
  private GetDbConfig() {
  }

  /**
   * Instance unique non préinitialisée.
   */
  private static GetDbConfig INSTANCE = null;

  /**
   * Acces point for singleton.
   */
  public static GetDbConfig getInstance() {
    if (INSTANCE == null) {
      synchronized (GetDbConfig.class) {
        if (INSTANCE == null) {
          INSTANCE = new GetDbConfig();
        }
      }
    }
    return INSTANCE;
  }

  /**
   * Get db config from a file in /home.
   */
  public void dbConfig() {
    final String configPath = System.getenv("VARPROJECT");

    try {
      InputStream flux = new FileInputStream("/" + configPath);
      InputStreamReader lecture = new InputStreamReader(flux);
      BufferedReader buff = new BufferedReader(lecture);
      String ligne;

      int i = 1;
      while ((ligne = buff.readLine()) != null) {
        switch (i) {
          case 1:
            ip = ligne;
            i++;
            break;
          case 2:
            login = ligne;
            i++;
            break;
          case 3:
            psw = ligne;
            i++;
            break;
          case 4:
            dbname = ligne;
            i++;
            break;
          default:
            break;
        }
      }
      buff.close();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  /**
   * Get ip.
   */
  public String getIp() {
    return ip;
  }

  /**
   * Get login.
   */
  public String getLogin() {
    return login;
  }

  /**
   * Get dbname.
   */
  public String getDbname() {
    return dbname;
  }

  /**
   * Get psw.
   */
  public String getPsw() {
    return psw;
  }
}
