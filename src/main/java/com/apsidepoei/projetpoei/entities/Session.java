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
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name.
   * @return
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The dateStart.
   * @return
   */
  public Date getDateStart() {
    return dateStart;
  }

  /**
   * Set the date start.
   * @return
   */
  public void setDateStart(Date dateStart) {
    this.dateStart = dateStart;
  }

  /**
   * The dateEnd.
   * @return
   */
  public Date getDateEnd() {
    return dateEnd;
  }

  /**
   * Set the dateEnd.
   * @return
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
   * empty constructor.
   */
  public Session() {

  }

  /**
   * override toString() function.
   */
  @Override
  public String toString() {
    return "session [Id = " + getId() + ", name=" + name + ", dateStart=" + dateStart + ", dateEnd="
        + dateEnd + "]";
  }
}
