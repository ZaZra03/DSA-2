/**
 * The Array class represents an array of Node objects. It has several methods
 * for managing the array, such as adding a linked list to the array and
 * increasing its capacity.
 *
 * @class Array
 *
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Node
 * @see LinkedList
 * @see Main
 */
public class Array {
	// Class fields
	private Node array[];
	private int size;
	private int capacity;
	private Node tail;

	// Constructors
	public Array(int size) {
		this.setArray(new Node[size]);
		this.setSize(size);
		this.setCapacity(size);
	}

	// Getters and Setters
	public Node[] getArray() {
		return array;
	}

	public void setArray(Node array[]) {
		this.array = array;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	/**
	 * Adds the specified linked list to this array.
	 *
	 * @param head the head node of the linked list to add to this array
	 */
	public void addLinkedList(Node head) {
		if (capacity == capacity - size + 1)
			increaseCapacity();
		array[size - capacity] = head;
		tail = array[size - capacity];
		capacity--;
	}

	/**
	 * Increases the capacity of the array by creating a new array with larger size
	 * and copying the contents from the old array.
	 */
	public void increaseCapacity() {
		Node temp[] = new Node[size + 10];
		int index = 0;
		for (Node value : this.array) {
			temp[index] = value;
			index++;
		}
		this.array = temp;
	}
}
