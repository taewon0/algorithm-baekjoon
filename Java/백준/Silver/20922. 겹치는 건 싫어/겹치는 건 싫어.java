import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] map = new int[100001];
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		int[] seq = new int[n];
		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		int rear = 0, front = 0;
		while(front < n && rear < n) {
			if (map[seq[rear]] < k) {
				map[seq[rear]]++;
				rear++;
			}
			else {
				while (map[seq[rear]] == k) {
					map[seq[front]]--;
					front++;
				}
			}
			answer = Math.max(answer, rear - front);
		}
		System.out.println(answer);
	}
}
