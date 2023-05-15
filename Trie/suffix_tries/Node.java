package suffix_tries;

public class Node {
	private char data;
	private Node[] child;
	private boolean isChildEmpty = true;
	
	public Node() {
		setChild(new Node[2]);
	}
	
	public Node(char data) {
		this.setData(data);
		setChild(new Node[26]);
	}

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
}
