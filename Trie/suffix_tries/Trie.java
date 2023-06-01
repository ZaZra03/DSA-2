package suffix_tries;

/**
 * The class represents a data structure called a trie. It is
 * used for efficient storage and retrieval of strings. The class consists of a
 * root node and various methods for manipulating the trie. The insert method
 * allows inserting a string into the trie, while the search method is intended
 * for searching within the trie. The displayChild method retrieves the children
 * of a given node. The class also includes helper methods such as hashKey,
 * which generates a hash key for a character, and getters and setters for the
 * root node and a flag indicating if a child node is full. Overall, the
 * Trie class provides functionality for constructing, inserting,
 * searching, and displaying the contents of a trie.
 *
 * @class Trie
 *
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Hans Neil Emnacin
 * @author Marc Ryzon Elomina
 * @author Mark Cedrick De Vera
 * @author Rizaldy Cantalejo
 * 
 * @see Node
 * @see Main
 */
public class Trie {
	// Class fields
	private Node root;
	private boolean isChildFull = false;

	// Getters and Setters
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	// Class constructor
	public Trie() {
		root = new Node();
	}

	// Class methods
	public int hashKey(char x) {
		if (x < 'a' || x > 'z') {
			throw new IllegalArgumentException("Invalid character: " + x);
		}
		return x - 'a';
	}

	public boolean isChildFull() {
		return isChildFull;
	}

	public void setChildFull(boolean isChildFull) {
		this.isChildFull = isChildFull;
	}

	/**
	 * Inserts a string into the trie.
	 *
	 * @param text The string to be inserted.
	 */
	public void insert(String text) {
		Node temp = root;
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			int key = hashKey(currentChar);
			if (i == 0) {
				// For the first character of the text.
				if (!isChildFull()) {
					if (root.getChild()[0] == null) {
						// If the first child node is null, create a new node with the current
						// character.
						temp.getChild()[0] = new Node(currentChar);
						root.setChildEmpty(false);
						temp = temp.getChild()[0];
					} else if (root.getChild()[1] == null && currentChar != root.getChild()[0].getData()) {
						// If the second child node is null and the current character is different from
						// the first child's data.
						temp.getChild()[1] = new Node(currentChar);
						temp = temp.getChild()[1];
						setChildFull(true);
					} else
						// If both child nodes are present or the current character matches the first
						// child's data.
						temp = temp.getChild()[0];
				} else {
					// If the child nodes are already full, navigate based on the current
					// character's data.
					if (root.getChild()[0].getData() == text.charAt(0))
						temp = temp.getChild()[0];
					else
						temp = temp.getChild()[1];
				}
			} else {
				// For subsequent characters of the text.
				if (temp.getChild()[key] == null) {
					// If the child node at the given key is null, create a new node with the
					// current character.
					temp.getChild()[key] = new Node(currentChar);
					temp.setChildEmpty(false);
					temp = temp.getChild()[key];
				} else {
					// If the child node at the given key already exists, navigate to that node.
					temp = temp.getChild()[key];
				}
			}
		}
		temp.setisLastCharacter(true);
	}

	/**
	 * Retrieves the children nodes of the given node and returns them as a string.
	 * If the node has no children, it returns an empty string.
	 *
	 * @param node The node whose children are to be displayed.
	 * @return A string representation of the children nodes, separated by commas.
	 */
	public String displayChild(Node node) {
		String child = "";
		if (node.isChildEmpty())
			// If the node has no children, return the data of the node itself.
			return child += node.getData();
		for (int i = 0; i < node.getChild().length; i++) {
			if (node.getChild()[i] == null)
				continue;
			if (node.isLastCharacter())
				// If the node is marked as the last character, add "terminate" to the children
				// string.
				child += "terminate";
			if (child.length() == 0)
				// If the children string is empty, add the data of the child node.
				child += node.getChild()[i].getData();
			else
				// If the children string is not empty, separate the child data with commas.
				child += "," + node.getChild()[i].getData();
		}

		return child;
	}
}
