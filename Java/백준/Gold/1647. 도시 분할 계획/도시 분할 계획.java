import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) parent[i] = i;
		int[][] edges = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(edges, (a,b)->{return a[2] - b[2];});
		int answer = 0, mx = 0;
		for (int[] edge : edges) {
			if (find(edge[0]) != find(edge[1])) {
				answer += edge[2];
				mx = Math.max(mx, edge[2]);
				union(edge[0], edge[1]);
			}
		}
		System.out.println(answer - mx);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa != pb) parent[pa] = pb;
	}
	
	static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}

}
