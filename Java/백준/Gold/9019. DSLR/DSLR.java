import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		class Path {
			int val;
			String path;
			
			public Path(int val, String path) {
				this.val = val;
				this.path = path;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayDeque<Path> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		while (t-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[10000];
			visited[a] = true;
			q.addFirst(new Path(a, ""));
			while (!q.isEmpty()) {
				Path cur = q.removeLast();
				//D
				int d = cur.val * 2 % 10000;
				if (d == b) {
					sb.append(cur.path).append("D").append("\n");
					break;
				}
				if (!visited[d]) {
					visited[d] = true;
					q.addFirst(new Path(d, new StringBuilder().append(cur.path).append("D").toString()));
				}
				//S
				int s = cur.val == 0 ? 9999 : cur.val - 1;
				if (s == b) {
					sb.append(cur.path).append("S").append("\n");
					break;
				}
				if (!visited[s]) {
					visited[s] = true;
					q.addFirst(new Path(s, new StringBuilder().append(cur.path).append("S").toString()));
				}
				//L
				int l = cur.val / 1000 + cur.val % 1000 * 10;
				if (l == b) {
					sb.append(cur.path).append("L").append("\n");
					break;
				}
				if (!visited[l]) {
					visited[l] = true;
					q.addFirst(new Path(l, new StringBuilder().append(cur.path).append("L").toString()));
				}
				//R
				int r = cur.val % 10 * 1000 + cur.val / 10;
				if (r == b) {
					sb.append(cur.path).append("R").append("\n");
					break;
				}
				if (!visited[r]) {
					visited[r] = true;
					q.addFirst(new Path(r, new StringBuilder().append(cur.path).append("R").toString()));
				}
				
			}
			q.clear();
		}
		System.out.println(sb);
	}

}
