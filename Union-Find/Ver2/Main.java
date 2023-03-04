import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Main class contains the main method for the UnionFind program. It handles
 * user input for adding nodes to a set and performing Union and Find operations
 * on the set using the UnionFind class.
 * 
 * @class Main
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Mark Cedrick De Vera
 * 
 * @see Node
 * @see UnionFind
 * @see LinkedList
 */
public class Main {

	/**
	 * The main method prompts the user to enter 10 numbers to form a set, then
	 * handles user input to perform Union and Find operations on the set using the
	 * UnionFind class.
	 * 
	 * @param args The command line arguments, not used in this program.
	 * @throws IOException if an I/O error occurs.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 10 numbers to form a set:");
		UnionFind u = new UnionFind(10);
		int numCount = 0;

		while (numCount < 10) {
			try {
				int x = Integer.parseInt(in.readLine());
				u.addNode(new Node(x)); // add each number to the set
				numCount++;
			} catch (NumberFormatException e) {
				System.out.println("\nInput must be an integer.");
			}
		}

		while (true) {
			System.out.println("\nMenu");
			System.out.println("1. Union");
			System.out.println("2. Find");
			System.out.println("3. Exit");
			System.out.print("\n>> ");

			try {
				int choice = Integer.parseInt(in.readLine());
				int x, y;
				Node first, second;

				switch (choice) {
				case 1:
					System.out.print("\nEnter first number for Union operation: ");
					x = Integer.parseInt(in.readLine());
					first = new Node(x);

					if (!u.findNode(first)) {
						System.out.println("\nERROR! That number is not part of the set. Please try again!\n");
						break;
					}

					System.out.print("\nEnter second number for Union operation: ");
					y = Integer.parseInt(in.readLine());
					second = new Node(y);

					if (!u.findNode(second)) {
						System.out.println("\nERROR! That number is not part of the set. Please try again!\n");
						break;
					}

					u.union(u.findNode(x), u.findNode(y));
					break;
				case 2:
					System.out.print("\nEnter first number for Find operation: ");
					x = Integer.parseInt(in.readLine());
					first = new Node(x);

					if (!u.findNode(first)) {
						System.out.println("\nERROR! That number is not part of the set. Please try again!\n");
						break;
					}

					System.out.print("\nEnter second number for Find operation: ");
					y = Integer.parseInt(in.readLine());
					second = new Node(y);

					if (!u.findNode(second)) {
						System.out.println("\nERROR! That number is not part of the set. Please try again!\n");
						break;
					}

					if (u.connected(u.findNode(x), u.findNode(y)) == true) {
						System.out.println("\nThe two numbers are connected!");
					} else {
						System.out.println("\nThe two numbers are not connected!");
					}

					break;
				case 3:
					System.out.println("\nEnd of program...\n");
					in.close();
					return;
				default:
					System.out.println("\nInvalid choice. Please try again!");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("\nInput must be an integer.");
			}
		}
	}
}
