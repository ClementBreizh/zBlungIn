package com.apsidepoei.projetpoei.entities;

import java.time.LocalDate;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.apsidepoei.projetpoei.database.contracts.AssessmentContract;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@Entity
@ToString
@Table(name = AssessmentContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = AssessmentContract.COL_ID))
public class Assessment extends EntityDb {

  @JsonProperty(value = AssessmentContract.COL_CATEGORY)
  @Column(name = AssessmentContract.COL_CATEGORY, nullable = false)
  private String category;

  @JsonProperty(value = AssessmentContract.COL_DATE)
  @Column(name = AssessmentContract.COL_DATE, nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate updatingDate;

  @JsonProperty(value = AssessmentContract.COL_SCORE)
  @Column(name = AssessmentContract.COL_SCORE, nullable = true)
  private Float score;

  @JsonProperty(value = AssessmentContract.COL_VALIDATION_DATE)
  @Column(name = AssessmentContract.COL_VALIDATION_DATE, nullable = true)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate validationDate;

  @JsonProperty(value = AssessmentContract.COL_FK_ID_CANDIDATE)
  @ManyToOne(targetEntity = Candidate.class)
  @JoinColumn(name = AssessmentContract.COL_FK_ID_CANDIDATE, referencedColumnName = AssessmentContract.COL_COLUMN_ID_CANDIDATE)
  private Candidate candidate;

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
  public Assessment(String category, LocalDate updatingDate, Candidate candidate) {
    super();
    this.category = category;
    this.updatingDate = updatingDate;
    this.candidate = candidate;
  }

  /**
   * @param category
   * @param updatingDate
   * @param score
   * @param validationDate
   * @param candidate
   */
  public Assessment(String category, LocalDate updatingDate, Float score, LocalDate validationDate,
      Candidate candidate) {
    super();
    this.category = category;
    this.updatingDate = updatingDate;
    this.score = score;
    this.validationDate = validationDate;
    this.candidate = candidate;
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
   * @return the candidate
   */
  public Candidate getCandidate() {
    return candidate;
  }

  /**
   * @param candidate the candidate to set
   */
  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

  /**
   * @return the score
   */
  public Float getScore() {
    return score;
  }

  /**
   * @param score the score to set
   */
  public void setScore(Float score) {
    this.score = score;
  }

  /**
   * @return the validationDate
   */
  public LocalDate getValidationDate() {
    return validationDate;
  }
}
