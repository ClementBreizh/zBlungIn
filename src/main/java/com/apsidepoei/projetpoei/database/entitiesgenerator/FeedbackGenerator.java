/**
 *
 */
package com.apsidepoei.projetpoei.database.entitiesgenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Feedback;
import com.github.javafaker.Faker;
import com.tactfactory.consolelogger.ConsoleLogger;
import com.tactfactory.consolelogger.Options;

/**
 * This class generate fake data for Feedback class.
 *
 * @author vianney
 */
public class FeedbackGenerator {

  /**
   * Constructor.
   */
  private FeedbackGenerator() {
  }

  private static FeedbackGenerator INSTANCE = null;

  /**
   *
   * @return an instance of the constructor
   */
  public static FeedbackGenerator getInstance() {
    if (INSTANCE == null) {
      synchronized (FeedbackGenerator.class) {
        if (INSTANCE == null) {
          INSTANCE = new FeedbackGenerator();
        }
      }
    }
    return INSTANCE;
  }

  Faker faker = new Faker(Locale.FRENCH);
  private List<Feedback> datas = new ArrayList<Feedback>();

  /**
   *
   * @return
   * @throws SQLException Generate fake data
   */
  public List<Feedback> generateDatas() throws SQLException {
    return generateDatas(faker.random().nextInt(100));
  }

  /**
   * Generate n fake data.
   *
   * @param nb
   * @return
   * @throws SQLException
   */
  public List<Feedback> generateDatas(int nb) throws SQLException {
    List<Feedback> result = new ArrayList<>();

    int i = 0;
    while (i < nb) {
      if (i % 3 == 0) {
        String typeOfContract1 = "CDI";
        Feedback feedback = new Feedback(typeOfContract1, 0, faker.company().name());
        result.add(feedback);
      } else if (i % 3 == 1) {
        String typeOfContract2 = "CDD";
        Integer durationOfContract2 = faker.random().nextInt(6, 24);
        String comment2 = faker.company().name();

        Feedback feedback = new Feedback(typeOfContract2, durationOfContract2, comment2);
        result.add(feedback);
      } else if (i % 3 == 2) {
        String typeOfContract2 = "Intérim";
        Integer durationOfContract2 = faker.random().nextInt(6, 24);
        String comment2 = faker.company().name();

        Feedback feedback = new Feedback(typeOfContract2, durationOfContract2, comment2);
        result.add(feedback);
      }

      i++;
    }
    return result;
  }

  /**
   * Generate and insert datas.
   *
   * @throws SQLException
   */
  public void generateAndInsertDatas() throws SQLException {
    generateAndInsertDatas(faker.random().nextInt(100));
  }

  /**
   * Generate and insert n datas.
   *
   * @param nb
   * @throws SQLException
   */
  public void generateAndInsertDatas(int nb) throws SQLException {
    for (Feedback feedback : generateDatas(nb)) {
      DbManager.getInstance().getFeedbackDao().insert(feedback);
      System.out.println(feedback);
      datas.add(feedback);
    }
  }

  /**
   * Drop, create table, generate and insert datas.
   *
   * @throws SQLException
   */
  public void generateAndInsertDatasDroppingTable() throws SQLException {
    generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
  }

  /**
   * Drop, create table, generate and insert n data.
   *
   * @param nb = number
   * @throws SQLException
   */
  public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
    ConsoleLogger generatedLogger = new ConsoleLogger("Feedback generated data tests", Options.DEBUG);
    generatedLogger.Log("Lancement des tests de données générées.", Options.DEBUG);

    DbManager.getInstance().getFeedbackDao().drop();
    DbManager.getInstance().getFeedbackDao().create();

    generateAndInsertDatas(nb);

    generatedLogger.Log("Fin des tests de données générées.", Options.DEBUG);
  }

  /**
   * Delete datas
   */
  public void deleteDatas() {
    for (Feedback feedback : datas) {
      DbManager.getInstance().getFeedbackDao().delete(feedback);
    }
  }
}
