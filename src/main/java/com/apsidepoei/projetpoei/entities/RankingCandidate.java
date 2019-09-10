/**
 *
 */
package com.apsidepoei.projetpoei.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author vianney
 *
 */
public enum RankingCandidate {

    RANK_0,
    RANK_1,
    RANK_2,
    RANK_3,
    RANK_4;

    private static Map<String, RankingCandidate> namesMap = new HashMap<String, RankingCandidate>(5);

    static {
        namesMap.put("0 - statut non déterminé", RANK_0);
        namesMap.put("1 - tout est ok", RANK_1);
        namesMap.put("2 - ok sauf documents à revoir", RANK_2);
        namesMap.put("3 - pas mal de choses à revoir", RANK_3);
        namesMap.put("4 - ne correspond pas au poste", RANK_4);
    }

    @JsonCreator
    public static RankingCandidate forValue(String value) {
        return namesMap.get(value);
    }

    @JsonValue
    public String toValue() {
        for (Entry<String, RankingCandidate> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }

        return null; // or fail
    }
}
