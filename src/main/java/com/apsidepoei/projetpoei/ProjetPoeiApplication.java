package com.apsidepoei.projetpoei;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.apsidepoei.projetpoei.database.DbManager;

import com.apsidepoei.projetpoei.database.entitiesgenerator.MatiereGenerator;
import com.apsidepoei.projetpoei.database.entitiesgenerator.AddressGenerator;
import com.apsidepoei.projetpoei.database.entitiesgenerator.DegreeGenerator;
import com.apsidepoei.projetpoei.database.entitiesgenerator.EntrepriseGenerator;
import com.apsidepoei.projetpoei.database.entitiesgenerator.FeedbackGenerator;
import com.apsidepoei.projetpoei.entities.Address;
import com.apsidepoei.projetpoei.entities.Degree;
import com.apsidepoei.projetpoei.entities.Entreprise;
import com.apsidepoei.projetpoei.entities.Feedback;
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

        // Génération de données
//        testGenerate();

        // Tests entité Adress
//        addressTests();
//        AddressGenerator.getInstance().generateAndInsertDatasDroppingTable(10);
//        AddressGenerator.getInstance().deleteDatas();

        // Tests entité Feedback
//      feedbackTests();
      FeedbackGenerator.getInstance().generateAndInsertDatasDroppingTable(9);
      FeedbackGenerator.getInstance().deleteDatas();

         // Test entité Entreprise
//    		entrepriseTests();
//			EntrepriseGenerator.getInstance().generateDatas(10);

         // Tests entité Matiere
//         matiereTests();


          // Tests entité Degree
//        degreeTests();
//        DegreeGenerator.getInstance().generateAndInsertDatasDroppingTable(10);
//        DegreeGenerator.getInstance().deleteDatas();

    }



    private static final void addressTests () throws SQLException {

        DbManager.getInstance().getAddressDao().drop();
        DbManager.getInstance().getAddressDao().create();
        Address address1 = new Address("51 rue de l'alma", "35000", "rennes");
        DbManager.getInstance().getAddressDao().insert(address1);

        Address address2 = new Address("87 rue nationale", "35130", "chartres");
        DbManager.getInstance().getAddressDao().insert(address2);

        Address address3 = new Address("ZI des basses forges", "35530", "noyal sur vilaine");
        DbManager.getInstance().getAddressDao().insert(address3);

        for (Object obj : DbManager.getInstance().getAddressDao().select()) {
            System.out.println(obj.toString());
        }
        DbManager.getInstance().getAddressDao().delete(address1);
        address2.setPostalCode("35531");
        DbManager.getInstance().getAddressDao().update(address2);


        for (Object obj : DbManager.getInstance().getAddressDao().select()) {
            System.out.println(obj.toString());
        }
    }

    private static final void feedbackTests () throws SQLException {

        DbManager.getInstance().getFeedbackDao().drop();
        DbManager.getInstance().getFeedbackDao().create();
        Feedback feedback1 = new Feedback("CDI", 0, "en contrat depuis sa fin de formation");
        DbManager.getInstance().getFeedbackDao().insert(feedback1);

        Feedback feedback2 = new Feedback("CDD", 12, "en contrat");
        DbManager.getInstance().getFeedbackDao().insert(feedback2);

        Feedback feedback3 = new Feedback("CDD", 18, "en contrat depuis 3 mois");
        DbManager.getInstance().getFeedbackDao().insert(feedback3);

        for (Object obj : DbManager.getInstance().getFeedbackDao().select()) {
            System.out.println(obj.toString());
        }
        DbManager.getInstance().getFeedbackDao().delete(feedback1);
        feedback2.setDurationOfContract(24);
        DbManager.getInstance().getFeedbackDao().update(feedback2);


        for (Object obj : DbManager.getInstance().getFeedbackDao().select()) {
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

    /**
     *
     * @throws SQLException
     * Functions tests for degree
     */
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

    private static final void entrepriseTests () throws SQLException {

        DbManager.getInstance().getEntrepriseDao().drop();
        DbManager.getInstance().getEntrepriseDao().create();
        Entreprise entreprise1 = new Entreprise("Apside", "Apside Rennes", "30906508400068", "0000A");
        DbManager.getInstance().getEntrepriseDao().insert(entreprise1);

        Entreprise entreprise2 = new Entreprise("Capgemini", "Capgemini Nantes", "33070384400036", "0000A");
        DbManager.getInstance().getEntrepriseDao().insert(entreprise2);

        for (Object obj : DbManager.getInstance().getEntrepriseDao().select()) {
            System.out.println(obj.toString());
        }

        DbManager.getInstance().getEntrepriseDao().delete(entreprise1);

        for (Object obj : DbManager.getInstance().getEntrepriseDao().select()) {
            System.out.println(obj.toString());
        }

        entreprise2.setNom("Capgemini France");
        DbManager.getInstance().getEntrepriseDao().update(entreprise2);


        for (Object obj : DbManager.getInstance().getEntrepriseDao().select()) {
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
