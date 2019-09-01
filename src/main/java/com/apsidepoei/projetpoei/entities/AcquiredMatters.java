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
import com.fasterxml.jackson.annotation.JsonProperty;

/**
* This class is the relation entity Assessment and Candidate.
* @author vianney
*
*/
@Entity
@Table(name = AcquiredMattersContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = AcquiredMattersContract.COL_ID))
public class AcquiredMatters extends EntityDb {

 @JsonProperty(value = AcquiredMattersContract.COL_SCORE)
 @Column(name = AcquiredMattersContract.COL_SCORE, nullable = true)
 protected Float score;

 @JsonProperty(value = AcquiredMattersContract.COL_VALIDATION_DATE)
 @Column(name = AcquiredMattersContract.COL_VALIDATION_DATE, nullable = true)
 @DateTimeFormat(pattern = "yyyy-MM-dd")
 protected LocalDate validationLocalDate;

 @JsonProperty(value = AcquiredMattersContract.COL_FK_ID_MATTER)
 @ManyToOne(targetEntity = Matter.class, optional = false)
 @JoinColumn(name = AcquiredMattersContract.COL_FK_ID_MATTER, referencedColumnName = MatterContract.COL_ID)
 private Matter matter;

 @JsonProperty(value = AcquiredMattersContract.COL_FK_ID_CANDIDATE)
 @ManyToOne(targetEntity = Candidate.class, optional = false)
 @JoinColumn(name = AcquiredMattersContract.COL_FK_ID_CANDIDATE, referencedColumnName = AcquiredMattersContract.COL_COLUMN_ID_CANDIDATE)
 private Candidate candidate;



 /**
  * Empty constructor.
  */
 public AcquiredMatters() {
   super();
 }

 /**
  * Constructor for a new HasDoneAssessment.
  *
  * @param assessment = assessment
  * @param candidate  = candidate
  */
 public AcquiredMatters(Matter matter, Candidate candidate) {
   super();
   this.matter = matter;
   this.candidate = candidate;
 }


 // GETTER/SETTER

 /**
  * @return the candidate
  */
 public Candidate getCandidate() {
   return candidate;
 }

 /**
 * @return the matter
 */
public Matter getMatter() {
  return matter;
}

/**
 * @param matter the matter to set
 */
public void setMatter(Matter matter) {
  this.matter = matter;
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
  * @return the validationLocalDate
  */
 public LocalDate getValidationLocalDate() {
   return validationLocalDate;
 }

 /**
  * @param validationLocalDate the validationLocalDate to set
  */
 public void setValidationLocalDate(LocalDate validationLocalDate) {
   this.validationLocalDate = validationLocalDate;
 }

}
