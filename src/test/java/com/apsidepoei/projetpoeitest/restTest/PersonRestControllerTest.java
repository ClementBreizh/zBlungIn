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
import com.apsidepoei.projetpoei.database.repositories.PersonRepository;
import com.apsidepoei.projetpoei.entities.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class PersonRestControllerTest extends BaseRestControllerTest<Person, Integer> {

  @Autowired
  private PersonRepository repository;

  public PersonRestControllerTest() {
    super("/persons");
  }

  @Override
  protected JpaRepository<Person, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Person> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Person>>() {
    });
  }

  @Override
  protected boolean compareTo(Person item1, Person item2) {
    return item1.getId().equals(item2.getId())
        && item1.getFirstname().equals(item2.getFirstname())
            && item1.getLastname().equals(item2.getLastname())
                && item1.getEmail().equals(item2.getEmail())
                  && item1.getCellPhone().equals(item2.getCellPhone())
                    && item1.getHomePhone().equals(item2.getHomePhone())
                      && item1.getCommentary().equals(item2.getCommentary());
  }

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  @Override
  protected Person getObjectTest() {
    Person item = new Person("José", "Phine", "josephine@gmail.com", "0712233443", "0212342534", "no comment");
    return item;
  }

  @Override
  protected Integer getItemIdTest(Person item) {
    return item.getId();
  }
}






