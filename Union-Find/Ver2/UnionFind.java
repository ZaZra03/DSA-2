/**
 * This is a Java implementation of the Union-Find data structure, which is used 
 * to efficiently keep track of a set of elements partitioned into disjoint subsets, 
 * and support operations such as checking whether two elements are in the 
 * same subset, and merging two subsets into a single subset.
 * 
 * This is an implementation of the Union-Find data structure using an array of nodes
 * and linked list approach. The data structure maintains a collection of disjoint sets, 
 * with each element of the set represented by a Node object. The implementation uses 
 * the concept of "path compression" to optimize the time complexity of the find() operation.
 * 
 *
 * @class HashTable
 * 
 * @author Eugene Lawrence Autos
 * @author Ezra Micah Malsi
 * @author Mark Cedrick De Vera
 * @see Main
 * @see Node
 * @see LinkedList
 */

public class UnionFind {
	//Class Fields
	private Node[] parents;
	private int[] size;
	
    /**
     * Constructs a UnionFind instance with the specified size.
     *
     * @param size the size of the UnionFind instance
     */
	public UnionFind(int size) {
		this.parents = new Node[size];
		this.size = new int[size];

		for (int i = 0; i < parents.length; i++) {
			this.size[i] = 1;
		}
	}
	
    /**
     * A hash function for generating an index based on a key.
     *
     * @param key the key to hash
     * @return the index generated by the hash function
     */
	private int hashFunction(int key) {
		return key = key < 0 ? (key % size.length) * -1 : key % size.length;
	}

    /**
     * This method adds a new node to the UnionFind data structure. The node is 
     * first hashed using the hashFunction() method, which returns an index
     * where the node should be stored. If the index is empty (i.e., null), the node 
     * is added at that index, and the node's index is set to that index. If the index is
     * not empty, a linear probing technique is used to find the next available index 
     * for the new node. The method iterates over the array from the index returned
     * by the hash function until it finds an empty slot or until it completes a full 
     * loop of the array (in which case, the array is considered full). If the node's 
     * data is already present in the data structure, the method outputs a message
     * stating that the node already exists and returns without adding the node. 
     * Otherwise, the node is added at the first available index found through linear
     * probing, and its index is set to that index.
     * 
     * @param node the node to add
     */
	public void addNode(Node node) {
		int index = hashFunction(node.getData());
		int temp = hashFunction(node.getData());

		if (parents[index] == null) {
			parents[index] = node;
			parents[index].setIndex(index);

			return;
		} else {
			// Linear Probing
			while (parents[index] != null) {
				if (parents[index].getData() == node.getData()) {
					System.out.println("\nNode already exists in the array.");
					return;
				}

				// Compute the next index.
				index = (index + 1) % size.length;

				if (index == temp) {
					System.out.println("\nArray is full.");
					return;
				}
			}
			parents[index] = node;
			parents[index].setIndex(index);

		}
	}

	public Node findNode(int cur) {
		int index = hashFunction(cur);
		int temp = hashFunction(cur);

		while (parents[index] != null) {
			if (parents[index].getData() == cur)
				return parents[index]; // Key has been found.

			// Compute the next index.
			index = (index + 1) % size.length;

			// Break Point.
			if (index == temp)
				break; // Key has not been found.
		}
		return new Node(cur);
	}

	public boolean connected(int first, int second) {
		Node firstNode = findNode(first);
		Node secondNode = findNode(second);
		return connected(firstNode, secondNode);
	}

	public boolean connected(Node first, Node second) {
		Node root1 = findRoot(first);
		Node root2 = findRoot(second);
		return root1 == root2;
	}

	public Node findRoot(Node node) {
		while (node.getHead() != null) {
			node = node.getHead();
		}
		return node;
	}

	public void union(Node node1, Node node2) {
		if (node1 == node2) {
			System.out.println("\nBoth are the same nodes.");
			return;
		}

		if (connected(node1, node2)) {
			System.out.println("\nThe nodes are already connected.");
			return;
		}

		Node root1 = findRoot(node1);
		Node root2 = findRoot(node2);

		if (size[root1.getIndex()] >= size[root2.getIndex()]) {
			root2.setHead(root1);
			size[root1.getIndex()] += size[root2.getIndex()];
		} else {
			root1.setHead(root2);
			size[root2.getIndex()] += size[root1.getIndex()];
		}

		System.out.println("\nOperation successful!");
	}
}