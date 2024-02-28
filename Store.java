import java.util.*;

public class Store {
	private Map<Integer,Product> inventory;

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

			Product item = new Product(name,stock,cost,productID);
			inventory.put(productID,item);	
		}
	}
	
	public void displayStock() {
		for (Product item: inventory.values()) {
			item.printDetails();
			System.out.println();
		}	
	}

	public void purchaseProduct(int productID, int stock) {
		if (!inventory.containsKey(productID)) {
			System.out.println("Product not found!");
			return;
		}

		Product item = inventory.get(productID);
		item.makePurchase(stock);
	}

	public static void main(String args[]) {
		Store manager = new Store();
		Scanner sc = new Scanner(System.in);
		int option = 1, productID, stock;;
		while (option >= 1 && option <= 3) {
			System.out.println(
				"INVENTORY MANAGEMENT SYSTEM");	
			System.out.println(
				"1. Add Stock");
			System.out.println(
				"2. View Current Inventory");
			System.out.println(
				"3. Make Purchase");
			System.out.print("Enter option: ");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
				case 1:
					System.out.print("Enter product ID: ");
					productID = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter stock to add: ");
					stock = sc.nextInt();
					sc.nextLine();
					manager.addStock(productID, stock);
					break;
				case 2:
					manager.displayStock();		
					break;
				case 3:	
					System.out.print("Enter product ID: ");
					productID = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter stock to buy: ");
					stock = sc.nextInt();
					sc.nextLine();	
					manager.purchaseProduct(productID,stock);
				default:
					break;
			}
			System.out.println();
		}
	}
}						
