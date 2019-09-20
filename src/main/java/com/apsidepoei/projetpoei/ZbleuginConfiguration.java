package com.apsidepoei.projetpoei;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ZbleuginConfiguration {

  /**
   * CORS Configuration.
   * @return the configuration for disable CORS restrictions.
   */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurerAdapter() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**/*")
            .allowedOrigins("*")
            .allowedHeaders("*")
            .allowCredentials(true)
            .allowedMethods("*");
      }
    };
  }
}
