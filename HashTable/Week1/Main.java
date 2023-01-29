package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        HashTable hashTable = new HashTable(20);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\n1. Add New Key");
            System.out.println("2. Display Hash Table");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("\n>> ");
            int choice = Integer.parseInt(in.readLine());
            System.out.println();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter a key: ");
                    int key = Integer.parseInt(in.readLine());
                    if(key > 0) hashTable.addNewKey(key);
                    else System.out.println("\nKey should be a positive integer value.");
                    break;
                case 2:
                    hashTable.display();
                    break;
                case 3:
                    System.out.print("Enter a key to search: ");
                    key = Integer.parseInt(in.readLine());
                    if(key > 0) hashTable.search(key);
                    else System.out.println("\nKey should be a positive integer value.");
                    break;
                case 4:
                    System.out.print("Enter a key to delete: ");
                    key = Integer.parseInt(in.readLine());
                    if(key > 0) hashTable.delete(key);
                    else System.out.println("\nKey should be a positive integer value.");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}



