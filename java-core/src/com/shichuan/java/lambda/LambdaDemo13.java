package com.shichuan.java.lambda;

import java.util.*;
import java.util.stream.Stream;

public class LambdaDemo13 {

	public static void main(String[] args) {
		System.out.println("stream with list");
		streamWithList();
		System.out.println("stream with set");
		streamWithSet();
		System.out.println("stream with map (entry & key & values)");
		streamWithMap();
		System.out.println("stream with array");
		streamWithArray();
	}
	
	private static void streamWithList() {
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(5); ls.add(4); ls.add(13); ls.add(6);
		ls.stream().forEach(e -> System.out.println(e));
	}
	
	private static void streamWithSet() {
		Set<Integer> set = new HashSet<Integer>();
		set.add(5); set.add(6); set.add(0); set.add(15);
		set.stream().forEach(e -> System.out.println(e));
	}
	
	private static void streamWithMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Texas");
		map.put(2, "New Jersey");
		map.put(3, "Chicago");
		map.put(4, "Texas");
		
		Stream<?> s1 = map.entrySet().stream();
		Stream<?> s2 = map.keySet().stream();
		Stream<?> s3 = map.values().stream();
		
		s1.forEach(e -> System.out.println(e));
		s2.forEach(e -> System.out.println(e));
		s3.forEach(e -> System.out.println(e));
	}
	
	public static void streamWithArray() {
		Integer[] arr = { 5,2,11,3,6 };
		Stream<Integer> s = Arrays.stream(arr);
		s.forEach(e -> System.out.println(e));
	}

}
