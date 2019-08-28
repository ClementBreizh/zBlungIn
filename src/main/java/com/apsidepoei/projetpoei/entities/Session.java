package com.apsidepoei.projetpoei.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.CandidateContract;
import com.apsidepoei.projetpoei.database.contracts.SessionContract;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is the session entity.
 *
 * @author benjamin-m
 *
 */
@Entity
@Table(name = SessionContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = SessionContract.COL_ID))
public class Session extends EntityDb {

  @JsonProperty(value = SessionContract.COL_NAME)
  @Column(name = SessionContract.COL_NAME, nullable = false)
  private String name;

  @JsonProperty(value = SessionContract.COL_DATE_START)
  @Column(name = SessionContract.COL_DATE_START, nullable = false)
  private Date dateStart;

  @JsonProperty(value = SessionContract.COL_DATE_END)
  @Column(name = SessionContract.COL_DATE_END, nullable = false)
  private Date dateEnd;

  @JsonProperty(value = SessionContract.COL_CANDIDATES)
  @ManyToMany(targetEntity = Candidate.class)
  @JoinTable(name = "session_candidate", joinColumns = {
      @JoinColumn(name = SessionContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = CandidateContract.COL_ID) })
  private List<Candidate> candidates;


  /**
   * The name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name.
   *
   * @param name = the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The dateStart.
   *
   * @return the start date
   */
  public Date getDateStart() {
    return dateStart;
  }

  /**
   * Set the date start.
   *
   * @param dateStart = the start date
   */
  public void setDateStart(Date dateStart) {
    this.dateStart = dateStart;
  }

  /**
   * The dateEnd.
   *
   * @return the end date
   */
  public Date getDateEnd() {
    return dateEnd;
  }

  /**
   * Set the dateEnd.
   *
   * @param dateEnd = the end date
   */
  public void setDateEnd(Date dateEnd) {
    this.dateEnd = dateEnd;
  }

  /**
   * Constructor for a new Session.
   *
   * @param name      = the name
   * @param dateStart = the dateStart
   * @param dateEnd   = the dateEnd
   */
  public Session(String name, Date dateStart, Date dateEnd) {
    super();
    this.name = name;
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
  }

  /**
   * Constructor with id for a new Session.
   *
   * @param id        = the id
   * @param name      = the name
   * @param dateStart = the dateStart
   * @param dateEnd   = the dateEnd
   */
  public Session(int id, String name, Date dateStart, Date dateEnd) {
    super();
    this.setId(id);
    this.name = name;
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
  }

  /**
   * Empty constructor.
   */
  public Session() {

  }

  /**
   * Override toString() function.
   */
  @Override
  public String toString() {
    return "session [Id = " + getId() + ", name=" + name + ", dateStart=" + dateStart + ", dateEnd="
        + dateEnd + "]";
  }
}
