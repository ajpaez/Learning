package com.apr.reflection.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * collections and reflections, arrays are also here as well
 * 
 */
public class ReflectionCollections {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		// handle collections using reflection
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.put("4", "d");

		reflectionCollections(map);
		reflectionCollections(map.keySet());
		reflectionCollections(map.values());

		List<String> list = new ArrayList<String>();
		list.add("10");
		list.add("20");
		list.add("30");
		list.add("40");

		reflectionCollections(list);
		reflectionCollections("this is an string");

	}

	/**
	 * This methods extracts all elements of a collection if the passed ref is a
	 * collection
	 * 
	 * @param ref
	 */
	private static void reflectionCollections(Object ref) {

		if (ref instanceof Collection) {
			System.out.println("A collection:  " + ref.getClass().getName());
			// not nice
			Iterator<String> items = ((Collection<String>) ref).iterator();
			while (items != null && items.hasNext()) {
				Object item = items.next();
				System.out.println("Element of the collection:  " + item.getClass().getName());
			}
		} else {
			System.out.println("Not a collection:  " + ref.getClass().getName());
		}
	}

}
