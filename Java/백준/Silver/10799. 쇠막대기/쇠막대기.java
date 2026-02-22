import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		ArrayDeque<Character> stack = new ArrayDeque<>();
		int answer = 0;
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '(') {
				stack.addFirst(c);
			}
			else {
				stack.removeFirst();
				answer += line.charAt(i-1) == '(' ? stack.size() : 1;
			}
		}
		System.out.println(answer);
	}

}
