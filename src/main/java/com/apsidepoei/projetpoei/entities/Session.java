package com.apsidepoei.projetpoei.entities;

import com.apsidepoei.projetpoei.database.contracts.SessionContract;

import java.time.LocalDate;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.ToString;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * This class is the session entity.
 *
 * @author vianney
 *
 */
@Entity
@ToString
@Table(name = SessionContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = SessionContract.COL_ID))
public class Session extends EntityDb {

  @Column(name = SessionContract.COL_NAME, length = 50, nullable = false)
  private String name;

  @Column(name = SessionContract.COL_DATE_START, nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate startDate;

  @Column(name = SessionContract.COL_DATE_END, nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate endDate;


  /**
   * Empty constructor.
   */
  public Session() {
    super();
  }

  /**
   * Constructor for a new Session.
   *
   * @param name      = the name
   * @param startDate = the startDate
   * @param endDate   = the endDate
   */
  public Session(String name, LocalDate startDate, LocalDate endDate) {
    super();
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  // GETTER/SETTER

  /**
   * The name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name.
   *
   * @param name = the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter.
   * @return the startDate
   */
  public LocalDate getStartDate() {
    return startDate;
  }

  /**
   * Setter.
   * @param startDate the startDate to set
   */
  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  /**
   * Getter.
   * @return the endDate
   */
  public LocalDate getEndDate() {
    return endDate;
  }

  /**
   * Setter.
   * @param endDate the endDate to set
   */
  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }
}
