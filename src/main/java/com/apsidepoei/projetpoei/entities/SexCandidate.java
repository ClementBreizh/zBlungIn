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
public enum SexCandidate {

  SEX_0,
  SEX_1,
  SEX_2;

  private static Map<String, SexCandidate> namesMap = new HashMap<String, SexCandidate>(3);

  static {
    namesMap.put("-", SEX_0);
    namesMap.put("Mr", SEX_1);
    namesMap.put("Mme", SEX_2);
  }

  @JsonCreator
  public static SexCandidate forValue(String value) {
    return namesMap.get(value);
  }

  @JsonValue
  public String toValue() {
    for (Entry<String, SexCandidate> entry : namesMap.entrySet()) {
      if (entry.getValue() == this)
        return entry.getKey();
    }

    return null; // or fail
  }
}
