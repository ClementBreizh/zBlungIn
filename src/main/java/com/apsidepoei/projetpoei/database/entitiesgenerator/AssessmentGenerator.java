package com.apsidepoei.projetpoei.database.entitiesgenerator;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Assessment;

import com.github.javafaker.Faker;
import com.tactfactory.consolelogger.ConsoleLogger;
import com.tactfactory.consolelogger.Options;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AssessmentGenerator {

  /**
   * Constructor.
   */
  public AssessmentGenerator() {
  }

  private static volatile AssessmentGenerator INSTANCE = null;

  /**
   * Generator for Assessment.
   */
  public static AssessmentGenerator getInstance() {
    if (INSTANCE == null) {
      synchronized (AssessmentGenerator.class) {
        if (INSTANCE == null) {
          INSTANCE = new AssessmentGenerator();
        }
      }
    }
    return INSTANCE;
  }

  private Faker faker = new Faker(Locale.FRENCH);

  private List<Assessment> datas = new ArrayList<Assessment>();

  /**
   * Generate data list for Assessment with faker.
   */
  public List<Assessment> generateDatas() throws SQLException, ParseException {
    return generateDatas(faker.random().nextInt(100));
  }

  /**
   * Generate data list for Assessment.
   */
  public List<Assessment> generateDatas(int nb) throws SQLException, ParseException {
    List<Assessment> result = new ArrayList<>();
    int i = 0;
    while (i < nb) {
      Assessment test = new Assessment(faker.name().firstName(),
          new SimpleDateFormat("yyyy/MM/dd").parse("1999/12/31"));
      if (!result.contains(test)) {
        result.add(test);

        i++;
      }
    }
    return result;

  }

  /**
   * Generate and insert date with random parameter.
   */
  public void generateAndInsertDatas() throws SQLException, ParseException {
    generateAndInsertDatas(faker.random().nextInt(100));
  }

  /**
   * generate and insert data with paramater number.
   */
  public void generateAndInsertDatas(int nb) throws SQLException, ParseException {
    for (Assessment assessment : generateDatas(nb)) {
      DbManager.getInstance().getAssessmentDao().insert(assessment);
      datas.add(assessment);
    }
  }
  /**
   * generate and insert data with faker.
   */
  public void generateAndInsertDatasDroppingTable() throws SQLException, ParseException {
    generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
  }

  /**
   * Generate and insert data after drop the table.
   */
  public void generateAndInsertDatasDroppingTable(int nb) throws SQLException, ParseException {
    ConsoleLogger generatedLogger = new ConsoleLogger("Assessment generated data tests", Options.DEBUG);
    generatedLogger.Log("Lancement des tests de données générées.", Options.DEBUG);

    DbManager.getInstance().getAssessmentDao().drop();
    DbManager.getInstance().getAssessmentDao().create();

    generateAndInsertDatas(nb);

    generatedLogger.Log("Fin des tests de données générées.", Options.DEBUG);
  }

  /**
   * Delete data.
   */
  public void deleteDatas() {
    for (Assessment assessment : datas) {
      DbManager.getInstance().getAssessmentDao().delete(assessment);
    }
  }

  /**
   * insert function.
   */
  public void insert(Assessment monAssessment) {

  }
}
