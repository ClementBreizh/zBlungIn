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
   * defines the name of the column="id_company".
   */
  public static final String COL_ID = "id_company";
  /**
   * defines the name of the column="name".
   */
  public static final String COL_NAME = "name";
  /**
   * defines the name of the column="antenna_name".
   */
  public static final String COL_ANTENNANAME = "antenna_name";
  /**
   * defines the name of the column="siret".
   */
  public static final String COL_SIRET = "siret";
  /**
   * defines the name of the column="ape_code".
   */
  public static  final String COL_APECODE = "ape_code";
  /**
   * Define name of the contacts column.
   */
  public static final String COL_FK_ID_CONTACTS = "contacts";
  /**
   * Define the name of the address column.
   */
  public static final String COL_FK_ID_ADDRESS = "address";

  /**
   * Define a table with all column.
   */
  protected static final String[] COLS = new String[] { COL_ID, COL_NAME, COL_ANTENNANAME, COL_SIRET,
      COL_APECODE };


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
