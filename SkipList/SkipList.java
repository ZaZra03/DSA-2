public class SkipList {
	private SkipNode head;
	private SkipNode tail;
	

	public SkipNode getHead() {
		return head;
	}

	public void setHead(SkipNode head) {
		this.head = head;
	}
	
	public void addNode(SkipNode node) {
		if(head == null) {
			head = node;
		} 
		
		else {
			tail.setNext(node);;
			node.setPrev(tail);
		}
		tail = node;
	}
	
	public SkipNode getTail() {
		return tail;
		
	}
	
	public void displayList() {
		if(head != null) {
			System.out.print("\nThe values are: ");
			SkipNode currentNode = head;
			while(currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getNext();
			}
		} else System.out.print("\nThe list is empty.");
	}
	
	public void displayReversedList() {
		if(head != null) {
			System.out.print("\nThe values are: ");
			SkipNode currentNode = tail;
			while(currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getPrev();
			}
		} else System.out.print("\nThe list is empty.");
	}
}
