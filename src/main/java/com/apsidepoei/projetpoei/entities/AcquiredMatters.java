package com.apsidepoei.projetpoei.entities;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.apsidepoei.projetpoei.database.contracts.AcquiredMattersContract;
import com.apsidepoei.projetpoei.database.contracts.MatterContract;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;


/**
 * This class is the relation entity Assessment and Candidate.
 *
 * @author vianney
 *
 */
@Entity
@ToString
@Table(name = AcquiredMattersContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = AcquiredMattersContract.COL_ID))
//@ApiModel()
public class AcquiredMatters extends EntityDb {

  @ApiModelProperty("My commented field.")
  @ManyToOne(targetEntity = Matter.class, optional = false)
  @JoinColumn(name = AcquiredMattersContract.COL_FK_ID_MATTER,
      referencedColumnName = MatterContract.COL_ID)
  private Matter matter;

  @ManyToOne(targetEntity = Candidate.class, optional = false)
  @JoinColumn(name = AcquiredMattersContract.COL_FK_ID_CANDIDATE,
      referencedColumnName = AcquiredMattersContract.COL_COLUMN_ID_CANDIDATE)
  private Candidate candidate;

  @Column(name = AcquiredMattersContract.COL_SCORE, nullable = true)
  private Float score;

  @Column(name = AcquiredMattersContract.COL_VALIDATION_DATE, nullable = true)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate validationLocalDate;

  /**
   * Empty constructor.
   */
  public AcquiredMatters() {
    super();
  }

  /**
   * Constructor for a new HasDoneAssessment.
   *
   * @param matter    is the matter that the candidate acquired.
   * @param candidate is the candidate who acquired the matter.
   */
  public AcquiredMatters(Matter matter, Candidate candidate) {
    super();
    this.matter = matter;
    this.candidate = candidate;
  }

  /**
   * Constructor for a new HasDoneAssessment.
   *
   * @param score               is the candidate's score.
   * @param validationLocalDate is the date when the candidate validated the
   *                            assessment.
   * @param matter              is the matter of this assessment.
   * @param candidate           is the candidate.
   */
  public AcquiredMatters(Float score, LocalDate validationLocalDate, Matter matter,
      Candidate candidate) {
    super();
    this.score = score;
    this.validationLocalDate = validationLocalDate;
    this.matter = matter;
    this.candidate = candidate;
  }

  // GETTER/SETTER

  /**
   * Return the candidate.
   * @return id the candidate.
   */
  public Candidate getCandidate() {
    return candidate;
  }

  /**
   * Return the matter.
   * @return is the matter.
   */
  public Matter getMatter() {
    return matter;
  }

  /**
   * Set the matter to set.
   * @param matter is a matter to set.
   */
  public void setMatter(Matter matter) {
    this.matter = matter;
  }

  /**
   * Set the candidate.
   * @param candidate is the candidate to set.
   */
  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

  /**
   * Return the score.
   * @return is the the score.
   */
  public Float getScore() {
    return score;
  }

  /**
   * Set the score.
   * @param score is the score to set.
   */
  public void setScore(Float score) {
    this.score = score;
  }

  /**
   * Return the validation date.
   * @return is the validation date.
   */
  public LocalDate getValidationLocalDate() {
    return validationLocalDate;
  }

  /**
   * Set the validation date.
   * @param validationLocalDate is the validationLocalDate to set.
   */
  public void setValidationLocalDate(LocalDate validationLocalDate) {
    this.validationLocalDate = validationLocalDate;
  }

}
