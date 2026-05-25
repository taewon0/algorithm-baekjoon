import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0], gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //현재 최소공배수와 arr[i]의 최대공약수를 구한다.
            int a = arr[i];
            int b = lcm;
            while (b != 0) {
                int r = a % b;
                a = b;
                b = r;
            }
            //현재 최소공배수 * arr[i] / 최대공약수 = 새로운 최소공배수
            lcm = lcm * arr[i] / a;
        }
        return lcm;
    }
}