package com.apsidepoei.projetpoeitest.restTest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.apsidepoei.projetpoei.ZbleuginApplication;
import com.apsidepoei.projetpoei.database.repositories.CompanyCandidatesSessionRepository;
import com.apsidepoei.projetpoei.entities.Company;
import com.apsidepoei.projetpoei.entities.CompanyCandidatesSession;
import com.apsidepoei.projetpoei.entities.Session;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.result.LocalDateValueFactory;

/**
 *
 * @author clemb
 * Tests for CompanyCandidatesSession Entity.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class CompanyCandidatesSessionRestControllerTest extends BaseRestControllerTest<CompanyCandidatesSession, Integer> {

  @Autowired
  private CompanyCandidatesSessionRepository repository;

  /**
   * Empty Constructor.
   */
  public CompanyCandidatesSessionRestControllerTest() {
    super("/candidBySessionAndCompany");
  }

  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<CompanyCandidatesSession, Integer> getRepository() {
    return repository;
  }

  /**
   * Parse CompanyCandidatesSession in Json to List for test.
   */
  @Override
  protected List<CompanyCandidatesSession> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<CompanyCandidatesSession>>() {
    });
  }

  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(CompanyCandidatesSession item1, CompanyCandidatesSession item2) {
    return item1.getId().equals(item2.getId())
        && item1.getCompany().equals(item2.getCompany())
            && item1.getCandidates().equals(item2.getCandidates())
                && item1.getSession().equals(item2.getSession())
                ;
  }

  /**
   * Generate a Id for run test.
   */
  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  /**
   * Create a CompanyCandidatesSession object for run test.
   */
  @Override
  protected CompanyCandidatesSession getObjectTest() {
    Company comp1 = new Company("MaSuperCompany");
    LocalDate dateTest = LocalDate.of(2016, 8, 19);
    Session session1 = new Session("maSuperComp", dateTest, dateTest);
    CompanyCandidatesSession item = new CompanyCandidatesSession(comp1, session1);
    return item;
  }

  /**
   * Create a string for POST method API.
   */
  @Override
  protected String getObjectToStringToPost() {
    String urlParameters  = "";
    return urlParameters;
  }

  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(CompanyCandidatesSession item) {
    return item.getId();
  }

  /**
   * Parse Json to a Object CompanyCandidatesSession for run test.
   */
  @Override
  protected CompanyCandidatesSession parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<CompanyCandidatesSession>() {
    });
  }

  /**
   * Method to compare list of CompanyValidateCandidatesSession.
   */
  @Override
  protected boolean compareToList(List<CompanyCandidatesSession> items, List<CompanyCandidatesSession> dbItems) {
    return false;
  }
}





