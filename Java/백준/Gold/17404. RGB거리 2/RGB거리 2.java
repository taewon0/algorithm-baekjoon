import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] h = new int[n + 1][4];
		int[][] d = new int[n + 1][4];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			h[i][1] = Integer.parseInt(st.nextToken());
			h[i][2] = Integer.parseInt(st.nextToken());
			h[i][3] = Integer.parseInt(st.nextToken());
		}
		int answer = 10000000;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				d[1][j] = i == j ? h[1][j] : 10000;
			}
			for (int j = 2; j <= n; j++) {
				d[j][1] = Math.min(d[j-1][2], d[j-1][3]) + h[j][1];
				d[j][2] = Math.min(d[j-1][1], d[j-1][3]) + h[j][2];
				d[j][3] = Math.min(d[j-1][2], d[j-1][1]) + h[j][3];
			}
			if (i == 1) {
				answer = Math.min(answer, d[n][2]);
				answer = Math.min(answer, d[n][3]);
			}
			else if (i == 2) {
				answer = Math.min(answer, d[n][3]);
				answer = Math.min(answer, d[n][1]);
			}
			else {
				answer = Math.min(answer, d[n][1]);
				answer = Math.min(answer, d[n][2]);
			}
		}
		
		System.out.println(answer);
	}

}
