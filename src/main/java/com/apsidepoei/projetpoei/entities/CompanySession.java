package com.apsidepoei.projetpoei.entities;

import com.apsidepoei.projetpoei.database.contracts.CompanyContract;
import com.apsidepoei.projetpoei.database.contracts.CompanySessionContract;
import com.apsidepoei.projetpoei.database.contracts.SessionContract;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.ToString;

import org.hibernate.annotations.Type;

/**
 * This class is the CompanyCandidateValidatedSession entity.
 * @author thomas
 *
 */
@Entity
@ToString
@Table(name = CompanySessionContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = CompanySessionContract.COL_ID))
public class CompanySession extends EntityDb {

  @ManyToOne(targetEntity = Company.class, optional = false)
  @JoinColumn(name = CompanyContract.COL_ID)
  private Company company;

  @ManyToOne(targetEntity = Session.class, optional = false)
  @JoinColumn(name = SessionContract.COL_ID)
  private Session session;

  @Column(name = CompanySessionContract.COL_VALIDATED, nullable = false)
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean validated = false;

  /**
   * Empty constructor.
   */
  public CompanySession() {
    super();
  }

  /**
   * Constructor.
   * @param company is an object company.
   * @param session is an object session.
   */
  public CompanySession(Company company, Session session) {
    super();
    this.company = company;
    this.session = session;
  }

  /**
   * Constructor.
   * @param company is an object company.
   * @param session is an object session.
   * @param validated is a boolean.
   */
  public CompanySession(Company company, Session session, Boolean validated) {
    super();
    this.company = company;
    this.session = session;
    this.validated = validated;
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
   * @param company = object company
   */
  public void setCompany(Company company) {
    this.company = company;
  }

  /**
   * Getter for the session.
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

  /**
   * Return the boolean.
   * @return the validated
   */
  public Boolean getValidated() {
    return validated;
  }

  /**
   * Set the boolean.
   * @param validated the validated to set
   */
  public void setValidated(Boolean validated) {
    this.validated = validated;
  }

}
