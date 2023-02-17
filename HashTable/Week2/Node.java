/**
 * The Node class represents a node in a linked list. It contains an integer
 * value (data) and a reference to the next node in the list (next).
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
 * @see LinkedList
 * @see HashTable
 * @see Main
 */

public class Node {
	// Class fields
	private int data;
	private Node next;

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

	public void setNext(Node next) {
		this.next = next;
	}
}
