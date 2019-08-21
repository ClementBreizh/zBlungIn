package com.apsidepoei.projetpoei;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.apsidepoei.projetpoei.database.DbManager;

import com.apsidepoei.projetpoei.database.entitiesgenerator.MatiereGenerator;

import com.apsidepoei.projetpoei.database.entitiesgenerator.DegreeGenerator;

import com.apsidepoei.projetpoei.entities.Address;

import com.apsidepoei.projetpoei.entities.Degree;

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



         matiereTests();
         adressTests();

         degreeTests();
         testGenerate();


//         degreeTests ();
//         DegreeGenerator.getInstance().generateAndInsertDatasDroppingTable(10);
//         DegreeGenerator.getInstance().deleteDatas();


    }


    private static final void adressTests () throws SQLException {

//        DbManager.getInstance().getAdressDao().drop();
        DbManager.getInstance().getAddressDao().create();
        Address adress1 = new Address("51 rue de l'alma", "35000", "rennes");
        DbManager.getInstance().getAddressDao().insert(adress1);

        Address adress2 = new Address("31 rue de la rabine", "35530", "noyal sur vilaine");
        DbManager.getInstance().getAddressDao().insert(adress2);

        for (Object obj : DbManager.getInstance().getAddressDao().select()) {
            System.out.println(obj.toString());
        }
        DbManager.getInstance().getAddressDao().delete(adress1);

        for (Object obj : DbManager.getInstance().getAddressDao().select()) {
            System.out.println(obj.toString());
        }
    }

    // Test of database function for matiere class
    private static final void matiereTests () throws SQLException {

        DbManager.getInstance().getMatiereDao().drop();
        DbManager.getInstance().getMatiereDao().create();
        Matiere matiere1 = new Matiere("Physique Quantique");
        DbManager.getInstance().getMatiereDao().insert(matiere1);

        Matiere matiere2 = new Matiere("Algorythmie");
        DbManager.getInstance().getMatiereDao().insert(matiere2);

        for (Object obj : DbManager.getInstance().getMatiereDao().select()) {
            System.out.println(obj.toString());
        }
        DbManager.getInstance().getMatiereDao().delete(matiere1);

        for (Object obj : DbManager.getInstance().getMatiereDao().select()) {
            System.out.println(obj.toString());
        }
        matiere2.setName("Mathematique");
        DbManager.getInstance().getMatiereDao().update(matiere2);

        for (Object obj : DbManager.getInstance().getMatiereDao().select()) {
            System.out.println(obj.toString());
        }
    }

    private static final void degreeTests () throws SQLException {

      DbManager.getInstance().getDegreeDao().drop();
      DbManager.getInstance().getDegreeDao().create();
      Degree degree1 = new Degree("BTS Informatique", "BAC + 2");
      DbManager.getInstance().getDegreeDao().insert(degree1);

      Degree degree2 = new Degree("BTS Systèmes Numériques", "BAC + 2");
      DbManager.getInstance().getDegreeDao().insert(degree2);

      for (Object obj : DbManager.getInstance().getDegreeDao().select()) {
          System.out.println(obj.toString());
      }

      DbManager.getInstance().getDegreeDao().delete(degree1);

      for (Object obj : DbManager.getInstance().getDegreeDao().select()) {
          System.out.println(obj.toString());
      }

      degree2.setName("BTS Systèmes Numériques Option A");
      DbManager.getInstance().getDegreeDao().update(degree2);

      for (Object obj : DbManager.getInstance().getDegreeDao().select()) {
          System.out.println(obj.toString());
      }
  }



    private static void testGenerate() throws SQLException, ParseException {

        MatiereGenerator.getInstance().generateAndInsertDatasDroppingTable(10);

               for (Matiere matiere : DbManager.getInstance().getMatiereDao().select()) {
            System.out.println(matiere);
        }

               MatiereGenerator.getInstance().deleteDatas();
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
