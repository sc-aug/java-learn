package com.shichuan.java.lambda;

import java.util.function.*;

/**
 * Print a random number
 */
public class LambdaDemo07Supplier {

	public static void main(String[] args) {
		// Solution 1
		Supplier<Double> s1 = new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		};
		System.out.println(s1.get());
		
		// Solution 2
		Supplier<Double> s2 = () -> Math.random();
		System.out.println(s2.get());
	}

}
