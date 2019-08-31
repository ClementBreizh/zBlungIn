//package com.apsidepoei.projetpoeitest.database.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Matter;
//import java.sql.SQLException;
//import java.text.ParseException;
//
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.Test;
//
///** Test DELETE function on database. */
//public class MatterDaoDeleteTest {
//
//  @Before
//  /** Drop and create for clean test. */
//  public void dropCreate() {
//    DbManager.getInstance().getMatterDao().drop();
//    DbManager.getInstance().getMatterDao().create();
//  }
//
//  @Test
//  /** Test for delete a data. */
//  public void testMatterDaoDeleteSimple() throws SQLException, ParseException {
//    Matter matters = new Matter("Matter1");
//    DbManager.getInstance().getMatterDao().insert(matters);
//
//    matters.setId(1);
//    DbManager.getInstance().getMatterDao().delete(matters);
//
//    assertNull(DbManager.getInstance().getMatterDao().select(1));
//  }
//
//  @Test
//  /** test delete mulitple. */
//  public void testMatterDaoDeleteMultiple2() throws SQLException, ParseException {
//    boolean statut = false;
//
//    for (int i = 17; i <= 102; i += 17) {
//      Matter matters = new Matter("Matter" + i);
//      matters.setId(i);
//      DbManager.getInstance().getMatterDao().insert(matters);
//
//      if (i == 51) {
//        DbManager.getInstance().getMatterDao().delete(matters);
//      }
//    }
//
//    for (int i = 17; i <= 102; i += 17) {
//      if (i == 51 && DbManager.getInstance().getMatterDao().select(i) == null) {
//        statut = true;
//      }
//    }
//
//    assertTrue(statut);
//  }
//
//  @Test
//  /**
//   * Test Delete a null data.
//   */
//  public void testMatterDaoDeleteNullMultiple() throws SQLException, ParseException {
//    int statut = 0;
//
//    for (int i = 17; i <= 102; i += 17) {
//      Matter matters = new Matter("Matter" + i);
//      matters.setId(i);
//      DbManager.getInstance().getMatterDao().insert(matters);
//
//      if (i == 102) {
//        DbManager.getInstance().getMatterDao().delete(matters);
//        statut = DbManager.getInstance().getMatterDao().delete(matters);
//      }
//    }
//
//    assertEquals(0, statut);
//  }
//
//  @AfterClass
//  public static void dropAfter() {
//    DbManager.getInstance().getMatterDao().drop();
//    DbManager.getInstance().getMatterDao().create();
//  }
//}
