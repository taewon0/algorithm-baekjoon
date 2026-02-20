import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-->0) {
			String color = br.readLine();
			int countA = 0, countB = 0;
			for (int i = 0; i < color.length(); i++) {
				if (color.charAt(i) == 'a') countA++;
				else countB++;
			}
			sb.append(Math.min(countA, countB)).append("\n");
		}
		System.out.println(sb);
	}

}
