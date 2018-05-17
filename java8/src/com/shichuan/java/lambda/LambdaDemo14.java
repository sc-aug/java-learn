package com.shichuan.java.lambda;

import java.util.stream.Stream;

/**
 * Employee class: id, name, salary
 * for each employee: tax on the income
 * salary: less than 3000: 10%
 * 3000 and 5000: 20%
 * above 5000: 30%
 * calculate the salary after tax
 * and then find the employee with max salary
 */
public class LambdaDemo14 {

	public static void main(String[] args) {
		
		Employee e1= new Employee (1, "Payal", 6000);
		Employee e2= new Employee (2, "Parul", 4000);
		Employee e3= new Employee (3, "Priya", 2000);
		
		Employee e = Stream.of(e1, e2, e3)
		.map(o -> {
            if (o.salary < 3000) {
                o.salary = o.salary * 0.9;
            } else if (o.salary >= 3000 && o.salary < 5000) {
                o.salary = o.salary * 0.8;
            } else if (o.salary >= 5000) {
                o.salary = o.salary * 0.7;
            }
            return o;
        })
        .max((o1, o2) -> o1.salary - o2.salary < 0 ? -1 : 1).get();
		System.out.println(e);
	}

	static class Employee {
		int id;
		String name;
		double salary;

		public Employee(int id, String name, double s) {
			this.id = id;
			this.name = name;
			this.salary = s;
		}

		@Override
		public String toString() {
			return id + " : " + name + " " + salary;
		}
	}

}


