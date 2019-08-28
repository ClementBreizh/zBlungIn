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
import com.apsidepoei.projetpoei.entities.Address;
import com.apsidepoei.projetpoei.entities.Candidate;
import com.apsidepoei.projetpoei.entities.Degree;
import com.apsidepoei.projetpoei.entities.Matter;



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



  Faker faker = new Faker(Locale.FRENCH);

  Integer nbEntities = 10;
  public DatasInsertors() {
    System.out.println("Lancement de DatasInsertors");
  }


  @PostConstruct
  public void InsertData() {
    Faker faker = new Faker(Locale.FRENCH);

    for (int i = 0; i < nbEntities; i++) {
      Address address = new Address(
          faker.address().streetAddress(),
          faker.address().zipCode(),
          faker.address().city()
          );
      addressRepository.save(address);
    }

    for (int i = 0; i < nbEntities; i++) {
      Degree degree = new Degree(
          faker.book().toString(),
          faker.random().nextInt(0, 5).toString()
          );
      degreeRepository.save(degree);
    }

    for (int i = 0; i < nbEntities; i++) {
      Matter matter = new Matter(
          faker.hacker().verb()
          );
      matterRepository.save(matter);
    }

    for (int i = 0; i < nbEntities; i++) {
      Person person = new Person(
          faker.name().firstName(),
          faker.name().lastName(),
          faker.internet().emailAddress(),
          faker.phoneNumber().cellPhone().replaceAll(" ", ""));
      personRepository.save(person);
    }

    for (int i = 0; i < nbEntities; i++) {
      Candidate candidate = new Candidate(
          faker.name().firstName(),
          faker.name().lastName(),
          faker.internet().emailAddress(),
          faker.phoneNumber().cellPhone().replaceAll(" ", ""));

//      candidate.setRanking(RankingCandidate.values()[(faker.random().nextInt(0, RankingCandidate.values().length))]);
      candidate.setRanking(RankingCandidate.RANK_2);

      candidate.getDegrees().add(degreeRepository.findById(1).get());
      candidateRepository.save(candidate);
      System.out.println(candidate);
    }

    for (int i = 0; i < nbEntities; i++) {
      User user = new User(
          faker.name().username(),
          faker.internet().password(),
          faker.name().firstName(),
          faker.name().lastName(),
          faker.internet().emailAddress(),
          faker.phoneNumber().cellPhone().replaceAll(" ", ""));
      userRepository.save(user);
    }

    for (int i = 0; i < nbEntities; i++) {

    }

    for (int i = 0; i < nbEntities; i++) {

    }

    for (int i = 0; i < nbEntities; i++) {

    }

    System.out.println(candidateRepository.findAll());
    System.out.println(personRepository.findAll());
    System.out.println(userRepository.findAll());
  }
}
