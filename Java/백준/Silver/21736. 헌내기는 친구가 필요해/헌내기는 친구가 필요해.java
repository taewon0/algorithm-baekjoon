import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map;
	static int n, m;
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		int startI = 0, startJ = 0;
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'I') {
					startI = i; startJ = j;
				}
			}
		}
		
		bfs(startI, startJ);
		
		if (answer == 0) System.out.println("TT");
		else System.out.println(answer);
	}
	
	static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];
		visited[x][y] = true;
		q.addFirst(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] cur = q.removeLast();
			for (int dir = 0; dir < 4; dir++) {
				int ni = cur[0] + di[dir];
				int nj = cur[1] + dj[dir];
				if (ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
				if (map[ni][nj] == 'X') continue;
				if (!visited[ni][nj]) {
					if (map[ni][nj] == 'P') answer++;
					q.addFirst(new int[] {ni, nj});
					visited[ni][nj] = true;
				}
			}
		}
	}
}
