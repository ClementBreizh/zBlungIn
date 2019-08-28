/**
 *
 */
package com.apsidepoei.projetpoei.entities;

/**
 * @author vianney
 *
 */
public enum RankingCandidate {

    RANK_1("1 - tout est ok "),
    RANK_2("2 - ok sauf documents à revoir"),
    RANK_3("3 - pas mal de choses à revoir"),
    RANK_4("4 - ne correspond pas au poste");

    public final String label;
    private RankingCandidate(String label) {
    this.label = label;
    }

}
