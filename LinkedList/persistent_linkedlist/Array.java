package persistent_linkedlist;

public class Array {
	private Node array[];
	private int size;
	private int capacity;
	private Node tail;
	
	public Array(int size) {
		this.setArray(new Node[size]);
		this.setSize(size);
		this.setCapacity(size);
	}
	
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
	
	public void addLinkedList(Node head, String message) {
		if(capacity == capacity - size + 1) increaseCapacity();
		array[size - capacity] = head;
		tail = array[size - capacity];
		head.setMessage(message);
		capacity--;
	}
	
	public void increaseCapacity() {
		Node temp[] = new Node[size + 10];
		int index = 0;
		for(Node value: this.array) {
			temp[index] = value;
			index++;
		}
		this.array = temp;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
}
