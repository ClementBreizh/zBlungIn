package com.apsidepoei.projetpoei.entities;

import com.apsidepoei.projetpoei.database.contracts.DegreeContract;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.time.Year;

/**
 * This class is the Degree entity.
 *
 * @author thomas
 *
 */
@Entity
@ToString
@Table(name = DegreeContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = DegreeContract.COL_ID))
public class Degree extends EntityDb {

  @JsonProperty(value = DegreeContract.COL_NAME)
  @Column(name = DegreeContract.COL_NAME, nullable = false)
  private String name;

  @JsonProperty(value = DegreeContract.COL_LEVEL)
  @Column(name = DegreeContract.COL_LEVEL, length = 50, nullable = false)
  private String level;

  @JsonProperty(value = DegreeContract.COL_VALIDATION_DATE)
  @Column(name = DegreeContract.COL_VALIDATION_DATE, nullable = true, length = 4)
  @Pattern(regexp = "20\\d{2}")
  protected String validationDate;

  /**
   * Empty constructor.
   */
  public Degree() {
    super();
  }

  /**
   * Constructor for a new degree.
   *
   * @param name  = the name
   * @param level = the level
   */
  public Degree(String name, String level) {
    super();
    this.name = name;
    this.level = level;
  }

  /**
   * @param name
   * @param level
   * @param validationDate
   */
  public Degree(String name, String level, String validationDate) {
    super();
    this.name = name;
    this.level = level;
    this.validationDate = validationDate;
  }


  // GETTER/SETTER

  /**
   * The name.
   *
   * @return the name.
   */
  public String getName() {
    return this.name;
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
   * The level.
   *
   * @return the name.
   */
  public String getLevel() {
    return this.level;
  }

  /**
   * Set the level.
   *
   * @param level = the level
   */
  public void setLevel(String level) {
    this.level = level;
  }

  /**
   * @return the validationDate
   */
  public String getValidationDate() {
    return validationDate;
  }

  /**
   * @param validationDate the validationDate to set
   */
  public void setValidationDate(String validationDate) {
    this.validationDate = validationDate;
  }
}
