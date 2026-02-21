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
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int[][] edges = new int[e][3];
		parent = new int[v+1];
		for (int i = 1; i <= v; i++) parent[i] = i;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(edges, (a, b)->{return a[2]-b[2];});
		int answer = 0, picked = 0;
		for (int[] edge : edges) {
			if (find(edge[0]) != find(edge[1])) {
				union(edge[0], edge[1]);
				answer += edge[2];
				picked++;
				if (picked == v - 1) break;
			}
		}
		System.out.println(answer);
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa != pb) parent[pa] = pb;
	}

	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

}
