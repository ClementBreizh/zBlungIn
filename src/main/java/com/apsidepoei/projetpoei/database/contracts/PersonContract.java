package com.apsidepoei.projetpoei.database.contracts;

/**
 * This class is the Appointment contract.
 *
 * @author vianney
 *
 */
public class PersonContract extends BaseContract {
  /**
   * Define the table name.
   */
  public static final String TABLE = "appointment";
  /**
   * Define the id column name.
   */
  public static final String COL_ID = "id_person";
  /**
   * Define the name column name.
   */
  public static final String COL_FIRSTNAME = "firstname";
  /**
   * Define the level column name.
   */
  public static final String COL_LASTNAME = "lastname";
  /**
   * Define the report column name.
   */
  public static final String COL_EMAIL = "email";
  /**
   * Define the report column name.
   */
  public static final String COL_CELL_PHONE = "cellPhone";
  /**
   * Define the report column name.
   */
  public static final String COL_HOME_PHONE = "homePhone";
  /**
   * Define the report column name.
   */
  public static final String COL_COMMENTARY = "commentary";
  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] { COL_ID, COL_FIRSTNAME, COL_LASTNAME, COL_EMAIL,
      COL_CELL_PHONE, COL_HOME_PHONE, COL_COMMENTARY };
  /**
   * Define the string used for create the table.
   */

  // A FINIR !!!
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS )";

  /**
   * Constructor.
   */
  public PersonContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
