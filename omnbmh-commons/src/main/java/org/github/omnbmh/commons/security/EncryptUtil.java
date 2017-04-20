package org.github.omnbmh.commons.security;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;


public class EncryptUtil {

	public static String sha512(String originalText) {
		if (originalText == null)
			return null;
		return DigestUtils.sha512Hex(originalText);
	}

	public static String MD5(String originalText) {
		if (originalText == null)
			return null;
		return DigestUtils.md5Hex(originalText);
	}

	public static String base64Encode(String originalText)
			throws UnsupportedEncodingException {
		if (originalText == null)
			return null;
		return Base64.encodeBase64String(originalText.getBytes("UTF-8"));
	}

	public static String base64Decode(String text)
			throws UnsupportedEncodingException {
		if (text == null)
			return null;
		return new String(Base64.decodeBase64(text), "UTF-8");
	}
	 
	public static String decode(String text) throws UnsupportedEncodingException {
		return URLDecoder.decode(URLDecoder.decode(base64Decode(base64Decode(text)), "utf-8"), "utf-8");
	}
	 
	public static String encode(String text) throws UnsupportedEncodingException {
		return base64Encode(base64Encode(URLEncoder.encode(URLEncoder.encode(text, "utf-8"), "utf-8")));
	}
	//EncryptUtil
	public static void main(String[] args) throws UnsupportedEncodingException {
      // String str="SlRJMU4wSWxNalV5TW5WelpYSkpaQ1V5TlRJeUpUSTFNMEVsTWpVeU1qRXdNREF3TnpZeU1UWXhOU1V5TlRJeUpUSTFOMFE9";
       String  str="{\"userId\":\"100007621615\"}";
       str=encode(str);
       System.out.println(str);
       System.out.println(decode(str));
       //System.out.println(URLDecoder.decode(URLDecoder.decode(str,"UTF-8"),"UTF-8"));
		String code = "userName=18321136147&email=1755601633333333@qq.com";
		String urlLink="userId=81&source=2";
//		String url="http://localhost/lingtou/index.shtml?sign=dXNlcklkPTgxJnNvdXJjZT0y";
		try {
//			System.out.println(sha512("test138"));
//			System.out.println(base64Encode(urlLink));
//			System.out.println(base64Decode("dXNlcmlkPTEwMDAwNzY0NjkzMyZjb2RlPTkzMzIwMDAwMTkyMTY4NyZhbW91bnQ9NS4w"));
//			System.out.println(base64Encode(code));
//			System.out
//					.println(base64Decode("YZzbMihAlmocW-zGjh7xCpLIN-KdRau2*Wvlsg3ulqg_"));
//			System.out.println(code.indexOf("userName="));
//			System.out.println(code.indexOf("&email="));
//			System.out.println(code.substring(code.indexOf("userName=")
//					+ ("userName=").length(), code.indexOf("&email=")));
//			System.out.println(code.substring(code.indexOf("&email=")
//					+ ("&email=").length(), code.length()));
//		    CallWebService.notifyTMPayFinish("022200306397303", "PT20140729100054201");
			
//			String s = "taskBizNo=PAY20140801170001089&taskCode=PN20140801175952001&taskTime=2014-08-01 17:59:40&taskAmount=2.0&payAmount=2.00&fee=&ext1=D20140801170000915&ext2=JY20140801170001086&payResult=00";
//			String s1 = base64Decode(base64Decode(s));
//					;
//			System.out.println(paramMap(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	    
    private static Map<String, String> paramMap(String s) {
        Map<String, String> map = new HashMap<String, String>();
        String[] st = s.split("&");
        for (int i = 0; i < st.length; i++) {
            String[] sp = st[i].split("=");
            if(sp.length==1){
            	map.put(sp[0], null);
            }else{
            	map.put(sp[0], sp[1]);
            }
        }
        return map;
    }

}



 
