package suffix_tries;

public class SuffixTrie {
	private Node root;
	private boolean isChildFull = false;
	
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	
	public SuffixTrie() {
		root = new Node();
	}
	
	public int hashKey(char x) {
		int key = x - 'a';
		return key;
	}
	
	public void insert(String text) {
		Node temp = root;
		for(int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			int key = hashKey(currentChar);
			
			if(i == 0) {
				if(!isChildFull) {
					if(root.getChild()[0] == null) {
						temp.getChild()[0] = new Node(currentChar);
						temp = temp.getChild()[0];
					} 
					else if(root.getChild()[1] == null && currentChar != root.getChild()[0].getData()) {
						temp.getChild()[1] = new Node(currentChar);
						temp = temp.getChild()[1];
						isChildFull = true;
					} else temp = temp.getChild()[0];
				} else {
					if(root.getChild()[0].getData() == text.charAt(0)) temp = temp.getChild()[0];
					else temp = temp.getChild()[1];
				}
			} else {
				if(temp.getChild()[key] == null) {
					temp.getChild()[key] = new Node(currentChar);
					temp = temp.getChild()[key];
				} 
				else {
					temp = temp.getChild()[key];
				} 
			}
		}
	}
	
	public void search(Node node) {
		
	}
}
