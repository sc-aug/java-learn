package com.shichuan.java.lambda;

import java.util.stream.Stream;

public class LambdaDemo11 {
	static class Employee {
		int id;
		String name;
		int age;
		int marks;
		Employee(int i, String n, int a, int m) {
			id = i;
			name = n;
			age = a;
			marks = m;
		}
	}
	
	public static void main(String[] args) {
		Employee e1 = new Employee(1, "XX", 10, 100);
		Employee e2 = new Employee(2, "RX", 30, 30);
		Employee e3 = new Employee(3, "CX", 10, 10);
		Employee e4 = new Employee(4, "VX", 70, 50);
		Employee e5 = new Employee(5, "EX", 80, 90);
		
		Stream.of(e1,e2,e3,e4,e5)
		.map(e -> { e.marks += (e.marks < 40) ? 5 : 0; return e; })
		.sorted((ea, eb) -> ea.marks - eb.marks)
		.forEach(e -> System.out.println(e.id + " " + e.name));
	}
}

