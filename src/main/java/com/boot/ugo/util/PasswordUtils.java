package com.boot.ugo.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * PasswordUtils 密码加密解密工具
 *
 * @author gnl
 */

public class PasswordUtils {

    private final static String KEY = "THISISUGOSPASSWORDHEADER";

    private static final String  ALGORITHM = "AES/ECB/PKCS5Padding";

    public static String aesEncoded(String rawPassword) throws NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        return aesEncoded(rawPassword, KEY);
    }

    public static String aesEncoded(String rawPassword, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return base64Encode(aesEncryptToBytes(rawPassword, key));
    }

    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
        return cipher.doFinal(content.getBytes("utf-8"));
    }

    public static String base64Encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }



    public static String aesDecoded(String encodedPassword) throws Exception {
        return new String(aesDecoded(encodedPassword, KEY), "utf-8");
    }

    public static byte[] aesDecoded(String encryptPassword, String decryptKey) throws Exception {
        return StringUtils.hasText(encryptPassword) ? aesDecodedByByte(base64Decode(encryptPassword), decryptKey) : null;
    }

    public static byte[] base64Decode(String base64Code) throws Exception {
        return StringUtils.hasText(base64Code) ? new BASE64Decoder().decodeBuffer(base64Code) : null;
    }

    public static byte[] aesDecodedByByte(byte[] bytes, String decryptKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        SecretKey secretKey = new SecretKeySpec(decryptKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] plainBytes = cipher.doFinal(bytes);
        return plainBytes;
    }

}
