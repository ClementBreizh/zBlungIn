package com.apsidepoei.projetpoei.entities;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.apsidepoei.projetpoei.database.contracts.CompanySessionContract;
import com.apsidepoei.projetpoei.database.contracts.CompanyContract;
import com.apsidepoei.projetpoei.database.contracts.SessionContract;
import lombok.ToString;

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
   * @param company
   * @param session
   */
  public CompanySession(Company company, Session session) {
    super();
    this.company = company;
    this.session = session;
  }

  /**
   * @param company
   * @param session
   * @param validated
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
   * @param optional = object company
   */
  public void setCompany(Company company) {
    this.company = company;
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

  /**
   * @return the validated
   */
  public Boolean getValidated() {
    return validated;
  }

  /**
   * @param validated the validated to set
   */
  public void setValidated(Boolean validated) {
    this.validated = validated;
  }

}
