package com.apsidepoei.projetpoeitest.entities;

import java.text.ParseException;
import org.junit.Assert;
import org.junit.Test;

import com.apsidepoei.projetpoei.entities.Matters;

/**
 *
 * @author clemb Test to string function
 */
public class MattersTest {
    /**
     * Test the toString()
     *
     * @throws ParseException
     */
    @Test
    public void testToString() throws ParseException {

        Matters matters = new Matters("Mon Super nom");
        matters.setId(1);
        String expected = "Matters [Id = 1, name= Mon Super nom]";
        Assert.assertEquals(expected, matters.toString());
    }
}
