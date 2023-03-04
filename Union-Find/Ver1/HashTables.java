package Ver1;
/**
 * A Hashtable is a data structure that implements an associative array abstract data type, a 
 * structure that can map keys to values. A hashtable uses a hash function to compute an index
 * into an array of buckets or slots, from which the desired value can be found. The hash 
 * function takes the input (i.e. the key), and returns an integer that is used as the index in an
 * array to locate the corresponding value. The idea is to distribute the keys uniformly across
 * an array, such that each bucket contains roughly the same number of elements. The keys are
 * unique, and so the hashtable provides an efficient way to look up a value based on its key.
 * 
 * The class can perform 4 operations, which are Add New Key, Display, Search, and Delete.
 *
 * @class HashTable
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * @see Main
 */

public class HashTables {
	// Class fields
	private Node[] hashTable;
	private int size;

	// Constructor
	public HashTables(int size) {
		this.size = size;
		this.hashTable = new Node[size];
	}

	// Methods
	/**
	 * The hash function to be used (hk = k modulo 20).
	 * 
	 * @param Integer key The key to be inserted into the table.
	 * @return Integer key % size The computed hash of the key.
	 */
	private int hashFunction(int key) {
		return key % size;
	}

	/**
	 * The AddNewKey method simply inserts a new key into the hash table. We used
	 * linear probing to resolve collision, to implement linear probing we
	 * used a while-loop that iterates whenever the cell is occupied, it will 
	 * set a value if that index is empty. We initialized an integer named temp
	 * that indicates as a pointer in order to track if it already loops all elements
	 * in the array and avoid boundless iteration.
	 * 
	 * @param Integer key The key to be inserted into the table.
	 */
	public void AddNewKey(int key) {
		int index = hashFunction(key);
		int temp = hashFunction(key);

		// Use linear probing to handle collision.
		while (hashTable[index] != null) {
			if (hashTable[index].getData() == key) {
				System.out.println("\nKey already exists in the hash table.");
				return;
			}
			
			// Compute the next index.
			index = (index + 1) % size;

			// Check if the hash table is full.
			if (index == temp) {
				System.out.println("\nHash table is full.");
				return;
			}
		}

		// Insert key into hash table if index is empty.
		hashTable[index] = new Node(key);

	}

	/**
	 * The Search method accepts a key and searches its index given by the 
	 * hashFunction method in the hash table. We used while-loop to find the
	 * given key. If the loop finds an empty cell, then it will be terminated 
	 * and prompt key not found. If the key is found, then it will display the 
	 * key and its index. We initialized an integer named temp that indicates
	 * as a pointer in order to track if it already loops all elements in
	 * the array and avoid boundless iteration.
	 * 
	 * @param Integer key The key to be searched within the table.
	 */
	public boolean Search(int key) {
		int index = hashFunction(key);
		int temp = hashFunction(key);

		while (hashTable[index] != null) {
			if (hashTable[index].getData() == key) {
				System.out.println("\nKey found: " + hashTable[index] + " at index " + index);
				return true; // Key has been found.
			}

			// Compute the next index.
			index = (index + 1) % size;
			
			//Break Point.
			if (index == temp) {
				System.out.println("\nKey not found.");
				break; // Key has not been found.
			}
		}
		System.out.println("\nKey not found.");
		return false;
	}
}