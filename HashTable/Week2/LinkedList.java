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
			tail.setNext(node);
			tail = node;
		}
	}
	
	public void deleteNode() {
		tail = null;
	}
	
	public void displayList() {
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + "-> ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
}