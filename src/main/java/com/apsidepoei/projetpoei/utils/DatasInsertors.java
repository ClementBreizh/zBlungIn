package com.apsidepoei.projetpoei.utils;

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
import com.apsidepoei.projetpoei.entities.Matter;
import com.apsidepoei.projetpoei.entities.Person;
import com.apsidepoei.projetpoei.entities.RankingCandidate;
import com.apsidepoei.projetpoei.entities.Session;
import com.apsidepoei.projetpoei.entities.SexCandidate;
import com.apsidepoei.projetpoei.entities.StatusCandidate;
import com.apsidepoei.projetpoei.entities.User;
import com.apsidepoei.projetpoei.services.fixtures.MatterFixtureService;
import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

/**
 * @author vianney
 *
 */
@Slf4j
@Service(value = "baseDatasInsertors")
@Transactional
public class DatasInsertors {

//  @Autowired
//  private EntityManager manager;

  @Autowired
  private MatterFixtureService matterFixtures;

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

  // Lists

  private List<Company> companyList = new ArrayList<>();
  private List<CompanySession> companySessionList = new ArrayList<>();
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
  private List<AcquiredMatters> acquiredMattersList = new ArrayList<>();



  Faker faker = new Faker(Locale.FRENCH);

  Integer nbEntities = 100;

  public DatasInsertors() {
  }

  @PostConstruct
  public void InsertData() {
    log.debug("Inserting fixtures...");
    Faker faker = new Faker(Locale.FRENCH);

    // -----------------------------------Address-----------------------------------
    for (int i = 1; i < this.nbEntities + 1; i++) {
      Address address = new Address(faker.address().streetAddress(), faker.address().zipCode(),
          faker.address().city());
      this.addressRepository.saveAndFlush(address);
    }
    this.addressList.addAll(this.addressRepository.findAll());
    System.out.println("Address ok");

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
    System.out.println("Appointment ok");

    // -----------------------------------Assessment-----------------------------------
//    Assessment assessment1 = new Assessment("Culture générale",
//        faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//    this.assessmentRepository.saveAndFlush(assessment1);
//    Assessment assessment2 = new Assessment("Mathématiques",
//        faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//    this.assessmentRepository.saveAndFlush(assessment2);
//    Assessment assessment3 = new Assessment("Culture informatique",
//        faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//    this.assessmentRepository.saveAndFlush(assessment3);
//    Assessment assessment4 = new Assessment("Logique",
//        faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//    this.assessmentRepository.saveAndFlush(assessment4);
//    this.assessmentList.addAll(this.assessmentRepository.findAll());
//    System.out.println("Assessment ok");

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
    this.candidateList = this.candidateRepository.toto();
    System.out.println("Candidate ok");

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
    System.out.println("Company ok");


    // -----------------------------------Degrees-----------------------------------
    for (int i = 1; i < this.nbEntities + 1; i++) {
      Degree degree = new Degree(faker.book().title(), faker.random().nextInt(0, 5).toString());
      degree.setValidationDate("2014");

      this.degreeRepository.saveAndFlush(degree);
    }
    this.degreeList.addAll(this.degreeRepository.findAll());
    System.out.println("Degrees ok");

    // -----------------------------------Feedback-----------------------------------
    for (int i = 1; i < this.nbEntities + 1; i++) {
      Feedback feedback = new Feedback("CDD", faker.random().nextInt(6, 24), faker.lorem().word(),
          faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
      this.feedbackRepository.saveAndFlush(feedback);
    }
    this.feedbackList.addAll(this.feedbackRepository.findAll());
    System.out.println("Feedback ok");

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
    System.out.println("Matter ok");

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
    System.out.println("Person ok");

    // -----------------------------------Session-----------------------------------

    for (int i = 0; i < this.nbEntities; i++) {
      Session session = new Session(faker.gameOfThrones().house(),
          faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
          faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
      this.sessionRepository.saveAndFlush(session);

    }
    this.sessionList.addAll(this.sessionRepository.findAll());
    System.out.println("Session ok");

    // -----------------------------------User-----------------------------------
//    for (int i = 0; i < nbEntities; i++) {
//      User user = new User(
//          faker.name().username(),
//          faker.internet().password(),
//          faker.name().firstName(),
//          faker.name().lastName(),
//          faker.internet().emailAddress(),
//          faker.phoneNumber().cellPhone().replaceAll(" ", ""));
//      userRepository.saveAndFlush(user);
//    }
    this.userList.addAll(this.userRepository.findAll());
    System.out.println("User ok");

//  -----------------------------------Relations-----------------------------
//  -------------------------------------------------------------------------

    // --------------------------------CompanySession--------------------------------
    for (int i = 1; i < 20 + 1; i++) {
      CompanySession companySession = new CompanySession(
          this.companyRepository.findById(i).get(),
          this.sessionRepository.findById(i).get());
      this.companySessionRepository.saveAndFlush(companySession);
    }
    this.companyList.addAll(this.companyRepository.findAll());
    System.out.println("CompanySession ok");

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

//  -----------------------------Champs supplémentaires------------------------------------
//  --------------------------------------------------------------------------------

    Feedback feedback = this.feedbackList.get(1);
    for (int i = 0; i < this.candidateList.size(); i++) {
      candidate = this.candidateList.get(i);
      candidate.setFeedback(feedback);
      candidate.setHomePhone(faker.phoneNumber().phoneNumber().replaceAll(" ", ""));
      candidate.setCommentary(faker.lorem().sentence());
      candidate.addCompanySession(companySessionRepository.findById(faker.random().nextInt(1, 20)).get());

      this.candidateRepository.saveAndFlush(candidate);
    }


    this.matterFixtures.make();

    System.out.println("DatasInsertors totalement chargé");
  }
}
