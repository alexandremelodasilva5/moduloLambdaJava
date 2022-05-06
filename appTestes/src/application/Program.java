package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import entities.MyComparator;
import entities.Product;
import model.services.ProductService;
import util.ProductConsumer;
import util.ProductPredicate;
import util.UpperCaseName;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		Product prod1 = new Product("TV", 1000.0);
		Product prod2 = new Product("Note", 3000.0);
		Product prod3 = new Product("Tablet", 2000.0);
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
		
		//Predicate<Product> pred = p -> p.getPrice() >= 100;
		//list.removeIf(p->p.getPrice()>100.0);
		//list.removeIf(new ProductPredicate());
		//list.removeIf(Product::staticProductPredicate);
		//list.removeIf(Product::nonStaticProductPredicate);
		//list.removeIf(pred);
		
		//Consumer<Product> cons = p ->p.setPrice(p.getPrice()*1.1);
		//list.forEach(new ProductConsumer());
		//list.forEach(Product::staticPriceUpdate);
		//list.forEach(Product::nonStaticPriceUpdate);
		//list.forEach(cons);
		//list.forEach(p ->p.setPrice(p.getPrice()*1.1));
		
		//Function<Product, String> func = p -> p.getName().toUpperCase();
		//List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
		//List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
		//List<String> names = list.stream().map(Product::nonstaticUpperCaseName).collect(Collectors.toList());
		//List<String> names = list.stream().map(func).collect(Collectors.toList());
		List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		ProductService ps = new ProductService();
		
		double sum = ps.filteredSum(list);
		
		
		//list.forEach(System.out::println);
		//names.forEach(System.out::println);
		/*for(Product p:list) {
			System.out.println(p);
		}*/
		System.out.println("Soma:" + String.format("%.2f", sum));
		
		
	}

}
