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
import com.apsidepoei.projetpoei.database.repositories.FeedbackRepository;
import com.apsidepoei.projetpoei.entities.Feedback;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class FeedbackRestControllerTest extends BaseRestControllerTest<Feedback, Integer> {

  @Autowired
  private FeedbackRepository repository;

  public FeedbackRestControllerTest() {
    super("/feedbacks");
  }

  @Override
  protected JpaRepository<Feedback, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Feedback> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Feedback>>() {
    });
  }

  @Override
  protected boolean compareTo(Feedback item1, Feedback item2) {
    return item1.getId().equals(item2.getId())
        && item1.getTypeOfContract().equals(item2.getTypeOfContract())
            && item1.getDurationOfContract().equals(item2.getDurationOfContract())
                && item1.getComment().equals(item2.getComment());
  }

  @Override
  protected Feedback parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Feedback>() {
    });
  }

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  @Override
  protected Feedback getObjectTest() throws ParseException {
    Feedback item = new Feedback("CDI", 24, "no comment test");
    return item;
  }

  @Override
  protected Integer getItemIdTest(Feedback item) {
    return item.getId();
  }
}


