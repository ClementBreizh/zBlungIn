package com.apsidepoei.projetpoei.database;

import com.apsidepoei.projetpoei.database.dao.AddressDao;
import com.apsidepoei.projetpoei.database.dao.AppointmentDao;
import com.apsidepoei.projetpoei.database.dao.AssessmentDao;
import com.apsidepoei.projetpoei.database.dao.DegreeDao;
import com.apsidepoei.projetpoei.database.dao.EntrepriseDao;
import com.apsidepoei.projetpoei.database.dao.FeedbackDao;
import com.apsidepoei.projetpoei.database.dao.MatterDao;
import com.apsidepoei.projetpoei.database.dao.SessionDao;
import com.apsidepoei.projetpoei.database.entitiesgenerator.AssessmentGenerator;

public class DbManager {

  private AddressDao addressDao = new AddressDao();
  private AppointmentDao appointmentDao = new AppointmentDao();
  private DegreeDao degreeDao = new DegreeDao();
  private EntrepriseDao entrepriseDao = new EntrepriseDao();
  private FeedbackDao feedbackDao = new FeedbackDao();
  private MatterDao mattersDao = new MatterDao();
  private SessionDao sessionDao = new SessionDao();
  private AssessmentDao assessmentDao = new AssessmentDao();
  private AssessmentGenerator assessmentGenerator = new AssessmentGenerator();

  /** Constructeur privé. */
  private DbManager() {
  }

  /** Instance unique non préinitialisée. */
  private static DbManager INSTANCE = null;

  /** Point d'accès pour l'instance unique du singleton. */
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
   * the adressDao.
   */
  public AddressDao getAddressDao() {
    return addressDao;
  }

  /**
   * the appointmentDao.
   */
  public AppointmentDao getAppointmentDao() {
    return appointmentDao;
  }

  /**
   * the degreeDao.
   */
  public DegreeDao getDegreeDao() {
    return degreeDao;
  }

  /**
   * the entrepriseDao.
   */
  public EntrepriseDao getEntrepriseDao() {
    return entrepriseDao;
  }

  /**
   * the feedbackDao.
   */
  public FeedbackDao getFeedbackDao() {
    return feedbackDao;
  }

  /**
   * the mattersDao.
   */
  public MatterDao getMatterDao() {
    return mattersDao;
  }

  /**
   * the sessionDao.
   */
  public SessionDao getSessionDao() {
    return sessionDao;
  }

  /**
   * the assessmentDao.
   */
  public AssessmentDao getAssessmentDao() {
    return assessmentDao;
  }

  public AssessmentGenerator getAssessmentGenerator() {
    return assessmentGenerator;
  }

}
