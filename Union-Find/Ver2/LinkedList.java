/**
 * The LinkedList class is a data structure used in the implementation of the 
 * Union-Find algorithm. It is used to store the nodes and create connections 
 * between them to form disjoint sets. In the context of Union-Find, the 
 * LinkedList class is responsible for maintaining the linked list of nodes, 
 * adding new nodes to the end of the list, and providing access to the head of 
 * the list. The LinkedList class is used in conjunction with the Node class,
 * which represents the individual nodes in the linked list. Together, these 
 * classes allow for efficient union and find operations in the Union-Find 
 * algorithm.
 * 
 * @class LinkedList
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Mark Cedrick De Vera
 * @see Main
 * @see UnionFind
 * @see Node
 */

public class LinkedList {
	// Class fields
	private Node head;
	private Node tail;

	/**
	 * The getHead method returns the head of the linked list.
	 * 
	 * @return The head of the linked list.
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * The addNode method adds a new node to the end of the linked list. If the
	 * linked list is empty, the head and tail are set to the new node. Otherwise,
	 * the new node is added to the end of the list and the tail is updated.
	 * 
	 * @param node The node to be added to the linked list.
	 */
	public void addNode(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
	}
}
