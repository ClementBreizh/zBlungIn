package com.apsidepoei.projetpoei.database.contracts;

/**
 * Candidate contract.
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
  public static final String COL_ID = "id_person";

  /**
   * defines the name of the column="rankingCandidate".
   */
  public static final String COL_RANKING_CANDIDATE = "ranking_candidate";

  /**
   * defines the name of the column="statusCandidate".
   */
  public static final String COL_STATUS_CANDIDATE = "status_candidate";

  /**
   * defines the name of the column="sexCandidate".
   */
  public static final String COL_SEX_CANDIDATE = "sex_candidate";

  /**
   * defines the name of the column="feedback_id".
   */
  public static final String COL_FK_ID_FEEDBACK = "feedback_id";

  /**
   * defines the name of the column="degrees".
   */
  public static final String COL_DEGREES = "degrees";

  /**
   * defines the name of the column="matters".
   */
  public static final String COL_MATTERS = "matters";

  /**
   * defines the name of the column="companySession".
   */
  public static final String COL_FK_ID_COMPANYSESSION = "company_session";

  /**
   * defines the name of the column="address_id".
   */
  public static final String COL_FK_ID_ADDRESS = "address_id";

  /**
   * Define a table with all column.
   */
  protected static final String[] COLS = new String[] { COL_ID, COL_RANKING_CANDIDATE,
      COL_FK_ID_ADDRESS };

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
