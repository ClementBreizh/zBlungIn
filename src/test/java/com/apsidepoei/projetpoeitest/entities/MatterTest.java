package com.apsidepoei.projetpoeitest.entities;

import java.text.ParseException;
import org.junit.Assert;
import org.junit.Test;

import com.apsidepoei.projetpoei.entities.Matter;

/**
 *
 * @author clemb Test to string function
 */
public class MatterTest {
    /**
     * Test the toString()
     *
     * @throws ParseException
     */
    @Test
    public void testToString() throws ParseException {

        Matter matters = new Matter("Mon Super nom");
        matters.setId(1);
        String expected = "Matter [Id = 1, name= Mon Super nom]";
        Assert.assertEquals(expected, matters.toString());
    }
}
