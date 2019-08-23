package com.apsidepoei.projetpoei.database.entitiesgenerator;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Matter;

import com.github.javafaker.Faker;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MatterGenerator {

  public MatterGenerator() {
  }

  private static MatterGenerator INSTANCE = null;

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
   * @return
   * @throws SQLException
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
    DbManager.getInstance().getMatterDao().drop();
    DbManager.getInstance().getMatterDao().create();

    generateAndInsertDatas(nb);
  }

  /**
   * Delete data in table.
   */
  public void deleteDatas() {
    for (Matter matters : datas) {
      DbManager.getInstance().getMatterDao().delete(matters);
    }
  }

  public void insert(Matter monMatter) {
  }
}
