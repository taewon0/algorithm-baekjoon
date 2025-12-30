import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if ((a >= b && a <= c) || (a >= c && a <= b)) {
            System.out.println(a);
            return;
        }
        if ((b >= a && b <= c) || (b >= c && b <= a)) {
            System.out.println(b);
            return;
        }
        if ((c >= b && c <= a) || (c >= a && c <= b)) {
            System.out.println(c);
            return;
        }
	}

}
