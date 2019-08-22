package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Matter;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/** Test UPDATE function on database. */
public class MatterDaoUpdateTest {

  private static final String CHANGED_DATA = "toto";
  private List<Matter> matterss = new ArrayList<Matter>();

  /**
   * setup for the test.
   */
  @Before
  public void setupTests() throws SQLException {
    DbManager.getInstance().getMatterDao().drop();
    DbManager.getInstance().getMatterDao().create();

    matterss.clear();
    matterss.add(new Matter(1, "matters1"));
    matterss.add(new Matter(2, "matters2"));
    matterss.add(new Matter(3, "matters3"));

    for (Matter matters : matterss) {
      DbManager.getInstance().getMatterDao().insert(matters);
    }
  }

  /** Compare data. */
  @Test
  public void simpleUpdateCompare1() throws SQLException {
    Matter matters = matterss.get(0);
    matters.setName(CHANGED_DATA);

    Matter dbMatter = (Matter) DbManager.getInstance().getMatterDao().select(1);
    DbManager.getInstance().getMatterDao().update(matters);
    Matter dbMatterUpdated = (Matter) DbManager.getInstance().getMatterDao().select(1);

    assertTrue(dbMatter.getId() == dbMatterUpdated.getId()
        && !dbMatter.getName().equals(dbMatterUpdated.getName())
        && dbMatterUpdated.getName().equals(CHANGED_DATA));
  }

  /**
   * Simple Update test compare.
   */
  @Test
  public void simpleUpdateCompare2() throws SQLException {
    Matter matters = matterss.get(0);
    matters.setName(CHANGED_DATA);

    DbManager.getInstance().getMatterDao().update(matters);
    Matter dbMatterUpdated = (Matter) DbManager.getInstance().getMatterDao().select(1);

    assertTrue(matters.getId() == dbMatterUpdated.getId()
        && matters.getName().equals(dbMatterUpdated.getName()));
  }

  /**
   * Simple Update test compare.
   */
  @Test
  public void simpleUpdateCompare3() {
    Matter matters = matterss.get(0);
    Matter dbMatter = (Matter) DbManager.getInstance().getMatterDao().select(1);

    assertTrue(matters.getId() == dbMatter.getId() && matters.getName().equals(dbMatter.getName()));
  }

  /**
   * Test number of character.
   */
  @Test(expected = MysqlDataTruncation.class)
  public void updateMaxValExtended() throws SQLException {
    Matter matters = matterss.get(0);

    StringBuilder data = new StringBuilder();
    for (int i = 0; i < 255; i++) {
      data.append("x");
    }
    matters.setName(data.toString());

    DbManager.getInstance().getMatterDao().update(matters);
  }

  /**
   * Test number of character.
   */
  @Test
  public void updateMaxValOK() throws SQLException {
    Matter matters = matterss.get(0);

    StringBuilder data = new StringBuilder();
    for (int i = 0; i < 50; i++) {
      data.append("x");
    }
    matters.setName(data.toString());

    DbManager.getInstance().getMatterDao().update(matters);
  }

  /** Test update with a empty string. */
  @Test
  public void updateMinValOK() throws SQLException {
    Matter matters = matterss.get(0);
    matters.setName("");

    DbManager.getInstance().getMatterDao().update(matters);
  }

  /** Test update with NULL. */
  @Test(expected = MySQLIntegrityConstraintViolationException.class)
  public void updateNullValKO() throws SQLException {
    Matter matters = matterss.get(0);
    matters.setName(null);

    DbManager.getInstance().getMatterDao().update(matters);
  }

  /** Test with wrong id. */
  @Test
  public void updateWrongId() throws SQLException {
    Matter matters = matterss.get(0);
    matters.setId(4);
    matters.setName(CHANGED_DATA);

    assertEquals(new Integer(0), DbManager.getInstance().getMatterDao().update(matters));
  }

  /** Test with good id. */
  @Test
  public void updateGoodId() throws SQLException {
    Matter matters = matterss.get(0);
    matters.setName(CHANGED_DATA);

    assertEquals(new Integer(1), DbManager.getInstance().getMatterDao().update(matters));
  }
}
