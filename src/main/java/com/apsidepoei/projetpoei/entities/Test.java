package com.apsidepoei.projetpoei.entities;

import java.util.Date;

public class Test extends EntityDb {

    private String category;
    private Date majTest;

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

    public Test(String category) {
        super();
        this.category = category;
    }

    public Test(int id, String category) {
        super();
        this.setId(id);
        this.category = category;

    }
    public Test(int id, String category, Date majTest) {
        super();
        this.setId(id);
        this.category = category;
        this.majTest = majTest;
    }

    public Test() {
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Test [id=" + this.getId() + ", category=" + category + ", date=" + majTest + "]";
    }

}
