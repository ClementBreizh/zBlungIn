package com.apsidepoei.projetpoeitest.restTest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.apsidepoei.projetpoei.database.repositories.AssessmentRepository;
import com.apsidepoei.projetpoei.entities.Assessment;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class AssessmentRestControllerTest extends BaseRestControllerTest<Assessment, Integer> {

  @Autowired
  private AssessmentRepository repository;

  public AssessmentRestControllerTest() {
    super("/assesments");
  }

  @Override
  protected JpaRepository<Assessment, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Assessment> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Assessment>>() {
    });
  }

  @Override
  protected boolean compareTo(Assessment item1, Assessment item2) {
    return item1.getId().equals(item2.getId()) && item1.getCategory().equals(item2.getCategory())
        && item1.getDateTime().compareTo(item2.getDateTime()) == 0;
  }

  @Override
  protected Assessment parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Assessment>() {
    });
  }

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  @Override
  protected Assessment getObjectTest() throws ParseException {
    Assessment item = new Assessment("categorie", new SimpleDateFormat("yyyy/MM/dd").parse("2019/10/02"));
    return item;
  }

  @Override
  protected Integer getItemIdTest(Assessment item) {
    return item.getId();
  }

  @Override
  protected String getObjectToStringToPost() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected boolean compareToList(List<Assessment> items, List<Assessment> dbItems) {
    // TODO Auto-generated method stub
    return false;
  }
}
