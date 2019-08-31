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
import com.apsidepoei.projetpoei.database.repositories.AppointmentRepository;
import com.apsidepoei.projetpoei.entities.Appointment;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class AppointmentRestControllerTest extends BaseRestControllerTest<Appointment, Integer> {

  @Autowired
  private AppointmentRepository repository;

  public AppointmentRestControllerTest() {
    super("/appointments");
  }

  @Override
  protected JpaRepository<Appointment, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Appointment> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Appointment>>() {
    });
  }

  @Override
  protected boolean compareTo(Appointment item1, Appointment item2) {
    return item1.getId().equals(item2.getId()) && item1.getInformations().equals(item2.getInformations())
        && item1.getDateTime().compareTo(item2.getDateTime()) == 0 && item1.getReport().equals(item2.getReport());
  }

  @Override
  protected Appointment parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Appointment>() {
    });
  }

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  @Override
  protected Appointment getObjectTest() throws ParseException {
    Appointment item = new Appointment("Commentaire 1",new SimpleDateFormat("yyyy/MM/dd").parse("2019/12/15"), "Report 1");
    return item;
  }

  @Override
  protected Integer getItemIdTest(Appointment item) {
    return item.getId();
  }

  @Override
  protected String getObjectToStringToPost() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected boolean compareToList(List<Appointment> items, List<Appointment> dbItems) {
    // TODO Auto-generated method stub
    return false;
  }
}

