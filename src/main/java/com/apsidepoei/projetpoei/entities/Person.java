/**
 *
 */
package com.apsidepoei.projetpoei.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.apsidepoei.projetpoei.database.contracts.PersonContract;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

/**
 * @author vianney
 *
 */
@Entity
@ToString(exclude = {"appointments"})
@Table(name = PersonContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = PersonContract.COL_ID))
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends EntityDb {


  private String type;

  @JsonProperty(value = PersonContract.COL_FIRSTNAME)

  @Column(name = PersonContract.COL_FIRSTNAME, nullable = false, length = 50)
  private String firstname;

  @Column(name = PersonContract.COL_LASTNAME, nullable = false, length = 50)
  private String lastname;

  @Column(name = PersonContract.COL_EMAIL, nullable = false)
  private String email;

  @Column(name = PersonContract.COL_CELL_PHONE, nullable = false, length = 12)
  private String cellPhone;

  @Column(name = PersonContract.COL_HOME_PHONE, nullable = true, length = 12)
  private String homePhone;

  @Column(name = PersonContract.COL_COMMENTARY, nullable = true)
  private String commentary;

  @Column(name = PersonContract.COL_MAINCONTACT, nullable = true)
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean mainContact = false;

  @ManyToMany(mappedBy = "persons")
  @JsonIgnoreProperties({"persons"})
  private List<Appointment> appointments = new ArrayList<>();

  /**
   * Empty constructor.
   */
  public Person() {
    super();
  }

  @PrePersist
  public void prePersist() {
    this.type = this.getClass().getSimpleName();
  }

  /**
   * Constructor with id for new Feedback.
   *
   * @param firstname = the firstname
   * @param lastname  = the lastname
   * @param email     = the email
   * @param cellPhone = the cellPhone
   */
  public Person(String firstname, String lastname, String email, String cellPhone) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.cellPhone = cellPhone;
  }

  /**
   * @param firstname
   * @param lastname
   * @param email
   * @param cellPhone
   * @param homePhone
   * @param commentary
   * @param mainContact
   */
  public Person(String firstname, String lastname, String email, String cellPhone, String homePhone,
      String commentary, Boolean mainContact) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.cellPhone = cellPhone;
    this.homePhone = homePhone;
    this.commentary = commentary;
    this.mainContact = mainContact;
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

  /**
   * @return the appointments
   */
  public List<Appointment> getAppointments() {
    return appointments;
  }

  /**
   * @param appointments the appointments to set
   */
  public void setAppointments(List<Appointment> appointments) {
    this.appointments = appointments;
  }

  public Person addAppointment(final Appointment appointment) {
    if (!this.appointments.contains(appointment)) {
      this.appointments.add(appointment);
    }
    return this;
  }

}
