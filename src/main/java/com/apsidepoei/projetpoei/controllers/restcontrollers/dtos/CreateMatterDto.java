package com.apsidepoei.projetpoei.controllers.restcontrollers.dtos;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Value
public class CreateMatterDto {
  
  @NotBlank
  private final String name;
  
  private final Float score;
  
  private final LocalDate validationDate;
  
}