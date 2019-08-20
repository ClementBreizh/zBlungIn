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
    public String getadress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setadress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the postalCode
     */
    public String getpostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setpostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the town
     */
    public String gettown() {
        return town;
    }

    /**
     * @param town the town to set
     */
    public void settown(String town) {
        this.town = town;
    }



}
