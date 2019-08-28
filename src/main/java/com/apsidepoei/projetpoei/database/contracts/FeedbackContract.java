package com.apsidepoei.projetpoei.database.contracts;

/**
 * This class is the Degree contract.
 * @author vianney
 *
 */
public class FeedbackContract extends BaseContract {

  /**
   * Define the table name.
   */
  public static final String TABLE = "feedback";

  /**
   * defines the name of the column="id".
   */
  public static final String COL_ID = "id_feedback";

  /**
   * defines the name of the column="typeOfContract".
   */
  public static final String COL_TYPE_OF_CONTRACT = "typeOfContract";

  /**
   * defines the name of the column="durationOfContract".
   */
  public static final String COL_DURATION_OF_CONTRACT = "durationOfContract";
  /**
   * defines the name of the column="comment".
   */
  public static final String COL_COMMENT = "comment";

  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] { COL_ID, COL_TYPE_OF_CONTRACT,
      COL_DURATION_OF_CONTRACT, COL_COMMENT, };

  /**
   * Define the sql request used for create the table in database.
   */
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_TYPE_OF_CONTRACT
      + " VARCHAR(50) NOT NULL," + COL_DURATION_OF_CONTRACT + " TINYINT NOT NULL," + COL_COMMENT
      + " VARCHAR(255) NOT NULL" + ")";

  /**
   * Constructor.
   */
  public FeedbackContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
