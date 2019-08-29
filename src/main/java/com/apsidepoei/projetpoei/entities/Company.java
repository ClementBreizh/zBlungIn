package com.apsidepoei.projetpoei.entities;

import java.util.ArrayList;
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

import com.apsidepoei.projetpoei.database.contracts.AddressContract;
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
  @Column(name = CompanyContract.COL_NAME, nullable = false, length = 120)
  private String name;

  @JsonProperty(value = CompanyContract.COL_ANTENNANAME)
  @Column(name = CompanyContract.COL_ANTENNANAME, nullable = false, length = 50)
  private String antennaName;

  @JsonProperty(value = CompanyContract.COL_SIRET)
  @Column(name = CompanyContract.COL_SIRET, nullable = true, length = 14)
  private String siret;

  @JsonProperty(value = CompanyContract.COL_APECODE)
  @Column(name = CompanyContract.COL_APECODE, nullable = true, length = 5)
  private String apeCode;

  @JsonProperty(value = CompanyContract.COL_FK_ID_CONTACTS)
  @OneToMany(targetEntity = Person.class)
  private List<Person> contacts;

  @JsonProperty(value = CompanyContract.COL_FK_ID_MAINCONTACT)
  @ManyToOne(targetEntity = Person.class, optional = true)
  @JoinColumn(name = CompanyContract.COL_FK_ID_MAINCONTACT, referencedColumnName = PersonContract.COL_ID)
  private Person mainContact;

  @JsonProperty(value = CompanyContract.COL_FK_ID_ADRESS)
  @ManyToOne(targetEntity = Address.class, optional = true)
  @JoinColumn(name = CompanyContract.COL_FK_ID_ADRESS, referencedColumnName = AddressContract.COL_ID)
  private Address address;

  @JsonProperty(value = CompanyContract.COL_SESSIONS)
  @ManyToMany(targetEntity = Session.class)
  @JoinTable(name = "company_session", joinColumns = {
      @JoinColumn(name = CompanyContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = SessionContract.COL_ID) })
  private List<Session> sessions;

  /**
   * Constructor for a new business.
   *
   * @param name        = the name
   * @param antennaName = the name of antenna
   * @param siret       = the siret
   * @param apeCode     = the APE code
   */
  public Company(String name, String antennaName, String siret, String apeCode) {
    super();
    this.name = name;
    this.antennaName = antennaName;
    this.siret = siret;
    this.apeCode = apeCode;
    this.contacts = new ArrayList<Person>();
    this.sessions = new ArrayList<Session>();
  }

  /**
   * Constructor with id for a new business.
   *
   * @param id          = the id
   * @param name        = the name
   * @param antennaName = the name of antenna
   * @param siret       = the siret
   * @param apeCode     = the APE code
   */
  public Company(int id, String name, String antennaName, String siret, String apeCode,
      List<Person> contacts, Person mainContact, List<Session> sessions) {
    super();
    this.setId(id);
    this.name = name;
    this.antennaName = antennaName;
    this.siret = siret;
    this.apeCode = apeCode;
    this.contacts = contacts;
    this.mainContact = mainContact;
    this.sessions = sessions;
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
    return "Entreprise [Id = " + getId() + ", name = " + name + ", antennaName = " + antennaName
        + ", siret = " + siret + ", apeCode = " + apeCode + ", contacts = " + contacts
        + ", mainContact = " + mainContact + ", address = " + address + ", sessions = " + sessions
        + "]";
  }

  // GETTER/SETTER
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
   * Getter for the contact list.
   *
   * @return the list of person.
   */
  public List<Person> getContacts() {
    return contacts;
  }

  /**
   * Setter for the contact list.
   *
   * @param contacts = a list of person object.
   */
  public void setContacts(List<Person> contacts) {
    this.contacts = contacts;
  }

  /**
   * Getter for the main contact.
   *
   * @return the main contact.
   */
  public Person getMainContact() {
    return mainContact;
  }

  /**
   * Setter for the main contact.
   *
   * @param mainContact = the object person who is the main contact.
   */
  public void setMainContact(Person mainContact) {
    this.mainContact = mainContact;
  }

  /**
   * Getter for the address.
   *
   * @return the address.
   */
  public Address getAddress() {
    return address;
  }

  /**
   * Setter for the address .
   *
   * @param addresses = an address.
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * Getter for the sessions list.
   *
   * @return a session object list.
   */
  public List<Session> getSessions() {
    return sessions;
  }

  /**
   * Setter for the sessions list.
   *
   * @param sessions is the list of session object.
   */
  public void setSessions(List<Session> sessions) {
    this.sessions = sessions;
  }
}
