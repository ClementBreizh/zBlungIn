package com.apsidepoei.projetpoei.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.AddressContract;
import com.apsidepoei.projetpoei.database.contracts.CandidateContract;
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

  @JsonProperty(value = AppointmentContract.COL_APPOINTMENTDATE)
  @Column(name = AppointmentContract.COL_APPOINTMENTDATE, nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private LocalDateTime appointmentDate;

  @JsonProperty(value = AppointmentContract.COL_INFORMATIONS)
  @Column(name = AppointmentContract.COL_INFORMATIONS, nullable = true)
  private String informations;

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
  private List<Person> persons = new ArrayList<>();

  @JsonProperty(value = AppointmentContract.COL_ORGANIZER)
  @ManyToOne(targetEntity = Person.class, optional = true)
  @JoinColumn(name = AppointmentContract.COL_ORGANIZER, referencedColumnName = PersonContract.COL_ID)
  private Person organizer;

  /**
   * Empty constructor.
   */
  public Appointment() {
    super();
    this.persons = new ArrayList<Person>();
  }

  /**
   * @param informations
   * @param appointmentDate
   * @param report
   * @param status
   */
  public Appointment(String informations, LocalDateTime appointmentDate, String report,
      Boolean status) {
    super();
    this.informations = informations;
    this.appointmentDate = appointmentDate;
    this.report = report;
    this.status = status;
    this.persons = new ArrayList<Person>();
  }

  /**
   * @param informations
   * @param appointmentDate
   * @param report
   * @param status
   * @param persons
   * @param organizer
   */
  public Appointment(String informations, LocalDateTime appointmentDate, String report,
      Boolean status, List<Person> persons, Person organizer) {
    super();
    this.informations = informations;
    this.appointmentDate = appointmentDate;
    this.report = report;
    this.status = status;
    this.persons = persons;
    this.organizer = organizer;
  }

  /**
   * Override toString() function.
   */
  @Override
  public String toString() {
    return "Rendez-vous [Id = " + getId() + ", informations=" + informations + ", date=" + appointmentDate
        + ", report=" + report + ", status=" + status + "]";
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
  public LocalDateTime getAppointmentDate() {
    return appointmentDate;
  }

  /**
   * Set the dateTime.
   *
   * @param dateTime = the date and time
   */
  public void setAppointmentDate(LocalDateTime appointmentDate) {
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

  public Person getOrganizer() {
    return organizer;
  }

  public void setOrganizer(Person organizer) {
    this.organizer = organizer;
  }

}
