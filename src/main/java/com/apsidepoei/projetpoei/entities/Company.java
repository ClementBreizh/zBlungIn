package com.apsidepoei.projetpoei.entities;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.CompanyContract;
import com.apsidepoei.projetpoei.database.contracts.PersonContract;
import com.apsidepoei.projetpoei.database.contracts.SessionContract;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is the business entity.
 *
 * @author benjamin-m
 *
 */
@Entity
@Table(name = CompanyContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = CompanyContract.COL_ID))
public class Company extends EntityDb {

  @JsonProperty(value = CompanyContract.COL_NAME)
  @Column(name = CompanyContract.COL_NAME, nullable = false)
  private String name;

  @JsonProperty(value = CompanyContract.COL_ANTENNANAME)
  @Column(name = CompanyContract.COL_ANTENNANAME, nullable = false)
  private String antennaName;

  @JsonProperty(value = CompanyContract.COL_SIRET)
  @Column(name = CompanyContract.COL_SIRET, nullable = true)
  private String siret;
  @JsonProperty(value = CompanyContract.COL_APECODE)
  @Column(name = CompanyContract.COL_APECODE, nullable = true)
  private String apeCode;

  @JsonProperty(value = CompanyContract.COL_FK_ID_CONTACTS)
  @OneToMany(targetEntity=Person.class)
  private List<Person> contacts;

  @JsonProperty(value = CompanyContract.COL_FK_ID_MAINCONTACT)
  @ManyToOne(targetEntity=Person.class,optional=true)
  @JoinColumn(name=CompanyContract.COL_FK_ID_MAINCONTACT, referencedColumnName=PersonContract.COL_ID)
  private Person mainContact;

  @JsonProperty(value = CompanyContract.COL_FK_ID_ADRESSES)
  @OneToMany(targetEntity=Address.class)
  private List<Person> addresses;

  @JsonProperty(value = CompanyContract.COL_SESSIONS)
  @ManyToMany(targetEntity = Session.class)
  @JoinTable(name = "company_session", joinColumns = {
      @JoinColumn(name = CompanyContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = SessionContract.COL_ID) })
  private List<Session> sessions;

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name.
   *
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the antennaName
   */
  public String getAntennaName() {
    return antennaName;
  }

  /**
   * @param antennaName the antennaName to set
   */
  public void setAntennaName(String antennaName) {
    this.antennaName = antennaName;
  }

  /**
   * @return the siret
   */
  public String getSiret() {
    return siret;
  }

  /**
   * @param siret the siret to set
   */
  public void setSiret(String siret) {
    this.siret = siret;
  }

  /**
   * @return the apeCode
   */
  public String getApeCode() {
    return apeCode;
  }

  /**
   * Set The APE code.
   *
   * @param apeCode the apeCode to set
   */
  public void setApeCode(String apeCode) {
    this.apeCode = apeCode;
  }

  /**
   * Constructor for a new business.
   *
   * @param name        = the name
   * @param antennaName = the name of antenna
   * @param siret      = the siret
   * @param apeCode    = the APE code
   */
  public Company(String name, String antennaName, String siret, String apeCode) {
    super();
    this.name = name;
    this.antennaName = antennaName;
    this.siret = siret;
    this.apeCode = apeCode;
  }

  /**
   * Constructor with id for a new business.
   *
   * @param id         = the id
   * @param name        = the name
   * @param antennaName = the name of antenna
   * @param siret      = the siret
   * @param apeCode    = the APE code
   */
  public Company(int id, String name, String antennaName, String siret, String apeCode) {
    super();
    this.setId(id);
    this.name = name;
    this.antennaName = antennaName;
    this.siret = siret;
    this.apeCode = apeCode;
  }

  /**
   * Empty constructor.
   */
  public Company() {

  }

  /**
   * override toString() function.
   */
  @Override
  public String toString() {
    return "Entreprise [Id = " + getId() + ", name = " + name + ", antennaName = " + antennaName + ", siret = " + siret
        + ", apeCode = " + apeCode + "]";
  }

}
