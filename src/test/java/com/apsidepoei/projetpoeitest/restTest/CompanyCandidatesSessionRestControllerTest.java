package com.apsidepoei.projetpoeitest.restTest;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.apsidepoei.projetpoei.ZbleuginApplication;
import com.apsidepoei.projetpoei.database.repositories.CompanyCandidatesSessionRepository;
import com.apsidepoei.projetpoei.database.repositories.FeedbackRepository;
import com.apsidepoei.projetpoei.entities.CompanyCandidatesSession;
import com.apsidepoei.projetpoei.entities.Feedback;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
*
* @author clemb
* Tests for Feedback Entity.
*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class CompanyCandidatesSessionRestControllerTest {

  @Autowired
  private CompanyCandidatesSessionRepository repository;
  /**
   * Empty Constructor.
   */
  public CompanyCandidatesSessionRestControllerTest() {
    super("/companyCandidatesSessions");
  }
  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<CompanyCandidatesSession, Integer> getRepository() {
    return repository;
  }
  /**
   * Parse Json to List for test.
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
        && item1.getTypeOfContract().equals(item2.getTypeOfContract())
            && item1.getDurationOfContract().equals(item2.getDurationOfContract())
                && item1.getComment().equals(item2.getComment());
  }
  /**
   * Parse Json to a Object for run test.
   */
  @Override
  protected CompanyCandidatesSession parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<CompanyCandidatesSession>() {
    });
  }
  /**
   * Generate a Id for run test.
   */
  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }
  /**
   * Create a object for run test.
   */
  @Override
  protected Feedback getObjectTest() throws ParseException {
    CompanyCandidatesSession item = new CompanyCandidatesSession("CDI", 24, "no comment test");
    return item;
  }
  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(CompanyCandidatesSession item) {
    return item.getId();
  }
  /**
   * Create a string for POST method API.
   */
  @Override
  protected String getObjectToStringToPost() {
    String urlParameters  = "typeOfContract=CDI&durationOfContract=24&comment=nocomment";
    return urlParameters;
  }
  /**
   * Method to compare list.
   */
  @Override
  protected boolean compareToList(List<CompanyCandidatesSession> items, List<CompanyCandidatesSession> dbItems) {
    return false;
  }
}



