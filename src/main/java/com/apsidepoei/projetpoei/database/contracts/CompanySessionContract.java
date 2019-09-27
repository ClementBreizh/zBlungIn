/**
 *
 */
package com.apsidepoei.projetpoei.database.contracts;

/**
 * @author thomas
 *
 */

public class CompanySessionContract extends BaseContract {

  /**
   * Define the table name .
   */
  public static final String TABLE = "companySession";
  /**
   * defines the name of the column="company".
   */
  public static final String COL_ID = "id_company_session";
  /**
   * defines the name of the column="company".
   */
  public static final String COL_COMPANY = "company";
  /**
   * Define name of column mainContact
   */
  public static final String COL_VALIDATED = "validated";

  /**
   * defines the name of the column="session".
   */
  public static final String COL_SESSION = "session";

  public CompanySessionContract(String table, String colId, String[] cols, String createtable) {
    super(table, colId, cols, createtable);
  }

}
