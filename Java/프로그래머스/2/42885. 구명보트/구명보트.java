import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        while(i <= j) {
            if (i < j && people[i] + people[j] <= limit) {
                i += 1;
                j -= 1;
            }
            else {
                j -= 1;
            }
            answer++;
        }
        return answer;
    }
}