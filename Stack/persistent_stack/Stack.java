/**
 * The Stack class provides an implementation of a stack data structure using a
 * linked list. A stack is a linear data structure that follows the Last In
 * First Out (LIFO) principle. This class contains methods for adding a new node
 * to the top of the stack (push), removing a node from the top of the stack
 * (pop), and displaying the contents of the stack.
 * 
 * @class Stack
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Node
 * @see Main
 */

public class Stack {
	// Class fields
	private Node head;
	private Node tail;

	// Getters and Setters
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

	/**
	 * Method to push a node onto the stack.
	 * 
	 * @param node  the node to push onto the stack.
	 * @param stack the history stack.
	 */
	public void push(Node node, Stack stack) {
		Node temp = new Node(node.getData());
		if (head == null) {
			// If the stack is empty, set the head and tail to the new node.
			head = node;
			tail = node;
			if (stack.getHead() == null) {
				// If the history stack is empty, set its head and tail to the new node.
				stack.setHead(temp);
				stack.setTail(temp);
			} else {
				// Otherwise, add the new node to the end of the history stack.
				stack.getTail().setNext(temp);
				temp.setPrev(stack.getTail());
				stack.setTail(temp);
			}
			// Set the message of the new node in the history stack.
			temp.setMessage("Added " + temp.getData() + " to the stack\nStack item(s): " + getData());
		} else {
			// If the stack is not empty, add the new node to the end of the stack.
			tail.setNext(node);
			node.setPrev(tail);
			tail = node;
			// Add a new node to the end of the history stack.
			stack.getTail().setNext(temp);
			temp.setPrev(stack.getTail());
			stack.setTail(temp);
			// Set the message of the new node in the history stack.
			temp.setMessage("Added " + temp.getData() + " to the stack\nStack item(s): " + getData());
		}
	}

	/**
	 * Method to pop a node from the stack.
	 *
	 * @param stack the history stack.
	 */
	public void pop(Stack stack) {
		Node temp = new Node(tail.getData());
		if (tail == head) {
			// If there is only one element in the stack, set the head and tail to null.
			head = null;
			tail = null;
		} else {
			// Otherwise, remove the last element from the stack.
			tail = tail.getPrev();
			tail.setNext(null);
		}
		// Add a new node to the end of the history stack.
		stack.getTail().setNext(temp);
		temp.setPrev(stack.getTail());
		stack.setTail(temp);
		// Set the message of the new node in the history stack.
		temp.setMessage("Removed " + temp.getData() + " from the stack\nStack item(s): " + getData());
		System.out.println("The recently added item was deleted!");
		System.out.println();
		displayList();
		System.out.println();
	}

	/**
	 * Method to display the current items in the stack.
	 */
	public void displayList() {
		Node currentNode = head;
		boolean first = true;
		if (currentNode == null) {
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

	/**
	 * Method to display the history of the stack.
	 *
	 * @param stack the history stack.
	 */
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
