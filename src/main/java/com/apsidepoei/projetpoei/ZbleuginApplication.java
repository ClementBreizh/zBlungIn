package com.apsidepoei.projetpoei;

import java.sql.SQLException;
import java.text.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages="com.apsidepoei")
public class ZbleuginApplication {



  /**
   * Main entry.
   * @param args = the args
   * @throws ParseException = exception
   * @throws SQLException   = exception
   */
  public static void main(String[] args) throws ParseException, SQLException {
    SpringApplication.run(ZbleuginApplication.class, args);
  }
}
