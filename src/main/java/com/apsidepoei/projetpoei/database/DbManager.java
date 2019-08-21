package com.apsidepoei.projetpoei.database;

import com.apsidepoei.projetpoei.database.dao.AddressDao;
import com.apsidepoei.projetpoei.database.dao.AssessmentDao;
import com.apsidepoei.projetpoei.database.dao.DegreeDao;
import com.apsidepoei.projetpoei.database.dao.EntrepriseDao;
import com.apsidepoei.projetpoei.database.dao.FeedbackDao;
import com.apsidepoei.projetpoei.database.dao.MatiereDao;

public class DbManager {

    private AddressDao addressDao = new AddressDao();
    private DegreeDao degreeDao = new DegreeDao();
    private EntrepriseDao entrepriseDao = new EntrepriseDao();
    private FeedbackDao feedbackDao = new FeedbackDao();
    private MatiereDao matiereDao = new MatiereDao();
    private AssessmentDao assessmentDao = new AssessmentDao();


    /** Constructeur privé */
    private DbManager() {
    }

    /** Instance unique non préinitialisée */
    private static DbManager INSTANCE = null;

    /** Point d'accès pour l'instance unique du singleton */
    public static DbManager getInstance() {
        if (INSTANCE == null) {
            synchronized (DbManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DbManager();
                }
            }
        }
        return INSTANCE;
    }

    // GETTER/SETTER
    /**
     * @return the adressDao
     */
    public AddressDao getAddressDao() {
        return addressDao;
    }

    /**
     * @return the degreeDao
     */
    public DegreeDao getDegreeDao() {
        return degreeDao;
    }

    /**
     * @return the entrepriseDao
     */
    public EntrepriseDao getEntrepriseDao() {
        return entrepriseDao;
    }

    /**
     * @return the feedbackDao
     */
    public FeedbackDao getFeedbackDao() {
        return feedbackDao;
    }
    /**
     * @return the matiereDao
     */
    public MatiereDao getMatiereDao() {
        return matiereDao;
    }

    /**
     * @return the assessmentDao
     */

    public AssessmentDao getAssessmentDao() {
        return assessmentDao;
    }


}
