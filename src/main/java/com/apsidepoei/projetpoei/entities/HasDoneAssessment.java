/**
 *
 */
package com.apsidepoei.projetpoei.entities;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.AssessmentContract;
import com.apsidepoei.projetpoei.database.contracts.HasDoneAssessmentContract;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is the relation entity Assessment and Candidate.
 * @author vianney
 *
 */
@Entity
@Table(name = HasDoneAssessmentContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = HasDoneAssessmentContract.COL_ID))
public class HasDoneAssessment extends EntityDb {

  @JsonProperty(value = HasDoneAssessmentContract.COL_SCORE)
  @Column(name = HasDoneAssessmentContract.COL_SCORE, nullable = false)
  protected Float score;

  @JsonProperty(value = HasDoneAssessmentContract.COL_VALIDATION_DATE)
  @Column(name = HasDoneAssessmentContract.COL_VALIDATION_DATE, nullable = false)
  protected Date calidationDate;

  @JsonProperty(value = HasDoneAssessmentContract.COL_FK_ID_ASSESSMENT)
  @ManyToOne(targetEntity = Assessment.class, optional = true)
  @JoinColumn(name = HasDoneAssessmentContract.COL_FK_ID_ASSESSMENT, referencedColumnName = AssessmentContract.COL_ID)
  private Assessment assessment;

  @JsonProperty(value = HasDoneAssessmentContract.COL_FK_ID_CANDIDATE)
  @ManyToOne(targetEntity = Candidate.class, optional = true)
  @JoinColumn(name = HasDoneAssessmentContract.COL_FK_ID_CANDIDATE, referencedColumnName = HasDoneAssessmentContract.COL_COLUMN_ID_CANDIDATE)
  private Candidate candidate;



  /**
   * Empty constructor.
   */
  public HasDoneAssessment() {
    super();
  }

  /**
   * Constructor for a new HasDoneAssessment.
   *
   * @param assessment = assessment
   * @param candidate  = candidate
   */
  public HasDoneAssessment(Assessment assessment, Candidate candidate) {
    super();
    this.assessment = assessment;
    this.candidate = candidate;
  }


  // GETTER/SETTER
  /**
   * @return the assessment
   */
  public Assessment getAssessment() {
    return assessment;
  }

  /**
   * @param assessment the assessment to set
   */
  public void setAssessment(Assessment assessment) {
    this.assessment = assessment;
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
}
