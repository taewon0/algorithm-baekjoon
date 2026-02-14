import java.util.*;
import java.io.*;
public class Main {
	
	public static int n;
	public static int m;
	public static int[] input;
	public static int[] arr;
	public static boolean[] isUsed;
	public static StringBuilder sb;
	
	public static void findSequence(int k) {
		if (k == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int prev = 0;
		for(int i = 0; i < input.length; i++) {
			if (!isUsed[i] && prev != input[i]) {
				arr[k] = input[i];
				isUsed[i] = true;
				prev = input[i];
				findSequence(k + 1);
				isUsed[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n];
		arr = new int[m];
		isUsed = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
		sb = new StringBuilder();
		findSequence(0);
		System.out.println(sb);
	}

}
