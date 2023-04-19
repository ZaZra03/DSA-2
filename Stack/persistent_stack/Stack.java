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
	private Node bottom;
	private Node top;

	// Getters and Setters
	public Node getBottom() {
		return this.bottom;
	}

	public Node getTop() {
		return this.top;
	}

	public void setBottom(Node bottom) {
		this.bottom = bottom;
	}

	public void setTop(Node top) {
		this.top = top;
	}

	public String getData() {
		String temp = "";
		Node currentNode = bottom;
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
		if (bottom == null) {
			// If the stack is empty, set the bottom and top to the new node.
			bottom = node;
			top = node;
			if (stack.getBottom() == null) {
				// If the history stack is empty, set its bottom and top to the new node.
				stack.setBottom(temp);
				stack.setTop(temp);
			} else {
				// Otherwise, add the new node to the end of the history stack.
				stack.getTop().setNext(temp);
				temp.setPrev(stack.getTop());
				stack.setTop(temp);
			}
			// Set the message of the new node in the history stack.
			temp.setMessage("Added " + temp.getData() + " to the stack\nStack item(s): " + getData());
		} else {
			// If the stack is not empty, add the new node to the end of the stack.
			top.setNext(node);
			node.setPrev(top);
			top = node;
			// Add a new node to the end of the history stack.
			stack.getTop().setNext(temp);
			temp.setPrev(stack.getTop());
			stack.setTop(temp);
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
		Node temp = new Node(top.getData());
		if (top == bottom) {
			// If there is only one element in the stack, set the bottom and top to null.
			bottom = null;
			top = null;
		} else {
			// Otherwise, remove the last element from the stack.
			top = top.getPrev();
			top.setNext(null);
		}
		// Add a new node to the end of the history stack.
		stack.getTop().setNext(temp);
		temp.setPrev(stack.getTop());
		stack.setTop(temp);
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
		Node currentNode = bottom;
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
		Node currentNode = stack.getTop();
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
