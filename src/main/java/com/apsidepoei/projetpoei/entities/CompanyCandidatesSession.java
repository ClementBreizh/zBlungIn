package com.apsidepoei.projetpoei.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.CompanyCandidatesSessionContract;
import com.apsidepoei.projetpoei.database.contracts.CompanyContract;
import com.apsidepoei.projetpoei.database.contracts.SessionContract;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is the CompanyCandidateSession entity.
 * @author thomas
 *
 */
@Entity
@Table(name = CompanyCandidatesSessionContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = CompanyCandidatesSessionContract.COL_ID))
public class CompanyCandidatesSession extends EntityDb {

  @JsonProperty(value = CompanyCandidatesSessionContract.COL_COMPANY)
  @OneToOne(targetEntity=Company.class,optional=false)
  @JoinColumn(name = CompanyContract.COL_ID)
  private Company company;

  @JsonProperty(value = CompanyCandidatesSessionContract.COL_CANDIDATES)
  @OneToMany(targetEntity = Candidate.class)
  private List<Candidate> candidates;

  @JsonProperty(value = CompanyCandidatesSessionContract.COL_SESSION)
  @OneToOne(targetEntity=Session.class,optional=false)
  @JoinColumn(name = SessionContract.COL_ID)
  private Session session;


  /**
   * Empty constructor.
   */
  public CompanyCandidatesSession() {
    super();
    this.candidates = new ArrayList<Candidate>();
  }

  /**
   * @param company
   * @param session
   */
  public CompanyCandidatesSession(Company company, Session session) {
    super();
    this.company = company;
    this.session = session;
    this.candidates = new ArrayList<Candidate>();
  }

  /**
   * @param company
   * @param candidates
   * @param session
   */
  public CompanyCandidatesSession(Company company, List<Candidate> candidates, Session session) {
    super();
    this.company = company;
    this.candidates = candidates;
    this.session = session;
  }


  /**
   * Override toString() function.
   */
  @Override
  public String toString() {
    return "Association Company/Candidates/Session [Id = " + getId() + ", company = " + company + ", candidates = " + candidates + ", session = " + session
        + "]";
  }

  // GETTER/SETTER

  /**
   * Getter for the company.
   * @return the company
   */
  public Company getCompany() {
    return company;
  }

  /**
   * Setter for the company.
   * @param company = object company
   */
  public void setCompany(Company company) {
    this.company = company;
  }

  /**
   * Getter for the candidates.
   * @return a list of candidates.
   */
  public List<Candidate> getCandidates() {
    return candidates;
  }

  /**
   * Setter for the candidates
   * @param candidates = list of candidates
   */
  public void setCandidates(List<Candidate> candidates) {
    this.candidates = candidates;
  }

  /**
   * Getter for the session
   * @return the session.
   */
  public Session getSession() {
    return session;
  }

  /**
   * Setter for the session object.
   * @param session = the object session.
   */
  public void setSession(Session session) {
    this.session = session;
  }
}
