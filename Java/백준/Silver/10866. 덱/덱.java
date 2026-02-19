import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> d = new ArrayDeque<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (n-->0) {
			st = new StringTokenizer(br.readLine());
			String comm = st.nextToken();
			if (comm.equals("push_front")) {
				d.addFirst(Integer.parseInt(st.nextToken()));
			}
			else if (comm.equals("push_back")) {
				d.addLast(Integer.parseInt(st.nextToken()));
			}
			else if (comm.equals("pop_front")) {
				sb.append(d.isEmpty() ? -1 : d.removeFirst()).append("\n");
			}
			else if (comm.equals("pop_back")) {
				sb.append(d.isEmpty() ? -1 : d.removeLast()).append("\n");
			}
			else if (comm.equals("size")) {
				sb.append(d.size()).append("\n");
			}
			else if (comm.equals("empty")) {
				sb.append(d.isEmpty() ? 1 : 0).append("\n");
			}
			else if (comm.equals("front")) {
				sb.append(d.isEmpty() ? -1 : d.getFirst()).append("\n");
			}
			else if (comm.equals("back")) {
				sb.append(d.isEmpty() ? -1 : d.getLast()).append("\n");
			}
		}
		System.out.println(sb);
	}

}
