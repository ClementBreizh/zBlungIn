package com.apsidepoei.projetpoeitest.restTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
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
import com.apsidepoei.projetpoei.database.repositories.SessionRepository;
import com.apsidepoei.projetpoei.entities.Session;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
/**
*
* @author clemb
* Tests for Session Entity.
*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class SessionRestControllerTest extends BaseRestControllerTest<Session, Integer> {

  @Autowired
  private SessionRepository repository;
  /**
   * Empty Constructor.
   */
  public SessionRestControllerTest() {
    super("/sessions");
  }
  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<Session, Integer> getRepository() {
    return repository;
  }
  /**
   * Parse Json to List for test.
   */
  @Override
  protected List<Session> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Session>>() {
    });
  }
  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(Session item1, Session item2) {
    return item1.getId().equals(item2.getId())
        && item1.getName().equals(item2.getName())
          && item1.getStartDate().equals(item2.getStartDate())
            && item1.getEndDate().equals(item2.getEndDate());
  }
  /**
   * Parse Json to a Object for run test.
   */
  @Override
  protected Session parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Session>() {
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
  protected Session getObjectTest() throws ParseException {
    Faker faker = new Faker();
    String name = "Mickael";
    LocalDate startDate = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate endDate = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    Session item = new Session(name, startDate, endDate);

      return item;


  }
  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(Session item) {
    return item.getId();
  }
  /**
   * Create a string for POST method API.
   */
  @Override
  protected String getObjectToStringToPost() {
    String urlParameters  = "name=Session1&startDate=2018-08-19&endDate=2018-08-19";
    return urlParameters;
  }
  /**
   * Method to compare list.
   */
  @Override
  protected boolean compareToList(List<Session> items, List<Session> dbItems) {
    return false;
  }
  /**
   * Test function via HTTP
   * @throws Exception
   */
  @Test
  public void test() throws Exception {

      // Make object
      Session sess = new Session();
      sess.setName("Clement");
      sess.setStartDate(LocalDate.now());
      sess.setEndDate(LocalDate.now());

      // Transform to JSON
      String objJson = this.objectMapper.writeValueAsString(sess);

      // Prepare Request
      MockHttpServletRequestBuilder request = post(BASE_API + entityPath)
              .contentType("application/json")

              .content(objJson);

      MvcResult result = this.mockMvc.perform(request)
              .andExpect(status().isOk())
              .andReturn();


      System.out.println(result.getResponse().getStatus());
      System.out.println(result.getResponse().getContentAsString());

      // Transform to Object
      Session newSess = this.objectMapper.readValue(result.getResponse().getContentAsString(), Session.class);

      // Tests
      assertNotNull(newSess);
      assertThat("Clement").isEqualTo(newSess.getName());
  }

}


