package com.apsidepoei.projetpoei.entities;

import java.time.LocalDate;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.apsidepoei.projetpoei.database.contracts.AssessmentContract;
import lombok.ToString;

@Entity
@ToString
@Table(name = AssessmentContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = AssessmentContract.COL_ID))
public class Assessment extends EntityDb {

  @Column(name = AssessmentContract.COL_CATEGORY)
  private AssessmentSubject category;

  @Column(name = AssessmentContract.COL_DATE, nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate updatingDate;

  @Column(name = AssessmentContract.COL_SCORE, nullable = true)
  private Integer score;

  @Column(name = AssessmentContract.COL_VALIDATION_DATE, nullable = true)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate validationDate;


  /**
   * empty constructor.
   */
  public Assessment() {
    super();
  }

  /**
   * @param category
   * @param updatingDate
   * @param candidate
   */
  public Assessment(AssessmentSubject category, LocalDate updatingDate) {
    super();
    this.category = category;
    this.updatingDate = updatingDate;
  }

  /**
   * @param category
   * @param updatingDate
   * @param score
   * @param validationDate
   * @param candidate
   */
  public Assessment(AssessmentSubject category, LocalDate updatingDate, Integer score, LocalDate validationDate) {
    super();
    this.category = category;
    this.updatingDate = updatingDate;
    this.score = score;
    this.validationDate = validationDate;
  }


  // GETTER/SETTER
  /**
   * the category.
   */
  public AssessmentSubject getCategory() {
    return category;
  }

  /**
   * set the category.
   */
  public void setCategory(AssessmentSubject category) {
    this.category = category;
  }

  /**
   * the dateTime.
   */
  public LocalDate getUpdatingDate() {
    return updatingDate;
  }

  /**
   * set the dateTime.
   */
  public void setUpdatingDate(LocalDate updatingDate) {
    this.updatingDate = updatingDate;
  }

  /**
   * @return the score
   */
  public Integer getScore() {
    return score;
  }

  /**
   * @param score the score to set
   */
  public void setScore(Integer score) {
    this.score = score;
  }

  /**
   * @return the validationDate
   */
  public LocalDate getValidationDate() {
    return validationDate;
  }
}
