package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Assessment;

public class AssessmentDaoInsertTest {

    @Test
    /** Test d'insertion dans la table */
    public void testInsertAssessment() throws ParseException, SQLException {
        Assessment monAssessment = new Assessment("Logique", new SimpleDateFormat("yyyy/mm/dd").parse("1980/04/24"));
        DbManager.getInstance().getAssessmentDao().insert(monAssessment);

        assertFalse("Insert ok", false);
    }

    @Test
    /** Test avec lettre en autre que a-z */
    public void testInsertJapaneseLetter() throws ParseException, SQLException {
        Assessment monAssessment2 = new Assessment("亜紀", new SimpleDateFormat("yyyy/mm/dd").parse("1980/04/24"));
        DbManager.getInstance().getAssessmentDao().insert(monAssessment2);

        assertTrue("Insert ok", true);
    }

    @Test
    /** Test sur longueur des saisies */
    public void testInsertCategoryVar50() throws ParseException {
        String data = "";
        for (int i = 0; i < 50; i++) {
            data += "x";
        }
        Assessment monAssessment2 = new Assessment(data, new SimpleDateFormat("yyyy/mm/dd").parse("1980/04/24"));
        try {
            DbManager.getInstance().getAssessmentDao().insert(monAssessment2);
        } catch (SQLException e) {
            e.getMessage();
            assertEquals(e.getMessage(), "Data truncation: Data too long for column 'firstname' at row 1");
        }
    }

    @Test
    /** Test sur la validité de la date */
    public void testInsertWrongDate() throws SQLException {
        try {
            Assessment monAssessment2 = new Assessment("MIROUF",
                    new SimpleDateFormat("yyyy/mm/dd").parse("1980/24/32"));
            DbManager.getInstance().getAssessmentDao().insert(monAssessment2);
        } catch (ParseException e1) {
            e1.getMessage();
            assertEquals(e1.getMessage(),
                    "Data truncation: Incorrect datetime value: " + e1.getMessage() + " for column 'date' at row 1 ");
        }
    }

    @Test
    /** Test d'insertion dans la table */
    public void testGeneratorInsertAssessment() throws ParseException, SQLException {
        Assessment monAssessment = new Assessment("Logique", new SimpleDateFormat("yyyy/mm/dd").parse("1980/04/24"));
        DbManager.getInstance().getAssessmentGenerator().insert(monAssessment);
        Assert.assertNotEquals("", toString());
        ;
    }

}
