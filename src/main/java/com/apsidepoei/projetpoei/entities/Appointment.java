package com.apsidepoei.projetpoei.entities;

import java.util.Date;

/**
 * This class is the Appointment entity.
 * @author thomas
 *
 */
public class Appointment extends EntityDb {

  private String informations;
  private Date dateTime;
  private String report;

  /**
   * The informations.
   * @return
   */
  public String getInformations() {
    return informations;
  }

  /**
   * Set the informations.
   * @param informations = the informations
   */
  public void setInformations(String informations) {
    this.informations = informations;
  }

  /**
   * Return the dateTime.
   * @return
   */
  public Date getDateTime() {
    return dateTime;
  }

  /**
   * Set the dateTime.
   * @param dateTime = the date and time
   */
  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  /**
   * The report.
   * @return
   */
  public String getReport() {
    return report;
  }

  /**
   * Set the report.
   * @param report = the report
   */
  public void setReport(String report) {
    this.report = report;
  }

  /**
   * Constructor for a new Appointment.
   * @param informations = informations
   * @param dateTime = date and time
   * @param report = the report
   */
  public Appointment(String informations, Date dateTime, String report) {
    super();
    this.informations = informations;
    this.dateTime = dateTime;
    this.report = report;
  }

  /**
   * Constructor for a new Appointment.
   * @param informations = informations
   * @param dateTime = date and time
   * @param report = the report
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
