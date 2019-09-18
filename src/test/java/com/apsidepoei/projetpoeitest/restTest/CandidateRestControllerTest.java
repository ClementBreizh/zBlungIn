package com.apsidepoei.projetpoeitest.restTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.apsidepoei.projetpoei.ZbleuginApplication;
import com.apsidepoei.projetpoei.database.repositories.CandidateRepository;
import com.apsidepoei.projetpoei.entities.Candidate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author clemb Tests for CandidateRestControllerTest Entity.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class CandidateRestControllerTest extends BaseRestControllerTest<Candidate, Integer> {

  @Autowired
  private CandidateRepository repository;

  /**
   * Empty Constructor.
   */
  public CandidateRestControllerTest() {
    super("/candidates");
  }

  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<Candidate, Integer> getRepository() {
    return repository;
  }

  /**
   * Parse Json to List for test.
   */
  @Override
  protected List<Candidate> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Candidate>>() {
    });
  }

  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(Candidate item1, Candidate item2) {
    return item1.getId().equals(item2.getId()) && item1.getRanking().equals(item2.getRanking())
        && item1.getFeedback().equals(item2.getFeedback()) && item1.getDegrees().equals(item2.getDegrees())
        && item1.getMatters().equals(item2.getMatters()) && item1.getSessions().equals(item2.getSessions());
  }

  /**
   * Parse Json to a Object for run test.
   */
  @Override
  protected Candidate parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Candidate>() {
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
  protected Candidate getObjectTest() throws ParseException {
    Candidate item = new Candidate("Toto", "Achille", "toto.achille@gmail.com", "8765678765");
    return item;
  }

  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(Candidate item) {
    return item.getId();
  }

  /**
   * Create a string for POST method API.
   */
  @Override
  protected String getObjectToStringToPost() {
    String urlParameters = "firstname=Toto&lastname=Achille&email=toto.achille@gmail.com&cellPhone=8765678765";
    return urlParameters;
  }

  /**
   * Method to compare list.
   */
  @Override
  protected boolean compareToList(List<Candidate> items, List<Candidate> dbItems) {
    return false;
  }

  @Autowired
  private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void setup() {
      mvc = MockMvcBuilders
        .webAppContextSetup(context)
        .apply(springSecurity())
        .build();
  }

  /**
   * Test function via HTTP
   * @throws Exception
   */
  @WithMockUser(username="admin",password="adminadmin")
  @Test
  public void test() throws Exception {

    // Make object
    Candidate candidate = new Candidate();
    candidate.setFirstname("Jean");
    candidate.setLastname("Dupont");
    candidate.setEmail("amatter@gmail.com");
    candidate.setCellPhone("0987789878");

    // Transform to JSON
    String objJson = this.objectMapper.writeValueAsString(candidate);

    // Prepare Request
    MockHttpServletRequestBuilder request = post(BASE_API + entityPath + "/test").contentType("application/json")

        .content(objJson);

    MvcResult result = this.mockMvc.perform(request).andExpect(status().isOk()).andReturn();

    System.out.println(result.getResponse().getStatus());
    System.out.println(result.getResponse().getContentAsString());

    // Transform to Object
    Candidate newSess = this.objectMapper.readValue(result.getResponse().getContentAsString(), Candidate.class);

    // Tests
    assertNotNull(newSess);
    assertThat(candidate.getFirstname()).isEqualTo(newSess.getFirstname());
    assertThat(candidate.getCellPhone()).isEqualTo(newSess.getCellPhone());
  }

}
