package persistent_linkedlist;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size;
	private Array history = new Array(10);
	

	
	public Node getHead() {
		return this.head;
	}

	public int getSize() {
		return this.size;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void addNode(Node node) {
		if(head == null) {
			head = node;
			tail = node;
			size++;
			head.setIndex(size);
			history.addLinkedList(head, "Added " + head.getData() + " into the stack.");
		}

		else {
			Node currentNode = tail;	
			currentNode.setNext(node);
			node.setPrev(currentNode);
			tail = node;
			size++;
			tail.setIndex(size);
			history.addLinkedList(new Node(head), "Added " + tail.getData() + " into the stack.");
		}
	}

	public void deleteNode(int index) {
		if(size > 0) {
			Node currentNode = head;
			int temp;
			if(index == head.getIndex()) {
				if(size == 1) {
					temp = head.getData();
					head = null;
					tail = null;
					size--;
					history.addLinkedList(head, "Remove " + temp + " from the stack.");
				}
				temp = head.getData();
				head = head.getNext();
				head.setPrev(null);
				size--;
				fixIndex();
				history.addLinkedList(head, "Remove " + temp + " from the stack.");
			}

			else if (index == tail.getIndex()) {
				temp = tail.getData();
				tail = tail.getPrev();
				tail.setNext(null);
				size--;
				fixIndex();
				history.addLinkedList(head, "Remove " + temp + " from the stack.");

			} else {
				while(currentNode.getIndex() != index) {
					currentNode = currentNode.getNext();
				}
				temp = currentNode.getData();
				currentNode.getPrev().setNext(currentNode.getNext());
				currentNode.getNext().setPrev(currentNode.getPrev());
				currentNode = null;
				size--;
				fixIndex();
				history.addLinkedList(head, "Remove " + temp + " from the stack.");
			}
		} else System.out.println("List is empty.");
	}

	public void displayList() {
		System.out.print("The values are: ");
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();

		}
	}
	
	public void changeValue(Node node) {
		
	}
	
	public void fixIndex() {
		Node currentNode = head;
		int index = 1;
		while(currentNode != null) {
			currentNode.setIndex(index);
			currentNode = currentNode.getNext();
			index++;
		}
	}
}

