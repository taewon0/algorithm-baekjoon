import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			long[] p = new long[n + 5];
			p[1] = 1; p[2] = 1; p[3] = 1;
			for(int j = 4; j <= n; j++) {
				p[j] = p[j - 2] + p[j - 3];
			}
			sb.append(p[n]).append("\n");
		}
		System.out.println(sb);
	}

}
