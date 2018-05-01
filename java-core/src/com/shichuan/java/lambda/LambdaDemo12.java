package com.shichuan.java.lambda;

import java.util.stream.Stream;

/**
 * Print name of employees who are less than 25 years
 * old and scored more than 40 marks
 */
public class LambdaDemo12 {
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
		Employee e4 = new Employee(4, "VX", 20, 50);
		Employee e5 = new Employee(5, "EX", 80, 90);
		
		Stream.of(e1,e2,e3,e4,e5)
		.filter(e -> e.age < 25)
		.filter(e -> e.marks > 40)
		.map(e -> { e.marks += (e.marks < 40) ? 5 : 0; return e; })
		.sorted((ea, eb) -> ea.marks - eb.marks)
		.forEach(e -> System.out.println(e.id + " " + e.name + " " + e.marks));
	}
}

