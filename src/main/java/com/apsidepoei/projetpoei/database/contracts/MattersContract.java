package com.apsidepoei.projetpoei.database.contracts;

public class MattersContract extends BaseContract {

    public final static String TABLE = "matters";

    public final static String COL_ID = "id";
    public final static String COL_NAME = "name";

    public final static String[] COLS = new String[] { COL_ID, COL_NAME };

    public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
            + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_NAME + " VARCHAR(50) NOT NULL" + ")";

    public MattersContract() {
        super(TABLE, COL_ID, COLS, CREATE_TABLE);
    }
}
