package Ver3;

public class SetOperations {
	private int[] parent;

	public SetOperations(int n) {
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	public int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}

	public boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px == py) {
			return false; // x and y are already in the same set
		}
		parent[px] = py;
		return true;
	}
}
