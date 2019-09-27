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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.apsidepoei.projetpoei.database.contracts.AcquiredMattersContract;
import com.apsidepoei.projetpoei.database.contracts.AddressContract;
import com.apsidepoei.projetpoei.database.contracts.CandidateContract;
import com.apsidepoei.projetpoei.database.contracts.CompanySessionContract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NonNull;
import lombok.ToString;

/**
 * @author vianney
 *
 */
@Entity
@ToString(of = {"ranking", "sex", "status"}, callSuper = true)
@Table(name = CandidateContract.TABLE)
public class Candidate extends Person {

  @Column(name = CandidateContract.COL_RANKING_CANDIDATE)
  private RankingCandidate ranking = RankingCandidate.RANK_0;

  @Column(name = CandidateContract.COL_STATUS_CANDIDATE)
  private StatusCandidate status = StatusCandidate.STATUS_0;

  @Column(name = CandidateContract.COL_SEX_CANDIDATE)
  private SexCandidate sex = SexCandidate.SEX_0;

  @ManyToOne()
  @JoinTable(name = CandidateContract.COL_FK_ID_FEEDBACK)
  private Feedback feedback;

  @ManyToMany(fetch = FetchType.EAGER,
  cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Degree> degrees = new ArrayList<>();

  @JsonIgnore
  @ManyToMany(targetEntity = AcquiredMatters.class)
  @JoinTable(name = "candidate_matter", joinColumns = {
      @JoinColumn(name = CandidateContract.COL_ID) }, inverseJoinColumns = {
      @JoinColumn(name = AcquiredMattersContract.COL_ID) })
  private List<AcquiredMatters> matters;

  @LazyCollection(LazyCollectionOption.FALSE)
  @ManyToMany(targetEntity = CompanySession.class,
  cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
  @JoinTable(joinColumns = {
    @JoinColumn(name = CandidateContract.COL_ID) }, inverseJoinColumns = {
    @JoinColumn(name = CompanySessionContract.COL_ID) })
  private List<CompanySession> companySession;

  @ManyToOne(targetEntity = Address.class, optional = true)
  @JoinColumn(name = CandidateContract.COL_FK_ID_ADDRESS, referencedColumnName = AddressContract.COL_ID)
  private Address address;

  @ManyToMany(
  cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
  @JsonIgnoreProperties({"assessments"})
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Assessment> assessments;

  /**
   * Empty constructor.
   */
  public Candidate() {
    super();
    this.degrees = new ArrayList<>();
    this.matters = new ArrayList<>();
    this.companySession = new ArrayList<>();
    this.assessments = new ArrayList<>();
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
    this.assessments = new ArrayList<>();
  }

  /**
   * @param ranking
   * @param status
   * @param sex
   * @param feedback
   * @param degrees
   * @param matters
   * @param companySession
   */
  public Candidate(String firstname, String lastname, String email, String cellPhone, String homePhone, String commentary, Boolean mainContact, Address address, RankingCandidate ranking, StatusCandidate status, SexCandidate sex, Feedback feedback, List<Degree> degrees,
      List<AcquiredMatters> matters, @NonNull List<CompanySession> companySession, List<Assessment> assessments) {
    super(firstname, lastname, email, cellPhone, homePhone, commentary, mainContact);
    this.ranking = ranking;
    this.status = status;
    this.sex = sex;
    this.feedback = feedback;
    this.degrees = degrees;
    this.matters = matters;
    this.companySession = companySession;
    this.address = address;
    this.assessments = assessments;

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

  public Candidate addDegree(final Degree degree) {
    if (!this.degrees.contains(degree)) {
      this.degrees.add(degree);
    }
    return this;
  }
  
  public Candidate removeDegree(@NonNull  final Degree degree) {
    this.degrees.remove((degree));
    return this;
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
  public void addMatter(AcquiredMatters matter) {
    if (!this.matters.contains(matter)) {
      this.matters.add(matter);
    }
  }

  /**
   * @return the matters
   */
  public List<AcquiredMatters> getMatters() {
    return this.matters;
  }

  /**
   * @param matters the matters to set
   */
  public void setMatters(List<AcquiredMatters> matters) {
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

  /**
   * @return the status
   */
  public StatusCandidate getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(StatusCandidate status) {
    this.status = status;
  }

  /**
   * @return the sex
   */
  public SexCandidate getSex() {
    return sex;
  }

  /**
   * @param sex the sex to set
   */
  public void setSex(SexCandidate sex) {
    this.sex = sex;
  }

  public void setCompanySession(List<CompanySession> companySession) {
    this.companySession = companySession;
  }

  public List<CompanySession> getCompanySession() {
    return companySession;
  }

  /**
   * @return the assessments
   */
  public List<Assessment> getAssessments() {
    return assessments;
  }

  /**
   * @param assessments the assessments to set
   */
  public void setAssessments(List<Assessment> assessments) {
    this.assessments = assessments;
  }

  public Candidate addAssessment(final Assessment assessment) {
    if (!this.assessments.contains(assessment)) {
      this.assessments.add(assessment);
    }
    return this;
  }
}
