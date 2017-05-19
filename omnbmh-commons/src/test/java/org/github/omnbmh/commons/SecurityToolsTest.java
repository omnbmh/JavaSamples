package org.github.omnbmh.commons;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.apache.log4j.PropertyConfigurator;
import org.github.omnbmh.commons.security.RSACoder;
import org.github.omnbmh.commons.tools.FileTools;
import org.github.omnbmh.commons.tools.PathTools;
import org.github.omnbmh.commons.tools.SecurityTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/25 上午10:56
 * @since 1.7
 */
public class SecurityToolsTest extends TestCase {

  Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  protected void setUp() {
    PropertyConfigurator.configure(getClass().getResource("/log4j.properties"));
  }

  public void testRSAKeyCreate() {
    String basePath = PathTools.getClassPath();
    Map<String, byte[]> keys = RSACoder.generateKeyBytes();
    try {
      FileTools
          .writeFile(RSACoder.encryptBASE64(keys.get(RSACoder.PRIVATE_KEY)), basePath + "yx_czbc_rsa");
      FileTools
          .writeFile(RSACoder.encryptBASE64(keys.get(RSACoder.PUBLIC_KEY)), basePath + "yx_czbc_rsa.pub");
    } catch (UnsupportedEncodingException e) {
      logger.error(e.getMessage(), e);
    }
  }

  public void testRSA() {
    String testText = "{\"SERVICE\":{\"SERVICE_BODY\":{\"REQUEST\":{\"ID_NO\":\"612524199203130628\",\"ID_TYPE\":\"I\",\"BORROW_NO\":\"XMJR220002204009\",\"TRANS_TYPE_UP\":\"C\",\"COOPERATOR_ID\":\"20000051\",\"CELLPHONE\":\"15088656026\",\"TRANS_TYPE_DOWNLOAD\":\"B\",\"NAME\":\"汤爱玲\",\"CONTRACT_NO\":\"20170424150000003417\",\"KEY_WORD\":\"甲方（债权人）\",\"FILE_URL\":\"https://plutus-daily.zhonganonline.com/cz/contract/download/\"}},\"SERVICE_HEADER\":{\"SERVICE_ID\":\"AsyncContractApply\",\"REQUEST_TIME\":\"20170424180230\",\"CHANNEL_ID\":\"BANK\",\"SERVICESN\":\"001bfb9f-cff0-4801-9b39-66826412d169\",\"VERSION_ID\":\"01\",\"SUB_TERMINAL_TYPE\":\"OpenApi\",\"ORG\":\"000000000001\",\"ACQ_ID\":\"20000051\"}}}";

//    String priKeyPath = PathTools.getClassPath() +"id_rsa";
//    // 加密
//    System.out.println(new String(SecurityTools.RSAEncode(FileTools.getBytes(priKeyPath) ,testText.getBytes())));

    try {
      System.out.println("-----sign");
      String b1 =RSACoder.sign(testText.getBytes("UTF-8"), RSACoder.getPrivateKey());
      System.out.println(b1);
      System.out.println("-----end");

      System.out.println("-----encrypt");
      byte [] b2 = RSACoder.encryptByPrivateKey(testText.getBytes("UTF-8"), RSACoder.getPrivateKey());
      System.out.println((RSACoder.encryptBASE64(b2)));
      System.out.println("-----end");

      System.out.println("-----verify");
      boolean b3 = RSACoder.verify(testText.getBytes("UTF-8"), RSACoder.getPublicKey(),b1);
      System.out.println(b3);
      System.out.println("-----end");

      System.out.println("-----decrypt");
      byte [] b4 = RSACoder.decryptByPublicKey(b2, RSACoder.getPublicKey());
      System.out.println(new String(b4,"UTF-8"));
      System.out.println("-----end");
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
