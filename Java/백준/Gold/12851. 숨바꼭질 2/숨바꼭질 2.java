import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        if (n >= k) {
        	System.out.println(n - k);
        	System.out.println(1);
        	return;
        }
        
        int[] dist = new int[100002];
        int[] cnt = new int[100002];
        Arrays.fill(dist, -1);
        dist[n] = 0;
        cnt[n] = 1;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addFirst(n);
        while (!q.isEmpty()) {
            int cur = q.removeLast();
            for (int nxt : new int[]{cur - 1, cur + 1, 2 * cur}) {
                if (nxt < 0 || nxt > 100000) continue;
                //처음 방문이면 시간 +1, 횟수는 그대로, 큐에 추가
                if (dist[nxt] == -1) {
                	dist[nxt] = dist[cur] + 1;
                	cnt[nxt] = cnt[cur];
                	q.addFirst(nxt);
                }
                //이미 방문한 곳인데 최단 시간과 같으면 횟수 증가
                //횟수는 cur 까지 갈 수 있는 최단 방법 개수 + nxt 까지 갈 수 있는 최단 방법 개수
                else if (dist[nxt] == dist[cur] + 1) {
                	cnt[nxt] += cnt[cur];
                }
            }
        }

        System.out.println(dist[k]);
        System.out.println(cnt[k]);
	}

}
