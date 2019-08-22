/**
 *
 */
package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Feedback;

/**
 * @author vianney
 *
 */
public class FeedbackDaoSelectTest {

  static List<Feedback> feedbacks = new ArrayList<Feedback>();

  @BeforeClass
  public static void config() {
    Feedback feedback1 = new Feedback("feedback 1", 1, "commentaire 1");
    Feedback feedback2 = new Feedback("feedback 2", 2, "commentaire 2");
    Feedback feedback3 = new Feedback("feedback 3", 3, "commentaire 3");
    feedback1.setId(1);
    feedback2.setId(2);
    feedback3.setId(3);
    feedbacks.add(feedback1);
    feedbacks.add(feedback2);
    feedbacks.add(feedback3);
  }

  @Before
  public void drop() throws Exception {
    DbManager.getInstance().getFeedbackDao().drop();
    DbManager.getInstance().getFeedbackDao().create();
    DbManager.getInstance().getFeedbackDao().insert(feedbacks.get(0));
    DbManager.getInstance().getFeedbackDao().insert(feedbacks.get(1));
    DbManager.getInstance().getFeedbackDao().insert(feedbacks.get(2));
  }

  @Test
  public void selectAll() throws Exception {
    assertNotNull(DbManager.getInstance().getFeedbackDao().select());
  }

  @Test
  public void selectAllCount() throws Exception {
    List<Feedback> listObjects = DbManager.getInstance().getFeedbackDao().select();
    DbManager.getInstance().getFeedbackDao().select();
    assertEquals(3, listObjects.size());
  }

  @Test
  public void dataCompare() throws Exception {
    List<Feedback> listObjects = DbManager.getInstance().getFeedbackDao().select();

    assertTrue((feedbacks.get(0).getId() == (listObjects.get(0).getId())
        && (feedbacks.get(0).getTypeOfContract().equals(listObjects.get(0).getTypeOfContract())
            && (feedbacks.get(0).getDurationOfContract()
                .equals(listObjects.get(0).getDurationOfContract())
                && (feedbacks.get(0).getComment().equals(listObjects.get(0).getComment()))))));
  }

}
