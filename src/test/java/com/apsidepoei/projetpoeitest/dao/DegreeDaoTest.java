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
import com.apsidepoei.projetpoei.entities.Degree;

/**
 *
 * @author thomas
 * This class test the select functions of the dao
 */
public class DegreeDaoTest {

	static List<Degree> Degrees = new ArrayList<Degree>();

	/**
	 * Before the tests, create new data
	 */
	@BeforeClass
	public static void config() {
		Degree Degree1 = new Degree("Diplome1", "Master");
		Degree Degree2 = new Degree("Diplome2", "Master");
		Degree Degree3 = new Degree("Diplome3", "Master");
		Degree1.setId(1);
		Degree2.setId(2);
		Degree3.setId(3);
		Degrees.add(Degree1);
		Degrees.add(Degree2);
		Degrees.add(Degree3);
	}

	/**
	 *
	 * @throws Exception
	 * Before each test, drop, create and insert new data
	 */
	@Before
	public void drop() throws Exception {
		DbManager.getInstance().getDegreeDao().drop();
		DbManager.getInstance().getDegreeDao().create();
		DbManager.getInstance().getDegreeDao().insert(Degrees.get(0));
		DbManager.getInstance().getDegreeDao().insert(Degrees.get(1));
		DbManager.getInstance().getDegreeDao().insert(Degrees.get(2));
	}

	/**
	 *
	 * @throws Exception
	 * Test to select all
	 */
	@Test
	public void selectAll() throws Exception {
		assertNotNull(DbManager.getInstance().getDegreeDao().select());
	}

	/**
	 *
	 * @throws Exception
	 * Test select all with a count
	 */
	@Test
	public void selectAllCount() throws Exception {
		List<Degree> listObjects = DbManager.getInstance().getDegreeDao().select();
		DbManager.getInstance().getDegreeDao().select();
		assertEquals(3, listObjects.size());
	}

	/**
	 *
	 * @throws Exception
	 * Test the data compare
	 */
	@Test
	public void dataCompare() throws Exception {
		List<Degree> listObjects = DbManager.getInstance().getDegreeDao().select();

		assertTrue((Degrees.get(0).getId() == ((Degree) listObjects.get(0)).getId())
				&& (Degrees.get(0).getName().equals(((Degree) listObjects.get(0)).getName())));
	}

}
