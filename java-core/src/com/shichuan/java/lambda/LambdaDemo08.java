package com.shichuan.java.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Print the product that its price is less than 1000.0
 */
public class LambdaDemo08 {

	public static void main(String[] args) {
		Product p1 = new Product(12, 3411.2f,"Test1");
		Product p2 = new Product(13, 145.2f,"Test2");
		Product p3 = new Product(14, 4444.2f,"Test3");
		Product p4 = new Product(15, 533.2f,"Test4");
		Product p5 = new Product(16, 144.2f,"Test5");
		
		List<Product> list = Arrays.asList(p1,p2,p3,p4,p5);

		list.stream()
		.filter(o -> o.price < 1000f)
		.forEach(o -> System.out.println(o.name + " " + o.price));
	}

}

class Product {
	int prodId;
	float price;
	String name;
	Product(int id, float p, String n) {
		prodId = id;
		price = p;
		name = n;
	}
}