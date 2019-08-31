//package com.apsidepoei.projetpoeitest.database.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Company;
//
//import java.sql.SQLException;
//import java.text.ParseException;
//
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// * This class test the delete function of the dao.
// * @author benjamin-m
// *
// */
//public class CompanyDaoDeleteTest {
//  /**
//   * Drop and create the table before each test.
//   */
//  @Before
//  public void dropCreate() {
//    DbManager.getInstance().getCompanyDao().drop();
//    DbManager.getInstance().getCompanyDao().create();
//  }
//
//  /**
//   *Test simple delete.
//   * @throws SQLException
//   * @throws ParseException
//   */
//  @Test
//  public void testCompanyDaoDeleteSimple() throws SQLException, ParseException {
//    Company company = new Company("company1", "antenne1", "53267126000018", "0000A");
//    DbManager.getInstance().getCompanyDao().insert(company);
//
//    company.setId(1);
//    DbManager.getInstance().getCompanyDao().delete(company);
//
//    assertNull(DbManager.getInstance().getCompanyDao().select(1));
//  }
//
//  /**
//   *Test multiple delete.
//   * @throws SQLException
//   * @throws ParseException
//   */
//  @Test
//  public void testCompanyDaoDeleteMultiple2() throws SQLException, ParseException {
//    boolean statut = false;
//
//    for (int i = 17; i <= 102; i += 17) {
//      Company company = new Company("company" + i, "antenne" + i, "53267126000018",
//          "0000A");
//      company.setId(i);
//      DbManager.getInstance().getCompanyDao().insert(company);
//
//      if (i == 51) {
//        DbManager.getInstance().getCompanyDao().delete(company);
//      }
//    }
//
//    for (int i = 17; i <= 102; i += 17) {
//      if (i == 51 && DbManager.getInstance().getCompanyDao().select(i) == null) {
//        statut = true;
//      }
//    }
//
//    assertTrue(statut);
//  }
//
//  /**
//   *Test mutliple delete.
//   * @throws SQLException
//   * @throws ParseException
//   */
//  @Test
//  public void testCompanyDaoDeleteNullMultiple() throws SQLException, ParseException {
//    int statut = 0;
//
//    for (int i = 17; i <= 102; i += 17) {
//      Company company = new Company("company" + i, "antenne" + i, "53267126000018",
//          "0000A");
//      company.setId(i);
//      DbManager.getInstance().getCompanyDao().insert(company);
//
//      if (i == 102) {
//        DbManager.getInstance().getCompanyDao().delete(company);
//        statut = DbManager.getInstance().getCompanyDao().delete(company);
//      }
//    }
//
//    assertEquals(0, statut);
//  }
//
//  /**
//   * After all test, drop and create the table.
//   */
//  @AfterClass
//  public static void dropAfter() {
//    DbManager.getInstance().getCompanyDao().drop();
//    DbManager.getInstance().getCompanyDao().create();
//  }
//}
