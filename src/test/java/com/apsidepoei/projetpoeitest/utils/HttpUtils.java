package com.apsidepoei.projetpoeitest.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpUtils {

    public StringBuilder callServer(StringBuilder builder, String subUrl) throws MalformedURLException, IOException {
      try {
        // Create base URL to go
        URL url = new URL("http://127.0.0.1:1234"+subUrl);

        // Allow to access HTTP via defined URL
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Set HTTP verbb to use
        conn.setRequestMethod("GET");

        // Real request connection with all configs
        conn.connect();

        // Retrieve current status for request
        int responsecode = conn.getResponseCode();

        // Actions before request ended from server side
        if (!(responsecode >= 200 && responsecode < 300))
          throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
          // If all is ok parse server datas
          Scanner sc = new Scanner(url.openStream());
          builder = new StringBuilder();

          // Loop over scanner datas to parse them
          while (sc.hasNext()) {
            builder.append(sc.nextLine());
          }

          System.out.println("\nJSON data in string format");
          System.out.println(builder.toString());

          // Close scanner
          sc.close();
        }

        // Close url connection
        conn.disconnect();
      } catch (MalformedURLException e) {
        e.printStackTrace();
        throw e;
      } catch (IOException e) {
        e.printStackTrace();
        throw e;
      }
      return builder;
    }
  }

