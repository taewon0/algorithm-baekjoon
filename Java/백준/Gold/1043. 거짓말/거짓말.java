import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int tn = Integer.parseInt(st.nextToken());
		HashSet<Integer> t = new HashSet<>();
		for (int i = 0; i < tn; i++) {
			int num = Integer.parseInt(st.nextToken());
			t.add(num);
		}
		HashSet<Integer>[] party = new HashSet[m];
		for (int i = 0; i < m; i++) {
			party[i] = new HashSet<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int pn = Integer.parseInt(st.nextToken());
			for (int j = 0; j < pn; j++) {
				int num = Integer.parseInt(st.nextToken());
				party[i].add(num);
			}
		}
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0; i < m; i++) {
				boolean isKnow = false;
				for (int num : party[i]) {
					if (t.contains(num)) {
						isKnow = true;
						break;
					}
				}
				if (isKnow) {
					int oriSize = t.size();
					t.addAll(party[i]);
					if (oriSize < t.size()) changed = true;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < m; i++) {
			boolean isKnow = false;
			for (int num : party[i]) {
				if (t.contains(num)) {
					isKnow = true;
					break;
				}
			}
			if (!isKnow) answer++;
		}
		System.out.println(answer);
	}

}
