
package com.apsidepoei.projetpoei.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Assessment subject enumeration.
 * @author vianney
 *
 */
public enum AssessmentSubject {


  SUBJECT_0,
  SUBJECT_1,
  SUBJECT_2,
  SUBJECT_3;


  private static Map<String, AssessmentSubject> namesMap =
      new HashMap<String, AssessmentSubject>(4);

  static {
    namesMap.put("Culture générale", SUBJECT_0);
    namesMap.put("Culture numérique", SUBJECT_1);
    namesMap.put("Mathématiques", SUBJECT_2);
    namesMap.put("Logique", SUBJECT_3);
  }

  @JsonCreator
  public static AssessmentSubject forValue(String value) {
    return namesMap.get(value);
  }

  /**
   * Return the value of the enumeration.
   *
   * @return is a string.
   */
  @JsonValue
  public String toValue() {
    String data = null;

    for (Entry<String, AssessmentSubject> entry : namesMap.entrySet()) {
      if (entry.getValue() == this) {
        data = entry.getKey();
      } else {
        data = null;
      }

    }
    return data;
  }
}
