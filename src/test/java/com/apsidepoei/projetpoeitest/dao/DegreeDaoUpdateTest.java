package com.apsidepoei.projetpoeitest.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Degree;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * @author thomas
 * This class test the update function of the dao
 */
public class DegreeDaoUpdateTest {
	private static final String CHANGED_DATA = "toto";
	private List<Degree> degrees = new ArrayList<Degree>();

	/**
	 *
	 * @throws SQLException
	 * Before each test, drop & create the table and add / insert new degrees
	 */
	@Before
	public void setupTests() throws SQLException {
		DbManager.getInstance().getDegreeDao().drop();
		DbManager.getInstance().getDegreeDao().create();

		degrees.clear();
		degrees.add(new Degree(1, "Diplome 1", "Master"));
		degrees.add(new Degree(2, "Diplome 2", "Master"));
		degrees.add(new Degree(3, "Diplome 3", "Master"));

		for (Degree degree : degrees) {
			DbManager.getInstance().getDegreeDao().insert(degree);
		}
	}

	/**
	 *
	 * @throws SQLException
	 * Compare name modification with the update
	 */
	@Test
	public void simpleUpdateCompareName1() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setName(CHANGED_DATA);

		Degree dbDegree = (Degree) DbManager.getInstance().getDegreeDao().select(1);
		DbManager.getInstance().getDegreeDao().update(degree);
		Degree dbDegreeUpdated = (Degree) DbManager.getInstance().getDegreeDao().select(1);

		assertTrue(dbDegree.getId() == dbDegreeUpdated.getId() && !dbDegree.getName().equals(dbDegreeUpdated.getName())
				&& dbDegreeUpdated.getName().equals(CHANGED_DATA));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare name modification with the update
	 */
	@Test
	public void simpleUpdateCompareName2() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setName(CHANGED_DATA);

		DbManager.getInstance().getDegreeDao().update(degree);
		Degree dbDegreeUpdated = (Degree) DbManager.getInstance().getDegreeDao().select(1);

		assertTrue(degree.getId() == dbDegreeUpdated.getId() && degree.getName().equals(dbDegreeUpdated.getName()));
	}

	/**
	 * Compare the name modification with the update
	 */
	@Test
	public void simpleUpdateCompareName3() {
		Degree degree = degrees.get(0);
		Degree dbDegree = (Degree) DbManager.getInstance().getDegreeDao().select(1);

		assertTrue(degree.getId() == dbDegree.getId() && degree.getName().equals(dbDegree.getName()));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare level modification with the update
	 */
	@Test
	public void simpleUpdateCompareLevel1() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setLevel(CHANGED_DATA);

		Degree dbDegree = (Degree) DbManager.getInstance().getDegreeDao().select(1);
		DbManager.getInstance().getDegreeDao().update(degree);
		Degree dbDegreeUpdated = (Degree) DbManager.getInstance().getDegreeDao().select(1);

		assertTrue(dbDegree.getId() == dbDegreeUpdated.getId() && !dbDegree.getLevel().equals(dbDegreeUpdated.getLevel())
				&& dbDegreeUpdated.getLevel().equals(CHANGED_DATA));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare level modification with the update
	 */
	@Test
	public void simpleUpdateCompareLevel2() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setLevel(CHANGED_DATA);

		DbManager.getInstance().getDegreeDao().update(degree);
		Degree dbDegreeUpdated = (Degree) DbManager.getInstance().getDegreeDao().select(1);

		assertTrue(degree.getId() == dbDegreeUpdated.getId() && degree.getLevel().equals(dbDegreeUpdated.getLevel()));
	}

	/**
	 * Compare the level modification with the update
	 */
	@Test
	public void simpleUpdateCompareLevel3() {
		Degree degree = degrees.get(0);
		Degree dbDegree = (Degree) DbManager.getInstance().getDegreeDao().select(1);

		assertTrue(degree.getId() == dbDegree.getId() && degree.getLevel().equals(dbDegree.getLevel()));
	}

	/**
	 *
	 * @throws SQLException
	 * Test if data is truncated when update is too long
	 */
	@Test(expected = MysqlDataTruncation.class)
	public void updateMaxValNameExtended() throws SQLException {
		Degree degree = degrees.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 256; i++) {
			data.append("x");
		}
		degree.setName(data.toString());

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	/**
	 *
	 * @throws SQLException
	 * Test update with the max size for the data
	 */
	@Test
	public void updateMaxValNameOK() throws SQLException {
		Degree degree = degrees.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 255; i++) {
			data.append("x");
		}
		degree.setName(data.toString());

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with the min size of the value
	 */
	@Test
	public void updateMinValNameOK() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setName("");

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with null value
	 */
	@Test(expected = MySQLIntegrityConstraintViolationException.class)
	public void updateNullValNameKO() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setName(null);

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	/**
	 *
	 * @throws SQLException
	 * Test if data is truncated when update is too long
	 */
	@Test(expected = MysqlDataTruncation.class)
	public void updateMaxValLevelExtended() throws SQLException {
		Degree degree = degrees.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 256; i++) {
			data.append("x");
		}
		degree.setLevel(data.toString());

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	/**
	 *
	 * @throws SQLException
	 * Test update with the max size for the data
	 */
	@Test
	public void updateMaxValLevelOK() throws SQLException {
		Degree degree = degrees.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 50; i++) {
			data.append("x");
		}
		degree.setLevel(data.toString());

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with the min size of the value
	 */
	@Test
	public void updateMinValLevelOK() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setLevel("");

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with null value
	 */
	@Test(expected = MySQLIntegrityConstraintViolationException.class)
	public void updateNullValLevelKO() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setLevel(null);

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	/**
	 * Test the update with the wrong id
	 * @throws SQLException
	 */
	@Test
	public void updateWrongId() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setId(4);
		degree.setName(CHANGED_DATA);

		assertEquals(new Integer(0), DbManager.getInstance().getDegreeDao().update(degree));
	}
	/**
	 *
	 * @throws SQLException
	 * Test the update with the good id
	 */
	@Test
	public void updateGoodId() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setName(CHANGED_DATA);

		assertEquals(new Integer(1), DbManager.getInstance().getDegreeDao().update(degree));
	}
}
