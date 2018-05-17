package com.shichuan.java.lambda;

import java.util.stream.Stream;

/**
 * Print employees whose marks are greater than 90,
 * sort the result by employee ID
 */
public class LambdaDemo10 {
	
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
		Employee e2 = new Employee(2, "RX", 30, 40);
		Employee e3 = new Employee(3, "CX", 10, 10);
		Employee e4 = new Employee(4, "VX", 70, 94);
		Employee e5 = new Employee(5, "EX", 80, 98);
		
		// Sol1
		Stream.of(e1,e2,e3,e4,e5)
		.filter(e -> e.marks > 90)
		.sorted((ea, eb) -> ea.id - eb.id)
		.forEach(e -> System.out.println(e.id + " " + e.name));
	}

}
