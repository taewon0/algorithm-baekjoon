import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] a = new int [n];
		int [] b = new int [n];
		StringTokenizer sta = new StringTokenizer(br.readLine());
		StringTokenizer stb = new StringTokenizer(br.readLine());
		int i;
		for(i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sta.nextToken());
			b[i] = Integer.parseInt(stb.nextToken());
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int answer = 0;
		for(i = 0; i < n; i++)
			answer += a[i] * b[n - 1 - i];
		System.out.println(answer);
	}
}
