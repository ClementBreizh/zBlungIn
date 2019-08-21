package com.apsidepoei.projetpoeitest.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Appointment;

/**
*
* @author thomas
* This class test the select functions of the dao
*/
public class AppointmentDaoSelectTest {

	static List<Appointment> Appointments = new ArrayList<Appointment>();

	/**
	 * Before the tests, create new data
	 * @throws ParseException
	 */
	@BeforeClass
	public static void config() throws ParseException {
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date mySqlDate = sdf.parse("2019-08-20 02:05:00");

		Appointment Appointment1 = new Appointment("Commentaire 1", mySqlDate, "Report 1");
		Appointment Appointment2 = new Appointment("Commentaire 2", mySqlDate, "Report 2");
		Appointment Appointment3 = new Appointment("Commentaire 3", mySqlDate, "Report 3");
		Appointment1.setId(1);
		Appointment2.setId(2);
		Appointment3.setId(3);
		Appointments.add(Appointment1);
		Appointments.add(Appointment2);
		Appointments.add(Appointment3);
	}

	/**
	 *
	 * @throws Exception
	 * Before each test, drop, create and insert new data
	 */
	@Before
	public void drop() throws Exception {
		DbManager.getInstance().getAppointmentDao().drop();
		DbManager.getInstance().getAppointmentDao().create();
		DbManager.getInstance().getAppointmentDao().insert(Appointments.get(0));
		DbManager.getInstance().getAppointmentDao().insert(Appointments.get(1));
		DbManager.getInstance().getAppointmentDao().insert(Appointments.get(2));
	}

	/**
	 *
	 * @throws Exception
	 * Test to select all
	 */
	@Test
	public void selectAll() throws Exception {
		assertNotNull(DbManager.getInstance().getAppointmentDao().select());
	}

	/**
	 *
	 * @throws Exception
	 * Test select all with a count
	 */
	@Test
	public void selectAllCount() throws Exception {
		List<Appointment> listObjects = DbManager.getInstance().getAppointmentDao().select();
		DbManager.getInstance().getAppointmentDao().select();
		assertEquals(3, listObjects.size());
	}

	/**
	 *
	 * @throws Exception
	 * Test the data compare
	 */
	@Test
	public void dataCompare() throws Exception {
		List<Appointment> listObjects = DbManager.getInstance().getAppointmentDao().select();

		assertTrue((Appointments.get(0).getId() == ((Appointment) listObjects.get(0)).getId())
				&& (Appointments.get(0).getInformations().equals(((Appointment) listObjects.get(0)).getInformations())
				&& (Appointments.get(0).getDateTime().compareTo(((Appointment) listObjects.get(0)).getDateTime()) == 0
				&& (Appointments.get(0).getReport().equals(((Appointment) listObjects.get(0)).getReport())))));
	}

}
