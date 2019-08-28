/**
 *
 */
package com.apsidepoei.projetpoei.utils;

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
import com.apsidepoei.projetpoei.database.repositories.DegreeRepository;
import com.apsidepoei.projetpoei.database.repositories.FeedbackRepository;
import com.apsidepoei.projetpoei.database.repositories.MatterRepository;
import com.apsidepoei.projetpoei.database.repositories.PersonRepository;
import com.apsidepoei.projetpoei.database.repositories.SessionRepository;
import com.apsidepoei.projetpoei.database.repositories.UserRepository;
import com.github.javafaker.Faker;
import com.apsidepoei.projetpoei.entities.Person;
import com.apsidepoei.projetpoei.entities.RankingCandidate;
import com.apsidepoei.projetpoei.entities.User;
import com.apsidepoei.projetpoei.entities.Candidate;



/**
 * @author vianney
 *
 */
@Service(value="baseDatasInsertors")
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








  public DatasInsertors() {
    System.out.println("Lancement de DatasInsertors");
  }

//  @PostConstruct
  public void InsertData() {
    Faker faker = new Faker(Locale.FRENCH);

    Person person = new Person(
        faker.name().firstName(),
        faker.name().lastName(),
        faker.internet().emailAddress(),
        faker.phoneNumber().phoneNumber().intern());
    personRepository.save(person);

    Candidate candidate = new Candidate(
        faker.name().firstName(),
        faker.name().lastName(),
        faker.internet().emailAddress(),
        faker.phoneNumber().phoneNumber().intern());
    candidate.setRanking(RankingCandidate.RANK_2);
    candidateRepository.save(candidate);

    User user = new User(
        faker.name().username(),
        faker.internet().password(),
        faker.name().firstName(),
        faker.name().lastName(),
        faker.internet().emailAddress(),
        faker.phoneNumber().phoneNumber().intern());
    userRepository.save(user);

    System.out.println(candidateRepository.findAll());
    System.out.println(personRepository.findAll());
    System.out.println(userRepository.findAll());

  }
}
