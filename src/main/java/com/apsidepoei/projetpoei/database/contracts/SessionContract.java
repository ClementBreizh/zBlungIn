package com.apsidepoei.projetpoei.database.contracts;

/**
 * This class is the Session contract.
 * @author benjamin-m
 *
 */
public class SessionContract extends BaseContract {
  /**
   * Define the table name.
   */
  public static final String TABLE = "session";
  /**
   * Define the id column name.
   */
  public static final String COL_ID = "id_session";
  /**
   * Define the name column name.
   */
  public static final String COL_NAME = "name";
  /**
   * Define the dateStart column name.
   */
  public static final String COL_DATESTART = "dateStart";
  /**
   * Define the dateEnd column name.
   */
  public static final String COL_DATEEND = "dateEnd";

  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] { COL_ID, COL_NAME, COL_DATESTART, COL_DATEEND };

  /**
   * Define the string used for create the table.
   */
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_NAME + " VARCHAR(50) NOT NULL,"
      + COL_DATESTART + " DATE NOT NULL," + COL_DATEEND + " DATE NOT NULL" + ")";

  /**
   * Constructor.
   */
  public SessionContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
