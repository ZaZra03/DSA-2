/**
* A SkipList is a data structure that consists of a sequence of 
* sorted linked lists that are linked together by express lanes between nodes.
* This class represents a Skip List and provides methods to manipulate the list.
* 
* @class SkipList
* 
* @author Eugene Lawrence Autos
* @author Ezra Micah Malsi
* @author Hans Neil Emnacin
* @author Marc Ryzon Elomina
* @author Mark Cedrick De Vera
* @author Rizaldy Cantalejo
* 
* @see Main
* @see LinkedList
* @see Node
* @see SkipNode
*/

public class SkipList {
	//Class fields
	private SkipNode head;
	private SkipNode tail;
	
	/**
	* The getHead method returns the head of the skip list.
	* 
	* @return the head node of the skip list.
	*/
	public SkipNode getHead() {
		return head;
	}
	
	/**
	* The setHead method sets the head node of the skip list.
	* 
	* @param head the node to be set as the head of the skip list.
	*/
	public void setHead(SkipNode head) {
		this.head = head;
	}
	
	/**
	* The addNode method adds a new node to the end of the skip list.
	* 
    * @param node the node to be added to the end of the skip list.
	*/
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
	
	/**
	* The getTail method returns the tail of the skip list.
	* @return the tail node of the skip list.
	*/
	public SkipNode getTail() {
		return tail;
		
	}
	
	/**
	* Displays the values in the skip list. If the list is not empty, it prints out 
	* all the values in the list separated by a space. 
	* If the list is empty, it prints out "The list is empty."
	*/
	public void displayList() {
		if(head != null) {
			System.out.print("The values are: ");
			SkipNode currentNode = head;
			while(currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getNext();
			}
			System.out.println();
			
		} else {
			System.out.print("The list is empty.");
			System.out.println();
		}
	}
	
	/**
	* Displays the values in the skip list in reverse order.
	* If the list is not empty, it prints out all the values in 
	* the list in reverse order, separated by a space.
   	* If the list is empty, it prints out "The list is empty."
	*/
	public void displayReversedList() {
		if(head != null) {
			System.out.print("The values are: ");
			SkipNode currentNode = tail;
			while(currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getPrev();
			}
			System.out.println();
			
		} else {
			System.out.print("The list is empty.");
			System.out.println();
		}
	}
}
