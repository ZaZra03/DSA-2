package Week2;

public class HashTable {
    private LinkedList[] hashTable;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.hashTable = new LinkedList[size];
    }

    // Hash function h(k) = k modulo 10
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
            System.out.print("Index " + i + ": ");
            if(hashTable[i] == null) {
            	System.out.println("EMPTY");
            } else hashTable[i].displayList();
            
        }
    }

    // Searches for a key in the hash table
	public void search(int key) {
		int index = hashFunction(key);
		
		if(hashTable[index] == null) {
            System.out.println("Cell is still empty.");
            
        } else {
        	if(hashTable[index].search(new Node(key))) {
        		System.out.println(key + " is present at index " + index);
        	} else System.out.println("Key does not exist.");
        } 
	}

    // Deletes a key from the hash table
	public void delete(int key) {
		int index = hashFunction(key);

		if(hashTable[index] == null) {
            System.out.println("Cell is still empty.");
            
        } else {
        	if(hashTable[index].search(new Node(key))) {
        		hashTable[index].deleteNode(new Node(key));
        		if(hashTable[index].getHead() == null) hashTable[index] = null;
        	} else System.out.println("Key does not exist.");
        } 
	}
}
