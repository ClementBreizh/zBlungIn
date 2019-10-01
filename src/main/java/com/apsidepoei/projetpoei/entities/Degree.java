package com.apsidepoei.projetpoei.entities;

import com.apsidepoei.projetpoei.database.contracts.DegreeContract;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import lombok.ToString;

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

  @Column(name = DegreeContract.COL_NAME, nullable = false)
  private String name;

  @Column(name = DegreeContract.COL_LEVEL)
  @Enumerated(EnumType.STRING)
  private LevelDegree level;

  @Column(name = DegreeContract.COL_VALIDATION_DATE, nullable = true, length = 4)
  @Pattern(regexp = "\\d{4}")
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
  public Degree(String name, LevelDegree level) {
    super();
    this.name = name;
    this.level = level;
  }

  /**
   * Constructor.
   * @param name is the degree name.
   * @param level is a level degree.
   * @param validationDate is the validation date of the degree.
   */
  public Degree(String name, LevelDegree level, String validationDate) {
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
   * Return a date.
   * @return the validationDate
   */
  public String getValidationDate() {
    return validationDate;
  }

  /**
   * Setter for the validation date.
   * @param validationDate the validationDate to set
   */
  public void setValidationDate(String validationDate) {
    this.validationDate = validationDate;
  }

  /**
   * Return a level.
   * @return the level
   */
  public LevelDegree getLevel() {
    return level;
  }

  /**
   * Setter for the level.
   * @param level the level to set
   */
  public void setLevel(LevelDegree level) {
    this.level = level;
  }
}
