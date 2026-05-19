import java.util.*;
class Solution {
    public int solution(int[] elements) {
        
        HashSet<Integer> set = new HashSet<>();
        int l = elements.length;
        
        int num;
        for (int i = 0; i < l; i++) {
            num = 0;
            for (int j = 0; j < l; j++) {
                num += elements[(i + j) % l];
                set.add(num);
            }
        }
        
        return set.size();
    }
}