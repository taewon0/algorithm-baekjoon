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
			switch(comm) {
			case "push_front" : {d.addFirst(Integer.parseInt(st.nextToken()));break;}
			case "push_back" : {d.addLast(Integer.parseInt(st.nextToken()));break;}
			case "pop_front" : {sb.append(d.isEmpty() ? -1 : d.removeFirst()).append("\n");break;}
			case "pop_back" : {sb.append(d.isEmpty() ? -1 : d.removeLast()).append("\n");break;}
			case "size" : {sb.append(d.size()).append("\n");break;}
			case "empty" : {sb.append(d.isEmpty() ? 1 : 0).append("\n");break;}
			case "front" : {sb.append(d.isEmpty() ? -1 : d.getFirst()).append("\n");break;}
			case "back" : {sb.append(d.isEmpty() ? -1 : d.getLast()).append("\n");break;}
			default : break;
			}
		}
		System.out.println(sb);
	}

}
