import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		while (t-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[10000];
			int[] from = new int[10000];
			char[] how = new char[10000];
			visited[a] = true;
			q.addFirst(a);
			while (!q.isEmpty()) {
				int cur = q.removeLast();
				//D
				int d = cur * 2 % 10000;
				if (d == b) {
					from[d] = cur;
					how[d] = 'D';
					break;
				}
				if (!visited[d]) {
					visited[d] = true;
					from[d] = cur;
					how[d] = 'D';
					q.addFirst(d);
				}
				//S
				int s = cur == 0 ? 9999 : cur - 1;
				if (s == b) {
					from[s] = cur;
					how[s] = 'S';
					break;
				}
				if (!visited[s]) {
					visited[s] = true;
					from[s] = cur;
					how[s] = 'S';
					q.addFirst(s);
				}
				//L
				int l = cur / 1000 + cur % 1000 * 10;
				if (l == b) {
					from[l] = cur;
					how[l] = 'L';
					break;
				}
				if (!visited[l]) {
					visited[l] = true;
					from[l] = cur;
					how[l] = 'L';
					q.addFirst(l);
				}
				//R
				int r = cur % 10 * 1000 + cur / 10;
				if (r == b) {
					from[r] = cur;
					how[r] = 'R';
					break;
				}
				if (!visited[r]) {
					visited[r] = true;
					from[r] = cur;
					how[r] = 'R';
					q.addFirst(r);
				}
			}
			StringBuilder path = new StringBuilder();
			while (b != a) {
				path.append(how[b]);
				b = from[b];
			}
			sb.append(path.reverse()).append("\n");
			q.clear();
		}
		System.out.println(sb);
	}

}
