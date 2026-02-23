import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int V;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (K-->0) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] graph = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;
				graph[u].add(v);
				graph[v].add(u);
			}
			if (bfs(graph)) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb);
	}
	
	static boolean bfs(ArrayList<Integer>[] graph) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int[] visited = new int[V];
		for (int i = 0; i < V; i++) {
			if (visited[i] != 0) continue;
			visited[i] = 1;
			q.addLast(i);
			while (!q.isEmpty()) {
				int cur = q.removeFirst();
				for (int x : graph[cur]) {
					if (visited[x] == visited[cur]) return false;
					if (visited[x] == 0) {
						q.addLast(x);
						visited[x] = -visited[cur];
					}
				}
			}
		}
		return true;
	}
	
}
