import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int n, count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bt(1,1, 1,2);
		System.out.println(count);
	}

	private static void bt(int si, int sj, int ei, int ej) {
		//끝부분이 n,n 도달 시 count 증가 후 종료
		if (ei == n && ej == n) {
			count++;
			return;
		}
		/* si, sj, ei, ej를 보고 현재 상태가 뭔지 알아낸 후
		 * 다음 움직일 수 있는 상태로 이동
		 * 
		 * 각 상태를 가로0, 세로1, 대각선2 라고 하자
		 * 각 상태마다 이동 가능한 다음 상태를 구해 거기로 bt 이동
		*/
		int state = getState(si, sj, ei, ej);
		if (state == 0) {
			moveRight(ei, ej);
			moveDia(ei, ej);
		}
		else if ( state == 1) {
			moveDown(ei, ej);
			moveDia(ei, ej);
		}
		else {
			moveRight(ei, ej);
			moveDown(ei, ej);
			moveDia(ei, ej);
		}
	}

	private static int getState(int si, int sj, int ei, int ej) {
		if (si == ei && ej == sj + 1) return 0;
		if (sj == ej && ei == si + 1) return 1;
		return 2;
	}
	
	private static void moveRight(int ei, int ej) {
		if (ej + 1 <= n && map[ei][ej+1] != 1) {
			bt(ei, ej, ei, ej+1);
		}
	}
	
	private static void moveDown(int ei, int ej) {
		if (ei + 1 <= n && map[ei+1][ej] != 1) {
			bt(ei, ej, ei + 1, ej);
		}
	}
	
	private static void moveDia(int ei, int ej) {
		if (ei + 1 <= n && ej + 1 <= n && map[ei+1][ej+1] != 1 && map[ei][ej+1] != 1 && map[ei+1][ej] != 1) {
			bt(ei, ej, ei + 1, ej + 1);
		}
	}

}
