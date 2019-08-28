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
import com.apsidepoei.projetpoei.database.repositories.CompanyRepository;
import com.apsidepoei.projetpoei.entities.Company;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class CompanyRestControllerTest extends BaseRestControllerTest<Company, Integer> {

  @Autowired
  private CompanyRepository repository;

  public CompanyRestControllerTest() {
    super("/companies");
  }

  @Override
  protected JpaRepository<Company, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Company> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Company>>() {
    });
  }

  @Override
  protected boolean compareTo(Company item1, Company item2) {
    return item1.getId().equals(item2.getId()) && item1.getNom().equals(item2.getNom())
        && item1.getNomAntenne().equals(item2.getNomAntenne()) && item1.getSiret().equals(item2.getSiret())
        && item1.getCodeApe().equals(item2.getCodeApe());
  }
  
  @Override
  protected Company parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Company>() {
    });
  }

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  @Override
  protected Company getObjectTest() throws ParseException {
    Company item = new Company(1, "entreprise1", "antenne1", "53267126000018", "0000A");
    return item;
  }

  @Override
  protected Integer getItemIdTest(Company item) {
    return item.getId();
  }
}
