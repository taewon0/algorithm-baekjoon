import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clsMap = new HashMap<>();
        for(String[] cl : clothes){
            if (!clsMap.containsKey(cl[1])) clsMap.put(cl[1], 1);
            else clsMap.put(cl[1], clsMap.get(cl[1]) + 1);
        }
        for(String cl : clsMap.keySet()){
            answer *= clsMap.get(cl) + 1;
        }
        return answer - 1;
    }
}