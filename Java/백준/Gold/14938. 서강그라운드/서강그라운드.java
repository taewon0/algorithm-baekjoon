import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<int[]>[] graph;
	static int n, m;
	static int[] t, d;
	static int maxValue = 0;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		graph = new ArrayList[n + 1];
		t = new int[n + 1]; d = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			t[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, l});
			graph[b].add(new int[] {a, l});
		}
		
		for (int i = 1; i <= n; i++) {
			dijkstra(i);
		}
		System.out.println(maxValue);
	}
	
	static void dijkstra(int start) {
		for (int i = 1; i <= n; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		d[start] = 0;
		int result = 0;
		pq.clear();
		pq.offer(new int[] {start, 0});
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (d[cur[0]] < cur[1]) continue;
			for (int[] next : graph[cur[0]]) {
				if (d[next[0]] > cur[1] + next[1]) {
					d[next[0]] = cur[1] + next[1];
					pq.offer(new int[] {next[0], d[next[0]]});
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (d[i] <= m) result += t[i];
		}
		maxValue = Math.max(result, maxValue);
	}

}
