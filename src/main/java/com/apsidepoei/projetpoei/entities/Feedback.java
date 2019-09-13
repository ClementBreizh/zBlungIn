package com.apsidepoei.projetpoei.entities;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.apsidepoei.projetpoei.database.contracts.FeedbackContract;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

/**
 * This class is the Feedback entity.
 *
 * @author vianney
 *
 */
@Entity
@ToString
@Table(name = FeedbackContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = FeedbackContract.COL_ID))
public class Feedback extends EntityDb {

  @JsonProperty(value = FeedbackContract.COL_TYPE_OF_CONTRACT)
  @Column(name = FeedbackContract.COL_TYPE_OF_CONTRACT, nullable = false, length = 50)
  private String typeOfContract;

  @JsonProperty(value = FeedbackContract.COL_DURATION_OF_CONTRACT)
  @Column(name = FeedbackContract.COL_DURATION_OF_CONTRACT, nullable = true)
  private Integer durationOfContract;

  @JsonProperty(value = FeedbackContract.COL_COMMENT)
  @Column(name = FeedbackContract.COL_COMMENT, nullable = true)
  private String comment;

  @JsonProperty(value = FeedbackContract.COL_UPDATED_AT)
  @Column(name = FeedbackContract.COL_UPDATED_AT, nullable = true)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  protected LocalDate updatedAt = LocalDate.now();

  /**
   * Empty constructor.
   */
  public Feedback() {
    super();
  }

  /**
   * Constructor with id for new Feedback.
   *
   * @param typeOfContract     = the typeOfContract
   */
  public Feedback(String typeOfContract) {
    super();
    this.typeOfContract = typeOfContract;
  }


  /**
   * @param typeOfContract
   * @param durationOfContract
   * @param comment
   * @param updatedAt
   */
  public Feedback(String typeOfContract, Integer durationOfContract, String comment,
      LocalDate updatedAt) {
    super();
    this.typeOfContract = typeOfContract;
    this.durationOfContract = durationOfContract;
    this.comment = comment;
    this.updatedAt = updatedAt;
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
