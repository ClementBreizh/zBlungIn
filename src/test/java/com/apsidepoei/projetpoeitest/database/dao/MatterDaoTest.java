package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Matter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** Test SELECT function on database. */
public class MatterDaoTest {

  static List<Matter> matterss = new ArrayList<Matter>();

  /** setup for the test. */
  @BeforeClass
  public static void config() {
    Matter matters1 = new Matter("matters1");
    Matter matters2 = new Matter("matters2");
    Matter matters3 = new Matter("matters3");
    matters1.setId(1);
    matters2.setId(2);
    matters3.setId(3);
    matterss.add(matters1);
    matterss.add(matters2);
    matterss.add(matters3);
  }

  /** config database. */
  @Before
  public void drop() throws Exception {
    DbManager.getInstance().getMatterDao().drop();
    DbManager.getInstance().getMatterDao().create();
    DbManager.getInstance().getMatterDao().insert(matterss.get(0));
    DbManager.getInstance().getMatterDao().insert(matterss.get(1));
    DbManager.getInstance().getMatterDao().insert(matterss.get(2));
  }

  @Test
  /**  SelectAll test */
  public void selectAll() throws Exception {
    assertNotNull(DbManager.getInstance().getMatterDao().select());
  }

  @Test
  /** Select all with count */
  public void selectAllCount() throws Exception {
    List<Matter> listObjects = DbManager.getInstance().getMatterDao().select();
    DbManager.getInstance().getMatterDao().select();
    assertEquals(3, listObjects.size());
  }

  @Test
  /** Test if data insert is correct . */
  public void dataCompare() throws Exception {
    List<Matter> listObjects = DbManager.getInstance().getMatterDao().select();

    assertTrue((matterss.get(0).getId() == ((Matter) listObjects.get(0)).getId())
        && (matterss.get(0).getName().equals(((Matter) listObjects.get(0)).getName())));
  }
}
