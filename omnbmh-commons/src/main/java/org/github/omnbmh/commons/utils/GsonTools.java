 

package org.github.omnbmh.commons.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

 

public class GsonTools {
	public static String toJsonString(Object object) {
		return new Gson().toJson(object);
	}

	public static JsonObject toJson(String json) {
		return (JsonObject) new JsonParser().parse(json);
	}
}
