package com.apsidepoei.projetpoeitest.entities;

import com.apsidepoei.projetpoei.entities.Assessment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test to string function.
 */
public class AssessmentTest {

  /**
   * Test the toString().
   */
  @Test
  public void testToString() throws ParseException {

    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date mySqlDate = sdf.parse("2019-08-20 02:05:00");

    Assessment assessment = new Assessment("Categorie 42", mySqlDate);
    assessment.setId(1);
    String expected = "Assessment [Id = 1, "
        + "category =Categorie 42, date=Tue Aug 20 02:05:00 CEST 2019]";
    Assert.assertEquals(expected, assessment.toString());
  }
}
