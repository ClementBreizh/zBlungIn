package com.apsidepoei.projetpoei.database.contracts;

/**
 * This class is the Degree contract.
 *
 * @author thomas
 *
 */
public class DegreeContract extends BaseContract {

  /**
   * Define the table name.
   */
  public static final String TABLE = "degree";
  /**
   * defines the name of the column="id_degree".
   */
  public static final String COL_ID = "id_degree";
  /**
   * defines the name of the column="name".
   */
  public static final String COL_NAME = "name";
  /**
   * defines the name of the column="level".
   */
  public static final String COL_LEVEL = "level";
  /**
   * defines the name of the column="validation_date".
   */
  public static final String COL_VALIDATION_DATE = "validation_date";

  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] { COL_ID, COL_NAME, COL_LEVEL };

  /**
   * Define the string used for create the table.
   */
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_NAME + " VARCHAR(255) NOT NULL,"
      + COL_LEVEL + " VARCHAR(50) NOT NULL" + ")";

  /**
   * Constructor.
   */
  public DegreeContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
