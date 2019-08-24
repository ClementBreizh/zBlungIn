package com.apsidepoei.projetpoei.database.entitiesgenerator;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Appointment;
import com.github.javafaker.Faker;
import com.tactfactory.consolelogger.ConsoleLogger;
import com.tactfactory.consolelogger.Options;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * This class generate fake data.
 * @author thomas
 */
public class AppointmentGenerator {
  private AppointmentGenerator() {
  }

  private static AppointmentGenerator INSTANCE = null;

  /**
   * An instance of the constructor.
   * @return
   */

  public static AppointmentGenerator getInstance() {
    if (INSTANCE == null) {
      synchronized (AppointmentGenerator.class) {
        if (INSTANCE == null) {
          INSTANCE = new AppointmentGenerator();
        }
      }
    }
    return INSTANCE;
  }

  Faker faker = new Faker(Locale.FRENCH);
  private List<Appointment> datas = new ArrayList<Appointment>();

  /**
   * @return
   */
  public List<Appointment> generateDatas() throws SQLException, ParseException {
    return generateDatas(faker.random().nextInt(100));
  }

  /**
   * Generate n fake data.
   * @param nb = number
   * @return
   */
  public List<Appointment> generateDatas(int nb) throws SQLException, ParseException {
    List<Appointment> result = new ArrayList<>();

    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final Date mySqlDate = sdf.parse("2019-08-22 02:05:00");

    for (int i = 0; i < nb; i++) {
      Appointment appointment = new Appointment(faker.lorem().sentence(), mySqlDate,
          faker.lorem().sentence(4));
      result.add(appointment);
    }

    return result;
  }

  /**
   * Generate and insert datas.
   * @throws SQLException = exception
   */
  public void generateAndInsertDatas() throws SQLException, ParseException {
    generateAndInsertDatas(faker.random().nextInt(100));
  }

  /**
   * Generate and insert n datas.
   * @param nb = number
   * @throws SQLException = exception
   * @throws ParseException = exception
   */
  public void generateAndInsertDatas(int nb) throws SQLException, ParseException {
    for (Appointment appointment : generateDatas(nb)) {
      DbManager.getInstance().getAppointmentDao().insert(appointment);
      System.out.println(appointment);
      datas.add(appointment);
    }
  }

  /**
   * Drop, create table, generate and insert datas.
   * @throws SQLException = exception
   * @throws ParseException = exception
   */
  public void generateAndInsertDatasDroppingTable() throws SQLException, ParseException {
    generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
  }

  /**
   * Drop, create table, generate and insert n data.
   * @param nb = number
   * @throws SQLException = exception
   * @throws ParseException = exception
   */
  public void generateAndInsertDatasDroppingTable(int nb) throws SQLException, ParseException {
    ConsoleLogger generatedLogger = new ConsoleLogger("Appointment generated data tests",
        Options.DEBUG);
    generatedLogger.Log("Lancement des tests de données générées.", Options.DEBUG);

    DbManager.getInstance().getAppointmentDao().drop();
    DbManager.getInstance().getAppointmentDao().create();

    generateAndInsertDatas(nb);

    generatedLogger.Log("Fin des tests de données générées.", Options.DEBUG);
  }

  /**
   * delete datas.
   */
  public void deleteDatas() {
    for (Appointment appointment : datas) {
      DbManager.getInstance().getAppointmentDao().delete(appointment);
    }
  }
}
