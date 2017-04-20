package org.github.omnbmh.commons.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
  * Created With IntelliJ IDEA CE
  *  Date 工具类
  * <p>More Info!</p>
  * @version 2017/4/12 下午4:17
  * @since 1.7
  * */
public class DateUtils {
	private static ThreadLocal<SimpleDateFormat> format = new ThreadLocal<SimpleDateFormat>();

	public static final String FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String MONTH_FORMAT = "yyyy-MM";
	public static final String DAY_FORMAT = "yyyy-MM-dd";
	public static final String YEAR_FORMAT = "yyyy-MM";

	public static SimpleDateFormat getf() {
		SimpleDateFormat instance = format.get();
		if (instance == null) {
			instance = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
			format.set(instance);
		}
		return instance;
	}

	public static long getTimeInMillis() {
		return Calendar.getInstance().getTimeInMillis();
	}

	// ------- getDateTime -------
	public static String getCurDateTime() {
		return getCurDateTime("yyyy-MM-dd HH:mm:ss");
	}

	public static String getCurDateTime(String formatStr) {
		getf().applyPattern(formatStr);
		return getf().format(Calendar.getInstance().getTime());
	}

	public static String getDateTime(long source) {
		getf().applyPattern("yyyy-MM-dd HH:mm:ss");
		return getf().format(source);
	}

	public static String getDateTime(long source, String formatStr) {
		getf().applyPattern(formatStr);
		return getf().format(source);
	}

	public static String getDateTime(String source) {
		long temp = parseStrToLong(source);
		getf().applyPattern("yyyy-MM-dd HH:mm:ss");
		return getf().format(temp);
	}

	public static String getDateTime(String source, String formatStr) {
		long temp = parseStrToLong(source);
		getf().applyPattern(formatStr);
		return getf().format(temp);
	}

	// ------- getDate ------
	public static String getCurDate() {
		return getCurDateTime(DAY_FORMAT);
	}

	public static String getCurDate(String formatStr) {
		return getCurDateTime(formatStr);
	}

	public static String getDate(long source, String formatStr) {
		return getDateTime(source, formatStr);
	}

	public static String getDate(String source) {
		long temp = parseStrToLong(source);
		getf().applyPattern("yyyy-MM-dd");
		return getf().format(temp);
	}

	public static String getDate(String source, String formatStr) {
		long temp = parseStrToLong(source);
		getf().applyPattern(formatStr);
		return getf().format(temp);
	}

	// ------- getTime ------
	public static String getCurTime() {
		return getCurDateTime("HH:mm:ss");
	}

	public static String getCurTime(String formatStr) {
		return getCurDateTime(formatStr);
	}

	public static String getTime(long source, String formatStr) {
		return getDateTime(source, formatStr);
	}

	public static String getTime(String source) {
		long temp = parseStrToLong(source);
		getf().applyPattern("HH:mm:ss");
		return getf().format(temp);
	}

	public static String getTime(String source, String formatStr) {
		long temp = parseStrToLong(source);
		getf().applyPattern(formatStr);
		return getf().format(temp);
	}

	// ------- parseStr ------+++
	public static Calendar parseStrToCal(String source) {
		Calendar strCal = Calendar.getInstance();
		try {
			strCal.setTime(getf().parse(checkPattern(source)));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return strCal;
	}

	public static Date parseStrToDate(String source) {
		source = checkPattern(source);
		return source.equals("") ? null : getf().parse(source, new ParsePosition(0));
	}

	public static long parseStrToLong(String source) {
		Date date = parseStrToDate(source);
		return date == null ? 0L : date.getTime();
	}

	public static Date getDateByCal() {
		return Calendar.getInstance().getTime();
	}

	public static Calendar getCalByDate(Date date) {
		Calendar strCal = Calendar.getInstance();
		strCal.setTime(date);
		return strCal;
	}

	// ------- parse HH ------
	public static int getYearByStr(String source) {
		return parseStrToCal(source).get(Calendar.YEAR);
	}

	public static int getDateOfWeekByStr(String source) {
		return parseStrToCal(source).get(Calendar.DAY_OF_WEEK);
	}

	public static int getDateOfWeekStart(String source) {
		int index = getDateOfWeekByStr(source);
		return index - 1 - 7;
	}

	public static int getDateOfWeekEnd(String source) {
		int index = getDateOfWeekByStr(source);
		return 7 - index + 1;
	}

	public static int getMonthByStr(String source) {
		return parseStrToCal(source).get(Calendar.MONTH);
	}

	public static int getDayByStr(String source) {
		return parseStrToCal(source).get(Calendar.DAY_OF_MONTH);
	}

	public static int getHourByStr(String source) {
		return parseStrToCal(source).get(Calendar.HOUR_OF_DAY);
	}

	public static int getMinuteByStr(String source) {
		return parseStrToCal(source).get(Calendar.MINUTE);
	}

	public static int getSecondByStr(String source) {
		return parseStrToCal(source).get(Calendar.SECOND);
	}

	public static String checkPattern(String source) {
		// yyyy-MM-dd HH:mm:ss
		String fP = "(\\d{4})([-:/])(\\d{1,2})\\2(\\d{1,2})[\\s](\\d{1,2})([:])(\\d{1,2})\\6(\\d{1,2})";
		// yyyy-MM-dd
		String dP = "(\\d{4})([-:/])(\\d{1,2})\\2(\\d{1,2})";
		// HH:mm:ss
		String tP = "(\\d{1,2})([-:])(\\d{1,2})\\2(\\d{1,2})";
		// Tue May 22 18:04:33 +0800 2012
		String gP = "\\w{3}([\\s])\\w{3}\\1\\d{2}\\1\\d{2}([:])\\d{2}\\2\\d{2}\\1[\\+]?\\w{3,4}\\1\\d{4}";
		if (source.matches(fP)) {
			getf().applyPattern("yyyy-MM-dd HH:mm:ss");
		} else if (source.matches(dP)) {
			getf().applyPattern("yyyy-MM-dd");
		} else if (source.matches(tP)) {
			Matcher m = Pattern.compile(tP).matcher(source);
			Calendar checkCal = Calendar.getInstance();
			if (m.matches()) {
				checkCal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(m.group(1)));
				checkCal.set(Calendar.MINUTE, Integer.valueOf(m.group(3)));
				checkCal.set(Calendar.SECOND, Integer.valueOf(m.group(4)));
			}
			getf().applyPattern("yyyy-MM-dd HH:mm:ss");
			return getf().format(checkCal.getTime());
		} else if (source.matches(gP)) {
			getf().applyPattern("EEE MMM dd HH:mm:ss z yyyy");
		} else {
			return "";
		}
		return source;
	}

	public static boolean isTheSameDateYMD(Date date, Date antherDate) {

		if (date.getYear() == antherDate.getYear() && date.getMonth() == antherDate.getMonth() && date.getDate() == antherDate.getDate()) {
			return true;
		}
		return false;
	}

	public static Date getPreviousDate(Date date) {
		Date result = new Date();
		result.setTime(date.getTime() - 24 * 60 * 60 * 1000);
		return result;
	}

	public static String getDateOfWeekInChinese(int dateOfWeek) {
		switch (dateOfWeek) {
			case 1:
				return "周日";
			case 2:
				return "周一";
			case 3:
				return "周二";
			case 4:
				return "周三";
			case 5:
				return "周四";
			case 6:
				return "周五";
			case 7:
				return "周六";

		}
		return "";
	}

	public static Date getDateWeekStart(String source) {
		return addDays(parseStrToDate(source), getDateOfWeekStart(source));
	}

	/**
	 *
	 * @Title: getDateWeekStart
	 * @Description: 获取上一个星期一  0点时间
	 * @param @param today
	 * @param @return    参数描述
	 * @return Date    返回类型描述
	 * @throws
	 */
	public static Date getDateWeekStart(Date today) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int index = calendar.get(Calendar.DAY_OF_WEEK)-1;
		if(index == 0 )
			index = 7;
		calendar.add(Calendar.DATE, (1-index));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	/**
	 *
	 * @Title: getDayStartTime
	 * @Description: 获取一天的  0点时间
	 * @param @param today
	 * @param @return    参数描述
	 * @return Date    返回类型描述
	 * @throws
	 */
	public static Date getDayStartTime(Date day) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	/**
	 *
	 * @Title: getDayStartTime
	 * @Description: 获取一天的  0点时间
	 * @param @param today
	 * @param @return    参数描述
	 * @return Date    返回类型描述
	 * @throws
	 */
	public static Date getDayEndTime(Date day) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(day);
		calendar.add(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	/**
	 *
	 * @Title: getDateWeekEnd
	 * @Description: 获取下一个星期一  0点时间
	 * @param @param today
	 * @param @return    参数描述
	 * @return Date    返回类型描述
	 * @throws
	 */
	public static Date getDateWeekEnd(Date today) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int index = calendar.get(Calendar.DAY_OF_WEEK)-1;
		if(index == 0 )
			index = 7;

		calendar.add(Calendar.DATE, (8-index));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	public static Date getDateWeekEnd(String source) {
		return addDays(parseStrToDate(source), getDateOfWeekEnd(source));
	}

	public static Date addDays(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return c.getTime();
	}

	public static Date addMonths(Date date, int months) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, months);
		return c.getTime();
	}

	public static String parseDate2Str(Date date, String formate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		return sdf.format(date);
	}

	public static void main(String[] args) {
		System.out.println(parseStrToLong("2013-11-11 11:11:11"));
		System.out.println(getCurDate("yyyy-MM-dd HH:mm:ss"));
		System.out.println(getCurDate("yyyy-MM"));
		System.out.println(getDateOfWeekByStr(getCurDate("2013-11-11")));
		System.out.println(getDateOfWeekByStr(getCurDate("2013-11-17")));
		System.out.println(getDateOfWeekByStr(getCurDate()));
		System.out.println(addDays(parseStrToDate("2013-11-14"), 3));
		System.out.println(parseStrToDate("2013-11-11"));
	}
	 
	public static String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	 
	public static String formatToDay(Date date) {
		return format(date, "yyyy-MM-dd");
	}
	 
	public static String formatToTime(Date date) {
		return format(date, "HH:mm:ss");
	}
	 
	public static String format(Date date, String pattern) {
		if (date == null) {
			return "null";
		}
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		return new java.text.SimpleDateFormat(pattern).format(date);
	}
	
	 
	public static Date addDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}

	 
	public static Date format(String date) {
		return format(date, null);
	}

	 
	public static Date format(String date, String pattern) {
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		if (date == null || date.equals("") || date.equals("null")) {
			return new Date();
		}
		Date d = null;
		try {
			d = new java.text.SimpleDateFormat(pattern).parse(date);
		} catch (ParseException pe) {
		}
		return d;
	}
	
	  
         
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    
    
    
     
    public static int hoursBetween(String startTime,String endTime){
    	
    	long start = fromDateStringToLong(startTime);
    	long end = fromDateStringToLong(endTime);
    	
    	long ss=(start-end)/(1000); //共计秒数  
    	int hh=(int)ss/3600;  //共计小时数
    	//int MM = (int)ss/60;   //共计分钟数  
    	//int dd=(int)hh/24;   //共计天数  
    	
    	return hh;
    	
    }    
    
     
    public static long ssBetween(String startTime,String endTime){
    	
    	long start = fromDateStringToLong(startTime);
    	long end = fromDateStringToLong(endTime);
    	long ss=(start-end)/(1000); //共计秒数  
    	
    	return ss;
    	
    }    
    
    public static long fromDateStringToLong(String inVal) {
    	Date date = null;   //定义时间类型         
    	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
    	try {   
    	  date = inputFormat.parse(inVal); //将字符型转换成日期型  
    	} catch (Exception e) {   
    	  e.printStackTrace();   
    	}   
    	return date.getTime();   //返回毫秒数  
    }   
    
    public static String getNowTime(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date d = new Date();  
		String str=sdf.format(d);  
		return str;
	}

}
