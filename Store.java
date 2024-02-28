import java.util.*;

public class Store {
	private Map<Integer,Product> inventory;
	private static int currID = 1000;

	Store() {
		inventory = new HashMap<Integer,Product>();
	}

	public void addStock(int productID, int stock) {
		if (inventory.containsKey(productID)) {
			Product item = inventory.get(productID);
			item.addStock(stock);
		}
		else {
			System.out.println("Product not found in inventory!\nPlease add necessary details");
			double cost;
			String name;
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter name of product: ");
			name = sc.nextLine();
			System.out.print("Enter cost of product: ");
			cost = sc.nextDouble();
			sc.nextLine();

			Product item = new Product(name,stock,cost,currID);
			inventory.put(currID,item);
			currID++;	
		}
	}
	
	public void displayStock() {
		for (Product item: inventory.values()) {
			item.printDetails();
		}	
	}

	public static void main(String args[]) {
		Store manager = new Store();
		Scanner sc = new Scanner(System.in);
		int option = 1;
		while (option >= 1 && option <= 2) {
			System.out.println(
				"INVENTORY MANAGEMENT SYSTEM");	
			System.out.println(
				"1. Add Stock");
			System.out.println(
				"2. View Current Inventory");
			System.out.println("Enter option: ");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
				case 1:
					int productID, stock;
					System.out.print("Enter product ID: ");
					productID = sc.nextInt();
					sc.nextLine();
					stock = sc.nextInt();
					sc.nextLine();
					manager.addStock(productID, stock);
				case 2:
					manager.displayStock();		
			}
		}
	}
}						
