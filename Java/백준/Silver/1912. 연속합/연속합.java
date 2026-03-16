import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] d = new int[n];
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		d[0] = arr[0];
		for (int i = 1; i < n; i++) {
			d[i] = Math.max(d[i-1] + arr[i], arr[i]);
		}
		int answer = -1000000000;
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, d[i]);
		}
		System.out.println(answer);
	}

}
