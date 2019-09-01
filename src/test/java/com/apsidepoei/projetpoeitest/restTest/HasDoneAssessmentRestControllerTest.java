package com.apsidepoei.projetpoeitest.restTest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.apsidepoei.projetpoei.database.repositories.HasDoneAssessmentRepository;
import com.apsidepoei.projetpoei.entities.HasDoneAssessment;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
*
* @author clemb
* Tests for HasDoneAssessment Entity.
*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class HasDoneAssessmentRestControllerTest extends BaseRestControllerTest<HasDoneAssessment, Integer>{
  @Autowired
  private HasDoneAssessmentRepository repository;

  /**
   * Empty Constructor.
   */
  public HasDoneAssessmentRestControllerTest() {
    super("/persons");
  }

  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<HasDoneAssessment, Integer> getRepository() {
    return repository;
  }

  /**
   * Parse HasDoneAssessment in Json to List for test.
   */
  @Override
  protected List<HasDoneAssessment> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<HasDoneAssessment>>() {
    });
  }

  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(HasDoneAssessment item1, HasDoneAssessment item2) {
    return item1.getId().equals(item2.getId())
        && item1.getScore().equals(item2.getScore())
            && item1.getValidationDate().equals(item2.getValidationDate())
                && item1.getAssessment().equals(item2.getAssessment())
                  && item1.getCandidate().equals(item2.getCandidate());
  }

  /**
   * Generate a Id for run test.
   */
  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  /**
   * Create a HasDoneAssessment object for run test.
   * @throws ParseException
   */
  @Override
  protected HasDoneAssessment getObjectTest() throws ParseException {
    Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2019/12/21");
    HasDoneAssessment item = new HasDoneAssessment(12F, date);
    return item;
  }

  /**
   * Create a string for POST method API.
   * @throws ParseException
   */
  @Override
  protected String getObjectToStringToPost() {
    String urlParameters  = "score=12F&validationDate=2019/12/21";
    return urlParameters;
  }

  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(HasDoneAssessment item) {
    return item.getId();
  }

  /**
   * Parse Json to a Object HasDoneAssessment for run test.
   */
  @Override
  protected HasDoneAssessment parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<HasDoneAssessment>() {
    });
  }

  /**
   * Method to compare list of HasDoneAssessment.
   */
  @Override
  protected boolean compareToList(List<HasDoneAssessment> items, List<HasDoneAssessment> dbItems) {
    return false;
  }
}
