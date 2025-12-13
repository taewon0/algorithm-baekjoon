public class Main {

	public static void main(String[] args) {
		/*
		 * n, d(n)에서 d(n) = n + n의 각 자리 숫자이므로
		 * 무조건 n < d(n)이 성립한다.
		 * 1부터 시작해서 자신의 셀프 넘버 여부를 확인해서 답 저장 후
		 * 자신이 만들 수 있는 d(n)의 셀프넘버 여부를 false로 바꾼다.
		 */
		boolean [] notSelf = new boolean[10001];
		StringBuilder sb = new StringBuilder();
		int d, num;
		for (int i = 1; i <= 10000; i++) {
			if (!notSelf[i]) sb.append(i).append("\n");
			d = i;
			num = i;
			while (num > 0) {
				d += num % 10;
				num /= 10;
			}
			if (d <= 10000) notSelf[d] = true;
		}
		System.out.println(sb);
	}

}
