package com.apsidepoei.projetpoei.database.contracts;

/**
 * This class is the Company contract.
 * @author benjamin-m
 *
 */

public class CompanyContract extends BaseContract {

  /**
   * Define the table name.
   */
  public static final String TABLE = "company";
  /**
   * Define the id column name.
   */
  public static final String COL_ID = "id_company";
  /**
   * Define the name column name.
   */
  public static final String COL_NAME = "name";
  /**
   * Define the name of antenna column name.
   */
  public static final String COL_ANTENNANAME = "antennaName";
  /**
   * Define the siret column name.
   */
  public static final String COL_SIRET = "siret";
  /**
   * Define the APE code column name.
   */
  public static  final String COL_APECODE = "apeCode";
  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] { COL_ID, COL_NAME, COL_ANTENNANAME, COL_SIRET,
      COL_APECODE };

  /**
   * Define name of the contacts column.
   */
  public static final String COL_FK_ID_CONTACTS = "contacts";

  /**
   * Define name of the main contact column.
   */
  public static final String COL_FK_ID_MAINCONTACT = "mainContact";

  /**
   * Define the name of the adresses column.
   */
  public static final String COL_FK_ID_ADRESSES = "adresses";

  /**
   * Define the name of the sessions column.
   */
  public static final String COL_SESSIONS = "sessions";


  /**
   * Define the string used for create the table.
   */
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_NAME + " VARCHAR(50) NOT NULL,"
      + COL_ANTENNANAME + " VARCHAR(50) NOT NULL," + COL_SIRET + " VARCHAR(50) NOT NULL,"
      + COL_APECODE + " VARCHAR(5) NOT NULL" + ")";

  /**
   * Constructor.
   */
  public CompanyContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }

}
