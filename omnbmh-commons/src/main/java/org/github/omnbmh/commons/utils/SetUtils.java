package org.github.omnbmh.commons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetUtils {
	public static <T> List<T> asList(Set<T> set) {
		if (null == set) {
			return null;
		}
		List<T> list = new ArrayList<>();
		for (T t : set) {
			list.add(t);
		}
		return list;
	}
}
