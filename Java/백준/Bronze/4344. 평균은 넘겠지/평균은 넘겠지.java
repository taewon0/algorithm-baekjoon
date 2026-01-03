import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			double avg = 0;
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				avg += arr[j];
			}
			avg /= n;
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j] > avg) cnt++;
			}
//			sb.append((double)cnt/n * 100).append("\n");
			sb.append(String.format("%.3f%%", (double)cnt/n * 100)).append("\n");
		}
		System.out.println(sb);
	}

}
