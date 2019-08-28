
package com.apsidepoei.projetpoei.entities;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.AssessmentContract;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = AssessmentContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = AssessmentContract.COL_ID))
public class Assessment extends EntityDb {

  @JsonProperty(value = AssessmentContract.COL_CATEGORY)
  @Column(name = AssessmentContract.COL_CATEGORY, nullable = false)
  private String category;

  @JsonProperty(value = AssessmentContract.COL_DATE)
  @Column(name = AssessmentContract.COL_DATE, nullable = false)
  private Date dateTime;

  /**
   * Constructor for a new Assessment.
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

  // GETTER/SETTER


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
   * Constructor for a new Assessment.
   */
  public Assessment(String category, Date dateTime) {
    super();
    this.category = category;
    this.dateTime = dateTime;
  }



}
