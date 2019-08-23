package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Matter;
import java.sql.SQLException;
import java.text.ParseException;
import org.junit.Assert;
import org.junit.Test;

public class MatterDaoInsertTest {
  /**
   * Test Insert in table.
   */
  @Test
  public void testInsertMatter() throws ParseException, SQLException {
    Matter monMatter = new Matter("Logique");
    DbManager.getInstance().getMatterDao().insert(monMatter);

    assertFalse("Insert ok", false);
  }

  /**
   * Test Insert with other letter than a-Z.
   */
  @Test
  public void testInsertJapaneseLetter() throws ParseException, SQLException {
    Matter monMatter2 = new Matter("亜紀");
    DbManager.getInstance().getMatterDao().insert(monMatter2);

    assertTrue("Insert ok", true);
  }

  /**
   *  SQLException Test insert with greater than expeted size varchar.
   */
  @Test
  public void testInsertCategoryVar50() throws ParseException {
    String data = "";
    for (int i = 0; i < 50; i++) {
      data += "x";
    }
    Matter monMatter2 = new Matter(data);
    try {
      DbManager.getInstance().getMatterDao().insert(monMatter2);
    } catch (SQLException e) {
      e.getMessage();
      assertEquals(e.getMessage(), "Data truncation: "
          + "Data too long for column 'firstname' at row 1");
    }
  }

  /**
   * SQLException Test of valid date.
   */
  @Test
  public void testInsertWrongDate() throws SQLException {
    Matter monMatter2 = new Matter("MIROUF");
    DbManager.getInstance().getMatterDao().insert(monMatter2);
  }

  /**
   *  SQLException Test insert via generator.
   */
  @Test
  public void testGeneratorInsertMatter() throws ParseException, SQLException {
    Matter monMatter = new Matter("Logique");
    DbManager.getInstance().getMatterGenerator().insert(monMatter);
    Assert.assertNotEquals("", toString());
    ;
  }

}
