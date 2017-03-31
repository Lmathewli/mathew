package com.mathew.utils.core;

import java.security.MessageDigest;

public class MD5Util {
    private static final String MD5 = "md5";

    public static String md5(String value) {
        try {
            MessageDigest md5 = MessageDigest.getInstance(MD5Util.MD5);
            value = Base64.encode(md5.digest(value.getBytes(StringPool.UTF8))).toString();
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return value;
        }
    }
}
