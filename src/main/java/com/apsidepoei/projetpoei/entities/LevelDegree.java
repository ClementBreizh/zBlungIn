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
public enum LevelDegree {

  LEVEL_0,
  LEVEL_1,
  LEVEL_2,
  LEVEL_3,
  LEVEL_4,
  LEVEL_5;

  private static Map<String, LevelDegree> namesMap = new HashMap<String, LevelDegree>(6);

  static {
      namesMap.put("Sans diplôme", LEVEL_0);
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

  @JsonValue
  public String toValue() {
      for (Entry<String, LevelDegree> entry : namesMap.entrySet()) {
          if (entry.getValue() == this)
              return entry.getKey();
      }

      return null;
  }
}
