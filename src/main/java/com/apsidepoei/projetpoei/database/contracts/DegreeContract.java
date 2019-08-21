package com.apsidepoei.projetpoei.database.contracts;

/**
 * @author thomas
 * This class is the Degree contract
 *
 */
public class DegreeContract extends BaseContract {

	/**
	 * Define the table name
	 */
    public final static String TABLE = "degree";
    /**
     * Define the id column name
     */
    public final static String COL_ID = "id_degree";
    /**
     * Define the name column name
     */
    public final static String COL_NAME = "name";
    /**
     * Define the level column name
     */
    public final static String COL_LEVEL = "level";

    /**
     * Define a table with all column
     */
    public final static String[] COLS = new String[] {
            COL_ID,
            COL_NAME,
            COL_LEVEL
    };

    /**
     * Define the string used for create the table
     */
    public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE +"(" +
            COL_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            COL_NAME + " VARCHAR(255) NOT NULL," +
            COL_LEVEL + " VARCHAR(50) NOT NULL" +
            ")";

    /**
     * Constructor
     */
    public DegreeContract() {
        super(TABLE, COL_ID, COLS, CREATE_TABLE);
    }
}
