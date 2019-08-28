package com.apsidepoei.projetpoeitest.restTest;

import java.io.IOException;
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
import com.apsidepoei.projetpoei.database.repositories.SessionRepository;
import com.apsidepoei.projetpoei.entities.Session;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class SessionRestControllerTest extends BaseRestControllerTest<Session, Integer> {

  @Autowired
  private SessionRepository repository;

  public SessionRestControllerTest() {
    super("/sessions");
  }

  @Override
  protected JpaRepository<Session, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Session> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Session>>() {
    });
  }

  @Override
  protected boolean compareTo(Session item1, Session item2) {
    return item1.getId().equals(item2.getId())
        && item1.getName().equals(item2.getName())
          && item1.getDateStart().equals(item2.getDateStart())
            && item1.getDateEnd().equals(item2.getDateEnd());
  }
  @Override
  protected Session parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Session>() {
    });
  }

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }
}


