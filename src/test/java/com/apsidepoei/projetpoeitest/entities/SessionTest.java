package com.apsidepoei.projetpoeitest.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import com.apsidepoei.projetpoei.entities.Session;

/**
 * 
 * @author benjamin-m
 *
 */
public class SessionTest {

	/**
	 * Test the toString()
	 * @throws ParseException
	 */
    @Test
    public void testToString() throws ParseException {
    	
        Session session = new Session("Java Web", new SimpleDateFormat("yyyy/MM/dd").parse("2019/06/15"), new SimpleDateFormat("yyyy/MM/dd").parse("2019/10/02"));
        System.out.println(session.toString());
        session.setId(1);
        String expected = "session [Id = 1, name=Java Web, dateStart=Sat Jun 15 00:00:00 CEST 2019, dateEnd=Wed Oct 02 00:00:00 CEST 2019]";
        Assert.assertEquals(expected, session.toString());
    }
}
