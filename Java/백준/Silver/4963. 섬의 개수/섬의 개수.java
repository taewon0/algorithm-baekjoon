import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int[] di = {0,0,1,-1,1,1,-1,-1};
		int[] dj = {1,-1,0,0,1,-1,1,-1};
		while (true) {
			st  = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;
			int[][] map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean[][] visited = new boolean[h][w];
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						count++;
						q.clear();
						q.addFirst(new int[] {i, j});
						while (!q.isEmpty()) {
							int[] cur = q.removeLast();
							for (int dir = 0; dir < 8; dir++) {
								int ni = cur[0] + di[dir];
								int nj = cur[1] + dj[dir];
								if (ni < 0 || nj < 0 || ni >= h || nj >= w) continue;
								if (visited[ni][nj] || map[ni][nj] == 0) continue;
								visited[ni][nj] = true;
								q.addFirst(new int[] {ni, nj});
							}
						}
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

}
