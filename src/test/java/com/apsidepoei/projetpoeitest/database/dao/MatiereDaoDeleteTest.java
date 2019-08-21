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
import com.apsidepoei.projetpoei.entities.Matiere;

/** Test DELETE function on database */
public class MatiereDaoDeleteTest {

    @Before
    /** drop et create avant les tests pour eviter conflits */
    public void dropCreate() {
        DbManager.getInstance().getMatiereDao().drop();
        DbManager.getInstance().getMatiereDao().create();
    }

    @Test
    /** test delete d'une entrée dans les DB */
    public void testMatiereDaoDeleteSimple() throws SQLException, ParseException {
        Matiere matiere = new Matiere("Matiere1");
        DbManager.getInstance().getMatiereDao().insert(matiere);

        matiere.setId(1);
        DbManager.getInstance().getMatiereDao().delete(matiere);

        assertNull(DbManager.getInstance().getMatiereDao().select(1));
    }

    @Test
    /** test delete mulitple */
    public void testMatiereDaoDeleteMultiple2() throws SQLException, ParseException {
        boolean statut = false;

        for (int i = 17; i <= 102; i += 17) {
            Matiere matiere = new Matiere("Matiere" + i);
            matiere.setId(i);
            DbManager.getInstance().getMatiereDao().insert(matiere);

            if (i == 51) {
                DbManager.getInstance().getMatiereDao().delete(matiere);
            }
        }

        for (int i = 17; i <= 102; i += 17) {
            if (i == 51 && DbManager.getInstance().getMatiereDao().select(i) == null) {
                statut = true;
            }
        }

        assertTrue(statut);
    }

    @Test
    public void testMatiereDaoDeleteNullMultiple() throws SQLException, ParseException {
        int statut = 0;

        for (int i = 17; i <= 102; i += 17) {
            Matiere matiere = new Matiere("Matiere" + i);
            matiere.setId(i);
            DbManager.getInstance().getMatiereDao().insert(matiere);

            if (i == 102) {
              DbManager.getInstance().getMatiereDao().delete(matiere);
              statut = DbManager.getInstance().getMatiereDao().delete(matiere);
            }
        }

        assertEquals(0, statut);
    }

    @AfterClass
    public static void dropAfter() {
        DbManager.getInstance().getMatiereDao().drop();
        DbManager.getInstance().getMatiereDao().create();
    }
}

