/**
 * The Node class represents a node in a linked list. It contains an integer
 * value (data) and references to the next and previous nodes in the list (next
 * and prev). This class is used by the Stack class to implement a stack data
 * structure using a linked list.
 * 
 * @class Node
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Stack
 * @see Main
 */

public class Node {
	// Class fields
	private int data;
	private Node next;
	private Node prev;
	private String message;

	// Constructor
	public Node() {
		data = 0;
		next = null;
	}

	public Node(int data) {
		this.data = data;
		next = null;
	}

	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public String getMessage() {
		return message;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
