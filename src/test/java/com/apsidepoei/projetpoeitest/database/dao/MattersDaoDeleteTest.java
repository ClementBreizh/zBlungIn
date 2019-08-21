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
import com.apsidepoei.projetpoei.entities.Matters;

/** Test DELETE function on database */
public class MattersDaoDeleteTest {

    @Before
    /** drop et create avant les tests pour eviter conflits */
    public void dropCreate() {
        DbManager.getInstance().getMattersDao().drop();
        DbManager.getInstance().getMattersDao().create();
    }

    @Test
    /** test delete d'une entrée dans les DB */
    public void testMattersDaoDeleteSimple() throws SQLException, ParseException {
        Matters matters = new Matters("Matters1");
        DbManager.getInstance().getMattersDao().insert(matters);

        matters.setId(1);
        DbManager.getInstance().getMattersDao().delete(matters);

        assertNull(DbManager.getInstance().getMattersDao().select(1));
    }

    @Test
    /** test delete mulitple */
    public void testMattersDaoDeleteMultiple2() throws SQLException, ParseException {
        boolean statut = false;

        for (int i = 17; i <= 102; i += 17) {
            Matters matters = new Matters("Matters" + i);
            matters.setId(i);
            DbManager.getInstance().getMattersDao().insert(matters);

            if (i == 51) {
                DbManager.getInstance().getMattersDao().delete(matters);
            }
        }

        for (int i = 17; i <= 102; i += 17) {
            if (i == 51 && DbManager.getInstance().getMattersDao().select(i) == null) {
                statut = true;
            }
        }

        assertTrue(statut);
    }

    @Test
    public void testMattersDaoDeleteNullMultiple() throws SQLException, ParseException {
        int statut = 0;

        for (int i = 17; i <= 102; i += 17) {
            Matters matters = new Matters("Matters" + i);
            matters.setId(i);
            DbManager.getInstance().getMattersDao().insert(matters);

            if (i == 102) {
              DbManager.getInstance().getMattersDao().delete(matters);
              statut = DbManager.getInstance().getMattersDao().delete(matters);
            }
        }

        assertEquals(0, statut);
    }

    @AfterClass
    public static void dropAfter() {
        DbManager.getInstance().getMattersDao().drop();
        DbManager.getInstance().getMattersDao().create();
    }
}

