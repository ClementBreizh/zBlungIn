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
import com.apsidepoei.projetpoei.database.repositories.MatterRepository;
import com.apsidepoei.projetpoei.entities.Matter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class MatterRestControllerTest extends BaseRestControllerTest<Matter, Integer> {

  @Autowired
  private MatterRepository repository;

  public MatterRestControllerTest() {
    super("/matters");
  }

  @Override
  protected JpaRepository<Matter, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Matter> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Matter>>() {
    });
  }

  @Override
  protected boolean compareTo(Matter item1, Matter item2) {
    return item1.getId().equals(item2.getId())
        && item1.getName().equals(item2.getName());
  }

  @Override
  protected Matter parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Matter>() {
    });
  }

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  @Override
  protected Matter getObjectTest() throws ParseException {
    Matter item = new Matter("MatièreTest1");
    return item;
  }

  @Override
  protected Integer getItemIdTest(Matter item) {
    return item.getId();
  }
}

