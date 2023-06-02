package finals_lab_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static Array<Item> item = new Array<Item>(10);
	static Array<Order> order = new Array<Order>(10);
	static int response;

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
					DisplayItems();
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
					DisplayItems();
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
	
	private static void DisplayItems() {
		System.out.println("\nItem ID                    Description                    Price                    Stock");
		if(item.getArray()[0] != null) {
			for(int i = 0; i < item.getSize(); i++) {
				
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
