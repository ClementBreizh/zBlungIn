package com.apsidepoei.projetpoei.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsidepoei.projetpoei.database.repositories.AcquiredMattersRepository;
import com.apsidepoei.projetpoei.database.repositories.AddressRepository;
import com.apsidepoei.projetpoei.database.repositories.AppointmentRepository;
import com.apsidepoei.projetpoei.database.repositories.AssessmentRepository;
import com.apsidepoei.projetpoei.database.repositories.CandidateManualRepository;
import com.apsidepoei.projetpoei.database.repositories.CandidateRepository;
import com.apsidepoei.projetpoei.database.repositories.CompanyRepository;
import com.apsidepoei.projetpoei.database.repositories.CompanySessionRepository;
import com.apsidepoei.projetpoei.database.repositories.DegreeRepository;
import com.apsidepoei.projetpoei.database.repositories.FeedbackRepository;
import com.apsidepoei.projetpoei.database.repositories.MatterRepository;
import com.apsidepoei.projetpoei.database.repositories.PersonRepository;
import com.apsidepoei.projetpoei.database.repositories.SessionRepository;
import com.apsidepoei.projetpoei.database.repositories.UserRepository;
import com.apsidepoei.projetpoei.entities.AcquiredMatters;
import com.apsidepoei.projetpoei.entities.Address;
import com.apsidepoei.projetpoei.entities.Appointment;
import com.apsidepoei.projetpoei.entities.AppointmentType;
import com.apsidepoei.projetpoei.entities.Assessment;
import com.apsidepoei.projetpoei.entities.Candidate;
import com.apsidepoei.projetpoei.entities.Company;
import com.apsidepoei.projetpoei.entities.CompanySession;
import com.apsidepoei.projetpoei.entities.Degree;
import com.apsidepoei.projetpoei.entities.Feedback;
import com.apsidepoei.projetpoei.entities.LevelDegree;
import com.apsidepoei.projetpoei.entities.Matter;
import com.apsidepoei.projetpoei.entities.Person;
import com.apsidepoei.projetpoei.entities.RankingCandidate;
import com.apsidepoei.projetpoei.entities.Session;
import com.apsidepoei.projetpoei.entities.SexCandidate;
import com.apsidepoei.projetpoei.entities.StatusCandidate;
import com.apsidepoei.projetpoei.entities.User;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

/**
 * @author vianney
 *
 */
@Slf4j
@Service(value = "baseDatasInsertors")
public class DatasInsertors {

  // Repositories

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CandidateRepository candidateRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private AppointmentRepository appointmentRepository;

  @Autowired
  private AssessmentRepository assessmentRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private DegreeRepository degreeRepository;

  @Autowired
  private FeedbackRepository feedbackRepository;

  @Autowired
  private MatterRepository matterRepository;

  @Autowired
  private SessionRepository sessionRepository;

  @Autowired
  private CompanySessionRepository companySessionRepository;

  @Autowired
  private AcquiredMattersRepository acquiredMattersRepository;

  @Autowired
  private CandidateManualRepository candidateManualRepository;

  // Lists

  private List<Company> companyList = new ArrayList<>();
  private List<Address> addressList = new ArrayList<>();
  private List<Degree> degreeList = new ArrayList<>();
  private List<Feedback> feedbackList = new ArrayList<>();
  private List<Assessment> assessmentList = new ArrayList<>();
  private List<Person> personList = new ArrayList<>();
  private List<Matter> matterList = new ArrayList<>();
  private List<Appointment> appointmentList = new ArrayList<>();
  private List<Session> sessionList = new ArrayList<>();
  private List<User> userList = new ArrayList<>();
  private List<Candidate> candidateList = new ArrayList<>();

  Faker faker = new Faker(Locale.FRENCH);

  Integer nbEntities = 100;

  public DatasInsertors() {
  }

  @Transactional
  @PostConstruct
  public void InsertData() {
    Faker faker = new Faker(Locale.FRENCH);
    log.info("Création des fixtures");
    log.info("Si fail, relancer, erreur dûe aux id uniques");


    // -----------------------------------Address-----------------------------------
    for (int i = 1; i < this.nbEntities + 1; i++) {
      Address address = new Address(faker.address().streetAddress(), faker.address().zipCode(),
          faker.address().city());
      this.addressRepository.saveAndFlush(address);
    }
    this.addressList.addAll(this.addressRepository.findAll());
    log.debug("Address ok");


    // -----------------------------------Appointment-----------------------------------
      Person person = new Person("prénom", "nom", "email", "0600000000");
      personRepository.saveAndFlush(person);

    for (int i = 0; i < this.nbEntities; i++) {
      Appointment appointment = new Appointment(
                LocalDateTime.now(),
                personRepository.findById(1).get(),
                AppointmentType.TYPE_1);
      appointment.setInformations(faker.lorem().sentence());
      this.appointmentRepository.saveAndFlush(appointment);
      }

    this.appointmentList.addAll(this.appointmentRepository.findAll());
    log.debug("Appointment ok");



    // -----------------------------------Candidate-----------------------------------
    for (int i = 0; i < this.nbEntities; i++) {
      Candidate candidate = new Candidate(faker.name().firstName(), faker.name().lastName(),
          faker.internet().emailAddress(), faker.phoneNumber().cellPhone().replaceAll(" ", ""));
      candidate.setRanking(RankingCandidate.RANK_2);
      candidate.setSex(SexCandidate.SEX_1);
      candidate.setStatus(StatusCandidate.STATUS_3);
      candidate.setAddress(
          this.addressRepository.findById(faker.random().nextInt(1, this.nbEntities)).get());
      this.candidateRepository.saveAndFlush(candidate);

    }
    this.candidateList.addAll(this.candidateRepository.findAll());
    log.debug("Candidate ok");

    // -----------------------------------Assessment-----------------------------------
    Assessment assessment1 = new Assessment(
        "Culture générale",
        faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
        candidateRepository.findById(faker.random().nextInt(1, nbEntities)).get());
    this.assessmentRepository.saveAndFlush(assessment1);
    Assessment assessment2 = new Assessment("Mathématiques",
        faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
        candidateRepository.findById(faker.random().nextInt(1, nbEntities)).get());
    this.assessmentRepository.saveAndFlush(assessment2);
    Assessment assessment3 = new Assessment("Culture informatique",
        faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
        candidateRepository.findById(faker.random().nextInt(1, nbEntities)).get());
    this.assessmentRepository.saveAndFlush(assessment3);
    Assessment assessment4 = new Assessment("Logique",
        faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
        candidateRepository.findById(faker.random().nextInt(1, nbEntities)).get());
    this.assessmentRepository.saveAndFlush(assessment4);
    log.debug("Assessment ok");

    // -----------------------------------Company-----------------------------------
    for (int i = 1; i < this.nbEntities + 1; i++) {
      Company company = new Company(faker.company().name());
      company.setSiret(faker.number().digits(14));
      company.setApeCode(faker.number().digits(5));
      company.setAddress(
          this.addressRepository.findById(faker.random().nextInt(1, this.nbEntities)).get());

      this.companyRepository.saveAndFlush(company);
    }
    this.companyList.addAll(this.companyRepository.findAll());
    log.debug("Company ok");

    // -----------------------------------Degrees-----------------------------------
    for (int i = 1; i < this.nbEntities + 1; i++) {
      Degree degree = new Degree(
          faker.book().title(),
          LevelDegree.LEVEL_0);
      degree.setValidationDate("2014");

      this.degreeRepository.saveAndFlush(degree);
    }
    this.degreeList.addAll(this.degreeRepository.findAll());
    log.debug("Degree ok");

    // -----------------------------------Feedback-----------------------------------
    for (int i = 1; i < this.nbEntities + 1; i++) {
      Feedback feedback = new Feedback("CDD", faker.random().nextInt(6, 24), faker.lorem().word(),
          faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
      this.feedbackRepository.saveAndFlush(feedback);

    }
    this.feedbackList.addAll(this.feedbackRepository.findAll());
    log.debug("Feedback ok");

    // -----------------------------------Matter-----------------------------------
    Matter matter1 = new Matter("Angular");
    this.matterRepository.saveAndFlush(matter1);
    Matter matter2 = new Matter("Java");
    this.matterRepository.saveAndFlush(matter2);
    Matter matter3 = new Matter("HTML");
    this.matterRepository.saveAndFlush(matter3);
    Matter matter4 = new Matter("CSS");
    this.matterRepository.saveAndFlush(matter4);
    Matter matter5 = new Matter("C#");
    this.matterRepository.saveAndFlush(matter5);
    Matter matter6 = new Matter("C++");
    this.matterRepository.saveAndFlush(matter6);

    this.matterList.addAll(this.matterRepository.findAll());
    log.debug("Matter ok");

    // -----------------------------------Person-----------------------------------
//    for (int i = 0; i < nbEntities; i++) {
//      Person person = new Person(
//          faker.name().firstName(),
//          faker.name().lastName(),
//          faker.internet().emailAddress(),
//          faker.phoneNumber().cellPhone().replaceAll(" ", ""));
//      person.setEmail(faker.internet().emailAddress());
//      person.setCellPhone(faker.phoneNumber().cellPhone().replaceAll(" ", ""));
//      personRepository.saveAndFlush(person);
//    }
//    this.personList.addAll(this.personRepository.findAll());
//    log.debug("Person ok");

    // -----------------------------------Session-----------------------------------

    for (int i = 0; i < this.nbEntities; i++) {
      Session session = new Session(faker.gameOfThrones().house(),
          faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
          faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
      this.sessionRepository.saveAndFlush(session);

    }
    this.sessionList.addAll(this.sessionRepository.findAll());
    log.debug("Session ok");

    // -----------------------------------User-----------------------------------
    for (int i = 0; i < nbEntities; i++) {
      User user = new User(
          faker.name().firstName(),
          faker.name().lastName(),
          faker.internet().emailAddress(),
          faker.phoneNumber().cellPhone().replaceAll(" ", ""),
          faker.name().fullName(),
          faker.internet().password()
          );
      userRepository.saveAndFlush(user);
    }
    this.userList.addAll(this.userRepository.findAll());
    log.debug("User ok");

//  -----------------------------------Relations-----------------------------
//  -------------------------------------------------------------------------

    Degree degree = null;
    Candidate candidate = null;

    for (int i = 0; i < this.nbEntities; i++) {
      degree = this.degreeList.get(i);
      candidate = this.candidateList.get(i);
      candidate.getDegrees().add(degree);
      this.candidateRepository.saveAndFlush(candidate);

    }


    candidateRepository.findById(2).get().addDegree(degreeRepository.findById(1).get());
    candidateRepository.findAll().get(0);



//  -----------------------------Candidate Matters------------------------------------
//  --------------------------------------------------------------------------------

    this.acquiredMattersRepository.save(new AcquiredMatters(10.0f,LocalDate.now(),this.matterRepository.findById(1).get(), this.candidateRepository.findById(2).get()));
    this.acquiredMattersRepository.save(new AcquiredMatters(15.0f,LocalDate.now(),this.matterRepository.findById(2).get(), this.candidateRepository.findById(2).get()));
    this.acquiredMattersRepository.save(new AcquiredMatters(12.0f,LocalDate.now(),this.matterRepository.findById(3).get(), this.candidateRepository.findById(2).get()));

    CompanySession cs1 = new CompanySession(this.companyRepository.findById(1).get(), this.sessionRepository.findById(1).get(), false);
    CompanySession cs2 = new CompanySession(this.companyRepository.findById(1).get(), this.sessionRepository.findById(1).get(), false);
    CompanySession cs3 = new CompanySession(this.companyRepository.findById(1).get(), this.sessionRepository.findById(1).get(), false);
    companySessionRepository.saveAndFlush(cs1);
    companySessionRepository.saveAndFlush(cs2);
    companySessionRepository.saveAndFlush(cs3);

//    this.companySessionRepository.save(new CompanySession(this.companyRepository.findById(1).get(), this.sessionRepository.findById(1).get(), false));
//    this.companySessionRepository.save(new CompanySession(this.companyRepository.findById(1).get(), this.sessionRepository.findById(2).get(), true));
//    this.companySessionRepository.save(new CompanySession(this.companyRepository.findById(2).get(), this.sessionRepository.findById(1).get(), false));

    Candidate c1 = this.candidateRepository.findById(2).get();
    c1.setCompanySession(this.companySessionRepository.findAll());
    this.candidateRepository.save(c1);


    Candidate getCandidate = this.candidateManualRepository.loadWithChildrens(2);

    // Eagered mod
    getCandidate.addDegree(new Degree("testDeg", LevelDegree.LEVEL_0, "1990"));
    getCandidate.getDegrees().remove(0);

    getCandidate.addCompanySession(new CompanySession(this.companyRepository.findById(3).get(), this.sessionRepository.findById(3).get(), false));
    getCandidate.getCompanySession().remove(0);

    // Lazy mod
    getCandidate.getMatters().remove(0);
    AcquiredMatters m1 = this.acquiredMattersRepository.save(new AcquiredMatters(10f, LocalDate.now(), this.matterRepository.findById(4).get(), getCandidate));
    getCandidate.addMatter(m1);

    this.candidateRepository.save(getCandidate);

//  -----------------------------Champs supplémentaires------------------------------------
//  --------------------------------------------------------------------------------

    Feedback feedback = this.feedbackList.get(1);

    for (int i = 0; i < this.candidateList.size(); i++) {
      candidate = this.candidateList.get(i);
      candidate.setFeedback(feedback);
      candidate.setHomePhone(faker.phoneNumber().phoneNumber().replaceAll(" ", ""));
      candidate.setCommentary(faker.lorem().sentence());
      candidate.addCompanySession(companySessionRepository.findById(faker.random().nextInt(1, 3)).get());
      this.candidateRepository.saveAndFlush(candidate);
    }

//  -----------------------------------Tests-----------------------------------------------
//  ---------------------------------------------------------------------------------------


    log.debug("Fixtures totalement chargées");

  }
}
