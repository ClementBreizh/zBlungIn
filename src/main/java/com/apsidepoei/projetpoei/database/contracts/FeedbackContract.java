/**
 *
 */
package com.apsidepoei.projetpoei.database.contracts;

/**
 * @author vianney
 *
 */
public class FeedbackContract extends BaseContract {

  public final static String TABLE = "feedback";

  public final static String COL_ID = "id";
  public final static String COL_TYPE_OF_CONTRACT = "typeOfContract";
  public final static String COL_DURATION_OF_CONTRACT = "durationOfContract";
  public final static String COL_COMMENT = "comment";

  public final static String[] COLS = new String[] { COL_ID, COL_TYPE_OF_CONTRACT, COL_DURATION_OF_CONTRACT,
      COL_COMMENT, };

  public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_TYPE_OF_CONTRACT + " VARCHAR(50) NOT NULL,"
      + COL_DURATION_OF_CONTRACT + " TINYINT NOT NULL," + COL_COMMENT + " VARCHAR(255) NOT NULL" + ")";

  public FeedbackContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
