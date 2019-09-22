package com.apsidepoei.projetpoeitest.restTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpMethod;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.apsidepoei.projetpoei.ZbleuginApplication;
import com.apsidepoei.projetpoei.database.repositories.AppointmentRepository;
import com.apsidepoei.projetpoei.database.repositories.PersonRepository;
import com.apsidepoei.projetpoei.entities.Appointment;
import com.apsidepoei.projetpoei.entities.Matter;
import com.apsidepoei.projetpoei.entities.Person;
import com.apsidepoei.projetpoei.entities.Session;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
*
* @author clemb
* Tests for Appointment Entity.
*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class AppointmentRestControllerTest extends BaseRestControllerTest<Appointment, Integer> {

  @Autowired
  private AppointmentRepository repository;
  /**
   * Empty Constructor.
   */
  public AppointmentRestControllerTest() {
    super("/appointments");
  }
  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<Appointment, Integer> getRepository() {
    return repository;
  }
  /**
   * Parse Adress in Json to List for test.
   */
  @Override
  protected List<Appointment> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Appointment>>() {
    });
  }
  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(Appointment item1, Appointment item2) {
    return item1.getId().equals(item2.getId()) && item1.getInformations().equals(item2.getInformations())
        && item1.getAppointmentDate().compareTo(item2.getAppointmentDate()) == 0 && item1.getReport().equals(item2.getReport());
  }
  /**
   * Parse Json to a Object Appointment for run test.
   */
  @Override
  protected Appointment parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Appointment>() {
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
  LocalDateTime date = LocalDateTime.now();
  Person organizer = new Person();
  @Override
  protected Appointment getObjectTest() throws ParseException {
    Appointment item = new Appointment();
    return item;
  }
  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(Appointment item) {
    return item.getId();
  }
  /**
   * Create a string for POST method API.
   */
  @Override
  protected String getObjectToStringToPost() {
    String urlParameters  = "informations=Commentaire&dateTime=2019/12/15&report=Report";
    return urlParameters;
  }
  /**
   * Method to compare list.
   */
  @Override
  protected boolean compareToList(List<Appointment> items, List<Appointment> dbItems) {
    return false;
  }

  /**
   * Test function via HTTP
   * @throws Exception
   */
  @Test
  public void test() throws Exception {

      // Make objects
      Person pers = new Person();
      pers.setFirstname("Clement");
      pers.setLastname("BOUCHEREAU");
      pers.setEmail("moemain@gmail.com");
      pers.setCellPhone("9809877786");

      Appointment sess = new Appointment();
      sess.setAppointmentDate(LocalDateTime.now());
      sess.setOrganizer(pers);

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
      Appointment newSess = this.objectMapper.readValue(result.getResponse().getContentAsString(), Appointment.class);

      // Tests
      assertNotNull(newSess);
      assertThat(sess.getAppointmentDate()).isEqualTo(newSess.getAppointmentDate());
  }
}
