package com.apsidepoei.projetpoei.database.entitiesgenerator;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Matter;

import com.github.javafaker.Faker;
import com.tactfactory.consolelogger.ConsoleLogger;
import com.tactfactory.consolelogger.Options;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MatterGenerator {

  /**
   * constructor.
   */
  public MatterGenerator() {
  }

  private static volatile MatterGenerator INSTANCE = null;

  /**
   * Generator for Matter.
   */
  public static MatterGenerator getInstance() {
    if (INSTANCE == null) {
      synchronized (MatterGenerator.class) {
        if (INSTANCE == null) {
          INSTANCE = new MatterGenerator();
        }
      }
    }
    return INSTANCE;
  }

  private Faker faker = new Faker(Locale.FRENCH);
  private List<Matter> datas = new ArrayList<Matter>();


  /**
   * Generate list.
   */
  public List<Matter> generateDatas() throws SQLException {
    return generateDatas(faker.random().nextInt(100));
  }

  /**
   * Generate list of data.
   */
  public List<Matter> generateDatas(int nb) throws SQLException {
    List<Matter> result = new ArrayList<>();
    List<String> matters = new ArrayList<String>();

    int i = 0;
    while (i < nb) {
      String matterss = faker.book().title();
      if (!matters.contains(matterss)) {

        matters.add(matterss);

        Matter mat = new Matter(matterss);
        result.add(mat);

        i++;
      }
    }
    return result;
  }

  /**
   * Generate and Insert data .
   */
  public void generateAndInsertDatas() throws SQLException {
    generateAndInsertDatas(faker.random().nextInt(100));
  }

  /**
   * Generate and Insert data with parameter.
   */
  public void generateAndInsertDatas(int nb) throws SQLException {
    for (Matter matters : generateDatas(nb)) {
      DbManager.getInstance().getMatterDao().insert(matters);
      datas.add(matters);
    }
  }

  /**
   * Generate and insert after a drop table with random parameter.
   */
  public void generateAndInsertDatasDroppingTable() throws SQLException {
    generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
  }

  /**
   * Generate and insert after a drop table with a parameter number.
   */
  public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
    ConsoleLogger generatedLogger = new ConsoleLogger("Matter generated data tests", Options.DEBUG);
    generatedLogger.Log("Lancement des tests de données générées.", Options.DEBUG);

    DbManager.getInstance().getMatterDao().drop();
    DbManager.getInstance().getMatterDao().create();

    generateAndInsertDatas(nb);

    generatedLogger.Log("Fin des tests de données générées.", Options.DEBUG);
  }

  /**
   * Delete data in table.
   */
  public void deleteDatas() {
    for (Matter matters : datas) {
      DbManager.getInstance().getMatterDao().delete(matters);
    }
  }

  /**
   *  monMatter.
   */
  public void insert(Matter monMatter) {
  }
}
