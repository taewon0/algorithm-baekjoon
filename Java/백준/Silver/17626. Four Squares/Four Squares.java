import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static boolean find;
	static int[] select = new int[3], arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		/*
		 * 자연수 n은 4개 혹은 그 이하의 자연수의 제곱의 합으로 표현 가능
		 * 
		 * 우선 n이 제곱수면 답은 1
		 * 2개의 합으로 표현 가능한지 체크 -> 50000, 앞에서 부터 하나 선택 후 걔 제곱을 n에서 뺀게 제곱수인지 확인
		 * 3개의 합으로 표현 가능한지 체크 -> 
		 * 4개의 합으로 표현 가능한지 체크 위가 다 아니면 무조건 이거
		 * 
		 * 
		 * 50000 이하의 제곱수를 모두 구한다.
		 * 1,4,9,16,25,36,49,64,81,100
		 * 121,...40000, ... 223x223=49729까지 총 223개 있음
		 * 
		 * !!!!!중복이 허용된다................
		 * 223^2 = 49729
		 * 223C3 = 11089567
		 * 아니면 무조건 4
		 *
		 * 2개만 찾는 bt 먼저 하고, 3개 찾는 bt 진행.
		 * bt 진행 중 더 적은 개수에서 찾는순간 종료
		 */
		int a = (int) Math.sqrt(n);
		if (a * a == n) {
			System.out.println(1);
			return;
		}
		arr = new int[224];
		for (int i = 1; i < 224; i++) {
			arr[i] = i * i;
		}
		bt(0, 2);
		if (find) {
			System.out.println(2);
			return;
		}
		bt(0, 3);
		if (find) {
			System.out.println(3);
			return;
		}
		System.out.println(4);
	}
	
	static void bt(int d, int end) {
		if (d == end) {
			int sum = 0;
			for (int i = 0; i < end; i++) {
				sum += select[i];
			}
			if (sum == n) {
				find = true;
			}
			return;
		}
		for (int i = 1; i < 224; i++) {
			select[d] = arr[i];
			bt(d+1, end);
			if (find) return;
		}
	}

}
