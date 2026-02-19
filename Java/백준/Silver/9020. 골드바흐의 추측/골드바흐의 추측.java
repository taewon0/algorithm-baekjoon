import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static boolean[] isPrime = new boolean[10001];
	
	//에라토스테네스의 체로 10000이하의 모든 소수 구하기
	static void getAllPrime() {
		for (int i = 2; i <= 10000; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i <= 10000; i++) {
			if (!isPrime[i]) continue;
			
			for (int j = i * i; j <= 10000; j += i) {
				isPrime[j] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		getAllPrime();
		while (t-->0) {
			int n = Integer.parseInt(br.readLine());
			/*
			 * n 이하의 모든 소수를 구함? -> 에라토스테네스의 체
			 * n - 그 소수 ==  소수 이면 한쌍 구함. 이런 쌍들을 모두 구해서 가장 차이 작은거 하나 저장
			 */
			int p1 = 0, p2 = 10000;
			for (int i = 2; i <= n / 2; i++) {
				if (isPrime[i] && isPrime[n - i]) {
					if (p2 - p1 > n - i - i) {
						p1 = i; p2 = n - i;
					}
				}
			}
			sb.append(p1).append(" ").append(p2).append("\n");
		}
		System.out.println(sb);
	}

}
