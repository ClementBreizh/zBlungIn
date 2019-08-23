/**
 *
 */
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
  public final static String TABLE = "adress";

  /**
   * defines the name of the column="id"
   */
  public final static String COL_ID = "id";

  /**
   * defines the name of the column="address"
   */
  public final static String COL_ADDRESS = "address";

  /**
   * defines the name of the column="postalCode"
   */
  public final static String COL_POSTAL_CODE = "postalCode";

  /**
   * defines the name of the column="town"
   */
  public final static String COL_TOWN = "town";

  /**
   * Define a table with all column.
   */
  public final static String[] COLS = new String[] { COL_ID, COL_ADDRESS, COL_POSTAL_CODE,
      COL_TOWN };

  /**
   * Define the sql request used for create the table in database.
   */
  public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_ADDRESS + " VARCHAR(255) NOT NULL,"
      + COL_POSTAL_CODE + " VARCHAR(5) NOT NULL," + COL_TOWN + " VARCHAR(255) NOT NULL" + ")";

  /**
   * Constructor.
   */
  public AddressContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
