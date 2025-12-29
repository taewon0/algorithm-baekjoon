import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = 0, mx = 0;
		int[] request = new int[n];
		for(int i = 0; i < n; i++) {
			request[i] = Integer.parseInt(st.nextToken());
			total += request[i];
			mx = Math.max(mx, request[i]);
		}
		int yesan = Integer.parseInt(br.readLine());
		if (total <= yesan) {
			System.out.println(mx);
			return;
		}
		int left = 0, right = mx, mid;
		while (true) {
			mid = (left + right) / 2;
			total = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (mid > request[i]) {
					total += request[i];
				}
				else total += mid;
			}
			if (total < yesan) {
				left = mid;
			}
			else if (total > yesan) {
				right = mid;
			}
			else break;
			if (left + 1 == right && total < yesan) break;
			if (left + 1 == right && total > yesan) {
				mid--;
				break;
			}
		}
		System.out.println(mid);
	}

}
