package com.apsidepoei.projetpoeitest;

import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.apsidepoei.projetpoei.ZbleuginApplication;

@SpringBootApplication
@Configuration
@ComponentScan("com.apsidepoei.projetpoei.entities")
@EnableJpaRepositories(basePackages="com.apsidepoei")
public class ProjetPoeiApplicationTest {

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
