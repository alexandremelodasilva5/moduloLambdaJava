package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import entities.MyComparator;
import entities.Product;
import util.ProductPredicate;

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
		
	
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		Predicate<Product> pred = p -> p.getPrice() >= 100;
		
		//list.removeIf(p->p.getPrice()>100.0);
		//list.removeIf(new ProductPredicate());
		//list.removeIf(Product::staticProductPredicate);
		//list.removeIf(Product::nonStaticProductPredicate);
		list.removeIf(pred);
		for(Product p:list) {
			System.out.println(p);
		}
	}

}
