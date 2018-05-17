package com.shichuan.java.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Print even numbers in the list
 */
public class LambdaDemo09 {
	
	public static void main(String[] args) {
		int[] arr = new int[] { 2,4,6,8,12,13,15 };
		Arrays.stream(arr)
			.filter(n -> (n & 1) == 0)
			.forEach(n -> System.out.println(n));
		
		Stream.of(2,4,6,8,12,13,15)
			.filter(n -> (n & 1) == 0)
			.forEach(n -> System.out.println(n));
	}

}
