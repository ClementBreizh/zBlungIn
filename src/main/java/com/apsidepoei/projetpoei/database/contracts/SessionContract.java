package com.apsidepoei.projetpoei.database.contracts;

/**
 * This class is the Session contract.
 *
 * @author benjamin-m
 *
 */
public class SessionContract extends BaseContract {
  /**
   * Define the table name.
   */
  public static final String TABLE = "session";
  /**
   * defines the name of the column="id_session".
   */
  public static final String COL_ID = "id_session";
  /**
   * defines the name of the column="name".
   */
  public static final String COL_NAME = "name";
  /**
   * defines the name of the column="startDate".
   */
  public static final String COL_DATE_START = "startDate";
  /**
   * defines the name of the column="endDate".
   */
  public static final String COL_DATE_END = "endDate";
  /**
   * defines the name of the column="candidates".
   */
  public static final String COL_CANDIDATES = "candidates";

  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] { COL_ID, COL_NAME, COL_DATE_START,
      COL_DATE_END };

  /**
   * Define the string used for create the table.
   */
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_NAME + " VARCHAR(50) NOT NULL,"
      + COL_DATE_START + " DATE NOT NULL," + COL_DATE_END + " DATE NOT NULL" + ")";

  /**
   * Constructor.
   */
  public SessionContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
