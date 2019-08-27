package com.apsidepoei.projetpoei.database.entitiesgenerator;
//package com.apsidepoei.projetpoei.database.entitiesgenerator;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Company;
//import com.github.javafaker.Faker;
//import com.tactfactory.consolelogger.ConsoleLogger;
//import com.tactfactory.consolelogger.Options;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
///**
// *  This class generate fake data.
// * @author benjamin-m
// *
// */
//public class CompanyGenerator {
//  private CompanyGenerator() {
//  }
//
//  private static CompanyGenerator INSTANCE = null;
//
//  /**
//   * instance of the constructor.
//   *
//   * @return an
//   */
//  public static CompanyGenerator getInstance() {
//    if (INSTANCE == null) {
//      synchronized (CompanyGenerator.class) {
//        if (INSTANCE == null) {
//          INSTANCE = new CompanyGenerator();
//        }
//      }
//    }
//    return INSTANCE;
//  }
//
//  Faker faker = new Faker(Locale.FRENCH);
//  private List<Company> datas = new ArrayList<Company>();
//
//  /**
//   * Generate fake data.
//   *
//   * @return fake data.
//   */
//  public List<Company> generateDatas() throws SQLException {
//    return generateDatas(faker.random().nextInt(100));
//  }
//
//  /**
//   * Generate n fake data.
//   *
//   * @param nb = the number
//   * @return n fake data.
//   */
//  public List<Company> generateDatas(int nb) throws SQLException {
//    List<Company> result = new ArrayList<>();
//    List<String> companys = new ArrayList<String>();
//
//    int i = 0;
//    while (i < nb) {
//      String ent = faker.company().name();
//      if (!companys.contains(ent)) {
//        companys.add(ent);
//
//        Company company = new Company(ent, ent + faker.address().city(),
//            faker.number().digits(14), faker.letterify(faker.number().digits(4) + "?"));
//        result.add(company);
//
//        i++;
//      }
//    }
//    return result;
//  }
//
//  /**
//   * Generate and insert datas.
//   *
//   */
//  public void generateAndInsertDatas() throws SQLException {
//    generateAndInsertDatas(faker.random().nextInt(100));
//  }
//
//  /**
//   * Generate and insert n datas.
//   *
//   * @param nb = the number
//   */
//  public void generateAndInsertDatas(int nb) throws SQLException {
//    for (Company company : generateDatas(nb)) {
//      DbManager.getInstance().getCompanyDao().insert(company);
//      System.out.println(company);
//      datas.add(company);
//    }
//  }
//
//  /**
//   * Drop, create table, generate and insert datas.
//   *
//   */
//  public void generateAndInsertDatasDroppingTable() throws SQLException {
//    generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
//  }
//
//  /**
//   * Drop, create table, generate and insert n data.
//   *
//   * @param nb = the number
//   */
//  public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
//    ConsoleLogger generatedLogger = new ConsoleLogger("Company generated data tests",
//        Options.DEBUG);
//    generatedLogger.Log("Lancement des tests de données générées.", Options.DEBUG);
//
//    DbManager.getInstance().getCompanyDao().drop();
//    DbManager.getInstance().getCompanyDao().create();
//
//    generateAndInsertDatas(nb);
//
//    generatedLogger.Log("Fin des tests de données générées.", Options.DEBUG);
//  }
//
//  /**
//   * delete datas.
//   */
//  public void deleteDatas() {
//    for (Company company : datas) {
//      DbManager.getInstance().getCompanyDao().delete(company);
//    }
//  }
//}
