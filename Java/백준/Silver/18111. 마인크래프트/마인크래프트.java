import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] map = new int[n * m];
		int mx = 0, mn = 256;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i * m + j] = Integer.parseInt(st.nextToken());
				mx = Math.max(mx, map[i * m + j]);
				mn = Math.min(mn, map[i * m + j]);
			}
		}
		Arrays.sort(map);
		int minTime = Integer.MAX_VALUE;
		int mxH = 0;
		//500 * 500 * 256 = 64,000,000 일단 이걸로 해봄
		for (int h = mn; h <= mx; h++) {
			int time = 0;
			int left = b;
			boolean imp = false;
			for (int i = n * m - 1; i >= 0; i--) {
				if (map[i] > h) {
					left += map[i] - h;
					time += (map[i] - h) * 2;
				}
				else if (map[i] < h) {
					left -= h - map[i];
					if (left < 0) {
						imp = true;
						break;
					}
					time += h - map[i];
				}
			}
			if (imp) continue;
			if (time < minTime) {
				minTime = time;
				mxH = h;
			}
			else if (time ==  minTime) {
				mxH = Math.max(mxH, h);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(minTime).append(" ").append(mxH);
		System.out.println(sb);
	}

}
