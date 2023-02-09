package Week2;

public class LinkedList {
	private Node head;
	private Node tail;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	public void addNode(Node node) {
		if(head == null) {
			head = node;
			tail = node;
		}
		
		else {
			Node currentNode = tail;
			currentNode.setNext(node);
			tail = node;
			head.setNext(currentNode);
		}
	}
	
	public void deleteNode() {
		tail = null;
	}
	
	public void displayList() {
		System.out.print("\nThe values are: ");
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
	}
}