/**
 *
 */
package com.apsidepoei.projetpoei.database.contracts;

/**
 * @author vianney
 *
 */
public class AdressContract  extends BaseContract {

    public final static String TABLE = "adress";

    public final static String COL_ID = "id";
    public final static String COL_ADRESS = "adress";
    public final static String COL_POSTAL_CODE = "postalCode";
    public final static String COL_TOWN = "town";


    public final static String[] COLS = new String[] {
            COL_ID,
            COL_ADRESS,
            COL_POSTAL_CODE,
            COL_TOWN,
    };

    public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE +"(" +
            COL_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            COL_ADRESS + " VARCHAR(255) NOT NULL," +
            COL_POSTAL_CODE + " VARCHAR(5) NOT NULL," +
            COL_TOWN + " VARCHAR(255) NOT NULL" +
            ")";

    public AdressContract() {
        super(TABLE, COL_ID, COLS, CREATE_TABLE);
    }
}
