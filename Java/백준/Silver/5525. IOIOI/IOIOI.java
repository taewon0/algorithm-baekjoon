import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		//n을 가지고 패턴 문자열 구성
		StringBuilder pattern = new StringBuilder();
		pattern.append("I");
		for (int i = 0; i < n; i++) {
			pattern.append("OI");
		}
		//해시 준비
		long patHash = 0, sHash = 0, power = 1;
		long base = 31, mod = 1_000_000_007L;
		//패턴 길이를 pl이라고 할 때 패턴과 s의 앞 pl만큼 부분문자열의 해시 구하기
		int pl = pattern.length();
		for (int i = 0; i < pl; i++) {
			patHash = (patHash * base + pattern.charAt(i)) % mod;
			sHash = (sHash * base + s.charAt(i)) % mod;
			//맨 앞의 가중치
			if (i < pl - 1) power = (power * base) % mod;
		}
		//s를 끝까지 돌며 해시를 이용해 패턴 등장 횟수 카운트
		int cnt = 0;
		if (patHash == sHash) cnt++;
		for (int i = pl; i < m; i++) {
			sHash = (sHash - (s.charAt(i - pl) * power)) % mod;
			if (sHash < 0) sHash += mod;
			sHash = (sHash * base + (s.charAt(i))) % mod;
			if (patHash == sHash) cnt++;
		}
		System.out.println(cnt);
	}

}
