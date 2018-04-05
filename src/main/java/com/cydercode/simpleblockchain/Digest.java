package com.cydercode.simpleblockchain;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {

    public String apply(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexFormat = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hexNumber = Integer.toHexString(0xFF & hash[i]);
                if (hexNumber.length() == 1) {
                    hexFormat.append('0');
                }

                hexFormat.append(hexNumber);
            }

            return hexFormat.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
