package com.apsidepoei.projetpoei.database.entitiesgenerator;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Entreprise;
import com.github.javafaker.Faker;

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
   * @return
   * @throws SQLException
   */
  public List<Entreprise> generateDatas() throws SQLException {
    return generateDatas(faker.random().nextInt(100));
  }

  /**
   * Generate n fake data.
   * 
   * @param nb
   * @return
   * @throws SQLException
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
   * @throws SQLException
   */
  public void generateAndInsertDatas() throws SQLException {
    generateAndInsertDatas(faker.random().nextInt(100));
  }

  /**
   * Generate and insert n datas.
   *
   * @param nb = the number
   * @throws SQLException
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
   * @throws SQLException
   */
  public void generateAndInsertDatasDroppingTable() throws SQLException {
    generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
  }

  /**
   * Drop, create table, generate and insert n data.
   *
   * @param nb = the number
   * @throws SQLException
   */
  public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
    DbManager.getInstance().getEntrepriseDao().drop();
    DbManager.getInstance().getEntrepriseDao().create();

    generateAndInsertDatas(nb);
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
