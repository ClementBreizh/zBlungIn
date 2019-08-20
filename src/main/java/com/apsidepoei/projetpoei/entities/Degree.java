package com.apsidepoei.projetpoei.entities;

public class Degree extends EntityDb{

	private String name;
	private String level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Degree(String name, String level) {
        super();
        this.name = name;
        this.level = level;
    }

	public Degree() {

    }

	@Override
	public String toString() {
		return "Diplome [nom=" + name + ", niveau=" + level + ", getId()=" + getId() + "]";
	}
}
