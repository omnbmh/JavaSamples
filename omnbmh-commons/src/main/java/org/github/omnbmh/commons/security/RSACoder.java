package org.github.omnbmh.commons.security;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import org.github.omnbmh.commons.tools.PathTools;


public abstract class RSACoder extends Coder {

  public static final String KEY_ALGORITHM = "RSA";
  /**
   * 貌似默认是RSA/NONE/PKCS1Padding，未验证
   */
  public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
  public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

  public static final String PUBLIC_KEY = "RSAPublicKey";

  public static final String PRIVATE_KEY = "RSAPrivateKey";

  private static final int MAX_ENCRYPT_BLOCK = 117;


  private static final int MAX_DECRYPT_BLOCK = 128;

  /**
   * RSA密钥长度必须是64的倍数，在512~65536之间。默认是1024
   */
//  public static final int KEY_SIZE = 2048;
  public static final int KEY_SIZE = 1024;



  public static String sign(byte[] data, String privateKey) throws Exception {
    // 解密由base64编码的私钥
    byte[] keyBytes = decryptBASE64(privateKey);

    // 构造PKCS8EncodedKeySpec对象
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

    // KEY_ALGORITHM 指定的加密算法
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

    // 取私钥匙对象
    PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

    // 用私钥对信息生成数字签名
    Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
    signature.initSign(priKey);
    signature.update(data);

    return encryptBASE64(signature.sign());
  }


  public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {

    // 解密由base64编码的公钥
    byte[] keyBytes = decryptBASE64(publicKey);

    // 构造X509EncodedKeySpec对象
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

    // KEY_ALGORITHM 指定的加密算法
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

    // 取公钥匙对象
    PublicKey pubKey = keyFactory.generatePublic(keySpec);

    Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
    signature.initVerify(pubKey);
    signature.update(data);

    // 验证签名是否正常
    return signature.verify(decryptBASE64(sign));
  }


  public static byte[] decryptByPrivateKey(byte[] data, String key) throws Exception {
    // 对密钥解密
    byte[] keyBytes = decryptBASE64(key);

    // 取得私钥
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

    // 对数据解密
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(Cipher.DECRYPT_MODE, privateKey);

    int inputLen = data.length;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offSet = 0;
    byte[] cache;
    int i = 0;
    // 对数据分段解密
    while (inputLen - offSet > 0) {
      if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
        cache = cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK);
      } else {
        cache = cipher.doFinal(data, offSet, inputLen - offSet);
      }
      out.write(cache, 0, cache.length);
      i++;
      offSet = i * MAX_DECRYPT_BLOCK;
    }
    byte[] decryptedData = out.toByteArray();
    out.close();
    return decryptedData;
    // return cipher.doFinal(core);
  }


  public static byte[] decryptByPublicKey(byte[] data, String key) throws Exception {
    // 对密钥解密
    byte[] keyBytes = decryptBASE64(key);

    // 取得公钥
    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    Key publicKey = keyFactory.generatePublic(x509KeySpec);

    // 对数据解密
//    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
    cipher.init(Cipher.DECRYPT_MODE, publicKey);

//    return cipher.doFinal(data);

    int inputLen = data.length;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offSet = 0;
    byte[] cache;
    int i = 0;
    // 对数据分段解密
    while (inputLen - offSet > 0) {
      if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
        cache = cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK);
      } else {
        cache = cipher.doFinal(data, offSet, inputLen - offSet);
      }
      out.write(cache, 0, cache.length);
      i++;
      offSet = i * MAX_DECRYPT_BLOCK;
    }
    byte[] decryptedData = out.toByteArray();
    out.close();
    return decryptedData;
  }


  public static byte[] encryptByPublicKey(byte[] data, String key) throws Exception {
    // 对公钥解密
    byte[] keyBytes = decryptBASE64(key);

    // 取得公钥
    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    Key publicKey = keyFactory.generatePublic(x509KeySpec);

    // 对数据加密
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(Cipher.ENCRYPT_MODE, publicKey);

    int inputLen = data.length;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offSet = 0;
    byte[] cache;
    int i = 0;
    // 对数据分段加密
    while (inputLen - offSet > 0) {
      if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
        cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
      } else {
        cache = cipher.doFinal(data, offSet, inputLen - offSet);
      }
      out.write(cache, 0, cache.length);
      i++;
      offSet = i * MAX_ENCRYPT_BLOCK;
    }
    byte[] decryptedData = out.toByteArray();
    out.close();
    return decryptedData;
    // return cipher.doFinal(core);
  }


  public static byte[] encryptByPrivateKey2(byte[] data, String key) throws Exception {
    // 对密钥解密
    byte[] keyBytes = decryptBASE64(key);

    // 取得私钥
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

    // 对数据加密
    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(Cipher.ENCRYPT_MODE, privateKey);

    return cipher.doFinal(data);
  }

  // 分段使用私钥加密
  public static byte[] encryptByPrivateKey(byte[] data, String key) throws Exception {
    // 对密钥解密
    byte[] keyBytes = decryptBASE64(key);

    // 取得私钥
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

    // 对数据加密
//    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, privateKey);

    int inputLen = data.length;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offSet = 0;
    byte[] cache;
    int i = 0;
    // 对数据分段加密
    while (inputLen - offSet > 0) {
      if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
        cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
      } else {
        cache = cipher.doFinal(data, offSet, inputLen - offSet);
      }
      out.write(cache, 0, cache.length);
      i++;
      offSet = i * MAX_ENCRYPT_BLOCK;
    }
    byte[] decryptedData = out.toByteArray();
    out.close();
    return decryptedData;
//    return cipher.doFinal(data);
  }


  public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
    Key key = (Key) keyMap.get(PRIVATE_KEY);

    return encryptBASE64(key.getEncoded());
  }


  public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
    Key key = (Key) keyMap.get(PUBLIC_KEY);

    return encryptBASE64(key.getEncoded());
  }


  public static Map<String, Object> initKey() throws Exception {
    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
    keyPairGen.initialize(1024);

    KeyPair keyPair = keyPairGen.generateKeyPair();

    // 公钥
    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

    // 私钥
    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

    Map<String, Object> keyMap = new HashMap<String, Object>(2);

    keyMap.put(PUBLIC_KEY, publicKey);
    keyMap.put(PRIVATE_KEY, privateKey);
    return keyMap;
  }

  public static String getPrivateKey() throws IOException {
    String key = "";
    FileReader fr = new FileReader(PathTools.getClassPath() +"yx_czbc_rsa");
    BufferedReader br = new BufferedReader(fr);
    String brl = br.readLine();
    key = brl;
    while (brl != null) {
//      System.out.println(brl);
      brl = br.readLine();
      key += brl;
    }
    br.close();
    fr.close();
    return key;
  }

  public static String getPublicKey() throws IOException {
    String key = "";
    FileReader fr = new FileReader(PathTools.getClassPath() +"yx_czbc_rsa.pub");
    BufferedReader br = new BufferedReader(fr);
    String brl = br.readLine();
    key = brl;
    while (brl != null) {
//      System.out.println(brl);
      brl = br.readLine();
      key += brl;
    }
    br.close();
    fr.close();
    return key;
  }

  /**
   * 生成密钥对。注意这里是生成密钥对KeyPair，再由密钥对获取公私钥
   *
   * @return
   */
  public static Map<String, byte[]> generateKeyBytes() {

    try {
      KeyPairGenerator keyPairGenerator = KeyPairGenerator
          .getInstance(KEY_ALGORITHM);
      keyPairGenerator.initialize(KEY_SIZE);
      KeyPair keyPair = keyPairGenerator.generateKeyPair();
      RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
      RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

      Map<String, byte[]> keyMap = new HashMap<>();
      keyMap.put(PUBLIC_KEY, publicKey.getEncoded());
      keyMap.put(PRIVATE_KEY, privateKey.getEncoded());
      return keyMap;
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return new HashMap<>();
  }
  /**
   * 还原公钥，X509EncodedKeySpec 用于构建公钥的规范
   *
   * @param keyBytes
   * @return
   */
  public static PublicKey restorePublicKey(byte[] keyBytes) {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);

    try {
      KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
      PublicKey publicKey = factory.generatePublic(x509EncodedKeySpec);
      return publicKey;
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 还原私钥，PKCS8EncodedKeySpec 用于构建私钥的规范
   *
   * @param keyBytes
   * @return
   */
  public static PrivateKey restorePrivateKey(byte[] keyBytes) {
    PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
        keyBytes);
    try {
      KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
      PrivateKey privateKey = factory
          .generatePrivate(pkcs8EncodedKeySpec);
      return privateKey;
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
}
