/**
 * 
 * A linked list is a data structure that consists of a sequence of nodes, where
 * each node stores a data value and a reference to the next and previous node.
 * This class represents a linked list and provides methods to manipulate the
 * list.
 * 
 * 
 * @class LinkedList
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Main
 * @see Node
 * @see SkipNode
 * @see SkipList
 */

public class LinkedList {
	// Class fields
	private Node head;
	private Node tail;
	private int size;

	/**
	 * 
	 * The getHead method returns the head node of the linked list.
	 * 
	 * @return the head node of the linked list.
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * 
	 * The getTail method returns the tail node of the linked list.
	 * 
	 * @return the tail node of the linked list.
	 */
	public Node getTail() {
		return tail;
	}

	/**
	 * 
	 * The getSize method returns the number of nodes in the linked list.
	 * 
	 * @return the number of nodes in the linked list.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 
	 * The addNode method adds a new node to the end of the linked list.
	 * 
	 * @param node the node to be added to the linked list.
	 */
	public void addNode(Node node) {
		if (head == null) {
			head = node;
			tail = node;
			size++;
		}

		else {
			tail.setNext(node);
			;
			node.setPrev(tail);
			tail = node;
			insertionSort(node);
			size++;
		}
	}

	/**
	 * 
	 * Sorts the linked list using the insertion sort algorithm, starting from the
	 * given node. This method compares the data values of the given node with its
	 * previous nodes, and swaps their positions if necessary to maintain the
	 * ascending order of the list.
	 * 
	 * @param node the node to be sorted in the linked list.
	 */
	private void insertionSort(Node node) {
		Node key = node;
		Node prev = node.getPrev();

		while (prev != null && prev.getData() > key.getData()) {
			// Swap key and prev node values
			int temp = key.getData();
			key.setData(prev.getData());
			prev.setData(temp);

			key = prev;
			prev = prev.getPrev();
		}
	}

	/**
	 * 
	 * Deletes the last node in the linked list. This method updates the tail
	 * reference to point to the second-to-last node, and removes the reference to
	 * the deleted node from the previous node. It also decrements the size of the
	 * linked list.
	 */
	public void deleteNode() {
		tail = tail.getPrev();
		tail.getPrev().setNext(null);
		size--;
	}

	/**
	 * 
	 * Prints all the values in the linked list in order.
	 */
	public void displayList() {
		System.out.print("The values are: ");
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}

	/**
	 * 
	 * Prints all the values in the linked list in reverse order.
	 */
	public void displayReversedList() {
		if (head != null) {
			System.out.print("The values are: ");
			Node currentNode = tail;
			while (currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getPrev();
			}
			System.out.println();

		}
	}
}
