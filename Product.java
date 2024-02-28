import java.util.*;

public class Product {
	private int id;
	private String name;
	private int stock;
	private double cost;

	Product(String name, int stock , double cost) {
		this.name = name;
		this.stock = stock;
		this.cost = cost;
	}

	public double getCost() {
		return this.cost;
	}

	public int getStock() {
		return this.stock;
	}

	public void printDetails() {
		System.out.println("Product ID: "+this.id);
		System.out.println("Name: "+this.name);
		System.out.println("Stock: "+this.stock);
		System.out.println("Cost: "+this.cost);
	}
}
