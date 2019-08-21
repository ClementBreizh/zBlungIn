package com.apsidepoei.projetpoeitest.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Session;

/**
 * 
 * @author benjamin-m
 *
 */
public class SessionDaoDeleteTest {
	
	/**
	 * Drop and create the table before each test
	 */
	@Before
    public void dropCreate() {
        DbManager.getInstance().getSessionDao().drop();
        DbManager.getInstance().getSessionDao().create();
    }

	/**
	 *
	 * @throws SQLException
	 * @throws ParseException
	 * Test simple delete
	 */
    @Test
    public void testSessionDaoDeleteSimple() throws SQLException, ParseException {
    	Session session = new Session("Java Web", new SimpleDateFormat("yyyy/mm/dd").parse("2019/06/15"), new SimpleDateFormat("yyyy/mm/dd").parse("2019/10/02"));
        DbManager.getInstance().getSessionDao().insert(session);

        session.setId(1);
        DbManager.getInstance().getSessionDao().delete(session);

        assertNull(DbManager.getInstance().getSessionDao().select(1));
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
        	Session session = new Session("Java Web", new SimpleDateFormat("yyyy/mm/dd").parse("2019/06/15"), new SimpleDateFormat("yyyy/mm/dd").parse("2019/10/02"));
            session.setId(i);
            DbManager.getInstance().getSessionDao().insert(session);

            if (i == 51) {
                DbManager.getInstance().getSessionDao().delete(session);
            }
        }

        for (int i = 17; i <= 102; i += 17) {
            if (i == 51 && DbManager.getInstance().getSessionDao().select(i) == null) {
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
        	Session session = new Session("Java Web", new SimpleDateFormat("yyyy/mm/dd").parse("2019/06/15"), new SimpleDateFormat("yyyy/mm/dd").parse("2019/10/02"));
        	session.setId(i);
            DbManager.getInstance().getSessionDao().insert(session);

            if (i == 102) {
              DbManager.getInstance().getSessionDao().delete(session);
              statut = DbManager.getInstance().getSessionDao().delete(session);
            }
        }

        assertEquals(0, statut);
    }

    /**
	 * After all test, drop and create the table
	 */
    @AfterClass
    public static void dropAfter() {
        DbManager.getInstance().getSessionDao().drop();
        DbManager.getInstance().getSessionDao().create();
    }
}
