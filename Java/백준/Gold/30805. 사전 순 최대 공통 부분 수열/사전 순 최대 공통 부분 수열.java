import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());
		/*
		 * n이 100일때 부분수열의 개수는?
		 * 매우 많음
		 * 공통 부분 수열을 모두 구해야될까? 
		 * 두 수열에 공통으로 있는 가장 큰 수를 찾을 수는 있다. 없으면 K는 0
		 * 그 수 이후에 또다시 다음으로 가장 큰 수를 찾는다. 반복
		 */
		StringBuilder sb = new StringBuilder();
		int commonMax = 0, cmIdxA = 0, cmIdxB = 0, count = 0, startA = 0, startB = 0;
		while (startA < n && startB < m) {
			commonMax = 0;
			for (int i = startA; i < n; i++) {
				for (int j = startB; j < m; j++) {
					if (a[i] == b[j] && a[i] > commonMax) {
						commonMax = a[i];
						cmIdxA = i; cmIdxB = j;
					}
				}
			}
			if (commonMax == 0) {
				sb.insert(0, count + "\n");
				System.out.println(sb);
				return;
			}
			sb.append(commonMax).append(" ");
			startA = cmIdxA + 1; startB = cmIdxB + 1; count++;
		}
		sb.insert(0, count + "\n");
		System.out.println(sb);
	}

}
