import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		/*
		 * 2를 곱하거나   10을 곱하고 1더하기
		 * 기존 dp, bfs 방식으로 할 수 없다. b의 최댓값이 10억
		 * 
		 * 일의자리로 가능한 숫자
		 * 0 가능
		 * 1 가능
		 * 2 가능
		 * 4 가능
		 * 6 가능
		 * 8 가능
		 * 
		 * b 는 어떠한 수에 2를 곱하거나 10을 곱하고 1을 더한 숫자여야함
		 * 그럼 1을 제외한 홀수로 끝나는 것은 불가능
		 * 3가지 케이스
		 * - 1로 끝
		 * - 2로 끝
		 * - 한번만 수행했다면 2가 아닌 짝수로 끝
		 * 
		 * b가 1로 끝나면 -> 1빼고 10으로 나누기
		 * b가 짝수면 -> 2로 나누기
		 */
		int cnt = 1;
		while (true) {
			if (b % 10 == 1) {
				b /= 10;
			}
			else if (b % 2 == 0) {
				b /= 2;
			}
			else break;
			cnt++;
			if (a == b) {
				System.out.println(cnt);
				return;
			}
			if (a > b) break;
		}
		System.out.println(-1);
	}

}
