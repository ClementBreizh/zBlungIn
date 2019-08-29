/**
 *
 */
package com.apsidepoei.projetpoei.database.contracts;

/**
 * @author vianney
 *
 */
public class AcquiredMattersContract extends BaseContract {

  /**
   * Define the table name.
   */
  public static final String TABLE = "AcquiredMatters";
  /**
   * defines the name of the column="id_acquired_matters".
   */
  public static final String COL_ID = "id_acquired_matters";
  /**
   * defines the name of the column="score".
   */
  public final static String COL_SCORE = "score";
  /**
   * defines the name of the column="validation_date".
   */
  public final static String COL_VALIDATION_DATE = "validation_date";
  /**
   * defines the name of the column="id_matter".
   */
  public final static String COL_FK_ID_MATTER = "id_matter";
  /**
   * defines the name of the column="candidate_id".
   */
  public final static String COL_FK_ID_CANDIDATE = "id_candidate";
  /**
   * defines the name of the column="candidate_id".
   */
  public final static String COL_COLUMN_ID_CANDIDATE = PersonContract.COL_ID;

  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] { COL_ID, COL_SCORE, COL_VALIDATION_DATE};

  /**
   * Define the string used for create the table.
   */
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS )";

  /**
   * Constructor.
   */
  public AcquiredMattersContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
