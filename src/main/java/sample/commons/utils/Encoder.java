package sample.commons.utils;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;;

public class Encoder {
    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
    private static final String HMAC_SHA256 = "HmacSHA256";

    private Encoder() {
    }

    public static String signHmacSHA256(String data, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] rawHmac = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return toHexString(rawHmac);
    }

    public static boolean hmacSHA256Integrity(String source, String signature) {
        return source.equals(signature);
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        Formatter formatter = new Formatter(sb);
        byte[] var3 = bytes;
        int var4 = bytes.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            formatter.format("%02x", b);
        }

        return sb.toString();
    }

    public static String encode64(String s) {
        byte[] bytesEncoded = Base64.encodeBase64(s.getBytes());
        return new String(bytesEncoded);
    }

    public static String encode64(byte[] bytes) {
        byte[] bytesEncoded = Base64.encodeBase64(bytes);
        return new String(bytesEncoded);
    }

    public static String deCode64(String s) {
        byte[] valueDecoded = Base64.decodeBase64(s);
        return new String(valueDecoded);
    }

    public static String encryptAes(String strToEncrypt, String myKey) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] key = myKey.getBytes("UTF-8");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String decryptAes(String strToDecrypt, String myKey) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] key = myKey.getBytes("UTF-8");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String decryptJsonAes(String strToDecrypt, String myKey) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] key = myKey.getBytes("UTF-8");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("phoneNumber", "0944808998");
//        String enrypt = encryptAes(jsonObject.toString(), "IyWNTG0GOUPLNAq0ZREQWoB0BHtSVE4m");
//        System.out.println(enrypt);
//        System.out.println(decryptAes(enrypt, "IyWNTG0GOUPLNAq0ZREQWoB0BHtSVE4m"));
//    }
}
