package com.apsidepoei.projetpoei.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class AES {
  /** The Constant ENCODING. */
  private static final String ENCODING = "UTF-8";

  /** The Constant ALGORITHM. */
  private static final String ALGORITHM = "AES/CBC/PKCS5PADDING";

  /** The Constant SECRET_ALGORITHM. */
  private static final String SECRET_ALGORITHM = "AES";

  public static String encrypt(String key, String initVector, String value) {
    try {
      IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(ENCODING));
      SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(ENCODING), SECRET_ALGORITHM);

      Cipher cipher = Cipher.getInstance(ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

      byte[] encrypted = cipher.doFinal(value.getBytes());

      return Base64.encodeBase64String(encrypted);

    } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
        | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
      e.printStackTrace();
    }

    return null;
  }

  public static String decrypt(String key, String initVector, String encrypted) {

    try {
      IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(ENCODING));
      SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(ENCODING), SECRET_ALGORITHM);

      Cipher cipher = Cipher.getInstance(ALGORITHM);
      cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

      byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

      return new String(original);

    } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
        | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
      e.printStackTrace();
    }

    return null;
  }
}
