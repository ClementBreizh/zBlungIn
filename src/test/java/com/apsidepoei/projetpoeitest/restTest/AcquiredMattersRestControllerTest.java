package com.apsidepoei.projetpoeitest.restTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.text.ParseException;
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
import com.apsidepoei.projetpoei.database.repositories.AcquiredMattersRepository;
import com.apsidepoei.projetpoei.entities.AcquiredMatters;
import com.apsidepoei.projetpoei.entities.Candidate;
import com.apsidepoei.projetpoei.entities.Matter;
import com.apsidepoei.projetpoei.entities.Person;
import com.apsidepoei.projetpoeitest.securityservicetest.Securityconf;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author clemb Tests for AcquiredMatters Entity.
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
    return item1.getId().equals(item2.getId()) && item1.getMatter().equals(item2.getMatter())
        && item1.getCandidate().equals(item2.getCandidate());
  }

  /**
   * Parse Json to a Object for run test.
   */
  @Override
  protected AcquiredMatters parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerSubtypes(Person.class);
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
    String urlParameters = "score=12&validationDate=2019/02/24";
    return urlParameters;
  }

  /**
   * Method to compare list.
   */
  @Override
  protected boolean compareToList(List<AcquiredMatters> items, List<AcquiredMatters> dbItems) {
    return false;
  }

  /**
   * Test function via HTTP
   *
   * @throws Exception
   */
  @Test
  public void test() throws Exception {

    // Make objects
    Matter matter = new Matter();
    matter.setName("Diplomatie spaciale");

    Candidate candidate = new Candidate();
    candidate.setFirstname("Jean");
    candidate.setLastname("Dupont");
    candidate.setEmail("amatter@gmail.com");
    candidate.setCellPhone("0987789878");


    AcquiredMatters sess = new AcquiredMatters();
    sess.setMatter(matter);
    sess.setCandidate(candidate);
    ;

    // Transform to JSON
    String objJson = this.objectMapper.writeValueAsString(sess);

    // Prepare Request
    MockHttpServletRequestBuilder request = post(BASE_API + entityPath + "/test").contentType("application/json")

        .content(objJson);

    MvcResult result = this.mockMvc.perform(request).andExpect(status().isOk()).andReturn();

    System.out.println(result.getResponse().getStatus());
    System.out.println(result.getResponse().getContentAsString());

    // Transform to Object
    AcquiredMatters newSess = this.objectMapper.readValue(result.getResponse().getContentAsString(), AcquiredMatters.class);

    // Tests
    assertNotNull(newSess);
    assertThat(sess.getMatter().getName()).isEqualTo(newSess.getMatter().getName());
    assertThat(sess.getCandidate().getFirstname()).isEqualTo(newSess.getCandidate().getFirstname());
  }

}
