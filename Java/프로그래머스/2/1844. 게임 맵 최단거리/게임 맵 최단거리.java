import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,0};
        
        int n = maps.length;
        int m = maps[0].length;
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        q.addFirst(new int[] {0,0});
        
        while (!q.isEmpty()) {
            int[] cur = q.removeLast();
            int curDis = maps[cur[0]][cur[1]];
            
            for (int dir = 0; dir < 4; dir++) {
                int ni = cur[0] + di[dir];
                int nj = cur[1] + dj[dir];
                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;
                if (maps[ni][nj] != 1) continue;
                maps[ni][nj] = curDis + 1;
                q.addFirst(new int[] {ni, nj});
            }
        }
        if (maps[n-1][m-1] == 1) return -1;
        return maps[n-1][m-1];
    }
}