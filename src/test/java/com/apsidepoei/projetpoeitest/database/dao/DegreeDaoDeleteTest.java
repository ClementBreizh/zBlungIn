///**
// *
// */
//package com.apsidepoei.projetpoeitest.database.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//import java.sql.SQLException;
//import java.text.ParseException;
//
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Degree;
//
///**
// * @author thomas
// * This class test the delete function of the dao
// */
//public class DegreeDaoDeleteTest {
//	/**
//	 * Drop and create the table before each test
//	 */
//	@Before
//	public void dropCreate() {
//		DbManager.getInstance().getDegreeDao().drop();
//		DbManager.getInstance().getDegreeDao().create();
//	}
//
//	/**
//	 *
//	 * @throws SQLException
//	 * @throws ParseException
//	 * Test simple delete
//	 */
//	@Test
//	public void testDegreeDaoDeleteSimple() throws SQLException, ParseException {
//		Degree Degree = new Degree("Diplome 1", "Master");
//		DbManager.getInstance().getDegreeDao().insert(Degree);
//
//		Degree.setId(1);
//		DbManager.getInstance().getDegreeDao().delete(Degree);
//
//		assertNull(DbManager.getInstance().getDegreeDao().select(1));
//	}
//
//	/**
//	 *
//	 * @throws SQLException
//	 * @throws ParseException
//	 * Test multiple delete
//	 */
//	@Test
//	public void testDegreeDaoDeleteMultiple2() throws SQLException, ParseException {
//		boolean statut = false;
//
//		for (int i = 17; i <= 102; i += 17) {
//			Degree Degree = new Degree("Diplome" + i, "Master" + i);
//			Degree.setId(i);
//			DbManager.getInstance().getDegreeDao().insert(Degree);
//
//			if (i == 51) {
//				DbManager.getInstance().getDegreeDao().delete(Degree);
//			}
//		}
//
//		for (int i = 17; i <= 102; i += 17) {
//			if (i == 51 && DbManager.getInstance().getDegreeDao().select(i) == null) {
//				statut = true;
//			}
//		}
//
//		assertTrue(statut);
//	}
//
//	/**
//	 *
//	 * @throws SQLException
//	 * @throws ParseException
//	 * Test mutliple delete
//	 */
//	@Test
//	public void testDegreeDaoDeleteNullMultiple() throws SQLException, ParseException {
//		int statut = 0;
//
//		for (int i = 17; i <= 102; i += 17) {
//			Degree Degree = new Degree("Diplome" + i, "Master" + i);
//			Degree.setId(i);
//			DbManager.getInstance().getDegreeDao().insert(Degree);
//
//			if (i == 102) {
//				DbManager.getInstance().getDegreeDao().delete(Degree);
//				statut = DbManager.getInstance().getDegreeDao().delete(Degree);
//			}
//		}
//
//		assertEquals(0, statut);
//	}
//
//	/**
//	 * After all test, drop and create the table
//	 */
//	@AfterClass
//	public static void dropAfter() {
//		DbManager.getInstance().getDegreeDao().drop();
//		DbManager.getInstance().getDegreeDao().create();
//	}
//}
