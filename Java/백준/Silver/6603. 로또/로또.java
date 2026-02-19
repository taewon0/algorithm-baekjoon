import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr = new int[6], num;
	static int k;
	static StringBuilder sb = new StringBuilder();
	
	static void bt(int d, int start) {
		if (d == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < k; i++) {
			arr[d] = num[i];
			bt(d + 1, i + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				System.out.println(sb);
				return;
			}
			num = new int[k];
			for (int i = 0; i < k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			bt(0, 0);
			sb.append("\n");
		}
	}

}
