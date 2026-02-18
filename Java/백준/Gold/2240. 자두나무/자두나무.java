import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] tree = new int[t + 1];
		for (int i = 1; i <= t; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		int[][] d = new int[t+1][w+1];
		for (int i = 1; i <= t; i++) {
			int maxW = Math.min(w, t);
			
			for (int j = 0; j <= maxW; j++) {
				int cur = (j % 2 == 0) ? 1 : 2;
				int bonus = (tree[i] == cur) ? 1 : 0;
				
				if (j == 0) {
					d[i][j] = d[i-1][j] + bonus;
				} else {
					d[i][j] = Math.max(d[i-1][j], d[i-1][j-1]) + bonus;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i <= w; i++) {
			answer = Math.max(answer, d[t][i]);
		}
		System.out.println(answer);
	}

}
