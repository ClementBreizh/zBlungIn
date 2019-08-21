//package com.apsidepoei.projetpoeitest.dao;
//
//import static org.junit.Assert.assertNotNull;
//
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//
//
//public class AssessmentDaoTestBySelectId {
//
// @BeforeClass
//		 DbManager.getInstance().getAssessmentDao().drop();
//        DbManager.getInstance().getAssessmentDao().create();
//
//    @Test
// 		/** test de selection par ID */
//    public void testGetSelectId() {
//        assertNotNull(DbManager.getInstance().getTestDao().select(1));
//    }
//
//   @Test
//		/** test selection multiple */
//    public static void testSelectIdMultiple() throws SQLException, ParseException {
//
//        for (int i = 1; i <= 10; i++) {
//        	Assessment assessment = new Assessment("Rorchard" + i, new SimpleDateFormat("yyyy/mm/dd").parse("1999/12/31"));
//        	Assessment.setId(i);
//            DbManager.getInstance().getAssessmentDao().insert(assessment);
//        }
//    }
//
//    @Test
//		/** Test de selection valide */
//    public void testSelectIdTrue() {
//        boolean isOk = false;
//        Assessment assessment = (Assessment) DbManager.getInstance().getAssessmentDao().select(1);
//        isOk = assessment.getCategory().equals("Rorchard");
//        System.out.println(isOk);
//        System.out.println(Test.getCategory());
//    }
//
//
//    @Test
//		/** Test de selection invalide */
//    public void  testSelectIdFalse() {
//        boolean isNotOk = true;
//        Assessment assessment = (Assessment) DbManager.getInstance().getAssessmentDao().select(1);
//        isNotOk = assessment.getCategory().equals("Casimir");
//        isNotOk = isNotOk && assessment.getCategory().equals("Calimero");
//        System.out.println(isNotOk);
//    }
//}
//
