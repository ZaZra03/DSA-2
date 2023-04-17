package midterm_lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		int value;
		try {
			while (true) {
				// Display menu options.
				System.out.println("MENU");
				System.out.println("\n[1] Push");
				System.out.println("\n[2] Pop");
				System.out.println("\n[3] History");
				System.out.println("\n[4] Exit");
				System.out.print("\n>> ");

				// Read user input.
				int choice = Integer.parseInt(in.readLine());
				System.out.println();

				// Execute the selected menu option.
				switch (choice) {
				case 1: // Add Node to Stack
					System.out.print("\nEnter an integer number: ");
					value = Integer.parseInt(in.readLine());
					
					break;

				case 2: //Delete Node to Stack
					break;

				case 3: // Display the History
					break;

				case 4: // Exit
					System.out.print("\nProgram will be terminated");
					for (int i = 0; i < 3; i++) {
						Thread.sleep(1000);
						System.out.print(".");
					}
					System.out.print("\nProgram terminated.");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice!");
				}
			}

		} catch (NumberFormatException e) {
			System.out.println("\nInput must be an integer.");
		} 
	}
}
