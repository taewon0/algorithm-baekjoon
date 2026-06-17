import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String conv = getKNum(n, k);
        long num = 0;
        for (int i = 0; i < conv.length(); i++) {
            char cur = conv.charAt(i);
            if (cur == '0') {
                answer += isPrime(num);
                num = 0;
            }
            else {
                num *= 10;
                num += cur - '0';
            }
        }
        answer += isPrime(num);
        return answer;
    }
    
    String getKNum(int n, int k) {
        int i = 1;
        StringBuilder answer = new StringBuilder();
        while (n > 0) {
            answer.append(n % k);
            n /= k;
            i *= 10;
        }
        return answer.reverse().toString();
    }
    
    int isPrime(long num) {
        if (num == 0 || num == 1) return 0;
        for (int i = 2; i < (int)Math.sqrt(num) + 1; i++) {
            if (num % i == 0) return 0;
        }
        return 1;
    }
    
}