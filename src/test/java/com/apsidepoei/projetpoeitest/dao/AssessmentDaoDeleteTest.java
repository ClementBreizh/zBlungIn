package com.apsidepoei.projetpoeitest.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Assessment;

public class AssessmentDaoDeleteTest {

  @Before
  public void dropCreate() {
      DbManager.getInstance().getAssessmentDao().drop();
      DbManager.getInstance().getAssessmentDao().create();
  }

  @Test
  /** Test de DELETE d'une entrée via ID */
  public void testAssessmentDaoDeleteSimple() throws SQLException, ParseException {
      Assessment assessment = new Assessment("Ou est Charlie?", new SimpleDateFormat("yyyy/mm/dd").parse("1990/04/24"));
      DbManager.getInstance().getAssessmentDao().insert(assessment);

      assessment.setId(1);
      DbManager.getInstance().getAssessmentDao().delete(assessment);

      assertNull(DbManager.getInstance().getAssessmentDao().select(1));
  }

  @Test
 /** test de DELETE multiple */
  public void testAssessmentDaoDeleteMultiple() throws SQLException, ParseException {
      boolean statut = false;

      for (int i = 1; i <= 10; i++) {
          Assessment assessment = new Assessment("Test de reflexion", new SimpleDateFormat("yyyy/mm/dd").parse("1990/04/24"));
          assessment.setId(i);
          DbManager.getInstance().getAssessmentDao().insert(assessment);

          if (i == 5) {
              DbManager.getInstance().getAssessmentDao().delete(assessment);
          }
      }

      for (int i = 1; i <= 10; i++) {
          if (i == 5 && DbManager.getInstance().getAssessmentDao().select(i) == null) {
              statut = true;
          }
      }

      assertTrue(statut);
  }

  @Test
 /** Test de delete multiple */
  public void testAssessmentDaoDeleteMultiple2() throws SQLException, ParseException {
      boolean statut = false;

      for (int i = 17; i <= 102; i += 17) {
          Assessment assessment = new Assessment("QI", new SimpleDateFormat("yyyy/mm/dd").parse("2001/11/23"));
          assessment.setId(i);
          DbManager.getInstance().getAssessmentDao().insert(assessment);

          if (i == 51) {
              DbManager.getInstance().getAssessmentDao().delete(assessment);
          }
      }

      for (int i = 17; i <= 102; i += 17) {
          if (i == 51 && DbManager.getInstance().getAssessmentDao().select(i) == null) {
              statut = true;
          }
      }

      assertTrue(statut);
  }


  @AfterClass
  public static void dropAfter() {
      DbManager.getInstance().getAssessmentDao().drop();
      DbManager.getInstance().getAssessmentDao().create();
  }
}
