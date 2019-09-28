
package com.apsidepoei.projetpoei.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Appointment type enumeration.
 * @author vianney
 *
 */
public enum AppointmentType {

  TYPE_0,
  TYPE_1,
  TYPE_2,
  TYPE_3;

  private static Map<String, AppointmentType> namesMap = new HashMap<String, AppointmentType>(5);

  static {
    namesMap.put("téléphonique", TYPE_0);
    namesMap.put("physique", TYPE_1);
    namesMap.put("Skype", TYPE_2);
    namesMap.put("physique avec tests", TYPE_3);
  }

  @JsonCreator
  public static AppointmentType forValue(String value) {
    return namesMap.get(value);
  }

  /**
   * Return the key.
   *
   * @return is the entry key.
   */
  @JsonValue
  public String toValue() {
    String data = null;
    for (Entry<String, AppointmentType> entry : namesMap.entrySet()) {
      if (entry.getValue() == this) {
        data = entry.getKey();
      } else {
        data = null;
      }
    }
    return data; // or fail
  }
}

