package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Entreprise;

/**
 * 
 * @author benjamin-m
 *
 */
public class EntrepriseDaoDeleteTest {
	/**
	 * Drop and create the table before each test
	 */
	@Before
    public void dropCreate() {
        DbManager.getInstance().getEntrepriseDao().drop();
        DbManager.getInstance().getEntrepriseDao().create();
    }

	/**
	 *
	 * @throws SQLException
	 * @throws ParseException
	 * Test simple delete
	 */
    @Test
    public void testEntrepriseDaoDeleteSimple() throws SQLException, ParseException {
    	Entreprise entreprise = new Entreprise("entreprise1", "antenne1", "53267126000018", "0000A");
        DbManager.getInstance().getEntrepriseDao().insert(entreprise);

        entreprise.setId(1);
        DbManager.getInstance().getEntrepriseDao().delete(entreprise);

        assertNull(DbManager.getInstance().getEntrepriseDao().select(1));
    }

    /**
	 *
	 * @throws SQLException
	 * @throws ParseException
	 * Test multiple delete
	 */
    @Test
    public void testEntrepriseDaoDeleteMultiple2() throws SQLException, ParseException {
        boolean statut = false;

        for (int i = 17; i <= 102; i += 17) {
            Entreprise entreprise = new Entreprise("entreprise" + i, "antenne" + i, "53267126000018", "0000A");
            entreprise.setId(i);
            DbManager.getInstance().getEntrepriseDao().insert(entreprise);

            if (i == 51) {
                DbManager.getInstance().getEntrepriseDao().delete(entreprise);
            }
        }

        for (int i = 17; i <= 102; i += 17) {
            if (i == 51 && DbManager.getInstance().getEntrepriseDao().select(i) == null) {
                statut = true;
            }
        }

        assertTrue(statut);
    }

    /**
	 *
	 * @throws SQLException
	 * @throws ParseException
	 * Test mutliple delete
	 */
    @Test
    public void testEntrepriseDaoDeleteNullMultiple() throws SQLException, ParseException {
        int statut = 0;

        for (int i = 17; i <= 102; i += 17) {
            Entreprise entreprise = new Entreprise("entreprise" + i, "antenne" + i, "53267126000018", "0000A");
            entreprise.setId(i);
            DbManager.getInstance().getEntrepriseDao().insert(entreprise);

            if (i == 102) {
              DbManager.getInstance().getEntrepriseDao().delete(entreprise);
              statut = DbManager.getInstance().getEntrepriseDao().delete(entreprise);
            }
        }

        assertEquals(0, statut);
    }

    /**
	 * After all test, drop and create the table
	 */
    @AfterClass
    public static void dropAfter() {
        DbManager.getInstance().getEntrepriseDao().drop();
        DbManager.getInstance().getEntrepriseDao().create();
    }
}
