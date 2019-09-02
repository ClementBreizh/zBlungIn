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
import com.apsidepoei.projetpoei.database.repositories.UserRepository;
import com.apsidepoei.projetpoei.entities.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
*
* @author clemb
* Tests for User Entity.
*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class UserRestControllerTest extends BaseRestControllerTest <User, Integer> {

  @Autowired
  private UserRepository repository;

  /**
   * Empty Constructor.
   */
  public UserRestControllerTest() {
    super("/users");
  }

  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<User, Integer> getRepository() {
    return repository;
  }

  /**
   * Parse User in Json to List for test.
   */
  @Override
  protected List<User> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<User>>() {
    });
  }

  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(User item1, User item2) {
    return item1.getId().equals(item2.getId())
        && item1.getFirstname().equals(item2.getFirstname())
            && item1.getLastname().equals(item2.getLastname())
                && item1.getEmail().equals(item2.getEmail())
                  && item1.getCellPhone().equals(item2.getCellPhone())
                    && item1.getHomePhone().equals(item2.getHomePhone());
  }

  /**
   * Generate a Id for run test.
   */
  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  /**
   * Create a User object for run test.
   */
  @Override
  protected User getObjectTest() {
    User item = new User("logadmin", "PassAdmin", "PrenomAdmin", "NomAdmin" ,"josephine@gmail.com", "0712233443");
    return item;
  }

  /**
   * Create a string for POST method API.
   */
  @Override
  protected String getObjectToStringToPost() {
    String urlParameters  = "login=logadmin&password=PassAdmin&firstname=José&lastname=Phine&email=josephine@gmail.com&cellPhone=0712233443&homePhone=0213234323";
    return urlParameters;
  }

  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(User item) {
    return item.getId();
  }

  /**
   * Parse Json to a Object User for run test.
   */
  @Override
  protected User parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<User>() {
    });
  }

  /**
   * Method to compare list of Person.
   */
  @Override
  protected boolean compareToList(List<User> items, List<User> dbItems) {
    return false;
  }
}
