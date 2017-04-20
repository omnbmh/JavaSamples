package org.github.omnbmh.commons.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class MapUtils {

	public static <T> Map<T, T> page(Map<T, T> map, int start, int end) {
		Map<T, T> newMap = new HashMap<T, T>();

		if (start < 0 || (end < start)) {
			return newMap;
		}
		int idx = 0;
		for (T t : map.keySet()) {
			if (idx >= start && idx <= end) {
				newMap.put(t, map.get(t));
			} else {
				break;
			}
			idx++;
		}
		return newMap;
	}

	public static <T> Map<T, T> sort(Map<T, T> map) {
		List<Entry<T, T>> entryMap = new ArrayList<Map.Entry<T, T>>(map.entrySet());

		// 通过比较器实现比较排序
		Collections.sort(entryMap, new Comparator<Map.Entry<T, T>>() {
			public int compare(Map.Entry<T, T> mapping1, Map.Entry<T, T> mapping2) {
				if (mapping1.getValue().getClass().equals(Long.class)) {
					return Long.valueOf(mapping1.getValue().toString()).compareTo(Long.valueOf(mapping2.getValue().toString()));
				}
				return 0;
			}
		});
		Map<T, T> newMap = new HashMap<>();
		for (Entry<T, T> entry : entryMap) {
			newMap.put(entry.getKey(), entry.getValue());
		}
		return newMap;
	}
}
