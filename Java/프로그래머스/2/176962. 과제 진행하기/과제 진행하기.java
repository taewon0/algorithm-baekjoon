import java.util.*;

class Solution {
    
    static class Plan {
        String name;
        int start;
        int left;
        
        public Plan(String name, int start, int left) {
            this.name = name;
            this.start = start;
            this.left = left;
        }
    }
    
    public String[] solution(String[][] plans) {
        
        Plan[] planList = new Plan[plans.length];
        for (int i = 0; i < plans.length; i++) {
            planList[i] = new Plan(plans[i][0], timeToInt(plans[i][1]), Integer.parseInt(plans[i][2]));
        }
        
        Arrays.sort(planList, (a, b) -> {
            return Integer.compare(a.start, b.start);
        });
        
        ArrayDeque<Plan> stop = new ArrayDeque<>();
        
        ArrayList<String> answerList = new ArrayList<>();
        
        int idx = 1;
        Plan cur = planList[0];
        for (int i = planList[0].start+1; i < 150000; i++) {
            
            if (answerList.size() == planList.length) break;
            
            cur.left--;
            
            // 진행 중이던 과제가 끝났나 확인
            if (cur.left == 0) {
                //끝났으면 answerList에 추가하고, 새로운 과제 있으면 하고, 없으면 멈췄던 과제하고, 없으면 걍 넘어감
                answerList.add(cur.name);
                if (idx < planList.length && planList[idx].start == i) cur = planList[idx++];
                else if (!stop.isEmpty()) cur = stop.removeFirst();
            }
            else if (idx < planList.length && planList[idx].start == i) {
                //새로운 과제가 있으면 진행 중이던 작업을 멈추고 새 과제 진행
                stop.addFirst(cur);
                cur = planList[idx++];
            }
        }
        
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    static int timeToInt(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        return hour * 60 + min;
    }
    
}