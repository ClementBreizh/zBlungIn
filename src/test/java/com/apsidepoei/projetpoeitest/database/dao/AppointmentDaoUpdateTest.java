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
import com.apsidepoei.projetpoei.entities.Appointment;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * @author thomas
 * This class test the update function of the dao
 */
public class AppointmentDaoUpdateTest {

	private static final String CHANGED_DATA = "toto";

	private List<Appointment> appointments = new ArrayList<Appointment>();

	/**
	 *
	 * @throws SQLException
	 * Before each test, drop & create the table and add / insert new appointments
	 * @throws ParseException
	 */
	@Before
	public void setupTests() throws SQLException, ParseException {
		DbManager.getInstance().getAppointmentDao().drop();
		DbManager.getInstance().getAppointmentDao().create();

        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date mySqlDate = sdf.parse("2019-08-20 02:05:00");

		appointments.clear();
		appointments.add(new Appointment(1, "Commentaire 1", mySqlDate, "Report 1"));
		appointments.add(new Appointment(2, "Commentaire 2", mySqlDate, "Report 2"));
		appointments.add(new Appointment(3, "Commentaire 3", mySqlDate, "Report 3"));

		for (Appointment appointment : appointments) {
			DbManager.getInstance().getAppointmentDao().insert(appointment);
		}
	}

	/**
	 *
	 * @throws SQLException
	 * Compare name modification with the update
	 */
	@Test
	public void simpleUpdateCompareInformations1() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setInformations(CHANGED_DATA);

		Appointment dbAppointment = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);
		DbManager.getInstance().getAppointmentDao().update(appointment);
		Appointment dbAppointmentUpdated = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);

		assertTrue(dbAppointment.getId() == dbAppointmentUpdated.getId() && !dbAppointment.getInformations().equals(dbAppointmentUpdated.getInformations())
				&& dbAppointmentUpdated.getInformations().equals(CHANGED_DATA));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare name modification with the update
	 */
	@Test
	public void simpleUpdateCompareInformations2() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setInformations(CHANGED_DATA);

		DbManager.getInstance().getAppointmentDao().update(appointment);
		Appointment dbAppointmentUpdated = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);

		assertTrue(appointment.getId() == dbAppointmentUpdated.getId() && appointment.getInformations().equals(dbAppointmentUpdated.getInformations()));
	}

	/**
	 * Compare the name modification with the update
	 */
	@Test
	public void simpleUpdateCompareInformations3() {
		Appointment appointment = appointments.get(0);
		Appointment dbAppointment = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);

		assertTrue(appointment.getId() == dbAppointment.getId() && appointment.getInformations().equals(dbAppointment.getInformations()));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare level modification with the update
	 * @throws ParseException
	 */
	@Test
	public void simpleUpdateCompareDate1() throws SQLException, ParseException {
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Date CHANGED_DATETIME = sdf.parse("2019-08-22 02:05:00");

		Appointment appointment = appointments.get(0);
		appointment.setDateTime(CHANGED_DATETIME);

		Appointment dbAppointment = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);
		DbManager.getInstance().getAppointmentDao().update(appointment);
		Appointment dbAppointmentUpdated = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);

		assertTrue(dbAppointment.getId() == dbAppointmentUpdated.getId() && !dbAppointment.getDateTime().equals(dbAppointmentUpdated.getDateTime())
				&& dbAppointmentUpdated.getDateTime().equals(CHANGED_DATETIME));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare level modification with the update
	 * @throws ParseException
	 */
	@Test
	public void simpleUpdateCompareDate2() throws SQLException, ParseException {
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Date CHANGED_DATETIME = sdf.parse("2019-08-20 02:05:00");

		Appointment appointment = appointments.get(0);
		appointment.setDateTime(CHANGED_DATETIME);

		DbManager.getInstance().getAppointmentDao().update(appointment);
		Appointment dbAppointmentUpdated = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);

		assertTrue(appointment.getId() == dbAppointmentUpdated.getId() && appointment.getDateTime().equals(dbAppointmentUpdated.getDateTime()));
	}

	/**
	 * Compare the level modification with the update
	 */
	@Test
	public void simpleUpdateCompareDate3() {
		Appointment appointment = appointments.get(0);
		Appointment dbAppointment = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);

		assertTrue(appointment.getId() == dbAppointment.getId() && appointment.getDateTime().equals(dbAppointment.getDateTime()));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare name modification with the update
	 */
	@Test
	public void simpleUpdateCompareReport1() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setReport(CHANGED_DATA);

		Appointment dbAppointment = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);
		DbManager.getInstance().getAppointmentDao().update(appointment);
		Appointment dbAppointmentUpdated = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);

		assertTrue(dbAppointment.getId() == dbAppointmentUpdated.getId() && !dbAppointment.getReport().equals(dbAppointmentUpdated.getReport())
				&& dbAppointmentUpdated.getReport().equals(CHANGED_DATA));
	}

	/**
	 *
	 * @throws SQLException
	 * Compare name modification with the update
	 */
	@Test
	public void simpleUpdateCompareReport2() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setReport(CHANGED_DATA);

		DbManager.getInstance().getAppointmentDao().update(appointment);
		Appointment dbAppointmentUpdated = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);

		assertTrue(appointment.getId() == dbAppointmentUpdated.getId() && appointment.getReport().equals(dbAppointmentUpdated.getReport()));
	}

	/**
	 * Compare the name modification with the update
	 */
	@Test
	public void simpleUpdateCompareReport3() {
		Appointment appointment = appointments.get(0);
		Appointment dbAppointment = (Appointment) DbManager.getInstance().getAppointmentDao().select(1);

		assertTrue(appointment.getId() == dbAppointment.getId() && appointment.getReport().equals(dbAppointment.getReport()));
	}

	/**
	 *
	 * @throws SQLException
	 * Test if data is truncated when update is too long
	 */
	@Test(expected = MysqlDataTruncation.class)
	public void updateMaxValInformationsExtended() throws SQLException {
		Appointment appointment = appointments.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 256; i++) {
			data.append("x");
		}
		appointment.setInformations(data.toString());

		DbManager.getInstance().getAppointmentDao().update(appointment);
	}

	/**
	 *
	 * @throws SQLException
	 * Test update with the max size for the data
	 */
	@Test
	public void updateMaxValInformationsOK() throws SQLException {
		Appointment appointment = appointments.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 255; i++) {
			data.append("x");
		}
		appointment.setInformations(data.toString());

		DbManager.getInstance().getAppointmentDao().update(appointment);

		assertTrue(DbManager.getInstance().getAppointmentDao().update(appointment) == 1);
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with the min size of the value
	 */
	@Test
	public void updateMinValInformationsOK() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setInformations("");

		DbManager.getInstance().getAppointmentDao().update(appointment);

		assertTrue(DbManager.getInstance().getAppointmentDao().update(appointment) == 1);
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with null value
	 */
	@Test
	public void updateNullValInformationsKO() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setInformations(null);

		DbManager.getInstance().getAppointmentDao().update(appointment);

		assertTrue(DbManager.getInstance().getAppointmentDao().update(appointment) == 1);

	}

	/**
	 *
	 * @throws SQLException
	 * Test if data is truncated when update is too long
	 */
	@Test(expected = MysqlDataTruncation.class)
	public void updateMaxValReportExtended() throws SQLException {
		Appointment appointment = appointments.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 256; i++) {
			data.append("x");
		}
		appointment.setInformations(data.toString());

		DbManager.getInstance().getAppointmentDao().update(appointment);
	}

	/**
	 *
	 * @throws SQLException
	 * Test update with the max size for the data
	 */
	@Test
	public void updateMaxValReportOK() throws SQLException {
		Appointment appointment = appointments.get(0);

		StringBuilder data = new StringBuilder();
		for (int i = 0; i < 255; i++) {
			data.append("x");
		}
		appointment.setReport(data.toString());

		DbManager.getInstance().getAppointmentDao().update(appointment);

		assertTrue(DbManager.getInstance().getAppointmentDao().update(appointment) == 1);
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with the min size of the value
	 */
	@Test
	public void updateMinValReportOK() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setInformations("");

		DbManager.getInstance().getAppointmentDao().update(appointment);

		assertTrue(DbManager.getInstance().getAppointmentDao().update(appointment) == 1);
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with null value
	 */
	@Test
	public void updateNullValReportOK() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setReport(null);

		DbManager.getInstance().getAppointmentDao().update(appointment);

		assertTrue(DbManager.getInstance().getAppointmentDao().update(appointment) == 1);
	}

	/**
	 * Test the update with the wrong id
	 * @throws SQLException
	 */
	@Test
	public void updateInformationsWrongId() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setId(4);
		appointment.setInformations(CHANGED_DATA);

		assertEquals(new Integer(0), DbManager.getInstance().getAppointmentDao().update(appointment));
	}

	/**
	 * Test the update with the wrong id
	 * @throws SQLException
	 * @throws ParseException
	 */
	@Test
	public void updateDateTimeWrongId() throws SQLException, ParseException {
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Date CHANGED_DATETIME = sdf.parse("2019-08-20 02:05:00");

		Appointment appointment = appointments.get(0);
		appointment.setId(4);
		appointment.setDateTime(CHANGED_DATETIME);

		assertEquals(new Integer(0), DbManager.getInstance().getAppointmentDao().update(appointment));
	}

	/**
	 * Test the update with the wrong id
	 * @throws SQLException
	 */
	@Test
	public void updateReportWrongId() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setId(4);
		appointment.setReport(CHANGED_DATA);

		assertEquals(new Integer(0), DbManager.getInstance().getAppointmentDao().update(appointment));
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with the good id
	 */
	@Test
	public void updateInformationsGoodId() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setInformations(CHANGED_DATA);

		assertEquals(new Integer(1), DbManager.getInstance().getAppointmentDao().update(appointment));
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with the good id
	 * @throws ParseException
	 */
	@Test
	public void updateDateTimeGoodId() throws SQLException, ParseException {
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Date CHANGED_DATETIME = sdf.parse("2019-08-20 02:05:00");

		Appointment appointment = appointments.get(0);
		appointment.setDateTime(CHANGED_DATETIME);

		assertEquals(new Integer(1), DbManager.getInstance().getAppointmentDao().update(appointment));
	}

	/**
	 *
	 * @throws SQLException
	 * Test the update with the good id
	 */
	@Test
	public void updateReportGoodId() throws SQLException {
		Appointment appointment = appointments.get(0);
		appointment.setReport(CHANGED_DATA);

		assertEquals(new Integer(1), DbManager.getInstance().getAppointmentDao().update(appointment));
	}

}
