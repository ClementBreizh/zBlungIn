/**
 *
 */
package com.apsidepoei.projetpoei.database.entitiesgenerator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Address;
import com.github.javafaker.Faker;

/**
 * @author vianney This class generate fake data
 */
public class AddressGenerator {

  private AddressGenerator() {
  }

  private static AddressGenerator INSTANCE = null;

  /**
   *
   * @return an instance of the constructor
   */
  public static AddressGenerator getInstance() {
    if (INSTANCE == null) {
      synchronized (AddressGenerator.class) {
        if (INSTANCE == null) {
          INSTANCE = new AddressGenerator();
        }
      }
    }
    return INSTANCE;
  }

  Faker faker = new Faker(Locale.FRENCH);
  private List<Address> datas = new ArrayList<Address>();

  /**
   *
   * @return
   * @throws SQLException Generate fake data
   */
  public List<Address> generateDatas() throws SQLException {
    return generateDatas(faker.random().nextInt(100));
  }

  /**
   *
   * @param nb
   * @return
   * @throws SQLException Generate n fake data
   */
  public List<Address> generateDatas(int nb) throws SQLException {
    List<Address> result = new ArrayList<>();
    List<String> addresses = new ArrayList<String>();

    int i = 0;
    while (i < nb) {
      String postalAddress = faker.address().streetAddress();
      String postalCode = faker.address().zipCode();
      String town = faker.address().city();

      if (!addresses.contains(postalAddress)) {
        addresses.add(postalAddress);

        Address address = new Address(postalAddress, postalCode, town);
        result.add(address);

        i++;
      }
    }
    return result;
  }

  /**
   *
   * @throws SQLException Generate and insert datas
   */
  public void generateAndInsertDatas() throws SQLException {
    generateAndInsertDatas(faker.random().nextInt(100));
  }

  /**
   *
   * @param nb
   * @throws SQLException Generate and insert n datas
   */
  public void generateAndInsertDatas(int nb) throws SQLException {
    for (Address address : generateDatas(nb)) {
      DbManager.getInstance().getAddressDao().insert(address);
      System.out.println(address);
      datas.add(address);
    }
  }

  /**
   *
   * @throws SQLException Drop, create table, generate and insert datas
   */
  public void generateAndInsertDatasDroppingTable() throws SQLException {
    generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
  }

  /**
   *
   * @param nb
   * @throws SQLException Drop, create table, generate and insert n data
   */
  public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
    DbManager.getInstance().getAddressDao().drop();
    DbManager.getInstance().getAddressDao().create();

    generateAndInsertDatas(nb);
  }

  /**
   * delete datas
   */
  public void deleteDatas() {
    for (Address address : datas) {
      DbManager.getInstance().getAddressDao().delete(address);
    }
  }
}
