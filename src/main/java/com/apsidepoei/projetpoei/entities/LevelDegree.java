package com.apsidepoei.projetpoei.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Enumration for level of degree.
 * @author vianney.
 *
 */
public enum LevelDegree {

  LEVEL_0,
  LEVEL_1,
  LEVEL_2,
  LEVEL_3,
  LEVEL_4,
  LEVEL_5;

  private static Map<String, LevelDegree> namesMap = new HashMap<String, LevelDegree>(6);

  static {
    namesMap.put("Niveau inconnu", LEVEL_0);
    namesMap.put("CAP, BEP, MC", LEVEL_1);
    namesMap.put("Bac", LEVEL_2);
    namesMap.put("Bac+2", LEVEL_3);
    namesMap.put("Bac+3", LEVEL_4);
    namesMap.put("Bac+5", LEVEL_4);
  }

  @JsonCreator
  public static LevelDegree forValue(String value) {
    return namesMap.get(value);
  }

  /**
   * Return value for the enumeration.
   *
   * @return the value.
   */
  @JsonValue
  public String toValue() {
    String data = null;
    for (Entry<String, LevelDegree> entry : namesMap.entrySet()) {
      if (entry.getValue() == this) {
        data = entry.getKey();
      } else {
        data = null;
      }
    }
    return data;
  }
}
