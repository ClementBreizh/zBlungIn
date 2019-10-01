package com.apsidepoei.projetpoei.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Ranking candidate enumeration.
 * @author vianney.
 *
 */

@RequiredArgsConstructor
@Getter
public enum RankingCandidate {
  RANK_0(0, "0 - statut non déterminé"),
  RANK_1(1, "1 - tout est ok"),
  RANK_2(2, "2 - ok sauf documents à revoir"),
  RANK_3(3, "3 - pas mal de choses à revoir"),
  RANK_4(4, "4 - ne correspond pas au poste");
  
  // Maybe should simply use ordinal.
  @NonNull
  private final int value;
  
  @NonNull
  @JsonValue
  private final String label;
  
//public enum RankingCandidate {
//
//    RANK_0,
//    RANK_1,
//    RANK_2,
//    RANK_3,
//    RANK_4;
//
//  private static Map<String, RankingCandidate> namesMap = new HashMap<String, RankingCandidate>(5);
//
//  static {
//    namesMap.put("0 - statut non déterminé", RANK_0);
//    namesMap.put("1 - tout est ok", RANK_1);
//    namesMap.put("2 - ok sauf documents à revoir", RANK_2);
//    namesMap.put("3 - pas mal de choses à revoir", RANK_3);
//    namesMap.put("4 - ne correspond pas au poste", RANK_4);
//  }
//
//  @JsonCreator
//    public static RankingCandidate forValue(String value) {
//    return namesMap.get(value);
//  }
//
//  /**
//    * Return the value of this enumeration.
//    * @return the value.
//    */
//  @JsonValue
//  public String toValue() {
//    for (Entry<String, RankingCandidate> entry : namesMap.entrySet()) {
//      if (entry.getValue() == this)
//        return entry.getKey();
//    }
//
//    return null; // or fail
//  }
}
