///**
// *
// */
//package com.apsidepoei.projetpoeitest.database.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Address;
//
///**
// * @author vianney
// *
// */
//public class AddressDaoSelectTest {
//
//  static List<Address> addresses = new ArrayList<Address>();
//
//  @BeforeClass
//  public static void config() {
//    Address address1 = new Address("adress1", "code1", "ville1");
//    Address address2 = new Address("adress2", "code2", "ville2");
//    Address address3 = new Address("adress3", "code3", "ville3");
//    address1.setId(1);
//    address2.setId(2);
//    address3.setId(3);
//    addresses.add(address1);
//    addresses.add(address2);
//    addresses.add(address3);
//  }
//
//  @Before
//  public void drop() throws Exception {
//    DbManager.getInstance().getAddressDao().drop();
//    DbManager.getInstance().getAddressDao().create();
//    DbManager.getInstance().getAddressDao().insert(addresses.get(0));
//    DbManager.getInstance().getAddressDao().insert(addresses.get(1));
//    DbManager.getInstance().getAddressDao().insert(addresses.get(2));
//  }
//
//  @Test
//  public void selectAll() throws Exception {
//    assertNotNull(DbManager.getInstance().getAddressDao().select());
//  }
//
//  @Test
//  public void selectAllCount() throws Exception {
//    List<Address> listObjects = DbManager.getInstance().getAddressDao().select();
//    DbManager.getInstance().getAddressDao().select();
//    assertEquals(3, listObjects.size());
//  }
//
//  @Test
//  public void dataCompare() throws Exception {
//    List<Address> listObjects = DbManager.getInstance().getAddressDao().select();
//
//    assertTrue((addresses.get(0).getId() == (listObjects.get(0).getId())
//        && (addresses.get(0).getAddress().equals(listObjects.get(0).getAddress())
//            && (addresses.get(0).getPostalCode().equals(listObjects.get(0).getPostalCode())
//                && (addresses.get(0).getTown().equals(listObjects.get(0).getTown()))))));
//  }
//}
