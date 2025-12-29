import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n][n];
		int min = 101 ,max = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
				max = Math.max(max, arr[i][j]);
			}	
		}
		int answer = 0;
		int [] di = {1, -1, 0, 0};
		int [] dj = {0, 0, 1, -1};
		for(int w = min - 1; w <= max; w++) {
			int count = 0;
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if (arr[i][j] > w && !visited[i][j]) {
						count++;
						visited[i][j] = true;
						q.add(new int[] {i, j});
						while(!q.isEmpty()) {
							int[] dot = q.poll();
							for(int dir = 0; dir < 4; dir++) {
								int ni = dot[0] + di[dir];
								int nj = dot[1] + dj[dir];
								if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
								if (arr[ni][nj] > w && !visited[ni][nj]) {
									visited[ni][nj] = true;
									q.add(new int[] {ni, nj});
								}
							}
						}
					}
				}
			}
			answer = Math.max(count, answer);
		}
		System.out.println(answer);
	}
}
