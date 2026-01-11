import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		int[] d = new int[n + 2];
		int mx = 0;
		for(int i = 1; i <= n; i++) {
			if (mx < d[i]) mx = d[i];
			int next = i + t[i];
			if (next <= n + 1) {
				d[next] = Math.max(d[next], mx + p[i]);
			}
		}
		if (d[n + 1] > mx) mx = d[n + 1];
		System.out.println(mx);
	}

}
