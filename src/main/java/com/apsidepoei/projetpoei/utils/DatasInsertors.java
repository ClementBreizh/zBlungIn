package com.apsidepoei.projetpoei.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsidepoei.projetpoei.database.repositories.AddressRepository;
import com.apsidepoei.projetpoei.database.repositories.AppointmentRepository;
import com.apsidepoei.projetpoei.database.repositories.AssessmentRepository;
import com.apsidepoei.projetpoei.database.repositories.CandidateRepository;
import com.apsidepoei.projetpoei.database.repositories.CompanyCandidatesSessionRepository;
import com.apsidepoei.projetpoei.database.repositories.CompanyRepository;
import com.apsidepoei.projetpoei.database.repositories.CompanyValidatedCandidatesSessionRepository;
import com.apsidepoei.projetpoei.database.repositories.DegreeRepository;
import com.apsidepoei.projetpoei.database.repositories.FeedbackRepository;
import com.apsidepoei.projetpoei.database.repositories.MatterRepository;
import com.apsidepoei.projetpoei.database.repositories.PersonRepository;
import com.apsidepoei.projetpoei.database.repositories.SessionRepository;
import com.apsidepoei.projetpoei.database.repositories.UserRepository;
import com.github.javafaker.Faker;
import com.apsidepoei.projetpoei.entities.Person;
import com.apsidepoei.projetpoei.entities.RankingCandidate;
import com.apsidepoei.projetpoei.entities.RoleUser;
import com.apsidepoei.projetpoei.entities.Session;
import com.apsidepoei.projetpoei.entities.User;
import com.apsidepoei.projetpoei.entities.Address;
import com.apsidepoei.projetpoei.entities.Appointment;
import com.apsidepoei.projetpoei.entities.Assessment;
import com.apsidepoei.projetpoei.entities.Candidate;
import com.apsidepoei.projetpoei.entities.Company;
import com.apsidepoei.projetpoei.entities.CompanyValidatedCandidatesSession;
import com.apsidepoei.projetpoei.entities.Degree;
import com.apsidepoei.projetpoei.entities.Feedback;
import com.apsidepoei.projetpoei.entities.Matter;

/**
 * @author vianney
 *
 */
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
  private CompanyCandidatesSessionRepository validateRepository;

  @Autowired
  private DegreeRepository degreeRepository;

  @Autowired
  private FeedbackRepository feedbackRepository;

  @Autowired
  private MatterRepository matterRepository;

  @Autowired
  private SessionRepository sessionRepository;

  @Autowired
  private CompanyValidatedCandidatesSessionRepository companyValidatedCandidatesSessionRepository;








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

  Integer nbEntities = 10;

  public DatasInsertors() {
    System.out.println("Lancement de DatasInsertors");
  }

//  @PostConstruct
  public void InsertData() {
    Faker faker = new Faker(Locale.FRENCH);

    // Address
    for (int i = 0; i < nbEntities; i++) {
      Address address = new Address(faker.address().streetAddress(), faker.address().zipCode(),
          faker.address().city());
      addressRepository.save(address);
    }
    addressList.addAll(addressRepository.findAll());
    System.out.println("Address ok");


    // Appointment
    for (int i = 0; i < nbEntities; i++) {
      Appointment appointment = new Appointment(
          faker.lorem().sentence(),
          faker.date().birthday(),
          faker.lorem().sentence());
      appointment.setInformations(faker.lorem().sentence());
      appointmentRepository.save(appointment);
    }
    appointmentList.addAll(appointmentRepository.findAll());
    System.out.println("Appointment ok");


    // Assessment
    Assessment assessment1 = new Assessment("Culture générale", faker.date().birthday());
    assessmentRepository.save(assessment1);
    Assessment assessment2 = new Assessment("Mathématiques", faker.date().birthday());
    assessmentRepository.save(assessment2);
    Assessment assessment3 = new Assessment("Culture informatique", faker.date().birthday());
    assessmentRepository.save(assessment3);
    Assessment assessment4 = new Assessment("Logique", faker.date().birthday());
    assessmentRepository.save(assessment4);
    assessmentList.addAll(assessmentRepository.findAll());
    System.out.println("Assessment ok");


    // Candidate
    for (int i = 0; i < nbEntities; i++) {
      Candidate candidate = new Candidate(
          faker.name().firstName(),
          faker.name().lastName(),
          faker.internet().emailAddress(),
          faker.phoneNumber().cellPhone().replaceAll(" ", ""));
      candidate.setRanking(RankingCandidate.RANK_2);
      candidateRepository.save(candidate);
    }
    candidateList.addAll(candidateRepository.findAll());
    System.out.println("Candidate ok");


    // Company
    for (int i = 0; i < nbEntities; i++) {
      Company company = new Company(faker.company().name(), faker.address().city(),
          faker.number().digits(14), faker.number().digits(5));
      companyRepository.save(company);
    }
    companyList.addAll(companyRepository.findAll());
    System.out.println("Company ok");


    // Degrees
    for (int i = 0; i < nbEntities; i++) {
      Degree degree = new Degree(
          faker.book().toString(),
          faker.random().nextInt(0, 5).toString());
      degreeRepository.save(degree);
    }
    degreeList.addAll(degreeRepository.findAll());
    System.out.println("Degrees ok");



    // Feedback
    for (int i = 0; i < nbEntities; i++) {
      Feedback feedback = new Feedback(
          "CDD",
          faker.random().nextInt(6, 24),
          faker.lorem().word());
      feedbackRepository.save(feedback);
    }
    feedbackList.addAll(feedbackRepository.findAll());
    System.out.println("Feedback ok");


    // Matter
    Matter matter1 = new Matter("Angular");
    matterRepository.save(matter1);
    Matter matter2 = new Matter("Java");
    matterRepository.save(matter2);
    Matter matter3 = new Matter("HTML");
    matterRepository.save(matter3);
    Matter matter4 = new Matter("CSS");
    matterRepository.save(matter4);
    Matter matter5 = new Matter("C#");
    matterRepository.save(matter5);
    Matter matter6 = new Matter("C++");
    matterRepository.save(matter6);

    matterList.addAll(matterRepository.findAll());
    System.out.println("Matter ok");



    // Person
    for (int i = 0; i < nbEntities; i++) {
      Integer addressSize = faker.random().nextInt(0, addressList.size());

      Person person = new Person(
          faker.name().firstName(),
          faker.name().lastName(),
          faker.internet().emailAddress(),
          faker.phoneNumber().cellPhone().replaceAll(" ", ""));
      personRepository.save(person);
    }
    personList.addAll(personRepository.findAll());
    System.out.println("Person ok");


    // Session
    for (int i = 0; i < nbEntities; i++) {
      Session session = new Session(faker.gameOfThrones().house(), faker.date().birthday(),
          faker.date().birthday());
      sessionRepository.save(session);
    }
    sessionList.addAll(sessionRepository.findAll());
    System.out.println("Session ok");


    // User
    for (int i = 0; i < nbEntities; i++) {
      User user = new User(
          faker.name().username(),
          faker.internet().password(),
          faker.name().firstName(),
          faker.name().lastName(),
          faker.internet().emailAddress(),
          faker.phoneNumber().cellPhone().replaceAll(" ", ""));
//      user.setRole(RoleUser.ROLE_3);
      userRepository.save(user);
    }
    userList.addAll(userRepository.findAll());
    System.out.println("User ok");




    // Company Validate

//    for (int i = 0; i < nbEntities; i++) {
//      Integer companySize = faker.random().nextInt(0, companyList.size());
//      Integer sessionSize = faker.random().nextInt(0, sessionList.size());
//      Integer candidateSize = faker.random().nextInt(0, candidateList.size());
//
//      CompanyValidatedCandidatesSession relation = new CompanyValidatedCandidatesSession();
//      relation.setCompany(companyRepository.findById(companySize).get());
//      relation.setSession(sessionRepository.findById(sessionSize).get());
//      relation.getValidatedCandidates().add(candidateList.get(candidateSize));
//      companyValidatedCandidatesSessionRepository.save(relation);
//    }











System.out.println("DatasInsertors totalement chargé");
//person.setHomePhone(faker.phoneNumber().cellPhone().replaceAll(" ", ""));
//person.setCommentary(faker.lorem().sentence());
//person.setAddress(addressList.get(addressSize));
//person.setMainContact(true);
//company.setAddress(addressRepository.findById(addressSize).get());
//company.setMainContact(personRepository.findById(personSize).get());
//candidate.setRanking(RankingCandidate.values()[(faker.random().nextInt(0, RankingCandidate.values().length))]);

  }
}
