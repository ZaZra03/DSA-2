
/**
 * This is a Java program that implements a Skip List data structure using
 * linked lists. The program allows the user to create a linked list of a
 * specified size and then create a skip list based on the linked list with a
 * predetermined number of nodes to skip. The program provides various options
 * for manipulating and displaying the linked list and skip list, including
 * adding a new node to the list, displaying the list from the head or tail, and
 * searching the list from the head or tail for a specific value. The program
 * uses a menu-driven interface to allow the user to select from the available
 * options, and it includes input validation to ensure that the user provides
 * valid inputs.
 * 
 * @class Main
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see SkipList
 * @see LinkedList
 * @see Node
 * @see SkipNode
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		LinkedList list = new LinkedList();
		SkipList skiplist = new SkipList();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int size;
		do {
			try {
				System.out.print("Enter the size of the linked list: ");
				int input = Integer.parseInt(in.readLine());
				size = input;
				if (size <= 0) {
					System.out.println("\nSize must be a positive integer.\n");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("\nSize must be a positive integer.\n");
			}

		} while (true);

		int value;
		for (int i = 0; i < size; i++) {
			boolean isValidInput = false;
			while (!isValidInput) {
				try {
					System.out.print("Enter a value: ");
					value = Integer.parseInt(in.readLine());
					list.addNode(new Node(value));
					isValidInput = true;
				} catch (NumberFormatException e) {
					System.out.println("\nValue must be an integer.\n");
				}
			}
		}

		// computes the number of nodes to be skipped
		final int nodesToSkip = (int) squareRoot(list.getSize());

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
					createSkipList(skiplist, list, nodesToSkip);
					break;

				case 2: // Add Node
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
					if (skiplist.getHead() != null) {
						boolean isFound = false, isFinished = false;
						int numNodes = 1, numSkipNodes = 0;
						System.out.print("Enter a value: ");
						value = Integer.parseInt(in.readLine());
						SkipNode currentSkipNode = skiplist.getHead();
						searchFromHead(list, currentSkipNode, isFound, isFinished, nodesToSkip, value, numNodes,
								numSkipNodes);
					} else
						System.out.println("Skip List is empty.");
					break;

				case 8: // Search from Tail
					if (skiplist.getHead() != null) {
						boolean isFound = false, isFinished = false;
						int numNodes = 1, numSkipNodes = 0;
						System.out.print("Enter a value: ");
						value = Integer.parseInt(in.readLine());
						SkipNode currentSkipNode = skiplist.getTail();
						searchFromTail(list, currentSkipNode, isFound, isFinished, nodesToSkip, value, numNodes,
								numSkipNodes);
					} else
						System.out.println("Skip List is empty.");
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

	/**
	 * This method calculates the square root of a given integer using the
	 * Babylonian method. It starts with an initial guess and iteratively refines it
	 * until the difference between the guess and its square is smaller than a given
	 * tolerance. The algorithm is implemented using a do-while loop that continues
	 * until the difference between the previous and current guesses is zero.
	 * 
	 * @param num the integer whose square root is to be computed
	 * @return the square root of the input integer, computed using the Babylonian
	 *         method
	 */
	static double squareRoot(int num) {
		double t, sqrtroot = num / 2;
		do {
			t = sqrtroot;
			sqrtroot = (t + (num / t)) / 2;
		} while ((t - sqrtroot) != 0);
		return sqrtroot;
	}

	/**
	 * This method creates a skip list from a given linked list by taking every n-th
	 * node (specified by the nodesToSkip parameter) and adding it to the skip list.
	 * It first checks if a skip list has already been created. If not, it creates
	 * the first node of the skip list using the first node of the linked list, and
	 * then iterates through the remaining nodes of the linked list, adding every
	 * n-th node to the skip list as a new SkipNode object. If the linked list is
	 * shorter than n, the remaining nodes are not added to the skip list.
	 * 
	 * @param skiplist    the SkipList object on which the skip list will be created
	 * @param list        the LinkedList object from which the skip list will be
	 *                    created
	 * @param nodesToSkip the number of nodes to skip between each node that is
	 *                    added to the skip list
	 */
	static void createSkipList(SkipList skiplist, LinkedList list, int nodesToSkip) {
		if (skiplist.getHead() != null) {
			System.out.print("Already created a skip list.");
			System.out.println();
		}

		else {
			// creates the first node of the skip list
			SkipNode skipNode = new SkipNode(list.getHead().getData(), list.getHead());
			skiplist.addNode(skipNode);
			// creates the remaining nodes of the skip list
			Node currentNode = list.getHead();
			while (currentNode != null) {
				for (int i = 1; i <= nodesToSkip + 1; i++) {
					if (currentNode != null)
						currentNode = currentNode.getNext();
					else
						break;

				}

				if (currentNode != null) {
					skipNode = new SkipNode(currentNode.getData(), currentNode);
					skiplist.addNode(skipNode);
				}
			}
			System.out.print("Skip list created!");
			System.out.println();
		}
	}

	/**
	 * This method adds a new node to both the linked list and the skip list. It
	 * first checks if the value of the new node is greater than the value of the
	 * tail node of the linked list. If not, it prints an error message and does not
	 * add the node. Otherwise, it creates a new node with the given value and adds
	 * it to the linked list. It then iterates through the bottom level of the skip
	 * list to find the appropriate position to add the new node, adding a new
	 * SkipNode object at every n-th node (specified by the nodesToSkip parameter).
	 * The new SkipNode object is created with the same data as the corresponding
	 * linked list node and a bottom pointer to the corresponding linked list node.
	 * 
	 * @param list        the LinkedList to which the new node will be added
	 * @param skiplist    the SkipList to which the new skip node will be added
	 * @param nodesToSkip the number of nodes to skip between each node that is
	 *                    added to the skip list
	 * @param value       the value of the new node to be added to the linked list
	 *                    and skip list
	 */
	static void addNode(LinkedList list, SkipList skiplist, int nodesToSkip, int value) {
		if (value < list.getTail().getData())
			System.out.println("The value must be greater than " + list.getTail().getData());
		else {
			list.addNode(new Node(value));
			Node currentNode = skiplist.getTail().getBottom();
			while (currentNode != null) {
				for (int i = 1; i <= nodesToSkip + 1; i++) {
					if (currentNode != null)
						currentNode = currentNode.getNext();
					else
						break;
				}

				if (currentNode != null) {
					SkipNode skipNode = new SkipNode();
					skipNode.setData(currentNode.getData());
					skipNode.setBottom(currentNode);
					skiplist.addNode(skipNode);
				}
			}
		}
	}

	/**
	 * This method is used to search for a specific value in a skip list. It takes
	 * in several parameters including the linked list, the current skip node, the
	 * value to be searched for, and counts of the number of nodes and skipped nodes
	 * traversed. The method iterates through the skip list starting from the head
	 * and follows the pointers to nodes with values that are greater than or equal
	 * to the target value. If the current node has the target value, the method
	 * returns the number of nodes and skipped nodes traversed and sets a flag to
	 * indicate that the value has been found. If the target value is not found in
	 * the skip list, the method returns a message indicating that the value was not
	 * found.
	 * 
	 * @param list            the SkipList to search in
	 * @param currentSkipNode the current SkipNode being evaluated
	 * @param isFound         a boolean indicating whether the value has been found
	 * @param isFinished      a boolean indicating whether the search is finished
	 * @param nodesToSkip     the number of nodes to skip when moving to the next
	 *                        SkipNode
	 * @param value           the value to search for
	 * @param numNodes        the number of nodes traversed during the search
	 * @param numSkipNodes    the number of SkipNodes traversed during the search
	 */
	static void searchFromHead(LinkedList list, SkipNode currentSkipNode, boolean isFound, boolean isFinished,
			int nodesToSkip, int value, int numNodes, int numSkipNodes) {
		while (currentSkipNode != null && isFinished != true) {
			if (currentSkipNode.getData() == value) {
				System.out.println("Value found.");
				System.out.println("Number of Traversed Nodes: " + numNodes);
				System.out.println("Number of Skipped Nodes: " + numSkipNodes);
				isFound = true;
				isFinished = true;
			} else if (currentSkipNode.getData() < value && currentSkipNode.getNext() != null) {
				currentSkipNode = currentSkipNode.getNext();
				numSkipNodes = numSkipNodes + nodesToSkip;
				numNodes++;
			}

			else {
				Node currentNode = currentSkipNode.getBottom();
				if (currentNode == list.getHead()) {
					if (currentNode.getData() > value) {
						System.out.println("Value not found.");
						isFinished = true;
					}
				}

				else if (currentNode.getData() > value) {
					while (currentSkipNode.getPrev().getBottom() != currentNode) {
						if (currentNode.getData() == value) {
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
					if (!isFound) {
						System.out.println("Value not found.");
						isFinished = true;
					}
				} else {
					while (currentNode != null) {
						if (currentNode.getData() == value) {
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
					if (!isFound) {
						System.out.println("Value not found.");
						isFinished = true;
					}
				}
			}
		}
	}

	/**
	 * This method is used to search for a specific value in a skip list. It takes
	 * in several parameters including the linked list, the current skip node, the
	 * value to be searched for, and counts of the number of nodes and skipped nodes
	 * traversed. The method iterates through the skip list starting from the tail
	 * and follows the pointers to nodes with values that are less than or equal to
	 * the target value. If the current node has the target value, the method
	 * returns the number of nodes and skipped nodes traversed and sets a flag to
	 * indicate that the value has been found. If the target value is not found in
	 * the skip list, the method returns a message indicating that the value was not
	 * found.
	 * 
	 * @param list            the SkipList to search in
	 * @param currentSkipNode the current SkipNode being evaluated
	 * @param isFound         a boolean indicating whether the value has been found
	 * @param isFinished      a boolean indicating whether the search is finished
	 * @param nodesToSkip     the number of nodes to skip when moving to the next
	 *                        SkipNode
	 * @param value           the value to search for
	 * @param numNodes        the number of nodes traversed during the search
	 * @param numSkipNodes    the number of SkipNodes traversed during the search
	 */
	static void searchFromTail(LinkedList list, SkipNode currentSkipNode, boolean isFound, boolean isFinished,
			int nodesToSkip, int value, int numNodes, int numSkipNodes) {
		while (currentSkipNode != null && isFinished != true) {
			if (currentSkipNode.getData() == value) {
				System.out.println("Value found.");
				System.out.println("Number of Traversed Nodes: " + numNodes);
				System.out.println("Number of Skipped Nodes: " + numSkipNodes);
				isFound = true;
				isFinished = true;
			} else if (currentSkipNode.getData() > value && currentSkipNode.getPrev() != null) {
				currentSkipNode = currentSkipNode.getPrev();
				numSkipNodes = numSkipNodes + nodesToSkip;
				numNodes++;
			}

			else {
				Node currentNode = currentSkipNode.getBottom();
				if (currentNode == list.getTail()) {
					if (currentNode.getData() < value) {
						System.out.println("Value not found.");
						isFinished = true;
					}
				}

				else if (currentNode.getData() < value && currentSkipNode.getNext() == null) {
					while (currentNode != null) {
						if (currentNode.getData() == value) {
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
					if (!isFound) {
						System.out.println("Value not found.");
						isFinished = true;
					}
				}

				else if (currentNode.getData() < value) {
					while (currentSkipNode.getNext().getBottom() != currentNode) {
						if (currentNode.getData() == value) {
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
					if (!isFound) {
						System.out.println("Value not found.");
						isFinished = true;
					}
				} else {
					while (currentNode != null) {
						if (currentNode.getData() == value) {
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
					if (!isFound) {
						System.out.println("Value not found.");
						isFinished = true;
					}
				}
			}
		}
	}
}
