/**
 *
 */
package com.apsidepoei.projetpoei.entities;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.CandidateContract;
import com.apsidepoei.projetpoei.database.contracts.DegreeContract;
import com.apsidepoei.projetpoei.database.contracts.FeedbackContract;
import com.apsidepoei.projetpoei.database.contracts.MatterContract;
import com.apsidepoei.projetpoei.database.contracts.SessionContract;
import com.apsidepoei.projetpoei.entities.RankingCandidate;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author vianney
 *
 */
@Entity
@Table(name = CandidateContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = CandidateContract.COL_ID))
public class Candidate extends EntityDb {

  @JsonProperty(value = CandidateContract.COL_RANKING_CANDIDATE)
  @Column(name = CandidateContract.COL_RANKING_CANDIDATE, nullable = false)
  private RankingCandidate ranking;

  @JsonProperty(value = CandidateContract.COL_FK_ID_FEEDBACK)
  @ManyToOne(targetEntity=Feedback.class,optional=true)
  @JoinColumn(name=CandidateContract.COL_FK_ID_FEEDBACK, referencedColumnName=FeedbackContract.COL_ID)
  private Feedback feedback;

  @JsonProperty(value = CandidateContract.COL_DEGREES)
  @ManyToMany(targetEntity = Degree.class)
  @JoinTable(name = "candidate_degree", joinColumns = {
      @JoinColumn(name = CandidateContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = DegreeContract.COL_ID) })
  private List<Degree> degrees;

  @JsonProperty(value = CandidateContract.COL_MATTERS)
  @ManyToMany(targetEntity = Matter.class)
  @JoinTable(name = "candidate_matter", joinColumns = {
      @JoinColumn(name = CandidateContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = MatterContract.COL_ID) })
  private List<Matter> matters;

  @JsonProperty(value = CandidateContract.COL_SESSIONS)
  @ManyToMany(targetEntity = Session.class)
  @JoinTable(name = "candidate_session", joinColumns = {
      @JoinColumn(name = CandidateContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = SessionContract.COL_ID) })
  private List<Session> sessions;

  @JsonProperty(value = CandidateContract.COL_ASSESSMENTS)
  @OneToMany(targetEntity=Assessment.class)
  private List<Assessment> assessments;

  /**
   * @return the ranking
   */
  public RankingCandidate getRanking() {
    return ranking;
  }

  /**
   * @param ranking the ranking to set
   */
  public void setRanking(RankingCandidate ranking) {
    this.ranking = ranking;
  }

}
