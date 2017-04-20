package org.github.omnbmh.commons.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class ListUtils {
	public static <T> T getFirst(List<? extends T> list) {
		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	public static <T> List<List<T>> splitList(List<T> list, int count) {
		List<List<T>> result = new ArrayList<List<T>>();
		for (int i = 0; i < list.size(); i += count) {
			int start = i;
			int end = (i + count) > (list.size()) ? (list.size()) : (i + count);
			result.add(list.subList(start, end));

		}
		return result;
	}

	public static boolean isEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}

	public static boolean isNotEmpty(List<?> list) {
		return !isEmpty(list);
	}

	public static int removeEmptyElement(List<String> list) {
		int result = 0;
		if (isNotEmpty(list)) {
			for (int index = list.size() - 1; index >= 0; index--) {
				String string = list.get(index);
				if (StringUtils.isEmpty(string)) {
					list.remove(index);
					result++;
				}
			}
		}
		return result;
	}
	
	public static int removeNullElement(List<? extends Object> list) {
		int result = 0;
		if (isNotEmpty(list)) {
			for (int index = list.size() - 1; index >= 0; index--) {
				Object obj = list.get(index);
				if (obj == null) {
					list.remove(index);
					result++;
				}
			}
		}
		return result;
	}
	
}
