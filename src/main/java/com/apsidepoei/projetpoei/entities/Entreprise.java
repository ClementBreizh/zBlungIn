package com.apsidepoei.projetpoei.entities;

public class Entreprise extends EntityDb {

    private String nom;
    private String nomAntenne;
    private String siret;
    private String codeApe;
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomAntenne() {
        return nomAntenne;
    }

    public void setNomAntenne(String nomAntenne) {
        this.nomAntenne = nomAntenne;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }
    
    public String getCodeApe() {
    	return codeApe;
    }
    
    public void setCodeApe(String codeApe) {
    	this.codeApe = codeApe;
    }

    public Entreprise(String nom, String nomAntenne, String siret, String codeApe) {
        super();
        this.nom = nom;
        this.nomAntenne = nomAntenne;
        this.siret = siret;
        this.codeApe = codeApe;
    }

    public Entreprise() {

    }

    @Override
    public String toString() {
        return "Entreprise [nom=" + nom + ", nomAntenne=" + nomAntenne + ", siret=" + siret + ", codeApe=" + codeApe + ", getId()=" + getId() + "]";
    }

}
