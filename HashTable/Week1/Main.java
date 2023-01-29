import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        HashTable hashTable = new HashTable(20);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add New Key");
            System.out.println("2. Display Hash Table");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter key: ");
                    int key = scanner.nextInt();
                    hashTable.addNewKey(key);
                    break;
                case 2:
                    hashTable.display();
                    break;
                case 3:
                    System.out.print("\nEnter key to search: ");
                    key = scanner.nextInt();
                    hashTable.search(key);
                    break;
                case 4:
                    System.out.print("\nEnter key to delete: ");
                    key = scanner.nextInt();
                    hashTable.delete(key);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid choice!");
            }
        }
    }
	}


