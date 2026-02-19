import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < line.length(); i ++) {
			if (i != 0 && i % 10 == 0) sb.append("\n");
			sb.append(line.charAt(i));
		}
		System.out.println(sb);
	}

}
