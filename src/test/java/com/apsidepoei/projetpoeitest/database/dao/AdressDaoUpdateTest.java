///**
// *
// */
//package com.apsidepoei.projetpoeitest.database.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Address;
//import com.mysql.jdbc.MysqlDataTruncation;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
//
///**
// * @author vianney
// *
// */
//public class AdressDaoUpdateTest {
//
//  private static final String CHANGED_DATA = "toto";
//  private List<Address> addresses = new ArrayList<Address>();
//
//  /**
//   *
//   * @throws SQLException Before each test, drop & create the table and add /
//   *                      insert new addresses
//   */
//  @Before
//  public void setupTests() throws SQLException {
//    DbManager.getInstance().getAddressDao().drop();
//    DbManager.getInstance().getAddressDao().create();
//
//    addresses.clear();
//    addresses.add(new Address("Adresse 1", "code1", "ville1"));
//    addresses.add(new Address("Adresse 2", "code2", "ville2"));
//    addresses.add(new Address("Adresse 3", "code3", "ville3"));
//
//    for (Address address : addresses) {
//      DbManager.getInstance().getAddressDao().insert(address);
//    }
//  }
//
//  // Simple compare update address
//  /**
//   *
//   * @throws SQLException Compare modification with the update
//   */
//  @Test
//  public void simpleUpdateCompareAddress1() throws SQLException {
//    Address address = addresses.get(0);
//    address.setAddress(CHANGED_DATA);
//
//    Address dbAddress = (Address) DbManager.getInstance().getAddressDao().select(1);
//    DbManager.getInstance().getAddressDao().update(address);
//    Address dbAddressUpdated = (Address) DbManager.getInstance().getAddressDao().select(1);
//
//    assertTrue(dbAddress.getId() == dbAddressUpdated.getId()
//        && !dbAddress.getAddress().equals(dbAddressUpdated.getAddress())
//        && dbAddressUpdated.getAddress().equals(CHANGED_DATA));
//  }
//
//  /**
//   *
//   * @throws SQLException Compare modification with the update
//   */
//  @Test
//  public void simpleUpdateCompareAddress2() throws SQLException {
//    Address address = addresses.get(0);
//    address.setAddress(CHANGED_DATA);
//
//    DbManager.getInstance().getAddressDao().update(address);
//    Address dbAddressUpdated = (Address) DbManager.getInstance().getAddressDao().select(1);
//
//    assertTrue(address.getId() == dbAddressUpdated.getId()
//        && address.getAddress().equals(dbAddressUpdated.getAddress()));
//  }
//
//  /**
//   * Compare the modification with the update
//   */
//  @Test
//  public void simpleUpdateCompareAddress3() {
//    Address address = addresses.get(0);
//    Address dbAddress = (Address) DbManager.getInstance().getAddressDao().select(1);
//
//    assertTrue(address.getId() == dbAddress.getId()
//        && address.getAddress().equals(dbAddress.getAddress()));
//  }
//
//  // Simple compare postalCode
//  /**
//   *
//   * @throws SQLException Compare modification with the update
//   */
//  @Test
//  public void simpleUpdateComparePostalCode1() throws SQLException {
//    Address address = addresses.get(0);
//    address.setPostalCode(CHANGED_DATA);
//
//    Address dbAddress = (Address) DbManager.getInstance().getAddressDao().select(1);
//    DbManager.getInstance().getAddressDao().update(address);
//    Address dbAddressUpdated = (Address) DbManager.getInstance().getAddressDao().select(1);
//
//    assertTrue(dbAddress.getId() == dbAddressUpdated.getId()
//        && !dbAddress.getPostalCode().equals(dbAddressUpdated.getPostalCode())
//        && dbAddressUpdated.getPostalCode().equals(CHANGED_DATA));
//  }
//
//  /**
//   *
//   * @throws SQLException Compare modification with the update
//   */
//  @Test
//  public void simpleUpdateComparePostalCode2() throws SQLException {
//    Address address = addresses.get(0);
//    address.setPostalCode(CHANGED_DATA);
//
//    DbManager.getInstance().getAddressDao().update(address);
//    Address dbAddressUpdated = (Address) DbManager.getInstance().getAddressDao().select(1);
//
//    assertTrue(address.getId() == dbAddressUpdated.getId()
//        && address.getPostalCode().equals(dbAddressUpdated.getPostalCode()));
//  }
//
//  /**
//   * Compare the modification with the update
//   */
//  @Test
//  public void simpleUpdateComparePostalCode3() {
//    Address address = addresses.get(0);
//    Address dbAddress = (Address) DbManager.getInstance().getAddressDao().select(1);
//
//    assertTrue(address.getId() == dbAddress.getId()
//        && address.getPostalCode().equals(dbAddress.getPostalCode()));
//  }
//
//  // Simple compare town
//  /**
//   *
//   * @throws SQLException Compare modification with the update
//   */
//  @Test
//  public void simpleUpdateCompareTown1() throws SQLException {
//    Address address = addresses.get(0);
//    address.setTown(CHANGED_DATA);
//
//    Address dbAddress = (Address) DbManager.getInstance().getAddressDao().select(1);
//    DbManager.getInstance().getAddressDao().update(address);
//    Address dbAddressUpdated = (Address) DbManager.getInstance().getAddressDao().select(1);
//
//    assertTrue(dbAddress.getId() == dbAddressUpdated.getId()
//        && !dbAddress.getTown().equals(dbAddressUpdated.getTown())
//        && dbAddressUpdated.getTown().equals(CHANGED_DATA));
//  }
//
//  /**
//   *
//   * @throws SQLException Compare modification with the update
//   */
//  @Test
//  public void simpleUpdateCompareTown2() throws SQLException {
//    Address address = addresses.get(0);
//    address.setTown(CHANGED_DATA);
//
//    DbManager.getInstance().getAddressDao().update(address);
//    Address dbAddressUpdated = (Address) DbManager.getInstance().getAddressDao().select(1);
//
//    assertTrue(address.getId() == dbAddressUpdated.getId()
//        && address.getTown().equals(dbAddressUpdated.getTown()));
//  }
//
//  /**
//   * Compare the modification with the update
//   */
//  @Test
//  public void simpleUpdateCompareTown3() {
//    Address address = addresses.get(0);
//    Address dbAddress = (Address) DbManager.getInstance().getAddressDao().select(1);
//
//    assertTrue(
//        address.getId() == dbAddress.getId() && address.getTown().equals(dbAddress.getTown()));
//  }
//
//// verifying the Max size of the fields
//
//  // veriying address
//  /**
//   *
//   * @throws SQLException Test if data is truncated when update is too long
//   */
//  @Test(expected = MysqlDataTruncation.class)
//  public void updateMaxValExtendedAddress() throws SQLException {
//    Address address = addresses.get(0);
//
//    StringBuilder data = new StringBuilder();
//    for (int i = 0; i < 256; i++) {
//      data.append("x");
//    }
//    address.setAddress(data.toString());
//
//    DbManager.getInstance().getAddressDao().update(address);
//  }
//
//  /**
//   *
//   * @throws SQLException Test if data is truncated when update is too long
//   */
//  @Test(expected = MysqlDataTruncation.class)
//  public void updateMaxValExtendedPostalCode() throws SQLException {
//    Address address = addresses.get(0);
//
//    StringBuilder data = new StringBuilder();
//    for (int i = 0; i < 6; i++) {
//      data.append("x");
//    }
//    address.setPostalCode(data.toString());
//
//    DbManager.getInstance().getAddressDao().update(address);
//  }
//
//  /**
//   *
//   * @throws SQLException Test if data is truncated when update is too long
//   */
//  @Test(expected = MysqlDataTruncation.class)
//  public void updateMaxValExtendedTown() throws SQLException {
//    Address address = addresses.get(0);
//
//    StringBuilder data = new StringBuilder();
//    for (int i = 0; i < 256; i++) {
//      data.append("x");
//    }
//    address.setTown(data.toString());
//
//    DbManager.getInstance().getAddressDao().update(address);
//  }
//
////verifying the Min size of the fields
//
//  /**
//   *
//   * @throws SQLException Test the update with the min size of the value
//   */
//  @Test
//  public void updateMinValOKAddress() throws SQLException {
//    Address address = addresses.get(0);
//    address.setAddress("");
//
//    DbManager.getInstance().getAddressDao().update(address);
//  }
//
//  /**
//   *
//   * @throws SQLException Test the update with the min size of the value
//   */
//  @Test
//  public void updateMinValOKPostalCode() throws SQLException {
//    Address address = addresses.get(0);
//    address.setPostalCode("");
//
//    DbManager.getInstance().getAddressDao().update(address);
//  }
//
//  /**
//   *
//   * @throws SQLException Test the update with the min size of the value
//   */
//  @Test
//  public void updateMinValOKTown() throws SQLException {
//    Address address = addresses.get(0);
//    address.setTown("");
//
//    DbManager.getInstance().getAddressDao().update(address);
//  }
//
//  // verifying with null value
//  /**
//   *
//   * @throws SQLException Test the update with null value
//   */
//  @Test(expected = MySQLIntegrityConstraintViolationException.class)
//  public void updateNullValKOAddress() throws SQLException {
//    Address address = addresses.get(0);
//    address.setAddress(null);
//
//    DbManager.getInstance().getAddressDao().update(address);
//  }
//
//  /**
//   *
//   * @throws SQLException Test the update with null value
//   */
//  @Test(expected = MySQLIntegrityConstraintViolationException.class)
//  public void updateNullValKOPostalCode() throws SQLException {
//    Address address = addresses.get(0);
//    address.setPostalCode(null);
//
//    DbManager.getInstance().getAddressDao().update(address);
//  }
//
//  /**
//   *
//   * @throws SQLException Test the update with null value
//   */
//  @Test(expected = MySQLIntegrityConstraintViolationException.class)
//  public void updateNullValKOTown() throws SQLException {
//    Address address = addresses.get(0);
//    address.setTown(null);
//
//    DbManager.getInstance().getAddressDao().update(address);
//  }
//
//  /**
//   * Test the update with the wrong id
//   *
//   * @throws SQLException
//   */
//  @Test
//  public void updateWrongId() throws SQLException {
//    Address address = addresses.get(0);
//    address.setId(4);
//    address.setAddress(CHANGED_DATA);
//
//    assertEquals(new Integer(0), DbManager.getInstance().getAddressDao().update(address));
//  }
//
//  /**
//   *
//   * @throws SQLException Test the update with the good id
//   */
//  @Test
//  public void updateGoodId() throws SQLException {
//    Address address = addresses.get(0);
//    address.setAddress(CHANGED_DATA);
//
//    assertEquals(new Integer(1), DbManager.getInstance().getAddressDao().update(address));
//  }
//}
