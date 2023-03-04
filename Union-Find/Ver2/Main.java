import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 10 numbers to form a set:");
		UnionFind u = new UnionFind(10);
		int numCount = 0;

		while (numCount < 10) {
			try {
				int x = Integer.parseInt(in.readLine());
				u.addNode(new Node(x)); // add each number to the set
				numCount++;
			} catch (NumberFormatException e) {
				System.out.println("\nInput must be an integer.");
			}
		}

		while (true) {
			System.out.println("\nMenu");
			System.out.println("1. Union");
			System.out.println("2. Find");
			System.out.println("3. Exit");
			System.out.print("\n>> ");

			try {
				int choice = Integer.parseInt(in.readLine());
				switch (choice) {
				case 1:
					System.out.print("\nEnter first number for Union operation: ");
					int x = Integer.parseInt(in.readLine());
					if (u.findNode(x).getData() != x) {
						System.out.println("\nERROR! That number is not part of the set. Please try again!\n");
						break;
					}

					System.out.print("\nEnter second number for Union operation: ");
					int y = Integer.parseInt(in.readLine());

					if (u.findNode(y).getData() != y) {
						System.out.println("\nERROR! That number is not part of the set. Please try again!\n");
						break;
					}

					u.union(u.findNode(x), u.findNode(y));
					break;
				case 2:
					System.out.print("\nEnter first number for Find operation: ");
					x = Integer.parseInt(in.readLine());
					if (u.findNode(x).getData() != x) {
						System.out.println("\nERROR! That number is not part of the set. Please try again!\n");
						break;
					}

					System.out.print("\nEnter second number for Find operation: ");
					y = Integer.parseInt(in.readLine());

					if (u.findNode(y).getData() != y) {
						System.out.println("\nERROR! That number is not part of the set. Please try again!\n");
						break;
					}
					System.out.println();
					System.out.println(u.connected(u.findNode(x), u.findNode(y)));
					break;
				case 3:
					System.out.println("\nEnd of program...\n");
					in.close();
					return;
				default:
					System.out.println("\nInvalid choice. Please try again!");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("\nInput must be an integer.");
			}
		}
	}
}