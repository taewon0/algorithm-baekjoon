import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		bfs();
	}

	
	static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		boolean [][] visited = new boolean[n][m];
		visited[0][0] = true;
		q.addFirst(new int[] {0,0,1});
		while (!q.isEmpty()) {
			int[] cur = q.removeLast();
			for (int dir = 0; dir < 4; dir++) {
				int ni = cur[0] + di[dir];
				int nj = cur[1] + dj[dir];
				if (ni == n-1 && nj == m-1) {
					System.out.println(cur[2] + 1);
					return;
				}
				if (ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
				if (visited[ni][nj] || map[ni][nj] == 0) continue;
				visited[ni][nj] = true;
				q.addFirst(new int[] {ni, nj, cur[2] + 1});
			}
		}
	}
	
}
