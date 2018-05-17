package com.shichuan.java.lambda;

interface I1 {
	public static void test() {
		System.out.println("I1");
	}
}

interface I2 {
	public static void test() {
		System.out.println("I2");
	}
}

/**
 * the static methods belongs to class/interface
 * the static methods can not be inherited
 */
public class LambdaDemo00Interface implements I1, I2 {
	public static void main(String[] args) {
		I1.test();
		I2.test();
	}
}
