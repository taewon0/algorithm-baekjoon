import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] q = new int[n];
		for (int i = 0; i < n; i++) {
			q[i] = i + 1;
		}
		int head = 0;
		int answer = 0;
		int count0 = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			// 왼쪽 한번, 오른쪽 한번 해서 더 적은걸로 ㄱㄱ
			// 이미 뽑은 수는 0으로 표현
			if (q[head] == x) {
				q[head] = 0;
				count0++;
				if (count0 == n) break;
				while (q[head] == 0) head = (head + 1) % n;
			}
			else {
				int left =head, right = head, leftCount = 0, rightCount = 0;
				while (q[left] != x) {
					left = (left + 1) % n;
					while (q[left] == 0) left = (left + 1) % n; 
					leftCount++;
				}
				while (q[right] != x) {
					right = (n + right - 1) % n;
					while (q[right] == 0) right = (n + right - 1) % n; 
					rightCount++;
				}
				if (leftCount < rightCount) {
					answer += leftCount;
					head = left;
					q[head] = 0;
					count0++;
					if (count0 == n) break;
					while (q[head] == 0) head = (head + 1) % n;
				}
				else {
					answer += rightCount;
					head = right;
					q[head] = 0;
					count0++;
					if (count0 == n) break;
					while (q[head] == 0) head = (head + 1) % n;
				}
			}
		}
		System.out.println(answer);
	}

}
