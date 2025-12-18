import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main { 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ori = new int[n];
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			ori[i] = Integer.parseInt(st.nextToken());
			arr[i] = ori[i];
		}
		Arrays.sort(arr);
		int idx = 1;
		for(int i = 1; i < n; i++) {
			if (arr[i] == arr[idx - 1]) continue;
			arr[idx++] = arr[i];
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int start = 0, end = idx;
			while(start <= end) {
				int mid = (start + end) / 2;
				if (ori[i] == arr[mid]) {
					sb.append(mid).append(" ");
					break;
				};
				if (ori[i] < arr[mid]) end = mid - 1;
				else start = mid + 1;
			}
		}
		System.out.println(sb);
	}

}
