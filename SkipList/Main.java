import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
  		LinkedList list = new LinkedList();
  		SkipList skiplist = new SkipList();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int nodesToSkip=0, number=0;
		
		System.out.print("Enter the size of the linked list: ");
		int size = Integer.parseInt(in.readLine());
		int value;
		 for(int i = 0; i < size; i++) {
			System.out.print("Enter a value: ");
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
			System.out.println("6. Display Skip List from Tail");
			System.out.println("7. Search from Head");
			System.out.println("8. Search from Tail");
			System.out.println("9. Exit");
			System.out.print("\n>> ");

			try {
				// Read user input.
				int choice = Integer.parseInt(in.readLine());
				System.out.println();

				// Execute the selected menu option.
				switch (choice) {
				case 1: // Create Skip List
					createSkipList(skiplist, list, nodesToSkip, number);
					break;

				case 2: //Add Node
					System.out.print("Enter a value: ");
					value = Integer.parseInt(in.readLine());
					addNode(list, skiplist, nodesToSkip, value);
					break;
					
				case 3: // Display List from Head
					list.displayList();
					break;
				case 4: // Display Skip List from Head
					skiplist.displayList();
					break;
				case 5: // Display List from Tail
					list.displayReversedList();
					break;
				case 6: // Display Skip List from Tail
					skiplist.displayReversedList();
					break;

				case 7: // Search from Head
					if(skiplist.getHead() != null) {
						boolean isFound = false, isFinished = false;
						int numNodes = 1, numSkipNodes = 0;
						System.out.print("Enter a value: ");
						value = Integer.parseInt(in.readLine());
						SkipNode currentSkipNode = skiplist.getHead();
						searchFromHead(list, currentSkipNode, isFound, isFinished, number, value, numNodes, numSkipNodes);
					} else System.out.println("Skip List is empty.");
					break;
					
				case 8: // Search from Tail
					if(skiplist.getHead() != null) {
						boolean isFound = false, isFinished = false;
						int numNodes = 1, numSkipNodes = 0;
						System.out.print("Enter a value: ");
						value = Integer.parseInt(in.readLine());
						SkipNode currentSkipNode = skiplist.getTail();
						searchFromHead(list, currentSkipNode, isFound, isFinished, number, value, numNodes, numSkipNodes);
					} else System.out.println("Skip List is empty.");
					break;
					
				case 9: // Exit
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
	
	static double squareRoot(int num) {
		double t, sqrtroot=num/2;   
		do   
		{  
			t=sqrtroot;  
			sqrtroot=(t+(num/t))/2;  
		}   
		while((t-sqrtroot)!= 0);  
		return sqrtroot;  
	}
	
	static void createSkipList(SkipList skiplist, LinkedList list, int nodesToSkip, int number) {
		if(skiplist.getHead()!=null)
			System.out.print("\nAlready created a skip list.");
		else {
			// computes the number of nodes to be skipped
			nodesToSkip = (int) squareRoot(list.getSize());
			number = (int) squareRoot(list.getSize());
			// creates the first node of the skip list
			SkipNode skipNode = new SkipNode(list.getHead().getData(), list.getHead());
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
					skipNode = new SkipNode(currentNode.getData(), currentNode);
					skiplist.addNode(skipNode);
				}
			}
			System.out.print("Skip list created!");
			System.out.println();
		}
	}
	
	static void addNode(LinkedList list, SkipList skiplist, int nodesToSkip, int value) {
		if(value < list.getTail().getData()) System.out.println("The value must be greater than " + list.getTail().getData());
		else {
			list.addNode(new Node(value));
			Node currentNode = skiplist.getTail().getBottom();
			while(currentNode!=null) {
				for(int i=1; i <= nodesToSkip+1; i++) {
					if(currentNode!=null) currentNode = currentNode.getNext();
					else break;
				}

				if(currentNode!=null) {
					SkipNode skipNode = new SkipNode();
					skipNode.setData(currentNode.getData());
					skipNode.setBottom(currentNode);
					skiplist.addNode(skipNode);
				}
			}
		} 
	}
	
	static void searchFromHead(LinkedList list, SkipNode currentSkipNode, boolean isFound, boolean isFinished, int number, int value, int numNodes, int numSkipNodes) {
		while(currentSkipNode != null && isFinished != true) {
			if(currentSkipNode.getData() == value) {
				System.out.println("Value found.");
				System.out.println("Number of Traversed Nodes: " + numNodes);
				System.out.println("Number of Skipped Nodes: " + numSkipNodes);
				isFound = true;
				isFinished = true;
			}
			else if (currentSkipNode.getData() < value && currentSkipNode.getNext() != null) {
				currentSkipNode = currentSkipNode.getNext();
				numSkipNodes = numSkipNodes + (number+1);
				numNodes++;
			}
			
			else {
				Node currentNode = currentSkipNode.getBottom();
				if(currentNode == list.getHead()) {
					if(currentNode.getData() > value) {
						System.out.println("Value not found.");
						isFinished = true;
					}
				}
				
				else if(currentNode.getData() > value) {
					while(currentSkipNode.getPrev().getBottom() != currentNode) {
						if(currentNode.getData() == value) {
							System.out.println("Value found.");
							System.out.println("Number of Traversed Nodes: " + numNodes);
							System.out.println("Number of Skipped Nodes: " + numSkipNodes);
							isFound = true;
							isFinished = true;
							break;
						} else {
							currentNode = currentNode.getPrev();
							numNodes++;
						}
					}
					if(!isFound) {
						System.out.println("Value not found.");
						isFinished = true;
					} 
				} else {
					while(currentNode != null) {
						if(currentNode.getData() == value) {
							System.out.println("Value found.");
							System.out.println("Number of Traversed Nodes: " + numNodes);
							System.out.println("Number of Skipped Nodes: " + numSkipNodes);
							isFound = true;
							isFinished = true;
							break;
						} else {
							currentNode = currentNode.getNext();
							numNodes++;
						}
					}
					if(!isFound) {
						System.out.println("Value not found.");
						isFinished = true;
					}
				}
			}
		}
	}
	
	static void searchFromTail(LinkedList list, SkipNode currentSkipNode, boolean isFound, boolean isFinished, int number, int value, int numNodes, int numSkipNodes) {
		while(currentSkipNode != null && isFinished != true) {
			if(currentSkipNode.getData() == value) {
				System.out.println("Value found.");
				System.out.println("Number of Traversed Nodes: " + numNodes);
				System.out.println("Number of Skipped Nodes: " + numSkipNodes);
				isFound = true;
				isFinished = true;
			}
			else if (currentSkipNode.getData() > value && currentSkipNode.getPrev() != null) {
				currentSkipNode = currentSkipNode.getPrev();
				numSkipNodes = numSkipNodes + (number+1);
				numNodes++;
			}
			
			else {
				Node currentNode = currentSkipNode.getBottom();
				if(currentNode == list.getTail()) {
					if(currentNode.getData() < value) {
						System.out.println("Value not found.");
						isFinished = true;
					}
				}
				
				else if(currentNode.getData() < value) {
					while(currentSkipNode.getNext().getBottom() != currentNode) {
						if(currentNode.getData() == value) {
							System.out.println("Value found.");
							System.out.println("Number of Traversed Nodes: " + numNodes);
							System.out.println("Number of Skipped Nodes: " + numSkipNodes);
							isFound = true;
							isFinished = true;
							break;
						} else {
							currentNode = currentNode.getNext();
							numNodes++;
						}
					}
					if(!isFound) {
						System.out.println("Value not found.");
						isFinished = true;
					} 
				} else {
					while(currentNode != null) {
						if(currentNode.getData() == value) {
							System.out.println("Value found.");
							System.out.println("Number of Traversed Nodes: " + numNodes);
							System.out.println("Number of Skipped Nodes: " + numSkipNodes);
							isFound = true;
							isFinished = true;
							break;
						} else {
							currentNode = currentNode.getPrev();
							numNodes++;
						}
					}
					if(!isFound) {
						System.out.println("Value not found.");
						isFinished = true;
					}
				}
			}
		}
	}
}