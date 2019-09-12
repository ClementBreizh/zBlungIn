/**
 *
 */
package com.apsidepoei.projetpoei.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.AddressContract;
import com.apsidepoei.projetpoei.database.contracts.CandidateContract;
import com.apsidepoei.projetpoei.database.contracts.CompanySessionContract;
import com.apsidepoei.projetpoei.database.contracts.MatterContract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

/**
 * @author vianney
 *
 */
@Entity
@ToString
@Table(name = CandidateContract.TABLE)
public class Candidate extends Person {

  @JsonProperty(value = CandidateContract.COL_RANKING_CANDIDATE)
  @Column(name = CandidateContract.COL_RANKING_CANDIDATE)
  private RankingCandidate ranking = RankingCandidate.RANK_0;

  @JsonProperty(value = CandidateContract.COL_FK_ID_FEEDBACK)
  @ManyToOne()
  private Feedback feedback;

//  @JsonIgnore
  @ManyToMany(fetch = FetchType.EAGER, // dit à l'ORM de charger la liste d'objects degrees lorqu'il charge un object candidat
  cascade = {
      CascadeType.PERSIST, // Dit à l'ORM de persister la grappe d'object Degree lorsqu'il persiste un Candidat
      CascadeType.MERGE
  })
  private List<Degree> degrees = new ArrayList<>();

//  @JsonIgnore
  @ManyToMany(targetEntity = Matter.class)
  @JoinTable(name = "candidate_matter", joinColumns = {
      @JoinColumn(name = CandidateContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = MatterContract.COL_ID) })
  private List<Matter> matters;

//  @JsonIgnore
  @ManyToMany(targetEntity = CompanySession.class)
  @JoinTable(joinColumns = {
    @JoinColumn(name = CandidateContract.COL_ID) }, inverseJoinColumns = {
    @JoinColumn(name = CompanySessionContract.COL_ID) })
  private List<CompanySession> companySession;

  @JsonProperty(value = CandidateContract.COL_FK_ID_ADDRESS)
  @ManyToOne(targetEntity = Address.class, optional = true)
  @JoinColumn(name = CandidateContract.COL_FK_ID_ADDRESS, referencedColumnName = AddressContract.COL_ID)
  protected Address address;

  /**
   * Empty constructor.
   */
  public Candidate() {
    super();
    this.degrees = new ArrayList<>();
    this.matters = new ArrayList<>();
    this.companySession = new ArrayList<>();
  }

  /**
   * Constructor with id for new Feedback.
   *
   * @param firstname   = the firstname
   * @param lastname    = the lastname
   * @param email       = the email
   * @param cellPhone   = the cellPhone
   */
  public Candidate(String firstname, String lastname, String email, String cellPhone) {
    super(firstname, lastname, email, cellPhone);
    this.degrees = new ArrayList<>();
    this.matters = new ArrayList<>();
    this.companySession = new ArrayList<>();
  }

  /**
   * @param ranking
   * @param feedback
   * @param degrees
   * @param matters
   * @param companySession
   */
  public Candidate(String firstname, String lastname, String email, String cellPhone, String homePhone, String commentary, Boolean mainContact, Address address, RankingCandidate ranking, Feedback feedback, List<Degree> degrees,
      List<Matter> matters, List<CompanySession> companySession) {
    super(firstname, lastname, email, cellPhone, homePhone, commentary, mainContact);
    this.ranking = ranking;
    this.feedback = feedback;
    this.degrees = degrees;
    this.matters = matters;
    this.companySession = companySession;
    this.address = address;
  }

  // GETTER/SETTER

  /**
   * @return the ranking
   */
  public RankingCandidate getRanking() {
    return this.ranking;
  }

  /**
   * @return the ranking label
   */
  @JsonIgnore
  public String getRankingLabel() {
    return this.ranking.toValue();
  }

  /**
   * @param ranking the ranking to set
   */
  public void setRanking(RankingCandidate ranking) {
    this.ranking = ranking;
  }

  /**
   * @return the feedback
   */
  public Feedback getFeedback() {
    return this.feedback;
  }

  /**
   * @param feedback the feedback to set
   */
  public void setFeedback(Feedback feedback) {
    this.feedback = feedback;
  }

  public void addDegree(final Degree degree) {
    if (!this.degrees.contains(degree)) {
      this.degrees.add(degree);
    }
  }

  /**
   * @return the degrees
   */
  public List<Degree> getDegrees() {
    return this.degrees;
  }

  /**
   * @param degrees the degrees to set
   */
  public void setDegrees(List<Degree> degrees) {
    this.degrees = degrees;
  }

  /**
   * Two way setter, adds {@link Matter} to {@link Candidate#matters matter list}
   * and {@link Candidate} to {@link Matter#getCandidates() candidates list}.
   *
   * @param matter to add
   */
  public void addMatter(Matter matter) {
    if (!this.matters.contains(matter)) {
      this.matters.add(matter);
    }
  }

  /**
   * @return the matters
   */
  public List<Matter> getMatters() {
    return this.matters;
  }

  /**
   * @param matters the matters to set
   */
  public void setMatters(List<Matter> matters) {
    this.matters = matters;
  }

  public void addCompanySession(final CompanySession companySession) {
    if (!this.companySession.contains(companySession)) {
      this.companySession.add(companySession);
    }
  }

  /**
   * @return the sessions
   */
  public List<CompanySession> getSessions() {
    return this.companySession;
  }

  /**
   * @param companySession the sessions to set
   */
  public void setSessions(List<CompanySession> companySession) {
    this.companySession = companySession;
  }
  /**
   * @return the address
   */
  public Address getAddress() {
    return this.address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(Address address) {
    this.address = address;
  }
}
