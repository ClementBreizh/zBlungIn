//package com.apsidepoei.projetpoeitest.dao;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Assessment;
//import com.mysql.jdbc.MysqlDataTruncation;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
//
//public class AssessmentDaoUpdateTest {
//
//    private static final String CHANGED_DATA_CATEGORY = "Noel";
//    private static final String CHANGED_DATA_DATE = "2018-12-24";
//    private List<Assessment> assessments = new ArrayList<Assessment>();
//
//    @Before
//    public void setupAssessment() throws SQLException {
//        DbManager.getInstance().getAssessmentDao().drop();
//        DbManager.getInstance().getAssessmentDao().create();
//
//        assessments.clear();
//        assessments.add(new Assessment(1,"test1"));
//        assessments.add(new Assessment(2,"test2"));
//        assessments.add(new Assessment(3,"test3"));
//
//        for (Assessment assessment : assessments) {
//            DbManager.getInstance().getAssessmentDao().insert(assessment);
//        }
//    }
//
//    @Test
//    public void simpleUpdateCompare1() throws SQLException {
//    	Assessment assessment = assessments.get(0);
//    	assessment.setCategory(CHANGED_DATA_CATEGORY);
//
//    	Assessment dbAssessment = (Assessment)DbManager.getInstance().getAssessmentDao().select(1);
//        DbManager.getInstance().getAssessmentDao().update(assessment);
//        Assessment dbAssessmentUpdated = (Assessment)DbManager.getInstance().getAssessmentDao().select(1);
//
//        assertTrue(dbAssessment.getId() == dbAssessmentUpdated.getId() && !dbAssessment.getCategory().equals(dbAssessmentUpdated.getCategory()) && dbAssessmentUpdated.getCategory().equals(CHANGED_DATA_CATEGORY));
//    }
//
//    @Test
//    public void simpleUpdateCompare2() throws SQLException {
//    	Assessment assessment = assessments.get(0);
//    	assessment.setCategory(CHANGED_DATA_CATEGORY);
//
//        DbManager.getInstance().getAssessmentDao().update(assessment);
//        Assessment dbAssessmentUpdated = (Assessment)DbManager.getInstance().getAssessmentDao().select(1);
//
//        assertTrue(assessment.getId() == dbAssessmentUpdated.getId() && assessment.getCategory().equals(dbAssessmentUpdated.getCategory()));
//    }
//
//    @Test
//    public void simpleUpdateCompare3() {
//    	Assessment assessment = assessments.get(0);
//    	Assessment dbAssessment = (Assessment)DbManager.getInstance().getAssessmentDao().select(1);
//
//        assertTrue(assessment.getId() == dbAssessment.getId() && assessment.getCategory().equals(dbAssessment.getCategory()));
//    }
//
//    @Test(expected = MysqlDataTruncation.class)
//    public void updateMaxValExtended() throws SQLException {
//    	Assessment assessment = assessments.get(0);
//
//        StringBuilder data = new StringBuilder();
//        for (int i = 0; i < 50; i++) {
//            data.append("x");
//        }
//        assessment.setCategory(data.toString());
//
//        DbManager.getInstance().getAssessmentDao().update(assessment);
//    }
//
//    @Test
//    public void updateMaxValOK() throws SQLException {
//    	Assessment assessment = assessments.get(0);
//
//        StringBuilder data = new StringBuilder();
//        for (int i = 0; i < 50; i++) {
//            data.append("x");
//        }
//        assessment.setCategory(data.toString());
//
//        DbManager.getInstance().getAssessmentDao().update(assessment);
//    }
//
//    @Test
//    public void updateMinValOK() throws SQLException {
//    	Assessment assessment = assessments.get(0);
//    	Assessment.setCategory("");
//
//        DbManager.getInstance().getAssessmentDao().update(assessment);
//    }
//
//    @Test(expected = MySQLIntegrityConstraintViolationException.class)
//    public void updateNullValKO() throws SQLException {
//    	Assessment assessment = assessments.get(0);
//    	assessment.setCategory(null);
//
//        DbManager.getInstance().getAssessmentDao().update(assessment);
//    }
//
//    @Test
//    public void updateWrongId() throws SQLException {
//    	Assessment assessment = assessments.get(0);
//    	assessment.setId(4);
//    	assessment.setCategory(CHANGED_DATA_CATEGORY);
//
//        assertEquals(new Integer(0), DbManager.getInstance().getAssessmentDao().update(assessment));
//    }
//
//    @Test
//    public void updateGoodId() throws SQLException {
//    	Assessment assessment = assessments.get(0);
//    	assessment.setCategory(CHANGED_DATA_CATEGORY);
//
//        assertEquals(new Integer(1), DbManager.getInstance().getAssessmentDao().update(assessment));
//    }
//}
