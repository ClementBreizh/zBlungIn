package com.apsidepoei.projetpoei.entities;

/**
 * This class is the business entity.
 * @author benjamin-m
 *
 */
public class Entreprise extends EntityDb {

  private String nom;
  private String nomAntenne;
  private String siret;
  private String codeApe;

  /**
   * The name.
   * @return
   */
  public String getNom() {
    return nom;
  }

  /**
   * Set the name.
   * @return
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * The name of antenna.
   * @return
   */
  public String getNomAntenne() {
    return nomAntenne;
  }

  /**
   * Set the name of antenna.
   * @return
   */
  public void setNomAntenne(String nomAntenne) {
    this.nomAntenne = nomAntenne;
  }

  /**
   * The siret.
   * @return
   */
  public String getSiret() {
    return siret;
  }

  /**
   * Set the siret.
   * @return
   */
  public void setSiret(String siret) {
    this.siret = siret;
  }

  /**
   * The APE code.
   * @return
   */
  public String getCodeApe() {
    return codeApe;
  }

  /**
   * Set The APE code.
   * @return
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
  public Entreprise(String nom, String nomAntenne, String siret, String codeApe) {
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
  public Entreprise(int id, String nom, String nomAntenne, String siret, String codeApe) {
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
  public Entreprise() {

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
