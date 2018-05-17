package com.shichuan.java.lambda;

@FunctionalInterface
interface I {
	String calculateFunc(int x);
}

public class LambdaDemo03 {
	public static void main(String args[]) throws Exception{
		// return whether it is "even" or "odd"
		I o = (int x) -> ((x & 1) == 0) ? "even" : "odd";
		System.out.println(o.calculateFunc(2));
	}
}
