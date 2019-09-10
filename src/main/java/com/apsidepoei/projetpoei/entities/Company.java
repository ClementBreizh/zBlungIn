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
import lombok.ToString;
import lombok.ToString;

/**
 * This class is the business entity.
 *
 * @author benjamin-m
 *
 */
@Entity
@ToString
@Table(name = CompanyContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = CompanyContract.COL_ID))
public class Company extends EntityDb {

  @JsonProperty(value = CompanyContract.COL_NAME)
  @Column(name = CompanyContract.COL_NAME, nullable = false, length = 120)
  private String name;

  @JsonProperty(value = CompanyContract.COL_ANTENNANAME)
  @Column(name = CompanyContract.COL_ANTENNANAME, nullable = true, length = 50)
  private String antennaName;

  @JsonProperty(value = CompanyContract.COL_SIRET)
  @Column(name = CompanyContract.COL_SIRET, nullable = true, length = 14)
  private String siret;

  @JsonProperty(value = CompanyContract.COL_APECODE)
  @Column(name = CompanyContract.COL_APECODE, nullable = true, length = 5)
  private String apeCode;

  @JsonProperty(value = CompanyContract.COL_FK_ID_CONTACTS)
  @OneToMany(targetEntity = Person.class)
  private List<Person> contacts = new ArrayList<>();

  @JsonProperty(value = CompanyContract.COL_FK_ID_MAINCONTACT)
  @ManyToOne(targetEntity = Person.class, optional = true)
  @JoinColumn(name = CompanyContract.COL_FK_ID_MAINCONTACT, referencedColumnName = PersonContract.COL_ID)
  private Person mainContact;

  @JsonProperty(value = CompanyContract.COL_FK_ID_ADDRESS)
  @ManyToOne(targetEntity = Address.class, optional = true)
  @JoinColumn(name = CompanyContract.COL_FK_ID_ADDRESS, referencedColumnName = AddressContract.COL_ID)
  private Address address;

  @JsonProperty(value = CompanyContract.COL_SESSIONS)
  @ManyToMany(targetEntity = Session.class)
  @JoinTable(name = "company_session", joinColumns = {
      @JoinColumn(name = CompanyContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = SessionContract.COL_ID) })
  private List<Session> sessions = new ArrayList<>();


  /**
   * Empty constructor.
   */
  public Company() {
    super();
  }

  /**
   * Constructor for a new business.
   *
   * @param name        = the name
   */
  public Company(String name) {
    super();
    this.name = name;
  }

  /**
   * @param name
   * @param antennaName
   * @param siret
   * @param apeCode
   * @param mainContact
   * @param address
   */
  public Company(String name, String antennaName, String siret, String apeCode, Person mainContact,
      Address address) {
    super();
    this.name = name;
    this.antennaName = antennaName;
    this.siret = siret;
    this.apeCode = apeCode;
    this.mainContact = mainContact;
    this.address = address;
  }


  /**
   * @param name
   * @param antennaName
   * @param siret
   * @param apeCode
   * @param contacts
   * @param mainContact
   * @param address
   * @param sessions
   */
  public Company(String name, String antennaName, String siret, String apeCode,
      List<Person> contacts, Person mainContact, Address address, List<Session> sessions) {
    super();
    this.name = name;
    this.antennaName = antennaName;
    this.siret = siret;
    this.apeCode = apeCode;
    this.contacts = contacts;
    this.mainContact = mainContact;
    this.address = address;
    this.sessions = sessions;
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
