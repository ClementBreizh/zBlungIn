package com.apsidepoei.projetpoei.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.FeedbackContract;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is the Feedback entity.
 *
 * @author vianney
 *
 */
@Entity
@Table(name = FeedbackContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = FeedbackContract.COL_ID))
public class Feedback extends EntityDb {

  @JsonProperty(value = FeedbackContract.COL_TYPE_OF_CONTRACT)
  @Column(name = FeedbackContract.COL_TYPE_OF_CONTRACT, nullable = false)
  private String typeOfContract;

  @JsonProperty(value = FeedbackContract.COL_DURATION_OF_CONTRACT)
  @Column(name = FeedbackContract.COL_DURATION_OF_CONTRACT, nullable = true)
  private Integer durationOfContract;

  @JsonProperty(value = FeedbackContract.COL_COMMENT)
  @Column(name = FeedbackContract.COL_COMMENT, nullable = true)
  private String comment;

  
  /**
   * Empty constructor.
   */
  public Feedback() {
  }

  /**
   * Constructor with id for new Feedback.
   *
   * @param typeOfContract     = the typeOfContract
   * @param durationOfContract = the durationOfContract
   * @param comment            = the comment
   */
  public Feedback(String typeOfContract, Integer durationOfContract, String comment) {
    super();
    this.typeOfContract = typeOfContract;
    this.durationOfContract = durationOfContract;
    this.comment = comment;
  }

  /**
   * Override toString() function.
   */
  @Override
  public String toString() {
    return "Feedback [" + "Id = " + getId() + ", type de contrat = " + typeOfContract
        + ", durée de contrat = " + durationOfContract + ", commentaire = " + comment + "]";
  }

  // GETTER/SETTER

  /**
   * The typeOfContract.
   *
   * @return the type of contract
   */
  public String getTypeOfContract() {
    return typeOfContract;
  }

  /**
   * Set the typeOfContract.
   *
   * @param typeOfContract = the typeOfContract
   */
  public void setTypeOfContract(String typeOfContract) {
    this.typeOfContract = typeOfContract;
  }

  /**
   * The contract duration.
   *
   * @return the duration
   */
  public Integer getDurationOfContract() {
    return durationOfContract;
  }

  /**
   * Set the durationOfContract.
   *
   * @param durationOfContract = the durationOfContract
   */
  public void setDurationOfContract(Integer durationOfContract) {
    this.durationOfContract = durationOfContract;
  }

  /**
   * The comment.
   *
   * @return the comment.
   */
  public String getComment() {
    return comment;
  }

  /**
   * Set the comment.
   *
   * @param comment = the comment
   */
  public void setComment(String comment) {
    this.comment = comment;
  }

}
