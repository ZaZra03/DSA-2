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

	public void push(Node node, Stack stack) {
		Node temp = new Node(node.getData());
		if (head == null) {
			head = node;
			tail = node;
			if (stack.getHead() == null) {
				stack.setHead(temp);
				stack.setTail(temp);
			} else {
				stack.getTail().setNext(temp);
				temp.setPrev(stack.getTail());
				stack.setTail(temp);
			}
			temp.setMessage("Added " + temp.getData() + " to the stack\nStack item(s): " + getData());
		} else {
			tail.setNext(node);
			node.setPrev(tail);
			tail = node;
			stack.getTail().setNext(temp);
			temp.setPrev(stack.getTail());
			stack.setTail(temp);
			temp.setMessage("Added " + temp.getData() + " to the stack\nStack item(s): " + getData());
		}
	}

	public void pop(Stack stack) {
		Node temp = new Node(tail.getData());
		if (tail == head) {
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
