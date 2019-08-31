//package com.apsidepoei.projetpoeitest.database.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Assessment;
//import com.mysql.jdbc.MysqlDataTruncation;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import org.junit.Before;
//import org.junit.Test;
//
//public class AssessmentDaoUpdateTest {
//
//  private static final String CHANGED_CATEGORY = "toto";
//  private List<Assessment> assessments = new ArrayList<Assessment>();
//
//  /**
//   * Before each test, drop & create the table and add / insert new assessments.
//   */
//  @Before
//  public void setupTests() throws SQLException, ParseException {
//    DbManager.getInstance().getAssessmentDao().drop();
//    DbManager.getInstance().getAssessmentDao().create();
//
//    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    Date mySqlDate = sdf.parse("2019-08-20 02:05:00");
//
//    assessments.clear();
//    assessments.add(new Assessment(1, "Category 1", mySqlDate));
//    assessments.add(new Assessment(2, "Category 2", mySqlDate));
//    assessments.add(new Assessment(3, "Category 3", mySqlDate));
//
//    for (Assessment assessment : assessments) {
//      DbManager.getInstance().getAssessmentDao().insert(assessment);
//    }
//  }
//
//  /**
//   * Compare name modification with the update.
//   */
//  @Test
//  public void simpleUpdateCompareCategory1() throws SQLException {
//    Assessment assessment = assessments.get(0);
//    assessment.setCategory(CHANGED_CATEGORY);
//
//    Assessment dbAssessment = (Assessment) DbManager.getInstance().getAssessmentDao().select(1);
//    DbManager.getInstance().getAssessmentDao().update(assessment);
//    Assessment dbAssessmentUpdated = (Assessment)
//        DbManager.getInstance().getAssessmentDao().select(1);
//
//    assertTrue(dbAssessment.getId() == dbAssessmentUpdated.getId()
//        && !dbAssessment.getCategory().equals(dbAssessmentUpdated.getCategory())
//        && dbAssessmentUpdated.getCategory().equals(CHANGED_CATEGORY));
//  }
//
//  /**
//   * Compare name modification with the update.
//   */
//  @Test
//  public void simpleUpdateCompareCategory2() throws SQLException {
//    Assessment assessment = assessments.get(0);
//    assessment.setCategory(CHANGED_CATEGORY);
//
//    DbManager.getInstance().getAssessmentDao().update(assessment);
//    Assessment dbAssessmentUpdated = (Assessment)
//        DbManager.getInstance().getAssessmentDao().select(1);
//
//    assertTrue(assessment.getId() == dbAssessmentUpdated.getId()
//        && assessment.getCategory().equals(dbAssessmentUpdated.getCategory()));
//  }
//
//  /**
//   * Compare the name modification with the update.
//   */
//  @Test
//  public void simpleUpdateCompareCategory3() {
//    Assessment assessment = assessments.get(0);
//    Assessment dbAssessment = (Assessment) DbManager.getInstance().getAssessmentDao().select(1);
//
//    assertTrue(
//        assessment.getId() == dbAssessment.getId()
//        && assessment.getCategory().equals(dbAssessment.getCategory()));
//  }
//
//  /**
//   * Compare level modification with the update.
//   */
//  @Test
//  public void simpleUpdateCompareDate1() throws SQLException, ParseException {
//    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    final Date changed_datetime =
//        sdf.parse("2019-08-22 02:05:00");
//
//    Assessment assessment = assessments.get(0);
//    assessment.setDateTime(changed_datetime);
//
//    Assessment dbAssessment = (Assessment) DbManager.getInstance().getAssessmentDao().select(1);
//    DbManager.getInstance().getAssessmentDao().update(assessment);
//    Assessment dbAssessmentUpdated = (Assessment)
//        DbManager.getInstance().getAssessmentDao().select(1);
//
//    assertFalse(dbAssessment.getId() == dbAssessmentUpdated.getId()
//        && !dbAssessment.getDateTime().equals(dbAssessmentUpdated.getDateTime())
//        && dbAssessmentUpdated.getDateTime().equals(changed_datetime));
//  }
//
//  /**
//   * Compare level modification with the update.
//   */
//  @Test
//  public void simpleUpdateCompareDate2() throws SQLException, ParseException {
//    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    final Date changed_datetime =
//        sdf.parse("2019-08-20 02:05:00");
//
//    Assessment assessment = assessments.get(0);
//    assessment.setDateTime(changed_datetime);
//
//    DbManager.getInstance().getAssessmentDao().update(assessment);
//    Assessment dbAssessmentUpdated = (Assessment)
//        DbManager.getInstance().getAssessmentDao().select(1);
//
//    assertFalse(assessment.getId() == dbAssessmentUpdated.getId()
//        && assessment.getDateTime().equals(dbAssessmentUpdated.getDateTime()));
//  }
//
//  /**
//   * Compare the level modification with the update.
//   */
//  @Test
//  public void simpleUpdateCompareDate3() {
//    Assessment assessment = assessments.get(0);
//    Assessment dbAssessment = (Assessment) DbManager.getInstance().getAssessmentDao().select(1);
//
//    assertFalse(
//        assessment.getId() == dbAssessment.getId()
//        && assessment.getDateTime().equals(dbAssessment.getDateTime()));
//  }
//
//  /**
//   * Test if data is truncated when update is too long.
//   */
//  @Test(expected = MysqlDataTruncation.class)
//  public void updateMaxValCategoryExtended() throws SQLException {
//    Assessment assessment = assessments.get(0);
//
//    StringBuilder data = new StringBuilder();
//    for (int i = 0; i < 256; i++) {
//      data.append("x");
//    }
//    assessment.setCategory(data.toString());
//
//    DbManager.getInstance().getAssessmentDao().update(assessment);
//  }
//
//  /**
//   * Test update with the max size for the data.
//   */
//  @Test(expected = MysqlDataTruncation.class)
//  public void updateMaxValCategoryOK() throws SQLException {
//    Assessment assessment = assessments.get(0);
//
//    StringBuilder data = new StringBuilder();
//    for (int i = 0; i < 255; i++) {
//      data.append("x");
//    }
//    assessment.setCategory(data.toString());
//
//    DbManager.getInstance().getAssessmentDao().update(assessment);
//
//    assertTrue(DbManager.getInstance().getAssessmentDao().update(assessment) == 1);
//  }
//
//  /**
//   * Test the update with the min size of the value.
//   */
//  @Test
//  public void updateMinValCategoryOK() throws SQLException {
//    Assessment assessment = assessments.get(0);
//    assessment.setCategory("");
//
//    DbManager.getInstance().getAssessmentDao().update(assessment);
//
//    assertTrue(DbManager.getInstance().getAssessmentDao().update(assessment) == 1);
//  }
//
//  /**
//   * Test the update with null value.
//   */
//  @Test(expected = MySQLIntegrityConstraintViolationException.class)
//  public void updateNullValCategoryKO() throws SQLException {
//    Assessment assessment = assessments.get(0);
//    assessment.setCategory(null);
//
//    DbManager.getInstance().getAssessmentDao().update(assessment);
//
//    assertTrue(DbManager.getInstance().getAssessmentDao().update(assessment) == 1);
//
//  }
//
//  /**
//   * Test if data is truncated when update is too long.
//   */
//  @Test(expected = MysqlDataTruncation.class)
//  public void updateMaxValReportExtended() throws SQLException {
//    Assessment assessment = assessments.get(0);
//
//    StringBuilder data = new StringBuilder();
//    for (int i = 0; i < 256; i++) {
//      data.append("x");
//    }
//    assessment.setCategory(data.toString());
//
//    DbManager.getInstance().getAssessmentDao().update(assessment);
//  }
//
//  /**
//   * Test the update with the wrong id.
//   */
//  @Test
//  public void updateCategoryWrongId() throws SQLException {
//    Assessment assessment = assessments.get(0);
//    assessment.setId(4);
//    assessment.setCategory(CHANGED_CATEGORY);
//
//    assertEquals(new Integer(0), DbManager.getInstance().getAssessmentDao().update(assessment));
//  }
//
//  /**
//   * Test the update with the wrong id.
//   */
//  @Test
//  public void updateDateTimeWrongId() throws SQLException, ParseException {
//    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    final Date changed_datetime =
//        sdf.parse("2019-08-20 02:05:00");
//
//    Assessment assessment = assessments.get(0);
//    assessment.setId(4);
//    assessment.setDateTime(changed_datetime);
//
//    assertEquals(new Integer(0), DbManager.getInstance().getAssessmentDao().update(assessment));
//  }
//
//  /**
//   * Test the update with the good id.
//   */
//  @Test
//  public void updateCategoryGoodId() throws SQLException {
//    Assessment assessment = assessments.get(0);
//    assessment.setCategory(CHANGED_CATEGORY);
//
//    assertEquals(new Integer(1), DbManager.getInstance().getAssessmentDao().update(assessment));
//  }
//
//  /**
//   * Test the update with the good id.
//   */
//  @Test
//  public void updateDateTimeGoodId() throws SQLException, ParseException {
//    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    final Date changed_datetime =
//        sdf.parse("2019-08-20 02:05:00");
//
//    Assessment assessment = assessments.get(0);
//    assessment.setDateTime(changed_datetime);
//
//    assertEquals(new Integer(1), DbManager.getInstance().getAssessmentDao().update(assessment));
//  }
//
//}
