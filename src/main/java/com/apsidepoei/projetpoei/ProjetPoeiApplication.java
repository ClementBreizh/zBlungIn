package com.apsidepoei.projetpoei;

import java.sql.SQLException;
import java.text.ParseException;

import com.apsidepoei.projetpoei.database.DbManager;
import com.tactfactory.consolelogger.ConsoleLogger;
import com.tactfactory.consolelogger.GlobalLogger;
import com.tactfactory.consolelogger.Options;

import com.apsidepoei.projetpoei.entities.Adress;
import com.apsidepoei.projetpoei.entities.Matiere;

public final class ProjetPoeiApplication {

    private ProjetPoeiApplication() {

    }

    /**
    *
    * @param args
    * @throws ParseException
    * @throws SQLException
    */
    public static void main(String[] args) throws ParseException, SQLException {

         adressTests();
    }


    private static final void adressTests () throws SQLException {

//        DbManager.getInstance().getAdressDao().drop();
        DbManager.getInstance().getAdressDao().create();
        Adress adress1 = new Adress("51 rue de l'alma", "35000", "rennes");
        DbManager.getInstance().getAdressDao().insert(adress1);

        Adress adress2 = new Adress("31 rue de la rabine", "35530", "noyal sur vilaine");
        DbManager.getInstance().getAdressDao().insert(adress2);

        for (Object obj : DbManager.getInstance().getAdressDao().select()) {
            System.out.println(obj.toString());
        }
        DbManager.getInstance().getAdressDao().delete(adress1);

        for (Object obj : DbManager.getInstance().getAdressDao().select()) {
            System.out.println(obj.toString());
        }
    }

    // Test of database function for matiere class
    private static final void matiereTests () throws SQLException {

        DbManager.getInstance().getMatiereDao().drop();
        DbManager.getInstance().getMatiereDao().create();
        Matiere matiere1 = new Matiere("Physique Quantique");
        DbManager.getInstance().getMatiereDao().insert(matiere1);

        Matiere matiere2 = new Matiere("Glandage");
        DbManager.getInstance().getMatiereDao().insert(matiere2);

        for (Object obj : DbManager.getInstance().getMatiereDao().select()) {
            System.out.println(obj.toString());
        }
        DbManager.getInstance().getMatiereDao().delete(matiere1);

        for (Object obj : DbManager.getInstance().getMatiereDao().select()) {
            System.out.println(obj.toString());
        }
    }


    // librairie

//  GlobalLogger.getConsoleLogger().Log("Ma data", Options.WARNING);
//  GlobalLogger.getConsoleLogger().Log("ma deuxième data", Options.ERROR, true);
//
//  ConsoleLogger.LogForce("3eme data", Options.WARNING);
//
//  ConsoleLogger logger = new ConsoleLogger("my application", Options.RELEASE);
//
//  logger.Log("3eme data", Options.WARNING);
}
