import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t-->0) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			int[][] d = new int[3][n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) sticker[0][i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) sticker[1][i] = Integer.parseInt(st.nextToken());
			
			d[0][0] = sticker[0][0];
			d[1][0] = sticker[1][0];
			d[2][0] = 0;
			for (int i = 1; i < n; i++) {
				d[0][i] = Math.max(d[1][i-1], d[2][i-1]) + sticker[0][i];
				d[1][i] = Math.max(d[0][i-1], d[2][i-1]) + sticker[1][i];
				d[2][i] = Math.max(Math.max(d[0][i-1], d[1][i-1]), d[2][i-1]);
			}
			sb.append(Math.max(Math.max(d[0][n-1], d[1][n-1]), d[2][n-1])).append("\n");
		}
		System.out.println(sb);
	}

}
