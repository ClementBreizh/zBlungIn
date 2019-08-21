/**
 *
 */
package com.apsidepoei.projetpoei.entities;

/**
 * @author vianney
 *
 */
public class Address extends EntityDb{

    private String address;
    private String postalCode;
    private String town;


    public Address() {
    }

    public Address(String address, String postalCode, String town) {
        super();
        this.address = address;
        this.postalCode = postalCode;
        this.town = town;
    }

    @Override
    public String toString() {
        return "Adresse [Id = " + getId() + ", adresse postale = " + address + ", code postal = " + postalCode + ", ville = " + town + "]";
    }

    // GETTER/SETTER


    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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
