/**
 * The LinkedList class provides an implementation of a doubly linked list data
 * structure. A linked list is a linear data structure that consists of nodes
 * connected by links. This class contains methods for adding and deleting
 * nodes, displaying the list, changing the value of a node, and viewing the
 * history of the list.
 *
 * @class LinkedList 
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Node
 * @see Array
 * @see Main
 */
public class LinkedList {
	// Class fields
	private Node head;
	private Node tail;
	private int size;
	private Array history = new Array(10);

	// Getters and Setters
	public Node getHead() {
		return this.head;
	}

	public int getSize() {
		return this.size;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * Adds the specified node to the tail of this linked list.
	 *
	 * @param node the node to add to this linked list
	 */
	public void addNode(Node node) {
		if (head == null) {
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
		System.out.println("\nNode added successfully.\n");
	}

	/**
	 * Deletes the node at the specified position in this linked list.
	 *
	 * @param index the position of the node to delete
	 */
	public void deleteNode(int index) {
		if (size > 0) {
			Node currentNode = head;
			if (index == head.getIndex()) {
				if (size == 1) {
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
				while (currentNode.getIndex() != index) {
					currentNode = currentNode.getNext();
				}
				currentNode.setDeleted(true);
				currentNode.setIndex(-1);
				size--;
				fixIndex();
				history.addLinkedList(new Node(head));
			}
			System.out.println("\nNode deleted successfully.\n");
		} else
			System.out.println("\nList is empty\n.");
	}

	/**
	 * Displays the values of all the existing nodes in this linked list.
	 */
	public void displayList() {
		System.out.print("The values are: ");
		for (Node currentNode = head; currentNode != null; currentNode = currentNode.getNext()) {
			if (!currentNode.isDeleted()) {
				System.out.print(currentNode.getData() + " ");
			}
		}
		System.out.println("\n");
	}

	/**
	 * Changes the value of the node at the specified position in this linked list.
	 *
	 * @param node  the new node to replace the existing node
	 * @param index the position of the node to change
	 */
	public void changeValue(Node node, int index) {
		Node currentNode = head;
		while (currentNode.getIndex() != index) {
			currentNode = currentNode.getNext();
		}
		node.setFrontVersion(currentNode);
		int temp = currentNode.getData();
		while (currentNode.getNextVersion() != null) {
			currentNode = currentNode.getNextVersion();
		}
		currentNode.setNextVersion(node);
		node.getFrontVersion().setData(node.getData());
		node.setData(temp);
	}

	/**
	 * Returns a string representation of the history of the node at the specified
	 * position in this linked list.
	 *
	 * @param node the node to get the history of
	 * @return a string representation of the history of the specified node
	 */
	public String nodeHistory(Node node) {
		String temp = "";
		int frontData = node.getData();
		if (node.getNextVersion() == null)
			return temp += node.getData();
		node = node.getNextVersion();
		while (node != null) {
			temp = temp + node.getData() + ",";
			node = node.getNextVersion();
		}
		temp = temp + " " + frontData;
		return temp;
	}

	/**
	 * Displays the values of all the nodes (including deleted nodes) in this linked
	 * list.
	 */
	public void displayHistory() {
		System.out.print("The values are: ");
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println("\n");
	}

	/**
	 * Fixes the indices of the nodes in this linked list.
	 */
	public void fixIndex() {
		Node currentNode = head;
		int index = 1;
		while (currentNode != null) {
			if (currentNode.isDeleted() == true) {
				currentNode = currentNode.getNext();
				continue;
			}
			currentNode.setIndex(index);
			currentNode = currentNode.getNext();
			index++;
		}
	}

	/**
	 * Returns the current value of the node at the specified position in this
	 * linked list.
	 *
	 * @param index the position of the node to get the value of
	 * @return the current value of the specified node
	 */
	public int showCurrentValue(int index) {
		Node currentNode = head;
		if (tail.getIndex() == index)
			return tail.getData();
		while (currentNode.getIndex() != index) {
			currentNode = currentNode.getNext();
		}
		return currentNode.getData();
	}

	/**
	 * Returns the node at the specified position in this linked list.
	 *
	 * @param index the position of the node to get
	 * @return the node at the specified position in this linked list
	 */
	public Node currentNode(int index) {
		Node currentNode = head;
		if (tail.getIndex() == index)
			return tail;
		while (currentNode.getIndex() != index) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}
}
