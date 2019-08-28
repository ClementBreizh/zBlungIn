/**
 *
 */
package com.apsidepoei.projetpoei.database.contracts;

/**
 * @author thomas
 *
 */
public class CompanyCandidatesSessionContract extends BaseContract {

  /**
   * Define the table name .
   */
  public static final String TABLE = "companyCandidateSession";

  /**
   * defines the name of the column="company".
   */
  public static final String COL_ID= "id_companyCandidateSession";

  /**
   * defines the name of the column="company".
   */
  public static final String COL_COMPANY = "company";

  /**
   * defines the name of the column="candidate".
   */
  public static final String COL_CANDIDATES = "candidates";

  /**
   * defines the name of the column="session".
   */
  public static final String COL_SESSION = "session";

  public CompanyCandidatesSessionContract(String table, String colId, String[] cols, String createtable) {
    super(table, colId, cols, createtable);
  }

}
