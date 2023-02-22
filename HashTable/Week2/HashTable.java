/**
 * A Hashtable is a data structure that implements an associative array abstract
 * data type, a structure that can map keys to values. A hashtable uses a hash
 * function to compute an index into an array of buckets or slots, from which
 * the desired value can be found. The hash function takes the input (i.e. the
 * key), and returns an integer that is used as the index in an array to locate
 * the corresponding value. The idea is to distribute the keys uniformly across
 * an array, such that each bucket contains roughly the same number of elements.
 * The keys are unique, and so the hashtable provides an efficient way to look
 * up a value based on its key.
 * 
 * This class provides an implementation of a hashtable using an array of linked
 * lists. The size of the hashtable is specified at construction time, and the
 * hash function used is a simple modulo operation. The class provides methods
 * for adding a new key, displaying the hashtable, searching for a key, and
 * deleting a key.
 * 
 * @class HashTable
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Node
 * @see LinkedList
 * @see Main
 */

public class HashTable {
	// Class fields
	private LinkedList[] hashTable;
	private int size;

	// Constructor
	public HashTable(int size) {
		this.size = size;
		this.hashTable = new LinkedList[size];
	}

	// Class methods

	/**
	 * The hash function to be used (hk = k modulo 10).
	 * 
	 * @param Integer key The key to be inserted into the table.
	 * @return Integer key % size The computed hash of the key.
	 */
	private int hashFunction(int key) {
		return key % size;
	}

	/**
	 * The addNewKey method accepts a key and adds it to the hash table. It uses the
	 * hashFunction method to compute the index where the key should be placed. If
	 * the cell is empty, a new linked list is created in the cell and the key is
	 * added as a new node. Otherwise, the key is added to the existing linked list
	 * in the cell.
	 * 
	 * @param key The key to be added to the hash table.
	 */
	public void addNewKey(int key) {
		int index = hashFunction(key);
		System.out.println("Computed hash: " + index);
        
		if(hashTable[index] == null) {
			hashTable[index] = new LinkedList(); hashTable[index].addNode(new Node(key));
            
		} else {
			if(!hashTable[index].search(new Node(key))) {
				hashTable[index].addNode(new Node(key));
			} else System.out.println("Key already existed.");
        	
		}
	}

	/**
	 * The display method displays the contents of the hash table. For each cell in
	 * the hash table, it prints the index of the cell and the keys stored in the
	 * cell's linked list, if any.
	 */
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print("Index " + i + ": ");
			if (hashTable[i] == null) {
				System.out.println("EMPTY");
			} else
				hashTable[i].displayList();

		}
	}

	/**
	 * The search method accepts a key and searches for it in the hash table. It
	 * uses the hashFunction method to compute the index where the key should be
	 * located. If the cell is empty, the method outputs a message that the key was
	 * not found. Otherwise, it searches for the key in the linked list at the cell
	 * and outputs a message indicating whether the key was found and at what index.
	 * 
	 * @param key The key to be searched for in the hash table.
	 */
	public void search(int key) {
		int index = hashFunction(key);

		if (hashTable[index] == null) {
			System.out.println("Cell is still empty.");

		} else {
			if (hashTable[index].search(new Node(key))) {
				System.out.println(key + " is present at index " + index);
			} else
				System.out.println("Key does not exist.");
		}
	}

	/**
	 * The delete method accepts a key and deletes it from the hash table. It uses
	 * the hashFunction method to compute the index where the key should be located.
	 * If the cell is empty, the method outputs a message that the key was not
	 * found. Otherwise, it searches for the key in the linked list at the cell and
	 * deletes it if it is found. If the linked list becomes empty after the key is
	 * deleted, the cell is set to null to indicate that it is empty.
	 * 
	 * @param key The key to be deleted from the hash table.
	 */
	public void delete(int key) {
		int index = hashFunction(key);

		if (hashTable[index] == null) {
			System.out.println("Cell is still empty.");

		} else {
			if (hashTable[index].search(new Node(key))) {
				hashTable[index].deleteNode(new Node(key));
				if (hashTable[index].getHead() == null)
					hashTable[index] = null;
			} else
				System.out.println("Key does not exist.");
		}
	}
}
