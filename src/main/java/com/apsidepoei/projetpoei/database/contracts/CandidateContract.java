/**
 *
 */
package com.apsidepoei.projetpoei.database.contracts;

/**
 * @author vianney
 *
 */
public class CandidateContract extends BaseContract {

  /**
   * Define the table name.
   */
  public static final String TABLE = "candidate";

  /**
   * defines the name of the column="id".
   */
  public static final String COL_ID = "id_candidate";

  /**
   * defines the name of the column="rankingCandidate".
   */
  public static final String COL_RANKING_CANDIDATE = "rankingCandidate";

  /**
   * defines the name of the column="rankingCandidate".
   */
  public static final String COL_FK_ID_FEEDBACK = "feedback_id";
  /**
   * Define the report column name.
   */
  public static final String COL_DEGREES = "degrees";
  /**
   * Define the report column name.
   */
  public static final String COL_MATTERS = "matters";
  /**
   * Define the report column name.
   */
  public static final String COL_SESSIONS = "sessions";
  /**
   * Define the report column name.
   */
  public static final String COL_ASSESSMENTS = "assessments";

  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] { COL_ID, COL_RANKING_CANDIDATE };

  /**
   * Define the sql request used for create the table in database.
   */
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS )";

  /**
   * defines the name of the column="town".
   */
  public static final String COL_TOWN = "town";

  public CandidateContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
