package com.apsidepoei.projetpoei.entities;

import java.util.Date;

public class Assessment extends EntityDb {

    private String category;
    private Date majAssessment;

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategorie(String category) {
        this.category = category;
    }

    public Assessment(String category) {
        super();
        this.category = category;
    }

    public Assessment(int id, String category) {
        super();
        this.setId(id);
        this.category = category;

    }
    public Assessment(int id, String category, Date majAssessment) {
        super();
        this.setId(id);
        this.category = category;
        this.majAssessment = majAssessment;
    }

    public Assessment() {
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Assessment [id=" + this.getId() + ", category=" + category + ", date=" + majAssessment + "]";
    }

}
