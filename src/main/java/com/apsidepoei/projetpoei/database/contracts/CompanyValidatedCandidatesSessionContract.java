/**
 *
 */
package com.apsidepoei.projetpoei.database.contracts;

/**
 * @author thomas
 *
 */

public class CompanyValidatedCandidatesSessionContract extends BaseContract {

  /**
   * Define the table name .
   */
  public static final String TABLE = "compValCandSession";

  /**
   * defines the name of the column="company".
   */
  public static final String COL_ID= "id_compValCandSession";

  /**
   * defines the name of the column="company".
   */
  public static final String COL_COMPANY = "company";

  /**
   * defines the name of the column="candidate".
   */
  public static final String COL_VALIDATED_CANDIDATES = "validatedCandidates";

  /**
   * defines the name of the column="session".
   */
  public static final String COL_SESSION = "session";

  public CompanyValidatedCandidatesSessionContract(String table, String colId, String[] cols, String createtable) {
    super(table, colId, cols, createtable);
  }

}
