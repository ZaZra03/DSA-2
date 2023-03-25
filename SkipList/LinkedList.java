public class LinkedList {
	private Node head;
	private Node tail;
	private int size;

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
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
			tail.setNext(node);;
			node.setPrev(tail);
			tail = node;
			insertionSort(node);
			size++;
		}
	}
	
    private void insertionSort(Node node) {
        Node key = node;
        Node prev = node.getPrev();

        while (prev != null && prev.getData() > key.getData()) {
            // Swap key and prev node values
            int temp = key.getData();
            key.setData(prev.getData());
            prev.setData(temp);

            key = prev;
            prev = prev.getPrev();
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
		System.out.println();
	}
	
	public void displayReversedList() {
		if(head != null) {
			System.out.print("The values are: ");
			Node currentNode = tail;
			while(currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getPrev();
			}
			System.out.println();

		}
	}
}
