package org.github.omnbmh.commons.tools;

import static org.github.omnbmh.commons.security.RSACoder.CIPHER_ALGORITHM;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: 安全工具类!
 * <p>加解密!</p>
 *
 * @version 2017/4/25 上午10:46
 * @since 1.7
 */
public final class SecurityTools {
  public static final String KEY_ALGORITHM = "RSA";


//  public static byte[] RSAEncode(String key, byte[] plainText) {
//
//  }

  public static byte[] RSAEncode(byte[] keyBytes, byte[] plainText) {
    try {
// 构造X509EncodedKeySpec对象
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

    // KEY_ALGORITHM 指定的加密算法
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

    // 取公钥匙对象
    PublicKey pubKey = keyFactory.generatePublic(keySpec);
   return RSAEncode(pubKey,plainText);

    }
    catch (Exception e){
      e.printStackTrace();
    }
    return  null;
  }

    /**
     * 加密，三步走。
     */
  public static byte[] RSAEncode(PublicKey key, byte[] plainText) {

    try {
      Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, key);
      return cipher.doFinal(plainText);
    } catch (NoSuchAlgorithmException | NoSuchPaddingException
        | InvalidKeyException | IllegalBlockSizeException
        | BadPaddingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

//  public static  String RSAEncode (byte [] key, String text) {
//
//  }

  /**
   * 解密，三步走。
   */
  public static String RSADecode(PrivateKey key, byte[] encodedText) {

    try {
      Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
      cipher.init(Cipher.DECRYPT_MODE, key);
      return new String(cipher.doFinal(encodedText));
    } catch (NoSuchAlgorithmException | NoSuchPaddingException
        | InvalidKeyException | IllegalBlockSizeException
        | BadPaddingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;

  }
}
