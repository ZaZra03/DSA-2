
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Main class is the entry point of the Java program. It contains methods
 * for an inventory and sales management system. The program prompts the user to
 * select a system to use: either the Inventory Module System or the Sales
 * Module System. The inventory system allows users to display items, add new
 * items, and replenish stock. The sales system enables users to display items,
 * transact orders, and generate reports. The program continuously loops until
 * the user chooses to exit. It utilizes a BufferedReader to read user input
 * from the console and various arrays to store items and transactions. The
 * class also includes utility methods for displaying items and checking if a
 * string can be parsed as an integer.
 *
 * @class Main
 *
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Array
 * @see Item
 * @see Transaction
 */
public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static Array<Item> item = new Array<Item>(10);
	static Array<Transaction> order = new Array<Transaction>(10);
	static int response;
	static int itemIDCounter = 1;
	static int transactionIDCounter = 1;

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		while (true) {
			try {
				System.out.println("Select a system you want to use: ");
				System.out.println("[1] Inventory Module System");
				System.out.println("[2] Sales Module System");
				System.out.println("[3] Exit\n");
				System.out.print(">> ");
				response = Integer.parseInt(in.readLine());

				switch (response) {
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

			} catch (Exception e) {
				System.out.println("Invalid Input. Please try again.");
			}
		}
	}

	/**
	 * This method represents the Inventory System. It allows the user to perform
	 * various operations related to the inventory.
	 *
	 * @throws NumberFormatException if an invalid number format is entered
	 * @throws IOException           if an I/O error occurs
	 * @throws InterruptedException  if the thread is interrupted
	 */
	private static void InventorySystem() throws NumberFormatException, IOException, InterruptedException {
		while (true) {
			try {
				System.out.println("\nSelect which Inventory System operations you want to use: ");
				System.out.println("[1] Display Items");
				System.out.println("[2] Add New Item");
				System.out.println("[3] Replenish Stock");
				System.out.println("[4] Exit\n");
				System.out.print(">> ");
				response = Integer.parseInt(in.readLine());

				switch (response) {
				case 1: // Display Items
					DisplayItems(item);
					continue;
				case 2: // Add New Items
					System.out.print("\nEnter description of the new item: ");
					String itemName = in.readLine();

					// If input is blank
					if (itemName.isBlank()) {
						throw new Exception();
					}

					System.out.print("Enter price of the new item: ");
					String itemPrice = in.readLine();

					// If input is blank
					if (itemPrice.isBlank()) {
						throw new Exception();
					}

					// If input is not a number
					if (!isInteger(itemPrice)) {
						throw new Exception();
					}

					System.out.print("Enter initial stock: ");
					String itemStock = in.readLine();

					// If input is blank
					if (itemStock.isBlank()) {
						throw new Exception();
					}

					// If input is not a number
					if (!isInteger(itemStock)) {
						throw new Exception();
					}

					// Display a success message and add the new item to the item array
					System.out.println("The new item has been added successfully!");
					item.addObject(new Item(itemIDCounter, Integer.parseInt(itemPrice), Integer.parseInt(itemStock),
							itemName));
					itemIDCounter++;
					DisplayItems(item);
					continue;
				case 3: // Replenish Stock
					// Get the first item in the array
					Item temp = (Item) item.getArray()[0];

					// Check if there are any items available
					if (temp != null) {
						DisplayItems(item);
						System.out.print("\nSelect an item by entering its ID: ");
						String itemID = in.readLine();

						// If input is blank
						if (itemID.isBlank()) {
							throw new Exception();
						}

						// If input is 0, which means that the item does not exist
						if (Integer.parseInt(itemID) == 0) {
							System.out.println("\nItem does not exist.");
							continue;
						}

						// If input is not a number
						if (!isInteger(itemID)) {
							throw new Exception();
						}

						// Retrieve the corresponding item from the array based on the entered ID
						Item currentItem = (Item) item.getArray()[Integer.parseInt(itemID) - 1];

						// If currentItem is null, which means that the item does not exist
						if (currentItem == null)
							System.out.println("\nItem does not exist.");
						else {
							System.out.print("Number of stocks to be added: ");
							String stocksAdded = in.readLine();

							// If input is not a number
							if (!isInteger(stocksAdded)) {
								throw new Exception();
							}

							// Update the stock of the currentItem and display a success message
							currentItem.setItemStock(currentItem.getItemStock() + Integer.parseInt(stocksAdded));
							System.out.println("Update successful!");
						}
					} else
						System.out.println("\nNo items available.");
					continue;
				case 4: // Exit
					System.out.println("Going to Main Menu...\n");
					return;
				default:
					System.out.println("Invalid choice!\n");
				}
			} catch (Exception e) {
				System.out.println("\nInvalid Input. Please try again.");
			}
		}
	}

	/**
	 * This method represents the Sales System. It allows the user to perform
	 * various operations related to sales and transactions.
	 *
	 * @throws NumberFormatException if an invalid number format is entered
	 * @throws IOException           if an I/O error occurs
	 * @throws InterruptedException  if the thread is interrupted
	 */
	private static void SalesSystem() throws NumberFormatException, IOException, InterruptedException {
		while (true) {
			try {
				System.out.println("\nSelect which Sales System operations you want to use: ");
				System.out.println("[1] Display Items");
				System.out.println("[2] Transact Order");
				System.out.println("[3] Generate Report");
				System.out.println("[4] Exit\n");
				System.out.print(">> ");
				response = Integer.parseInt(in.readLine());

				switch (response) {
				case 1: // Display Items
					DisplayItems(item);
					continue;
				case 2: // Transact Order

					// Check if there are any items available
					Item temp = (Item) item.getArray()[0];
					if (temp != null) {
						DisplayItems(item);

						// Print the transaction ID and create new transaction
						System.out.println("\nTransaction ID: " + transactionIDCounter);
						Transaction transaction = new Transaction(transactionIDCounter);
						boolean isFinished = false;
						int total = 0;

						// Continue adding items while not finished
						while (!isFinished) {
							System.out.print("\nEnter Item ID: ");
							String itemID = in.readLine();

							// If input is blank
							if (itemID.isBlank()) {
								throw new Exception();
							}

							// If input is 0, which means the item does not exist
							if (Integer.parseInt(itemID) == 0) {
								throw new Exception();
							}

							// If input is not a number
							if (!isInteger(itemID)) {
								throw new Exception();
							}

							Item currentItem = (Item) item.getArray()[Integer.parseInt(itemID) - 1];
							if (currentItem == null) {
								throw new Exception();
							}

							Item tempItem = new Item(currentItem.getItemID(), currentItem.getItemPrice(),
									currentItem.getItemStock(), currentItem.getItemName());
							Item tempItem2 = (Item) transaction.getRecord().getArray()[tempItem.getItemID() - 1];

							if (tempItem2 != null && tempItem2.getItemID() == tempItem.getItemID()) {
								System.out.println("The item is already in the list. Select another item.");
								break;
							}

							System.out.print("How many " + currentItem.getItemName() + "? ");
							String itemSold = in.readLine();

							if (!isInteger(itemSold)) {
								throw new Exception();
							}

							if (Integer.parseInt(itemSold) > currentItem.getItemStock()
									|| Integer.parseInt(itemSold) <= 0) {
								System.out.println("Cannot proceed to the transaction. Please try again.");
								break;
							}

							tempItem.setItemSold(Integer.parseInt(itemSold));

							// Update the currentItem stock and calculate the subtotal
							currentItem.setItemStock(currentItem.getItemStock() - Integer.parseInt(itemSold));
							int subtotal = currentItem.getItemPrice() * Integer.parseInt(itemSold);
							tempItem.setItemTotal(subtotal);
							System.out.println("Subtotal: Php " + subtotal);

							// Update transaction details and grand total
							transaction.getRecord().addObject(tempItem);
							order.addObject(transaction);

							total += subtotal;

							// Ask the user if they want to add another item
							System.out.print("Do you wish to add another item y/n? ");
							String answer = in.readLine().toUpperCase();

							switch (answer) {
							case "Y":

								continue;
							case "N":
								System.out.println("\nTotal Price: Php " + total);
								System.out.println("Transaction recorded!");
								transaction.setTransactionTotal(total);
								isFinished = true;
								transactionIDCounter++;
								break;
							default:
								System.out.println("Invalid choice!\n");
							}
						}

					} else
						System.out.println("\nNo items available.");
					continue;
				case 3: // Generate Report
					if (order.getArray()[0] != null) {
						for (int i = 0; i < order.getSize(); i++) {
							if (order.getArray()[i] != null) {
								Transaction temp1 = (Transaction) order.getArray()[i];
								temp1.displayRecords();
							} else
								break;
						}
					} else
						System.out.println("\nNo transactions available.");
					continue;
				case 4: // Exit
					System.out.println("Going to Main Menu...\n");
					return;
				default:
					System.out.println("Invalid choice!\n");
				}
			} catch (Exception e) {
				System.out.println("Invalid Input. Please try again.");
			}
		}
	}

	/**
	 * This method displays the items in the inventory.
	 *
	 * @param items the array of items to display
	 */
	private static void DisplayItems(Array<Item> items) {
		if (items.getArray()[0] != null) {
			System.out.println(
					"\nItem ID                    Description                    Price                    Stock");
			for (int i = 0; i < items.getSize(); i++) {
				if (items.getArray()[i] != null) {
					Item currentItem = (Item) items.getArray()[i];
					System.out.printf("%-26s %-30s %-24s %s%n", currentItem.getItemID(), currentItem.getItemName(),
							currentItem.getItemPrice(), currentItem.getItemStock());
				} else
					break;
			}
		} else
			System.out.println("\nNo items available.");
	}

	/**
	 * This method checks if a given string can be parsed to an integer.
	 *
	 * @param string the string to check
	 * @return true if the string can be parsed to an integer, false otherwise
	 */
	private static boolean isInteger(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
