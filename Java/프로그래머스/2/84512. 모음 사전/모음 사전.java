import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        HashMap<Character, int[]> preset = new HashMap<>();
        preset.put('A', new int[] {1, 1, 1, 1, 1});
        
        //1+5+25+125+625=781
        //1+5+25+125=156
        //1+5+25=31
        //1+5=6
        //1
        preset.put('E', new int[] {782, 157, 32, 7, 2});
        
        //781+781=1562
        //156+156=312
        //31+31=62
        //6+6=12
        preset.put('I', new int[] {1563, 313, 63, 13, 3});
        
        //781*3
        //156*3
        //31*3
        //6*3
        //1*3
        preset.put('O', new int[] {2344, 469, 94, 19, 4});
        
        //781*4
        //156*4
        //31*4
        //6*4
        //1*4
        preset.put('U', new int[] {3125, 625, 125, 25, 5});
        for (int i = 0; i < word.length(); i++) {
            answer += preset.get(word.charAt(i))[i];
        }
        return answer;
    }
}