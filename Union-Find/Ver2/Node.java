/**
 * Node class for a linked list in a disjoint-set data structure.
 * 
 * @class Node
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Mark Cedrick De Vera
 * @see Main
 * @see UnionFind
 * @see LinkedList
 */

public class Node {
    // Class fields
    private int data;
    private Node next;
    private Node head;
    private int index;

    /**
     * Constructor for Node class.
     *
     * @param data the integer data to store in the node
     */
    public Node(int data) {
        this.data = data;
        this.setNext(null);
    }

    // Getters
    public int getData() {
        return this.data;
    }

    public Node getHead() {
        return this.head;
    }

    public int getIndex() {
        return this.index;
    }

    public Node getNext() {
        return next;
    }

    // Setters
    public void setHead(Node head) {
        this.head = head;
    }

    public void setIndex(int x) {
        this.index = x;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
