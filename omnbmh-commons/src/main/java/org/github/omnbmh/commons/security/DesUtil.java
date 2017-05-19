package org.github.omnbmh.commons.security;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

 
public class DesUtil {

    private final static String DES = "DES";
    private final static String CODE = "UTF-8";

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
//    	String value="JRGnoizdE1UOqCpuYMDJ1l3M9AlKge%2FxJxECwCrcMcAb%2FcwlP22%2B6UsyR51quCa0XZ1P%2F7y%2BdErc%0D%0Apburh2mgBg%3D%3D";
//    	value=URLDecoder.decode(value,"UTF-8");
//    	System.out.println(value);
//    	//原值
//        //String core = "1056676474@qq.com";
//        String data = "{\"mark\":\"login\",\"password\":\"abcd1234\",\"userName\":\"18511761434\"}";
//        System.out.println(data);
//        //盐值
//        String key = "wylz7821";
//        key="12345678";
//        //加密后
//        String encrypt="";
//        //解密后
//        String decrypt="";
//        //转URLcode
//        String encode="";
//        //转回URLcode
//        String decode="";
//        //转ASCII
//        String stringToAscii="";
//        //ASCII转回
//        String asciiToString="";
//        //加密后
//        encrypt=encrypt(data, key);
//        System.out.println("加密后值：" + encrypt);
////        //转ASCII
////        stringToAscii=stringToAscii(core);
////        System.out.println("转ASCII的值：" + stringToAscii);
////        //转URLcode
////        encode=URLEncoder.encode(encrypt);
////        System.out.println("URLcode后值：" + stringToAscii);
////        //转回URLcode
////        decode=URLDecoder.decode(encode);
////        System.out.println("URLcode转回后值：" + decode);
////        //解密后
////        decrypt=decrypt(decode, key);
////        System.out.println("盐值："+ key +"---解密后值：" + decrypt);
////        //ASCII转回
////        asciiToString=asciiToString(stringToAscii);
////        System.out.println("ASCII转回值：" + asciiToString);
//        System.out.println("解密后：---〉"+decryptString(value,key));


        String en = "dQS8OBrUU757k0jRs/S4fvIxg7hI+lCY6U89zHAtLhIQsHVjVYsQywojuI7yWCF+nqSQJDWFwTU6\n"
            + "q5jnidImdgv0OKD4qO5PiVjU5LDFgs85uJ2KrMGSs4sOsoUs5+cR0pqFmUV1xheoi/CZPZccOBGe\n"
            + "wifX5TJcCH5QYg0A7y4B4TViuJgOMGnFwvAIrWL7chnv1zP8eDuZScDHtAlgQr+4GsanZF68IPCQ\n"
            + "SwAmPej7NRx06yVVmjuDs43iQKGeXnz7RD4KAAn13Zi3DBCz6UOyZhbENtlSYyrsWUC1Uw61Jr/o\n"
            + "fvqLigeuQV5Toyzj7mzSZUU++NnJvzi+cROKn/ifKBRk+Um65Gwxg3+Lz5N/M8mNhRX+U6cWC1Ty\n"
            + "Xf9kcB9yjUpntCzb2C2vQtmK5N20SScFUuVFzu7wWlp4+9nnmobh+KGLllJWWaVGH5eO6SseA1BQ\n"
            + "6wy0W4XDsW2K7lejpvUP5Sniy2D8dqSjfDVMJFe7sENHXezz0FEJwiv0cxY9HdZzbUfOIfmmFolB\n"
            + "yQCmVaufqD+AclvrJciuA1FwtMeG0DBu2WnFwvAIrWL7d7F0ByL+btxHUW/v2twYjDg/F0hl2OY9\n"
            + "Ei9KcA0nUEPlF9h30/lpOLbUhjC1CW1h6hIojwarxc9AO3Jhi+/2rxeGbpQvYZV6HOuR9SrQ8sah\n"
            + "ihJYW5cZCsnX25jS4GH5X0dPsts6tlFasSNYra4WNXdu4q17efV0ZkhU6Khhrn4IOElOoGDuF7Vf\n"
            + "iISZp7mnaZzJmALNB3tcske1Tgw1cWj61L5i54jP";

        en = "dnxuVCQBHS/A5zD38VxbUARwgaPX76LktCHkDTRmTD5Vv/6yhaImFpJUfE5HcpHNJT2gIlKxKQa/\n"
            + "wMF7qXvoYOHsyS6Eme45yDrfSZSXrXjJYSDnnT7OAkWGDiOiXYSCyFlEuRH3/5ZAv77aQnXqxsWz\n"
            + "/FI5Gi44Q8CTeboyzVmsA2rNwhIfSgxSsyw3tKaZdYnV/bjyYdxOeQFH0mu0jn/QUSBK0XEGnJ2g\n"
            + "dzNZ9yw=\n"
            + "14aa4b9f8bdba8c910080f91049d6bd2";

//        System.out.println(decryptString(en,"1A70A1DD249952FE16DDE84FEF1B5B4A"));
                System.out.println(decryptString(en,"12345678"));


    }
    
     
    public static String decryptString(String data, String key) throws Exception {
        //解密后
       return decryptString(data, key,CODE);
        
    }
     
    public static String decryptString(String data, String key,String code) throws Exception {
        //解密后
       return decrypt(data, key,code);
        
    }
     
    public static String encrypt(String data, String key) throws Exception {
        return encrypt(data, key, CODE);
    }
     
    public static String encrypt(String data, String key,String code) throws Exception {
        byte[] bt = encrypt(data.getBytes(code), key.getBytes(code));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }
     
    public static String decrypt(String data, String key) throws IOException,
            Exception {
    	return decrypt(data, key, CODE);
    }
    public static String decrypt(String data, String key,String code) throws IOException,
		    Exception {
		if (data == null)
		    return null;
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] buf = decoder.decodeBuffer(new String(data.getBytes(code)));
		byte[] bt = decrypt(buf, key.getBytes(code));
		return new String(bt,code);
	}
     
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }

     
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }

     
    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append("-");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }

     
    public static String asciiToString(String value) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split("-");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
}
