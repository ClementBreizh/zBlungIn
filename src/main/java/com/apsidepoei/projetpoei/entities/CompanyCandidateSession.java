package com.apsidepoei.projetpoei.entities;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.CandidateContract;
import com.apsidepoei.projetpoei.database.contracts.CompanyCandidateSessionContract;
import com.apsidepoei.projetpoei.database.contracts.CompanyContract;
import com.apsidepoei.projetpoei.database.contracts.PersonContract;
import com.apsidepoei.projetpoei.database.contracts.SessionContract;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is the CompanyCandidateSession entity.
 * @author thomas
 *
 */
@Entity
@Table(name = CompanyCandidateSessionContract.TABLE)
//@AttributeOverride(name = "id", column = @Column(name = CompanyCandidateSession.COL_ID))
public class CompanyCandidateSession extends EntityDb {

  @JsonProperty(value = CompanyCandidateSessionContract.COL_COMPANY)
  @OneToOne
  @JoinColumn(name = CandidateContract.COL_ID)
  private Company company;

  @JsonProperty(value = CompanyCandidateSessionContract.COL_CANDIDATES)
  @OneToMany(targetEntity = Candidate.class)
  @JoinColumn(name = CompanyCandidateSessionContract.COL_CANDIDATES, referencedColumnName = Candidate.COL_ID)
  private List<Candidate> candidates;

  @JsonProperty(value = CompanyCandidateSessionContract.COL_SESSION)
  @OneToOne
  @JoinColumn(name = SessionContract.COL_ID)
  private int session;

}
