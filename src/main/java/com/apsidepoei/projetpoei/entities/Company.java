package com.apsidepoei.projetpoei.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.CompanyContract;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is the business entity.
 *
 * @author benjamin-m
 *
 */
@Entity
@Table(name = CompanyContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = CompanyContract.COL_ID))
public class Company extends EntityDb {

  @JsonProperty(value = CompanyContract.COL_NOM)
  @Column(name = CompanyContract.COL_NOM, nullable = false)
  private String nom;

  @JsonProperty(value = CompanyContract.COL_NOM_ANTENNE)
  @Column(name = CompanyContract.COL_NOM_ANTENNE, nullable = false)
  private String nomAntenne;

  @JsonProperty(value = CompanyContract.COL_SIRET)
  @Column(name = CompanyContract.COL_SIRET, nullable = true)
  private String siret;

  @JsonProperty(value = CompanyContract.COL_CODE_APE)
  @Column(name = CompanyContract.COL_CODE_APE, nullable = true)
  private String codeApe;

  /**
   * The name.
   *
   * @return the name
   */
  public String getNom() {
    return nom;
  }

  /**
   * Set the name.
   *
   * @param nom = the name
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * The name of antenna.
   *
   * @return the name of an antenna
   */
  public String getNomAntenne() {
    return nomAntenne;
  }

  /**
   * Set the name of antenna.
   *
   * @param nomAntenne = name of an antenna
   */
  public void setNomAntenne(String nomAntenne) {
    this.nomAntenne = nomAntenne;
  }

  /**
   * The siret.
   *
   * @return the siret number
   */
  public String getSiret() {
    return siret;
  }

  /**
   * Set the siret.
   *
   * @param siret = the siret
   */
  public void setSiret(String siret) {
    this.siret = siret;
  }

  /**
   * The APE code.
   *
   * @return the code
   */
  public String getCodeApe() {
    return codeApe;
  }

  /**
   * Set The APE code.
   *
   * @param codeApe = the code APE
   */
  public void setCodeApe(String codeApe) {
    this.codeApe = codeApe;
  }

  /**
   * Constructor for a new business.
   *
   * @param nom        = the name
   * @param nomAntenne = the name of antenna
   * @param siret      = the siret
   * @param codeApe    = the APE code
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
   *
   * @param id         = the id
   * @param nom        = the name
   * @param nomAntenne = the name of antenna
   * @param siret      = the siret
   * @param codeApe    = the APE code
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
    return "Entreprise [Id = " + getId() + ", nom = " + nom + ", nomAntenne = " + nomAntenne + ", siret = " + siret
        + ", codeApe = " + codeApe + "]";
  }

}
