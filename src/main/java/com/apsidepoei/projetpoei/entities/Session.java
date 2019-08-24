package com.apsidepoei.projetpoei.entities;

import java.util.Date;

/**
 * This class is the session entity.
 * @author benjamin-m
 *
 */
public class Session extends EntityDb {
  private String name;
  private Date dateStart;
  private Date dateEnd;

  /**
   * The name.
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name.
   * @param name = the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The dateStart.
   * @return the start date
   */
  public Date getDateStart() {
    return dateStart;
  }

  /**
   * Set the date start.
   * @param dateStart = the start date
   */
  public void setDateStart(Date dateStart) {
    this.dateStart = dateStart;
  }

  /**
   * The dateEnd.
   * @return the end date
   */
  public Date getDateEnd() {
    return dateEnd;
  }

  /**
   * Set the dateEnd.
   * @param dateEnd = the end date
   */
  public void setDateEnd(Date dateEnd) {
    this.dateEnd = dateEnd;
  }

  /**
   * Constructor for a new Session.
   * @param name = the name
   * @param dateStart = the dateStart
   * @param dateEnd = the dateEnd
   */
  public Session(String name, Date dateStart, Date dateEnd) {
    super();
    this.name = name;
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
  }

  /**
   * Constructor with id for a new Session.
   * @param id = the id
   * @param name = the name
   * @param dateStart = the dateStart
   * @param dateEnd = the dateEnd
   */
  public Session(int id, String name, Date dateStart, Date dateEnd) {
    super();
    this.setId(id);
    this.name = name;
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
  }

  /**
   * Empty constructor.
   */
  public Session() {

  }

  /**
   * Override toString() function.
   */
  @Override
  public String toString() {
    return "session [Id = " + getId() + ", name=" + name + ", dateStart=" + dateStart + ", dateEnd="
        + dateEnd + "]";
  }
}
