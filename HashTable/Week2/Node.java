package Week2;

public class Node {
	private int data;
	private Node next;
	
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