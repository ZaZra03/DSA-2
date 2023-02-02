/**
 * Hash Table Menu-Driven Program
 * This program implements a program that perform the given hash table
 * operations such as Add New Key, Display, Search, and Delete Key.
 * 
 * The user can perform 5 operations in the menu-driven program and these are the following:
 * 
 * Add New Key - Inserts a new key (a positive integer value) into the hash table. The hash is
 * computed using the hash function h(k) = k mod 20. The computed hash is displayed before
 * inserting the key to the hash table. Perform linear probing to resolve collision and display 
 * the new index assigned to the key. If the hash table is full, do not insert the new key and
 * display an error message.
 * 
 * Display Hash Table - Displays the hash table to the screen. All indices must be displayed
 * with or without keys assigned to it.
 * 
 * Search - Accepts a key and determines whether or not the key is present in the hash table. If
 * found, the index of the key must also be displayed.
 * 
 * Delete - Accepts a key and determines whether or not the key is present in the hash table. If
 * found, remove the key from the hash table.
 *
 * Exit - This simply exits the program.
 *
 * @class Main
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * @see HashTable
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/** 
	 * This is the main method which makes use of displaying the menu 
	 * and calling the methods in the HashTable class.
	 * 
	 * @param args Unused.
	 * @throws IOException If an input or output exception occurred.
	 * @return Nothing.
	 */
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
