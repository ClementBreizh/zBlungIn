package com.apsidepoei.projetpoei.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
  private Date dateTime;

  @JsonProperty(value = AppointmentContract.COL_REPORT)
  @Column(name = AppointmentContract.COL_REPORT, nullable = true)
  private String report;

  @JsonProperty(value = AppointmentContract.COL_STATUS)
  @Column(name = AppointmentContract.COL_STATUS, nullable = true)
  private String status;

  @JsonProperty(value = AppointmentContract.COL_PERSONS)
  @ManyToMany(targetEntity = Person.class)
  @JoinTable(name = "appointment_person", joinColumns = {
      @JoinColumn(name = AppointmentContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = PersonContract.COL_ID) })
  private List<Person> persons;

  /**
   * Define the report column name.
   */
  public static final String COL_REPORT = "report";

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
  public Date getDateTime() {
    return dateTime;
  }

  /**
   * Set the dateTime.
   *
   * @param dateTime = the date and time
   */
  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
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
   * Constructor for a new Appointment.
   *
   * @param informations = informations
   * @param dateTime     = date and time
   * @param report       = the report
   */
  public Appointment(String informations, Date dateTime, String report) {
    super();
    this.informations = informations;
    this.dateTime = dateTime;
    this.report = report;
  }

  /**
   * Constructor for a new Appointment.
   *
   * @param informations = informations
   * @param dateTime     = date and time
   * @param report       = the report
   */
  public Appointment(int id, String informations, Date dateTime, String report) {
    super();
    this.setId(id);
    this.informations = informations;
    this.dateTime = dateTime;
    this.report = report;
  }

  /**
   * Empty constructor.
   */
  public Appointment() {
    super();
  }

  /**
   * Override toString() function.
   */
  @Override
  public String toString() {
    return "Rendez-vous [Id = " + getId() + ", informations=" + informations + ", date=" + dateTime
        + ", report=" + report + "]";
  }
}
