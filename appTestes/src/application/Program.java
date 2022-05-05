package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.MyComparator;
import entities.Product;

public class Program {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		Product prod1 = new Product("TV", 1000.0);
		Product prod2 = new Product("Note", 3000.0);
		Product prod3 = new Product("tablet", 2000.0);
		list.add(prod3);
		list.add(prod2);
		list.add(prod1);
		
		/*Comparator<Product> comp = new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
		}*/
		
		
		list.sort((p1,p2) ->  p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		
		for(Product p:list) {
			System.out.println(p);
		}
	}

}
