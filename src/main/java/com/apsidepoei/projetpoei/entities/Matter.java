package com.apsidepoei.projetpoei.entities;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.CandidateContract;
import com.apsidepoei.projetpoei.database.contracts.MatterContract;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = MatterContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = MatterContract.COL_ID))
public class Matter extends EntityDb {

  @JsonProperty(value = MatterContract.COL_NAME)
  @Column(name = MatterContract.COL_NAME, nullable = false, length = 50)
  private String name;

  @JsonProperty(value = MatterContract.COL_CANDIDATES)
  @ManyToMany(targetEntity = Candidate.class)
  @JoinTable(name = "matter_candidate", joinColumns = {
      @JoinColumn(name = MatterContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = CandidateContract.COL_ID) })
  private List<Candidate> candidates;


  /**
   * constructor.
   */
  public Matter() {
    super();
  }

  /**
   * Name in parameter.
   */
  public Matter(String name) {
    super();
    this.name = name;
  }

  @Override
  public String toString() {
    return "Matter [Id = " + getId() + ", name= " + name + "]";
  }


  // GETTER/SETTER

  /**
   * the name.
   */
  public String getName() {
    return name;
  }

  /**
   * name the name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * constructor woth id and name.
   */
  public Matter(int id, String name) {
    super();
    this.setId(id);
    this.name = name;
  }

  /**
   * @return the candidates
   */
  public List<Candidate> getCandidates() {
    return candidates;
  }

  /**
   * @param candidates the candidates to set
   */
  public void setCandidates(List<Candidate> candidates) {
    this.candidates = candidates;
  }
}
