
package com.apsidepoei.projetpoei.entities;

import java.util.Date;

public class Assessment extends EntityDb {

  private String category;
  private Date dateTime;

  /**
   * the category.
   */
  public String getCategory() {
    return category;
  }

  /**
   * set the category.
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * the dateTime.
   */
  public Date getDateTime() {
    return dateTime;
  }

  /**
   * set the dateTime.
   */
  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  /**
   * Constructor for a new Appointment.
   */
  public Assessment(String category, Date dateTime) {
    super();
    this.category = category;
    this.dateTime = dateTime;
  }

  /**
   * Constructor for a new Appointment.
   */
  public Assessment(int id, String category, Date dateTime) {
    super();
    this.setId(id);
    this.category = category;
    this.dateTime = dateTime;
  }

  /**
   * empty constructor.
   */
  public Assessment() {

  }

  /**
   * override toString() function.
   */
  @Override
  public String toString() {
    return "Assessment [Id = " + getId() + ", category =" + category + ", date=" + dateTime + "]";
  }

}
