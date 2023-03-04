package Ver2;

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
 * @class UnionFind
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

    /**
     * The findNode method takes an integer value as input and searches for a 
     * node with that value in the parents array. It uses the hashFunction to
     * calculate the index at which the node should be located in the array. If the 
     * node is found at that index, it is returned. If not, the method performs linear
     * probing to search for the node in the array. Linear probing involves checking
     * the next index in the array until an empty spot is found or the entire array 
     * has been searched. If the node is not found after the entire array has been 
     * searched, a new node with the specified value is created and returned.
     *
     * @param cur the value to search for
     * @return the node with the specified value if found, otherwise a new node with the specified value
     */
	public Node findNode(int cur) {
		int index = hashFunction(cur);
		int temp = hashFunction(cur);

		while (parents[index] != null) {
			if (parents[index].getData() == cur)
				return parents[index]; // Key has been found.

			// Compute the next index.
			index = (index + 1) % size.length;

			// Break Point.
			if (index == temp) {
				System.out.println("\nERROR! That number is not part of the set. Please try again!\n");
				break; // Key has not been found.
			}
				
		}
		return new Node(cur);
	}
	
    /**
     * Determines if two values are connected.
     *
     * @param first  Integer the first value
     * @param second Integer the second value
     * @return true if the two values are connected, false otherwise
     */
	public boolean connected(int first, int second) {
		Node firstNode = findNode(first);
		Node secondNode = findNode(second);
		return connected(firstNode, secondNode);
	}

    /**
     * Determines if two values are connected.
     *
     * @param first  Node the first value
     * @param second Node the second value
     * @return true if the two values are connected, false otherwise
     */
	public boolean connected(Node first, Node second) {
		Node root1 = findRoot(first);
		Node root2 = findRoot(second);
		return root1 == root2;
	}

    /**
     * This method finds and returns the root node of a given node.
     * Starting from the given node, the method iteratively follows the head field 
     * to its parent until the head field of the current node is null, which 
     * indicates that it is the root node. Once the root node is found, the method 
     * returns it.
     *
     * @param node the node to find the root of
     * @return the root node of the tree that contains the given node
     */
    public Node findRoot(Node node) {
        while (node.getHead() != null) {
            node = node.getHead();
        }
        return node;
    }

    /**
     * This code implements the union-find data structure using the weighted
     * quick-union algorithm to connect two nodes by linking the root of the 
     * smaller tree to the root of the larger tree, and updates the size of the larger 
     * tree accordingly. It also includes checks for nodes that are already connected 
     * or are the same node.
     *
     * @param node1 the first node to merge
     * @param node2 the second node to merge
     */
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

    // Other methods omitted for brevity
}
