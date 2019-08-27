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
  public static final String COL_ID = "id";
  /**
   * Define the name column name.
   */
  public static final String COL_NOM = "nom";
  /**
   * Define the name of antenna column name.
   */
  public static final String COL_NOM_ANTENNE = "nomAntenne";
  /**
   * Define the siret column name.
   */
  public static final String COL_SIRET = "siret";
  /**
   * Define the APE code column name.
   */
  public static  final String COL_CODE_APE = "codeApe";
  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] { COL_ID, COL_NOM, COL_NOM_ANTENNE, COL_SIRET,
      COL_CODE_APE };

  /**
   * Define the string used for create the table.
   */
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_NOM + " VARCHAR(50) NOT NULL,"
      + COL_NOM_ANTENNE + " VARCHAR(50) NOT NULL," + COL_SIRET + " VARCHAR(50) NOT NULL,"
      + COL_CODE_APE + " VARCHAR(5) NOT NULL" + ")";

  /**
   * Constructor.
   */
  public CompanyContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }

}
