
public class HashTable {
	// Class fields
	private String[] hashTable;
	private int size;

	// Constructors
	public HashTable(int size) {
		this.size = size;
		this.hashTable = new String[size];
	}

	// Methods

	/**
	 * The hash function to be used (hk = k modulo 20).
	 * 
	 * @param key the key to be inserted into the table.
	 * @return key % size the computed hash of the key.
	 */
	private int hashFunction(int key) {
		return key % size;
	}

	/**
	 * Inserts a new key into the hash table.
	 * 
	 * @param key the key to be inserted into the table.
	 */
	public void AddNewKey(int key) {
		int index = hashFunction(key);
		int temp = hashFunction(key);

		// Use linear probing to handle collision.
		while (hashTable[index] != null) {
			if (Integer.parseInt(hashTable[index]) == key) {
				System.out.println("\nKey already exists in the hash table.");
				return;
			}
			index = (index + 1) % size;

			// Check if the hash table is full.
			if (index == temp) {
				System.out.println("\nHash table is full.");
				return;
			}
		}

		// Insert key into hash table if index is empty.
		hashTable[index] = Integer.toString(key);
		System.out.println("\nKey inserted at index " + index);
	}

	/**
	 * Displays the contents of the hash table
	 */
	public void Display() {
		for (int i = 0; i < size; i++) {
			System.out.println("Index " + i + ": " + hashTable[i]);
		}
	}

	/**
	 * Searches for a key in the hash table
	 * 
	 * @param key the key to be searched within the table.
	 */
	public void Search(int key) {
		int index = hashFunction(key);
		int temp = index;

		// Loop until an empty cell is found.
		while (hashTable[index] != null) {
			if (Integer.parseInt(hashTable[index]) == key) {
				System.out.println("\nKey found: " + hashTable[index] + " at index " + index);
				return; // Key has been found.
			}

			// Compute the next index.
			index = (index + 1) % size;
			if (index == temp) {
				System.out.println("\nKey not found.");
				return; // Key has not been found.
			}
		}
		System.out.println("\nKey not found.");
	}

	/**
	 * Deletes a key from the hash table
	 * 
	 * @param key the key to be deleted from the table.
	 */
	public void Delete(int key) {
		int index = hashFunction(key);
		int temp = index;

		// Loop until an empty cell is found.
		while (hashTable[index] != null) {
			if (Integer.parseInt(hashTable[index]) == key) {
				System.out.println("\nDeleted key " + key + " at index " + index + ".");
				hashTable[index] = null;
				return; // Key is found and deleted from the table.
			}
			index = (index + 1) % size;
			if (index == temp) {
				System.out.println("\nKey " + key + " not found.");
				return; // Key is not found.
			}
		}
		System.out.println("\nKey " + key + " not found.");
	}
}
