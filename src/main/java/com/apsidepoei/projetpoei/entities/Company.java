package com.apsidepoei.projetpoei.entities;

/**
 * This class is the business entity.
 * @author benjamin-m
 *
 */
public class Company extends EntityDb {

  private String nom;
  private String nomAntenne;
  private String siret;
  private String codeApe;

  /**
   * The name.
   * @return the name
   */
  public String getNom() {
    return nom;
  }

  /**
   * Set the name.
   * @param nom = the name
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * The name of antenna.
   * @return the name of an antenna
   */
  public String getNomAntenne() {
    return nomAntenne;
  }

  /**
   * Set the name of antenna.
   * @param nomAntenne = name of an antenna
   */
  public void setNomAntenne(String nomAntenne) {
    this.nomAntenne = nomAntenne;
  }

  /**
   * The siret.
   * @return the siret number
   */
  public String getSiret() {
    return siret;
  }

  /**
   * Set the siret.
   * @param siret = the siret
   */
  public void setSiret(String siret) {
    this.siret = siret;
  }

  /**
   * The APE code.
   * @return the code
   */
  public String getCodeApe() {
    return codeApe;
  }

  /**
   * Set The APE code.
   * @param codeApe = the code APE
   */
  public void setCodeApe(String codeApe) {
    this.codeApe = codeApe;
  }

  /**
   * Constructor for a new business.
   * @param nom  = the name
   * @param nomAntenne = the name of antenna
   * @param siret = the siret
   * @param codeApe = the APE code
   */
  public Company(String nom, String nomAntenne, String siret, String codeApe) {
    super();
    this.nom = nom;
    this.nomAntenne = nomAntenne;
    this.siret = siret;
    this.codeApe = codeApe;
  }

  /**
   * Constructor with id for a new business.
   * @param id = the id
   * @param nom  = the name
   * @param nomAntenne = the name of antenna
   * @param siret = the siret
   * @param codeApe = the APE code
   */
  public Company(int id, String nom, String nomAntenne, String siret, String codeApe) {
    super();
    this.setId(id);
    this.nom = nom;
    this.nomAntenne = nomAntenne;
    this.siret = siret;
    this.codeApe = codeApe;
  }

  /**
   * Empty constructor.
   */
  public Company() {

  }

  /**
   * override toString() function.
   */
  @Override
  public String toString() {
    return "Entreprise [Id = " + getId() + ", nom = " + nom + ", nomAntenne = " + nomAntenne
        + ", siret = " + siret + ", codeApe = " + codeApe + "]";
  }

}
