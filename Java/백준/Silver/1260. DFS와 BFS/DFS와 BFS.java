import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
	
	static class Node{
		int val;
		Node next;
		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}
	
	static Node[] nodes;
	static int m;
	static int n;
	static StringBuilder sb;
	
	public static void dfs(int v, boolean[] visited) {
		visited[v] = true;
		sb.append(v + 1).append(" ");
		for(Node tmp = nodes[v]; tmp != null; tmp = tmp.next) {
			if (!visited[tmp.val]) {
				dfs(tmp.val, visited);
			}
		}
	}
	
	public static void bfs(int v) {
		sb.append("\n");
		boolean[] visited = new boolean[n];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.addFirst(v);
		visited[v] = true;
		while(!q.isEmpty()) {
			int num = q.removeLast();
			sb.append(num + 1).append(" ");
			for(Node tmp = nodes[num]; tmp != null; tmp = tmp.next) {
				if (!visited[tmp.val]) {
					q.addFirst(tmp.val);
					visited[tmp.val] = true;
				}
			}
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken()) - 1;
		nodes = new Node[n];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			if (nodes[from] == null)
				nodes[from] = new Node(to, null);
			else {
				for (Node tmp = nodes[from]; tmp != null; tmp = tmp.next) {
					if (to < nodes[from].val) {
						nodes[from] = new Node(to, nodes[from]);
						break;
					}
					if (tmp.next == null) {
						tmp.next = new Node(to, null);
						break;
					}
					if (tmp.next.val > to) {
						tmp.next = new Node(to, tmp.next);
						break;
					}
				}
			}
			if (nodes[to] == null)
				nodes[to] = new Node(from, null);
			else {
				for (Node tmp = nodes[to]; tmp != null; tmp = tmp.next) {
					if (from < nodes[to].val) {
						nodes[to] = new Node(from, nodes[to]);
						break;
					}
					if (tmp.next == null) {
						tmp.next = new Node(from, null);
						break;
					}
					if (tmp.next.val > from) {
						tmp.next = new Node(from, tmp.next);
						break;
					}
				}
			}
		}
		sb = new StringBuilder();
		dfs(v, new boolean[n]);
		bfs(v);
	}

}
