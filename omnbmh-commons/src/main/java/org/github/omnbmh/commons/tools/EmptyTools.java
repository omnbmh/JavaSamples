package org.github.omnbmh.commons.tools;

import java.util.Map;

 /**
  * Created With IntelliJ IDEA CE
  * 各种类型验证空!
  * <p>More Info!</p>
  * @param
  * @return
  * @throws
  * @author
  * @version 2017/4/12 下午4:40
  * @since 1.7
  * */
public class EmptyTools {

	 
	public static boolean isNullorEmpty(String str) {

		if ((str == null) || ("".equals(str)) || ("null".equalsIgnoreCase(str))
				|| ("undefined".equalsIgnoreCase(str))) {
			return true;
		}
		return false;
	}

	 
	public static <T> boolean isNullorEmpty(T entity) {
		if (entity == null) {
			return true;
		} else {
			return false;
		}
	}

	 
	public static boolean isNullorEmpty(StringBuffer str) {
		if (str == null ||"".equals(str.toString())  || str.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	 
	public static boolean isNullorEmpty(Map map) {
		if ((map == null) || (map.size() == 0)) {
			return true;
		}
		return false;
	}

 

	 
	public static boolean isNullorEmpty(Object[] obj) {
		if ((obj == null) || (obj.length == 0)) {
			return true;
		}
		return false;
	}

	 
	public static boolean isNullorEmpty(Long longTime) {
		if ((longTime == null) || (longTime.longValue() <= 0L)) {
			return true;
		}
		return false;
	}

	 
	public static boolean isNullorEmpty(String[] str) {
		if ((str == null) || (str.length == 0)) {
			return true;
		}
		return false;
	}
}
