/**
 *
 */
package com.apsidepoei.projetpoei.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.apsidepoei.projetpoei.database.contracts.AppointmentContract;
import com.apsidepoei.projetpoei.entities.Appointment;

/**
 * @author thomas
 * This class define the tools for data access object
 */
public class AppointmentDao extends BaseDao<Appointment> {

    /**
     * Constructor
     */
    public AppointmentDao() {
        super(new AppointmentContract());
    }

    /**
     * Override the function in order to insert a new appointment
     */
    @Override
    protected void javaToSqlInsert(Appointment item, PreparedStatement ps) throws SQLException {
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mySqlDate = sdf.format(item.getDateTime());


    	ps.setString(2, item.getInformations());
        ps.setString(3, mySqlDate);
        ps.setString(4, item.getReport());
    }

    /**
     * Override the function in order to update a appointment
     */
    @Override
    protected void javaToSqlUpdate(Appointment item, PreparedStatement ps) throws SQLException {
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mySqlDate = sdf.format(item.getDateTime());

        ps.setString(1, item.getInformations());
        ps.setString(2, mySqlDate);
        ps.setString(3, item.getReport());
        ps.setInt(4, item.getId());
    }

    /**
     * Override the function to parse a appointment from the database
     */
    @Override
    protected Appointment parseFromDbToJava(ResultSet rs) throws SQLException, ParseException {
        Appointment item = new Appointment();

        item.setId(rs.getInt(rs.findColumn(AppointmentContract.COL_ID)));
        item.setInformations(rs.getString(rs.findColumn(AppointmentContract.COL_INFORMATIONS)));

        String date = rs.getString(rs.findColumn(AppointmentContract.COL_DATETIME));

        item.setDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date));

        item.setReport(rs.getString(rs.findColumn(AppointmentContract.COL_REPORT)));

        return item;
    }
}
