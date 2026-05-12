import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int dTime = fees[0];
        int dFee = fees[1];
        int uTime = fees[2];
        int uFee = fees[3];
        TreeMap<String, Integer> result = new TreeMap<>();
        Map<String, Integer> inTime = new HashMap<>();
        Set<String> yet = new HashSet<>();
        StringTokenizer st;
        for (String str : records) {
            st = new StringTokenizer(str);
            String time = st.nextToken();
            String carNum = st.nextToken();
            String io = st.nextToken();
            String[] times = time.split(":");
            int minute = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            if (io.equals("IN")) {
                inTime.put(carNum, minute);
                yet.add(carNum);
            } else {
                int cur = result.getOrDefault(carNum, 0);
                result.put(carNum, cur + minute - inTime.get(carNum));
                yet.remove(carNum);
                inTime.remove(carNum);
            }
        }
        int last = 23 * 60 + 59;
        for (String carNum : yet) {
            int cur = result.getOrDefault(carNum, 0);
            result.put(carNum, cur + last - inTime.get(carNum));
        }
        int[] answer = new int[result.size()];
        int idx = 0;
        for (int value : result.values()) {
            int total = dFee;
            if (value > dTime) {
                total += (int)(Math.ceil((double) (value - dTime) / uTime)) * uFee;
            }
            answer[idx++] = total;
        }
        return answer;
    }
}