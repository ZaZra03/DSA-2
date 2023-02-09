package Week2;

public class HashTable {
    private LinkedList[] hashTable;

    private int size;


    public HashTable(int size) {
        this.size = size;
        this.hashTable = new LinkedList[size];
    }

    // Hash function h(k) = k modulo 20
    private int hashFunction(int key) {
    	return key % size;
    }

    // Inserts a new key into the hash table
    public void addNewKey(int key) {
        int index = hashFunction(key);
        System.out.println("Computed hash: " + index);
        
        if(hashTable[index] == null) {
            hashTable[index] = new LinkedList();
            hashTable[index].addNode(new Node(key));
            
        } else hashTable[index].addNode(new Node(key));
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


	}

    // Deletes a key from the hash table
	public void delete(int key) {
		int index = hashFunction(key);
		int temp = hashFunction(key);


	}
}
