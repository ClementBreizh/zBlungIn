package com.apsidepoei.projetpoei.database.contracts;

/**
 * User contract.
 * @author vianney
 *
 */
public class UserContract extends BaseContract {
  /**
   * Define the table name.
   */
  public static final String TABLE = "user";
  /**
   * defines the name of the column="id_user".
   */
  public static final String COL_ID = "id_user";
  /**
   * defines the name of the column="login".
   */
  public static final String COL_NAME = "login";
  /**
   * defines the name of the column="password".
   */
  public static final String COL_PASSWORD = "password";
  /**
   * defines the name of the column="role".
   */
  public static final String COL_ROLE = "role";

  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] { COL_ID, COL_NAME, COL_PASSWORD, COL_ROLE};
  /**
   * Define the string used for create the table.
   */

  // A FINIR !!!
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS )";

  /**
   * Constructor.
   */
  public UserContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}

