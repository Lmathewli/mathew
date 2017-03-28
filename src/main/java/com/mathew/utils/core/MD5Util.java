package com.mathew.utils.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    private static final String MD5 = "md5";
    private static final String STRING_BLANK = "";
    private static final String STRING_ZERO = "0";

    public static String getMD5String(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5Util.MD5);
            byte[] e = md.digest(value.getBytes());
            return toHexString(e);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return value;
        }
    }
 
    public static String getMD5String(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5Util.MD5);
            byte[] e = md.digest(bytes);
            return toHexString(e);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return STRING_BLANK;
        }
    }
 
    private static String toHexString(byte bytes[]) {
        StringBuilder hs = new StringBuilder();
        String stmp = STRING_BLANK;

        for (int n = 0; n < bytes.length; n++) {
            stmp = Integer.toHexString(bytes[n] & 0xff);

            if (stmp.length() == 1) {
                hs.append(STRING_ZERO).append(stmp);
            } 
            hs.append(stmp);
        }
 
        return hs.toString();
    }
}
