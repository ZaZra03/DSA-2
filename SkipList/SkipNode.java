/**
 * A skip node is a node that is used in a skip list data structure. This class
 * represents a skip node and provides methods to manipulate the node.
 *
 * @class SkipNode
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
 * @see Node
 * @see SkipList
 */

public class SkipNode {
	// Class fields
	private int data;
	private SkipNode next;
	private SkipNode prev;
	private Node bottom;

	/**
	 * 
	 * Creates a new skip node with data value 0 and no references.
	 */
	public SkipNode() {
		setData(0);
		setNext(null);
		setBottom(null);
	}

	/**
	 * 
	 * Creates a new skip node with the specified data value and bottom node reference.
	 * 
	 * @param data the data value to be stored in the skip node.
	 * @param bottom the bottom node reference to be stored in the skip node.
	 */
	// Constructor
	public SkipNode(int data, Node bottom) {
		this.data = data;
		this.bottom = bottom;
	}

	/**
	 * 
	 * The getData method returns the data value stored in the skip node.
	 * 
	 * @return the data value stored in the skip node.
	 */
	public int getData() {
		return data;
	}

	/**
	 * 
	 * The setData method sets the data value to be stored in the skip node.
	 * 
	 * @param data the data value to be stored in the skip node.
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * 
	 * The getNext method returns the next node reference of the skip node.
	 * 
	 * @return the next node reference of the skip node.
	 */
	public SkipNode getNext() {
		return next;
	}

	/**
	 * 
	 * The getPrev method returns the previous node reference of the skip node.
	 * 
	 * @return the previous node reference of the skip node.
	 */
	public SkipNode getPrev() {
		return prev;
	}

	/**
	 * 
	 * The setPrev method sets the previous node reference of the skip node.
	 * 
	 * @param prev the previous node reference to be set.
	 */
	public void setPrev(SkipNode prev) {
		this.prev = prev;
	}

	/**
	 * 
	 * The setNext method sets the next node reference of the skip node.
	 * 
	 * @param next the next node reference to be set.
	 */
	public void setNext(SkipNode next) {
		this.next = next;
	}

	/**
	 * 
	 * The getBottom method returns the bottom node reference of the skip node.
	 * 
	 * @return the bottom node reference of the skip node.
	 */
	public Node getBottom() {
		return bottom;
	}

	/**
	 * 
	 * The setBottom method sets the bottom node reference of the skip node.
	 * 
	 * @param bottom the bottom node reference to be set.
	 */
	public void setBottom(Node bottom) {
		this.bottom = bottom;
	}
}
