package com.apsidepoei.projetpoeitest.restTest;

import static org.junit.Assert.fail;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;
import org.junit.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpMethod;

import com.apsidepoei.projetpoeitest.utils.HttpUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author. Test queries generically
 *
 * @param <T>  for daughter
 * @param <ID> for id
 */
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
      builder = httpUtils.callServer(builder, BASE_API + entityPath, HttpMethod.GET);
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

  protected abstract boolean compareToList(List<T> items, List<T> dbItems);

  @Test
  public void getById() throws IOException, ParseException {
    StringBuilder builder = new StringBuilder();
    T item = getRepository().save(getObjectTest());
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath + "/" + getItemIdTest(item), HttpMethod.GET);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }

    Optional<T> dbItem = getRepository().findById(getItemIdToTest());

    T httpItem = parseJsonToObject(builder);

    if (dbItem == null && httpItem == null) {
      fail("One of object is null");
    }

    if (!compareTo(dbItem.get(), httpItem)) {
      fail();
    }

  }

  protected abstract T parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException;

  /**
   * Test of data selected by Id is deleted.
   *
   * @throws ParseException
   * @throws IOException.
   */
  @Test(expected = NoSuchElementException.class)
  public void deleteById() throws IOException, ParseException {
    StringBuilder builder = new StringBuilder();
    T item = getRepository().save(getObjectTest());
    getRepository().flush();
    try {
      httpUtils.callServer(builder, BASE_API + entityPath + "/" + getItemIdTest(item), HttpMethod.DELETE);
      // builder = httpUtils.callServer(builder, BASE_API + entityPath, "GET");
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
    // List<T> httpItems = parseJsonToList(builder);
    Optional<T> deleteItem = getRepository().findById(getItemIdTest(item));
    deleteItem.get();

  }

  /**
   * Test if all datas is DELETE.
   *
   * @throws IOException.
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
    List<T> httpItems = parseJsonToList(builder);

    if (!httpItems.isEmpty()) {
      fail();
    }
  }

  @Test
  public void save() throws ParseException, IOException {
    getRepository().deleteAll();
    StringBuilder builder = new StringBuilder();
    String urlParameters = getObjectToStringToPost();
    byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
    int postDataLength = postData.length;
    String request = "http://127.0.0.1:1234" + BASE_API + entityPath;
    URL url = new URL(request);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setInstanceFollowRedirects(false);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    conn.setRequestProperty("charset", "utf-8");
    conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
    conn.setUseCaches(false);
    try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
      wr.write(postData);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
    conn.connect();
    System.out.println(conn.getResponseCode());

    // If all is ok parse server datas
    Scanner sc = new Scanner(url.openStream());
    builder = new StringBuilder();

    // Loop over scanner datas to parse them
    while (sc.hasNext()) {
      builder.append(sc.next());
    }

    // Close scanner

    sc.close();
    List<T> httpItems = parseJsonToList(builder);

    List<T> dbItems = getRepository().findAll();

    if (dbItems.size() != httpItems.size()) {
      fail("List sized are not same");
    }

    if (!compareTo(dbItems.get(0), httpItems.get(0))) {
      fail("items not same");
    }

  }

  @Test
  public void count() throws IOException {
    long counter = getRepository().count();
    StringBuilder builder = new StringBuilder();
    builder = httpUtils.callServer(builder, BASE_API + entityPath, HttpMethod.GET);

  List<T> dbItems = getRepository().findAll();
  List<T> httpItems = parseJsonToList(builder);

  System.out.println(dbItems.size());
  System.out.println(httpItems.size());
  System.out.println(counter);

  }

  protected abstract T getObjectTest() throws ParseException;

  protected abstract ID getItemIdTest(T item);

  protected abstract String getObjectToStringToPost();

}
