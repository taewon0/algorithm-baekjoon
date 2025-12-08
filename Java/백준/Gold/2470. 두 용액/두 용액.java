import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int left = 0, right = n - 1;
		int answerL = 0, answerR = n - 1;
		int mn = Integer.MAX_VALUE;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (Math.abs(sum - 0) < mn) {
				mn = Math.abs(sum - 0);
				answerL = left;
				answerR = right;
			}
			if (sum < 0) {
				left++;
			}
			else right--;
		}
		System.out.printf("%d %d", arr[answerL], arr[answerR]);
	}

}
