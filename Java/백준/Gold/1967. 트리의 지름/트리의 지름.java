import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<int[]>[] graph;
	static int mxNode = 0, mx = 0, sum = 0;
	static boolean [] visited;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[p].add(new int[] {c, w});
			graph[c].add(new int[] {p, w});
		}
		/*
		 * 무조건 leaf node에서 leaf node로 가야한다.
		 * 
		 * 모든 leaf node에서 다른 모든 leaf node 까지 거리를 구한다?
		 * 너무 오래 걸림
		 * 
		 * 어떤 node에서 가장 멀리 있는 node를 구할 수 있나?
		 * 트리에 지름이 있다면, 
		 * 어떤 node에 대해 가장 멀리있는 node는 무조건 트리의 지름을 이루는 두 node 중 하나임
		 * 아니라면 그 둘의 거리가 트리의 지름보다 길다? 모순 발생
		 * 
		 * 즉 아무 node를 잡고 가장 멀리있는 node 구하기 -> dfs?
		 * 구한 node로부터 가장 멀리있는 node 구하기 -> 이 둘의 거리가 정답
		 */
		//root node 에서부터 dfs 시작. 가장 먼 노드 번호 구하기
		visited = new boolean[n+1];
		dfs(1); //이 메소드 결과로 가장 먼 노드 번호 mxNode 구해짐
		visited = new boolean[n+1];
		mx = 0; sum = 0;
		if (mxNode != 0) dfs(mxNode); //이 메소드 결과로 mx 트리의 지름의 길이 구해짐.
		System.out.println(mx);
	}

	private static void dfs(int u) {
		visited[u] = true;
		for (int[] e : graph[u]) {
			if (!visited[e[0]]) {
				sum += e[1];
				if (sum > mx) {
					mx = sum;
					mxNode = e[0];
				}
				dfs(e[0]);
				sum -= e[1];
			}
		}
	}

}
