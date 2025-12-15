import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int i;
		int [] coin = new int[n];
		for(i = 0; i < n; i++)
			coin[i] = Integer.parseInt(br.readLine());
		int answer = 0;
		for(i = n - 1; i >= 0; i--) {
			answer += k / coin[i];
			k %= coin[i];
		}
		System.out.println(answer);
	}
}
