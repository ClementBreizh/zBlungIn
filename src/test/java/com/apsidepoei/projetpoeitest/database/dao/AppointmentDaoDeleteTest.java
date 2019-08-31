//package com.apsidepoei.projetpoeitest.database.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.TimeZone;
//
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Appointment;
//
///**
// * @author thomas
// * This class test the delete function of the dao
// */
//public class AppointmentDaoDeleteTest {
//
//	/**
//	 * Drop and create the table before each test
//	 */
//	@Before
//	public void dropCreate() {
//		DbManager.getInstance().getAppointmentDao().drop();
//		DbManager.getInstance().getAppointmentDao().create();
//	}
//
//	/**
//	 *
//	 * @throws SQLException
//	 * @throws ParseException
//	 * Test simple delete
//	 */
//	@Test
//	public void testAppointmentDaoDeleteSimple() throws SQLException, ParseException {
//        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date mySqlDate = sdf.parse("2019-08-20 02:05:00");
//
//		Appointment Appointment = new Appointment("Commentaire 1", mySqlDate, "Report 1");
//		DbManager.getInstance().getAppointmentDao().insert(Appointment);
//
//		Appointment.setId(1);
//		DbManager.getInstance().getAppointmentDao().delete(Appointment);
//
//		assertNull(DbManager.getInstance().getAppointmentDao().select(1));
//	}
//
//	/**
//	 *
//	 * @throws SQLException
//	 * @throws ParseException
//	 * Test multiple delete
//	 */
//	@Test
//	public void testAppointmentDaoDeleteMultiple2() throws SQLException, ParseException {
//		boolean statut = false;
//        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date mySqlDate = sdf.parse("2019-08-20 02:05:00");
//
//		for (int i = 17; i <= 102; i += 17) {
//			Appointment Appointment = new Appointment("Commentaire " + i, mySqlDate, "Report " + i);
//			Appointment.setId(i);
//			DbManager.getInstance().getAppointmentDao().insert(Appointment);
//
//			if (i == 51) {
//				DbManager.getInstance().getAppointmentDao().delete(Appointment);
//			}
//		}
//
//		for (int i = 17; i <= 102; i += 17) {
//			if (i == 51 && DbManager.getInstance().getAppointmentDao().select(i) == null) {
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
//	public void testAppointmentDaoDeleteNullMultiple() throws SQLException, ParseException {
//		int statut = 0;
//        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date mySqlDate = sdf.parse("2019-08-20 02:05:00");
//
//		for (int i = 17; i <= 102; i += 17) {
//			Appointment Appointment = new Appointment("Commentaire " + i, mySqlDate, "Report " + i);
//			Appointment.setId(i);
//			DbManager.getInstance().getAppointmentDao().insert(Appointment);
//
//			if (i == 102) {
//				DbManager.getInstance().getAppointmentDao().delete(Appointment);
//				statut = DbManager.getInstance().getAppointmentDao().delete(Appointment);
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
//		DbManager.getInstance().getAppointmentDao().drop();
//		DbManager.getInstance().getAppointmentDao().create();
//	}
//}
