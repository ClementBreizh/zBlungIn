package com.apsidepoei.projetpoei.database.entitiesgenerator;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Entreprise;
import com.github.javafaker.Faker;
import com.tactfactory.consolelogger.ConsoleLogger;
import com.tactfactory.consolelogger.Options;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *  This class generate fake data.
 * @author benjamin-m
 *
 */
public class EntrepriseGenerator {
  private EntrepriseGenerator() {
  }

  private static EntrepriseGenerator INSTANCE = null;

  /**
   * instance of the constructor.
   *
   * @return an
   */
  public static EntrepriseGenerator getInstance() {
    if (INSTANCE == null) {
      synchronized (EntrepriseGenerator.class) {
        if (INSTANCE == null) {
          INSTANCE = new EntrepriseGenerator();
        }
      }
    }
    return INSTANCE;
  }

  Faker faker = new Faker(Locale.FRENCH);
  private List<Entreprise> datas = new ArrayList<Entreprise>();

  /**
   * Generate fake data.
   *
   * @return fake data.
   */
  public List<Entreprise> generateDatas() throws SQLException {
    return generateDatas(faker.random().nextInt(100));
  }

  /**
   * Generate n fake data.
   *
   * @param nb = the number
   * @return n fake data.
   */
  public List<Entreprise> generateDatas(int nb) throws SQLException {
    List<Entreprise> result = new ArrayList<>();
    List<String> entreprises = new ArrayList<String>();

    int i = 0;
    while (i < nb) {
      String ent = faker.company().name();
      if (!entreprises.contains(ent)) {
        entreprises.add(ent);

        Entreprise entreprise = new Entreprise(ent, ent + faker.address().city(),
            faker.number().digits(14), faker.letterify(faker.number().digits(4) + "?"));
        result.add(entreprise);

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
    for (Entreprise entreprise : generateDatas(nb)) {
      DbManager.getInstance().getEntrepriseDao().insert(entreprise);
      System.out.println(entreprise);
      datas.add(entreprise);
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
   * @param nb = the number
   */
  public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
    ConsoleLogger generatedLogger = new ConsoleLogger("Company generated data tests",
        Options.DEBUG);
    generatedLogger.Log("Lancement des tests de données générées.", Options.DEBUG);

    DbManager.getInstance().getEntrepriseDao().drop();
    DbManager.getInstance().getEntrepriseDao().create();

    generateAndInsertDatas(nb);

    generatedLogger.Log("Fin des tests de données générées.", Options.DEBUG);
  }

  /**
   * delete datas.
   */
  public void deleteDatas() {
    for (Entreprise entreprise : datas) {
      DbManager.getInstance().getEntrepriseDao().delete(entreprise);
    }
  }
}
