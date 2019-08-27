package com.apsidepoei.projetpoeitest.restTest;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.junit.Test;

import com.apsidepoei.projetpoeitest.utils.HttpUtils;

public abstract class BaseRestControllerTest {

  public static final String BASE_API = "/api";
  private String entityPath;
  private HttpUtils httpUtils = new HttpUtils();

  public BaseRestControllerTest(String entityPath) {
    this.entityPath = entityPath;
  }

  protected abstract JpaRepository<T, ID> getRepository();

  @Test
  public void getAll() throws IOException {
    StringBuilder builder = new StringBuilder();
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath);
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
  public void getById() {
  }

  @Test
  public void deleteById() {
  }

  @Test
  public void deleteAll() {
  }

  @Test
  public void save() {
  }

  @Test
  public void count() {
  }

}
