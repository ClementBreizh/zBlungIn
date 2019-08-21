/**
 *
 */
package com.apsidepoei.projetpoei.entities;

/**
 * @author vianney
 *
 */
public class Feedback extends EntityDb{

    private String typeOfContract;
    private Integer durationOfContract;
    private String comment;

    public Feedback() {
    }

    public Feedback(String typeOfContract, Integer durationOfContract, String comment) {
        super();
        this.typeOfContract = typeOfContract;
        this.durationOfContract = durationOfContract;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Feedback [" + "Id = " + getId() + ", type de contrat = " + typeOfContract + ", durée de contrat = " + durationOfContract + ", commentaire = " + comment + "]";
    }


    // GETTER/SETTER

    /**
     * @return the typeOfContract
     */
    public String getTypeOfContract() {
        return typeOfContract;
    }

    /**
     * @param typeOfContract the typeOfContract to set
     */
    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    /**
     * @return the durationOfContract
     */
    public Integer getDurationOfContract() {
        return durationOfContract;
    }

    /**
     * @param durationOfContract the durationOfContract to set
     */
    public void setDurationOfContract(Integer durationOfContract) {
        this.durationOfContract = durationOfContract;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

}
