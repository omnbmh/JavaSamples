package org.github.omnbmh.commons.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

 
public abstract class Coder {
	public static final String KEY_MD5 = "MD5";

	 
	public static byte[] decryptBASE64(String data) throws UnsupportedEncodingException {
		return Base64.decodeBase64(data.getBytes("UTF-8"));
	}

	 
	public static String encryptBASE64(byte[] data) throws UnsupportedEncodingException {
		return new String(Base64.encodeBase64(data), "UTF-8");
	}

	 
	public static byte[] encryptMD5(byte[] data) throws Exception {

		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);

		return md5.digest();

	}
}
