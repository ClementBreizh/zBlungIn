package com.apsidepoei.projetpoei.entities;

public class Matiere extends EntityDb{

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

    public Matiere(String name) {
        super();
        this.name = name;
    }

    public Matiere(int id, String name) {
        super();
        this.setId(id);
        this.name = name;
    }

    public Matiere() {
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Matiere [id =" + this.getId() + ", name=" + name + "]";
    }

}
