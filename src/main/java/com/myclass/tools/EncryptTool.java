package com.myclass.tools;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author joe
 * @Date 2019/9/3
 */
public class EncryptTool {

    public static String encrypt(String str) throws Exception {
        str = str + "1";
        return (new BASE64Encoder()).encodeBuffer(str.getBytes());
    }

    public static String decrypt(String key) throws Exception {
        byte[] result2 = (new BASE64Decoder()).decodeBuffer(key);
        String resulString = new String(result2);
        return resulString.substring(0, resulString.length() - 1);
    }

    public static String md5(String plainText) throws Exception {
        Object var1 = null;

        byte[] secretBytes;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException var4) {
            throw new RuntimeException("没有md5这个算法！");
        }

        String md5code = (new BigInteger(1, secretBytes)).toString(16);

        for (int i = 0; i < 32 - md5code.length(); ++i) {
            md5code = "0" + md5code;
        }

        return md5code;
    }
}
