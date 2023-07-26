package com.solvedex.BlogSolvedex.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import static org.apache.tomcat.util.codec.binary.Base64.decodeBase64;
import static org.apache.tomcat.util.codec.binary.Base64.encodeBase64;

public class Encrypt {
    private final static String ALG = "AES";
    private final static String CI = "AES/CBC/PKCS5Padding";
    private static final String KEY = "92AE31A79FEEB2A3";
    private static final String IV = "0123456789ABCDEF";

    public static String encrypt(String clearText) throws Exception {
        Cipher cipher = Cipher.getInstance(CI);
        SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(), ALG);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(clearText.getBytes());

        return new String(encodeBase64(encrypted, false));
    }

    public static String decrypt(String encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(CI);
        SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(), ALG);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        byte[] enc = decodeBase64(encrypted);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] decrypted = cipher.doFinal(enc);

        return new String(decrypted);
    }
}
