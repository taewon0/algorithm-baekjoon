import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static int[][] map = new int[9][9];
	static ArrayList<int[]> empty;
	
	static boolean bt(int d) {
		if (d == empty.size()) {
			return true;
		}
		int i = empty.get(d)[0];
		int j = empty.get(d)[1];
		
		for (int num = 1; num <= 9; num++) {
			if (canPlace(i, j, num)) {
				map[i][j] = num;
				if (bt(d + 1)) return true;
				map[i][j] = 0;
			}
		}
		return false;
	}
	
	private static boolean canPlace(int i, int j, int num) {
		//가로, 세로
		for (int k = 0; k < 9; k++) {
			if (map[i][k] == num) return false;
			if (map[k][j] == num) return false;
		}
		//3x3 박스
		//i, j가 속한 박스가 어딜까?
		/*
		 * ex) 1,2
		 * 1/3 ==> 0  0부터 2까지 돌림
		 * 2/3 ==> 0  0부터 2까지 돌림
		 * 
		 * 4,2
		 * 4/3 ==> 1 3부터 5까지 돌림
		 * 2/3 ==> 0 0부터 2까지 돌림
		 */
		int ir = i/3*3, jr = j/3*3;
		for (int k = ir; k < ir + 3; k++) {
			for (int l = jr; l < jr + 3; l++) {
				if (map[k][l] == num) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		empty = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = line.charAt(j) - '0';
				if (map[i][j] == 0) {
					empty.add(new int[] {i, j});
				}
			}
		}
		/*
		 * 0인 칸을 모아서
		 * 한칸씩 후보 리스트를 찾는다
		 * 후보 하나씩 정하고 다음 0인 칸 똑같이 반복
		 * 중간에 후보가 없는 경우, 다시 돌아감->백트래킹
		 * 
		 * empty에 빈칸을 모두 모았음.
		 * 이제 빈칸을 앞에서부터 하나씩 돌면서 1부터 이칸에 들어갈 수 있는 후보를 찾자.
		 */
		bt(0);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
