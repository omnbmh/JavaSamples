package org.github.omnbmh.commons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;


public class RegexUtils {
	
	static Pattern metionS = Pattern.compile("\\@.*");
	static Pattern metionE = Pattern.compile("\\@|\\s|\\#");
	static Pattern topicS = Pattern.compile("\\#.*");
	static Pattern topicE = Pattern.compile("\\#");
	static Pattern urlS = Pattern.compile("(http://|https://|www\\.)\\.*");
	static Pattern urlE = Pattern.compile("\\s|[\u4e00-\u9fa5]");
	
	/**
	 * 匹配出内容中提到的名字并返回
	* @Title: findMetions 
	* @param @param text
	* @param @return    参数描述
	* @return List<String>    返回类型描述
	* @throws */
	public static List<String> findMetions(String text){
		/** 这两步过滤有没必要?需要考虑. start */
		List<String> urls = findUrls(text);
		for (String string : urls) {
			text = text.replace(string, " ");
        }
		List<String> topics = findTopics(text);
		for (String string : topics) {
			text = text.replace(string, " ");
        }
		/** 这两步过滤有没必要,需要考虑  end */
		List<String> names = new ArrayList<String>();
		String name = "";
		String temp = "";
		int start = 0;
		int end = 0;
		while (true) {
			Matcher m = metionS.matcher(text);
			if(m.find()){
				start = m.start()+1;
				if(start <= text.length()){
					temp = text.substring(start);
					Matcher m1 = metionE.matcher(temp);
					if(m1.find()){
						end = start+m1.start();
					}else{
						end = text.length();
					}
					name = text.substring(start, end);
					if(!"".equals(name)) names.add(name);
				}
			}else{
				break;
			}
			text = temp;
        }
		return names;
	}

	public static List<String> findTopics(String text){
		List<String> topics = new ArrayList<String>();
		
		String temp = "";
		String topic = "";
		int start = 0;
		int end = 0;
		while(true){
			Matcher m = topicS.matcher(text);
			if(m.find()){
				start = m.start()+1;
				if(start <= text.length()){
					temp = text.substring(start);
					Matcher m1 = topicE.matcher(temp);
					if(m1.find()){
						end = start+m1.start();
						temp = temp.substring(m1.start()+1);
					}else{
						end = text.length();
					}
					topic = text.substring(start, end);
					if(!"".equals(topic)) topics.add(topic);
				}
			}else{
				break;
			}
			text = temp;
		}
		return topics;
	}

	public static List<String> findUrls(String text){
		List<String> urls = new ArrayList<String>();
		String url = "";
		String temp = "";
		int start = 0;
		int end = 0;
		while(true){
			Matcher m = urlS.matcher(text);
			if(m.find()){
				start = m.start();
				temp = text.substring(start);
				Matcher m1 = urlE.matcher(temp);
				if(m1.find()){
					end = start+m1.start();
				}else{
					end = text.length();
				}
				url = text.substring(start, end);
				text = text.substring(end);
				
				if(!"".equals(url)) urls.add(url);
			}else{
				break;
			}
		}
		return urls;
	}

	public static int contentCheck(String text, int type){
		int result = 1;
		if(StringUtils.isEmpty(text)){
			result = 0;
		}else{
			int limit = 280;
			if(3==type) limit = 600;
			List<String> urls = findUrls(text);
			for (String string : urls) {
				text = text.replace(string, "");
	        }
			text = text.replaceAll("[^\\x00-\\xff]", "**");
			if((text.trim().getBytes().length+2*10*urls.size()) > limit){//url 算10个字符
				result = 0;
			}
		}
		return result;
	}
}
