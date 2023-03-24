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
		if(head != null) {
			System.out.print("\nThe values are: ");
			Node currentNode = head;
			while(currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getNext();
			}
		} else System.out.print("\nThe list is empty.");
	}
	
	public void displayReversedList() {
		if(head != null) {
			System.out.print("\nThe values are: ");
			Node currentNode = tail;
			while(currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getPrev();
			}
		} else System.out.print("\nThe list is empty.");
	}
}
