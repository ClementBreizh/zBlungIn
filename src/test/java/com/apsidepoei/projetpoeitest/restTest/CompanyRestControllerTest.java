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
import com.apsidepoei.projetpoei.database.repositories.CompanyRepository;
import com.apsidepoei.projetpoei.entities.Company;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
*
* @author clemb
* Tests for Company Entity.
*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class CompanyRestControllerTest extends BaseRestControllerTest<Company, Integer> {

  @Autowired
  private CompanyRepository repository;
  /**
   * Empty Constructor.
   */
  public CompanyRestControllerTest() {
    super("/companies");
  }

  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<Company, Integer> getRepository() {
    return repository;
  }
  /**
   * Parse Json to List for test.
   */
  @Override
  protected List<Company> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Company>>() {
    });
  }
  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(Company item1, Company item2) {
    return item1.getId().equals(item2.getId()) && item1.getName().equals(item2.getName())
        && item1.getAntennaName().equals(item2.getAntennaName()) && item1.getSiret().equals(item2.getSiret())
        && item1.getApeCode().equals(item2.getApeCode());
  }
  /**
   * Parse Json to a Object for run test.
   */
  @Override
  protected Company parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Company>() {
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
  protected Company getObjectTest() throws ParseException {
    Company item = new Company();
    return item;
  }
  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(Company item) {
    return item.getId();
  }
  /**
   * Create a string for POST method API.
   */
  @Override
  protected String getObjectToStringToPost() {
    return null;
  }
  /**
   * Method to compare list.
   */
  @Override
  protected boolean compareToList(List<Company> items, List<Company> dbItems) {
    return false;
  }
}
