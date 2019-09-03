package com.apsidepoei.projetpoeitest.entities;

import com.apsidepoei.projetpoei.entities.Assessment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    LocalDate localDate = LocalDate.of(2016, 8, 19);
    Assessment assessment = new Assessment("Categorie 42", localDate);
    assessment.setId(1);
    String expected = "Assessment [Id = 1, "
        + "category =Categorie 42, date=Tue Aug 20 02:05:00 CEST 2019]";
    Assert.assertEquals(expected, assessment.toString());
  }
}
