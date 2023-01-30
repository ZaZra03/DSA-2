import java.util.ArrayList;
import java.util.List;

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
		// Calculate index using hash function.
		int index = hashFunction(key);
		int temp = hashFunction(key);

		// Use linear probing to handle collision.
		while (hashTable[index] != null) {
			index = (index + 1) % size;

			// Check if the hash table is full.
			if (index == temp) {
				System.out.println("Error: Hash table is full.");
				break;
			}
		}
		// Insert key into hash table if index is empty.
		if (hashTable[index] == null) {
			hashTable[index] = Integer.toString(key);
			System.out.println("Key inserted at index " + index);
		}
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
		List<Integer> indices = new ArrayList<>();

		// Loop to find all indices of the key in hash table.
		while (hashTable[index] != null) {
			if (Integer.parseInt(hashTable[index]) == key) {
				indices.add(index);
			}
			index = (index + 1) % size;
			if (index == temp) {
				break;
			}
		}

		// If the key is not found.
		if (indices.isEmpty()) {
			System.out.println("Error: Key not found.");
		} else { // Key is found.
			System.out.println("\nKey found...");
			System.out.println("Key: " + key);
			System.out.println("Key's Indices: " + indices);
		}
	}

	/**
	 * Deletes a key from the hash table
	 * 
	 * @param key the key to be deleted from the table.
	 */
	public void Delete(int key) {
		int index = hashFunction(key);
		int temp = index;
		List<Integer> indices = new ArrayList<>();

		// Find all indices with the same key.
		while (hashTable[index] != null) {
			if (Integer.parseInt(hashTable[index]) == key) {
				indices.add(index);
			}
			index = (index + 1) % size;
			if (index == temp) {
				break;
			}
		}

		// Key not found.
		if (indices.isEmpty()) {
			System.out.println("Error: Key not found.");
			return;
		}

		// Delete key at each index.
		for (int i : indices) {
			hashTable[i] = null;
		}

		System.out.println("\nKey deleted from indices " + indices.toString());
	}
}
