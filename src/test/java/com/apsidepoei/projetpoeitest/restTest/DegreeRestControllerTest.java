package com.apsidepoei.projetpoeitest.restTest;

import java.io.IOException;
import java.util.List;

import org.junit.experimental.theories.internal.ParameterizedAssertionError;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.apsidepoei.projetpoei.ZbleuginApplication;
import com.apsidepoei.projetpoei.database.repositories.DegreeRepository;
import com.apsidepoei.projetpoei.entities.Degree;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import freemarker.core.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class DegreeRestControllerTest extends BaseRestControllerTest<Degree, Integer> {

  @Autowired
  private DegreeRepository repository;

  public DegreeRestControllerTest() {
    super("/degrees");
  }

  @Override
  protected JpaRepository<Degree, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Degree> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Degree>>() {
    });
  }

  @Override
  protected boolean compareTo(Degree item1, Degree item2) {
    return item1.getId().equals(item2.getId()) && item1.getName().equals(item2.getName())
        && item1.getLevel().equals(item2.getLevel());
  }

  @Override
  protected Degree parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Degree>() {
    });
  }

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  @Override
  protected Degree getObjectTest() {
    Degree item = new Degree("BTS","Developpement Test");
    return item;
  }

  @Override
  protected Integer getItemIdTest(Degree item) {
    return item.getId();
  }
}

