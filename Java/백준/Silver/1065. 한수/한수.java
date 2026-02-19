import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		/*
		 * 모든 한자리, 두자리 숫자는 각 자릿수가 등차수열을 이룬다.
		 * 세자리부터는?
		 * 1부터 돌면서 등차수열을 만든다.
		 * 1, 11, 12, 13 ... 그 수가 등차수열이면 등차 만큼 다음 자릿수를 추가하여 그 수도 true 처리
		 */
		if (n < 100) {
			System.out.println(n);
			return;
		}
		boolean[] arr = new boolean[n + 1];
		for (int i = 1; i <= 99; i++) {
			arr[i] = true;
		}
		for (int i = 100; i <= n; i++) {
			//i의 이전 자릿수까지가 등차수열이면 등차를 구해 1의자리가 그와 같은 만큼 증가된 수라면 한수
			int prev = i / 10;
			if (arr[prev]) {
				int diff = (prev % 10) - (prev / 10 % 10);
				if (prev % 10 + diff == i % 10) arr[i] = true;
			}
		}
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (arr[i]) answer++;
		}
		System.out.println(answer);
	}

}
