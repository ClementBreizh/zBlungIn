package com.apsidepoei.projetpoeitest.restTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpMethod;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.apsidepoei.projetpoei.ZbleuginApplication;
import com.apsidepoei.projetpoei.database.repositories.FeedbackRepository;
import com.apsidepoei.projetpoei.entities.Feedback;
import com.apsidepoei.projetpoei.entities.Matter;
import com.apsidepoei.projetpoei.entities.Session;
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
public class FeedbackRestControllerTest extends BaseRestControllerTest<Feedback, Integer> {

  @Autowired
  private FeedbackRepository repository;
  /**
   * Empty Constructor.
   */
  public FeedbackRestControllerTest() {
    super("/feedbacks");
  }
  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<Feedback, Integer> getRepository() {
    return repository;
  }
  /**
   * Parse Json to List for test.
   */
  @Override
  protected List<Feedback> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Feedback>>() {
    });
  }
  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(Feedback item1, Feedback item2) {
    return item1.getId().equals(item2.getId())
        && item1.getTypeOfContract().equals(item2.getTypeOfContract())
            && item1.getDurationOfContract().equals(item2.getDurationOfContract())
                && item1.getComment().equals(item2.getComment());
  }
  /**
   * Parse Json to a Object for run test.
   */
  @Override
  protected Feedback parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Feedback>() {
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
    Feedback item = new Feedback();
    return item;
  }
  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(Feedback item) {
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
  protected boolean compareToList(List<Feedback> items, List<Feedback> dbItems) {
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
    Feedback sess = new Feedback();
      sess.setTypeOfContract("CDI");
      sess.setDurationOfContract(24);
      sess.setComment("blablabla");
      sess.setUpdatedAt(LocalDate.now());

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
      Feedback newSess = this.objectMapper.readValue(result.getResponse().getContentAsString(), Feedback.class);

      // Tests
      assertNotNull(newSess);
      assertThat("CDI").isEqualTo(newSess.getTypeOfContract());
  }
}


