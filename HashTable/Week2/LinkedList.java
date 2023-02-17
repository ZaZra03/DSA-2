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
	
	public void deleteNode(Node node) {
		Node currentNode = head;
		Node previousNode = null;
		
		if(currentNode.getData() == node.getData()) {
			head = currentNode.getNext();
			System.out.println("Key successfully deleted.");
			return;
		}
		
		while(currentNode != null) {
			if(currentNode.getData() == node.getData()) {
				System.out.println("Key successfully deleted.");
				previousNode.setNext(currentNode.getNext());
			}
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
	}
	
	public void displayList() {
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " -> ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public boolean search(Node node) {
		Node currentNode = head;

		while(currentNode != null) {
			if(currentNode.getData() == node.getData()) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}
}