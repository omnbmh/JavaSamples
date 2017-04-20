package org.github.omnbmh.commons.security;

import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Hash-based Message Authentication Code
 * Created by b1rd on 2017/1/4.
 */
public final class HMAC {
    private final  static Logger LOGGER = Logger.getLogger(HMAC.class);

    public static String SHA256 (String key,String text, String charset) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Mac mac = Mac.getInstance("HMACSHA256");
        SecretKey secretKey = new SecretKeySpec(key.getBytes(charset), "HMACSHA256");
        byte[] dataBytes = text.getBytes(charset);
        mac.init(secretKey);
        byte[] doFinal = mac.doFinal(dataBytes);
        byte[] hexB = new Hex().encode(doFinal);
        return new String(hexB, charset);
    }
}
