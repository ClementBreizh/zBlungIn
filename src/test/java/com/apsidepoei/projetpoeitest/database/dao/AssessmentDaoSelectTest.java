package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Assessment;

/**
 * @author clement
 */
public class AssessmentDaoSelectTest {

    static List<Assessment> assessments = new ArrayList<Assessment>();

    @BeforeClass
    public static void config() throws ParseException {

        Assessment assessment1 = new Assessment("Rorchard", new SimpleDateFormat("yyyy/MM/dd").parse("1999/12/31"));
        Assessment assessment2 = new Assessment("Rorcha", new SimpleDateFormat("yyyy/MM/dd").parse("1989/02/25"));
        Assessment assessment3 = new Assessment("Rorrd", new SimpleDateFormat("yyyy/MM/dd").parse("1998/11/12"));
        assessment1.setId(1);
        assessment2.setId(2);
        assessment3.setId(3);
        assessments.add(assessment1);
        assessments.add(assessment2);
        assessments.add(assessment3);
    }

    @Before
    public void drop() throws Exception {
        DbManager.getInstance().getAssessmentDao().drop();
        DbManager.getInstance().getAssessmentDao().create();
        DbManager.getInstance().getAssessmentDao().insert(assessments.get(0));
        DbManager.getInstance().getAssessmentDao().insert(assessments.get(1));
        DbManager.getInstance().getAssessmentDao().insert(assessments.get(2));
    }

    /**
     *  Test SelectAll.
     */
    @Test
    public void selectAll() throws Exception {
        assertNotNull(DbManager.getInstance().getAssessmentDao().select());
    }

    @Test
    /**
     * Test SelectAll with counter.
     */
    public void selectAllCount() throws Exception {
        List<Assessment> listObjects = DbManager.getInstance().getAssessmentDao().select();
        DbManager.getInstance().getAssessmentDao().select();
        assertEquals(3, listObjects.size());
    }

    /**
     *Test data compared with already registred data.
     */
    @Test
    public void dataCompare() throws Exception {
        List<Assessment> listObjects = DbManager.getInstance().getAssessmentDao().select();

        assertTrue((assessments.get(0).getId() == (listObjects.get(0).getId())
                && (assessments.get(0).getCategory().equals(listObjects.get(0).getCategory())
                        && (assessments.get(0).getDateTime().equals(listObjects.get(0).getDateTime())))));
    }
}
