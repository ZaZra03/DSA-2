public class HashTable {
    private String[] hashTable;
    private int size;
	
    public HashTable(int size) {
        this.size = size;
        this.hashTable = new String[size];
    }

    // Hash function h(k) = k modulo 20
    private int hashFunction(int key) {
    	return key % size;
    }

    // Inserts a new key into the hash table
    public void addNewKey(int key) {
        int index = hashFunction(key);
        int temp = hashFunction(key);
        System.out.println("Computed hash: " + index);

        // Linear probing to resolve collision
        while (hashTable[index] != null) {
            index = (index + 1) % size;
            if(index == temp) {
            	System.out.println("Error: Hash table is full.");
            	break;
            }
        }

        if (hashTable[index] == null) {
        	hashTable[index] = Integer.toString(key);
            System.out.println("Key inserted at index " + index);
        }
    }

    // Displays the hash table
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + hashTable[i]);
        }
    }

    // Searches for a key in the hash table
	public void search(int key) {
		int index = hashFunction(key);
		int temp = hashFunction(key);

		// Linear probing to resolve collision
		if (Integer.parseInt(hashTable[index]) == key) {
			System.out.println("\nKey found...");
			System.out.println("Key: " + hashTable[index]);
			System.out.println("Key's Index: " + index);
		} else {
			while (hashTable[index] != null) {
				index = (index + 1) % size;
				if (index == temp) {
					System.out.println("Error: Key not found.");
					break;
				} else if(Integer.parseInt(hashTable[index]) == key) {
					System.out.println("\nKey found...");
					System.out.println("Key: " + hashTable[index]);
					System.out.println("Key's Index: " + index);
				}
			}
		}
	}

    // Deletes a key from the hash table
	public void delete(int key) {
		int index = hashFunction(key);
		int temp = hashFunction(key);

		// Linear probing to resolve collision
		if (Integer.parseInt(hashTable[index]) == key) {
			hashTable[index] = null;
		} else {
			while (hashTable[index] != null) {
				index = (index + 1) % size;
				if (index == temp) {
					System.out.println("Error: Key not found.");
					break;
				} else if(Integer.parseInt(hashTable[index]) == key) {
					System.out.println("Key deleted.");
					hashTable[index] = null;
				}
			}
		}

	}
}
