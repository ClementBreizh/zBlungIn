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
import com.apsidepoei.projetpoei.database.repositories.AcquiredMattersRepository;
import com.apsidepoei.projetpoei.entities.AcquiredMatters;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
*
* @author clemb
* Tests for AcquiredMatters Entity.
*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class AcquiredMattersRestControllerTest extends BaseRestControllerTest<AcquiredMatters, Integer> {

  @Autowired
  private AcquiredMattersRepository repository;
  /**
   * Empty Constructor.
   */
  public AcquiredMattersRestControllerTest() {
    super("/acquiredmatters");
  }
  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<AcquiredMatters, Integer> getRepository() {
    return repository;
  }
  /**
   * Parse Json to List for test.
   */
  @Override
  protected List<AcquiredMatters> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<AcquiredMatters>>() {
    });
  }
  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(AcquiredMatters item1, AcquiredMatters item2) {
    return item1.getId().equals(item2.getId())
        && item1.getScore().equals(item2.getScore())
            && item1.getValidationDate().equals(item2.getValidationDate());
  }

  /**
   * Parse Json to a Object for run test.
   */
  @Override
  protected AcquiredMatters parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<AcquiredMatters>() {
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
  protected AcquiredMatters getObjectTest() throws ParseException {
    AcquiredMatters item = new AcquiredMatters();
    return item;
  }
  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(AcquiredMatters item) {
    return item.getId();
  }
  /**
   * Create a string for POST method API.
   */
  @Override
  protected String getObjectToStringToPost() {
    String urlParameters  = "score=12&validationDate=2019/02/24";
    return urlParameters;
  }
  /**
   * Method to compare list.
   */
  @Override
  protected boolean compareToList(List<AcquiredMatters> items, List<AcquiredMatters> dbItems) {
    return false;
  }
}


