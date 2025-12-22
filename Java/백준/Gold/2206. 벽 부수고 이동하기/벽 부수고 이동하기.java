import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
	
	static int[][] map;
	static boolean[][][] visited;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	static int n, m;
	
	public static int bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[0][0][0] = true;
		q.addLast(new int[] {0, 0, 1, 0});
		while (!q.isEmpty()) {
			int[] cur = q.removeFirst();
			if (cur[0] == n - 1 && cur[1] == m - 1) {
				return cur[2];
			}
			for (int dir = 0; dir < 4; dir++) {
				int ni = cur[0] + di[dir];
				int nj = cur[1] + dj[dir];
				if (valid(ni, nj)) {
					if (map[ni][nj] == 0 && !visited[ni][nj][cur[3]]) {
						visited[ni][nj][cur[3]] = true;
						q.addLast(new int[] {ni, nj, cur[2] + 1, cur[3]});
					}
					else if (map[ni][nj] == 1 && cur[3] == 0 && !visited[ni][nj][1]) {
						visited[ni][nj][1] = true;
						q.addLast(new int[] {ni, nj, cur[2] + 1, 1});
					}
				}
			}
		}
		return -1;
	}
	
	public static boolean valid(int i, int j) {
		return 0 <= i && i < n && 0 <= j && j < m;
	}
	
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
		visited = new boolean[n][m][2];
		System.out.println(bfs());
	}
}
