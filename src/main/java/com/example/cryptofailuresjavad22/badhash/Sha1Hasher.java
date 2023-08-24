package com.example.cryptofailuresjavad22.badhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha1Hasher {
  public static String hash(String password) throws NoSuchAlgorithmException {
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
    byte[] hashBytes = messageDigest.digest(password.getBytes());

    StringBuilder hashStringBuilder = new StringBuilder();
    for (byte hashByte : hashBytes) {
      // Convert each byte to hexadecimal representation
      hashStringBuilder.append(String.format("%02x", hashByte));
    }

    return hashStringBuilder.toString();
  }
}
