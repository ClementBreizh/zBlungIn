package com.apsidepoei.projetpoeitest.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Entreprise;


/**
 * 
 * @author benjamin-m
 *
 */
public class EntrepriseDaoSelectTest {

	static List<Entreprise> entreprises = new ArrayList<Entreprise>();

	/**
	 * Before the tests, create new data
	 */
    @BeforeClass
    public static void config() {
        Entreprise entreprise1 = new Entreprise("entreprise1", "antenne1", "53267126000018", "0000A");
        Entreprise entreprise2 = new Entreprise("entreprise2", "antenne1", "53267126000018", "0000A");
        Entreprise entreprise3 = new Entreprise("entreprise3", "antenne1", "53267126000018", "0000A");
        entreprise1.setId(1);
        entreprise2.setId(2);
        entreprise3.setId(3);
        entreprises.add(entreprise1);
        entreprises.add(entreprise2);
        entreprises.add(entreprise3);
    }

    /**
	 *
	 * @throws Exception
	 * Before each test, drop, create and insert new data
	 */
    @Before
    public void drop() throws Exception{
        DbManager.getInstance().getEntrepriseDao().drop();
        DbManager.getInstance().getEntrepriseDao().create();
        DbManager.getInstance().getEntrepriseDao().insert(entreprises.get(0));
        DbManager.getInstance().getEntrepriseDao().insert(entreprises.get(1));
        DbManager.getInstance().getEntrepriseDao().insert(entreprises.get(2));
    }

    /**
	 *
	 * @throws Exception
	 * Test to select all
	 */
    @Test
    public void selectAll() throws Exception {
        assertNotNull(DbManager.getInstance().getEntrepriseDao().select());
    }

    /**
	 *
	 * @throws Exception
	 * Test select all with a count
	 */
    @Test
    public void selectAllCount() throws Exception {
        List<Entreprise> listObjects = DbManager.getInstance().getEntrepriseDao().select();
        DbManager.getInstance().getEntrepriseDao().select();
        assertEquals(3, listObjects.size());
    }

    /**
	 *
	 * @throws Exception
	 * Test the data compare
	 */
    @Test
    public void dataCompare() throws Exception {
        List<Entreprise> listObjects = DbManager.getInstance().getEntrepriseDao().select();

        assertTrue((entreprises.get(0).getId() == ((Entreprise)listObjects.get(0)).getId()) && (entreprises.get(0).getNom().equals(((Entreprise)listObjects.get(0)).getNom())));
    }

}
