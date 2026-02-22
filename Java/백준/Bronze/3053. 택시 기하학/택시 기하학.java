import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long r = Long.parseLong(br.readLine());
		System.out.printf("%.6f\n", Math.PI * r * r);
		System.out.printf("%.6f", 2.0 * r * r);
	}

}
