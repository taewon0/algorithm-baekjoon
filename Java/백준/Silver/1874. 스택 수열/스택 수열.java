import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		s.push(0);
		int outStack = 1;
		int flag = 1;
		int i, cur;
		for (i = 0; i < n; i++) {
			cur = Integer.parseInt(br.readLine());
			if (flag == 1) {
				while(!s.isEmpty() && s.peek() < cur) {
					sb.append("+\n");
					s.push(outStack++);
				}
				if (s.peek() != cur) {
					flag = 0;
					continue;
				}
				s.pop();
				sb.append("-\n");
			}
		}
		if (flag == 1) System.out.println(sb);
		else System.out.println("NO");
	}

}
