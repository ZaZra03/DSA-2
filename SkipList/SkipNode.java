public class SkipNode {
	private int data;
	private SkipNode next;
	private Node bottom;
	
	public SkipNode() {
		setData(0);
		setNext(null);
		setBottom(null);
	}
	
	public SkipNode(int data, Node bottom) {
		this.data = data;
		this.bottom = bottom;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SkipNode getNext() {
		return next;
	}

	public void setNext(SkipNode next) {
		this.next = next;
	}

	public Node getBottom() {
		return bottom;
	}

	public void setBottom(Node bottom) {
		this.bottom = bottom;
	}
}