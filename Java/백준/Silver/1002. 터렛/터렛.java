import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t-->0) {
			/*
			 * 두 사람의 원이 겹치면 2, 접하면 1 아니면 1이고 완전히 겹치면 무한대
			 * 원의 중심과 반지름 길이로 판별 가능
			 */
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			if (x1 == x2 && y1 == y2 && r1 == r2) {
				sb.append(-1).append("\n");
				continue;
			}
			if (x1 == x2 && y1 == y2 && r1 != r2) {
				sb.append(0).append("\n");
				continue;
			}
			int xdiffPow = (x1 - x2) * (x1 - x2);
			int ydiffPow = (y1 - y2) * (y1 - y2);
			double distance = Math.sqrt(xdiffPow + ydiffPow);
			if (distance < r1 + r2) {
				/*
				 * 두 경우가 더 있음
				 * distance가 더 작지만 큰원 안에 작은원이 포함되면 -> 한점에서 접하거나 아예 안접하는 경우
				 * 
				 */
				if (r1 > r2) {
					if (distance + r2 == r1) {
						sb.append(1).append("\n");
						continue;
					}
					else if (distance + r2 < r1) {
						sb.append(0).append("\n");
						continue;
					}
				}
				if (r1 < r2) {
					if (distance + r1 == r2) {
						sb.append(1).append("\n");
						continue;
					}
					else if (distance + r1 < r2) {
						sb.append(0).append("\n");
						continue;
					}
				}
				
				sb.append(2).append("\n");
				continue;
			}
			else if (distance > r1 + r2) {
				sb.append(0).append("\n");
				continue;
			}
			else {
				sb.append(1).append("\n");
				continue;
			}
		}
		System.out.println(sb);
	}

}
