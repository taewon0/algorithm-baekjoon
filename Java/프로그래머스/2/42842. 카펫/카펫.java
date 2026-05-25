import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int yw, yh;
        //노란 부분의 높이는 1부터 루트 yellow 까지만 가능
        for (int i = 1; i < (int) Math.pow(yellow, 0.5) + 1; i++) {
            if (yellow % i == 0) {
                yh = i;
                yw = yellow / i;
                if (yw * 2 + (yh + 2) * 2 == brown) {
                    return new int[] {yw + 2, yh + 2};
                }
            } 
        }
        return null;
    }
}