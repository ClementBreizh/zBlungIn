package com.apsidepoei.projetpoeitest.restTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.tomcat.jni.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.apsidepoei.projetpoei.ZbleuginApplication;
import com.apsidepoei.projetpoei.database.repositories.PersonRepository;
import com.apsidepoei.projetpoei.entities.Person;
import com.apsidepoei.projetpoei.entities.Session;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author clemb
 * Tests for Person Entity.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class PersonRestControllerTest extends BaseRestControllerTest<Person, Integer> {

  @Autowired
  private PersonRepository repository;

  /**
   * Empty Constructor.
   */
  public PersonRestControllerTest() {
    super("/persons");
  }

  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<Person, Integer> getRepository() {
    return repository;
  }

  /**
   * Parse Person in Json to List for test.
   */
  @Override
  protected List<Person> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Person>>() {
    });
  }

  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(Person item1, Person item2) {
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
   * Create a Person object for run test.
   */
  @Override
  protected Person getObjectTest() {
    Person item = new Person("José", "Phine", "josephine@gmail.com", "0712233443", "0212233443", "this is a comment", false);
    return item;
  }

  /**
   * Create a string for POST method API.
   */
  @Override
  protected String getObjectToStringToPost() {
    String urlParameters  = "firstname=José&lastname=Phine&email=josephine@gmail.com"
        + "&cellPhone=0712233443&homePhone=0213234323&commentary=thsiisacomment"
        + "&mainContact=false";
    return urlParameters;
  }

  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(Person item) {
    return item.getId();
  }

  /**
   * Parse Json to a Object Person for run test.
   */
  @Override
  protected Person parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Person>() {
    });
  }

  /**
   * Method to compare list of Person.
   */
  @Override
  protected boolean compareToList(List<Person> items, List<Person> dbItems) {
    return false;
  }

  /**
   * Test function via HTTP
   * @throws Exception
   */
  @Test
  public void test() throws Exception {

      // Make object
    Person sess = new Person();
      sess.setFirstname("Clement");
      sess.setLastname("BOUCHEREAU");
      sess.setEmail("moemain@gmail.com");
      sess.setCellPhone("9809877786");

      // Transform to JSON
      String objJson = this.objectMapper.writeValueAsString(sess);

      // Prepare Request
      MockHttpServletRequestBuilder request = post(BASE_API + entityPath + "/test")
              .contentType("application/json")

              .content(objJson);

      MvcResult result = this.mockMvc.perform(request)
              .andExpect(status().isOk())
              .andReturn();


      System.out.println(result.getResponse().getStatus());
      System.out.println(result.getResponse().getContentAsString());

      // Transform to Object
      Person newSess = this.objectMapper.readValue(result.getResponse().getContentAsString(), Person.class);

      // Tests
      assertNotNull(newSess);
      assertThat("Clement").isEqualTo(newSess.getFirstname());
  }
}





