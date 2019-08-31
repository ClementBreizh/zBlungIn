///**
// *
// */
//package com.apsidepoei.projetpoeitest.database.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//import java.sql.SQLException;
//import java.text.ParseException;
//
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Feedback;
//
///**
// * @author vianney
// *
// */
//public class FeedbackDaoDeleteTest {
//
//  @Before
//  public void dropCreate() {
//    DbManager.getInstance().getFeedbackDao().drop();
//    DbManager.getInstance().getFeedbackDao().create();
//  }
//
//  @Test
//  public void testFeedbackDaoDeleteSimple() throws SQLException, ParseException {
//    Feedback feedback = new Feedback("FeedbackTest", 123, "Commentaire de test");
//    DbManager.getInstance().getFeedbackDao().insert(feedback);
//
//    feedback.setId(1);
//    DbManager.getInstance().getFeedbackDao().delete(feedback);
//
//    assertNull(DbManager.getInstance().getFeedbackDao().select(1));
//  }
//
//  @Test
//  public void testFeedbackDaoDeleteMultiple() throws SQLException, ParseException {
//    boolean statut = false;
//
//    for (int i = 1; i <= 10; i++) {
//      Feedback feedback = new Feedback("Feedback" + i, i, "Commentaire" + i);
//      feedback.setId(i);
//      DbManager.getInstance().getFeedbackDao().insert(feedback);
//
//      if (i == 5) {
//        DbManager.getInstance().getFeedbackDao().delete(feedback);
//      }
//    }
//
//    for (int i = 1; i <= 10; i++) {
//      if (i == 5 && DbManager.getInstance().getFeedbackDao().select(i) == null) {
//        statut = true;
//      }
//    }
//
//    assertTrue(statut);
//  }
//
//  @Test
//  public void testFeedbackDaoDeleteMultiple2() throws SQLException, ParseException {
//    boolean statut = false;
//
//    for (int i = 17; i <= 102; i += 17) {
//      Feedback feedback = new Feedback("Feedback" + i, i, "Commentaire" + i);
//      feedback.setId(i);
//      DbManager.getInstance().getFeedbackDao().insert(feedback);
//
//      if (i == 51) {
//        DbManager.getInstance().getFeedbackDao().delete(feedback);
//      }
//    }
//
//    for (int i = 17; i <= 102; i += 17) {
//      if (i == 51 && DbManager.getInstance().getFeedbackDao().select(i) == null) {
//        statut = true;
//      }
//    }
//
//    assertTrue(statut);
//  }
//
//  @Test
//  public void testFeedbackDaoDeleteNullMultiple() throws SQLException, ParseException {
//    int statut = 0;
//
//    for (int i = 17; i <= 102; i += 17) {
//      Feedback feedback = new Feedback("Feedback" + i, i, "Commentaire" + i);
//      feedback.setId(i);
//      DbManager.getInstance().getFeedbackDao().insert(feedback);
//
//      if (i == 102) {
//        DbManager.getInstance().getFeedbackDao().delete(feedback);
//        statut = DbManager.getInstance().getFeedbackDao().delete(feedback);
//      }
//    }
//
//    assertEquals(0, statut);
//  }
//
//  @AfterClass
//  public static void dropAfter() {
//    DbManager.getInstance().getFeedbackDao().drop();
//    DbManager.getInstance().getFeedbackDao().create();
//  }
//}
