package com.apsidepoei.projetpoei.entities;

/**
 * This class is the Feedback entity.
 * @author vianney
 *
 */
public class Feedback extends EntityDb {

  private String typeOfContract;
  private Integer durationOfContract;
  private String comment;

  /**
   * Empty constructor.
   */
  public Feedback() {
  }

  /**
   * Constructor with id for new Feedback.
   * @param typeOfContract    = the typeOfContract
   * @param durationOfContract  = the durationOfContract
   * @param comment = the comment
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
   * @return the type of contract
   */
  public String getTypeOfContract() {
    return typeOfContract;
  }

  /**
   * Set the typeOfContract.
   * @param typeOfContract = the typeOfContract
   */
  public void setTypeOfContract(String typeOfContract) {
    this.typeOfContract = typeOfContract;
  }

  /**
   * The contract duration.
   * @return the duration
   */
  public Integer getDurationOfContract() {
    return durationOfContract;
  }

  /**
   * Set the durationOfContract.
   * @param durationOfContract = the durationOfContract
   */
  public void setDurationOfContract(Integer durationOfContract) {
    this.durationOfContract = durationOfContract;
  }

  /**
   * The comment.
   * @return the comment.
   */
  public String getComment() {
    return comment;
  }

  /**
   * Set the comment.
   * @param comment = the comment
   */
  public void setComment(String comment) {
    this.comment = comment;
  }

}
