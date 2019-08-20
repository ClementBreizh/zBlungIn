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

public class DegreeDaoUpdateTest {
	private static final String CHANGED_DATA = "toto";
	private List<Degree> degrees = new ArrayList<Degree>();

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

	@Test
	public void simpleUpdateCompare1() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setName(CHANGED_DATA);

		Degree dbDegree = (Degree) DbManager.getInstance().getDegreeDao().select(1);
		DbManager.getInstance().getDegreeDao().update(degree);
		Degree dbDegreeUpdated = (Degree) DbManager.getInstance().getDegreeDao().select(1);

		assertTrue(dbDegree.getId() == dbDegreeUpdated.getId() && !dbDegree.getName().equals(dbDegreeUpdated.getName())
				&& dbDegreeUpdated.getName().equals(CHANGED_DATA));
	}

	@Test
	public void simpleUpdateCompare2() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setName(CHANGED_DATA);

		DbManager.getInstance().getDegreeDao().update(degree);
		Degree dbDegreeUpdated = (Degree) DbManager.getInstance().getDegreeDao().select(1);

		assertTrue(degree.getId() == dbDegreeUpdated.getId() && degree.getName().equals(dbDegreeUpdated.getName()));
	}

	@Test
	public void simpleUpdateCompare3() {
		Degree degree = degrees.get(0);
		Degree dbDegree = (Degree) DbManager.getInstance().getDegreeDao().select(1);

		assertTrue(degree.getId() == dbDegree.getId() && degree.getName().equals(dbDegree.getName()));
	}

	@Test(expected = MysqlDataTruncation.class)
	public void updateMaxValExtended() throws SQLException {
		Degree degree = degrees.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 256; i++) {
			data.append("x");
		}
		degree.setName(data.toString());

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	@Test
	public void updateMaxValOK() throws SQLException {
		Degree degree = degrees.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 255; i++) {
			data.append("x");
		}
		degree.setName(data.toString());

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	@Test
	public void updateMinValOK() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setName("");

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	@Test(expected = MySQLIntegrityConstraintViolationException.class)
	public void updateNullValKO() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setName(null);

		DbManager.getInstance().getDegreeDao().update(degree);
	}

	@Test
	public void updateWrongId() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setId(4);
		degree.setName(CHANGED_DATA);

		assertEquals(new Integer(0), DbManager.getInstance().getDegreeDao().update(degree));
	}

	@Test
	public void updateGoodId() throws SQLException {
		Degree degree = degrees.get(0);
		degree.setName(CHANGED_DATA);

		assertEquals(new Integer(1), DbManager.getInstance().getDegreeDao().update(degree));
	}
}
