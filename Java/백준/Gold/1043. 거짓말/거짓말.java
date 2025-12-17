import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) parent[b] = a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) parent[i] = i;
		
		st = new StringTokenizer(br.readLine());
		int tn = Integer.parseInt(st.nextToken());
		int[] t = new int[tn];
		for (int i = 0; i < tn; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		//진실 아는 사람들 union
		for (int i = 1; i < tn; i++) {
			union(t[0], t[i]);
		}
		ArrayList<int[]> party = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int pn = Integer.parseInt(st.nextToken());
			int[] arr = new int[pn];
			for (int j = 0; j < pn; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			party.add(arr);
			//파티원들 union
			for (int j = 1; j < pn; j++) {
				union(arr[0], arr[j]);
			}
		}
		if (tn ==  0) {
			System.out.println(m);
			return;
		}
		int answer = 0;
		int troot = find(t[0]);
		for (int[] par : party) {
			boolean isKnow = false;
			for (int p : par) {
				if (find(p) == troot) {
					isKnow = true;
					break;
				}
			}
			if (!isKnow) answer++;
		}
		System.out.println(answer);
	}

}
