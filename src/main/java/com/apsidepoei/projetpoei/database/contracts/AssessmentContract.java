package com.apsidepoei.projetpoei.database.contracts;

public class AssessmentContract extends BaseContract {

  public static final String TABLE = "assessment";

  public static final String COL_ID = "id";
  public static final String COL_CATEGORY = "category";
  public static final String COL_DATE = "majTest";

  public static final String[] COLS = new String[] { COL_ID, COL_CATEGORY, COL_DATE };

  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
      + COL_CATEGORY + " VARCHAR(50) NOT NULL," + COL_DATE
      + " DATETIME NOT NULL)";

  public AssessmentContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
