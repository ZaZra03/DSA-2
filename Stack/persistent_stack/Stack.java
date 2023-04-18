package persistent_stack;

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
 * @see Main
 */

public class Stack {
	// Class fields
	private Node head;
	private Node tail;

	/**
	 * The getHead method returns the head of the linked list.
	 * 
	 * @return The head of the linked list.
	 */
	public Node getHead() {
		return this.head;
	}

	
	public Node getTail() {
		return this.tail;
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	/**
	 * The addNode method adds a new node to the end of the linked list. If the
	 * linked list is empty, the head and tail are set to the new node. Otherwise,
	 * the new node is added to the end of the list and the tail is updated.
	 * 
	 * @param node The node to be added to the linked list.
	 */
	public void push(Node node, Stack stack) {
		Node temp = new Node(node.getData());
		if(head == null) {
			head = node;
			tail = node;
			stack.setHead(temp);
			stack.setTail(temp);
			stack.getHead().setMessage("Added " + stack.getHead().getData() + " to the stack\nStack item(s): " + stack.getHead().getData());
		}
		
		else {
			tail.setNext(node);
			node.setPrev(tail);
			tail = node;
			stack.getTail().setNext(temp);
			temp.setPrev(stack.getTail());
			stack.setTail(temp);
			temp.setMessage("Added " + stack.getTail().getData() + " to the stack\nStack item(s): " + getData());
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
	public void pop(Stack stack) {
		Node temp = new Node(tail.getData());
		if(tail == head) {
			head = null;
			tail = null;
		} else {
			tail = tail.getPrev();
			tail.setNext(null);
		}
		stack.getTail().setNext(temp);
		temp.setPrev(stack.getTail());
		stack.setTail(temp);
		temp.setMessage("Removed " + temp.getData() + " from the stack\nStack item(s): " + getData());
		System.out.println("The recently added item was deleted!");
		System.out.println();
		displayList();
		System.out.println();
	}

	/**
	 * The displayList method displays the nodes in the linked list. The method
	 * iterates through the linked list and prints the data value of each node.
	 */
	
	public String getData() {
		String temp = "";
		Node currentNode = head;
		boolean first = true;
		while (currentNode != null) {
			if (first) {
				temp += currentNode.getData();
				first = false;
			} else {
				temp += ", " + currentNode.getData();
			}
			currentNode = currentNode.getNext();
		}
		return temp;
	}
	
	public void displayList() {
		Node currentNode = head;
		boolean first = true;
		if(currentNode == null) {
			System.out.println("Stack is empty.");
			return;
		} 
		
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
	
	public void displayHistory(Stack stack) {
		Node currentNode = stack.getTail();
		displayList();
		System.out.println();
		System.out.println("Previous states of the stack data structure: ");
		System.out.println();
		while (currentNode != null) {
			System.out.println(currentNode.getMessage());
			currentNode = currentNode.getPrev();
			System.out.println();
		}
	}
}

