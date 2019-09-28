package com.apsidepoei.projetpoei.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Enumeration for the status of the candidate.
 * @author vianney.
 *
 */
public enum StatusCandidate {

  STATUS_0,
  STATUS_1,
  STATUS_2,
  STATUS_3,
  STATUS_4,
  STATUS_5,
  STATUS_6,
  STATUS_7,
  STATUS_8;

  private static Map<String, StatusCandidate> namesMap = new HashMap<String, StatusCandidate>(9);

  static {
    namesMap.put("Aucune action effectuée", STATUS_0);
    namesMap.put("Appel téléphonique effectué", STATUS_1);
    namesMap.put("Rendez-vous physique effectué", STATUS_2);
    namesMap.put("A rappeler", STATUS_3);
    namesMap.put("Annoncer résultats", STATUS_4);
    namesMap.put("Recherche entreprise", STATUS_5);
    namesMap.put("En poste", STATUS_6);
    namesMap.put("En formation", STATUS_7);
    namesMap.put("Abandon", STATUS_8);
  }

  @JsonCreator
  public static StatusCandidate forValue(String value) {
    return namesMap.get(value);
  }

  /**
   * Return the value for the enumeration.
   *
   * @return the value.
   */
  @JsonValue
  public String toValue() {
    String data = null;

    for (Entry<String, StatusCandidate> entry : namesMap.entrySet()) {
      if (entry.getValue() == this) {
        data = entry.getKey();
      } else {
        data = null; // or fail
      }
    }
    return data;
  }
}