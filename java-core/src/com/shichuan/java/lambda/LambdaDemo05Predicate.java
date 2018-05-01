package com.shichuan.java.lambda;

import java.util.function.Predicate;

/**
 * Check if the length of string is less or equal to 4
 */
public class LambdaDemo05Predicate {
	public static void main(String[] args) {

		String str = "kiwi";
		
		// Solution 1
		Predicate<String> p = new Predicate<String>() {
			@Override
			public boolean test(String str) {
				return str.length() <= 4;
			}
		};
		System.out.println(p.test(str));
		
		// Solution 2
		Predicate<String> p2 = (String s) -> s.length() <= 4;
		System.out.println(p2.test(str));
	}
	
}
