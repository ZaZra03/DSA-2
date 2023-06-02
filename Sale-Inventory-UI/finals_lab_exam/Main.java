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
				System.out.println("Invalid Input. Please try again.");
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
					continue;

				case 2:
					System.out.print("\nEnter description of the new item: ");
					String itemName = in.readLine();
					if(itemName.isBlank()) throw new Exception();
					System.out.print("Enter price of the new item: ");
					String itemPrice = in.readLine();
					if(itemPrice.isBlank()) throw new Exception();
					System.out.print("Enter initial stock: ");
					String itemStock = in.readLine();
					if(itemStock.isBlank()) throw new Exception();
					System.out.println("The new item has been added successfully!");
					item.addObject(new Item(itemIDCounter, Integer.parseInt(itemPrice), Integer.parseInt(itemStock), itemName));
					itemIDCounter++;
					DisplayItems(item);
					continue;

				case 3:
					Item temp = (Item) item.getArray()[0];
					if(temp != null) {
						DisplayItems(item);
						System.out.print("\nSelect an item by entering its ID: ");
						String itemID = in.readLine();
						if(itemID.isBlank()) throw new Exception();
						Item currentItem = (Item) item.getArray()[Integer.parseInt(itemID)-1];
						if(currentItem == null) System.out.println("\nItem does not exist.");
						else {
							System.out.print("Number of stocks to be added: ");
							String stocksAdded = in.readLine();
							currentItem.setItemStock(currentItem.getItemStock() + Integer.parseInt(stocksAdded));
							System.out.println("Update successful!");
						}
					} else System.out.println("\nNo items available.");

					continue;

				case 4:
					System.out.println("Going to Main Menu...\n");
					return;

				default:
					System.out.println("Invalid choice!\n");
				}

			} catch(Exception e) {
				System.out.println("Invalid Input. Please try again.");
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
					DisplayItems(item);
					continue;

				case 2:
					continue;

				case 3:
					continue;

				case 4:
					System.out.println("Going to Main Menu...\n");
					return;

				default:
					System.out.println("Invalid choice!\n");
				}

			} catch(Exception e) {
				System.out.println("Invalid Input. Please try again.\n");
			}
		}
	}

	private static void DisplayItems(Array<Item> items) {
	    if (items.getArray()[0] != null) {
	    	System.out.println("\nItem ID                    Description                    Price                    Stock");
	        for (int i = 0; i < items.getSize(); i++) {
	            if (items.getArray()[i] != null) {
	                Item currentItem = (Item) items.getArray()[i];
	                System.out.printf("%-26s %-30s %-24s %s%n", currentItem.getItemID(), currentItem.getItemName(), currentItem.getItemPrice(), currentItem.getItemStock());
	                // Access other methods of the Item class using currentItem
	                // currentItem.someMethod();
	            }
	        }
	    } else System.out.println("\nNo items available.");
	}

}
