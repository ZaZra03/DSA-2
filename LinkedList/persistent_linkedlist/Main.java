
/**
 * The Main class contains the main method. It uses the LinkedList class to
 * create a menu-driven program for managing a linked list. The program allows
 * the user to add and delete nodes, display the list, change the value of a
 * node, and view the history of the list.
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
 * @see LinkedList
 * @see Node
 * @see Array
 */
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
			System.out.println("-MENU-");
			System.out.println("[1] Add Node");
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
					if (value > 0 && value < list.getSize() + 1) {
						list.deleteNode(value);
					} else
						System.out.println("Invalid Position.\n");
					break;
				case 3: // Display List
					list.displayList();
					break;
				case 4: // Change Value
					System.out.print("Enter node position: ");
					int index = Integer.parseInt(in.readLine());
					if (index > 0 && index < list.getSize() + 1) {
						System.out.println(
								"Current value of node " + index + " is " + list.showCurrentValue(index) + ".");
						System.out.println();
						System.out.print("Enter new value for node " + index + ": ");
						value = Integer.parseInt(in.readLine());
						list.changeValue(new Node(value), index);
						System.out.println("Node value has been modified successfully!\n");
					} else
						System.out.println("Invalid Position.");
					break;
				case 5: // Node History
					System.out.print("Enter node position: ");
					value = Integer.parseInt(in.readLine());
					if (value > 0 && value < list.getSize() + 1) {
						System.out.println();
						System.out.println(
								"Current value of node " + value + " is " + list.showCurrentValue(value) + ".");
						System.out.print("Previous values of node " + value + " are "
								+ list.nodeHistory(list.currentNode(value)));
						System.out.println("\n");
					} else
						System.out.println("Invalid Position.");
					break;
				case 6: // List History
					list.displayHistory();
					break;
				case 7: // Exit
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
				System.out.println("\nInvalid input.\n");
			}
		}

	}
}
