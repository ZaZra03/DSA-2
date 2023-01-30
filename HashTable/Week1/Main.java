import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Main class that implements a menu-driven hash table program.
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Initialize hash table with size 20.
		HashTable hashTable = new HashTable(20);
		// Buffered reader for user input.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// Loop until user chooses to exit.
		while (true) {
			try {
				// Display menu options.
				System.out.println("\n1. Add New Key");
				System.out.println("2. Display Hash Table");
				System.out.println("3. Search");
				System.out.println("4. Delete");
				System.out.println("5. Exit");
				System.out.print("\n>> ");
				int choice = Integer.parseInt(in.readLine());
				System.out.println();

				// Perform action based on user choice.
				switch (choice) {
				case 1: // Add new key.
					System.out.print("Enter a key: ");
					int key = Integer.parseInt(in.readLine());

					// Check if key is positive.
					if (key < 0)
						System.out.println("\nKey should be a positive integer value.");

					hashTable.AddNewKey(key);
					break;
				case 2: // Display hash table.
					hashTable.Display();
					break;
				case 3: // Search for a key.
					System.out.print("Enter a key to search: ");
					key = Integer.parseInt(in.readLine());

					if (key < 0)
						System.out.println("\nKey should be a positive integer value.");

					hashTable.Search(key);
					break;
				case 4: // Delete a key.
					System.out.print("Enter a key to delete: ");
					key = Integer.parseInt(in.readLine());

					if (key < 0)
						System.out.println("\nKey should be a positive integer value.");

					hashTable.Delete(key);
					break;
				case 5: // Exit program.
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice!");
				}
			} catch (NumberFormatException e) {
				System.out.println("\nError: Input must be an integer.");
			}
		}
	}
}
