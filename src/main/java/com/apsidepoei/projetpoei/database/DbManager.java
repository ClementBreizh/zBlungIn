package com.apsidepoei.projetpoei.database;

import com.apsidepoei.projetpoei.database.dao.AddressDao;
import com.apsidepoei.projetpoei.database.dao.AssessmentDao;
import com.apsidepoei.projetpoei.database.dao.DegreeDao;
import com.apsidepoei.projetpoei.database.dao.EntrepriseDao;
import com.apsidepoei.projetpoei.database.dao.FeedbackDao;
import com.apsidepoei.projetpoei.database.dao.
MattersDao;
import com.apsidepoei.projetpoei.database.dao.SessionDao;

public class DbManager {

    private AddressDao addressDao = new AddressDao();
    private DegreeDao degreeDao = new DegreeDao();
    private EntrepriseDao entrepriseDao = new EntrepriseDao();
    private FeedbackDao feedbackDao = new FeedbackDao();
    private
MattersDao
mattersDao = new
MattersDao();
    private SessionDao sessionDao = new SessionDao();
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
     * @return the
mattersDao
     */
    public
    MattersDao getMattersDao() {
        return
mattersDao;
    }

    /**
     * @return the sessionDao
     */
    public SessionDao getSessionDao() {
        return sessionDao;
    }

    /**
     * @return the assessmentDao
     */
    public AssessmentDao getAssessmentDao() {
        return assessmentDao;
    }
}
