package com.apsidepoei.projetpoei.entities;

import com.apsidepoei.projetpoei.database.contracts.AcquiredMattersContract;
import com.apsidepoei.projetpoei.database.contracts.AddressContract;
import com.apsidepoei.projetpoei.database.contracts.CandidateContract;
import com.apsidepoei.projetpoei.database.contracts.CompanySessionContract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.NonNull;
import lombok.ToString;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Candidate entity.
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

  @JsonIgnoreProperties({"candidate"})
  @OneToMany(mappedBy = "candidate")
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
  @JoinColumn(name = CandidateContract.COL_FK_ID_ADDRESS,
      referencedColumnName = AddressContract.COL_ID)
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
   * Candidate contrucotor with all params.
   * @param ranking Ranking.
   * @param status Status.
   * @param sex Tell if it's a man or women.
   * @param feedback A feedback.
   * @param degrees A list of degrees.
   * @param matters A list of matters
   * @param companySession An association with a session and a company.
   */
  public Candidate(String firstname, String lastname, String email, String cellPhone,
                   String homePhone, String commentary, Boolean mainContact, Address address,
                   RankingCandidate ranking, StatusCandidate status, SexCandidate sex,
                   Feedback feedback, List<Degree> degrees,
                   List<AcquiredMatters> matters, @NonNull List<CompanySession> companySession,
                   List<Assessment> assessments) {
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
   * Return the rankin.
   * @return the ranking.
   */
  public RankingCandidate getRanking() {
    return this.ranking;
  }

  /**
   * Return the ranking label.
   * @return the ranking label
   */
//  @JsonIgnore
//  public String getRankingLabel() {
//    return this.ranking.toValue();
//  }

  /**
   * Set the rankin.
   * @param ranking the ranking to set
   */
  public void setRanking(RankingCandidate ranking) {
    this.ranking = ranking;
  }

  /**
   * Return the feedback.
   * @return the feedback
   */
  public Feedback getFeedback() {
    return this.feedback;
  }

  /**
   * Set the feedback.
   * @param feedback the feedback to set
   */
  public void setFeedback(Feedback feedback) {
    this.feedback = feedback;
  }

  /**
   * Add a degree.
   * @param degree is the degree to add.
   * @return return a candidate.
   */
  public Candidate addDegree(final Degree degree) {
    if (!this.degrees.contains(degree)) {
      this.degrees.add(degree);
    }
    return this;
  }

  /**
   * Return a candidate with a list list of degrees updated.
   * @param degree is the degree to remove.
   * @return the candidate with the upated degrees list.
   */
  public Candidate removeDegree(@NonNull  final Degree degree) {
    this.degrees.remove((degree));
    return this;
  }

  /**
   * Return a list of degres.
   * @return the degrees.
   */
  public List<Degree> getDegrees() {
    return this.degrees;
  }

  /**
   * Set the degrees.
   * @param degrees the degrees to set.
   */
  public void setDegrees(List<Degree> degrees) {
    this.degrees = degrees;
  }

  /**
   * Add the matter.
   * @param matter to add
   */
  public void addMatter(@NonNull AcquiredMatters matter) {
    if (!this.matters.contains(matter)) {
      this.matters.add(matter);
      matter.setCandidate(this);
    }
  }

  /**
   * Return a list of matters.
   * @return the matters.
   */
  public List<AcquiredMatters> getMatters() {
    return this.matters;
  }

  /**
   * Set a matter to the matters list.
   * @param matters the matters to set
   */
  public void setMatters(List<AcquiredMatters> matters) {
    this.matters = matters;
  }

  /**
   * Add a company + session associations.
   * @param companySession is an association of a company and a session.
   */
  public void addCompanySession(final CompanySession companySession) {
    if (!this.companySession.contains(companySession)) {
      this.companySession.add(companySession);
    }
  }

  /**
   * Return an address.
   * @return the address.
   */
  public Address getAddress() {
    return this.address;
  }

  /**
   * Set an address.
   * @param address the address to set.
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * Return a status.
   * @return the status.
   */
  public StatusCandidate getStatus() {
    return status;
  }

  /**
   * Set a status.
   * @param status the status to set.
   */
  public void setStatus(StatusCandidate status) {
    this.status = status;
  }

  /**
   * Return the sex of the candidate.
   * @return the sex.
   */
  public SexCandidate getSex() {
    return sex;
  }

  /**
   * Set the sex.
   * @param sex the sex to set.
   */
  public void setSex(SexCandidate sex) {
    this.sex = sex;
  }

  /**
   * Setter for the associations.
   * @param companySession the sessions to set.
   */
  public void setCompanySession(List<CompanySession> companySession) {
    this.companySession = companySession;
  }

  /**
   * Return the sessions.
   * @return the sessions.
   */
  public List<CompanySession> getCompanySession() {
    return companySession;
  }

  /** Return a list of assessments.
   * @return the assessments.
   */
  public List<Assessment> getAssessments() {
    return assessments;
  }

  /**
   * Set the assessments list.
   * @param assessments the assessments to set.
   */
  public void setAssessments(List<Assessment> assessments) {
    this.assessments = assessments;
  }

  /**
   * Add an assessment to the candidate.
   * @param assessment is an assessment to add.
   * @return is the candidate updated.
   */
  public Candidate addAssessment(final Assessment assessment) {
    if (!this.assessments.contains(assessment)) {
      this.assessments.add(assessment);
    }
    return this;
  }
}
