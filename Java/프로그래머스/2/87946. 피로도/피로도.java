class Solution {
    
    int answer;
    boolean[] visited;
    int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        this.answer = 0;
        this.visited = new boolean[dungeons.length];
        this.dungeons = dungeons;
        
        int l = dungeons.length;
        bt(0, k);
        
        return answer;
    }
    
    void bt(int d, int k) {
        if (d == dungeons.length) {
            answer = d;
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (answer == dungeons.length) return;
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                bt(d + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }
        
        //피로도가 모든 던전 방문 이전에 다 닳았을 경우
        answer = Math.max(answer, d);
    }
    
}