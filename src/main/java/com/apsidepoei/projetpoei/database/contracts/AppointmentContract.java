/**
 *
 */
package com.apsidepoei.projetpoei.database.contracts;

/**
 * @author thomas
 * This class is the Appointment contract
 *
 */
public class AppointmentContract extends BaseContract{

	/**
	 * Define the table name
	 */
    public final static String TABLE = "appointment";
    /**
     * Define the id column name
     */
    public final static String COL_ID = "id_appointment";
    /**
     * Define the name column name
     */
    public final static String COL_INFORMATIONS = "informations";
    /**
     * Define the level column name
     */
    public final static String COL_DATETIME = "dateTime";
    /**
    * Define the level column name
    */
   public final static String COL_REPORT = "report";

    /**
     * Define a table with all column
     */
    public final static String[] COLS = new String[] {
            COL_ID,
            COL_INFORMATIONS,
            COL_DATETIME,
            COL_REPORT
    };

    /**
     * Define the string used for create the table
     */
    public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE +"(" +
            COL_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            COL_INFORMATIONS + " VARCHAR(255)," +
            COL_DATETIME + " DATE NOT NULL," +
            COL_REPORT + " TEXT" +
            ")";

    /**
     * Constructor
     */
    public AppointmentContract() {
        super(TABLE, COL_ID, COLS, CREATE_TABLE);
    }
}
