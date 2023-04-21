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
			history.addLinkedList(head);
		}

		else {
			Node currentNode = tail;	
			currentNode.setNext(node);
			node.setPrev(currentNode);
			tail = node;
			size++;
			tail.setIndex(size);
			history.addLinkedList(new Node(head));
		}
	}

	public void deleteNode(int index) {
		if(size > 0) {
			Node currentNode = head;
			if(index == head.getIndex()) {
				if(size == 1) {
					head.setDeleted(true);
					tail.setDeleted(true);
					head.setIndex(-1);
					tail.setIndex(-1);
					size--;
					history.addLinkedList(new Node(head));
				}
				head.setDeleted(true);
				head.setIndex(-1);
				size--;
				fixIndex();
				history.addLinkedList(new Node(head));
			}

			else if (index == tail.getIndex()) {
				tail.setDeleted(true);
				tail.setIndex(-1);
				size--;
				fixIndex();
				history.addLinkedList(new Node(head));

			} else {
				while(currentNode.getIndex() != index) {
					currentNode = currentNode.getNext();
				}
				currentNode.setDeleted(true);
				currentNode.setIndex(-1);
				size--;
				fixIndex();
				history.addLinkedList(new Node(head));
			}
		} else System.out.println("List is empty.");
	}

	public void displayList() {
		System.out.print("The values are: ");
		Node currentNode = head;
		while(currentNode != null) {
			if(currentNode.isDeleted() == true) {
				currentNode = currentNode.getNext();
				continue;
			}
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public void changeValue(Node node, int index) {
		Node currentNode = head;
		while(currentNode.getIndex() != index) {
			currentNode = currentNode.getNext();
		}
		node.setFrontVersion(currentNode);
		int temp = currentNode.getData();
		while(currentNode.getNextVersion() != null) {
			currentNode = currentNode.getNextVersion();
		}
		currentNode.setNextVersion(node);
		node.getFrontVersion().setData(node.getData());
		node.setData(temp);
	}
	
	public String nodeHistory(Node node) {
		String temp = "";
		int frontData = node.getData();
		if(size == 1) return temp+=node.getData();
		node = node.getNextVersion();
		while(node != null) {
			temp = temp + node.getData() + " ,";
			node = node.getNextVersion();
		}
		temp += frontData;
		return temp;
	}
	
	public void displayHistory() {
		System.out.print("The values are: ");
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public void fixIndex() {
		Node currentNode = head;
		int index = 1;
		while(currentNode != null) {
			if(currentNode.isDeleted() == true) {
				currentNode = currentNode.getNext();
				continue;
			} 
			currentNode.setIndex(index);
			currentNode = currentNode.getNext();
			index++;
		}
	}
	
	public int showCurrentValue(int index) {
		Node currentNode = head;
		if(tail.getIndex() == index) return tail.getData();
		while(currentNode.getIndex() != index) {
			currentNode = currentNode.getNext();
		}
		return currentNode.getData();
	}
	
	public Node currentNode(int index) {
		Node currentNode = head;
		if(tail.getIndex() == index) return tail;
		while(currentNode.getIndex() != index) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}
}

