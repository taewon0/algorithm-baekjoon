import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {

	static char[][] map = new char[12][6];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}
		boolean isChanged = true;
		boolean [][] visited;
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		ArrayDeque<int[]> q = new ArrayDeque<>();
		ArrayList<int[]> list = new ArrayList<>();
		int cnt = 0;
		while (isChanged) {
			isChanged = false;
			visited = new boolean[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] == '.' || visited[i][j]) continue;
					//bfs 진행
					q.clear();
					list.clear();
					q.addFirst(new int[] {i, j});
					list.add(new int[] {i, j});
					visited[i][j] = true;
					char c = map[i][j];
					while (!q.isEmpty()) {
						int[] cur = q.removeLast();
						for (int dir = 0; dir < 4; dir++) {
							int ni = cur[0] + di[dir];
							int nj = cur[1] + dj[dir];
							if (ni < 0 || ni >= 12 || nj < 0 || nj >= 6) continue;
							if (visited[ni][nj] || map[ni][nj] == '.' || map[ni][nj] != c) continue;
							int[] next = {ni, nj};
							q.addFirst(next);
							list.add(next);
							visited[ni][nj] = true;
						}
					}
					//bfs 결과, list 크기가 4 이상이면 changed true 및 파괴
					if (list.size() >= 4) {
						if (!isChanged) isChanged = true;
						for (int[] cur : list) {
							map[cur[0]][cur[1]] = '.';
						}
					}
				}
			}
			//현재 상태에서 모든 파괴가 끝난 후 아래로 내리기, 카운트 증가
			if (isChanged) {
				cnt++;
				for (int i = 0; i < 6; i++) {
					//맨 아래 index 저장
					int top = 12;
					for (int j = 11; j >= 0; j--) {
						if (map[j][i] != '.') {
							top--;
							if (top != j) {
								map[top][i] = map[j][i];
								map[j][i] = '.';
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
