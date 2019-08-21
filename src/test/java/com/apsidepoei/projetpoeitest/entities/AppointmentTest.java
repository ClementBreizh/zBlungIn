package com.apsidepoei.projetpoeitest.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.apsidepoei.projetpoei.entities.Appointment;

/**
 * @author thomas
 * This test is for the toString function
 */
public class AppointmentTest {

    @Test
    public void testToString() throws ParseException
    {
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date mySqlDate = sdf.parse("2019-08-20 02:05:00");

        Appointment appointment = new Appointment("Information 1", mySqlDate, "Report 1");
        appointment.setId(1);
        String expected = "Rendez-vous [Id = 1, informations=Information 1, date=Tue Aug 20 02:05:00 CEST 2019, report=Report 1]";
        Assert.assertEquals(expected, appointment.toString());
    }
}
