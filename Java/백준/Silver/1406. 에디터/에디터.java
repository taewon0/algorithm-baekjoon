import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int m = Integer.parseInt(br.readLine());
		ArrayDeque<Character> leftQ = new ArrayDeque<>();
		for (int i = 0; i < str.length(); i++) {
			leftQ.addLast(str.charAt(i));
		}
		ArrayDeque<Character> rightQ = new ArrayDeque<>();
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String comm = st.nextToken();
			if (comm.equals("P")) {
				char c = st.nextToken().charAt(0);
				leftQ.addLast(c);
			}
			else if (comm.equals("L")) {
				if (!leftQ.isEmpty())
					rightQ.addFirst(leftQ.removeLast());
			}
			else if (comm.equals("D")) {
				if (!rightQ.isEmpty())
					leftQ.addLast(rightQ.removeFirst());
			}
			else {
				if (!leftQ.isEmpty())
					leftQ.removeLast();
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!leftQ.isEmpty()) {
			sb.append(leftQ.removeFirst());
		}
		while(!rightQ.isEmpty()) {
			sb.append(rightQ.removeFirst());
		}
		System.out.println(sb);
	}
}
