import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			set.add(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			set.remove(st.nextToken());
		}
		for (String last : set) System.out.println(last);
	}

}
