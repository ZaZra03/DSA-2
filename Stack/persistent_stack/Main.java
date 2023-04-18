
/**
 * The Main class contains the main method and provides a menu for the user to
 * interact with a stack data structure. The user can choose to push a new node
 * onto the stack, pop a node from the stack, view the history of the stack, or
 * exit the program.
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
 * @see Node
 * @see Stack
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/**
	 * The main method of the program.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
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
				case 1: // Push a Node into the Stack
					System.out.print("Enter an integer number: ");
					value = Integer.parseInt(in.readLine());
					stack1.push(new Node(value), stack2);
					System.out.println("\nThe item was added successfully!");
					System.out.println();
					stack1.displayList();
					System.out.println();
					break;
				case 2: // Pop a Node from the Stack
					if (stack1.getHead() != null) {
						stack1.pop(stack2);
					} else
						System.out.println("Stack is empty.");
					break;
				case 3: // Display the History
					if (stack2.getHead() != null) {
						stack1.displayHistory(stack2);
					} else
						System.out.println("History is empty.");
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
