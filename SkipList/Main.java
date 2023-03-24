import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
  		LinkedList list = new LinkedList();
  		SkipList skiplist = new SkipList();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter the size of the linked list: ");
		int size = Integer.parseInt(in.readLine());
		int value;
		System.out.println("Iniatilized: ");
		 for(int i = 0; i < size; i++) {
			value = Integer.parseInt(in.readLine());
			list.addNode(new Node(value));
		}

		// Display a menu and read user input until the user chooses to exit.
		while (true) {
			// Display menu options.
			System.out.println("\n1. Create Skip List");
			System.out.println("2. Add Node");
			System.out.println("3. Display List from Head");
			System.out.println("4. Display Skip List from Head");
			System.out.println("5. Display List from Tail");
			System.out.println("6. Display Skip List from Head");
			System.out.println("7. Search from Head");
			System.out.println("7. Search from Tail");
			System.out.println("8. Exit");
			System.out.print("\n>> ");

			try {
				// Read user input.
				int choice = Integer.parseInt(in.readLine());
				System.out.println();

				// Execute the selected menu option.
				switch (choice) {
				case 1: // Create Skip List
					if(skiplist.getHead()!=null)
						System.out.print("\nAlready created a skip list.");
					else {
						// computes the number of nodes to be skipped
						int nodesToSkip = (int) squareRoot(list.getSize());
						// creates the first node of the skip list

						SkipNode skipNode = new SkipNode();

						skipNode.setData(list.getHead().getData());
						skipNode.setBottom(list.getHead());
						skiplist.addNode(skipNode);
						// creates the remaining nodes of the skip list
						Node currentNode = list.getHead();
						while(currentNode!=null) {
							for(int i=1; i <= nodesToSkip+1; i++) {
								if(currentNode!=null)
									currentNode = currentNode.getNext();
								else
									break;

							}
							if(currentNode!=null) {
								skipNode = new SkipNode();
								skipNode.setData(currentNode.getData());
								skipNode.setBottom(currentNode);
								skiplist.addNode(skipNode);

							}
						}
						System.out.print("\nSkip list created!");
					}
					break;

				case 2: // Display Hash Table
					System.out.println("Iniatilized: ");
					value = Integer.parseInt(in.readLine());
					list.addNode(new Node(value));
					break;
				case 3: // Search

					break;
				case 4: // Delete

					break;
				case 5: // Exit
					System.exit(0);
					break;

				case 6: // Exit
					System.exit(0);
					break;

				case 7: // Exit
					System.exit(0);
					break;
					
				case 8: // Exit
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice!");
				}
			} catch (NumberFormatException e) {
				System.out.println("\nInput must be an integer.");
			}
		}
	}
	
	public static double squareRoot(int num)   
	{
		double t, sqrtroot=num/2;   
		do   
		{  
			t=sqrtroot;  
			sqrtroot=(t+(num/t))/2;  
		}   
		while((t-sqrtroot)!= 0);  
		return sqrtroot;  
	}
}