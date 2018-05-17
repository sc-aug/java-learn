package com.shichuan.java.lambda;

@FunctionalInterface
interface ITest {
	public Double getRandNum();
}

public class LambdaDemo02 {

	public static void main(String[] args) {
		ITest t = () -> Math.random();
		System.out.println(t.getRandNum());
	}

}
