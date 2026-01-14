import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String word = br.readLine();
		long answer = 0;
		long r = 1;
		for (int i = 0; i < n; i++) {
			int a = word.charAt(i) - 'a' + 1;
			long sum = (a * r) % 1234567891;
			answer += sum;
			answer %= 1234567891;
			r = (r * 31) % 1234567891;
		}
		System.out.println(answer);
	}

}
