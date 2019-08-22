package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Session;
import com.mysql.jdbc.MysqlDataTruncation;

/**
 * 
 * @author benjamin-m
 *
 */
public class SessionDaoUpdateTest {

	private static final String CHANGED_DATA = "toto";

	private List<Session> sessions = new ArrayList<Session>();

	/**
	 *
	 * @throws SQLException
	 * Before each test, drop & create the table and add / insert new sessions
	 * @throws ParseException
	 */
	@Before
	public void setupTests() throws SQLException, ParseException {
		DbManager.getInstance().getSessionDao().drop();
		DbManager.getInstance().getSessionDao().create();

		sessions.clear();
		sessions.add(new Session(1, "nom 1", new SimpleDateFormat("yyyy/MM/dd").parse("2019/06/15"), new SimpleDateFormat("yyyy/MM/dd").parse("2019/10/02")));
		sessions.add(new Session(2, "nom 2", new SimpleDateFormat("yyyy/MM/dd").parse("2019/10/15"), new SimpleDateFormat("yyyy/MM/dd").parse("2019/12/02")));
		sessions.add(new Session(3, "nom 3", new SimpleDateFormat("yyyy/MM/dd").parse("2019/12/15"), new SimpleDateFormat("yyyy/MM/dd").parse("2020/02/02")));

		for (Session session : sessions) {
			DbManager.getInstance().getSessionDao().insert(session);
		}
	}

	/**
	 *
	 * @throws SQLException
	 * Compare name modification with the update
	 */
	@Test
	public void simpleUpdateCompareName1() throws SQLException {
		Session session = sessions.get(0);
		session.setName(CHANGED_DATA);

		Session dbSession = (Session) DbManager.getInstance().getSessionDao().select(1);
		DbManager.getInstance().getSessionDao().update(session);
		Session dbSessionUpdated = (Session) DbManager.getInstance().getSessionDao().select(1);

		assertTrue(dbSession.getId() == dbSessionUpdated.getId() && !dbSession.getName().equals(dbSessionUpdated.getName())
				&& dbSessionUpdated.getName().equals(CHANGED_DATA));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare name modification with the update
	 */
	@Test
	public void simpleUpdateCompareName2() throws SQLException {
		Session session = sessions.get(0);
		session.setName(CHANGED_DATA);

		DbManager.getInstance().getSessionDao().update(session);
		Session dbSessionUpdated = (Session) DbManager.getInstance().getSessionDao().select(1);

		assertTrue(session.getId() == dbSessionUpdated.getId() && session.getName().equals(dbSessionUpdated.getName()));
	}

	/**
	 * Compare the name modification with the update
	 */
	@Test
	public void simpleUpdateCompareName3() {
		Session session = sessions.get(0);
		Session dbSession = (Session) DbManager.getInstance().getSessionDao().select(1);

		assertTrue(session.getId() == dbSession.getId() && session.getName().equals(dbSession.getName()));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare dateStart modification with the update
	 */
	@Test
	public void simpleUpdateCompareDateStart1() throws SQLException, ParseException {
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
		final Date CHANGED_DATESTART = sdf.parse("2019/08/22");

		Session session = sessions.get(0);
		session.setDateStart(CHANGED_DATESTART);

		Session dbSession = (Session) DbManager.getInstance().getSessionDao().select(1);
		DbManager.getInstance().getSessionDao().update(session);
		Session dbSessionUpdated = (Session) DbManager.getInstance().getSessionDao().select(1);

		assertTrue(dbSession.getId() == dbSessionUpdated.getId() && !dbSession.getDateStart().equals(dbSessionUpdated.getDateStart())
				&& dbSessionUpdated.getDateStart().equals(CHANGED_DATESTART));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare dateStart modification with the update
	 * @throws ParseException
	 */
	@Test
	public void simpleUpdateCompareDateStart2() throws SQLException, ParseException {
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
		final Date CHANGED_DATESTART = sdf.parse("2019/08/20");

		Session session = sessions.get(0);
		session.setDateStart(CHANGED_DATESTART);

		DbManager.getInstance().getSessionDao().update(session);
		Session dbSessionUpdated = (Session) DbManager.getInstance().getSessionDao().select(1);

		assertTrue(session.getId() == dbSessionUpdated.getId() && session.getDateStart().equals(dbSessionUpdated.getDateStart()));
	}

	/**
	 * Compare the DateStart modification with the update
	 */
	@Test
	public void simpleUpdateCompareDateStart3() {
		Session session = sessions.get(0);
		Session dbSession = (Session) DbManager.getInstance().getSessionDao().select(1);

		assertTrue(session.getId() == dbSession.getId() && session.getDateStart().equals(dbSession.getDateStart()));
	}
	
	/**
	 *
	 * @throws SQLException
	 * Compare dateEnd modification with the update
	 * @throws ParseException
	 */
	@Test
	public void simpleUpdateCompareDateEnd1() throws SQLException, ParseException {
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
		final Date CHANGED_DATEEND = sdf.parse("2019/08/22");

		Session session = sessions.get(0);
		session.setDateEnd(CHANGED_DATEEND);

		Session dbSession = (Session) DbManager.getInstance().getSessionDao().select(1);
		DbManager.getInstance().getSessionDao().update(session);
		Session dbSessionUpdated = (Session) DbManager.getInstance().getSessionDao().select(1);

		assertTrue(dbSession.getId() == dbSessionUpdated.getId() && !dbSession.getDateEnd().equals(dbSessionUpdated.getDateEnd())
				&& dbSessionUpdated.getDateEnd().equals(CHANGED_DATEEND));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare dateEnd modification with the update
	 * @throws ParseException
	 */
	@Test
	public void simpleUpdateCompareDateEnd2() throws SQLException, ParseException {
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
		final Date CHANGED_DATEEND = sdf.parse("2019/08/20");

		Session session = sessions.get(0);
		session.setDateEnd(CHANGED_DATEEND);

		DbManager.getInstance().getSessionDao().update(session);
		Session dbSessionUpdated = (Session) DbManager.getInstance().getSessionDao().select(1);

		assertTrue(session.getId() == dbSessionUpdated.getId() && session.getDateEnd().equals(dbSessionUpdated.getDateEnd()));
	}

	/**
	 * Compare the dateEnd modification with the update
	 */
	@Test
	public void simpleUpdateCompareDateEnd3() {
		Session session = sessions.get(0);
		Session dbSession = (Session) DbManager.getInstance().getSessionDao().select(1);

		assertTrue(session.getId() == dbSession.getId() && session.getDateEnd().equals(dbSession.getDateEnd()));
	}


	/**
	 *
	 * @throws SQLException
	 * Test if data is truncated when update is too long
	 */
	@Test(expected = MysqlDataTruncation.class)
	public void updateMaxValNameExtended() throws SQLException {
		Session session = sessions.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 256; i++) {
			data.append("x");
		}
		session.setName(data.toString());

		DbManager.getInstance().getSessionDao().update(session);
	}

	/**
	 *
	 * @throws SQLException
	 * Test update with the max size for the data
	 */
	@Test
	public void updateMaxValNameOK() throws SQLException {
		Session session = sessions.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 50; i++) {
			data.append("x");
		}
		session.setName(data.toString());

		DbManager.getInstance().getSessionDao().update(session);

		assertTrue(DbManager.getInstance().getSessionDao().update(session) == 1);
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with the min size of the value
	 */
	@Test
	public void updateMinValNameOK() throws SQLException {
		Session session = sessions.get(0);
		session.setName("");

		DbManager.getInstance().getSessionDao().update(session);

		assertTrue(DbManager.getInstance().getSessionDao().update(session) == 1);
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with null value
	 */
	@Test
	public void updateNullValNameKO() throws SQLException {
		Session session = sessions.get(0);
		session.setName(null);

		DbManager.getInstance().getSessionDao().update(session);

		assertTrue(DbManager.getInstance().getSessionDao().update(session) == 1);

	}

	
	/**
	 * Test the update with the wrong id
	 * @throws SQLException
	 */
	@Test
	public void updateNameWrongId() throws SQLException {
		Session session = sessions.get(0);
		session.setId(4);
		session.setName(CHANGED_DATA);

		assertEquals(new Integer(0), DbManager.getInstance().getSessionDao().update(session));
	}

	/**
	 * Test the update with the wrong id
	 * @throws SQLException
	 * @throws ParseException
	 */
	@Test
	public void updateDateStartWrongId() throws SQLException, ParseException {
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
		final Date CHANGED_DATESTART = sdf.parse("2019/08/20");

		Session session = sessions.get(0);
		session.setId(4);
		session.setDateStart(CHANGED_DATESTART);

		assertEquals(new Integer(0), DbManager.getInstance().getSessionDao().update(session));
	}

	/**
	 * Test the update with the wrong id
	 * @throws SQLException
	 * @throws ParseException 
	 */
	@Test
	public void updateDateEndWrongId() throws SQLException, ParseException {
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
		final Date CHANGED_DATEEND = sdf.parse("2019/08/20");
		
		Session session = sessions.get(0);
		session.setId(4);
		session.setDateEnd(CHANGED_DATEEND);

		assertEquals(new Integer(0), DbManager.getInstance().getSessionDao().update(session));
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with the good id
	 */
	@Test
	public void updateNameGoodId() throws SQLException {
		Session session = sessions.get(0);
		session.setName(CHANGED_DATA);

		assertEquals(new Integer(1), DbManager.getInstance().getSessionDao().update(session));
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with the good id
	 * @throws ParseException
	 */
	@Test
	public void updateDateTimeGoodId() throws SQLException, ParseException {
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
		final Date CHANGED_DATESTART = sdf.parse("2019/08/20");

		Session session = sessions.get(0);
		session.setDateStart(CHANGED_DATESTART);

		assertEquals(new Integer(1), DbManager.getInstance().getSessionDao().update(session));
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with the good id
	 * @throws ParseException 
	 */
	@Test
	public void updateDateEndGoodId() throws SQLException, ParseException {
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
		final Date CHANGED_DATEEND = sdf.parse("2019/08/20");
		
		Session session = sessions.get(0);
		session.setDateEnd(CHANGED_DATEEND);

		assertEquals(new Integer(1), DbManager.getInstance().getSessionDao().update(session));
	}
}
