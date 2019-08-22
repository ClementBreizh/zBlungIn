package com.apsidepoei.projetpoei.entities;

public class Matters extends EntityDb {

    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public Matters(String name) {
        super();
        this.name = name;
    }

    public Matters(int id, String name) {
        super();
        this.setId(id);
        this.name = name;
    }

    public Matters() {
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Matters [Id = " + getId() + ", name= " + name + "]";
    }

}
