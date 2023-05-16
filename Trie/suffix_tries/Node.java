
/**
 * The Node class is a fundamental component of the SuffixTrie data structure.
 * It represents a single node within the trie and contains information about
 * the stored character, child nodes, and flags indicating whether the node is
 * empty, representing the last character of a string, or both. The class
 * provides constructors for creating nodes with or without a specified
 * character and supports getter and setter methods for accessing and modifying
 * the node's attributes. Nodes are utilized by the SuffixTrie class to
 * construct the trie structure by connecting nodes as children of other nodes.
 *
 * @class Node
 *
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see SuffixTrie
 * @see Main
 */
public class Node {
	// Class fields
	private char data;
	private Node[] child;
	private boolean isChildEmpty = true;
	private boolean isLastCharacter;

	// Class constructors
	public Node() {
		setChild(new Node[2]);
	}

	public Node(char data) {
		this.setData(data);
		setChild(new Node[26]);
	}

	// Getters and Setters
	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Node[] getChild() {
		return child;
	}

	public void setChild(Node[] child) {
		this.child = child;
	}

	public boolean isChildEmpty() {
		return isChildEmpty;
	}

	public void setChildEmpty(boolean isChildEmpty) {
		this.isChildEmpty = isChildEmpty;
	}

	public boolean isLastCharacter() {
		return isLastCharacter;
	}

	public void setisLastCharacter(boolean isLastCharacter) {
		this.isLastCharacter = isLastCharacter;
	}
}
