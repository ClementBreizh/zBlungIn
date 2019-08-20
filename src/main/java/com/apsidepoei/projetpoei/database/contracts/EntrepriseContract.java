package com.apsidepoei.projetpoei.database.contracts;

public class EntrepriseContract extends BaseContract {

    public final static String TABLE = "entreprise";

    public final static String COL_ID = "id";
    public final static String COL_NOM = "nom";
    public final static String COL_NOM_ANTENNE = "nomAntenne";
    public final static String COL_SIRET = "siret";
    public final static String COL_CODE_APE = "codeApe";

    public final static String[] COLS = new String[] {
            COL_ID,
            COL_NOM,
            COL_NOM_ANTENNE,
            COL_SIRET,
            COL_CODE_APE
    };

    public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE +"(" +
            COL_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            COL_NOM + " VARCHAR(50) NOT NULL," +
            COL_NOM_ANTENNE + " VARCHAR(50) NOT NULL," +
            COL_SIRET + " VARCHAR(50) NOT NULL," +
            COL_CODE_APE + " VARCHAR(5) NOT NULL" +
            ")";

    public EntrepriseContract() {
        super(TABLE, COL_ID, COLS, CREATE_TABLE);
    }

}
