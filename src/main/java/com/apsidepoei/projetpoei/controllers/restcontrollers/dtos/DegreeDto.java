package com.apsidepoei.projetpoei.controllers.restcontrollers.dtos;

import com.apsidepoei.projetpoei.database.contracts.DegreeContract;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DegreeDto {

  @JsonProperty(value = DegreeContract.COL_ID)
  private Integer id;

  @JsonProperty(value = DegreeContract.COL_NAME)
  private String name;

  @JsonProperty(value = DegreeContract.COL_LEVEL)
  private String level;


  public DegreeDto() {
    super();
  }

  public DegreeDto(Integer id, String name, String level) {
    this();
    this.id = id;
    this.name = name;
    this.level = level;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

}
