package midterm_lab1;

/**
 * The LinkedList class provides an implementation of a singly linked list,
 * which is a linear data structure where each element is a separate object
 * called a node. Each node contains a reference to an object and a reference to
 * the next node in the list. This class contains methods for adding a new node
 * to the end of the list, deleting a specific node, searching for a specific
 * node, and displaying the contents of the list.
 * 
 * @class LinkedList
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * @see Node
 * @see HashTable
 * @see Main
 */

public class LinkedList {
	// Class fields
	private Node head;
	private Node tail;

	/**
	 * The getHead method returns the head of the linked list.
	 * 
	 * @return The head of the linked list.
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * The addNode method adds a new node to the end of the linked list. If the
	 * linked list is empty, the head and tail are set to the new node. Otherwise,
	 * the new node is added to the end of the list and the tail is updated.
	 * 
	 * @param node The node to be added to the linked list.
	 */
	public void addNode(Node node) {
		if(head == null) {
			head = node;
			tail = node;
		}
		
		else {
			tail.setNext(node);;
			node.setPrev(tail);
			tail = node;
		}
	}

	/**
	 * The deleteNode method accepts a node to be deleted from the linked list. The
	 * method searches for the node and removes it from the linked list. If the node
	 * to be deleted is the head, the head is updated to the next node. If the node
	 * to be deleted is not the head, the previous node's next pointer is updated to
	 * skip the node to be deleted.
	 * 
	 * @param node The node to be deleted from the linked list.
	 */
	public void deleteNode(Node node) {
		tail = tail.getPrev();
		tail.getPrev().setNext(null);
	}

	/**
	 * The displayList method displays the nodes in the linked list. The method
	 * iterates through the linked list and prints the data value of each node.
	 */
	public void displayList() {
		Node currentNode = head;
		boolean first = true;
		System.out.print("Current item(s) in the stack: ");
		while (currentNode != null) {
			if (first) {
				System.out.print(currentNode.getData());
				first = false;
			} else {
				System.out.print(", " + currentNode.getData());
			}
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public void displayHistory() {
		
	}
}
