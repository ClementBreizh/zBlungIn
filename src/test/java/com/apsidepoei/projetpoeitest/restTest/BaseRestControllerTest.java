package com.apsidepoei.projetpoeitest.restTest;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apsidepoei.projetpoeitest.utils.HttpUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public abstract class BaseRestControllerTest<T, ID> {

  public static final String BASE_API = "/api";
  private String entityPath;
  private HttpUtils httpUtils = new HttpUtils();

  public BaseRestControllerTest(String entityPath) {
    this.entityPath = entityPath;
  }

  protected abstract ID getItemIdToTest();

  protected abstract JpaRepository<T, ID> getRepository();

  @Test
  public void getAll() throws IOException {
    StringBuilder builder = new StringBuilder();
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath, "GET");
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }

    List<T> dbItems = getRepository().findAll();
    List<T> httpItems = parseJsonToList(builder);

    if (dbItems.size() != httpItems.size()) {
      fail("List sized are not same");
    }
    for (int i = 0; i < httpItems.size(); i++) {
      if (!compareTo(dbItems.get(i), httpItems.get(i))) {
        fail();
      }
    }
  }

  protected abstract List<T> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException;

  protected abstract boolean compareTo(T item1, T item2);

  @Test
  public void getById() throws IOException {
    StringBuilder builder = new StringBuilder();
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath + "/" + getItemIdToTest(), "GET");
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }

    Optional<T> dbItem = getRepository().findById(getItemIdToTest());

    T httpItem = parseJsonToObject(builder);

    if (dbItem == null && httpItem == null) {
      fail("One of object is nul");
    }

    if (!compareTo(dbItem.get(), httpItem)) {
      fail();
    }

  }

  protected abstract T parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException;


  /**
   * Test of data selected by Id is deleted.
   * @throws ParseException
   * @throws IOException.
   */
  @Test(expected = NoSuchElementException.class)
  public void deleteById() throws IOException, ParseException {
    StringBuilder builder = new StringBuilder();
    T item = getRepository().save(getObjectTest());
    getRepository().flush();
    try {
      httpUtils.callServer(builder, BASE_API + entityPath + "/" + getItemIdTest(item), "DELETE");
      //builder = httpUtils.callServer(builder, BASE_API + entityPath, "GET");
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
    //List<T> httpItems = parseJsonToList(builder);
    Optional<T> deleteItem = getRepository().findById(getItemIdTest(item));
    deleteItem.get();

  }

  /**
   * Test if all datas is DELETE.
   * @throws IOException.
   */
  @Test
  public void deleteAll() throws IOException {
    StringBuilder builder = new StringBuilder();
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath, "DELETE");
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
    List<T> httpItems = parseJsonToList(builder);

    if (!httpItems.isEmpty()) {
      fail();
    }
  }

  @Test
  public void save() {
  }

  @Test
  public void count() {
  }


  protected abstract T getObjectTest() throws ParseException;


  protected abstract ID getItemIdTest(T item);


}
