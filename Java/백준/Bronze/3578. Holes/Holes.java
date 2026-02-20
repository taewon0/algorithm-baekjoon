import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h = Integer.parseInt(br.readLine());
		if (h == 0) {
			System.out.println(1);
			return;
		}
		if (h == 1) {
			System.out.println(0);
			return;
		}
		StringBuilder sb = new StringBuilder();
		if (h % 2 == 1) sb.append(4);
		for (int i = 0; i < h / 2; i++) {
			sb.append(8);
		}
		System.out.println(sb);
	}

}
