import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		ArrayList<int[]> ji = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			ji.add(new int[] {s,e,w});
		}
		Collections.sort(ji, (a,b)->{return a[1]-b[1];});
		int[] dp = new int[d+1];
		dp[0] = 0;
		for (int i = 1; i <= d; i++) {
			dp[i] = dp[i-1] + 1;
			while (!ji.isEmpty() && ji.get(0)[1] == i) {
				int[] cur = ji.remove(0);
				if (cur[1] - cur[0] <= cur[2]) continue;
				dp[i] = Math.min(dp[i], dp[cur[0]] + cur[2]);
			}
//			System.out.println(dp[i]);
		}
		System.out.println(dp[d]);
	}

}
