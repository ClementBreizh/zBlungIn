package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Entreprise;

/**
 * 
 * @author benjamin-m
 *
 */
public class EntrepriseDaoUpdateTest {

	private static final String CHANGED_DATA = "toto";
    private List<Entreprise> entreprises = new ArrayList<Entreprise>();

    /**
	 *
	 * @throws SQLException
	 * Before each test, drop & create the table and add / insert new business
	 */
    @Before
    public void setupTests() throws SQLException {
        DbManager.getInstance().getEntrepriseDao().drop();
        DbManager.getInstance().getEntrepriseDao().create();

        entreprises.clear();
        entreprises.add(new Entreprise(1, "entreprise1", "antenne1", "53267126000018", "0000A"));
        entreprises.add(new Entreprise(2, "entreprise2", "antenne1", "53267126000018", "0000A"));
        entreprises.add(new Entreprise(3, "entreprise3", "antenne1", "53267126000018", "0000A"));

        for (Entreprise entreprise : entreprises) {
            DbManager.getInstance().getEntrepriseDao().insert(entreprise);
        }
    }

    /**
	 *
	 * @throws SQLException
	 * Compare modification with the update
	 */
    @Test
    public void simpleUpdateCompare1() throws SQLException {
       Entreprise entreprise = entreprises.get(0);
        entreprise.setNom(CHANGED_DATA);

        Entreprise dbEntreprise = (Entreprise)DbManager.getInstance().getEntrepriseDao().select(1);
        DbManager.getInstance().getEntrepriseDao().update(entreprise);
        Entreprise dbEntrepriseUpdated = (Entreprise)DbManager.getInstance().getEntrepriseDao().select(1);

        assertTrue(dbEntreprise.getId() == dbEntrepriseUpdated.getId() && !dbEntreprise.getNom().equals(dbEntrepriseUpdated.getNom()) && dbEntrepriseUpdated.getNom().equals(CHANGED_DATA));
    }

    /**
	 *
	 * @throws SQLException
	 * Compare modification with the update
	 */
    @Test
    public void simpleUpdateCompare2() throws SQLException {
    	Entreprise entreprise = entreprises.get(0);
        entreprise.setNom(CHANGED_DATA);

        DbManager.getInstance().getEntrepriseDao().update(entreprise);
        Entreprise dbEntrepriseUpdated = (Entreprise)DbManager.getInstance().getEntrepriseDao().select(1);

        assertTrue(entreprise.getId() == dbEntrepriseUpdated.getId() && entreprise.getNom().equals(dbEntrepriseUpdated.getNom()));
    }

	/**
	 * Compare the modification with the update
	 */
    @Test
    public void simpleUpdateCompare3() {
    	Entreprise entreprise = entreprises.get(0);
    	Entreprise dbEntreprise = (Entreprise)DbManager.getInstance().getEntrepriseDao().select(1);

        assertTrue(entreprise.getId() == dbEntreprise.getId() && entreprise.getNom().equals(dbEntreprise.getNom()));
    }

    /**
	 *
	 * @throws SQLException
	 * Test if data is truncated when update is too long
	 */
    @Test(expected = MysqlDataTruncation.class)
    public void updateMaxValExtended() throws SQLException {
    	Entreprise entreprise = entreprises.get(0);

        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            data.append("x");
        }
        entreprise.setNom(data.toString());

        DbManager.getInstance().getEntrepriseDao().update(entreprise);
    }

    /**
	 *
	 * @throws SQLException
	 * Test update with the max size for the data
	 */
    @Test
    public void updateMaxValOK() throws SQLException {
    	Entreprise entreprise = entreprises.get(0);

        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            data.append("x");
        }
        entreprise.setNom(data.toString());

        DbManager.getInstance().getEntrepriseDao().update(entreprise);
    }

    /**
	 *
	 * @throws SQLException
	 * Test the update with the min size of the value
	 */
    @Test
    public void updateMinValOK() throws SQLException {
    	Entreprise entreprise = entreprises.get(0);
    	entreprise.setNom("");

        DbManager.getInstance().getEntrepriseDao().update(entreprise);
    }

    /**
	 *
	 * @throws SQLException
	 * Test the update with null value
	 */
    @Test(expected = MySQLIntegrityConstraintViolationException.class)
    public void updateNullValKO() throws SQLException {
    	Entreprise entreprise = entreprises.get(0);
    	entreprise.setNom(null);

        DbManager.getInstance().getEntrepriseDao().update(entreprise);
    }

    /**
	 * Test the update with the wrong id
	 * @throws SQLException
	 */
    @Test
    public void updateWrongId() throws SQLException {
    	Entreprise entreprise = entreprises.get(0);
    	entreprise.setId(4);
    	entreprise.setNom(CHANGED_DATA);

        assertEquals(new Integer(0), DbManager.getInstance().getEntrepriseDao().update(entreprise));
    }

    /**
	 *
	 * @throws SQLException
	 * Test the update with the good id
	 */
    @Test
    public void updateGoodId() throws SQLException {
    	Entreprise entreprise = entreprises.get(0);
    	entreprise.setNom(CHANGED_DATA);

        assertEquals(new Integer(1), DbManager.getInstance().getEntrepriseDao().update(entreprise));
    }
	
}
