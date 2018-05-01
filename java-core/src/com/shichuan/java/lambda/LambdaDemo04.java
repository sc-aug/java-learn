package com.shichuan.java.lambda;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface FilterI {
	boolean filterFunc(String str);
}

/**
 * Print the string in a list which length <= 4.
 */
public class LambdaDemo04 {
	public static void main(String args[]) throws Exception{
		// Solution 1
		List<String> list= Arrays.asList("Apple", "Banana", "Kiwi", "Mango", "Orange");
		FilterI filter = (String str) -> str.length() <= 4; 
		for (String s: list) {
			if (filter.filterFunc(s)) System.out.println(s);
		}
		// Solution 2
		list.stream()
			.filter((s) -> s.length() <= 4)
			.forEach((s) -> System.out.println(s));
	}
}