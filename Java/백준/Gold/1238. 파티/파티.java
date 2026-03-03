import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Main {
	
	static int n, m, x;
	static PriorityQueue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		int[] dgo = new int[n + 1];
		int[] dcome = new int[n + 1];
		ArrayList<int[]>[] graph = new ArrayList[n + 1];
		ArrayList<int[]>[] graph2 = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<int[]>();
			graph2[i] = new ArrayList<int[]>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			graph[end].add(new int[] {start, time});
			graph2[start].add(new int[] {end, time});
		}
		q = new PriorityQueue<>(
				(a, b) -> { return a[1] - b[1]; });
		for (int i = 1; i <= n; i++) {
			dgo[i] = Integer.MAX_VALUE;
			dcome[i] = Integer.MAX_VALUE;
		}
		dgo[x] = 0;
		dcome[x] = 0;
		dijkstra(dgo, graph);
		dijkstra(dcome, graph2);
		int answer = -1;
		for (int i = 1; i <= n; i++) {
			answer = Math.max(dgo[i] + dcome[i], answer);
		}
		System.out.println(answer);
	}
	
	public static void dijkstra(int[] d, ArrayList<int[]>[] graph) {
		q.offer(new int[] {x, 0});
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (d[cur[0]] < cur[1]) continue;
			for (int[] next : graph[cur[0]]) {
				if (d[next[0]] > cur[1] + next[1]) {
					d[next[0]] = cur[1] + next[1];
					q.offer(new int[] {next[0], d[next[0]]});
				}
			}
		}
	}

}
