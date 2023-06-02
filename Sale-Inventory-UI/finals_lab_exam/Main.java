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
				System.out.println("\nSelect which Inventory System operations you want to use: ");
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
						if(itemID.isBlank() ) throw new Exception();
						if(Integer.parseInt(itemID) == 0) {
							System.out.println("\nItem does not exist.");
							continue;
						}
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
				System.out.println("\nSelect which Sales System operations you want to use: ");
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
					Item temp = (Item) item.getArray()[0];
					if(temp != null) {
						DisplayItems(item);
						System.out.println("\nTransaction ID: " + transactionIDCounter);
						Transaction transaction = new Transaction(transactionIDCounter);
						boolean isFinished = false;
						int total = 0;

						while(!isFinished) {
							System.out.print("\nEnter Item ID: ");
							String itemID = in.readLine();
							if(itemID.isBlank()) throw new Exception();
							
							if(Integer.parseInt(itemID) == 0) {
								System.out.println("\nItem does not exist.");
								continue;
							}
							
							Item currentItem = (Item) item.getArray()[Integer.parseInt(itemID)-1];
							if(currentItem == null) {
								System.out.println("\nItem does not exist.");
								continue;
							} 

							Item tempItem = new Item(currentItem.getItemID(), currentItem.getItemPrice(), currentItem.getItemStock(), currentItem.getItemName());
							Item tempItem2 = (Item) transaction.getRecord().getArray()[tempItem.getItemID()-1];

							if(tempItem2 != null && tempItem2.getItemID() == tempItem.getItemID()) {
								System.out.println("The item is already in the list. Select another item.");
								continue;
							}

							System.out.print("How many " + currentItem.getItemName() + "? ");
							String itemSold = in.readLine();
							
							if(Integer.parseInt(itemSold) > currentItem.getItemStock() || Integer.parseInt(itemSold) <= 0) {
								System.out.println("Cannot proceed to the transaction. Please try again.");
								continue;
							}
							
							tempItem.setItemSold(Integer.parseInt(itemSold));
							currentItem.setItemStock(currentItem.getItemStock() - Integer.parseInt(itemSold));
							int subtotal = currentItem.getItemPrice() * Integer.parseInt(itemSold);
							System.out.println("Subtotal: Php " + subtotal);

							transaction.getRecord().addObject(tempItem);
							order.addObject(transaction);

							total += subtotal;
							System.out.print("Do you wish to add another item y/n? ");
							String answer = in.readLine().toUpperCase();

							switch(answer) {
							case "Y":

								continue;
							case "N":
								System.out.println("\nTotal Price: Php " + total);
								System.out.println("Transaction recorded!");
								isFinished = true;
								break;
							default:
								System.out.println("Invalid choice!\n");
							}
						}

					} else System.out.println("\nNo items available.");
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
				System.out.println("Invalid Input. Please try again.");
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
				}
			}
		} else System.out.println("\nNo items available.");
	}

}
