/**
 *
 */
package com.apsidepoei.projetpoeitest.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.database.DbOpenHelper;
import com.apsidepoei.projetpoei.database.contracts.AppointmentContract;
import com.apsidepoei.projetpoei.entities.Appointment;
import com.apsidepoei.projetpoeitest.utils.DescribeQuery;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

/**
 *
 * @author thomas
 * This class test Dao
 */
public class AppointmentDaoCreateDropTest {

		/**
		 *
		 * @throws SQLException Test the creation of the table
		 */
		@Test
		public void testGetAppointmentDaoCreateTableMatchingFields() throws SQLException {
			DbManager.getInstance().getAppointmentDao().drop();
			DbManager.getInstance().getAppointmentDao().create();

			ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement()
					.executeQuery("DESCRIBE " + AppointmentContract.TABLE);
			List<DescribeQuery> describeQuery = new ArrayList<DescribeQuery>();
			while (rs.next()) {
				DescribeQuery desc = new DescribeQuery();
				desc.setField(rs.getString(1));
				desc.setType(rs.getString(2));
				desc.setNullable(rs.getString(3));
				desc.setKeyType(rs.getString(4));
				desc.setDefaultValue(rs.getString(5));
				desc.setExtra(rs.getString(6));
				describeQuery.add(desc);
			}

			if (AppointmentContract.COLS.length != describeQuery.size()) {
				fail("not same number of lines");
			}

			for (int i = 0; i < describeQuery.size(); i++) {
				if (!describeQuery.get(i).getField().equals(AppointmentContract.COLS[i])) {
					fail("Column name do not match");
				}
			}
		}

		/**
		 * Test the insert for a new appointment
		 */
		@Test
		public void testGetAppointmentDaoCreateTableInsertWorking() {
			DbManager.getInstance().getAppointmentDao().drop();
			DbManager.getInstance().getAppointmentDao().create();
			try {
		        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        Date mySqlDate = sdf.parse("2019-08-20 02:05:00");

				DbManager.getInstance().getAppointmentDao().insert(new Appointment("Commentaire 1", mySqlDate, "Report 1"));
			} catch (Exception e) {
				fail("Insertion failure");
			}
		}

		/**
		 *
		 * @throws SQLException Test the drop of the table
		 */
		@Test
		public void testGetAppointmentDaoDropTableRemoved() throws SQLException {
			DbManager.getInstance().getAppointmentDao().drop();
			ResultSet rs = DbOpenHelper.getInstance().getConn().createStatement().executeQuery("SHOW TABLES");
			while (rs.next()) {
				if (rs.getString(1).equals(AppointmentContract.TABLE)) {
					fail("Table already exists");
				}
			}
		}

		/**
		 *
		 * @throws SQLException
		 * @throws ParseException
		 * Test insert is not possible
		 */
		@Test(expected = MySQLSyntaxErrorException.class)
		public void testGetAppointmentDaoDropCannotInsert() throws SQLException, ParseException {
			DbManager.getInstance().getAppointmentDao().drop();

	        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date mySqlDate = sdf.parse("2019-08-20 02:05:00");

			DbManager.getInstance().getAppointmentDao().insert(new Appointment("Commentaire 1", mySqlDate, "Report 1"));
		}

		/**
		 * Test insert isn't possible give the good alert
		 * @throws ParseException
		 */
		@Test
		public void testGetAppointmentDaoDropCannotInsertGoodMessage() throws ParseException {
			DbManager.getInstance().getAppointmentDao().drop();
			try {
		        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        Date mySqlDate = sdf.parse("2019-08-20 02:05:00");

				DbManager.getInstance().getAppointmentDao().insert(new Appointment("Commentaire 1", mySqlDate, "Report 1"));
			} catch (SQLException e) {
				assertTrue(e.getMessage().equals("Table 'zbleugin." + AppointmentContract.TABLE + "' doesn't exist"));
			}
		}
}
