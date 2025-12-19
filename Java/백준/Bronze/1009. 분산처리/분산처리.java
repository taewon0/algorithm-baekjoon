import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] num = {
				{10,10,10,10},
				{1,1,1,1},
				{6,2,4,8},
				{1,3,9,7},
				{6,4,6,4},
				{5,5,5,5},
				{6,6,6,6},
				{1,7,9,3},
				{6,8,4,2},
				{1,9,1,9}
			};
		StringBuilder sb = new StringBuilder();
		while (t-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			/*
			 * a^b의 1의 자리가 무엇일까?
			 * a의 일의자리를 a라고하면
			 * a=1  항상 1
			 * a=2  2 4 8 6 반복
			 * a=3  3 9 7 1 반복
			 * a=4  4 6 반복
			 * a=5  항상 5
			 * a=6  항상 6
			 * a=7  7 9 3 1 반복
			 * a=8  8 4 2 6 반복
			 * a=9  9 1 반복
			 * a=10 항상 0
			 */
			sb.append(num[a%10][b%4]).append("\n");
		}
		System.out.println(sb);
	}
	
}
