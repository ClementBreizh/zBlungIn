package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Session;

/**
 * 
 * @author benjamin-m
 *
 */
public class SessionDaoSelectTest {

	static List<Session> Sessions = new ArrayList<Session>();

	/**
	 * Before the tests, create new data
	 * @throws ParseException
	 */
	@BeforeClass
	public static void config() throws ParseException {
        
		Session Session1 = new Session("nom 1", new SimpleDateFormat("yyyy/MM/dd").parse("2019/06/15"), new SimpleDateFormat("yyyy/MM/dd").parse("2019/10/02"));
		Session Session2 = new Session("nom 2", new SimpleDateFormat("yyyy/MM/dd").parse("2019/10/15"), new SimpleDateFormat("yyyy/MM/dd").parse("2019/12/02"));
		Session Session3 = new Session("nom 3", new SimpleDateFormat("yyyy/MM/dd").parse("2019/12/15"), new SimpleDateFormat("yyyy/MM/dd").parse("2020/02/02"));
		Session1.setId(1);
		Session2.setId(2);
		Session3.setId(3);
		Sessions.add(Session1);
		Sessions.add(Session2);
		Sessions.add(Session3);
	}

	/**
	 *
	 * @throws Exception
	 * Before each test, drop, create and insert new data
	 */
	@Before
	public void drop() throws Exception {
		DbManager.getInstance().getSessionDao().drop();
		DbManager.getInstance().getSessionDao().create();
		DbManager.getInstance().getSessionDao().insert(Sessions.get(0));
		DbManager.getInstance().getSessionDao().insert(Sessions.get(1));
		DbManager.getInstance().getSessionDao().insert(Sessions.get(2));
	}

	/**
	 *
	 * @throws Exception
	 * Test to select all
	 */
	@Test
	public void selectAll() throws Exception {
		assertNotNull(DbManager.getInstance().getSessionDao().select());
	}

	/**
	 *
	 * @throws Exception
	 * Test select all with a count
	 */
	@Test
	public void selectAllCount() throws Exception {
		List<Session> listObjects = DbManager.getInstance().getSessionDao().select();
		DbManager.getInstance().getSessionDao().select();
		assertEquals(3, listObjects.size());
	}

	/**
	 *
	 * @throws Exception
	 * Test the data compare
	 */
	@Test
	public void dataCompare() throws Exception {
		List<Session> listObjects = DbManager.getInstance().getSessionDao().select();


		assertTrue((Sessions.get(0).getId() == ((Session) listObjects.get(0)).getId())
				&& (Sessions.get(0).getName().equals(((Session) listObjects.get(0)).getName())));
				
				
	}
}