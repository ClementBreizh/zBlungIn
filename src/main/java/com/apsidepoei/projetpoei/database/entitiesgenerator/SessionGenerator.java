package com.apsidepoei.projetpoei.database.entitiesgenerator;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Session;
import com.github.javafaker.Faker;

/**
 * 
 * @author benjamin-m
 *
 */
public class SessionGenerator {

  private SessionGenerator() {
  }

  private static SessionGenerator INSTANCE = null;

  /**
   *
   * @return an instance of the constructor
   */
  public static SessionGenerator getInstance() {
    if (INSTANCE == null) {
      synchronized (SessionGenerator.class) {
        if (INSTANCE == null) {
          INSTANCE = new SessionGenerator();
        }
      }
    }
    return INSTANCE;
  }

  Faker faker = new Faker(Locale.FRENCH);
  private List<Session> datas = new ArrayList<Session>();

  /**
   *
   * @return
   * @throws SQLException Generate fake data
   * @throws ParseException
   */
  public List<Session> generateDatas() throws SQLException, ParseException {
    return generateDatas(faker.random().nextInt(100));
  }

  /**
   *
   * @param nb
   * @return
   * @throws SQLException Generate n fake data
   * @throws ParseException
   */
  public List<Session> generateDatas(int nb) throws SQLException, ParseException {
    List<Session> result = new ArrayList<>();


    for (int i = 0; i < nb; i++) {
      Session session = new Session(faker.name().title(), new SimpleDateFormat("yyyy/mm/dd").parse("2019/06/15"), new SimpleDateFormat("yyyy/mm/dd").parse("2019/10/02"));
      result.add(session);
    }

    return result;
  }

  /**
   *
   * @throws SQLException Generate and insert datas
   * @throws ParseException
   */
  public void generateAndInsertDatas() throws SQLException, ParseException {
    generateAndInsertDatas(faker.random().nextInt(100));
  }

  /**
   *
   * @param nb
   * @throws SQLException Generate and insert n datas
   * @throws ParseException
   */
  public void generateAndInsertDatas(int nb) throws SQLException, ParseException {
    for (Session session : generateDatas(nb)) {
      DbManager.getInstance().getSessionDao().insert(session);
      System.out.println(session);
      datas.add(session);
    }
  }

  /**
   *
   * @throws SQLException Drop, create table, generate and insert datas
   * @throws ParseException
   */
  public void generateAndInsertDatasDroppingTable() throws SQLException, ParseException {
    generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
  }

  /**
   *
   * @param nb
   * @throws SQLException Drop, create table, generate and insert n data
   * @throws ParseException
   */
  public void generateAndInsertDatasDroppingTable(int nb) throws SQLException, ParseException {
    DbManager.getInstance().getSessionDao().drop();
    DbManager.getInstance().getSessionDao().create();

    generateAndInsertDatas(nb);
  }

  /**
   * delete datas
   */
  public void deleteDatas() {
    for (Session session : datas) {
      DbManager.getInstance().getSessionDao().delete(session);
    }
  }
}