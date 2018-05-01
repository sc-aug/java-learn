package com.shichuan.java.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

public class LambdaDemo09 {
	
	public static void main(String[] args) {
		Arrays.stream(new int[] { 2,4,6,8,12,13,15 })
			.filter(n -> (n & 1) == 0)
			.forEach(n -> System.out.println(n));
		
		Stream.of(2,4,6,8,12,13,15)
			.filter(n -> (n & 1) == 0)
			.forEach(n -> System.out.println(n));
	}

}
