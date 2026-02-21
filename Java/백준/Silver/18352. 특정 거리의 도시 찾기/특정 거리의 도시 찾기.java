import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		ArrayList<Integer> answerList = new ArrayList<>();
		for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.addFirst(new int[] {x, 0});
		boolean[] visited = new boolean[n + 1];
		visited[x] = true;
		boolean end = false;
		while (!q.isEmpty()) {
			int[] cur = q.removeLast();
			for (int chd : graph[cur[0]]) {
				if (!visited[chd]) {
					if (cur[1] + 1 > k) {
						end = true;
						break;
					}
					if (cur[1] + 1 == k) answerList.add(chd);
					q.addFirst(new int[] {chd, cur[1] + 1});
					visited[chd] = true;
				}
			}
			if (end) break;
		}
		if (answerList.isEmpty()) {
			System.out.println(-1);
			return;
		}
		Collections.sort(answerList);
		StringBuilder sb = new StringBuilder();
		for (int a : answerList) {
			sb.append(a).append("\n");
		}
		System.out.println(sb);
	}

}
