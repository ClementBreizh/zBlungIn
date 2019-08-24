package com.apsidepoei.projetpoei.database.entitiesgenerator;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Degree;
import com.github.javafaker.Faker;
import com.tactfactory.consolelogger.ConsoleLogger;
import com.tactfactory.consolelogger.Options;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * This class generate fake data.
 *
 * @author thomas
 */
public class DegreeGenerator {
  private DegreeGenerator() {
  }

  private static DegreeGenerator INSTANCE = null;

  /**
   * An instance of the constructor.
   *
   * @return an instance
   */
  public static DegreeGenerator getInstance() {
    if (INSTANCE == null) {
      synchronized (DegreeGenerator.class) {
        if (INSTANCE == null) {
          INSTANCE = new DegreeGenerator();
        }
      }
    }
    return INSTANCE;
  }

  Faker faker = new Faker(Locale.FRENCH);
  private List<Degree> datas = new ArrayList<Degree>();

  /**
   * Generate fake data.
   *
   * @return fake data
   */
  public List<Degree> generateDatas() throws SQLException {
    return generateDatas(faker.random().nextInt(100));
  }

  /**
   * Generate n fake data.
   *
   * @param nb = the number
   * @return n fake data
   */
  public List<Degree> generateDatas(int nb) throws SQLException {
    List<Degree> result = new ArrayList<>();
    List<String> degrees = new ArrayList<String>();

    int i = 0;
    while (i < nb) {
      String deg = faker.educator().course();
      if (!degrees.contains(deg)) {
        degrees.add(deg);

        Degree degree = new Degree(deg, "BAC + " + faker.number().digit());
        result.add(degree);

        i++;
      }
    }
    return result;
  }

  /**
   * Generate and insert datas.
   *
   */
  public void generateAndInsertDatas() throws SQLException {
    generateAndInsertDatas(faker.random().nextInt(100));
  }

  /**
   * Generate and insert n datas.
   *
   * @param nb = the number
   */
  public void generateAndInsertDatas(int nb) throws SQLException {
    for (Degree degree : generateDatas(nb)) {
      DbManager.getInstance().getDegreeDao().insert(degree);
      System.out.println(degree);
      datas.add(degree);
    }
  }

  /**
   * Drop, create table, generate and insert datas.
   *
   */
  public void generateAndInsertDatasDroppingTable() throws SQLException {
    generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
  }

  /**
   * Drop, create table, generate and insert n data.
   *
   * @param nb = number
   */
  public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
    ConsoleLogger generatedLogger = new ConsoleLogger("Degree generated data tests", Options.DEBUG);
    generatedLogger.Log("Lancement des tests de données générées.", Options.DEBUG);

    DbManager.getInstance().getDegreeDao().drop();
    DbManager.getInstance().getDegreeDao().create();

    generateAndInsertDatas(nb);

    generatedLogger.Log("Fin des tests de données générées.", Options.DEBUG);
  }

  /**
   * Delete datas.
   */
  public void deleteDatas() {
    for (Degree degree : datas) {
      DbManager.getInstance().getDegreeDao().delete(degree);
    }
  }
}
