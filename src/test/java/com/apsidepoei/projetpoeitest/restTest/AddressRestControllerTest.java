package com.apsidepoei.projetpoeitest.restTest;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.apsidepoei.projetpoei.ZbleuginApplication;
import com.apsidepoei.projetpoei.database.repositories.AddressRepository;
import com.apsidepoei.projetpoei.entities.Address;
import com.apsidepoei.projetpoei.entities.Matter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
*
* @author clemb
* Tests for Adress Entity.
*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class AddressRestControllerTest extends BaseRestControllerTest<Address, Integer> {

  @Autowired
  private AddressRepository repository;

  /**
   * Empty Constructor.
   */
  public AddressRestControllerTest() {
    super("/addresses");
  }

  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<Address, Integer> getRepository() {
    return repository;
  }

  /**
   * Parse Json to List for test.
   */
  @Override
  protected List<Address> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Address>>() {
    });
  }

  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(Address item1, Address item2) {
    return item1.getId().equals(item2.getId()) && item1.getPostalCode().equals(item2.getPostalCode())
        && item1.getStreet().equals(item2.getStreet()) && item1.getCity().equals(item2.getCity());
  }

  /**
   * Parse Json to a Object for run test.
   */
  @Override
  protected Address parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Address>() {
    });
  }
  /**
   * Generate a Id for run test.
   */
  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }
  /**
   * Create a object for run test.
   */
  @Override
  protected Address getObjectTest() {
    Address item = new Address("adressepostale", "35000", "ville");
    return item;
  }
  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(Address item) {
    return item.getId();
  }
  /**
   * Create a string for POST method API.
   */
  @Override
  protected String getObjectToStringToPost() {
    String urlParameters  = "street=4352&postalCode=35000&city=ville";
    return urlParameters;
  }
  /**
   * Method to compare list.
   */
  @Override
  protected boolean compareToList(List<Address> items, List<Address> dbItems) {
    return false;
  }

  /**
   * Test to getAll.
   *
   * @throws IOException
   */
  @Test
  public void getAll() throws IOException {
    StringBuilder builder = new StringBuilder();
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath, HttpMethod.GET);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }

    List<Address> dbItems = getRepository().findAll();
    List<Address> httpItems = parseJsonToList(builder);

    if (dbItems.size() != httpItems.size()) {
      fail("List sized are not same");
    }
    for (int i = 0; i < httpItems.size(); i++) {
      if (!compareTo(dbItems.get(i), httpItems.get(i))) {
        fail();
      }
    }
  }

  /**
   * Test to getById.
   *
   * @throws IOException
   * @throws ParseException
   */
  @Test
  public void getById() throws IOException, ParseException {
    StringBuilder builder = new StringBuilder();
    Address item = getRepository().save(getObjectTest());
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath + "/" + getItemIdTest(item), HttpMethod.GET);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }

    Optional<Address> dbItem = getRepository().findById(getItemIdTest(item));

    Address httpItem = parseJsonToObject(builder);

    if (dbItem == null && httpItem == null) {
      fail("One of object is null");
    }

    if (!compareTo(dbItem.get(), httpItem)) {
      fail();
    }

  }

  /**
   * Test if data is deleted.
   *
   * @throws IOException
   * @throws ParseException
   */
  @Test(expected = NoSuchElementException.class)
  public void deleteById() throws IOException, ParseException {
    StringBuilder builder = new StringBuilder();
    Address item = getRepository().save(getObjectTest());
    getRepository().flush();
    try {
      httpUtils.callServer(builder, BASE_API + entityPath + "/" + getItemIdTest(item), HttpMethod.DELETE);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
    Optional<Address> deleteItem = getRepository().findById(getItemIdTest(item));
    deleteItem.get();
  }

  /**
   * Test if table is clear
   *
   * @throws IOException
   */
  @Test
  public void deleteAll() throws IOException {
    StringBuilder builder = new StringBuilder();
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath, HttpMethod.DELETE);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
    List<Address> httpItems = parseJsonToList(builder);

    if (!httpItems.isEmpty()) {
      fail();
    }
  }

  /**
   * Test if size of item is the same
   *
   * @throws IOException
   */
  @Test
  public void count() throws IOException {
    StringBuilder builder = new StringBuilder();
    builder = httpUtils.callServer(builder, BASE_API + entityPath, HttpMethod.GET);

    List<Address> dbItems = getRepository().findAll();
    List<Address> httpItems = parseJsonToList(builder);
    if (dbItems.size() != httpItems.size()) {
      fail();
    }
  }

  /**
   * Test for save objet, get him to URL + repo and test if is the same.
   * @throws Exception
   */
  @Test
  public void save() throws Exception {
    getRepository().deleteAll();
    String objJson = this.objectMapper.writeValueAsString(getObjectTest());

    // Prepare Request
    MockHttpServletRequestBuilder request = post(BASE_API + entityPath).contentType("application/json")

        .content(objJson);

    MvcResult result = this.mockMvc.perform(request).andExpect(status().isOk()).andReturn();

    System.out.println(result.getResponse().getStatus());
    System.out.println(result.getResponse().getContentAsString());

    // Transform to Object
    Address item = parseJsonToObject(new StringBuilder(result.getResponse().getContentAsString()));

    Optional<Address> dbItem = getRepository().findById(getItemIdTest(item));

    if (dbItem == null && item == null) {
      fail("One of object is null");
    }

    if (!compareTo(dbItem.get(), item)) {
      fail();
    }
  }
}
