/**
 *
 */
package com.apsidepoei.projetpoeitest.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.apsidepoei.projetpoei.database.DbManager;
import com.apsidepoei.projetpoei.entities.Feedback;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * @author vianney
 *
 */
public class FeedbackDaoUpdateTest {

    private static final String CHANGED_DATA_STRING = "toto";
    private static final Integer CHANGED_DATA_INTEGER = 123;
    private List<Feedback> feedbackes = new ArrayList<Feedback>();

    /**
     *
     * @throws SQLException
     * Before each test, drop & create the table and add / insert new feedbacks
     */
    @Before
    public void setupTests() throws SQLException {
        DbManager.getInstance().getFeedbackDao().drop();
        DbManager.getInstance().getFeedbackDao().create();

        feedbackes.clear();
        feedbackes.add(new Feedback("Feedback 1", 1, "commentaire 1"));
        feedbackes.add(new Feedback("Feedback 2", 2, "commentaire 2"));
        feedbackes.add(new Feedback("Feedback 3", 3, "commentaire 3"));

        for (Feedback feedback : feedbackes) {
            DbManager.getInstance().getFeedbackDao().insert(feedback);
        }
    }


    // Simple compare update feedback
    /**
     *
     * @throws SQLException
     * Compare modification with the update
     */
    @Test
    public void simpleUpdateCompareFeedback1() throws SQLException {
        Feedback feedback = feedbackes.get(0);
        feedback.setTypeOfContract(CHANGED_DATA_STRING);

        Feedback dbFeedback = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);
        DbManager.getInstance().getFeedbackDao().update(feedback);
        Feedback dbFeedbackUpdated = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);

        assertTrue(dbFeedback.getId() == dbFeedbackUpdated.getId() && !dbFeedback.getTypeOfContract().equals(dbFeedbackUpdated.getTypeOfContract())
                && dbFeedbackUpdated.getTypeOfContract().equals(CHANGED_DATA_STRING));
    }

    /**
     *
     * @throws SQLException
     * Compare modification with the update
     */
    @Test
    public void simpleUpdateCompareFeedback2() throws SQLException {
        Feedback feedback = feedbackes.get(0);
        feedback.setTypeOfContract(CHANGED_DATA_STRING);

        DbManager.getInstance().getFeedbackDao().update(feedback);
        Feedback dbFeedbackUpdated = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);

        assertTrue(feedback.getId() == dbFeedbackUpdated.getId() && feedback.getTypeOfContract().equals(dbFeedbackUpdated.getTypeOfContract()));
    }

    /**
     * Compare the modification with the update
     */
    @Test
    public void simpleUpdateCompareFeedback3() {
        Feedback feedback = feedbackes.get(0);
        Feedback dbFeedback = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);

        assertTrue(feedback.getId() == dbFeedback.getId() && feedback.getTypeOfContract().equals(dbFeedback.getTypeOfContract()));
    }

    // Simple compare postalCode
    /**
    *
    * @throws SQLException
    * Compare modification with the update
    */
   @Test
   public void simpleUpdateCompareDurationOfContract1() throws SQLException {
       Feedback feedback = feedbackes.get(0);
       feedback.setDurationOfContract(CHANGED_DATA_INTEGER);

       Feedback dbFeedback = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);
       DbManager.getInstance().getFeedbackDao().update(feedback);
       Feedback dbFeedbackUpdated = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);

       assertTrue(dbFeedback.getId() == dbFeedbackUpdated.getId() && !dbFeedback.getDurationOfContract().equals(dbFeedbackUpdated.getDurationOfContract())
               && dbFeedbackUpdated.getDurationOfContract().equals(CHANGED_DATA_INTEGER));
   }

   /**
    *
    * @throws SQLException
    * Compare modification with the update
    */
   @Test
   public void simpleUpdateCompareDurationOfContract2() throws SQLException {
       Feedback feedback = feedbackes.get(0);
       feedback.setDurationOfContract(CHANGED_DATA_INTEGER);

       DbManager.getInstance().getFeedbackDao().update(feedback);
       Feedback dbFeedbackUpdated = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);

       assertTrue(feedback.getId() == dbFeedbackUpdated.getId() && feedback.getDurationOfContract().equals(dbFeedbackUpdated.getDurationOfContract()));
   }

   /**
    * Compare the modification with the update
    */
   @Test
   public void simpleUpdateCompareDurationOfContract3() {
       Feedback feedback = feedbackes.get(0);
       Feedback dbFeedback = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);

       assertTrue(feedback.getId() == dbFeedback.getId() && feedback.getDurationOfContract().equals(dbFeedback.getDurationOfContract()));
   }

   // Simple compare town
   /**
   *
   * @throws SQLException
   * Compare modification with the update
   */
  @Test
  public void simpleUpdateCompareComment1() throws SQLException {
      Feedback feedback = feedbackes.get(0);
      feedback.setComment(CHANGED_DATA_STRING);

      Feedback dbFeedback = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);
      DbManager.getInstance().getFeedbackDao().update(feedback);
      Feedback dbFeedbackUpdated = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);

      assertTrue(dbFeedback.getId() == dbFeedbackUpdated.getId() && !dbFeedback.getComment().equals(dbFeedbackUpdated.getComment())
              && dbFeedbackUpdated.getComment().equals(CHANGED_DATA_STRING));
  }

  /**
   *
   * @throws SQLException
   * Compare modification with the update
   */
  @Test
  public void simpleUpdateCompareComment2() throws SQLException {
      Feedback feedback = feedbackes.get(0);
      feedback.setComment(CHANGED_DATA_STRING);

      DbManager.getInstance().getFeedbackDao().update(feedback);
      Feedback dbFeedbackUpdated = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);

      assertTrue(feedback.getId() == dbFeedbackUpdated.getId() && feedback.getComment().equals(dbFeedbackUpdated.getComment()));
  }

  /**
   * Compare the modification with the update
   */
  @Test
  public void simpleUpdateCompareComment3() {
      Feedback feedback = feedbackes.get(0);
      Feedback dbFeedback = (Feedback) DbManager.getInstance().getFeedbackDao().select(1);

      assertTrue(feedback.getId() == dbFeedback.getId() && feedback.getComment().equals(dbFeedback.getComment()));
  }


// verifying the Max size of the fields

  // veriying feedback
    /**
     *
     * @throws SQLException
     * Test if data is truncated when update is too long
     */
    @Test(expected = MysqlDataTruncation.class)
    public void updateMaxValExtendedTypeOfContract() throws SQLException {
        Feedback feedback = feedbackes.get(0);

        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            data.append("x");
        }
        feedback.setTypeOfContract(data.toString());

        DbManager.getInstance().getFeedbackDao().update(feedback);
    }

   /**
   *
   * @throws SQLException
   * Test if data is truncated when update is too long
   */
  @Test(expected = MysqlDataTruncation.class)
  public void updateMaxValExtendedComment() throws SQLException {
      Feedback feedback = feedbackes.get(0);

      StringBuilder data = new StringBuilder();
      for (int i = 0; i < 256; i++) {
          data.append("x");
      }
      feedback.setComment(data.toString());

      DbManager.getInstance().getFeedbackDao().update(feedback);
  }

//verifying the Min size of the fields

    /**
     *
     * @throws SQLException
     * Test the update with the min size of the value
     */
    @Test
    public void updateMinValOKTypeOfContract() throws SQLException {
        Feedback feedback = feedbackes.get(0);
        feedback.setTypeOfContract("");

        DbManager.getInstance().getFeedbackDao().update(feedback);
    }

   /**
   *
   * @throws SQLException
   * Test the update with the min size of the value
   */
  @Test
  public void updateMinValOKComment() throws SQLException {
      Feedback feedback = feedbackes.get(0);
      feedback.setComment("");

      DbManager.getInstance().getFeedbackDao().update(feedback);
  }

  // verifying with null value
    /**
     *
     * @throws SQLException
     * Test the update with null value
     */
    @Test(expected = MySQLIntegrityConstraintViolationException.class)
    public void updateNullValKOTypeOfContract() throws SQLException {
        Feedback feedback = feedbackes.get(0);
        feedback.setTypeOfContract(null);

        DbManager.getInstance().getFeedbackDao().update(feedback);
    }

    /**
     *
     * @throws SQLException
     * Test the update with null value
     */
//    @Test
//    public void updateNullValKODurationOfContract() {
//       Feedback feedback = feedbackes.get(0);
//       feedback.setDurationOfContract(null);
//
//       try {
//        DbManager.getInstance().getFeedbackDao().update(feedback);
//       } catch (SQLException e) {
//           e.printStackTrace();
//       }
//       assertTrue()
//    }

    /**
     *
     * @throws SQLException
     * Test the update with null value
     */
    @Test(expected = MySQLIntegrityConstraintViolationException.class)
    public void updateNullValKOComment() throws SQLException {
       Feedback feedback = feedbackes.get(0);
       feedback.setComment(null);

       DbManager.getInstance().getFeedbackDao().update(feedback);
    }

    /**
     * Test the update with the wrong id
     * @throws SQLException
     */
    @Test
    public void updateWrongId() throws SQLException {
        Feedback feedback = feedbackes.get(0);
        feedback.setId(4);
        feedback.setTypeOfContract(CHANGED_DATA_STRING);

        assertEquals(new Integer(0), DbManager.getInstance().getFeedbackDao().update(feedback));
    }

    /**
     *
     * @throws SQLException
     * Test the update with the good id
     */
    @Test
    public void updateGoodId() throws SQLException {
        Feedback feedback = feedbackes.get(0);
        feedback.setTypeOfContract(CHANGED_DATA_STRING);

        assertEquals(new Integer(1), DbManager.getInstance().getFeedbackDao().update(feedback));
    }

}
