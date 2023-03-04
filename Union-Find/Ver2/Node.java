class Node {
	// Class fields
	private int data;
	private Node next;
	private Node head;
	private int index;

	// Constructor
	public Node(int data) {
		this.data = data;
		this.setNext(null);
	}

	// Getters
	public int getData() {
		return this.data;
	}

	public Node getHead() {
		return this.head;
	}

	public int getIndex() {
		return this.index;
	}

	public Node getNext() {
		return next;
	}

	// Setters
	public void setHead(Node head) {
		this.head = head;
	}

	public void setIndex(int x) {
		this.index = x;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}