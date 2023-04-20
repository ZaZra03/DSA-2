package persistent_linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		LinkedList list = new LinkedList();
		
		int value;

		while (true) {
			// Display menu options.
			System.out.println("MENU");
			System.out.println("\n[1] Add Node");
			System.out.println("[2] Delete Node");
			System.out.println("[3] Display");
			System.out.println("[4] Change Value");
			System.out.println("[5] Node History");
			System.out.println("[6] List History");
			System.out.println("[7] Exit");
			System.out.print("\n>> ");
			try {
				// Read user input.
				int choice = Integer.parseInt(in.readLine());
				System.out.println();

				// Execute the selected menu option.
				switch (choice) {
				case 1: // Add Node
					System.out.print("Enter a value: ");
					value = Integer.parseInt(in.readLine());
					list.addNode(new Node(value));
					break;
				case 2: // Delete Node
					System.out.print("Enter node position: ");
					value = Integer.parseInt(in.readLine());
					if(value > 0 && value < list.getSize()+1) {
						list.deleteNode(value);
					} else System.out.println("Invalid Position.");
					break;
				case 3: // Display List
					list.displayList();
					break;
				case 4: // Change Value
					break;
				case 5: // Node History
					break;
				case 6: // List History
					break;
				case 7: // Exit
					System.out.print("\nProgram will be terminated");
					for (int i = 0; i < 3; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
					System.out.print("\nProgram terminated.");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice!\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("\nInput must be an integer.\n");
			}
		}

	}
}
