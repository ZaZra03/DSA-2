/**
 * 
 * A node is a basic element of a linked list data structure.
 * 
 * This class represents a node and provides methods to manipulate the node.
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
 * @see Main
 * @see LinkedList
 * @see SkipList
 * @see SkipNode
 */
public class Node {
	// Class fields
	private int data;
	private Node next;
	private Node prev;

	/**
	 * 
	 * Creates a new node with data value 0 and no references.
	 */
	public Node() {
		data = 0;
		next = null;
		prev = null;
	}

	/**
	 * 
	 * Creates a new node with the specified data value and no references.
	 * 
	 * @param data the data value to be stored in the node.
	 */
	public Node(int data) {
		this.data = data;
		next = null;
		prev = null;
	}

	/**
	 * 
	 * The getData method returns the data value stored in the node.
	 * 
	 * @return the data value stored in the node.
	 */
	public int getData() {
		return data;
	}

	/**
	 * 
	 * The setData method sets the data value to be stored in the node.
	 * 
	 * @param data the data value to be stored in the node.
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * 
	 * The getNext method returns the next node reference of the node.
	 * 
	 * @return the next node reference of the node.
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * 
	 * The method setNext sets the next node reference of the node.
	 * 
	 * @param next the next node reference to be set.
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * 
	 * The getPrev method returns the previous node reference of the node.
	 * 
	 * @return the previous node reference of the node.
	 */
	public Node getPrev() {
		return prev;
	}

	/**
	 * 
	 * The setPrev method sets the previous node reference of the node.
	 * 
	 * @param prev the previous node reference to be set.
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
