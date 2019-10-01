
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
 * Appointment type enumeration.
 * @author vianney
 *
 */
@RequiredArgsConstructor
@Getter
public enum AppointmentType {
  
  TYPE_0(0, "téléphonique"),
  TYPE_1(1, "physique"),
  TYPE_2(2, "Skype"),
  TYPE_3(3, "physique avec tests");
  
  // Maybe should simply use ordinal.
  @NonNull
  private final int value;
  
  @NonNull
  @JsonValue
  private final String label;
//  TYPE_0,
//  TYPE_1,
//  TYPE_2,
//  TYPE_3;
//
//  private static Map<String, AppointmentType> namesMap = new HashMap<String, AppointmentType>(5);
//
//  static {
//    namesMap.put("téléphonique", TYPE_0);
//    namesMap.put("physique", TYPE_1);
//    namesMap.put("Skype", TYPE_2);
//    namesMap.put("physique avec tests", TYPE_3);
//  }
//
//  @JsonCreator
//  public static AppointmentType forValue(String value) {
//    return namesMap.get(value);
//  }
//
//  /**
//   * Return the key.
//   *
//   * @return is the entry key.
//   */
//  @JsonValue
//  public String toValue() {
//    String data = null;
//    for (Entry<String, AppointmentType> entry : namesMap.entrySet()) {
//      if (entry.getValue() == this) {
//        data = entry.getKey();
//      } else {
//        data = null;
//      }
//    }
//    return data; // or fail
//  }
}

