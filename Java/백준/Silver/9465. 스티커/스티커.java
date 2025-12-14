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
			int[][][] d = new int[2][n][2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) sticker[0][i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) sticker[1][i] = Integer.parseInt(st.nextToken());
			
			d[0][0][0] = sticker[1][0];
			d[0][0][1] = sticker[0][0];
			d[1][0][0] = sticker[0][0];
			d[1][0][1] = sticker[1][0];
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					if (j == 0) {
						d[j][i][0] = Math.max(d[j][i-1][0], d[j][i-1][1]);
						d[j][i][1] = d[j][i-1][0] + sticker[j][i];
					}
					else if (j == 1) {
						d[j][i][0] = Math.max(d[j][i-1][0], d[j][i-1][1]);
						d[j][i][0] = Math.max(d[j][i][0], d[0][i][0]);
						d[j][i][0] = Math.max(d[j][i][0], d[0][i][1]);
						
						d[j][i][1] = d[j][i-1][0] + sticker[j][i];
						
						d[0][i][0] = Math.max(d[0][i][0], d[j][i][1]);
					}
//					System.out.print(d[j][i][0]);
//					System.out.println(" "+d[j][i][1]);
				}
			}
			sb.append(Math.max(d[1][n-1][0], d[1][n-1][1])).append("\n");
		}
		System.out.println(sb);
	}

}
