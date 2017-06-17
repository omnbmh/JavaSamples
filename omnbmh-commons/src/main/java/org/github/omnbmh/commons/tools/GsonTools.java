 

package org.github.omnbmh.commons.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

 

public class GsonTools {
	public static String toJsonString(Object object) {
		return new Gson().toJson(object);
	}

	public static JsonObject toJson(String json) {
		return (JsonObject) new JsonParser().parse(json);
	}

	public static JsonObject toJsonObject(Object javaObj) {
		return new Gson().toJsonTree(javaObj).getAsJsonObject();
	}

	public static JsonObject toJsonObject(String jsonStr) {
		return new JsonParser().parse(jsonStr).getAsJsonObject();
	}

	public static <T> T toJavaObject(JsonObject jsonObj, Class<T> classOfT) {
		return new Gson().fromJson(jsonObj, classOfT);
	}

	public static <T> T toJavaObject(String jsonStr, Class<T> classOfT) {
		return new Gson().fromJson(jsonStr, classOfT);
	}

	public static String getJsonStringFromObject(Object javaObj) {
		Gson gson = new Gson();
		return gson.toJson(javaObj);
	}

	public static String toJsonStringWithNull(Object javaObj) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(javaObj);
	}

	public static JsonObject toJsonObjectWithNull(Object javaObj) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJsonTree(javaObj).getAsJsonObject();
	}

	public static String getJsonStringFromObjectNo(Object javaObj) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String s = gson.toJson(javaObj);
		s.replaceAll("\"", "");
		return gson.toJson(javaObj);
	}

	public static String getRemoveQuotesJsonStringFromObject(Object javaObj) {
		Gson gson = new Gson();
		return gson.toJson(javaObj) == null ? gson.toJson(javaObj)
				: gson.toJson(javaObj).toString().replaceAll("\"", "").trim();
	}

	/**
	 * Created With IntelliJ IDEA CE
	 * translate 实现两个实体类的互转
	 * <p>More Info!</p>
	 *
	 * @param  classOfT
	 * @return T
	 * @author dezhichen@creditease.cn
	 * @date 2017/5/3
	 * @time 下午6:30 </PRE>
	 * @since 1.7
	 *
	 * <PRE>
	 */
	public static <T> T translate(Object obj1, Class<T> classOfT) {
		// 源转JsonObject
		Gson gson = new Gson();
		String jsonStr = gson.toJson(obj1);
		return new Gson().fromJson(jsonStr, classOfT);
	}


}
