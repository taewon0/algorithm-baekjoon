import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-->0) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][3];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = i;
			}
			Arrays.sort(arr, (a, b)-> {return a[0] - b[0];});
			HashSet<Integer> set1 = new HashSet<>();
			set1.add(arr[0][2]);
			int prev = arr[0][1];
			for (int i = 1; i < n; i++) {
				if (prev > arr[i][1]) {
					prev = arr[i][1];
					set1.add(arr[i][2]);
				}
			}
			Arrays.sort(arr, (a, b)-> {return a[1] - b[1];});
			HashSet<Integer> set2 = new HashSet<>();
			set2.add(arr[0][2]);
			prev = arr[0][0];
			for (int i = 1; i < n; i++) {
				if (prev > arr[i][0]) {
					prev = arr[i][0];
					set2.add(arr[i][2]);
				}
			}
			set1.addAll(set2);
			sb.append(set1.size()).append("\n");
		}
		System.out.println(sb);
	}

}
