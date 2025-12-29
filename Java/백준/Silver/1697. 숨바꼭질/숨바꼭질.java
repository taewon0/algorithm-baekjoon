import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		if (start > dest) {
			System.out.println(start - dest);
			return;
		}
		int[] d = new int[100002];
		for (int i = 0; i <= 100000; i++) {
			if (i <= start) d[i] = start - i;
			else {
				if (d[i] == 0) d[i] = d[i - 1] + 1;
				else d[i] = Math.min(d[i], d[i - 1] + 1);
				if (d[i + 1] != 0) d[i] = Math.min(d[i], d[i + 1] + 1);
				if (i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
				
				d[i - 1] = Math.min(d[i] + 1, d[i - 1]);
				if (i + 1 <= 100000 && d[i + 1] != 0) d[i + 1] = Math.min(d[i] + 1, d[i + 1]);
				if (i * 2 <= 100000 && d[i * 2] != 0) d[i * 2] = Math.min(d[i] + 1, d[i * 2]);
			}
		}
		System.out.println(d[dest]);
	}
}
