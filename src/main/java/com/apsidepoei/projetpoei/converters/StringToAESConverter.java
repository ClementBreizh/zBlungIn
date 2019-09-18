package com.apsidepoei.projetpoei.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.apsidepoei.projetpoei.utils.AES;


@Converter
public class StringToAESConverter implements AttributeConverter<String, String> {

  /** The Constant KEY. */
  private static final String KEY = "Bar12345Bar12345"; // 128 bit key

  /** The Constant INIT_VECTOR. */
  private static final String INIT_VECTOR = "RandomInitVector"; // 16 bytes IV

  @Override
  public String convertToDatabaseColumn(String attribute) {
    return AES.encrypt(KEY, INIT_VECTOR, attribute);
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    return AES.decrypt(KEY, INIT_VECTOR, dbData);
  }

}

