import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static long x = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long answer = 0;
        while (m-->0) {
        	st = new StringTokenizer(br.readLine());
        	long n = Long.parseLong(st.nextToken());
        	long s = Long.parseLong(st.nextToken());
        	answer = (answer + calc(n, s)) % x;
        }
        System.out.println(answer);
	}

	private static long calc(long n, long s) {
		//n과 s의 최대공약수로 각각 나눠서 기약 분수 만들기
		long g = gcd(n, s);
		n /= g; s /= g;
		//n에 대한 역원 찾기
		long rn = modPow(n, x - 2, x);
		//rn X s 를 x로 나눈 나머지 return 
		return rn * s % x;
	}

	private static long gcd(long a, long b) {
		long tmp;
		while (b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
	
	private static long modPow(long base, long exp, long mod) {
		if (exp == 0) return 1;
		long half = modPow(base, exp / 2, mod);
		long result = (half * half) % mod;
		if (exp % 2 == 1) result = (result * (base % mod)) % mod;
		return result;
	}

}
