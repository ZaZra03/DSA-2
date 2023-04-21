package persistent_linkedlist;

public class Node {
	private int data;
	private Node next;
	private Node prev;
	private Node frontVersion;
	private Node nextVersion;
	private int index;
	private boolean isDeleted;

	
	public Node() {
		this.data = 0;
		this.next = null;
		this.prev = null;
	}
	
	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
    // Constructor to make a copy of a Node object
    public Node(Node node) {
        this.data = node.data;
        this.index = node.index;
        if (node.next != null) {
            this.next = new Node(node.next);
            this.next.prev = this; // update the prev field of the next node in the copied list
        }
    }

	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}
	
	public Node getPrev() {
		return this.prev;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Node getNextVersion() {
		return nextVersion;
	}

	public void setNextVersion(Node nextVersion) {
		this.nextVersion = nextVersion;
	}

	public Node getFrontVersion() {
		return frontVersion;
	}

	public void setFrontVersion(Node frontVersion) {
		this.frontVersion = frontVersion;
	}
}
