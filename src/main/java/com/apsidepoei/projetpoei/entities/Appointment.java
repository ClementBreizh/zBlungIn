package com.apsidepoei.projetpoei.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.apsidepoei.projetpoei.database.contracts.AppointmentContract;
import com.apsidepoei.projetpoei.database.contracts.PersonContract;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is the Appointment entity.
 *
 * @author thomas
 *
 */
@Entity
@Table(name = AppointmentContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = AppointmentContract.COL_ID))
public class Appointment extends EntityDb {

  @JsonProperty(value = AppointmentContract.COL_INFORMATIONS)
  @Column(name = AppointmentContract.COL_INFORMATIONS, nullable = true)
  private String informations;

  @JsonProperty(value = AppointmentContract.COL_DATETIME)
  @Column(name = AppointmentContract.COL_DATETIME, nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private Date appointmentDate;

  @JsonProperty(value = AppointmentContract.COL_REPORT)
  @Column(name = AppointmentContract.COL_REPORT, nullable = true)
  private String report;

  @JsonProperty(value = AppointmentContract.COL_STATUS)
  @Column(name = AppointmentContract.COL_STATUS)
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean status = false;

  @JsonProperty(value = AppointmentContract.COL_PERSONS)
  @ManyToMany(targetEntity = Person.class)
  @JoinTable(name = "appointment_persons", joinColumns = {
      @JoinColumn(name = AppointmentContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = PersonContract.COL_ID) })
  private List<Person> persons;

  /**
   * Constructor for a new Appointment.
   *
   * @param informations = informations
   * @param dateTime     = date and time
   * @param report       = the report
   */
  public Appointment(String informations, Date dateTime, String report) {
    super();
    this.informations = informations;
    this.appointmentDate = appointmentDate;
    this.report = report;
    this.persons = new ArrayList<Person>();
  }

  /**
   * Constructor for a new Appointment.
   *
   * @param informations = informations
   * @param dateTime     = date and time
   * @param report       = the report
   */
  public Appointment(Date dateTime, List<Person> persons) {
    super();
    this.appointmentDate = appointmentDate;
    this.persons = persons;
  }

  /**
   * Empty constructor.
   */
  public Appointment() {
    super();
    this.persons = new ArrayList<Person>();
  }

  // GETTER/SETTER

  /**
   * The informations.
   *
   * @return the informations.
   */
  public String getInformations() {
    return informations;
  }

  /**
   * Set the informations.
   *
   * @param informations = the informations
   */
  public void setInformations(String informations) {
    this.informations = informations;
  }

  /**
   * Return the dateTime.
   *
   * @return the dateTime.
   */
  public Date getAppointmentDate() {
    return appointmentDate;
  }

  /**
   * Set the dateTime.
   *
   * @param dateTime = the date and time
   */
  public void setAppointmentDate(Date appointmentDate) {
    this.appointmentDate = appointmentDate;
  }

  /**
   * The report.
   *
   * @return the report.
   */
  public String getReport() {
    return report;
  }

  /**
   * Set the report.
   *
   * @param report = the report
   */
  public void setReport(String report) {
    this.report = report;
  }

  /**
   * Return the status for this appointment.
   * @return a boolean for the status.
   */
  public Boolean getStatus() {
    return status;
  }
/**
 * Set the status for this appointment
 * @param status is the status for the appointment.
 */
  public void setStatus(Boolean status) {
    this.status = status;
  }
/**
 * Getter fot the persons list in this appointment.
 * @return a list of persons.
 */
  public List<Person> getPersons() {
    return persons;
  }

  /**
   * Setter for the persons list.
   * @param persons is a list of persons, concerned in this appointment.
   */
  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }

  /**
   * Constructor for a new Appointment.
   *
   * @param informations = informations
   * @param dateTime     = date and time
   * @param report       = the report
   * @param status       = status for the appointment
   * @param persons      = list of persons, concerned in this appointment
   */
  public Appointment(String informations, Date appointmentDate, String report, Boolean status, List<Person> persons) {
    super();
    this.informations = informations;
    this.appointmentDate = appointmentDate;
    this.report = report;
    this.status = status;
    this.persons = persons;
  }

  /**
   * Constructor for a new Appointment.
   *
   * @param informations = informations
   * @param dateTime     = date and time
   * @param report       = the report
   * @param status       = status for the appointment
   * @param persons      = list of persons, concerned in this appointment
   */
  public Appointment(int id, String informations, Date appointmentDate, String report, Boolean status, List<Person> persons) {
    super();
    this.setId(id);
    this.informations = informations;
    this.appointmentDate = appointmentDate;
    this.report = report;
    this.status = status;
    this.persons = persons;

  }

  /**
   * Override toString() function.
   */
  @Override
  public String toString() {
    return "Rendez-vous [Id = " + getId() + ", informations=" + informations + ", date=" + appointmentDate
        + ", report=" + report + ", status=" + status + "]";
  }
}
