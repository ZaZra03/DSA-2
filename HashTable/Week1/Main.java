import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Main class to implement menu-driven hash table program.
public class Main {
	public static void main(String[] args) throws IOException {
		// Initialize hash table with size 20.
		HashTable hashTable = new HashTable(20);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// Loop until user chooses to exit.
		while (true) {
			
			// Display menu options.
			System.out.println("\n1. Add New Key");
			System.out.println("2. Display Hash Table");
			System.out.println("3. Search");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			System.out.print("\n>> ");

			// Perform action based on user choice.
			try {
				int choice = Integer.parseInt(in.readLine());
				System.out.println();

				switch (choice) {
				case 1: // Add new key.
					System.out.print("Enter a key: ");
					int key = Integer.parseInt(in.readLine());

					if (key < 0) {
						System.out.println("\nKey should be a positive integer value.");
						break;
					}

					hashTable.AddNewKey(key);
					break;
				case 2: // Display hash table.
					hashTable.Display();
					break;
				case 3: // Search for key.
					System.out.print("Enter a key to search: ");
					key = Integer.parseInt(in.readLine());

					if (key < 0) {
						System.out.println("\nKey should be a positive integer value.");
						break;
					}

					hashTable.Search(key);
					break;
				case 4: // Delete key.
					System.out.print("Enter a key to delete: ");
					key = Integer.parseInt(in.readLine());

					if (key < 0) {
						System.out.println("\nKey should be a positive integer value.");
						break;
					}

					hashTable.Delete(key);
					break;
				case 5: // Exit program.
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice!");
				}
			} catch (NumberFormatException e) {
				System.out.println("\nInput must be an integer.");
			}
		}
	}
}
