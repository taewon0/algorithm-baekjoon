import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}

	private static long bfs() {
		long[][] count = new long[n][n];
		count[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!(i == 0 && j == 0) && count[i][j] == 0) continue;
				if (i == n-1 && j == n-1) continue;
				if (i + map[i][j] < n) {
					count[i + map[i][j]][j] += count[i][j];
				}
				if (j + map[i][j] < n) {
					count[i][j + map[i][j]] += count[i][j];
				}
			}
		}
		return count[n-1][n-1];
	}

}
