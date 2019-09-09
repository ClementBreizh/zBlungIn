package com.apsidepoei.projetpoei.controllers.restcontrollers.dtos;

import java.util.ArrayList;
import java.util.List;

import com.apsidepoei.projetpoei.database.contracts.DegreeContract;
import com.apsidepoei.projetpoei.entities.Candidate;
import com.apsidepoei.projetpoei.entities.Degree;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DegreeDto {

  @JsonProperty(value = DegreeContract.COL_ID)
  private Integer id;

  @JsonProperty(value = DegreeContract.COL_NAME)
  private String name;

  @JsonProperty(value = DegreeContract.COL_LEVEL)
  private String level;

  @JsonProperty(value = DegreeContract.COL_CANDIDATES)
  private final List<DegreeCandidateDto> candidates;

  public DegreeDto() {
    super();
    this.candidates = new ArrayList<DegreeCandidateDto>();
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

  public List<DegreeCandidateDto> getCandidates() {
    return candidates;
  }

  public void parseIn(Degree degree) {
    this.setId(degree.getId());
    this.setLevel(degree.getLevel());
    this.setName(degree.getName());

    for (Candidate candidate : degree.getCandidates()) {
      DegreeCandidateDto candidateDto = new DegreeCandidateDto();
      candidateDto.parseIn(candidate);
      this.getCandidates().add(candidateDto);
    }
  }

  public Degree parseOut() {
    Degree degree = new Degree();
    degree.setId(this.getId());
    degree.setLevel(this.getLevel());
    degree.setName(this.getName());

    for (DegreeCandidateDto candidateDto : this.getCandidates()) {
      degree.getCandidates().add(candidateDto.parseOut());
    }

    return degree;
  }
}
