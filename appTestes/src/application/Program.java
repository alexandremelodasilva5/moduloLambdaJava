package application;

import java.util.ArrayList;
import java.util.List;

import entities.MyComparator;
import entities.Product;

public class Program {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		Product p1 = new Product("TV", 1000.0);
		Product p2 = new Product("Note", 3000.0);
		Product p3 = new Product("tablet", 2000.0);
		list.add(p3);
		list.add(p2);
		list.add(p1);
		list.sort(new MyComparator());
		
		for(Product p:list) {
			System.out.println(p);
		}
	}

}
