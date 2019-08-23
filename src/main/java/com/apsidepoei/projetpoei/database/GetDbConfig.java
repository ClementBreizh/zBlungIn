package com.apsidepoei.projetpoei.database;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetDbConfig {

  private static String ip;
  private static String login;
  private static String dbname;
  private static String psw;

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
   * Point d'accès pour l'instance unique du singleton.
   *
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
    final String CONFIGPATH = System.getenv("VARPROJECT");

    try {
      InputStream flux = new FileInputStream("/" + CONFIGPATH);
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
   *
   * @return
   */
  public String getIp() {
    return ip;
  }

  /**
   * Get login.
   *
   * @return
   */
  public String getLogin() {
    return login;
  }

  /**
   * Get dbname.
   *
   * @return
   */
  public String getDbname() {
    return dbname;
  }

  /**
   * Get psw.
   *
   * @return
   */
  public String getPsw() {
    return psw;
  }
}
