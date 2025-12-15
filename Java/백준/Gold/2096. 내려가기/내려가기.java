import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][3];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		getMax();
		getMin();
	}
	
	static void getMax() {
		int[][] mxd = new int[n+1][3];
		mxd[1][0] = arr[1][0];
		mxd[1][1] = arr[1][1];
		mxd[1][2] = arr[1][2];
		for (int i = 2; i <= n; i++) {
			mxd[i][0] = Math.max(mxd[i-1][0], mxd[i-1][1]) + arr[i][0];
			mxd[i][1] = Math.max(Math.max(mxd[i-1][0], mxd[i-1][1]), mxd[i-1][2]) + arr[i][1];
			mxd[i][2] = Math.max(mxd[i-1][1], mxd[i-1][2]) + arr[i][2];
		}
		System.out.print(Math.max(Math.max(mxd[n][0], mxd[n][1]), mxd[n][2]) + " ");
	}
	
	static void getMin() {
		int[][] mnd = new int[n+1][3];
		mnd[1][0] = arr[1][0];
		mnd[1][1] = arr[1][1];
		mnd[1][2] = arr[1][2];
		for (int i = 2; i <= n; i++) {
			mnd[i][0] = Math.min(mnd[i-1][0], mnd[i-1][1]) + arr[i][0];
			mnd[i][1] = Math.min(Math.min(mnd[i-1][0], mnd[i-1][1]), mnd[i-1][2]) + arr[i][1];
			mnd[i][2] = Math.min(mnd[i-1][1], mnd[i-1][2]) + arr[i][2];
		}
		System.out.println(Math.min(Math.min(mnd[n][0], mnd[n][1]), mnd[n][2]));
	}

}
