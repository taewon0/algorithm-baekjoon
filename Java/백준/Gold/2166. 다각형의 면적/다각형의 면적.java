import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] point = new long[n][2];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Long.parseLong(st.nextToken());
			point[i][1] = Long.parseLong(st.nextToken());
		}
		System.out.printf("%.1f",crossProduct(point, n));
	}

	private static double crossProduct(long[][] point, int n) {
		long a = 0, b  = 0;
		for (int i = 0; i < n - 1; i++) {
			a += point[i][0] * point[i+1][1];
			b += point[i][1] * point[i+1][0];
		}
		a += point[n-1][0] * point[0][1];
		b += point[n-1][1] * point[0][0];
		return Math.abs(a - b) / 2.0;
	}

}
