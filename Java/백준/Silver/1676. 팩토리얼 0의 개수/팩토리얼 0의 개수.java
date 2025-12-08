import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int two = 0, five = 0;
		for (int i = 1; i <= n; i++) {
			two += count(i, 2);
			five += count(i ,5);
		}
		System.out.println(Math.min(two, five));
	}
	
	static int count(int n, int num) {
		int cnt = 0;
		while (n % num == 0) {
			cnt++;
			n /= num;
		}
		return cnt;
	}

}
