public class HashTable {
    int[] table;
    int size;

    public HashTable(int size) {
        this.size = size;
        table = new int[size];
    }

    // Hash function h(k) = k mod 20
    public int hash(int key) {
        return key % 20;
    }

    // Inserts a new key into the hash table
    public void addNewKey(int key) {
        int index = hash(key);
        System.out.println("Computed hash: " + index);

        // Linear probing to resolve collision
        while (table[index] != 0) {
            index = (index + 1) % size;
        }

        if (table[index] == 0) {
            table[index] = key;
            System.out.println("Key inserted at index " + index);
        } else {
            System.out.println("Error: Hash table is full");
        }
    }

    // Displays the hash table
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + table[i]);
        }
    }

    // Searches for a key in the hash table
    public void search(int key) {
        int index = hash(key);

        // Linear probing to resolve collision
        int i = 0;
        while (table[(index + i) % size] != key && i < size) {
            i++;
        }

        if (i < size) {
            System.out.println("Key found at index " + ((index + i) % size));
        } else {
            System.out.println("Key not found");
        }
    }

    // Deletes a key from the hash table
    public void delete(int key) {
        int index = hash(key);

        // Linear probing to resolve collision
        int i = 0;
        while (table[(index + i) % size] != key && i < size) {
            i++;
        }

        if (i < size) {
            table[(index + i) % size] = 0;
            System.out.println("Key deleted");
        } else {
            System.out.println("Key not found");
        }
    }
   }
