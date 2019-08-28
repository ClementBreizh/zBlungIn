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
import com.apsidepoei.projetpoei.database.repositories.AddressRepository;
import com.apsidepoei.projetpoei.entities.Address;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class AddressRestControllerTest extends BaseRestControllerTest<Address, Integer> {

  @Autowired
  private AddressRepository repository;

  public AddressRestControllerTest() {
    super("/addresses");
  }

  @Override
  protected JpaRepository<Address, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Address> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Address>>() {
    });
  }

  @Override
  protected boolean compareTo(Address item1, Address item2) {
    return item1.getId().equals(item2.getId()) && item1.getPostalCode().equals(item2.getPostalCode())
        && item1.getAddress().equals(item2.getAddress()) && item1.getTown().equals(item2.getTown());
  }
  
  @Override
  protected Address parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Address>() {
    });
  }

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }
}
