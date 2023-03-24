package Week2;


/**
 * This is the main class of the program, which provides a user interface for the
 * HashTable data structure. The HashTable is a data structure that implements an
 * associative array abstract data type, which can map keys to values using a hash
 * function. This program provides an implementation of a hashtable using an array of
 * linked lists. The size of the hashtable is specified at construction time, and the
 * hash function used is a simple modulo operation.
 * The program provides the user with options to add a new key, display the hash table,
 * search for a key, delete a key and exit the program. The program requires user input
 * which is read from the standard input using the BufferedReader class. The program
 * validates that the input is a positive integer value before performing any actions.
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
 * @see HashTable
 * @see Node
 * @see LinkedList
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Initialize a new HashTable with a capacity of 10.
		HashTable hashTable = new HashTable(10);

		// Initialize a BufferedReader to read user input from the console.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// Display a menu and read user input until the user chooses to exit.
		while (true) {
			// Display menu options.
			System.out.println("\n1. Add New Key");
			System.out.println("2. Display Hash Table");
			System.out.println("3. Search");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			System.out.print("\n>> ");

			try {
				// Read user input.
				int choice = Integer.parseInt(in.readLine());
				System.out.println();

				// Execute the selected menu option.
				switch (choice) {
				case 1: // Add New Key
					System.out.print("Enter a key: ");
					int key = Integer.parseInt(in.readLine());
					if (key > 0)
						hashTable.addNewKey(key);
					else
						System.out.println("\nKey should be a positive integer value.");
					break;
				case 2: // Display Hash Table
					hashTable.display();
					break;
				case 3: // Search
					System.out.print("Enter a key to search: ");
					key = Integer.parseInt(in.readLine());
					if (key > 0)
						hashTable.search(key);
					else
						System.out.println("\nKey should be a positive integer value.");
					break;
				case 4: // Delete
					System.out.print("Enter a key to delete: ");
					key = Integer.parseInt(in.readLine());
					if (key > 0)
						hashTable.delete(key);
					else
						System.out.println("\nKey should be a positive integer value.");
					break;
				case 5: // Exit
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
