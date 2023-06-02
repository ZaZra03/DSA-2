package finals_lab_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static Array<Item> item = new Array<Item>(10);
	static Array<Transaction> order = new Array<Transaction>(10);
	static int response;
	static int itemIDCounter = 1;
	static int transactionIDCounter = 1;

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		// TODO Auto-generated method stub

		while(true) {
			try {
				System.out.println("Select a system you want to use: ");
				System.out.println("[1] Inventory Module System");
				System.out.println("[2] Sales Module System");
				System.out.println("[3] Exit\n");
				System.out.print(">> ");
				response = Integer.parseInt(in.readLine());
				System.out.println();

				switch(response) {
				case 1:
					InventorySystem();
					break;

				case 2:
					SalesSystem();
					break;

				case 3:
					System.out.println("Program will be terminated");
					for (int i = 0; i < 3; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
					System.out.println("Program terminated.");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice!\n");
				}

			} catch(Exception e) {
				System.out.println("Invalid Input. Please try again.\n");
			}
		}
	}

	private static void InventorySystem() throws NumberFormatException, IOException, InterruptedException {
		while(true) {
			try {
				System.out.println("\nSelect an operation you want to use: ");
				System.out.println("[1] Display Items");
				System.out.println("[2] Add New Item");
				System.out.println("[3] Replenish Stock");
				System.out.println("[4] Exit\n");
				System.out.print(">> ");
				response = Integer.parseInt(in.readLine());

				switch(response) {
				case 1:
					DisplayItems(item);
					break;

				case 2:
					System.out.print("Enter description of the new item: ");
					String itemName = in.readLine();
					System.out.print("Enter price of the new item: ");
					int itemPrice = Integer.parseInt(in.readLine());
					System.out.print("Enter initial stock: ");
					int itemStock = Integer.parseInt(in.readLine());
					System.out.println("The new item has been added successfully!");
					item.addObject(new Item(itemIDCounter, itemPrice, itemStock, itemName));
					itemIDCounter++;
					break;

				case 3:
					break;

				case 4:
					System.out.println("Program will be terminated");
					for (int i = 0; i < 3; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
					System.out.println("Program terminated.");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice!\n");
				}

			} catch(Exception e) {
				System.out.println("Invalid Input. Please try again.\n");
			}
		}
	}

	private static void SalesSystem() throws NumberFormatException, IOException, InterruptedException {
		while(true) {
			try {
				System.out.println("\nSelect an operation you want to use: ");
				System.out.println("[1] Display Items");
				System.out.println("[2] Transact Order");
				System.out.println("[3] Generate Report");
				System.out.println("[4] Exit\n");
				System.out.print(">> ");
				response = Integer.parseInt(in.readLine());

				switch(response) {
				case 1:
					DisplayItems(order);
					break;

				case 2:
					break;

				case 3:
					break;

				case 4:
					System.out.println("Program will be terminated");
					for (int i = 0; i < 3; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
					System.out.println("Program terminated.");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice!\n");
				}

			} catch(Exception e) {
				System.out.println("Invalid Input. Please try again.\n");
			}
		}
	}
	
//	private static void DisplayItems(Array<?> object) {
//		System.out.println("\nItem ID                    Description                    Price                    Stock");
//		if(object.getArray()[0] != null) {
//			for(int i = 0; i < object.getSize(); i++) {
//				if(object.getArray()[i] == null) break;
//				Object o = object.getArray()[i];
//
//			}
//		}
//	}
	
	private static void DisplayItems(Array<?> object) {
		System.out.println("\nItem ID                    Description                    Price                    Stock");

		for (int i = 0; i < object.getSize(); i++) {
			if(object.getArray()[i] == null) break;
			Object item = object.getArray()[i];
			if (item != null) {
				if (item instanceof Item) {
					Item currentItem = (Item) item;
					// System.out.printf("%-27s %-30s %-23s %s%n", currentItem.getItemID(), currentItem.getItemName(), currentItem.getItemPrice(), currentItem.getItemStock());
					// Access other methods of the Item class using currentItem
					// currentItem.someMethod();
				} else if (item instanceof Transaction) {
					Transaction currentTransaction = (Transaction) item;

					// Access other methods of the Transaction class using currentTransaction
					// currentTransaction.someMethod();
				}
			}
		}
	}

	
	private static void spaceCalculator(String word) {
		int space = 20 - word.length();
		for(int i = 0; i < space; i++) {
			System.out.print(" ");
		}
	}

}
