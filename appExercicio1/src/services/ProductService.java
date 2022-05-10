package services;

import java.util.List;

import entities.Product;

public class ProductService {
	
	public double average(List<Product> list) {
		double average = 0;
			for(Product p: list) {
				average+=p.getPrice();
			}
		
		return average/list.size();
	}
}
