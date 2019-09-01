/**
 *
 */
package com.apsidepoei.projetpoei.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.apsidepoei.projetpoei.database.contracts.AddressContract;
import com.apsidepoei.projetpoei.database.contracts.PersonContract;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author vianney
 *
 */
@Entity
@Table(name = PersonContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = PersonContract.COL_ID))
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends EntityDb {

  @JsonProperty(value = PersonContract.COL_FIRSTNAME)
  @Column(name = PersonContract.COL_FIRSTNAME, nullable = false, length = 50)
  protected String firstname;

  @JsonProperty(value = PersonContract.COL_LASTNAME)
  @Column(name = PersonContract.COL_LASTNAME, nullable = false, length = 50)
  protected String lastname;

  @JsonProperty(value = PersonContract.COL_EMAIL)
  @Column(name = PersonContract.COL_EMAIL, nullable = true)
  protected String email;

  @JsonProperty(value = PersonContract.COL_CELL_PHONE)
  @Column(name = PersonContract.COL_CELL_PHONE, nullable = true, length = 12)
  protected String cellPhone;

  @JsonProperty(value = PersonContract.COL_HOME_PHONE)
  @Column(name = PersonContract.COL_HOME_PHONE, nullable = true, length = 12)
  protected String homePhone;

  @JsonProperty(value = PersonContract.COL_COMMENTARY)
  @Column(name = PersonContract.COL_COMMENTARY, nullable = true)
  protected String commentary;

  @JsonProperty(value = PersonContract.COL_MAINCONTACT)
  @Column(name = PersonContract.COL_MAINCONTACT, nullable = true)
  @Type(type = "org.hibernate.type.NumericBooleanType")
  protected Boolean mainContact = false;

  @JsonProperty(value = PersonContract.COL_FK_ID_ADDRESS)
  @ManyToOne(targetEntity = Address.class, optional = true)
  @JoinColumn(name = PersonContract.COL_FK_ID_ADDRESS, referencedColumnName = AddressContract.COL_ID)
  protected Address address;


  /**
   * Empty constructor.
   */
  public Person() {
    super();
  }

  /**
   * Constructor with id for new Feedback.
   *
   * @param firstname = the firstname
   * @param lastname  = the lastname
   */
  public Person(String firstname, String lastname) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
  }

  /**
   * @param firstname
   * @param lastname
   * @param email
   * @param cellPhone
   * @param homePhone
   * @param commentary
   * @param mainContact
   * @param address
   */
  public Person(String firstname, String lastname, String email, String cellPhone, String homePhone,
      String commentary, Boolean mainContact, Address address) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.cellPhone = cellPhone;
    this.homePhone = homePhone;
    this.commentary = commentary;
    this.mainContact = mainContact;
    this.address = address;
  }


  /**
   * Override toString() function.
   */
  @Override
  public String toString() {
    return "Person [" + "Id = " + getId() + ", prénom = " + firstname + ", nom = " + lastname

        + ", email = " + email + ", téléphone = " + cellPhone + ", adresse = ]";

  }


  // GETTER/SETTER

  /**
   * @return the firstname
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * @param firstname the firstname to set
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * @return the lastname
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * @param lastname the lastname to set
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the cellPhone
   */
  public String getCellPhone() {
    return cellPhone;
  }

  /**
   * @param cellPhone the cellPhone to set
   */
  public void setCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
  }

  /**
   * @return the homePhone
   */
  public String getHomePhone() {
    return homePhone;
  }

  /**
   * @param homePhone the homePhone to set
   */
  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  /**
   * @return the commentary
   */
  public String getCommentary() {
    return commentary;
  }

  /**
   * @param commentary the commentary to set
   */
  public void setCommentary(String commentary) {
    this.commentary = commentary;
  }

  /**
   * @return the address
   */
  public Address getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * @return the mainContact
   */
  public Boolean getMainContact() {
    return mainContact;
  }

  /**
   * @param mainContact the mainContact to set
   */
  public void setMainContact(Boolean mainContact) {
    this.mainContact = mainContact;
  }

}
