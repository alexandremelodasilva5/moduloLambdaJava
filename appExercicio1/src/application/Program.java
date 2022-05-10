package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;
import services.ProductService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter full file path: ");
		String path = sc.nextLine();


		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Double price = Double.parseDouble(fields[1]);
				Product product = new Product(name, price);
				list.add(product);
				line = br.readLine();
			}

			ProductService ps = new ProductService();
			double average = ps.average(list);
			List<Product> pricesUnderAverage = list.stream().filter(p -> p.getPrice() < average)
			.collect(Collectors.toList());
			pricesUnderAverage.sort((p1, p2) -> p2.getName().toUpperCase().compareTo(p1.getName().toUpperCase()));
			
			System.out.printf("Average price: %.2f%n", average);
			for (Product p : pricesUnderAverage) {
				System.out.println(p.getName());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
