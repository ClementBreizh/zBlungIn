package com.apsidepoei.projetpoeitest.restTest;

import java.io.IOException;
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
import com.apsidepoei.projetpoei.database.repositories.CompanyValidatedCandidatesSessionRepository;
import com.apsidepoei.projetpoei.entities.CompanyValidatedCandidatesSession;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author clemb
 * Tests for CompanyValidateCandidatesSession Entity.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class CompanyValidatedCandidatesSessionRestControllerTest extends BaseRestControllerTest<CompanyValidatedCandidatesSession, Integer> {

  @Autowired
  private CompanyValidatedCandidatesSessionRepository repository;

  /**
   * Empty Constructor.
   */
  public CompanyValidatedCandidatesSessionRestControllerTest() {
    super("/valCandidBySessionAndCompany");
  }

  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<CompanyValidatedCandidatesSession, Integer> getRepository() {
    return repository;
  }

  /**
   * Parse CompanyValidateCandidatesSession in Json to List for test.
   */
  @Override
  protected List<CompanyValidatedCandidatesSession> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<CompanyValidatedCandidatesSession>>() {
    });
  }

  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(CompanyValidatedCandidatesSession item1, CompanyValidatedCandidatesSession item2) {
    return item1.getId().equals(item2.getId())
        && item1.getCompany().equals(item2.getCompany())
            && item1.getValidatedCandidates().equals(item2.getValidatedCandidates())
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
   * Create a CompanyValidateCandidatesSession object for run test.
   */
  @Override
  protected CompanyValidatedCandidatesSession getObjectTest() {
    CompanyValidatedCandidatesSession item = new CompanyValidatedCandidatesSession();
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
  protected Integer getItemIdTest(CompanyValidatedCandidatesSession item) {
    return item.getId();
  }

  /**
   * Parse Json to a Object CompanyValidateCandidatesSession for run test.
   */
  @Override
  protected CompanyValidatedCandidatesSession parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<CompanyValidatedCandidatesSession>() {
    });
  }

  /**
   * Method to compare list of CompanyValidateCandidatesSession.
   */
  @Override
  protected boolean compareToList(List<CompanyValidatedCandidatesSession> items, List<CompanyValidatedCandidatesSession> dbItems) {
    return false;
  }
}





