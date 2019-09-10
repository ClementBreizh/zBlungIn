package com.apsidepoei.projetpoei.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.apsidepoei.projetpoei.database.contracts.CompanyValidatedCandidatesSessionContract;
import com.apsidepoei.projetpoei.database.contracts.CompanyContract;
import com.apsidepoei.projetpoei.database.contracts.SessionContract;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;
import lombok.ToString;

/**
 * This class is the CompanyCandidateValidatedSession entity.
 * @author thomas
 *
 */
@Entity
@ToString
@Table(name = CompanyValidatedCandidatesSessionContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = CompanyValidatedCandidatesSessionContract.COL_ID))
public class CompanyValidatedCandidatesSession extends EntityDb {
  @JsonProperty(value = CompanyValidatedCandidatesSessionContract.COL_COMPANY)
  @ManyToOne(targetEntity = Company.class, optional = false)
  @JoinColumn(name = CompanyContract.COL_ID)
  private Company company;

  @JsonProperty(value = CompanyValidatedCandidatesSessionContract.COL_VALIDATED_CANDIDATES)
  @ManyToMany(targetEntity = Candidate.class)
  private List<Candidate> validatedCandidates;

  @JsonProperty(value = CompanyValidatedCandidatesSessionContract.COL_SESSION)
  @OneToOne(targetEntity = Session.class, optional = false)
  @JoinColumn(name = SessionContract.COL_ID)
  private Session session;


  /**
   * Empty constructor.
   */
  public CompanyValidatedCandidatesSession() {
    super();
    this.validatedCandidates = new ArrayList<Candidate>();
  }

  /**
   * @param company
   * @param session
   */
  public CompanyValidatedCandidatesSession(Company company, Session session) {
    super();
    this.company = company;
    this.session = session;
    this.validatedCandidates = new ArrayList<Candidate>();
  }

  /**
   * @param company
   * @param validatedCandidates
   * @param session
   */
  public CompanyValidatedCandidatesSession(Company company, List<Candidate> validatedCandidates,
      Session session) {
    super();
    this.company = company;
    this.validatedCandidates = validatedCandidates;
    this.session = session;
  }


  /**
   * Override toString() function.
   */
//  @Override
//  public String toString() {
//    return "Association Company/Candidates/Session [Id = " + getId() + ", company = " + getCompany().getName()
//        + ", session = " + getSession().getName() + "]";
//  }

  @Override
  public String toString() {
    return "Association Company/Candidates/Session [Id = ]";
  }

  // GETTER/SETTER

  /**
   * Getter for the company.
   *
   * @return the company
   */
  public Company getCompany() {
    return company;
  }

  /**
   * Setter for the company.
   *
   * @param optional = object company
   */
  public void setCompany(Company company) {
    this.company = company;
  }

  /**
   * Getter for the validated candidates.
   *
   * @return a list of candidates.
   */
  public List<Candidate> getValidatedCandidates() {
    return validatedCandidates;
  }

  /**
   * Setter for the validated candidates
   *
   * @param candidates = list of candidates
   */
  public void setValidatedCandidates(List<Candidate> candidates) {
    this.validatedCandidates = candidates;
  }

  /**
   * Getter for the session
   *
   * @return the session.
   */
  public Session getSession() {
    return session;
  }

  /**
   * Setter for the session object.
   *
   * @param session = the object session.
   */
  public void setSession(Session session) {
    this.session = session;
  }
}
