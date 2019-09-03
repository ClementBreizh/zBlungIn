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
  public static final String TABLE = "person";
  /**
   * defines the name of the column="id_person".
   */
  public static final String COL_ID = "id_person";
  /**
   * defines the name of the column="firstname".
   */
  public static final String COL_FIRSTNAME = "firstname";
  /**
   * defines the name of the column="lastname".
   */
  public static final String COL_LASTNAME = "lastname";
  /**
   * defines the name of the column="email".
   */
  public static final String COL_EMAIL = "email";
  /**
   * defines the name of the column="cellPhone".
   */
  public static final String COL_CELL_PHONE = "cellPhone";
  /**
   * defines the name of the column="homePhone".
   */
  public static final String COL_HOME_PHONE = "homePhone";
  /**
   * defines the name of the column="commentary".
   */
  public static final String COL_COMMENTARY = "commentary";

  /**
   * Define name of column mainContact
   */
  public static final String COL_MAINCONTACT = "mainContact";

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
