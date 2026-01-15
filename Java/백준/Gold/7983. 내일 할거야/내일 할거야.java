import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] dt = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dt[i][0] = Integer.parseInt(st.nextToken());
			dt[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(dt, (a, b) -> {
			return b[1] - a[1];
		});
		int day = dt[0][1] - dt[0][0];
		for (int i = 1; i < n; i++) {
			if (dt[i][1] >= day) {
				day -= dt[i][0];
			}
			else {
				day = dt[i][1] - dt[i][0];
			}
		}
		System.out.println(day);
	}

}
