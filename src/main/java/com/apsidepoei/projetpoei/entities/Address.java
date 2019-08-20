/**
 *
 */
package com.apsidepoei.projetpoei.entities;

/**
 * @author vianney
 *
 */
public class Address extends EntityDb{

    private String adress;
    private String postalCode;
    private String town;


    public Address() {
    }

    public Address(String adress, String postalCode, String town) {
        super();
        this.adress = adress;
        this.postalCode = postalCode;
        this.town = town;
    }

    @Override
    public String toString() {
        return "Adress [AdressName=" + adress + ", postalCode=" + postalCode + ", town=" + town + "]";
    }

    // GETTER/SETTER


    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the town
     */
    public String getTown() {
        return town;
    }

    /**
     * @param town the town to set
     */
    public void setTown(String town) {
        this.town = town;
    }





}
