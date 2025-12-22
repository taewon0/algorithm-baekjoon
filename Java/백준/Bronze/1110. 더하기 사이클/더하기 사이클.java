import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = n;
		while (true) {
			cnt++;
			int nnum = num % 10 * 10;
			int sum = num % 10 + num / 10;
			nnum += sum % 10;
			if (nnum == n) break;
			num = nnum;
		}
		System.out.println(cnt);
	}
	
}
