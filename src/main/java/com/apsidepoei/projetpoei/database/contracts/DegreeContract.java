package com.apsidepoei.projetpoei.database.contracts;

public class DegreeContract extends BaseContract {

    public final static String TABLE = "degree";

    public final static String COL_ID = "id_degree";
    public final static String COL_NAME = "name";
    public final static String COL_LEVEL = "level";

    public final static String[] COLS = new String[] {
            COL_ID,
            COL_NAME,
            COL_LEVEL
    };

    public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE +"(" +
            COL_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            COL_NAME + " VARCHAR(255) NOT NULL," +
            COL_LEVEL + " VARCHAR(50) NOT NULL" +
            ")";

    public DegreeContract() {
        super(TABLE, COL_ID, COLS, CREATE_TABLE);
    }
}
