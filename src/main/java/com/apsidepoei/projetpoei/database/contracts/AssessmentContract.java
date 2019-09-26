package com.apsidepoei.projetpoei.database.contracts;

public class AssessmentContract extends BaseContract {

  /**
   * Define the table name.
   */
  public static final String TABLE = "assessment";

  /**
   * defines the name of the column="id_assessment".
   */
  public static final String COL_ID = "id_assessment";

  public final static String COL_SCORE = "score";
  /**
   * defines the name of the column="validation_date".
   */
  public final static String COL_VALIDATION_DATE = "validation_date";
  /**
   * defines the name of the column="id_candidate".
   */
  public final static String COL_FK_ID_CANDIDATE = "id_candidate";
  /**
   * defines the name of the column="candidate_id".
   */
  public final static String COL_COLUMN_ID_CANDIDATE = PersonContract.COL_ID;
  /**
   * defines the name of the column="category".
   */
  public static final String COL_CATEGORY = "category";
  /**
   * defines the name of the column="updatingDate".
   */
  public static final String COL_DATE = "updatingDate";


  public static final String[] COLS = new String[] { COL_ID, COL_CATEGORY, COL_DATE };

  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
      + COL_CATEGORY + " VARCHAR(50) NOT NULL," + COL_DATE
      + " DATETIME NOT NULL)";

  /**
   * Constructor.
   */

  public AssessmentContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
