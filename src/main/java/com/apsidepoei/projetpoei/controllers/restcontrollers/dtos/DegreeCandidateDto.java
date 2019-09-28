package com.apsidepoei.projetpoei.controllers.restcontrollers.dtos;

import com.apsidepoei.projetpoei.database.contracts.CandidateContract;
import com.apsidepoei.projetpoei.entities.Address;
import com.apsidepoei.projetpoei.entities.Candidate;
import com.apsidepoei.projetpoei.entities.Matter;
import com.apsidepoei.projetpoei.entities.Person;
import com.apsidepoei.projetpoei.entities.RankingCandidate;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DegreeCandidateDto extends Person {

  @JsonProperty(value = CandidateContract.COL_RANKING_CANDIDATE)
  private RankingCandidate ranking = RankingCandidate.RANK_0;

  @JsonProperty(value = CandidateContract.COL_MATTERS)
  private final List<Matter> matters = new ArrayList<>();

  @JsonProperty(value = CandidateContract.COL_FK_ID_ADDRESS)
  protected Address address;

  public RankingCandidate getRanking() {
    return ranking;
  }

  public void setRanking(RankingCandidate ranking) {
    this.ranking = ranking;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Matter> getMatters() {
    return matters;
  }

  public DegreeCandidateDto() {
    super();
  }

  /**
   * Constructor.
   * @param ranking is the rank.
   * @param address is the address.
   */
  public DegreeCandidateDto(RankingCandidate ranking, Address address) {
    this();
    this.ranking = ranking;
    this.address = address;
  }

  /**
   * Return a candidate.
   * @param candidate is the candidate to return.
   * @return id the candidate.
   */
  public DegreeCandidateDto parseIn(Candidate candidate) {
    this.setId(candidate.getId());
    this.setCellPhone(candidate.getCellPhone());
    this.setFirstname(candidate.getFirstname());
    this.setLastname(candidate.getLastname());
    //    this.getMatters().addAll(candidate.getMatters());

    return this;
  }

  /**
   * Parse the candidate.
   * @return Return the parsed candidate.
   */
  public Candidate parseOut() {
    Candidate candidate = new Candidate();
    candidate.setId(this.getId());
    candidate.setCellPhone(this.getCellPhone());
    candidate.setFirstname(this.getFirstname());
    candidate.setLastname(this.getLastname());
    //    candidate.getMatters().addAll(this.getMatters());

    return candidate;
  }
}
