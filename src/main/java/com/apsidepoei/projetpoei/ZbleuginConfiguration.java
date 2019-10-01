package com.apsidepoei.projetpoei;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableSwagger2
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

  // TODO: Remove if useless.

  /**
   * Objectmapper.
   * @param builder to map in the object.
   * @return return un Objectmapper.
   */
  @Bean
  @Primary
  public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
    ObjectMapper objectMapper = builder.createXmlMapper(false).build();
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    objectMapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, true);
    //  objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
    return objectMapper;
  }

  @Bean
  public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.ant("/api/**/*"))
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfo("Zbleugin",
        "Application de gestion de candidats",
        "v1.0.0",
        "",
        new Contact("TACTfactory","http://www.tactfactory.com/", "contact@tactfactory.com"),
        "MIT",
        "https://github.com/ClementBreizh/zbleuginAPI/blob/dev/LICENSE",
        Collections.emptyList());
  }
}
