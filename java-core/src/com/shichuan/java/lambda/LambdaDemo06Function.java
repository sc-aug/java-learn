package com.shichuan.java.lambda;

import java.util.function.*;

/**
 * Print the length of a string **(Function)**
 */
public class LambdaDemo06Function {

	public static void main(String[] args) {
		String str = "kiwi";
		
		Function<String, Integer> p = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		System.out.println(p.apply(str));
		
		Function<String, Integer> p2 = (t) -> t.length();
		System.out.println(p2.apply(str));
	}
	
}
