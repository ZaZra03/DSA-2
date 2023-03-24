public class LinkedList {
	private Node head;
	private Node tail;
	private int size;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	public int getSize() {
		return size;
	}
	
	public void addNode(Node node) {
		if(head == null) {
			head = node;
			tail = node;
			size++;
		}
		
		else {
			Node currentNode = tail;	
			currentNode.setNext(node);
			node.setPrev(currentNode);
			tail = node;
			size++;
		}
	}
	
	public void deleteNode() {
		tail = tail.getPrev();
		tail.getPrev().setNext(null);
		size--;
	}
	
	public void displayList() {
		System.out.print("The values are: ");
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
			
		}
	}
	
	public void displayReversedList() {
		System.out.print("\nTHe values are: ");
		Node currentNode = head;
		while(currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getPrev();
		}
	}
}
