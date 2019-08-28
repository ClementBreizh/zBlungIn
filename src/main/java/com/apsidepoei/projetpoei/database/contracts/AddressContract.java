package com.apsidepoei.projetpoei.database.contracts;

/**
 * This class is the Degree contract.
 * @author vianney
 *
 */

public class AddressContract extends BaseContract {

  /**
   * Define the table name.
   */
  public static final String TABLE = "address";

  /**
   * defines the name of the column="id_address".
   */
  public static final String COL_ID = "id_address";

  /**
   * defines the name of the column="address".
   */
  public static final String COL_ADDRESS = "address";

  /**
   * defines the name of the column="postalCode".
   */
  public static final String COL_POSTAL_CODE = "postalCode";

  /**
   * defines the name of the column="town".
   */
  public static final String COL_TOWN = "town";

  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] { COL_ID, COL_ADDRESS, COL_POSTAL_CODE,
      COL_TOWN };

  /**
   * Define the sql request used for create the table in database.
   */
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_ADDRESS + " VARCHAR(255) NOT NULL,"
      + COL_POSTAL_CODE + " VARCHAR(5) NOT NULL," + COL_TOWN + " VARCHAR(255) NOT NULL" + ")";

  /**
   * Constructor.
   */
  public AddressContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
