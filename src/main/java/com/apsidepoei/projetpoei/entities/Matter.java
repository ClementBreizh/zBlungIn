package com.apsidepoei.projetpoei.entities;

public class Matter extends EntityDb {

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

    public Matter(String name) {
        super();
        this.name = name;
    }

    public Matter(int id, String name) {
        super();
        this.setId(id);
        this.name = name;
    }

    public Matter() {
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Matter [Id = " + getId() + ", name= " + name + "]";
    }

}
